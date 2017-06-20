package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class MainMenu {

    private Library library;
    private ArrayList<MenuOption> options;

    public MainMenu(Library library){
        this.library = library;
        this.options = new ArrayList<MenuOption>();
    }


    public void addOptions(MenuOption... optionsToAdd){
        for(MenuOption o : optionsToAdd){
            options.add(o);
        }
    }

    public void showOptions(){
        System.out.println("Please choose an option (use the letter in parenthesis):");
        for(MenuOption option : options){
            System.out.println(option.name());
        }
    }

    public void chooseOption(String userInput){
        if(isValidOption(userInput)){
            System.out.println("Invalid option!");
        }else{
            for(MenuOption option : options){
                if(userInput.equals(option.getCommand())){
                    option.run(library);
                }
            }
        }
    }

    private boolean isValidOption(String userInput){
        return !validOptions().contains(userInput);
    }

    private ArrayList<String> validOptions(){
        ArrayList<String> validOptions = new ArrayList<String>();
        for(MenuOption option : options){
            validOptions.add(option.getCommand());
        }
        return validOptions;
    }
}
