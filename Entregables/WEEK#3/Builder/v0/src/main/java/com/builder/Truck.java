package com.builder;

public class Truck extends Vehicle {
    
    // Optional parameters specific to Truck
    private String cargoCapacity;

    private Truck(TruckBuilder builder) {
        super(builder.engine, builder.transmission);
        this.cargoCapacity = builder.cargoCapacity;
    }

    @Override
    public String toString() {
        return "Truck [Engine=" + engine + ", Transmission=" + transmission +
               ", Cargo Capacity=" + cargoCapacity + "]";
    }

    public static class TruckBuilder implements Builder<Truck> {
        // Required parameters
        private String engine;
        private String transmission;

        // Optional parameters
        private String cargoCapacity;

        public TruckBuilder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        public TruckBuilder setCargoCapacity(String cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
            return this;
        }

        @Override
        public Truck build() {
            return new Truck(this);
        }
    }
}
