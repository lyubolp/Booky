package com.projectlibrary.library;
/**
 * @author Lyuboslav Karev
 * @version 0.1
 * @since 0.1
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String JSONToHandle = null;
    private JSONArray books;
    private JSONObject userProfile;


    JSONHandler(String json) //Default constructor, do not use !
    {
        JSONToHandle = "Default";
        getBooks(json);
    }
    private void getBooks(String json)
    {
        JSONObject reader;
        try
        {
            reader = new JSONObject(json);

            books = reader.getJSONArray("Books"); //We get all books in the JSON in an array
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    private ArrayList<Book> fillArrayListBooksBasicInfo(String json)
    {
        getBooks(json);
        ArrayList<Book> result = new ArrayList<>();

        int s = books.length();

        for(int i = 0; i < s; i++) {
            try {
                JSONObject curBook = books.getJSONObject(i);

                int id = curBook.getInt("id");
                int rating = curBook.getInt("rating");
                String cover = curBook.getString("cover");
                String name_bg = curBook.getString("name_bg");


                Book r = new Book(id, (short) rating, cover, name_bg);
                result.add(r);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    private Book getBookFromJSONObject(JSONObject curBook)
    {
        Book r;
        try {
            int id = curBook.getInt("id");
            int chapters = curBook.getInt("chapters");
            int series_id = curBook.getInt("series_id");
            int publish_year = curBook.getInt("publish_year");
            int language_id = curBook.getInt("language_id");
            int country_id = curBook.getInt("country_id");
            int rating = curBook.getInt("rating");
            int rating_count = curBook.getInt("rating_count");
            int finished_count  = curBook.getInt("finished_count");
            int reading_count = curBook.getInt("reading_count");
            int wishlist_count = curBook.getInt("wishlist_count");
            int dropped_count = curBook.getInt("dropped_count");
            int onhold_count = curBook.getInt("onhold_count");
            int review_count = curBook.getInt("review_count");
            String cover = curBook.getString("cover");
            String name_original = curBook.getString("name_original");
            String name_bg = curBook.getString("name_bg");
            String name_en = curBook.getString("name_en");
            int author_count = curBook.getInt("author_count");

            short userRating = (short)curBook.getInt("rating");
            short userRereadValue = (short)curBook.getInt("reread_value");
            short userRereadCount = (short)curBook.getInt("reread_count");

            Book.BookStatus userStatus = Book.BookStatus.Reading;
            userStatus = Book.BookStatus.values()[curBook.getInt("status_id")];

            String language = "";
            String country = "", series = "", summary = "";
            String userNote = curBook.getString("note");

            ArrayList<String> authors = new ArrayList<>(), genres = new ArrayList<>(), types = new ArrayList<>();
            ArrayList<Review> reviews = new ArrayList<>();

            //TODO - Get the language, county_id, series_id, summary from the DB - They will be done after the API is done
            //TODO - authors, genres, types, reviews - same

            r = new Book(id,series_id, finished_count, reading_count,wishlist_count, dropped_count,
                    onhold_count, review_count, (short)chapters,(short)publish_year, (short)rating, userRating,
                    userRereadValue,userRereadCount, name_original,
                    name_bg, language, country, series, cover, summary,userNote,authors, genres, types, reviews, userStatus);

            return r;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        r =  new Book();
        return r;

    }

    ArrayList<Book> getFavoriteBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getReadingBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getWishlishBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getDroppedBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getOnHoldBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getFinishedBooks(String json)
    {
        return fillArrayListBooksBasicInfo(json);
    }

    ArrayList<Book> getAllBooks(String json)
    {
        getBooks(json);
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
