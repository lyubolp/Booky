<?php
/**
 * Snippet for adding new books in the DB.
 *
 * @category  Modules
 * @package   DB-Additions
 * @author    Luchev <luchevz@gmail.com>
 * @version   1.0
 * @since     File available since Release 0.1
 */

require_once ROOT_FOLDER.'\DBCON\db.php';
require_once ROOT_FOLDER.'\modules\add_translation.php';

/**
 * Add a new author
 *
 * @return    TRUE|FALSE on success|failure
*/
function AddBook($book, $translation, $id) {
  $db = DB::Instance();

  $db->Insert('book', $book);

  $translation['item_id'] = $id;
  $translation['type_id'] = 7;
  AddTranslation($translation);

}


?>
