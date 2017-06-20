package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class UserManager {
    private ArrayList<User> users;
    private User currentUser;

    public UserManager(){
        users = new ArrayList<User>();
    }

    public void addUsers(User... usersToAdd){
        for(User u : usersToAdd){
            users.add(u);
        }
    }

    public boolean logIn(String libraryNumber, String password){
        for(User u : users){
            if(u.authenticate(libraryNumber, password)) {
                currentUser = u;
                return true;
            }
        }
        return false;
    }
}
