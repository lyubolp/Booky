package com.projectlibrary.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Console;
import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    public static User currentUser = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);


        playGround();


        NavigationView navigationView = findViewById(R.id.nav_view);
        //This whole snippet of code handles the slide menu click event
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        //menuItem is the menu item that is selected
                        /*TODO - there is probably a better way to get the text that was clicked
                          but for now, menuItem.toString() works
                        */
                        switch (menuItem.toString())
                        {
                            case "Библиотека":
                                /*new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Log.d("TEST", "1");

                                    }
                                };*/
                                //startActivity(new Intent(MainActivity.this, library.class));
                                Intent intent = new Intent(MainActivity.this, LibraryActivity.class);

                                startActivity(intent);

                                //case R.string.library; //TODO - When I try to access the string in values/string.xml, it shows them as integer... so yeah...
                                break;
                        }
                        Log.d("TEST",menuItem.toString());

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Test
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void playGround() //Testing some stuff
    {
        ArrayList<Book> books = new ArrayList<>();

        Book b1 = new Book(1);
        Book b2 = new Book(7);
        Book b3 = new Book(5);
        Book b4 = new Book(2);
        Book b5 = new Book(9);
        Book b6 = new Book(12);
        Book b7 = new Book(6);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);




        ArrayListAlgorithms ae = new ArrayListAlgorithms();

        ae.bookSortById(books);

        ae.bookInsertById(books, b7);

        String t2 = Integer.toString(ae.bookFind(books, b7));
        Log.d("Test", t2);


    }
}
