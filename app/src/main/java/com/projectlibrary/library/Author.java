package com.projectlibrary.library;

import java.util.ArrayList;

public class Author {

    private int id; //The id of the author

    private short bornYear; //The year the author is born
    private short diedYear; //The year the author has died (if not, its 0)
    private short bookCount; //The amount of books the author has written
    private short seriesCount; //The amount of series the author has written
    private short userRating; //The user rating of the author

    private String name; //The name of the author in the current language
    private String name_original; //The name of the author in his native language
    private String country; //The country of origin of the author
    private String penName; //The pen name of the author
    private String pictureLink; //The link to the author's picture

    Author() //Default constructor
    {
        id = -1;
        bornYear = -1;
        diedYear = -1;
        bookCount = 0;
        seriesCount = 0;
        userRating = 0;

        name = "Default author";
        name_original = "Le Default Authour";
        country = "Java";
        penName = "DA";
        pictureLink = "none";

    }

    Author(int ID, short bornYear, short diedYear, short bookCount, short seriesCount, short userRating, String name, String name_original, String country, String penName, String pictureLink)
    {
        id =  ID;
        this.bornYear = bornYear;
        this.diedYear = diedYear;
        this.bookCount = bookCount;
        this.seriesCount = seriesCount;
        this.userRating = userRating;
        this.name = name;
        this.name_original = name_original;
        this.country = country;
        this.penName = penName;
        this.pictureLink = pictureLink;
    }

    public short getBornYear() {
        return bornYear;
    }

    public short getDiedYear() {
        return diedYear;
    }

    public short getBookCount() {
        return bookCount;
    }

    public short getSeriesCount() {
        return seriesCount;
    }

    public short getUserRating() {
        return userRating;
    }

    public String getName() {
        return name;
    }

    public String getName_original() {
        return name_original;
    }

    public String getCountry() {
        return country;
    }

    public String getPenName() {
        return penName;
    }

    public String getPictureLink() {
        return pictureLink;
    }


    public int getID() {
        return id;
    }
}
