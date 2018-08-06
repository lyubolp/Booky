package com.projectlibrary.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class bookActivity extends AppCompatActivity {

    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String bookId= getIntent().getStringExtra("OPENED_BOOK");
        int bookIdInt = Integer.parseInt(bookId);

        //Log.d("JSON", "Trying to read local file..");
        //Log.d("JSON", loadJSONFromAsset());

        JSONHandler js = new JSONHandler(loadJSONFromAsset());
        book = js.getBookAt(bookIdInt);
        Log.d("Book", book.getOriginalName());
    }
    public String loadJSONFromAsset() {
        String json = "none";
        try {

            InputStream is = getResources().openRawResource(R.raw.test);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
