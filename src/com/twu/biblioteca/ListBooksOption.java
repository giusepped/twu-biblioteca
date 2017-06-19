package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class ListBooksOption implements MenuOption{

    @Override
    public String name() {
        return "List (B)ooks";
    }

    @Override
    public String getCommand() {
        return "B";
    }

    @Override
    public void run(Library library) {
        library.listBooks();
    }
}
