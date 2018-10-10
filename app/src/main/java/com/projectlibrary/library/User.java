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

    public static User Instance = new User();

    private int ID;
    private int level; //The account level

    private short birthYear; //User birth year
    private short birthMonth; //User birth month
    private short birthDay; //User birth day

    private String email; //The email of the user (used for login also)
    private String nickname; //The nickname, visible to other users
    private String city; //City of the user
    private String avatarLink; //Link to the avatar

    private ArrayList<Integer> achievements; //The achievements of the user

    private ArrayList<Integer> favoriteAuthors; //The favourite authors of the user

    private ArrayList<Integer> finished; //Books that have been read
    private ArrayList<Integer> reading; //Books that are currently being read
    private ArrayList<Integer> wishlist; //Books that are in the users wishlist
    private ArrayList<Integer> dropped; //Books that have been dropped
    private ArrayList<Integer> onhold; //Books that have been put onhold
    private ArrayList<Integer> favoriteBooks; //The favourite books of the user

    private ArrayList<Integer> friends; //Friends list

    private ArrayList<Integer> reviews;

    private ArrayList<String> favoriteGenres; //The favorite genres of the user
    private ArrayList<String> favoriteTypes; //The favorite books types of the users

    private Rank rank;

    private ArrayListAlgorithms sorter = new ArrayListAlgorithms();


    public User() //Constructor
    {

    }
    public User(int id, int level, short birthYear, short birthMonth, short birthDay, String email, String nickname, String city, String avatarLink, ArrayList<Integer> achievements, ArrayList<Integer> favoriteAuthors, ArrayList<Integer> finished, ArrayList<Integer> reading, ArrayList<Integer> wishlist, ArrayList<Integer> dropped, ArrayList<Integer> onhold, ArrayList<Integer> favoriteBooks, ArrayList<Integer> friends, ArrayList<Integer> reviews, ArrayList<String> favoriteGenres, ArrayList<String> favoriteTypes, Rank rank)
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


    public void setAvatarLink(String AvatarLink)
    {
        avatarLink = AvatarLink;
    }
    public String getAvatarLink() {
        return avatarLink;
    }

    public ArrayList<Integer> getAchievements() {
        return achievements;
    }

    public ArrayList<Integer> getFavoriteAuthors() {
        return favoriteAuthors;
    }

    public ArrayList<Integer> getFinished() {
        return finished;
    }

    public ArrayList<Integer> getReading() {
        return reading;
    }

    public ArrayList<Integer> getWishlist() {
        return wishlist;
    }

    public ArrayList<Integer> getDropped() {
        return dropped;
    }

    public ArrayList<Integer> getOnhold() {
        return onhold;
    }

    public ArrayList<Integer> getFavoriteBooks() {
        return favoriteBooks;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public ArrayList<Integer> getReviews() {
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

    public void setReadingBooks(ArrayList<Integer> books)
    {
        reading = books;
    }





    //TODO - all methods below are not finished. The code that gets the info from the DB should be added
    public void addAchievement(int id)
    {
        //TODO - write the code that gets an achievement from the DB
    }
    public void addFinishedBook(int id)
    {
        finished.add(id); //Inserting the book to be added, so that the list remains sorted
    }
    public void removeFinishedBook(int id)
    {
        finished.remove(id);
    }

    public void addReadingBook(int id)
    {
        reading.add(id); //Inserting the book to be added, so that the list remains sorted
    }
    public void removeReadingBook(int id)
    {
        reading.add(id);
    }

    public void addWishlistBook(int id)
    {
        wishlist.add(id); //Inserting the book to be added, so that the list remains sorted
    }

    public void removeWishlistBook(int id)
    {
        wishlist.remove(id);
    }

    public void addDroppedBook(int id)
    {
        dropped.add(id); //Inserting the book to be added, so that the list remains sorted
    }

    public void removeDroppedBook(int id)
    {
        dropped.remove(id);
    }

    public void addOnholdBook(int id)
    {
        onhold.add(id); //Inserting the book to be added, so that the list remains sorted
    }

    public void removeOnholdBook(int id)
    {
        onhold.remove(id);
    }

    public void addFriend(int id)
    {
        friends.add(id);
    }

    public void removeFriend(int id)
    {
        friends.remove(id);
    }

    public void addFavoriteAuthor(int id)
    {
        favoriteAuthors.add(id);
    }

    public void removeFavoriteAuthor(int id)
    {
        favoriteAuthors.remove(id);
    }

    public void addFavoriteBook(int id)
    {
        favoriteBooks.add(id); //Inserting the book to be added, so that the list remains sorted

    }

    public void removeFavoriteBook(int id)
    {
        favoriteBooks.remove(id);
    }

    public void addFavoriteGenre(int id)
    {
        String genreName = "t"; //TODO - code here that gets the genre from the DB
        favoriteGenres.add(genreName);
    }

    public void removeFavoriteGenre(int id)
    {
        String genreName = "t"; //TODO - code here that gets the genre from the DB
        favoriteGenres.remove(genreName);
    }

    public void addFavoriteType(int id)
    {
        String typeName = "t"; //TODO - code here that gets the genre from the DB
        favoriteTypes.add(typeName);
    }
    public void removeFavoriteType(int id)
    {
        String typeName = "t"; //TODO - code here that gets the genre from the DB
        favoriteTypes.remove(typeName);
    }


}
