<?php

const ROOT_FOLDER = __DIR__; // The root of the API. Used for include and require
require_once ROOT_FOLDER.'/modules/lib.php'; // Include functions to assist the API
require_once ROOT_FOLDER.'/DBCON/db.php'; // DB class
$message = ''; // JSON message received - parsed into $messageObj
$response = array(); // Response message which the server returns
$response['s'] = 0;
$messageObj; // Dictionary of variable-value converted from the JSON in message
$lastError = 0;
$db = DB::Instance();

// Security checks and parsing of the $message in $messageObj
Initialize();

// Custom error handling
//SetCustomErrorHandling();

$Rank = GetUserRank();

// Guest Rank tests
if ($Rank === 0) {
}





// Insert Test
// require_once(ROOT_FOLDER."\modules\add_status.php");
// $row['type_id'] = 0;
// $row['item_id'] = 28;
// $row['bg'] = "Желани";
// $row['en'] = "Wishlist";
// AddStatus($row);

// Update test
// $where['type_id'] = 0;
// $where['item_id'] = 0;
// $row['bg'] = "Test one";
// $row['en'] = "Test Change";
// $GLOBALS['response']['s'] = $db->Instance()->Update('translation', $row, $where);

// Select test
// $where['type_id'] = 0;
// $where['item_id'] = 0;
// $fields[] = 'item_id';
// $fields[] = 'en';
// // $fields = '*';
// $GLOBALS['response']['r'] = $db->Instance()->Select('translation', $fields, $where);
// $GLOBALS['response']['s'] = 1;

// Delete test
// $where['type_id'] = 0;
// $where['item_id'] = 0;
// $GLOBALS['response']['s'] = $db->Instance()->Delete('translation', $where);


// Add author test
// require_once ROOT_FOLDER.'\modules\add_author.php'; // Include functions to assist the API
// $author;
// $author['born_year'] = 1950;
// $author['country_id'] = 30;
//
// $author['name']['special'] = "Vladimir Babev";
// $author['name']['bg'] = "Бабев";
// $author['name']['en'] = "Babev";
// $author['pen_name']['special'] = "DIS God";
// $author['pen_name']['en'] = "Calculus God";
// $author['pen_name']['bg'] = "Бог на ДИС-а";
//
// AddAuthor($author);

// Tag test
// $tag;
// $tag['bg'] = "";
// $tag['en'] = "";

// Book test
// $book;
// $book['chapters'] = 0;
// $book['series_id'] = 0;
// $book['publish_year'] = 0;
// $book['language_id'] = 0;
// $book['country_id'] = 0;
// $book['rating'] = 0;
// $book['rating_count'] = 0;
// $book['finished_count'] = 0;
// $book['reading_count'] = 0;
// $book['wishlist_count'] = 0;
// $book['dropped_count'] = 0;
// $book['onhold_count'] = 0;
// $book['review_count'] = 0;
// $book['cover'] = "";
//
// $book['name']['bg'] = "";
// $book['name']['en'] = "";
// $book['name']['special'] = "";

// $response['ip'] = GetClientIp();
// $response['g'] = IsGuest($messageObj);
//$response["mt"] = 0; // Message Type - Default value 0
//$response["t"] = ""; // The token is left empty when returning a reponse except in the case of a user logging in (Then the api returns the user a token)
//$reponse['mc'] = ""; // Message Code - default is empty (meaning no request is being made)
//$response["t"] = $request["t"];


// Return the JSON message
Terminate();

?>
