package com.builder;

public class VehicleConfiguration {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("V8", "Automatic")
                        .setColor("Red")
                        .setAudioSystem("Bose")
                        .setWheels("Alloy")
                        .build();

        System.out.println(car);

        Truck truck = new Truck.TruckBuilder("V6", "Manual")
                              .setCargoCapacity("3000 k")
                              .build();

        System.out.println(truck);

        Motorcycle motorcycle = new Motorcycle.MotorcycleBuilder("V2", "Manual")
                                              .setType("Cruiser")
                                              .build();

        System.out.println(motorcycle);
    }
}
