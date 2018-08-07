package com.projectlibrary.library;

import java.util.Set;

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
    private String username;
    private String password; //Should be encrypted
    private String email;
    private String nickname;
    //A set for badges should be implemented
    private Set<Integer> readingBooks; //Currently reading
    private Set<Integer> suggestedBooks;
    private Set<Integer> favouritedBooks;
    private Set<Integer> readBooks; //Books that have been read
    private int accountLevel;
    private Rank permissionLevel;
    private Set<Integer> favouriteAuthors;

    User() //Constructor
    {
        ID = -1;
        username = "default";
    }


    public String GetUsername()
    {
        return username;
    }
    public boolean SetUsername(String Username)
    {
        username = Username;
        //Make the request to the server;
        return true;
    }

    public String GetPassword()
    {
        return password;
    }
    public boolean SetPassword(String Password)
    {
        password = Password;
        //Make the request to the server;
        return true;
    }

    public String GetEmail()
    {
        return email;
    }
    public boolean SetEmail(String Email)
    {
        email = Email;
        //Make the request to the server;
        return true;
    }

    public String GetNickname()
    {
        return nickname;
    }
    public boolean SetNickname(String Nickname)
    {
        nickname = Nickname;
        return true;
    }

    public Set<Integer> GetReadingBooks()
    {
        return readingBooks;
    }
    public void addBook(Book book)
    {
        readingBooks.add(book.getID());
    }
}
