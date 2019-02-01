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


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);


        playGround(); //Test code is executed here


        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
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
                            case "Профил":
                                Intent intentProfile = new Intent(MainActivity.this, ProfileActivity.class);
                                startActivity(intentProfile);

                                break;
                            case "Библиотека":
                                //startActivity(new Intent(MainActivity.this, library.class));
                                Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
                                startActivity(intent);
                                //case R.string.library; //TODO - When I try to access the string in values/string.xml, it shows them as integer... so yeah...
                                break;
                            case "Debug":
                                Intent intentDebug = new Intent(MainActivity.this, DeveloperPanel.class);
                                startActivity(intentDebug);
                                break;
                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
        mDrawerLayout.setDrawerListener(
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

    /**
     * THIS IS TESTING CODE, WILL BE CLEANED UP
     */
    public void playGround() //Testing some stuff
    {
        //TEST CODE FOR USER PROFILE
        User.Instance.setNickname("Любослав Карев");
        ArrayList<Integer> test = new ArrayList<>();

        for(int i = 1; i < 21; i++)
        {
            test.add(i*17 + i*5);
        }
        User.Instance.setReadingBooks(test);


    }
    public static void fillUserWithBooks(String json)
    {
        JSONHandler jsonHandler = new JSONHandler(json, QueryType.BookNine);
        ArrayList<Integer> books = jsonHandler.getReadingBooks();
        User.Instance.setReadingBooks(books);
    }
}
