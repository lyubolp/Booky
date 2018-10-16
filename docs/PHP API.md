# PHP API

## (JSON)



Template:

* **Variable Name** (Short variable explanation)

  Additional information.

  *Variable name* is usually an abbreviation of *Short variable explanation*.

  The JSON represents a dictionary with the following structure: *Variable Name* : *Value*.

  e.g { SomeString : "Some string", SomeInteger : 35 }

Aliases: 

* **Request** - **Message** sent from the app to the server.
* **Response** - JSON sent from the server to the app.

### JSON fields

* **MT** (Message Type)

  Type of the JSON message being sent between the server and the app.

  If this field is omitted, the default value is 1 (short message).

  List of types:
  * 0 - This is the standard message containing an array of *variable-value* fields.
  * 1 - Contains an array of *values* only. This is a compact (data-efficient) version of **0**, where the app and api know in what order the values are given so as to assign them to the proper variable once the message is received. This order is determined by the Message Type (**mc**).

* **T** (Token)

  When a user logs in they are given a unique token which they then use to send requests to the DB. If no token is provided or the token is invalid the request is rejected.

  Tokens have a lifespan of 24h. 24h after a token is issued to an user it becomes invalid and is deleted. The user then needs to request a new token.

  When a user logs in their account they are issued a token by the server. The user (app) needs to remember this token in order to use it when making requests to the api.

  If this field is omitted the api treats the message as sent by a Guest. (the *g* option can be omitted as well)

* **MC** (Message Code)

  Message codes could be a couple of predetermined characters 

  Used as shortcuts instead of specifying each field that is requested.

  List of codes:

  *  0 - No message code. The same as this field being empty.
  *  1 - Request 1 book by its ID. (Set the field **ID** in the message to have the desired ID)
  *  2 - Request 1 author by its ID. (Set the field **ID** in the message to have the desired ID)
  *  3 - Request all tags
  *  4 - Request multiple **MC 1**. (Set the field **IDS** in the message to have the desired IDs)
  *  5 - Request id, name, rating, rating_count, cover for a book by its ID. (Set the field **ID** in the message to have the desired ID)
  *  6 - Request multiple **MC 5**. (Set the field **IDS** in the message to have the desired IDs)

* **ID**

  ID needed when sending SELECT requests.

* **LANG** (Language)

  Specify the desired language for the translation return either by ID or by ISO code.

* **E** (Error)

  If this field is omitted the default value is 0.

  List of errors from the server:

  * 0 - No errors encountered.
  * 1 - Invalid POST request. *request* is not received. Make sure the app is sending the JSON under a string named *request*.
  * 2 - Empty request. *message* is an empty string. Make sure the app is giving *message* a value.
  * 3 - Invalid JSON. The JSON provided in *message* could not be correctly parsed.
  * 4 - Error in the php. Check the log in the DB for more info.
  * 5 - Failed to connect to the DB.
  * 6 - 
  * 7 - Authorization to the DB failed. Check the user who is trying to log in that they have proper username and password.
  * 8 - Failed to prepare SQL statement.
  * 9 - Provided wrong key to input in the DB. Either the key does not exist in the table or it's from another table.
  * 10 - Failed to set the charset to UTF-8 for the DB.
  * 11 - The provided list of Key => Value in the Insert request for the DB is empty.
  * 12 - Failed to bind parameter to SQL prepared statement.
  * 13 - Fatal error has occurred. Please inform the developers.
  * 14 - Invalid list of Keys or ***** in the Select request for the DB.
  * 15 - Failed to execute prepared SQL statement.
  * 16 - Failed to get result from prepares SQL statement.
  * 17 - Failed to fetch_assoc from the result of prepared SQL statement.
  * 18 - 
  * 19 - Missing a field in the message sent which is required. (e.g when requesting a book/author by ID the **ID** field is empty)
  * 20 - Invalid Message code (**MC**) sent.
  * 21 - Invalid type of argument supplied to a Select function. (e.g a string was given for the ID when an int was expected)
  * 1062 - Trying to add duplicate entries in the DB. PRIMARY key has to be unique.
  * 1064 - The provided SQL to the function ExecuteQuery in the DB class has bad syntax.

* **G** (Guest)

  Guest is used when no user is logged in, hence no token is provided for the request.

  If this field is omitted the default value is 1. Despite that, if the token is not empty this field is disregarded.

  List of values:

  * 1 - Guest mode enabled.

* **D** (Debug)

  Debug mode allows the server to send back detailed info about errors which have happened in the API on the PHP side of things (**Error code 4**). Not all errors return detailed info, most of them return only an *error code* even if debug mode is enabled.

  These errors are logged in the DB regardless of whether debug mode is enabled or not.

  This feature is **experimental** and is only available during early development.

  List of values:

  * 1 - Debug mode enabled

* **S** (Success)

  Determines whether the request to the server was a success. This field being 0 is equal to the error **e** being non-zero. This field can be checked before trying to parse the other parts of the request to save on useless work in case there was a failure.

  List of values:

  * 0 - Failure
  * 1 - Success

* **R** (Result)

  The returned result from the request to the API. This key holds the result from SELECT requests to the DB for example.
