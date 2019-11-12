package com.company.labinterfaces;

public class Table implements Square, RoomObject {
    private int square;
    private String name;

    public Table(String name, int square)
    {
        this.square = square;
        this.name = name;
    }

    @Override
    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return String.format("%s (Square: %d)", name, square);
    }
}
