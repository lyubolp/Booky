package com.projectlibrary.library;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    int[] currentBooksIds = {1,2,3,4,5,6,7,8,9}; //The id's of the 9 books currently displayed to the user


    //Events for images clicked


    //Function that loads an image based on a URL (may be usefull in the future)
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        JSONHandler jsonHandler = new JSONHandler(loadJSONFromAsset(), QueryType.BookNine);

        ArrayList<Book> books = jsonHandler.getReadingBooks();


        User.Instance.setReadingBooks(books);

        Log.d("test", books.get(0).getName());
        for(int i = 0; i < 9; i++)
        {
            currentBooksIds[i] = books.get(i).getID();
            Log.d("BookId", "BookId" + i + " " + Integer.toString(books.get(i).getID()));
        }
        //Temporary code

        //Every event sends the id of the book object
        img1 = findViewById(R.id.book1); //Binding the objects to the views
        img1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img2 = findViewById(R.id.book2); //Binding the objects to the views
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img3 = findViewById(R.id.book3); //Binding the objects to the views
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img4 = findViewById(R.id.book4); //Binding the objects to the views
        img4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img5 = findViewById(R.id.book5); //Binding the objects to the views
        img5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img6 = findViewById(R.id.book6); //Binding the objects to the views
        img6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img7 = findViewById(R.id.book7); //Binding the objects to the views
        img7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img8 = findViewById(R.id.book8); //Binding the objects to the views
        img8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img9 = findViewById(R.id.book9); //Binding the objects to the views
        img9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });
    }

    public void clickEvent(String a) {

        Intent intent;
        Log.d("TEST", a); //The id's are in such format com.projectlibrary.library:id/book1
        switch (a) {
            case "com.projectlibrary.library:id/book1":

                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[0]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book2":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[1]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book3":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[2]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book4":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[3]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book5":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[4]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book6":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[5]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book7":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[6]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book8":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[7]));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book9":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(currentBooksIds[8]));
                startActivity(intent);
                break;
        }
    }
    //@TODO - This is a temp function
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getResources().openRawResource(R.raw.get_multiple_books_by_id);
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
