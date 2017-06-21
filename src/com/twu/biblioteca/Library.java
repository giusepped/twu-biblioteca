package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class Library {

    private ArrayList<LibraryItem> items;
    private ArrayList<LibraryItem> checkedOutItems = new ArrayList<LibraryItem>();

    public Library(){
        this.items = new ArrayList<LibraryItem>();
    }

    public void addItems(LibraryItem... libraryItemsToAdd){
        for(LibraryItem item : libraryItemsToAdd){
            items.add(item);
        }
    }

    public void listBooks(){
        System.out.println("Here are the available books");
        System.out.println("Title   |   Author  |   Year of publication");
        for (LibraryItem item : books()){
            System.out.println(item.getDetails());
        }
    }

    public void listMovies(){
        System.out.println("Here are the available movies");
        System.out.println("Title   |   Director   |   Rating   |   Year of publication");
        for (LibraryItem item : movies()){
            System.out.println(item.getDetails());
        }
    }

    public void checkOut(){
        String title = getTitle();
        if(isValidCheckOutRequest(title)){
            System.out.println("Thank you! Enjoy the item");
            removeFromLibrary(title);
        }
        else{
            System.out.println("That item is not available");
        }
    }

    public void checkIn(){
        String title = getTitle();
        if(isValidCheckInRequest(title)){
            System.out.println("Thank you for returning the item");
            returnToLibrary(title);
        }else{
            System.out.println("That is not a valid item to return");
        }
    }


    public void listCheckedOut(){
        for (LibraryItem item : checkedOutItems){
            System.out.println(item.getDetails());
        }
    }

    private String getTitle(){
        System.out.println("Please enter the title of the item you want to borrow");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        return title;
    }

    private boolean isValidCheckOutRequest(String title){
        return items.stream().anyMatch(book -> book.getTitle().equals(title));
    }

    private boolean isValidCheckInRequest(String title){
        return checkedOutItems.stream().anyMatch(book -> book.getTitle().equals(title));
    }

    private void removeFromLibrary(String title) {
        for (LibraryItem item : new ArrayList<LibraryItem>(items)){
            if(item.getTitle().equals(title)){
                items.remove(item);
                checkedOutItems.add(item);
            }
        }
    }

    private void returnToLibrary(String title) {
        for (LibraryItem item : new ArrayList<LibraryItem>(checkedOutItems)){
            if(item.getTitle().equals(title)){
                checkedOutItems.remove(item);
                items.add(item);
            }
        }
    }

    private ArrayList<LibraryItem> books(){
        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        for(LibraryItem item : items){
            if(item instanceof Book){
                books.add(item);
            }
        }
        return books;
    }

    private ArrayList<LibraryItem> movies(){
        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        for(LibraryItem item : items){
            if(item instanceof Movie){
                movies.add(item);
            }
        }
        return movies;
    }
}
