package com.projectlibrary.library;

import java.util.ArrayList;

public class Series {

    private int ID;

    private short count;
    private short authorCount;

    private String nameOriginal;
    private String name;

    private ArrayList<Book> books;
    private ArrayList<Author> authors;

    Series()
    {

    }
    Series(int id, short count, short authorCount, String nameOriginal, String name, ArrayList<Book> books, ArrayList<Author> authors)
    {
        ID = id;
        this.count = count;
        this.authorCount = authorCount;
        this.nameOriginal = nameOriginal;
        this.name = name;
        this.books = books;
        this.authors = authors;
    }

    public int getID() {
        return ID;
    }

    public short getCount() {
        return count;
    }

    public short getAuthorCount() {
        return authorCount;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
}
