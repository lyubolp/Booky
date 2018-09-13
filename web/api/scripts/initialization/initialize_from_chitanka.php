<?php
/**
 * Functions purposed to parse a chitanka.***.ttx file and add all its relevant information to the DB
 *
 * @category      Scripts
 * @package       DB-Additions
 * @subpackage    Legacy
 * @uses          DB
 * @author        Luchev <luchevz@gmail.com>
 * @version       1.0
 * @since         0.1
 * @deprecated    0.1
 * @example       /api/scripts/examples/initialize_from_chitanka_example.php
 */

/**
 * Include the DB class
 */
require_once ROOT_FOLDER.'/DBCON/db.php';

/**
 * Add new book entries in table 'book' and add their titles in table 'translation'.
 * This function requires the table 'book' to be empty (Auto Increment for id to be 1)
 * for maximum efficiency and not checking the id of the last added row in 'book' in
 * order to add its corresponding title such as translation.item_id = book.id
 */
function InitializeBooksNames() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $lang;

  require_once ROOT_FOLDER.'\modules\add_book.php';
  $id = 1;
  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {
    // echo "Id: " . $matches[1][0] . ". Offset: " . end($matches)[1] . "\n";
    $offset = end($matches)[1];

    if ($matches[8][0] != '') {
      $book['publish_year'] = $matches[8][0];
    }
    else {
      $book['publish_year'] = 0;
    }

    $translation = array();
    if (!mb_detect_encoding($matches[6][0], 'ASCII', true)) {
      $translation['bg'] = $matches[6][0];
    }
    else {
      $translation['en'] = $matches[6][0];
    }

    AddBook($book, $translation, $id);
    $id++;

  }

}

/**
 * Match each book with its tags by adding book_id and tag_id in table 'book_tag'.
 * This function requires InitializeBooksNames() to be executed first because
 * it requires the books in table 'book' to be inserted with the same IDs as they
 * are in the chitanka.***.ttx file.
 */
function InitializeBooksTags() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $lang;
  $db = DB::Instance();
  $where['type_id'] = 6;
  $select = array('item_id', 'bg');
  $allTags = $db->Select('translation', $select, $where);
  $bgTag;
  foreach ($allTags as $item) {
    $bgTag[$item['bg']] = $item['item_id'];
  }

  $id = 1;
  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {
    // echo "Id: " . $matches[1][0] . ". Offset: " . end($matches)[1] . "\n";
    $offset = end($matches)[1];

    $tags = array();
    $tags = array_merge(explode('|', $matches[10][0]), explode('|', $matches[11][0]));
    // Tags
    $tags = array_unique($tags);
    foreach ($tags as $item) {
      if (!isset($bgTag[$item])) {
        continue;
      }

      $tagId = $bgTag[$item];
      $newRow['book_id'] = $id;
      $newRow['tag_id'] = $tagId;
      // print_r($newRow);
      $db->Insert('book_tag', $newRow);
    }

    $id++;

  }

}

/**
 * Match each book with its authors by adding book_id and author_id in table 'book_author'.
 * This function requires InitializeBooksNames() to be executed first because
 * it requires the books in table 'book' to be inserted with the same IDs as they
 * are in the chitanka.***.ttx file.
 */
function InitializeBooksAuthors() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $db = DB::Instance();
  $where['type_id'] = 4;
  $select = array('item_id', 'bg');
  $allAuthors = $db->Select('translation', $select, $where);
  $bgAuthors;
  foreach ($allAuthors as $item) {
    $bgAuthors[$item['bg']] = $item['item_id'];
  }

  $id = 1;
  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {
    // echo "Id: " . $matches[1][0] . ". Offset: " . end($matches)[1] . "\n";
    $offset = end($matches)[1];

    $authors = array();
    $authors = explode('|', $matches[2][0]); // DONE
    $authors = array_unique($authors);
    foreach ($authors as $item) {
      if (!isset($bgAuthors[$item])) {
        echo "Unset " . $item . " for Book: " . $id . "\n";
        continue;
      }

      $authorId = $bgAuthors[$item];
      $newRow['book_id'] = $id;
      $newRow['author_id'] = $authorId;
      // print_r($newRow);
      $db->Insert('book_author', $newRow);
    }

    $id++;

  }

}

/**
 * Match each book with its series by updating series_id in table 'book'.
 * This function requires InitializeBooksNames() and InitializeSeries()
 * to be executed first because it requires the books in table 'book' to be
 * inserted with the same IDs as they are in the chitanka.***.ttx file.
 */
function InitializeBooksSeries() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $db = DB::Instance();
  $where['type_id'] = 8;
  $select = array('item_id', 'bg', 'en');
  $allSeries = $db->Select('translation', $select, $where);
  $bgSeries;
  foreach ($allSeries as $item) {
    if (isset($item['bg']) && $item['bg'] != '') {
      $bgSeries[$item['bg']] = $item['item_id'];
    }
    else if (isset($item['en'])) {
      $bgSeries[$item['en']] = $item['item_id'];
    }
  }

  $id = 1;
  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {
    // echo "Id: " . $matches[1][0] . ". Offset: " . end($matches)[1] . "\n";
    $offset = end($matches)[1];

    $series = $matches[4][0];
    if (!isset($matches[4][0]) || $series == '') {
      $id++;
      continue;
    }

    $seriesId = $bgSeries[$series];
    $whereBook['id'] = $id;
    $newInfo['series_id'] = $seriesId;
    $data['new'] = $newInfo;
    $data['where'] = $whereBook;
    // print_r($data);
    $db->Update('book', $newInfo, $whereBook);

    $id++;


  }

}

/**
 * Add new series entries in table 'translation'.
 */
function InitializeSeries() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $series = array();

  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {

    $offset = end($matches)[1];

    $tempSeries = $matches[4][0];// = explode('|', $matches[2][0]);
    if ($tempSeries == '') {
      continue;
    }
    if (!in_array($tempSeries, $series)) {
      $series[] = $tempSeries;
    }

  }

  foreach ($series as $item) {
    $row['bg'] = "";
    $row['en'] = "";
    if (!mb_detect_encoding($item, 'ASCII', true)) {
      $row['bg'] = $item;
    }
    else {
      $row['en'] = $item;
    }
    AddSeries($row);
  }


  // file_put_contents('booky.log', print_r($series, true));

}

/**
 * Add new author entries in table 'author' and add their names in table 'translation'.
 * This function requires the table 'author' to be empty (Auto Increment for id to be 1)
 * for maximum efficiency and not checking the id of the last added row in 'author' in
 * order to add its corresponding name such as translation.item_id = author.id
 */
function InitializeAuthors() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $authors = array();

  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {

    $offset = end($matches)[1];

    $tempAuthors = explode('|', $matches[2][0]);
    foreach ($tempAuthors as $item) {
      if ($item == 'нт' || $item == 'сди' || $item == '(неизвестен автор)') {
        continue;
      }
      if (!in_array(trim($item), $authors)) {
        $authors[] = $item;
      }
    }

  }
  // file_put_contents('booky.log', print_r($authors, true));

  require_once ROOT_FOLDER.'\modules\add_author.php';
  // $test['name']['bg'] = '(неизвестен автор)';
  // AddAuthor($test);

  foreach ($authors as $item) {
    $tempAuthor['name']['bg'] = $item;
    AddAuthor($tempAuthor);
  }
}

/**
 * Add new tag entries in table 'translation'.
 */
function InitializeTags() {
  $htmlString = file_get_contents(ROOT_FOLDER."\chitanka.info.filter.ttx");
  $offset = 0;
  $tags = array();

  while(preg_match("|(\d+)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\t(.*?)\n|",
      $htmlString, $matches, PREG_OFFSET_CAPTURE, $offset)) {
    // echo "Id: " . $matches[1][0] . ". Offset: " . end($matches)[1] . "\n";
    $offset = end($matches)[1];
    $tempTags = explode('|', $matches[10][0]);
    $tempTags2 = explode('|', $matches[11][0]);
    foreach ($tempTags as $item) {
      if (strlen($item) < 1) {
        continue;
      }
      if ($item[0] === '@') { //ignore insider tags
        continue;
      }
      if (!in_array(trim($item), $tags)) {
        $tags[] = trim($item);
      }
    }
    foreach ($tempTags2 as $item) {
      if (strlen($item) < 1) { // avoid the empty tag
        continue;
      }
      if ($item[0] === '@') {
        continue;
      }
      if (!in_array(trim($item), $tags)) {
        $tags[] = trim($item);
      }
    }
  }
  $db = DB::Instance();
  foreach ($tags as $item) {
    $row['bg'] = $item;
    AddTag($row);
  }

}

/**
 * Helper function to insert new row in table 'book' and its title in table 'translation'
 *
 * @param Array $book         $key => $value array containing keys corresponding to the columns from table 'book'
 *                            e.g array('chapters' => 15, 'language_id' => 5,)
 * @param Array $translation  $key => $value array containing keys corresponding to the columns from table 'translation'
 *                            e.g array('bg' => "Bulgarian Name", 'en' => "English name",)
 * @param Int $id             Id of the new book added in table 'book'. This can be either precalculated from the DB
 *                            or it can be provided if the user knows what it will be (which is the case when this
 *                            function is called from inside InitializeBooksNames())
 */
function AddBook($book, $translation, $id) {
  $db = DB::Instance();

  $db->Insert('book', $book);

  $translation['item_id'] = $id;
  $translation['type_id'] = 7;
  AddTranslation($translation);

}

/**
 * Helper function to insert new row into table 'translation' with type_id = 6 (book tag)
 *
 * @param Array $row          $key => $value array containing keys corresponding to the columns from table 'translation'
 *                            e.g array('bg' => "Bulgarian Tag Name", 'en' => "English Tag Name",)
 */
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

/**
 * Helper function to insert new row into table 'translation' with type_id = 8 (series)
 *
 * @param Array $row          $key => $value array containing keys corresponding to the columns from table 'translation'
 *                            e.g array('bg' => "Bulgarian Series Name", 'en' => "English Series Name",)
 */
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

/**
 * Helper function to insert new row in table 'author' and its name and pen_name in table 'translation'
 *
 * @param Array $author       $key => $value array containing keys corresponding to the columns from table 'author' and
 *                            also the keys 'name' and 'pen_name' (arrays), which are removed from the array and inserted in the
 *                            'translation table'.
 *                            e.g array('name' => array('bg' => "Bulgarian Author Name",), 'born_year' => 1970,)
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
