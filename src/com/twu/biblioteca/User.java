package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String number;

    public User(String libraryNumber,
                String password,
                String name,
                String email,
                String number){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public boolean authenticate(String libraryNumber, String password){
        return libraryNumber.equals(this.libraryNumber) &&
                password.equals(this.password);
    }

    public String getDetails(){
        String details = "name: " + name + "\n" +
                "email: " + email + "\n" +
                "number: " + number + "\n";
        return details;
    }
}
