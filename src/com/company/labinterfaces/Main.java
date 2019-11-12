package com.company.labinterfaces;

public class Main {

    public static void main(String[] args) {
	    Building building = new Building("Building 1");
	    try {
            building.addRoom("Room 1", 100, 3);
            building.addRoom("Room 2", 5, 50);
            building.getRoom("Room 1").add(new Lamp(150));
            building.getRoom("Room 1").add(new Lamp(250));
            building.getRoom("Room 1").add(new Table("Nice table", 3));
        }
	    catch (Exception e) {
            e.printStackTrace();
        }
        building.describe();
    }
}
