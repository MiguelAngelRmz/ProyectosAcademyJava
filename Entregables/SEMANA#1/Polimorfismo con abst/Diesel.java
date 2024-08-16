class Diesel extends Carro {
    private double capacidadTanque;

    public Diesel(int llantas, String color, int asientos, double capacidadTanque) {
        super(llantas, color, asientos);
        this.capacidadTanque = capacidadTanque;
    }

    @Override
    void encender() {
        System.out.println("El carro diésel enciende usando su motor diésel.");
    }

    @Override
    void imprimirCaracteristicasEspecificas() {
        System.out.println("Capacidad del Tanque: " + capacidadTanque + " litros");
    }
}
