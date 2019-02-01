package com.projectlibrary.library;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class bookActivity extends AppCompatActivity {
    public static Book book;
    public static Author author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String bookId= getIntent().getStringExtra("OPENED_BOOK"); // The id of the book that should be opened
        String[] bookStates = getResources().getStringArray(R.array.bookState); //The book states (see Strings.xml)
        Spinner bookStatusDropdownObj = (Spinner)findViewById(R.id.bookStatusDropdown);

        //Code for loading the book states into the dropdown
        //android.R.layout.simple_spinner_dropdown_item - the way the dropdown works/looks
        //We need an array and an adapter in order to insert the array into the dropdown viewe

        ArrayAdapter<String> bookStatesAA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bookStates);
        bookStatesAA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bookStatusDropdownObj.setAdapter(bookStatesAA); //Sets the adapter





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
        tv.setText(book.getName() + " - " + author.getName());

       TextView tv2 = (TextView)findViewById(R.id.bookYearPublished);
        tv2.setText("Година на издаване - " + Integer.toString(book.getPublishYear()) + "г.");

       TextView tv3 = (TextView)findViewById(R.id.bookGenre);
        tv3.setText("Жанр - " + book.getGenres());

    }
}
