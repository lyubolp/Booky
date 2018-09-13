<?php
/**
 * Example how the functions from initialize_from_chitanka.php are supposed to be used
 * to put the information from chitanka.***.ttx file into the DB.
 * This procedure is to be executed only once when initializing the DB, because
 * it does not check for if such data as the one to be inserted already exists in the DB
 * and is reliant on the fact that the data being inserted starts from Auto Increment 1
 * for the id fields.
 *
 * @category      Examples
 * @package       DB-Additions
 * @subpackage    Legacy
 * @author        Luchev <luchevz@gmail.com>
 * @version       1.0
 */

/**
 * Include the file with the functions
 */
require_once ROOT_FOLDER.'\scripts\initialization\initialize_from_chitanka.php';

/**
 * Set the execution time of the script to be 1 day (86400 seconds)
 * because the default 30 seconds is not enough for parsing such a
 * huge file and inserting all the data into the DB.
 */
ini_set('max_execution_time', 86400);

/**
 * Order in which the functions have to be executed because later functions
 * rely on the already inserted data in the DB from earlier functions.
 * For example InitializeBooksSeries() requires the Series and Books to be added previously,
 * because it sets each book's series_id based on the Series added with InitializeSeries()
 * and it expects the Books to be already initialized with InitializeBooksNames()
 * in order to match each book's id to series_id.
 */

InitializeTags();
InitializeAuthors();
InitializeSeries();
InitializeBooksNames();
InitializeBooksTags();
InitializeBooksAuthors();
InitializeBooksSeries();

?>
