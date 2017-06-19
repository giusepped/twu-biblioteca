package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class ListMoviesOption implements MenuOption{
    @Override
    public String name() {
        return "List (M)ovies";
    }

    @Override
    public String getCommand() {
        return "M";
    }

    @Override
    public void run(Library library) {
        library.listMovies();
    }
}
