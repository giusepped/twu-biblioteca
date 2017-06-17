package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class Library {

    private ArrayList<Book> books;
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

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

    public void checkOut(){
        String title = getTitle();
        for (Book b : new ArrayList<Book>(books)){
            if(b.getTitle().equals(title)){
                books.remove(b);
                checkedOutBooks.add(b);
            }
        }
    }

    public void listCheckedOut(){
        for (Book b : checkedOutBooks){
            System.out.println(b.getDetails());
        }
    }

    private String getTitle(){
        System.out.println("Please enter the title of the book");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        return title;
    }
}
