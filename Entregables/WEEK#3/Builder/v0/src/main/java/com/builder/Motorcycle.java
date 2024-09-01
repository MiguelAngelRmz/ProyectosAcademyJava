package com.builder;

public class Motorcycle extends Vehicle {
    
    // Optional parameters specific to Motorcycle
    private String type;

    private Motorcycle(MotorcycleBuilder builder) {
        super(builder.engine, builder.transmission);
        this.type = builder.type;
    }

    @Override
    public String toString() {
        return "Motorcycle [Engine=" + engine + ", Transmission=" + transmission +
               ", Type=" + type + "]";
    }

    public static class MotorcycleBuilder implements Builder<Motorcycle> {
        // Required parameters
        private String engine;
        private String transmission;

        // Optional parameters
        private String type;

        public MotorcycleBuilder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        public MotorcycleBuilder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public Motorcycle build() {
            return new Motorcycle(this);
        }
    }
}
