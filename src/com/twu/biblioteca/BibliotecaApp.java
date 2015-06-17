package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", "2000"));
        books.add(new Book("Twilight", "Stephanie Myers", "2000"));
        books.add(new Book("Native Son", "Richard Wright", "2000"));
        Biblioteca biblioteca = new Biblioteca(System.out,  books);

        biblioteca.start();
    }
}
