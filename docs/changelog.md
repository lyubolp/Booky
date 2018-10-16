# PHP API Changelog

## [Unreleased]

- 



## [0.1.1] - 2018-09-30

### Added

- Added legacy/ for the code for parsing chitanka.***.ttx.
- Added classes Request and Response.
- Added class DBCON which contains the details for login into the DB.
- Added class DBVARS which contains the prepared statements and their types. 
- Added ThrowErrorSafe() which does not log errors, only returns them to the client.
- Added GetGlobalResponse() to get the Response object safely.
- Added GetGlobalRequest() to get the Request object safely.
- Added class LIMIST to store the limits for requests.
- Added Prepare() and ExecutePreparedStatement() in the DB class for interacting with the DB.

### Changed

- Changed the structure of the API to be more object-oriented.
- Renamed UpdateError() to ThrowError().
- Changed the structure of modules/ to separate them in categories.
- Changed the DB class to work with prepared statements only.
- Moved all the strings from the DB tables into _translation_ for easier access.

### Deprecated

- Deprecated the code for parsing information from chitanka.***.ttx.
- Deprecated ExecuteQuery() in the DB class for security reasons.

### Removed

- Removed the Insert, Select, Update, Delete functions from the DB class.

### Security

- Changed the LogError() in the DB class to use ThrowErrorSafe().



## [0.1.0] - 2018-09-25

### Added

- Created the database.
- Created the base of the API.
- Created the DB class responsible for the connection API-DB.
- Added functions for parsing information from chitanka.***.ttx file into the DB.
- Added examples for the parsing functions.
- Added basic request parsing.
- Added UpdateError() for returning errors to the client.
