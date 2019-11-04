package com.company.labinterfaces;

import java.util.List;

public class Room {
    private final int WINDOW_LIGHTNESS = 700;
    private final int MIN_ILLUMINATION = 300;
    private final int MAX_ILLUMINATION = 4000;
    private String name;
    private int square;
    private int numOfWindows;
    private List<RoomObject> roomProps;
    private int totalIllumination;

    public Room(String name, int square, int numOfWindows) throws WrongIlluminationException {
        this.name = name;
        this.square = square;
        this.numOfWindows = numOfWindows;

        totalIllumination = numOfWindows * WINDOW_LIGHTNESS;
        if (totalIllumination < MIN_ILLUMINATION || totalIllumination > MAX_ILLUMINATION)
            throw new WrongIlluminationException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNumOfWindows() {
        return numOfWindows;
    }

    public void setNumOfWindows(int numOfWindows) {
        this.numOfWindows = numOfWindows;
    }

    public void add(RoomObject roomObject) throws WrongSquareException, WrongIlluminationException
    {

    }
}
