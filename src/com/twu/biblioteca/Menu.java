package com.twu.biblioteca;

import com.twu.biblioteca.Commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by angoh on 6/17/15.
 */
public class Menu {
    private Biblioteca biblioteca;
    private BufferedReader reader;
    private PrintStream printStream;
    private boolean stillAlive;

    public Menu(PrintStream printStream, Biblioteca biblioteca, BufferedReader reader){
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = reader;
        stillAlive = true;
    }


    public boolean isStillAlive() {
        return stillAlive;
    }

    public void displayMenu() {
        printStream.println("MAIN MENU");
        printStream.println("- List Books");
        printStream.println("- List Movies");
        printStream.println("- Checkout book [name]");
        printStream.println("- Return [book name]");
        printStream.println("- Quit");

        printStream.println("Enter your selection");
        try {
            String userSelection = reader.readLine();
            selectOption(userSelection);
        }
        catch (IOException e) {
            printStream.println(e.getMessage());
        }

    }

    public void selectOption(String selection) {
        selection = selection.toLowerCase();

        Map<String, Command> commandMap = new HashMap<>();

        commandMap.get(selection);
        if (selection.contains("list books")) {
            biblioteca.listBooks();
        }else if(selection.contains("list movies")){
            biblioteca.listMovies();
        } else if (selection.contains("checkout")){
            boolean checkout = biblioteca.isBookAvailable(selection.replace("checkout", "").trim());
            if(checkout) {
                printStream.println("Success! Enjoy your book.");
            }else{
                printStream.println("Could not check out book with that name.");
            }
        }
        else if (selection.contains("return")) {
            boolean bool = biblioteca.returnBookWithTitle(selection.replace("return", "").trim());
            if(bool){
                printStream.println("You have successfully returned this book");
            }else{
                printStream.println("Sorry, could not return that book.");
            }
        }
        else if (selection.contains("quit")) {
            stillAlive = false;
        }
        else{
            printStream.println("That's not a valid option");
            displayMenu();
        }
    }
}
