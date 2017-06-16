package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class Library {

    private ArrayList<Book> books;

    public Library(){
        this.books = new ArrayList<Book>();
    }

    public void addBooks(Book... booksToAdd){
        for(Book b : booksToAdd){
            books.add(b);
        }
    }

    public void list(){
        System.out.println("Here are the available books");
        System.out.println("Title   |   Author  |   Year of publication");
        for (Book b : books){
            System.out.println(b.getDetails());
        }
    }
}
