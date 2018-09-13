<?php
// Helpful functions to assist the API and reduce the amount of code in index.php

require_once ROOT_FOLDER.'\DBCON\db.php'; // DB class

// Initial error checks and initializing the $messageObj
function Initialize() {
  if (isset($_POST['message'])) { // If a message is sent assign it to $message
    $GLOBALS['message'] = $_POST['message'];
  }
  else { // If no message is sent return an error
    UpdateError(1, TRUE); // ERROR-1
  }

  if ($GLOBALS['message'] === "") { // If the message is empty return an error
    UpdateError(2, TRUE); // ERROR-2
  }

  $GLOBALS['messageObj'] = json_decode($GLOBALS['message'], true); // Object created from the message so the API can work with it

  //if ($request === null && json_last_error() !== JSON_ERROR_NONE) { // If the JSON parse failed return an error
  if ($GLOBALS['messageObj'] === null) { // If the JSON parse failed return an error
    UpdateError(3, TRUE); // ERROR-3
  }
}

// This is a macro for quickly stopping the php script
// echo the $response in JSON form and then die();
function Terminate() {
  echo(json_encode($GLOBALS['response']));
  die();
}

// Function to get the client ip address
function GetClientIp() {
    return $_SERVER['REMOTE_ADDR'];
}

// Checks if the message is a request as a guest
function IsGuest() {
  if (!isset($GLOBALS['messageObj']['t']) ||
  (isset($GLOBALS['messageObj']['g']) && $GLOBALS['messageObj']['g'] === 1)) {
    return 1; // True
  }
  return 0; // False
}

function GetUserId() {
  // TODO
  return 0;
}

// $NewError 0 does not change the last error
function UpdateError($NewError = 0, $Error = "") {
  // Validation
  if (!is_int($NewError)) {
    return;
  }

  // Log the error
  $db = DB::Instance();
  $db->LogError($NewError, $Error);

  // If the error is a valid erro - terminate
  if ($NewError) {
    $GLOBALS['response'] = array();
    $GLOBALS['response']['e'] = $NewError;
    Terminate();
  }
}

// Get the user rank as integer
function GetUserRank() {
  if (IsGuest()) {
    return 0;
  }
  return 0;
  // TODO
  // Do more checks against the token in the DB
}

// Set the errors to be silent (to not be displayed to the client) unless specified so in the sent message
// If the received message has 'd':1 (stands for Debug : TRUE) then return the errors to the client, otherwise only log them in the DB
function SetCustomErrorHandling() {
  set_error_handler(function($errno, $errstr, $errfile, $errline, $errcontext) { //use ($db) {
    $e['errno'] = $errno;
    $e['errstr'] = $errstr;
    $e['errfile'] = $errfile;
    $e['errline'] = $errline;
    $e['$errcontext'] = $errcontext;
    UpdateError(4, $e); // ERROR-4
  });
}

?>
