package com.projectlibrary.library;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.projectlibrary.library.User.Instance;

public class LibraryActivity extends AppCompatActivity {

    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    private TextView pagesText;
    private Button btnPrev, btnNext;
    public static ArrayList<Integer> books;
    int page = 1, maxPage = 3;

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

        loadBooks();
         maxPage = (Instance.getReading().size() / 9) + 1;
        pagesText = (TextView)findViewById(R.id.pagesNumber);
        pagesText.setText(page + "/" + maxPage);

        btnPrev = (Button)findViewById(R.id.buttonPrev);
        btnPrev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                if(page >= 2)
                {
                    page--;
                    pagesText.setText(page + "/" + maxPage);
                    loadBooks();
                }
            }
        });
        btnNext = (Button)findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                if(page < maxPage)
                {
                    page++;
                    pagesText.setText(page + "/" + maxPage);
                    loadBooks();
                }
            }
        });
        //Every event sends the id of the book object
        img1 = (ImageView)findViewById(R.id.book1); //Binding the objects to the views
        img1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img2 = (ImageView)findViewById(R.id.book2); //Binding the objects to the views
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img3 = (ImageView)findViewById(R.id.book3); //Binding the objects to the views
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img4 = (ImageView)findViewById(R.id.book4); //Binding the objects to the views
        img4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img5 = (ImageView)findViewById(R.id.book5); //Binding the objects to the views
        img5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img6 = (ImageView)findViewById(R.id.book6); //Binding the objects to the views
        img6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img7 = (ImageView)findViewById(R.id.book7); //Binding the objects to the views
        img7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img8 = (ImageView)findViewById(R.id.book8); //Binding the objects to the views
        img8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w) {
                clickEvent(w.getResources().getResourceName(w.getId()));
            }
        });

        img9 = (ImageView)findViewById(R.id.book9); //Binding the objects to the views
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
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(0)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book2":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(1)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book3":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(2)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book4":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(3)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book5":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(4)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book6":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(5)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book7":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(6)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book8":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(7)));
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book9":
                intent = new Intent(LibraryActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", String.valueOf(books.get(8)));
                startActivity(intent);
                break;
        }
    }
    void loadBooks()
    {
        try {
            String params[] = {"3", "0", "0", "0", "0", "0", "0", "0", "0", "0"}; //We must send an array to the Loader, with the 1st parameter being the QueryType

            if(page == maxPage)
            {
                int s = User.Instance.getReading().size() % 9;
                for(int i = 1; i < s; i++)
                {
                    params[i] = Integer.toString(User.Instance.getReading().get((i-1) + (page - 1)*9));
                }
            }
            else
            {
                for(int i = 1; i < 10; i++)
                {
                    params[i] = Integer.toString(User.Instance.getReading().get((i-1) + (page - 1)*9));
                }
            }

            String res = new JSONLoader().execute(params).get();
            if(res == "Failed")
            {
                //App crashes
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
