package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class ListOption implements MenuOption{


    @Override
    public String name() {
        return "(L)ist books";
    }

    @Override
    public String getCommand() {
        return "L";
    }

    @Override
    public void run(Library library) {
        library.list();
    }
}
