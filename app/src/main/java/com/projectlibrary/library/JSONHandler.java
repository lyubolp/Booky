package com.projectlibrary.library;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHandler {
    String JSONToHandle = null;
    JSONArray books;
    JSONHandler() //Default constructor, do not use !
    {
        JSONToHandle = "Default";
    }
    JSONHandler(String json)
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
    Book getBookAt(int id)
    {
        Book result = new Book();
        for(int i = 0; i < books.length(); i++)
        {
            try {
                JSONObject curBook = books.getJSONObject(i);
                if(Integer.parseInt(curBook.getString("id")) == id)
                {
                    result.setID(id);

                    result.setRead(Integer.parseInt(curBook.getString("finished")));
                    result.setReading(Integer.parseInt(curBook.getString("reading")));

                    result.setOriginalName(curBook.getString("name"));
                    result.setBgName(curBook.getString("namebg"));
                    result.setGenres(curBook.getString("genres"));
                    result.setChapters(Integer.parseInt(curBook.getString("chapters")));
                    result.setAuthor(Integer.parseInt(curBook.getString("author")));
                    result.setReleaseDate(curBook.getString("day") + "/" + curBook.getString("month") + "/" + curBook.getString("year"));


                }
            } catch (JSONException e) { //This is required, in case the JSON blows up
                e.printStackTrace();
            }
        }
        return result;
    }
}
