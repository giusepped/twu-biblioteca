package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public interface MenuOption {

    String name();

    String getCommand();

    void run(Library library);
}
