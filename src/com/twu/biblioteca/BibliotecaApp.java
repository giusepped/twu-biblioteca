package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.run();
    }

    public void run(){
        WelcomeMessage message = new WelcomeMessage();
        Library library = new Library();
        Book b1 = new Book("The Aeneid");
        Book b2 = new Book("The House of the Spirits");
        library.addBooks(b1, b2);

        message.printMessage();
        library.list();

    }
}
