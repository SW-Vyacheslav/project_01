package com.company.labinterfaces;

public class WrongSquareException extends Exception {
    public WrongSquareException(String roomName) {
        super(String.format("%s: Wrong square", roomName));
    }
}
