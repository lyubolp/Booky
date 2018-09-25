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
        ArrayListAlgorithms arrayListAlgorithms = new ArrayListAlgorithms();
        int bookIdInt = Integer.parseInt(bookId);

        Log.d("Test", bookId);

        JSONHandler js = new JSONHandler(loadJSONFromAsset(), QueryType.BookSingle);
        Log.d("JSON", loadJSONFromAsset());

        //@TODO This is temp code, when the API is finished, we will request full book info
        book = js.getSingleBook();



       TextView tv = (TextView)findViewById(R.id.bookTitleAuthor);
        tv.setText(book.getName() + " - " + book.getAuthors().get(0).getName());

       TextView tv2 = (TextView)findViewById(R.id.bookYearPublished);
        tv2.setText("Година на издаване - " + Integer.toString(book.getPublishYear()) + "г.");

       TextView tv3 = (TextView)findViewById(R.id.bookGenre);
        tv3.setText("Жанр - " + book.getGenres());

    }
    //@TODO - This is a temp function
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getResources().openRawResource(R.raw.get_book_by_id);
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
