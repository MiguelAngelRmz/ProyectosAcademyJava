package com.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VehicleBuilderTest {

    @Test
    public void testCarBuilder() {
        Car car = new Car.CarBuilder("V8", "Automatic")
                        .setColor("Red")
                        .setAudioSystem("Bose")
                        .setWheels("Alloy")
                        .build();

        assertEquals("V8", car.getEngine());
        assertEquals("Automatic", car.getTransmission());
        assertEquals("Red", car.toString().contains("Color=Red") ? "Red" : "");
        assertEquals("Bose", car.toString().contains("Audio System=Bose") ? "Bose" : "");
        assertEquals("Alloy", car.toString().contains("Wheels=Alloy") ? "Alloy" : "");
    }

    @Test
    public void testTruckBuilder() {
        Truck truck = new Truck.TruckBuilder("V6", "Manual")
                              .setCargoCapacity("15 Tons")
                              .build();

        assertEquals("V6", truck.getEngine());
        assertEquals("Manual", truck.getTransmission());
        assertEquals("15 Tons", truck.toString().contains("Cargo Capacity=15 Tons") ? "15 Tons" : "");
    }

    @Test
    public void testMotorcycleBuilder() {
        Motorcycle motorcycle = new Motorcycle.MotorcycleBuilder("V2", "Manual")
                                              .setType("Cruiser")
                                              .build();

        assertEquals("V2", motorcycle.getEngine());
        assertEquals("Manual", motorcycle.getTransmission());
        assertEquals("Cruiser", motorcycle.toString().contains("Type=Cruiser") ? "Cruiser" : "");
    }

    @Test
    public void testCarToString() {
        Car car = new Car.CarBuilder("V8", "Automatic")
                        .setColor("Red")
                        .setAudioSystem("Bose")
                        .setWheels("Alloy")
                        .build();

        String expected = "Car [Engine=V8, Transmission=Automatic, Color=Red, Audio System=Bose, Wheels=Alloy]";
        assertEquals(expected, car.toString());
    }
}
