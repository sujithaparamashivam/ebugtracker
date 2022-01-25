package com.ebugtracker.staff.exceptions;

public class InvalidBugAssignation extends RuntimeException {
    public InvalidBugAssignation(String msg) {
        super(msg);
    }
}