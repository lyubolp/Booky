<?php
/**
 * Functions which are used to initialize the DB.
 * These are to be used only on a fresh database to insert the necessary
 * values like countries and their abbreviations, statuses, ranks,
 * languages and their abbreviations, etc.
 *
 * @category      Scripts
 * @package       DB-Additions
 * @subpackage    Legacy
 * @uses          DB
 * @author        Luchev <luchevz@gmail.com>
 * @version       1.0
 * @since         0.1
 * @deprecated    0.1
 * @example       /api/scripts/examples/initialize_db_misc_example.php
 */

/**
 * Include the DB class
 */
require_once ROOT_FOLDER.'/DBCON/db.php';

/**
 * Include the translation methods
 */
require_once(ROOT_FOLDER."\modules\add_translation.php");
require_once(ROOT_FOLDER."\modules\update_translation.php");

/**
 * Insert English statuses in table 'translation'
 * Initialize the statuses with hardcoded values
 */
function InitializeStatuses() {
  $row['type_id'] = 0;
  $row['item_id'] = 0;
  $row['en'] = "Wishlist";
  AddTranslation($row);

  $row['type_id'] = 0;
  $row['item_id'] = 1;
  $row['en'] = "Reading";
  AddTranslation($row);

  $row['type_id'] = 0;
  $row['item_id'] = 2;
  $row['en'] = "Completed";
  AddTranslation($row);

  $row['type_id'] = 0;
  $row['item_id'] = 3;
  $row['en'] = "On Hold";
  AddTranslation($row);

  $row['type_id'] = 0;
  $row['item_id'] = 4;
  $row['en'] = "Dropped";
  AddTranslation($row);
}

/**
 * Insert English ranks in table 'translation'
 * Initialize the ranks with hardcoded values
 */
function InitializeRanks() {
  $row['type_id'] = 1;
  $row['item_id'] = 0;
  $row['en'] = "Guest";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 1;
  $row['en'] = "Rookie";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 2;
  $row['en'] = "Reader";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 3;
  $row['en'] = "Book Wizard";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 4;
  $row['en'] = "Moderator";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 5;
  $row['en'] = "Admin";
  AddTranslation($row);

  $row['type_id'] = 1;
  $row['item_id'] = 6;
  $row['en'] = "Author";
  AddTranslation($row);

}

/**
 * Insert bg/en names of languages in table 'translation'.
 * Initialize the languages with their bg/en translation version, but
 * without their abbreviations. Use InitializeLanguageCodes() after this to
 * initialize the abbreviations
 */
function InitializeLanguages() {
  // Languages as a string separated by ',' while the different translations are separated as follows: English|Bulgarian

  $languages = "Afrikaans|африкански,Albanian|албански,Arabic|арабски,Azerbaijani|азерски,Basque|баски,Belarusian|беларуски,Bengali|бенгалски,Bosnian|босненски,Bulgarian|български,Cantonese|кантонски,Catalan|каталонски,Chinese|китайски,Croatian|хърватски,Czech|чешки,Danish|датски,Dutch|холандски,English|английски,Estonian|естонски,Filipino|филипински,Finnish|фински,French|френски,Georgian|грузински,German|немски,Greek|гръцки,Gujarati|гуджаратски,Hebrew|иврит,Hindi|хинди,Hungarian|унгарски,Icelandic|исландски,Indonesian|индонезийски,Irish|ирландски,Italian|италиански,Japanese|японски,Kazakh|казахски,Cambodian|камбоджански,Korean|корейски,Lao|лаоски,Latin|латински,Latvian|латвийски,Lithuanian|литовски,Malay|малайски,Marathi|маратхи,Mongolian|монголски,Nepali|непалски,Norwegian|норвежки,Pashto|пущунски,Persian|персийски,Polish|полски,Portuguese|португалски,Punjabi|панджаби,Romanian|румънски,Russian|руски,Scottish|шотландски,Serbian|сръбски,Slovak|словашки,Slovenian|словенски,Somali|сомалийски,Spanish|испански,Swahili|суахили,Swedish|шведски,Tagalog|тагалски,Tamil|тамилски,Telugu|телугу,Thai|тайвански,Turkish|турски,Ukrainian|украински,Urdu|урду,Uzbek|узбекски,Vietnamese|виетнамски,Welsh|уелски,Zulu|зулу";

  $arr = explode(',', $languages);

  // Loop through the capture groups and add them to the DB
  $i = 0;
  foreach ($arr as $value) {
    $row['type_id'] = 3;
    $row['item_id'] = $i;
    $language = explode('|', $value);
    $row['en'] = $language[0];
    $row['bg'] = $language[1];
    AddTranslation($row);
    $i++;
  }

}

/**
* Update the langauges in table 'translation' with their abbreviations.
* This function initializes the language abbreviations according to ISO-639 standard.
* Requires for the languages to be added to the 'translation' table first, as this functions
* searches for the English name of the language and adds its abbreviation.
*/
function InitializeLanguageCodes() {

  $htmlString = '<tbody><tr><td>Abkhazian</td><td>ab</td><td>abk</td></tr><tr><td>Afar</td><td>aa</td><td>aar</td></tr><tr><td>Afrikaans</td><td>af</td><td>afr</td></tr><tr><td>Albanian</td><td>sq</td><td>alb/sqi*</td></tr><tr><td>Amharic</td><td>am</td><td>amh</td></tr><tr><td>Arabic</td><td>ar</td><td>ara</td></tr><tr><td>Aragonese</td><td>an</td><td>arg</td></tr><tr><td>Armenian</td><td>hy</td><td>arm/hye*</td></tr><tr><td>Assamese</td><td>as</td><td>asm</td></tr><tr><td>Avestan</td><td>ae</td><td>ave</td></tr><tr><td>Aymara</td><td>ay</td><td>aym</td></tr><tr><td>Azerbaijani</td><td>az</td><td>aze</td></tr><tr><td>Bashkir</td><td>ba</td><td>bak</td></tr><tr><td>Basque</td><td>eu</td><td>baq/eus*</td></tr><tr><td>Belarusian</td><td>be</td><td>bel</td></tr><tr><td>Bengali</td><td>bn</td><td>ben</td></tr><tr><td>Bihari</td><td>bh</td><td>bih</td></tr><tr><td>Bislama</td><td>bi</td><td>bis</td></tr><tr><td>Bosnian</td><td>bs</td><td>bos</td></tr><tr><td>Breton</td><td>br</td><td>bre</td></tr><tr><td>Bulgarian</td><td>bg</td><td>bul</td></tr><tr><td>Burmese</td><td>my</td><td>bur/mya*</td></tr><tr><td>Catalan</td><td>ca</td><td>cat</td></tr><tr><td>Chamorro</td><td>ch</td><td>cha</td></tr><tr><td>Chechen</td><td>ce</td><td>che</td></tr><tr><td>Chinese</td><td>zh</td><td>chi/zho*</td></tr><tr><td>Church Slavic; Slavonic; Old Bulgarian</td><td>cu</td><td>chu</td></tr><tr><td>Chuvash</td><td>cv</td><td>chv</td></tr><tr><td>Cornish</td><td>kw</td><td>cor</td></tr><tr><td>Corsican</td><td>co</td><td>cos</td></tr><tr><td>Croatian</td><td>hr</td><td>scr/hrv*</td></tr><tr><td>Czech</td><td>cs</td><td>cze/ces*</td></tr><tr><td>Danish</td><td>da</td><td>dan</td></tr><tr><td>Divehi; Dhivehi; Maldivian</td><td>dv</td><td>div</td></tr><tr><td>Dutch</td><td>nl</td><td>dut/nld*</td></tr><tr><td>Dzongkha</td><td>dz</td><td>dzo</td></tr><tr><td>English</td><td>en</td><td>eng</td></tr><tr><td>Esperanto</td><td>eo</td><td>epo</td></tr><tr><td>Estonian</td><td>et</td><td>est</td></tr><tr><td>Faroese</td><td>fo</td><td>fao</td></tr><tr><td>Fijian</td><td>fj</td><td>fij</td></tr><tr><td>Finnish</td><td>fi</td><td>fin</td></tr><tr><td>French</td><td>fr</td><td>fre/fra*</td></tr><tr><td>Gaelic; Scottish Gaelic</td><td>gd</td><td>gla</td></tr><tr><td>Galician</td><td>gl</td><td>glg</td></tr><tr><td>Georgian</td><td>ka</td><td>geo/kat*</td></tr><tr><td>German</td><td>de</td><td>ger/deu*</td></tr><tr><td>Greek, Modern (1453-)</td><td>el</td><td>gre/ell*</td></tr><tr><td>Guarani</td><td>gn</td><td>grn</td></tr><tr><td>Gujarati</td><td>gu</td><td>guj</td></tr><tr><td>Haitian; Haitian Creole</td><td>ht</td><td>hat</td></tr><tr><td>Hausa</td><td>ha</td><td>hau</td></tr><tr><td>Hebrew</td><td>he</td><td>heb</td></tr><tr><td>Herero</td><td>hz</td><td>her</td></tr><tr><td>Hindi</td><td>hi</td><td>hin</td></tr><tr><td>Hiri Motu</td><td>ho</td><td>hmo</td></tr><tr><td>Hungarian</td><td>hu</td><td>hun</td></tr><tr><td>Icelandic</td><td>is</td><td>ice/isl*</td></tr><tr><td>Ido</td><td>io</td><td>ido</td></tr><tr><td>Indonesian</td><td>id</td><td>ind</td></tr><tr><td>Interlingua (International Auxiliary Language Association)</td><td>ia</td><td>ina</td></tr><tr><td>Interlingue</td><td>ie</td><td>ile</td></tr><tr><td>Inuktitut</td><td>iu</td><td>iku</td></tr><tr><td>Inupiaq</td><td>ik</td><td>ipk</td></tr><tr><td>Irish</td><td>ga</td><td>gle</td></tr><tr><td>Italian</td><td>it</td><td>ita</td></tr><tr><td>Japanese</td><td>ja</td><td>jpn</td></tr><tr><td>Javanese</td><td>jv</td><td>jav</td></tr><tr><td>Kalaallisut</td><td>kl</td><td>kal</td></tr><tr><td>Kannada</td><td>kn</td><td>kan</td></tr><tr><td>Kashmiri</td><td>ks</td><td>kas</td></tr><tr><td>Kazakh</td><td>kk</td><td>kaz</td></tr><tr><td>Khmer</td><td>km</td><td>khm</td></tr><tr><td>Kikuyu; Gikuyu</td><td>ki</td><td>kik</td></tr><tr><td>Kinyarwanda</td><td>rw</td><td>kin</td></tr><tr><td>Kirghiz</td><td>ky</td><td>kir</td></tr><tr><td>Komi</td><td>kv</td><td>kom</td></tr><tr><td>Korean</td><td>ko</td><td>kor</td></tr><tr><td>Kuanyama; Kwanyama</td><td>kj</td><td>kua</td></tr><tr><td>Kurdish</td><td>ku</td><td>kur</td></tr><tr><td>Lao</td><td>lo</td><td>lao</td></tr><tr><td>Latin</td><td>la</td><td>lat</td></tr><tr><td>Latvian</td><td>lv</td><td>lav</td></tr><tr><td>Limburgan; Limburger; Limburgish</td><td>li</td><td>lim</td></tr><tr><td>Lingala</td><td>ln</td><td>lin</td></tr><tr><td>Lithuanian</td><td>lt</td><td>lit</td></tr><tr><td>Luxembourgish; Letzeburgesch</td><td>lb</td><td>ltz</td></tr><tr><td>Macedonian</td><td>mk</td><td>mac/mkd*</td></tr><tr><td>Malagasy</td><td>mg</td><td>mlg</td></tr><tr><td>Malay</td><td>ms</td><td>may/msa*</td></tr><tr><td>Malayalam</td><td>ml</td><td>mal</td></tr><tr><td>Maltese</td><td>mt</td><td>mlt</td></tr><tr><td>Manx</td><td>gv</td><td>glv</td></tr><tr><td>Maori</td><td>mi</td><td>mao/mri*</td></tr><tr><td>Marathi</td><td>mr</td><td>mar</td></tr><tr><td>Marshallese</td><td>mh</td><td>mah</td></tr><tr><td>Moldavian</td><td>mo</td><td>mol</td></tr><tr><td>Mongolian</td><td>mn</td><td>mon</td></tr><tr><td>Nauru</td><td>na</td><td>nau</td></tr><tr><td>Navaho, Navajo</td><td>nv</td><td>nav</td></tr><tr><td>Ndebele, North</td><td>nd</td><td>nde</td></tr><tr><td>Ndebele, South</td><td>nr</td><td>nbl</td></tr><tr><td>Ndonga</td><td>ng</td><td>ndo</td></tr><tr><td>Nepali</td><td>ne</td><td>nep</td></tr><tr><td>Northern Sami</td><td>se</td><td>sme</td></tr><tr><td>Norwegian</td><td>no</td><td>nor</td></tr><tr><td>Norwegian Bokmal</td><td>nb</td><td>nob</td></tr><tr><td>Norwegian Nynorsk</td><td>nn</td><td>nno</td></tr><tr><td>Nyanja; Chichewa; Chewa</td><td>ny</td><td>nya</td></tr><tr><td>Occitan (post 1500); Provencal</td><td>oc</td><td>oci</td></tr><tr><td>Oriya</td><td>or</td><td>ori</td></tr><tr><td>Oromo</td><td>om</td><td>orm</td></tr><tr><td>Ossetian; Ossetic</td><td>os</td><td>oss</td></tr><tr><td>Pali</td><td>pi</td><td>pli</td></tr><tr><td>Panjabi</td><td>pa</td><td>pan</td></tr><tr><td>Persian</td><td>fa</td><td>per/fas*</td></tr><tr><td>Polish</td><td>pl</td><td>pol</td></tr><tr><td>Portuguese</td><td>pt</td><td>por</td></tr><tr><td>Pushto</td><td>ps</td><td>pus</td></tr><tr><td>Quechua</td><td>qu</td><td>que</td></tr><tr><td>Raeto-Romance</td><td>rm</td><td>roh</td></tr><tr><td>Romanian</td><td>ro</td><td>rum/ron*</td></tr><tr><td>Rundi</td><td>rn</td><td>run</td></tr><tr><td>Russian</td><td>ru</td><td>rus</td></tr><tr><td>Samoan</td><td>sm</td><td>smo</td></tr><tr><td>Sango</td><td>sg</td><td>sag</td></tr><tr><td>Sanskrit</td><td>sa</td><td>san</td></tr><tr><td>Sardinian</td><td>sc</td><td>srd</td></tr><tr><td>Serbian</td><td>sr</td><td>scc/srp*</td></tr><tr><td>Shona</td><td>sn</td><td>sna</td></tr><tr><td>Sichuan Yi</td><td>ii</td><td>iii</td></tr><tr><td>Sindhi</td><td>sd</td><td>snd</td></tr><tr><td>Sinhala; Sinhalese</td><td>si</td><td>sin</td></tr><tr><td>Slovak</td><td>sk</td><td>slo/slk*</td></tr><tr><td>Slovenian</td><td>sl</td><td>slv</td></tr><tr><td>Somali</td><td>so</td><td>som</td></tr><tr><td>Sotho, Southern</td><td>st</td><td>sot</td></tr><tr><td>Spanish; Castilian</td><td>es</td><td>spa</td></tr><tr><td>Sundanese</td><td>su</td><td>sun</td></tr><tr><td>Swahili</td><td>sw</td><td>swa</td></tr><tr><td>Swati</td><td>ss</td><td>ssw</td></tr><tr><td>Swedish</td><td>sv</td><td>swe</td></tr><tr><td>Tagalog</td><td>tl</td><td>tgl</td></tr><tr><td>Tahitian</td><td>ty</td><td>tah</td></tr><tr><td>Tajik</td><td>tg</td><td>tgk</td></tr><tr><td>Tamil</td><td>ta</td><td>tam</td></tr><tr><td>Tatar</td><td>tt</td><td>tat</td></tr><tr><td>Telugu</td><td>te</td><td>tel</td></tr><tr><td>Thai</td><td>th</td><td>tha</td></tr><tr><td>Tibetan</td><td>bo</td><td>tib/bod*</td></tr><tr><td>Tigrinya</td><td>ti</td><td>tir</td></tr><tr><td>Tonga (Tonga Islands)</td><td>to</td><td>ton</td></tr><tr><td>Tsonga</td><td>ts</td><td>tso</td></tr><tr><td>Tswana</td><td>tn</td><td>tsn</td></tr><tr><td>Turkish</td><td>tr</td><td>tur</td></tr><tr><td>Turkmen</td><td>tk</td><td>tuk</td></tr><tr><td>Twi</td><td>tw</td><td>twi</td></tr><tr><td>Uighur</td><td>ug</td><td>uig</td></tr><tr><td>Ukrainian</td><td>uk</td><td>ukr</td></tr><tr><td>Urdu</td><td>ur</td><td>urd</td></tr><tr><td>Uzbek</td><td>uz</td><td>uzb</td></tr><tr><td>Vietnamese</td><td>vi</td><td>vie</td></tr><tr><td>Volapuk</td><td>vo</td><td>vol</td></tr><tr><td>Walloon</td><td>wa</td><td>wln</td></tr><tr><td>Welsh</td><td>cy</td><td>wel/cym*</td></tr><tr><td>Western Frisian</td><td>fy</td><td>fry</td></tr><tr><td>Wolof</td><td>wo</td><td>wol</td></tr><tr><td>Xhosa</td><td>xh</td><td>xho</td></tr><tr><td>Yiddish</td><td>yi</td><td>yid</td></tr><tr><td>Yoruba</td><td>yo</td><td>yor</td></tr><tr><td>Zhuang; Chuang</td><td>za</td><td>zha</td></tr><tr><td>Zulu</td><td>zu</td><td>zul</td></tr></tbody><tfoot></tfoot></table>';

  preg_match_all("|<tr><td>(\w+)</td><td>(\w+)<|", $htmlString, $matches); // Match the html against some regex to separate the BG and EN translation

  $db = DB::Instance();
  // Loop through the capture groups and add them to the DB
  for ($i = 0; $i < count($matches[1]); $i++) {
    $abbr = $db->EscapeString($matches[2][$i]);
    $lang = $db->EscapeString($matches[1][$i]);
    $sql = "UPDATE translation SET special = '{$abbr}' WHERE en = '{$lang}' AND type_id = 3";
    if ($db->ExecuteQuery($sql)) {
      $GLOBALS['response']['r'][] = $abbr;
    }
  }


}

/**
 * Insert bg/en names of countries in table 'translation'.
 * Initialize countries from a given html page by parsing them with regex.
 * Example given in the comments inside.
 * If this function is needed to be used the html code has to be copied in the
 * variable inside called $htmlString. Not included to avoid huge strings.
 * After this function, InitializeCountryCodes() can be executed to add the
 * country abbreviations to the DB.
 */
function InitializeCountries() {

  $htmlString = ""; // Use html source code, e.g here used https://bg.speaklanguages.com/%D0%B0%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%B8/%D1%80%D0%B5%D1%87%D0%BD%D0%B8%D0%BA/%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8-%D0%B8-%D0%BD%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D0%BD%D0%BE%D1%81%D1%82%D0%B8

  preg_match_all("|<tr><td><a.*?>(.*?)</a><br>(.*?)<|", $htmlString, $matches); // Match the html against some regex to separate the BG and EN translation
  // in different capture groups

  // Loop through the capture groups and add them to the DB
  for ($i = 0; $i < count($matches[1]); $i++) {
    $row['type_id'] = 2;
    $row['item_id'] = $i;
    $row['en'] = $matches[1][$i];
    $row['bg'] = $matches[2][$i];
    AddTranslation($row);

  }


}

/**
 * Updates the countries in table 'translation' with their abbreviations.
 * This function requires InitializeCountries() to be executed first, as it
 * searches for the English name of the country to add its abbreviation.
 */
function InitializeCountryCodes() {

  $htmlString = "AF|AFGHANISTAN,AL|ALBANIA,DZ|ALGERIA,AS|AMERICAN SAMOA,AD|ANDORRA,AO|ANGOLA,AI|ANGUILLA,AQ|ANTARCTICA,AG|ANTIGUA AND BARBUDA,AR|ARGENTINA,AM|ARMENIA,AW|ARUBA,AU|AUSTRALIA,AT|AUSTRIA,AZ|AZERBAIJAN,BS|BAHAMAS,BH|BAHRAIN,BD|BANGLADESH,BB|BARBADOS,BY|BELARUS,BE|BELGIUM,BZ|BELIZE,BJ|BENIN,BM|BERMUDA,BT|BHUTAN,BO|BOLIVIA,BA|BOSNIA AND HERZEGOVINA,BW|BOTSWANA,BV|BOUVET ISLAND,BR|BRAZIL,IO|BRITISH INDIAN OCEAN TERRITORY,BN|BRUNEI DARUSSALAM,BG|BULGARIA,BF|BURKINA FASO,BI|BURUNDI,KH|CAMBODIA,CM|CAMEROON,CA|CANADA,CV|CAPE VERDE,KY|CAYMAN ISLANDS,CF|CENTRAL AFRICAN REPUBLIC,TD|CHAD,CL|CHILE,CN|CHINA,CX|CHRISTMAS ISLAND,CC|COCOS ISLANDS,CO|COLOMBIA,KM|COMOROS,CG|CONGO,CD|CONGO,CK|COOK ISLANDS,CR|COSTA RICA,CI|CÔTE D'IVOIRE,HR|CROATIA,CU|CUBA,CY|CYPRUS,CZ|CZECH REPUBLIC,DK|DENMARK,DJ|DJIBOUTI,DM|DOMINICA,DO|DOMINICAN REPUBLIC,EC|ECUADOR,EG|EGYPT,SV|EL SALVADOR,GQ|EQUATORIAL GUINEA,ER|ERITREA,EE|ESTONIA,ET|ETHIOPIA,FK|FALKLAND ISLANDS,FO|FAROE ISLANDS,FJ|FIJI,FI|FINLAND,FR|FRANCE,GF|FRENCH GUIANA,PF|FRENCH POLYNESIA,TF|FRENCH SOUTHERN TERRITORIES,GA|GABON,GM|GAMBIA,GE|GEORGIA,DE|GERMANY,GH|GHANA,GI|GIBRALTAR,GR|GREECE,GL|GREENLAND,GD|GRENADA,GP|GUADELOUPE,GU|GUAM,GT|GUATEMALA,GN|GUINEA,GW|GUINEA|BISSAU,GY|GUYANA,HT|HAITI,HM|HEARD ISLAND AND MCDONALD ISLANDS,HN|HONDURAS,HK|HONG KONG,HU|HUNGARY,IS|ICELAND,IN|INDIA,ID|INDONESIA,IR|IRAN,IQ|IRAQ,IE|IRELAND,IL|ISRAEL,IT|ITALY,JM|JAMAICA,JP|JAPAN,JO|JORDAN,KZ|KAZAKHSTAN,KE|KENYA,KI|KIRIBATI,KP|KOREA,KR|KOREA,KW|KUWAIT,KG|KYRGYZSTAN,LA|LAO PEOPLE'S DEMOCRATIC REPUBLIC,LV|LATVIA,LB|LEBANON,LS|LESOTHO,LR|LIBERIA,LY|LIBYAN ARAB JAMAHIRIYA,LI|LIECHTENSTEIN,LT|LITHUANIA,LU|LUXEMBOURG,MO|MACAO,MK|MACEDONIA,MG|MADAGASCAR,MW|MALAWI,MY|MALAYSIA,MV|MALDIVES,ML|MALI,MT|MALTA,MH|MARSHALL ISLANDS,MQ|MARTINIQUE,MR|MAURITANIA,MU|MAURITIUS,YT|MAYOTTE,MX|MEXICO,FM|MICRONESIA,MD|MOLDOVA,MC|MONACO,MN|MONGOLIA,MS|MONTSERRAT,MA|MOROCCO,MZ|MOZAMBIQUE,MM|MYANMAR,NA|NAMIBIA,NR|NAURU,NP|NEPAL,NL|NETHERLANDS,AN|NETHERLANDS ANTILLES,NC|NEW CALEDONIA,NZ|NEW ZEALAND,NI|NICARAGUA,NE|NIGER,NG|NIGERIA,NU|NIUE,NF|NORFOLK ISLAND,MP|NORTHERN MARIANA ISLANDS,NO|NORWAY,OM|OMAN,PK|PAKISTAN,PW|PALAU,PS|PALESTINIAN TERRITORY,PA|PANAMA,PG|PAPUA NEW GUINEA,PY|PARAGUAY,PE|PERU,PH|PHILIPPINES,PN|PITCAIRN,PL|POLAND,PT|PORTUGAL,PR|PUERTO RICO,QA|QATAR,RE|RÉUNION,RO|ROMANIA,RU|RUSSIAN FEDERATION,RW|RWANDA,SH|SAINT HELENA,KN|SAINT KITTS AND NEVIS,LC|SAINT LUCIA,PM|SAINT PIERRE AND MIQUELON,VC|SAINT VINCENT AND THE GRENADINES,WS|SAMOA,SM|SAN MARINO,ST|SAO TOME AND PRINCIPE,SA|SAUDI ARABIA,SN|SENEGAL,CS|SERBIA AND MONTENEGRO,SC|SEYCHELLES,SL|SIERRA LEONE,SG|SINGAPORE,SK|SLOVAKIA,SI|SLOVENIA,SB|SOLOMON ISLANDS,SO|SOMALIA,ZA|SOUTH AFRICA,GS|SOUTH GEORGIA AND SOUTH SANDWICH ISLANDS,ES|SPAIN,LK|SRI LANKA,SD|SUDAN,SR|SURINAME,SJ|SVALBARD AND JAN MAYEN,SZ|SWAZILAND,SE|SWEDEN,CH|SWITZERLAND,SY|SYRIAN ARAB REPUBLIC,TW|TAIWAN,TJ|TAJIKISTAN,TZ|TANZANIA,TH|THAILAND,TL|TIMOR|LESTE,TG|TOGO,TK|TOKELAU,TO|TONGA,TT|TRINIDAD AND TOBAGO,TN|TUNISIA,TR|TURKEY,TM|TURKMENISTAN,TC|TURKS AND CAICOS ISLANDS,TV|TUVALU,UG|UGANDA,UA|UKRAINE,AE|UNITED ARAB EMIRATES,GB|UNITED KINGDOM,US|UNITED STATES,UM|UNITED STATES MINOR OUTLYING ISLANDS,UY|URUGUAY,UZ|UZBEKISTAN,VU|VANUATU,VN|VIET NAM,VG|VIRGIN ISLANDS,VI|VIRGIN ISLANDS,WF|WALLIS AND FUTUNA,EH|WESTERN SAHARA,YE|YEMEN,ZW|ZIMBABWE";

  $db = DB::Instance();

  $countries = explode(',', $htmlString);
  $countryAbbrev = array();
  foreach ($countries as $country) {
    $tempArr = explode('|', $country);
    $abbr = $db->EscapeString(strtolower($tempArr[0]));
    $c = $db->EscapeString($tempArr[1]);
    $sql = "UPDATE translation SET special = '{$abbr}' WHERE en = '{$c}' AND type_id = 2";
    if ($db->ExecuteQuery($sql)) {
      $GLOBALS['response']['r'][] = $abbr;
    }
  }

}
?>
