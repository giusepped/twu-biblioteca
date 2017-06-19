package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class CheckInOption implements MenuOption {
    @Override
    public String name() {
        return "(R)eturn book";
    }

    @Override
    public String getCommand() {
        return "R";
    }

    @Override
    public void run(Library library) {
        library.checkIn();
    }
}
