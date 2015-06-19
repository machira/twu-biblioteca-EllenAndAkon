package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by machira on Jun/19/15.
 */
public class ListMoviesCommand implements Command{

    private Biblioteca biblioteca;

    public ListMoviesCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean execute() {
        return true;
    }
}
