package com.projectlibrary.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class bookActivity extends AppCompatActivity {
    public static Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String bookId= getIntent().getStringExtra("OPENED_BOOK");

        Log.d("TestCon", "Book id " + bookId);
        try {
            String res = new JSONLoader().execute("4", bookId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("TestCon", "Code after Async task");


        TextView tv = (TextView)findViewById(R.id.bookTitleAuthor);
        tv.setText(book.getName());

       TextView tv2 = (TextView)findViewById(R.id.bookYearPublished);
        tv2.setText("Година на издаване - " + Integer.toString(book.getPublishYear()) + "г.");

       TextView tv3 = (TextView)findViewById(R.id.bookGenre);
        tv3.setText("Жанр - " + book.getGenres());

    }
}
