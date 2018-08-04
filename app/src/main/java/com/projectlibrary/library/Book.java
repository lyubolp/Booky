package com.projectlibrary.library;

public class Book {

    private boolean approved; //If the book has been approved

    private int ID; //The ID of the book
    private int rank; //The user-ranking of the book
    private int read; //The amount of users that have read the book ?
    private int favourited; //The amount of users that have favourited the book
    private int reading; //The amount of user reading the book
    private int author; //The author id
    private int chapters; //The amount of chapters

    private float rating; //The user-rating of the book

    private String originalName; //The original name of the book
    private String bgName; //The name of the book in Bulgarian
    private String genres; //The genres of the book
    private String releaseDate; //Release date of the book


    //Set<int> reviews;

    Book() //Constructor
    {
        ID = -1;
        rating = -1;
        rank = 0;
        read = 0;
        favourited = 0;
        reading = 0;
        author = -1;
        chapters = 0;

        originalName = "Default book";
        bgName = "Книга по подразбиране";
        genres = "None";
        releaseDate = "20/09/1998";

        approved = true;
    }
    Book(int id) //Gets the book based on its id
    {
        //We will load the info from the local JSON file for the books
        //TODO - This method will be finished when the JSON stuff is ready
    }

    //Get & set
    int getID()
    {
        return ID;
    }
    void setID(int id)
    {
        ID = id;
    }

    float getRating()
    {
        return rating;
    }
    void setRating(float ratingU)
    {
        rating = ratingU;
    }

    int getRank()
    {
        return rank;
    }
    void setRank(int rankU)
    {
        rank = rankU;
    }

    int getRead()
    {
        return read;
    }
    void setRead(int readU)
    {
        read = readU;
    }

    int getFavourited()
    {
        return favourited;
    }
    void setFavourited(int favouritedU)
    {
        favouritedU = favourited;
    }

    int getReading()
    {
        return reading;
    }
    void setReading(int readingU)
    {
        reading = readingU;
    }

    int getAuthor()
    {
        return author;
    }
    void setAuthor(int authorU)
    {
        author = authorU;
    }

    int getChapters()
    {
        return chapters;
    }
    void setChapters(int chaptersU)
    {
        chapters = chaptersU;
    }

    String getOriginalName()
    {
        return originalName;
    }
    void setOriginalName(String originalNameU)
    {
        originalName = originalNameU;
    }

    String getBgName()
    {
        return bgName;
    }
    void setBgName(String bgNameU)
    {
        bgNameU = bgName;
    }

    String getGenres()
    {
        return genres;
    }
    void setGenres(String genresU)
    {
        genres = genresU;
    }

    String getReleaseDate()
    {
        return releaseDate;
    }
    void setReleaseDate(String releaseDateU)
    {
        releaseDate = releaseDateU;
    }

    boolean getApproved()
    {
        return approved;
    }
    void setApproved(boolean approvedU)
    {
        approved = approvedU;
    }
}
