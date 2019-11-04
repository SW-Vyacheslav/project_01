package com.company.labinterfaces;

public class Light implements Luminosity, RoomObject {
    private int luminosity;

    public Light(int luminosity)
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
}
