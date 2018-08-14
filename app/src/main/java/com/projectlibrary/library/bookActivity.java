package com.projectlibrary.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

       /* TextView tv = (TextView)findViewById(R.id.bookTitleAuthor);
        tv.setText(book.getOriginalName() + " - " + book.getAuthor()); //Author is an int, when the DB is finished, will be a name

        tv = findViewById(R.id.bookYearPublished);
        tv.setText(book.getReleaseDate());

        tv = findViewById(R.id.bookGenre);
        tv.setText(book.getGenres());*/

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
