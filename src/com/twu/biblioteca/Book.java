package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class Book implements LibraryItem{

    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication){
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle(){
        return title;
    }

    public String getDetails(){
        String details = title + " | " + author + " | " + yearOfPublication ;
        return details;
    }
}
