package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        options.forEach(option -> System.out.println(option.name()));
    }

    public void chooseOption(String userInput){
        if(!isValidOption(userInput)){
            System.out.println("Invalid option!");
        }else{
            MenuOption chosenOption = options.stream()
                    .filter(option -> userInput.equals(option.getCommand()))
                    .collect(Collectors.toList())
                    .get(0);
            chosenOption.run(library);
        }
    }

    private boolean isValidOption(String userInput){
        return options.stream().anyMatch(
                option -> userInput.equals(option.getCommand())
        );
    }
}
