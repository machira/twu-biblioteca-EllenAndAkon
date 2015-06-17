package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by angoh on 6/17/15.
 */
public class Menu {
    private Biblioteca biblioteca;
    private BufferedReader reader;
    private PrintStream printStream;

    public Menu(PrintStream printStream, Biblioteca biblioteca, BufferedReader reader){
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = reader;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca!");
        printStream.println("MAIN MENU");
        displayMenu();
    }

    public void displayMenu() {
        printStream.println("- List Books\n");

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
        if (selection.toLowerCase().contains("list books")) {
            biblioteca.listBooks();
        }else{
            printStream.println("That's not a valid option");
            displayMenu();
        }
    }
}
