package com.company.labinterfaces;

import java.util.List;

public class Building {
    private String name;
    private List<Room> rooms;

    public Building(String name)
    {
        name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(String name, int square, int numOfWindows) throws WrongIlluminationException {
        for (Room room: rooms) {
            if (room.getName().equals(name)) return;
        }

        Room newRoom = new Room(name, square, numOfWindows);
        rooms.add(newRoom);
    }

    public Room getRoom(String name)
    {
        for (Room room: rooms) {
            if (room.getName().equals(name)) return room;
        }

        return null;
    }

    public void describe()
    {

    }
}
