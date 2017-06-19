package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class Movie implements LibraryItem {

    private String title;
    private String director;
    private String rating;
    private int yearOfPublication;

    public Movie(String title,
                 String director,
                 String rating,
                 int yearOfPublication){

        this.title = title;
        this.director = director;
        this.rating = rating;
        this.yearOfPublication = yearOfPublication;

    }


    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        String details = this.title + " | " +
                this.director + " | " +
                this.rating + " | " +
                this.yearOfPublication;
        return details;
    }
}
