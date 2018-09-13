<?php
/**
 * Snippet for updating translation in table `translation` of the DB.
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
function UpdateTranslation($row, $where) {
  $db = DB::Instance();
  $success = $db->Update('translation', $row, $where);
  $GLOBALS['response']['s'] = $success;
  return $success;
}


?>
