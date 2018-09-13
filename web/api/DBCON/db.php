<?php
// MySQLi class to handle the DB interaction
// This class is initiated only once at the start of index.php
// The type of connection can be changed at any time after initialization to give more permissions when needed
require_once ROOT_FOLDER.'\modules\lib.php';
// TODO implement DB query methods

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT); // Set MySQLi to throw exceptions otherwise it pops as Warnings which cannot be handled

class DB {
  private $host = 'localhost';
  private $DBname = 'booky';
  private $mysqli;
  private $user = 'user'; // Dummy user, change with the actual user on release
  private $pass = 'pass'; // Dummy pass, change with the actual pass on release
  private $isOpen = FALSE;

  // Open a connection to the DB with the.
  public function Open() {
    if ($this->isOpen) {
      return TRUE;
    }

    // Establish the connection
    try {
      $this->mysqli = new mysqli($this->host, $this->user, $this->pass, $this->DBname);
    } catch (mysqli_sql_exception $e) {
      UpdateError(7, $e); // ERROR-7
    }

    // Check if the connection was successful
    if ($this->mysqli->connect_errno) {
      UpdateError(5); // ERROR-5
    }

    // Check if the server is alive
    if (!$this->mysqli->ping()) {
      UpdateError(6); // ERROR-6
    }

    // Set the charset to UTF-8
    if (!$this->mysqli->set_charset("utf8")) {
      UpdateError(10); // ERROR-10
    }

    // Connection successful
    $this->isOpen = TRUE;
    return TRUE;
  }
  // Close the connection to the DB and clear all error messages
  public function Close() {
    if ($this->mysqli) {
      $this->mysqli->close();
      $this->isOpen = FALSE;
    }
  }
  // Return the mysqli object (Should not be used)
  // Instead use the interface provided by the class to make queries
  public static function Instance() {
    static $instance = null;
    if ($instance === null) {
      $instance = new DB();
      $instance->Open();
    }
    return $instance;
  }
  // Private constructor for the singleton
  private function __construct() { }
  function __destruct() {
    $this->Close();
  }

  // Execute the string $query as an SQL query
  public function ExecuteQuery($sql) {
    // If no connection to the DB is established return false
    if (!$this->isOpen) {
      return FALSE;
    }
    // Execute the query and return the result
    try {
      if ($result = $this->mysqli->query($sql)) { // Success
        $this->LogQuery($sql);
        return $result;
      }
    } catch (Exception $e) { // Failure
        $this->LogQuery($sql, 0);
        UpdateError($e->getCode(), $e);
    }

    // On failure return false
    return 0;
  }

  // Log Queries
  private function LogQuery($sql, $success = 1) {
    $this->Open();
    try {
      if (isset($GLOBALS['old_data'])) {
        $old_data = $this->mysqli->escape_string($GLOBALS['old_data']);
      } else {
        $old_data = "-";
      }
      $ip = $this->mysqli->escape_string(GetClientIp());
      $user_id = $this->mysqli->escape_string(GetUserId());
      $sql = $this->mysqli->escape_string($sql);
      $success = ($success ? 1 : 0);
      $log = "INSERT INTO query_log (query, old_data, ip, user_id, success) VALUES ('{$sql}', '{$old_data}', '{$ip}', '{$user_id}', '{$success}')";
      $this->mysqli->query($log);
    } catch (Exception $e) {
      // Ignore
    }
  }

  // Log errors
  public function LogError($code, $error = "") {
    $this->Open();
    try {
      $error = $this->mysqli->escape_string(str_replace('\\u0000', '', json_encode((array)$error, JSON_UNESCAPED_UNICODE)));
      $ip = $this->mysqli->escape_string(GetClientIp());
      $user_id = $this->mysqli->escape_string(GetUserId());
      $log = "INSERT INTO error_log (code, error, ip, user_id) VALUES ('{$code}', '{$error}', '{$ip}', '{$user_id}')";
      $this->mysqli->query($log);
    } catch (Exception $e) {
      // Ignore
    }
  }

  // Returns the column names of $tableName or an empty array if some error occurs
  private function GetTableColumns($tableName) {
    $result = $this->ExecuteQuery("DESCRIBE " . $this->mysqli->escape_string($tableName));

    while ($row = $result->fetch_assoc()) {
      $columns[] = $row['Field'];
    }

    return $columns;
  }

  // Select
  public function Select($TableName, $KeyList, $WhereKeyValueList) {
    $allColumnNames = $this->GetTableColumns($TableName);

    $columns = ""; // Columns e.g 'col1', 'col2' ... OR *
    if (is_string($KeyList)) {
      if ($KeyList === "*") {
        $columns = "*";
      }
      else {
        UpdateError(14); // ERROR-14
      }
    }
    else {
      // Check if the keys from $keys are valid keys for the $tableName
      $listIsEmpty = TRUE;
      foreach ($KeyList as $key) {
        $listIsEmpty = FALSE;
        if (!in_array($key, $allColumnNames, TRUE)) {
          UpdateError(9); // ERROR-9
        }
      }

      // Check if the list has any valid items
      if ($listIsEmpty) {
        UpdateError(11); // ERROR-11
      }

      foreach ($KeyList as $key) {
        $columns .= $key . ',';
      }
      $columns = rtrim($columns, ',');
    }

    // Update where
    $where = "";
    foreach ($WhereKeyValueList as $key => $value) {
      $where .= $key . ' = ';
      if (is_string($value)) {
        $where .= '"' . $this->mysqli->escape_string($value) . '"';
      }
      else {
        $where .= $value;
      }
      $where .= ' AND ';
    }
    $where = preg_replace('/ AND $/', '', $where);
    $sql = "SELECT {$columns} FROM {$TableName} WHERE {$where}";
    // Check if the sql was successful
    if ($result = $this->ExecuteQuery($sql)) {
      $returnArr = array();
      while ($row = $result->fetch_assoc()) {
        $returnArr[] = $row;
      }
      return $returnArr;
    }
    else {
      return 0;
    }
  }
  // Insert
  public function Insert($TableName, $KeyValueList) {
    $allColumnNames = $this->GetTableColumns($TableName);
    // Check if the keys from $keys are valid keys for the $tableName
    $listIsEmpty = TRUE;
    foreach ($KeyValueList as $key => $value) {
      $listIsEmpty = FALSE;
      if (!in_array($key, $allColumnNames, TRUE)) {
        UpdateError(9); // ERROR-9
      }
    }

    // Check if the list has any valid items
    if ($listIsEmpty) {
      UpdateError(11); // ERROR-11
    }

    $columns = ""; // Columns e.g 'col1', 'col2' ...
    $values = ""; // Values e.g 'val1', 'val2' ...
    foreach ($KeyValueList as $key => $value) {
      $columns .= $key . ',';
      //$values .= '\'' . $this->mysqli->escape_string($value) . '\',';
      if (is_string($value)) {
        $values .= '"' . $this->mysqli->escape_string($value) . '"';
      }
      else {
        $values .= $value;
      }
      $values .= ',';
    }
    $columns = rtrim($columns, ',');
    $values = rtrim($values, ',');

    $sql = "INSERT INTO {$TableName} ({$columns}) VALUES ({$values})";
    // Check if the sql was successful
    if ($this->ExecuteQuery($sql)) {
      return 1;
    }
    else {
      return 0;
    }
  }
  // Update
  public function Update($TableName, $KeyValueList, $WhereKeyValueList) {
    $allColumnNames = $this->GetTableColumns($TableName);
    // Check if the keys from $keys are valid keys for the $tableName
    $listIsEmpty = TRUE;
    foreach ($KeyValueList as $key => $value) {
      $listIsEmpty = FALSE;
      if (!in_array($key, $allColumnNames, TRUE)) {
        UpdateError(9); // ERROR-9
      }
    }

    // Check if the list has any valid items
    if ($listIsEmpty) {
      UpdateError(11); // ERROR-11
    }

    // Update values
    $update = "";
    foreach ($KeyValueList as $key => $value) {
      $update .= $key . ' = ';
      if (is_string($value)) {
        $update .= '"' . $this->mysqli->escape_string($value) . '"';
      }
      else {
        $update .= $value;
      }
      $update .= ',';
    }
    $update = rtrim($update, ',');

    // Update where
    $where = "";
    foreach ($WhereKeyValueList as $key => $value) {
      $where .= $key . ' = ';
      if (is_string($value)) {
        $where .= '"' . $this->mysqli->escape_string($value) . '"';
      }
      else {
        $where .= $value;
      }
      $where .= ' AND ';
    }
    $where = preg_replace('/ AND $/', '', $where);

    // TODO after SELECT - backup data

    $sql = "UPDATE {$TableName} SET {$update} WHERE {$where}";

    // Check if the sql was successful
    if ($this->ExecuteQuery($sql)) {
      return 1;
    }
    else {
      return 0;
    }
  }
  // Delete
  public function Delete($TableName, $WhereKeyValueList) {
    // WHERE
    $where = "";
    foreach ($WhereKeyValueList as $key => $value) {
      $where .= $key . ' = ';
      if (is_string($value)) {
        $where .= '"' . $this->mysqli->escape_string($value) . '"';
      }
      else {
        $where .= $value;
      }
      $where .= ' AND ';
    }
    $where = preg_replace('/ AND $/', '', $where);

    // TODO after SELECT - backup data

    $sql = "DELETE FROM {$TableName} WHERE {$where}";

    // Check if the sql was successful
    if ($this->ExecuteQuery($sql)) {
      return 1;
    }
    else {
      return 0;
    }
  }
  // Get the maximum field of a table (useful for finding the last index)
  public function GetMax($tableName, $field, $WhereKeyValueList = null) {
    $tableName = $this->mysqli->escape_string($tableName);
    if (is_string($field)) {
      $field = $this->mysqli->escape_string($field);
    }

    // Update where
    $sql = "";
    if ($WhereKeyValueList !== null) {
      $where = "";
      foreach ($WhereKeyValueList as $key => $value) {
        $where .= $key . ' = ';
        if (is_string($value)) {
          $where .= '"' . $this->mysqli->escape_string($value) . '"';
        }
        else {
          $where .= $value;
        }
        $where .= ' AND ';
      }
      $where = preg_replace('/ AND $/', '', $where);

      $sql = "SELECT * FROM {$tableName} WHERE {$where} ORDER BY {$field} DESC LIMIT 1";
    }
    else {
      $sql = "SELECT * FROM {$tableName} ORDER BY {$field} DESC LIMIT 1";
    }

    $query = $this->ExecuteQuery($sql);
    $dbRow = $query->fetch_assoc();
    return $dbRow[$field];
  }

  // Escape string
  public function EscapeString($str) {
    return $this->mysqli->escape_string($str);
  }
}
?>
