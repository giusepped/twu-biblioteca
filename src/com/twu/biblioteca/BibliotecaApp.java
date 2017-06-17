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
        library.addBooks(b1, b2);
        return library;
    }

    private MainMenu setUpMenu(Library library){
        ListOption listOption = new ListOption();
        QuitOption quitOption = new QuitOption();
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        options.add(listOption);
        options.add(quitOption);
        return new MainMenu(library, options);
    }
}
