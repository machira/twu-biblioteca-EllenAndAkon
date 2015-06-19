package com.twu.biblioteca;

/**
 * Created by machira on Jun/19/15.
 */
public class Movie implements BorrowableItem {

    private int year;
    private String director;
    private int movieRating;

    public Movie(String name, int year, String director, int movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.checkedOut = false;
    }


    public String toString() {
        return String.format("%-20s %-20d %-20s %-20d\n", name, year, director, movieRating);
    }

    boolean checkedOut;
    String name;

    @Override
    public boolean isCheckedOut(){
        return checkedOut;
    }

    @Override
    public boolean checkout(){
        if(!checkedOut){
            checkedOut = true;
            return checkedOut;
        }
        return false;
    }

    @Override
    public boolean checkIn() {
        if (isCheckedOut()) {
            checkedOut = false;
            return true;
        }
        return false;
    }
}
