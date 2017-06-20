package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp(){
        User user1 = new User(
                "123-4567",
                "banana",
                "giuseppe",
                "giuseppe@banana.com",
                "123456789");
        User user2 = new User(
                "789-4567",
                "strawberry",
                "daenerys",
                "daenerys@targaryen.com",
                "987654321");
        userManager = new UserManager();
        userManager.addUsers(user1, user2);
    }

    @Test
    public void canLogInUser(){
        assertEquals(
                true,
                userManager.logIn("789-4567", "strawberry")
        );
    }

    @Test
    public void cannotLogInUserWithInvalidLibraryNumber(){
        assertEquals(
                false,
                userManager.logIn("XXX-XXXX", "strawberry")
        );
    }

    @Test
    public void cannotLogInUserWithInvalidPassword(){
        assertEquals(
                false,
                userManager.logIn("789-4567", "apple")
        );
    }
}
