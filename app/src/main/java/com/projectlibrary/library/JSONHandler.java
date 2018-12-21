package com.projectlibrary.library;
/**
 * @author Lyuboslav Karev
 * @version 0.1
 * @since 0.1
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.projectlibrary.library.MainActivity.currentUser;

enum QueryType
{
    BookSmall,
    BookFull,
    UserAchievements,
    BookNine,
    BookSingle,
    UserInfo,
    UserSettings
}
public class JSONHandler {
    /**

    How to use this class:

     Methods:
    Get the users favorite books (cover, name, rating) - getFavoriteBooks(String)
    Get the users reading books (cover, name, rating) - getReadingBooks(String)
    Get the users wishlist books (cover, name, rating) - getWishlistBooks(String)
    Get the users dropped books (cover, name, rating) - getDroppedBooks(String)
    Get the users onhold books (cover, name, rating) - getOnHoldBooks(String)
    Get the users finished books (cover, name, rating) - getFinishedBooks()

    The following methods use the method fillArrayListBooksBasicInfo(String),
    which calls getBooks(). That method loads the JSONObject from the query result,
    so that the fillArrayList...() can fill an ArrayList with the basic info for a book.
    I've decided to use separate methods for the different type of books for two reasons.
    One - simplicity, two - in case we want to do something else before or after we parse the JSON.

    Get the users profile info (all information) - getUserProfile(String json)

     Get the users friends list - WIP
     Get the users achievements - WIP

     Q: Why both methods will use the same getter ?
     A: The getters get a JSON string as a result of a query. In either of the cases, the query return different strings
     but the method to parse them is the same.

     Get all books by batches of 9 (full info) - getAllBooks(String)
     Get book full info - getAllBooks(String)


    Get user settings - WIP
     */
    private JSONArray books; //Books holder
    private JSONObject singleBook; //Single book holder
    private JSONObject userProfile; //User profile holder
    JSONHandler()
    {
        //Default constructor, do not use !
    }
    JSONHandler(String json, QueryType queryType)
    {
        /**
         * @params: String json, QueryType queryType
         * String json -> the json to be parsed
         * QueryType queryType -> The type of the query to be executed
         *
         * This constructor is called when there is JSON to be parsed
         * Based on this, we can execute different queries from the same class
         *
         * When the query is for a book, we call getBooks()
         */
        if(queryType == QueryType.BookFull || queryType == QueryType.BookSingle || queryType == QueryType.BookSmall || queryType == QueryType.BookNine )
        {
            getBooks(json, queryType);
        }
        else
        {
            //Fill other containers
        }

    }

    /**
     * BASE METHODS
     * All other methods use those base ones
     */
    private void getBooks(String json, QueryType queryType)
    {
        /**
         * @params: String json, QueryType queryType
         * String json -> the json to be parsed
         * QueryType queryType -> The type of the query to be executed
         *
         * Creates a JSONObject which reads the JSON.
         * Then based on the query (if its a single book or more), we fill the corresponding container (singleBook or books)
         *
         * This method is called on initialization, because the other methods use the containers singleBook or books to return the objects used in Java
         */
        JSONObject reader;
        try
        {
            reader = new JSONObject(json);

            if(queryType == QueryType.BookSingle)
            {
                singleBook = reader.getJSONObject("R");
            }
            else
            {
                books = reader.getJSONArray("R"); //We get all books and the info in the JSON in an array
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    private Book getBookBasicInfo(JSONObject curBook)
    {
        /**
         * @params: JSONObject curBook -> the current book is JSONObject form
         * @return: Book - the Java object to be used to hold the information about the current book
         *
         * This method converts aa JSONObject containing a book info, to a Book object
         * It saves only the "basic" info -> the id, the rating, the cover and the name
         */
        JSONObject book, translation;
        Book r = new Book();
        try {
            book = curBook.getJSONObject("book");
            translation = curBook.getJSONObject("translation");

            int id = book.getInt("id");
            int rating = book.getInt("rating");
            String cover = book.getString("cover");
            String name_bg = translation.getString("bg");


            r = new Book(id, (short) rating, cover, name_bg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return r;
    }
    private ArrayList<Integer> fillArrayListBooksBasicInfo() //Ready
    {
        /**
         * @return: ArrayList<Integer> - the container to be filled with the id's of the books
         *
         * This method fills an ArrayList with the ids of the books
         * Q: Why there are no arguments ?
         * A: Because the for loop uses the books container
         */
        ArrayList<Integer> result = new ArrayList<>();

        int s = books.length();
        for(int i = 0; i < s; i++) {
            try {
                result.add(getBookBasicInfo(books.getJSONObject(i)).getID());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
    private Book getBookFromJSONObject(JSONObject curBook) //Ready
    {
        /**
         *@param: JSONObject curBook - constains 7 JSONArray's
         *  book
         *  authors
         *  tags
         *  series
         *  translation
         *  language
         *  country
         * We split them into different JSONObjects or JSONArray, and get the relevant info from them
         *
         * This method returns a Book object based on the information from a JSONObject
         */
        JSONObject book, series, traslation, language, country;
        JSONArray authors, tags;
        Book r;

        int id = 0, chapters = 0, series_id = 0, publish_year = 0, language_id = 0, country_id = 0, rating = 0, rating_count = 0, finished_count = 0,
                reading_count = 0, wishlist_count = 0, dropped_count = 0, onhold_count = 0, review_count = 0, s = 0;

        short userRating = 1;
        short userRereadValue = 1;
        short userRereadCount = 1;
        String cover = "", name_original = "", name_bg = "", name_en = "", languageS = "", countryS = "",
                seriesS = "", summary = "", genres = "", userNote = "";


        ArrayList<Integer> authorsS = new ArrayList<>();
        ArrayList<String>  types = new ArrayList<>();
        ArrayList<Review> reviews = new ArrayList<>();

        Book.BookStatus userStatus = Book.BookStatus.Reading;

        try {
            book = curBook.getJSONObject("book");
            id = book.getInt("id");
            chapters = book.getInt("chapters");
            series_id = book.getInt("series_id");
            publish_year = book.getInt("publish_year");
            language_id = book.getInt("language_id");
            country_id = book.getInt("country_id");
            rating = book.getInt("rating");
            rating_count = book.getInt("rating_count");
            finished_count  = book.getInt("finished_count");
            reading_count = book.getInt("reading_count");
            wishlist_count = book.getInt("wishlist_count");
            dropped_count = book.getInt("dropped_count");
            onhold_count = book.getInt("onhold_count");
            review_count = book.getInt("review_count");

            cover = book.getString("cover");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try{
            authors = curBook.getJSONArray("authors");
            int author_count = authors.length(); //Legacy code
            if(authors.isNull(1))
            {
                s = 1;
            }
            else
            {
                s = authors.length();
            }

            for(int i = 0; i < s; i++)
            {
                authorsS.add(authors.getJSONObject(i).getInt("id"));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            tags = curBook.getJSONArray("tags");
            genres = tags.getJSONObject(0).getString("bg");
            s = tags.length();
            for(int i = 1; i < s; i++)
            {
                types.add(tags.getJSONObject(i).getString("bg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            series = curBook.getJSONObject("series");
            seriesS = series.getString("bg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            traslation = curBook.getJSONObject("translation");

            name_original = traslation.getString("special");
            name_bg = traslation.getString("bg");
            name_en = traslation.getString("en");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            language = curBook.getJSONObject("language");
            languageS = language.getString("bg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            country = curBook.getJSONObject("country");
            countryS = country.getString("special");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //TODO - Get the summary from the DB - They will be done after the API is done
        //TODO - authors, reviews - same

        r = new Book(id,series_id, finished_count, reading_count,wishlist_count, dropped_count,
                    onhold_count, review_count, (short)chapters,(short)publish_year, (short)rating, userRating,
                    userRereadValue,userRereadCount, name_original,
                    name_bg, languageS, countryS, seriesS, cover, summary,userNote,authorsS, genres, types, reviews, userStatus);

        return r;
    }
    private Author getAuthor(JSONObject obj)
    {
        /**
         * This method returns an Author object based on the information
         */
        int id = 0; //The id of the author
        short bornYear = 0; //The year the author is born
        short diedYear = 0; //The year the author has died (if not, its 0)
        short bookCount = 0; //The amount of books the author has written
        short seriesCount = 0; //The amount of series the author has written
        short userRating = 0; //The user rating of the author

        String name = ""; //The name of the author in the current language
        String name_original = ""; //The name of the author in his native language
        String country = ""; //The country of origin of the author
        String penName = ""; //The pen name of the author
        String pictureLink = ""; //The link to the author's picture

        ArrayList<String> genres; //The genres that author writes
        ArrayList<String> types; //The type of books that the author writes

        try {
            id = obj.getJSONObject("author").getInt("id");
            bornYear = (short)obj.getJSONObject("author").getInt("born_year");
            diedYear = (short)obj.getJSONObject("author").getInt("died_year");

            name = obj.getJSONObject("translation").getJSONObject("name").getString("bg");
            name_original = obj.getJSONObject("translation").getJSONObject("name").getString("special");

            country = obj.getJSONObject("country").getString("bg");
            penName = obj.getJSONObject("translation").getJSONObject("pen_name").getString("bg");

            pictureLink = obj.getJSONObject("author").getString("picture");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Author temp = new Author(id, bornYear, diedYear, bookCount, seriesCount, userRating, name, name_original, country, penName, pictureLink);

        return temp;
    }
    /**
     * Custom methods
     * Those methods work the same way:, they use the method fillArrayWithBookBasicInfo();, although its WIP
     * @TODO
     */
    ArrayList<Integer> getFavoriteBooks()
    {
        return fillArrayListBooksBasicInfo();
    }
    ArrayList<Integer> getReadingBooks()
    {
        return fillArrayListBooksBasicInfo();
    }
    ArrayList<Integer> getWishlishBooks()
    {
        return fillArrayListBooksBasicInfo();
    }
    ArrayList<Integer> getDroppedBooks()
    {
        return fillArrayListBooksBasicInfo();
    }
    ArrayList<Integer> getOnHoldBooks()
    {
        return fillArrayListBooksBasicInfo();
    }
    ArrayList<Integer> getFinishedBooks()
    {
        return fillArrayListBooksBasicInfo();
    }

    ArrayList<Book> getAllBooks()
    {
        /**
         * Method that fills an ArrayList with all books
         */
        ArrayList<Book> result = new ArrayList<>();
        int s = books.length();

        for(int i = 0; i < s; i++)
        {
            try {
                result.add(getBookFromJSONObject(books.getJSONObject(i)));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    Book getBookAt(int id)
    {
        /**
         * Method that returns the book by its id
         */

        Book result = new Book();
        for(int i = 0; i < books.length(); i++)
        {
            try {
                books.getJSONObject(i);
                if(Integer.parseInt(books.getJSONObject(i).getString("id")) == id)
                {
                    return getBookFromJSONObject(books.getJSONObject(i));
                }
            } catch (JSONException e) { //This is required, in case the JSON blows up
                e.printStackTrace();
            }
        }
        return result;
    }
    Book getSingleBook()
    {
        return getBookFromJSONObject(singleBook);
    }

    void getUserProfile(String json) // Gets all user's profile info
    {

        JSONObject reader;
        try
        {
            reader = new JSONObject(json);

            userProfile = reader.getJSONObject("User"); //We get the user info in the JSON in an object
            currentUser.setLevel(userProfile.getInt("level"));
            currentUser.setBirthDate((short)userProfile.getInt("birth_year"), (short)userProfile.getInt("birth_month"), (short)userProfile.getInt("birth_day"));
            currentUser.setEmail(userProfile.getString("email"));
            currentUser.setNickname(userProfile.getString("nickname"));
            currentUser.setCity(userProfile.getString("city"));
            currentUser.setAvatarLink(userProfile.getString("avatar"));

            JSONArray achievemnts = userProfile.getJSONArray("achievemnts");
            int s = achievemnts.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addAchievement(achievemnts.getInt(i));
            }

            currentUser.addFavoriteAuthor(userProfile.getInt("favourite_author_id_1"));
            currentUser.addFavoriteAuthor(userProfile.getInt("favourite_author_id_2"));
            currentUser.addFavoriteAuthor(userProfile.getInt("favourite_author_id_3"));

            JSONArray finishedBooks = userProfile.getJSONArray("finished");
            s = finishedBooks.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addFinishedBook(finishedBooks.getInt(i));
            }

            JSONArray readingBooks = userProfile.getJSONArray("reading");
            s = readingBooks.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addReadingBook(finishedBooks.getInt(i));
            }

            JSONArray wishlistBooks = userProfile.getJSONArray("wishlist");
            s = wishlistBooks.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addWishlistBook(finishedBooks.getInt(i));
            }

            JSONArray droppedBooks = userProfile.getJSONArray("dropped");
            s = droppedBooks.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addReadingBook(finishedBooks.getInt(i));
            }

            JSONArray onholdBooks = userProfile.getJSONArray("onhold");
            s = readingBooks.length();
            for(int i = 0; i < s; i++)
            {
                currentUser.addReadingBook(finishedBooks.getInt(i));
            }

            currentUser.addFavoriteBook(userProfile.getInt("favourite_book_id_1"));
            currentUser.addFavoriteBook(userProfile.getInt("favourite_book_id_2"));
            currentUser.addFavoriteBook(userProfile.getInt("favourite_book_id_3"));

            //TODO - Friends & Reviews will be done later

            currentUser.addFavoriteGenre(userProfile.getInt("favourite_genre_id_1"));
            currentUser.addFavoriteGenre(userProfile.getInt("favourite_genre_id_2"));
            currentUser.addFavoriteGenre(userProfile.getInt("favourite_genre_id_3"));

            currentUser.addFavoriteType(userProfile.getInt("favourite_type_id_1"));
            currentUser.addFavoriteType(userProfile.getInt("favourite_type_id_2"));
            currentUser.addFavoriteType(userProfile.getInt("favourite_type_id_3"));

            //TODO - Rank will be done later
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }



    //TODO - Friends will be done later
    //TODO - Achievements will be done later




}
