package com.company.labinterfaces;

public class WrongIlluminationException extends Exception {
    public WrongIlluminationException(String roomName) {
        super(String.format("%s: Wrong illumination", roomName));
    }
}
