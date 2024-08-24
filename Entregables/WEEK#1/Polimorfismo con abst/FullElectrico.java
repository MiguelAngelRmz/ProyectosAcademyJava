class FullElectrico extends Carro {
    private int autonomia;

    public FullElectrico(int llantas, String color, int asientos, int autonomia) {
        super(llantas, color, asientos);
        this.autonomia = autonomia;
    }

    @Override
    void encender() {
        System.out.println("El carro completamente eléctrico enciende usando solo el motor eléctrico.");
    }

    @Override
    void imprimirCaracteristicasEspecificas() {
        System.out.println("Autonomía: " + autonomia + " km");
    }
}