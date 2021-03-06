package com.projectlibrary.library;

import java.util.ArrayList;

/**
 * @author: Lyuboslav Karev
 * @version: 0.1
 * @since: 0.1
 */
public class Book {


    /**
     * Description of this class:
     *  This class is used to store information about the books.
     *  It has a lot of fields, which are related to the information about the book
     *  It also contains a enum BookStatus, which is signals the state that book is in for the current user
     *  As well as the user rating, user reread value, user reread count, user note
     *  All fields have getter methods
     *  The fields that are related to the user data (user rating, user status, etc.) also have setters
     *  It has four constructors - default, Book(id) -> make a book with only the id (not used), Book(small info) -> when we want to make a book with its "small info" (id, rating, cover)
     *      & Book (all fields)
     *
     */
    enum BookStatus
    {
        Reading,
        Finished,
        Wishlist,
        Dropped,
        Onhold
    }
    private int ID; //The ID of the book
    private int seriesID; //The series ID of the book
    private int finished; //The amount of users that have finished the book
    private int reading; //The amount of users reading the book
    private int wishlist; //The amount of users that have added the book to their wishlist
    private int dropped; //The amount of users that have dropped the book
    private int onhold; //The amount of users that have put the book onhold
    private int reviewsCount; //The amount of reviews made by the users

    private short chapters; //The amount of chapters
    private short publishYear; //The year that book was published
    private short rating; //The rating of the book

    private short userRating; //The rating of the book from the current user
    private short userRereadValue; //Rating the rereading value of a book
    private short userRereadCount; //Amount of times the user has reread the book

    private String nameOriginal; //The original name of the book
    private String name; //The name of the book in the current language
    private String language; //The language of the book
    private String country; //The country of origin of the book
    private String series; //The book series
    private String coverLink; //The link to the book cover
    private String summary; //The summary of the book
    private String userNote; //A note that the user gave the book


    private ArrayList<Integer> authors; //The authors of the book
    private String genres; //The genres of the book
    private ArrayList<String> types; //The book types
    private ArrayList<Review> reviews; //The book reviews

    private BookStatus userStatus;

    Book() //Constructor
    {

    }
    Book(int id)
    {

    }
    Book(int id, short Rating, String Cover, String Name)
    {
        //Constructor by id, which gets the info by its self from the DB
        ID = id;
        rating = Rating;
        coverLink = Cover;
        name = Name;
    }
    Book(int id, int seriesID, int finished, int reading, int wishlish, int dropped, int onhold, int reviewsCount, short chapters, short publishYear, short rating, short userRating, short userRereadValue, short userRereadCount, String nameOriginal, String name, String language, String country, String series, String coverLink, String summary, String userNote, ArrayList<Integer> authors, String genres, ArrayList<String> types, ArrayList<Review> reviews, BookStatus userStatus) //Gets the book based on its id
    {
        ID = id;
        this.seriesID = seriesID;
        this.finished = finished;
        this.reading = reading;
        this.wishlist = wishlish;
        this.dropped = dropped;
        this.onhold = onhold;
        this.reviewsCount = reviewsCount;
        this.chapters = chapters;
        this.publishYear = publishYear;
        this.rating = rating;
        this.userRating = userRating;
        this.userRereadValue = userRereadValue;
        this.userRereadCount = userRereadCount;
        this.nameOriginal = nameOriginal;
        this.name = name;
        this.language = language;
        this.country = country;
        this.series = series;
        this.coverLink = coverLink;
        this.summary = summary;
        this.userNote = userNote;
        this.authors = authors;
        this.genres = genres;
        this.types = types;
        this.reviews = reviews;
        this.userStatus = userStatus;
    }

    public int getID() {
        return ID;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public int getFinished() {
        return finished;
    }

    public int getReading() {
        return reading;
    }

    public int getWishlist() {
        return wishlist;
    }

    public int getDropped() {
        return dropped;
    }

    public int getOnhold() {
        return onhold;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public short getChapters() {
        return chapters;
    }

    public short getPublishYear() {
        return publishYear;
    }

    public short getRating() {
        return rating;
    }

    public short getUserRating() {
        return userRating;
    }

    public short getUserRereadValue() {
        return userRereadValue;
    }

    public short getUserRereadCount() {
        return userRereadCount;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getSeries() {
        return series;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public String getSummary() {
        return summary;
    }

    public String getUserNote() {
        return userNote;
    }

    public ArrayList<Integer> getAuthors() {
        return authors;
    }

    public String getGenres() {
        return genres;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void SetReviews(ArrayList<Review> reviews)
    {
        this.reviews = reviews;
    }

    public void SetUserRating(short UserRating)
    {
        userRating = UserRating;
    }

    public void SetUserNote(String UserNote)
    {
        userNote = UserNote;
    }

    public void SetUserRereadValue(short UserRereadValue)
    {
        userRereadValue = UserRereadValue;
    }

    public void SetUserRereadCount(short UserRereadCount)
    {
        userRereadCount = UserRereadCount;
    }

    public BookStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(BookStatus userStatus) {
        this.userStatus = userStatus;
    }
}
