package com.company.labinterfaces;

public interface Room {
    String getInfo();
    String getName();
    void add(RoomObject roomObject) throws WrongSquareException, WrongIlluminationException;
}
