package com.projectlibrary.library;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

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
    String JSONToHandle = null;
    JSONArray books;
    JSONObject userProfile;


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

    ArrayList<Book> getFavoriteBooks()
    {
        //Send request for favorite books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getReadingBooks()
    {
        //Send request for reading books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getWishlishBooks()
    {
        //Send request for wishlist books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getDroppedBooks()
    {
        //Send request for dropped books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getOnHoldBooks()
    {
        //Send request for onhold books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }
    ArrayList<Book> getFinishedBooks()
    {
        //Send request for finished books
        String json = "";
        return fillArrayListBooksBasicInfo(json);
    }

    ArrayList<Book> getAllBooks()
    {
        ArrayList<Book> result = new ArrayList<>();
        int s = books.length();

        for(int i = 0; i < s; i++)
        {
            try {
                JSONObject curBook = books.getJSONObject(i);

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

                short userRating = 0, userRereadValue = 0, userRereadCount = 0;
                String language = "", country = "", series = "", summary = "", userNote = "";
                ArrayList<String> authors = new ArrayList<>(), genres = new ArrayList<>(), types = new ArrayList<>();
                ArrayList<Review> reviews = new ArrayList<>();

                //TODO - Get the userRating, userRereadValue, userRereadCount, userNote, userStatus, language,
                //TODO - county_id, series_id, summary from the DB
                Book r = new Book(id,series_id, finished_count, reading_count,wishlist_count, dropped_count,
                        onhold_count, review_count, (short)chapters,(short)publish_year, (short)rating, userRating,
                        userRereadValue,userRereadCount, name_original,
                        name_bg, language, country, series, cover, summary,userNote,authors, genres, types, reviews );
                result.add(r);

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
                JSONObject curBook = books.getJSONObject(i);
                if(Integer.parseInt(curBook.getString("id")) == id)
                {
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

                    short userRating = 0, userRereadValue = 0, userRereadCount = 0;
                    String language = "", country = "", series = "", summary = "", userNote = "";
                    ArrayList<String> authors = new ArrayList<>(), genres = new ArrayList<>(), types = new ArrayList<>();
                    ArrayList<Review> reviews = new ArrayList<>();

                    //TODO - Get the userRating, userRereadValue, userRereadCount, userNote, userStatus, language,
                    //TODO - county_id, series_id, summary from the DB
                    Book r = new Book(id,series_id, finished_count, reading_count,wishlist_count, dropped_count,
                            onhold_count, review_count, (short)chapters,(short)publish_year, (short)rating, userRating,
                            userRereadValue,userRereadCount, name_original,
                            name_bg, language, country, series, cover, summary,userNote,authors, genres, types, reviews );
                    return r;
                }
            } catch (JSONException e) { //This is required, in case the JSON blows up
                e.printStackTrace();
            }
        }
        return result;
    }

    private void getUserProfile(String json)
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
            //currentUser.
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }


}
