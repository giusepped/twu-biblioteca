package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class User {

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean authenticate(String libraryNumber, String password){
        return libraryNumber == this.libraryNumber &&
                password == this.password;
    }
}
