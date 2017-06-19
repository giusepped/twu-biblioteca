package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by giuseppedesantis on 19/06/2017.
 */
public class UserTest {

    private User user;

    @Before
    public void setUpUser(){
        user = new User("123-4567", "banana");
    }

    @Test
    public void canAuthenticateWithValidCredentials(){
        assertEquals(
                true,
                user.authenticate(
                        "123-4567",
                        "banana"
                )
        );
    }

    @Test
    public void cannotAuthenticateWithIncorrectPassword(){
        assertEquals(
                false,
                user.authenticate(
                        "123-4567",
                        "strawberry"
                )
        );
    }

    @Test
    public void canAuthenticateWithCorrectPassword(){
        assertEquals(
                false,
                user.authenticate(
                        "123-9076",
                        "banana"
                )
        );
    }
}
