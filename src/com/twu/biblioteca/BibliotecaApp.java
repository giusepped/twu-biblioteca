package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.run();
    }

    public void run(){
        WelcomeMessage message = new WelcomeMessage();
        Library library = setUpLibrary();
        MainMenu menu = setUpMenu(library);

        message.printMessage();

        while(true){
            menu.showOptions();
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            menu.chooseOption(userInput);
        }
    }

    private Library setUpLibrary(){
        Library library = new Library();
        Book b1 = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        Book b2 = new Book("The House of the Spirits", "Isabel Allende", 1982);
        Movie m1 = new Movie(
                "The Incredibles",
                "Brad Bird",
                "10",
                2004);
        Movie m2 = new Movie(
                "The Matrix",
                "The Wachowskis",
                "10",
                1999);
        library.addItems(b1, b2, m1, m2);
        return library;
    }

    private MainMenu setUpMenu(Library library){
        ListBooksOption listBooksOption = new ListBooksOption();
        ListMoviesOption listMoviesOption = new ListMoviesOption();
        CheckOutOption checkOutOption = new CheckOutOption();
        CheckInOption checkInOption = new CheckInOption();
        QuitOption quitOption = new QuitOption();
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        options.add(listBooksOption);
        options.add(listMoviesOption);
        options.add(checkOutOption);
        options.add(checkInOption);
        options.add(quitOption);
        return new MainMenu(library, options);
    }
}
