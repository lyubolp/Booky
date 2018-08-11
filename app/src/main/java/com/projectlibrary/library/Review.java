package com.projectlibrary.library;

public class Review {

    private int ID; //The ID of the review
    private int bookID; //The reviewed book's id
    private int userID; //The reviewers id
    private int languageID; //The id of the language

    private short rating; //The rating
    private short userRating; //User-rating

    private String language; //The language the review is in
    private String text; //The text of the review

    Review()
    {
        ID = -1;
        bookID = -1;
        userID = -1;
        languageID = -1;
        rating = 0;
        userRating = 0;
        language = "Default";
        text = "Default";
    }
    Review(int id, int bookID, int userID, int languageID, short rating, short userRating, String language, String text)
    {
        ID = id;
        this.bookID = bookID;
        this.userID = userID;
        this.languageID = languageID;
        this.rating = rating;
        this.userRating = userRating;
        this.language = language;
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public int getBookID() {
        return bookID;
    }

    public int getUserID() {
        return userID;
    }

    public int getLanguageID() {
        return languageID;
    }

    public short getRating() {
        return rating;
    }

    public short getUserRating() {
        return userRating;
    }

    public void setUserRating(short userRating) {
        this.userRating = userRating;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }
}
