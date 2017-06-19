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
        if(isValidCheckOutRequest(title)){
            System.out.println("Thank you! Enjoy the book");
            removeFromLibrary(title);
        }
        else{
            System.out.println("That book is not available");
        }
    }

    public void checkIn(){
        String title = getTitle();
        if(isValidCheckInRequest(title)){
            System.out.println("Thank you for returning the book");
            returnToLibrary(title);
        }else{
            System.out.println("That is not a valid book to return");
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

    private boolean isValidCheckOutRequest(String title){
        ArrayList<String> titles = new ArrayList<String>();
        for (Book b : books){
            titles.add(b.getTitle());
        }
        return titles.contains(title);
    }

    private boolean isValidCheckInRequest(String title){
        ArrayList<String> titles = new ArrayList<String>();
        for (Book b : checkedOutBooks){
            titles.add(b.getTitle());
        }
        return titles.contains(title);
    }

    private void removeFromLibrary(String title) {
        for (Book b : new ArrayList<Book>(books)){
            if(b.getTitle().equals(title)){
                books.remove(b);
                checkedOutBooks.add(b);
            }
        }
    }

    private void returnToLibrary(String title) {
        for (Book b : new ArrayList<Book>(checkedOutBooks)){
            if(b.getTitle().equals(title)){
                checkedOutBooks.remove(b);
                books.add(b);
            }
        }
    }
}
