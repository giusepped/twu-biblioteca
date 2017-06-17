package com.twu.biblioteca;

/**
 * Created by giuseppesmac on 17/06/17.
 */
public class CheckOutOption implements MenuOption{
    @Override
    public String name() {
        return "(C)heck out book";
    }

    @Override
    public String getCommand() {
        return "C";
    }

    @Override
    public void run(Library library) {
        library.checkOut();
    }
}
