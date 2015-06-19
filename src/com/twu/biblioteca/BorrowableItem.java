package com.twu.biblioteca;

/**
 * Created by machira on Jun/19/15.
 */
public interface BorrowableItem {
    boolean isCheckedOut();
    boolean checkout();
    boolean checkIn();
}
