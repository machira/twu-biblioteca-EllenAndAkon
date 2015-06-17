package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    private BufferedReader reader;
    private Biblioteca biblioteca;
    private Menu menu;
    private PrintStream printStream;

    public BibliotecaApp(BufferedReader reader, PrintStream printStream, Biblioteca biblioteca, Menu menu) {
        this.reader = reader;
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.menu = menu;
    }

    public static void main(String[] args) {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(ir);
        PrintStream printStream = System.out;

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", "2000"));
        books.add(new Book("Twilight", "Stephanie Myers", "2000"));
        books.add(new Book("Native Son", "Richard Wright", "2000"));
        Biblioteca biblioteca = new Biblioteca(printStream, books);

        Menu menu = new Menu(System.out, biblioteca, reader);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(reader, printStream, biblioteca, menu);

        bibliotecaApp.start();
    }

    public void start() {

        printStream.println("Welcome to Biblioteca!");
        printStream.println("MAIN MENU");
        while (menu.stillAlive) {
            menu.displayMenu();
        }
        quit();

    }

    public boolean quit() {
        return true;
    }
}
