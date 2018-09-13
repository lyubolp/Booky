<?php
/**
 * Snippet for adding new translation in table `translation` of the DB.
 *
 * @category  Modules
 * @package   DB-Additions
 * @author    Luchev <luchevz@gmail.com>
 * @version   1.0
 * @since     File available since Release 0.1
 */

require_once ROOT_FOLDER.'\DBCON\db.php'; // DB class

/**
 * Add a new row to the table `translation`
 *
 * @return    TRUE|FALSE on success|failure
*/
function AddTranslation($row) {
  $db = DB::Instance();
  $success = $db->Insert('translation', $row);
  return $success;
}

function AddCountry($row) {
  $row['type_id'] = 2;
  $db = DB::Instance();
  $where['type_id'] = $row['type_id'];
  $lastId = $db->GetMax('translation', 'item_id', $where);
  $row['item_id'] = $lastId;
  $row['item_id']++;

  $success = $db->Insert('translation', $row);
  $GLOBALS['response']['s'] = $success;
  return $success;
}

function AddLanguage($row) {
  $row['type_id'] = 3;
  $db = DB::Instance();
  $where['type_id'] = $row['type_id'];
  $lastId = $db->GetMax('translation', 'item_id', $where);
  $row['item_id'] = $lastId;
  $row['item_id']++;

  $success = $db->Insert('translation', $row);
  $GLOBALS['response']['s'] = $success;
  return $success;
}

function AddTag($row) {
  $row['type_id'] = 6;
  $db = DB::Instance();
  $where['type_id'] = $row['type_id'];
  $lastId = $db->GetMax('translation', 'item_id', $where);
  $row['item_id'] = $lastId;
  $row['item_id']++;

  $success = $db->Insert('translation', $row);
  $GLOBALS['response']['s'] = $success;
  return $success;
}

function AddSeries($row) {
  $row['type_id'] = 8;
  $db = DB::Instance();
  $where['type_id'] = $row['type_id'];
  $lastId = $db->GetMax('translation', 'item_id', $where);
  $row['item_id'] = $lastId;
  $row['item_id']++;

  $success = $db->Insert('translation', $row);
  $GLOBALS['response']['s'] = $success;
  return $success;
}


?>
