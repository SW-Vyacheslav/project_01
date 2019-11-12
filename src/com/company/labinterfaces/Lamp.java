package com.company.labinterfaces;

public class Lamp implements Luminosity, RoomObject {
    private int luminosity;

    public Lamp(int luminosity)
    {
        this.luminosity = luminosity;
    }

    @Override
    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }

    @Override
    public String getInfo() {
        return String.format("Lamp (Luminosity: %d)", luminosity);
    }
}
