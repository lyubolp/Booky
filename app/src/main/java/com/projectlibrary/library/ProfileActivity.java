package com.projectlibrary.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView img1, img2, img3, img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


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
    }
    public void clickEvent(String a) {

        Intent intent;
        Log.d("TEST", a); //The id's are in such format com.projectlibrary.library:id/book1
        switch (a) {
            case "com.projectlibrary.library:id/book1":

                intent = new Intent(ProfileActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", "234");
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book2":
                intent = new Intent(ProfileActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", "352");
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book3":
                intent = new Intent(ProfileActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", "1122");
                startActivity(intent);
                break;
            case "com.projectlibrary.library:id/book4":
                intent = new Intent(ProfileActivity.this, bookActivity.class);
                intent.putExtra("OPENED_BOOK", "2102");
                startActivity(intent);
                break;

        }
    }
}
