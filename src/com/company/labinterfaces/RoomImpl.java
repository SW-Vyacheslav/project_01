package com.company.labinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomImpl implements Room {
    private final int WINDOW_LIGHTNESS = 700;
    private final int MIN_ILLUMINATION = 300;
    private final int MAX_ILLUMINATION = 4000;
    private final int MAX_SQUARE;
    private String name;
    private int square;
    private int numOfWindows;
    private List<RoomObject> roomProps;

    private int totalIllumination;
    private int usedSquare;

    public RoomImpl(String name, int square, int numOfWindows) throws WrongIlluminationException {
        this.name = name;
        this.square = square;
        this.numOfWindows = numOfWindows;
        roomProps = new ArrayList<>();
        MAX_SQUARE = (int)(square * 0.7f);

        usedSquare = 0;
        totalIllumination = numOfWindows * WINDOW_LIGHTNESS;
        if (totalIllumination < MIN_ILLUMINATION || totalIllumination > MAX_ILLUMINATION)
            throw new WrongIlluminationException(name);
    }

    @Override
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

    @Override
    public void add(RoomObject roomObject) throws WrongSquareException, WrongIlluminationException
    {
        if (roomObject instanceof Luminosity) {
            int objectLum = ((Luminosity) roomObject).getLuminosity();
            int newTotalIllumination = objectLum + totalIllumination;
            if (newTotalIllumination > MAX_ILLUMINATION)
                throw new WrongIlluminationException(name);
            totalIllumination = newTotalIllumination;
            roomProps.add(roomObject);
        } else if (roomObject instanceof Square) {
            int objectSquare = ((Square) roomObject).getSquare();
            int newUsedSquare = usedSquare + objectSquare;
            if (newUsedSquare > MAX_SQUARE)
                throw new WrongSquareException(name);
            usedSquare = newUsedSquare;
            roomProps.add(roomObject);
        }
    }

    @Override
    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\t%s:", name));
        stringBuilder.append("\n\r");
        stringBuilder.append(String.format("\tIllumination: %d", totalIllumination));
        stringBuilder.append("\n\r");
        List<RoomObject> lights = roomProps.stream().filter(roomObject -> roomObject instanceof Luminosity).collect(Collectors.toList());
        for (RoomObject roomObject : lights) {
            stringBuilder.append(String.format("\t\t%s\n\r", roomObject.getInfo()));
        }
        stringBuilder.append(String.format("\tSquare: %d (Used square: %d)", square, usedSquare));
        stringBuilder.append("\n\r");
        List<RoomObject> squares = roomProps.stream().filter(roomObject -> roomObject instanceof Square).collect(Collectors.toList());
        for (RoomObject roomObject : squares) {
            stringBuilder.append(String.format("\t\t%s\n\r", roomObject.getInfo()));
        }
        return stringBuilder.toString();
    }
}
