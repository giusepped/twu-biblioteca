package com.twu.biblioteca;

/**
 * Created by giuseppesmac on 17/06/17.
 */
public class QuitOption implements MenuOption{

    @Override
    public String name() {
        return "(Q)uit";
    }

    @Override
    public String getCommand() {
        return "Q";
    }

    @Override
    public void run(Library library) {
        System.exit(0);
    }
}
