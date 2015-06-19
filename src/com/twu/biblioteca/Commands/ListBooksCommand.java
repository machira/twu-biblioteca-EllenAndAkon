package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by machira on Jun/19/15.
 */
public class ListBooksCommand implements Command {

    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public boolean execute(){
        biblioteca.listBooks();
        return true;
    }
}
