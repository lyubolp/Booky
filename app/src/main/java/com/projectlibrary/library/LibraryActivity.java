package com.projectlibrary.library;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class LibraryActivity extends AppCompatActivity {

    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

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

    public void clickEvent(String a)
    {
        Log.d("TEST", a); //The id's are in such format com.projectlibrary.library:id/book1
        switch (a)
        {
            case "com.projectlibrary.library:id/book1":
                break;
            case "com.projectlibrary.library:id/book2":
                break;
            case "com.projectlibrary.library:id/book3":
                break;
            case "com.projectlibrary.library:id/book4":
                break;
            case "com.projectlibrary.library:id/book5":
                break;
            case "com.projectlibrary.library:id/book6":
                break;
            case "com.projectlibrary.library:id/book7":
                break;
            case "com.projectlibrary.library:id/book8":
                break;
            case "com.projectlibrary.library:id/book9":
                break;
        }
    }





}
