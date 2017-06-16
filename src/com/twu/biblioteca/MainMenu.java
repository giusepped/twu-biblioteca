package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class MainMenu {

    private Library library;
    private ArrayList<MenuOption> options;

    public MainMenu(Library library, ArrayList<MenuOption> options){
        this.library = library;
        this.options = options;
    }

    public void showOptions(){
        System.out.println("Please choose an option (use the first letter):");
        for(MenuOption option : options){
            System.out.println(option.name());
        }
    }

    public void chooseOption(String userInput){
        for(MenuOption option : options){
            if(userInput.equals(option.getCommand())){
                option.run(library);
            }
        }
    }
}
