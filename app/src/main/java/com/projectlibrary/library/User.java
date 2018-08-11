package com.projectlibrary.library;

import java.util.ArrayList;

public class User {

    enum Rank
    {
        Admin,
        Mod,
        Author,
        BookWizard,
        Reader,
        Rookie
    }

    private int ID;
    private int level; //The account level

    private short birthYear; //User birth year
    private short birthMonth; //User birth month
    private short birthDay; //User birth day

    private String email; //The email of the user (used for login also)
    private String nickname; //The nickname, visible to other users
    private String city; //City of the user
    private String avatarLink; //Link to the avatar

    private ArrayList<Achievement> achievements; //The achievements of the user

    private ArrayList<Author> favoriteAuthors; //The favourite authors of the user

    private ArrayList<Book> finished; //Books that have been read
    private ArrayList<Book> reading; //Books that are currently being read
    private ArrayList<Book> wishlist; //Books that are in the users wishlist
    private ArrayList<Book> dropped; //Books that have been dropped
    private ArrayList<Book> onhold; //Books that have been put onhold
    private ArrayList<Book> favoriteBooks; //The favourite books of the user

    private ArrayList<Friend> friends; //Friends list

    private ArrayList<Review> reviews;

    private ArrayList<String> favoriteGenres; //The favorite genres of the user
    private ArrayList<String> favoriteTypes; //The favorite books types of the users

    private Rank rank;

    User() //Constructor
    {

    }
    User(int id, int level, short birthYear, short birthMonth, short birthDay, String email, String nickname, String city, String avatarLink, ArrayList<Achievement> achievements, ArrayList<Author> favoriteAuthors, ArrayList<Book> finished, ArrayList<Book> reading, ArrayList<Book> wishlist, ArrayList<Book> dropped, ArrayList<Book> onhold, ArrayList<Book> favoriteBooks, ArrayList<Friend> friends, ArrayList<Review> reviews, ArrayList<String> favoriteGenres, ArrayList<String> favoriteTypes, Rank rank)
    {
        ID = id;
        this.level = level;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.email = email;
        this.nickname = nickname;
        this.city = city;
        this.avatarLink = avatarLink;
        this.achievements = achievements;
        this.favoriteAuthors = favoriteAuthors;
        this.finished = finished;
        this.reading = reading;
        this.wishlist = wishlist;
        this.dropped = dropped;
        this.onhold = onhold;
        this.favoriteBooks = favoriteBooks;
        this.friends = friends;
        this.reviews = reviews;
        this.favoriteGenres = favoriteGenres;
        this.favoriteTypes = favoriteTypes;
        this.rank = rank;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getID() {
        return ID;
    }

    public String getEmail()
    {
        return email;
    }
    public boolean setEmail(String Email)
    {
        email = Email;
        //Make the request to the server;
        return true;
    }

    public String getNickname()
    {
        return nickname;
    }
    public boolean setNickname(String Nickname)
    {
        nickname = Nickname;
        return true;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public ArrayList<Author> getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public ArrayList<Book> getFinished() {
        return finished;
    }

    public ArrayList<Book> getReading() {
        return reading;
    }

    public ArrayList<Book> getWishlist() {
        return wishlist;
    }

    public ArrayList<Book> getDropped() {
        return dropped;
    }

    public ArrayList<Book> getOnhold() {
        return onhold;
    }

    public ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public ArrayList<String> getFavoriteTypes() {
        return favoriteTypes;
    }

    public Rank getRank() {
        return rank;
    }

    public String getBirthDate()
    {
        return birthDay + "/" + birthMonth + "/" + birthYear;
    }

    public void setBirthDate(short y, short m, short d)
    {
        birthYear = y;
        birthMonth =  m;
        birthDay = d;
    }

    //TODO - all methods below are not finished. The code that gets the info from the DB should be added
    //TODO - also, sort & search should be done too
    public void addAchievement(int id)
    {
        //TODO - write the code that gets an achievement from the DB
    }
    public void addFinishedBook(int id)
    {
        Book temp = new Book(id);
        finished.add(temp);
    }
    public void removeFinishedBook(int id)
    {
        //TODO - as the rest
    }

    public void addReadingBook(int id)
    {

    }
    public void removeReadingBook(int id)
    {

    }

    public void addWishlistBook(int id)
    {

    }

    public void removeWishlistBook(int id)
    {

    }

    public void addDroppedBook(int id)
    {

    }

    public void removeDroppedBook(int id)
    {

    }

    public void addOnholdBook(int id)
    {

    }

    public void removeOnholdBook(int id)
    {

    }

    public void addFriend(int id)
    {
        //Friend temp = new Friend(id);
        //friends.add(temp);
    }

    public void removeFriend(int id)
    {

    }

    public void addFavoriteAuthor(int id)
    {

    }

    public void removeFavoriteAuthor(int id)
    {

    }

    public void addFavoriteBook(int id)
    {
        Book temp = new Book(id);
        favoriteBooks.add(temp);


    }

    public void removeFavoriteBook(int id)
    {

    }

    public void addFavoriteGenre(int id)
    {

    }

    public void removeFavoriteGenre(int id)
    {

    }

    public void addFavoriteType(int id)
    {

    }
    public void removeFavoriteType(int id)
    {

    }


}
