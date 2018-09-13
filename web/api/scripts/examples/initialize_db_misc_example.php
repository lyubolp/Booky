<?php
/**
 * Example how the functions from initialize_db_misc.php are supposed to be used
 * to create the base database with basic information and necessary items for
 * further use.
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
require_once ROOT_FOLDER.'\scripts\initialization\initialize_db_misc.php';

/**
 * Independent functions.
 * For these the order of execution does not matter.
 */
InitializeStatuses();
InitializeRanks();
InitializeLanguages();
InitializeCountries();

/**
 * This function should be executed after InitializeLanguages();
 */
InitializeLanguageCodes();

/**
 * This function should be executed after InitializeCountries();
 */
InitializeCountryCodes();

?>
