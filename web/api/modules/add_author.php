<?php
/**
 * Snippet for adding new authors in the DB.
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
function AddAuthor($author) {
  $db = DB::Instance();

  if (isset($author['name'])) {
    $name = $author['name'];
  }
  if (isset($author['pen_name']))  {
    $pen_name = $author['pen_name'];
  }
  unset($author['name']);
  unset($author['pen_name']);

  if (!isset($author['born_year'])) {
    $author['born_year'] = 0;
  }

  if (!$db->Insert('author', $author)) {
    return FALSE;
  }

  $lastId = $db->GetMax('author', 'id');

  $name['type_id'] = 4;
  $name['item_id'] = $lastId;
  AddTranslation($name);

  $pen_name['type_id'] = 5;
  $pen_name['item_id'] = $lastId;
  AddTranslation($pen_name);

}


?>
