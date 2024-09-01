package com.builder;

public class Car extends Vehicle {
    // Optional parameters specific to Car
    private String color;
    private String audioSystem;
    private String wheels;

    private Car(CarBuilder builder) {
        super(builder.engine, builder.transmission); // call the constructor
        this.color = builder.color;
        this.audioSystem = builder.audioSystem;
        this.wheels = builder.wheels;
    }

    @Override
    public String toString() {
        return "Car [Engine=" + engine + ", Transmission=" + transmission +
               ", Color=" + color + ", Audio System=" + audioSystem +
               ", Wheels=" + wheels + "]";
    }

    // CarBuilder implementing the Builder interface
    public static class CarBuilder implements Builder<Car> {
        // Required parameters
        private String engine;
        private String transmission;

        // Optional parameters
        private String color;
        private String audioSystem;
        private String wheels;

        public CarBuilder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setAudioSystem(String audioSystem) {
            this.audioSystem = audioSystem;
            return this;
        }

        public CarBuilder setWheels(String wheels) {
            this.wheels = wheels;
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }
}
