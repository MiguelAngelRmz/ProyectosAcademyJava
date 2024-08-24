class Hibrido extends Carro {
    private String tipoMotorHibrido;

    public Hibrido(int llantas, String color, int asientos, String tipoMotorHibrido) {
        super(llantas, color, asientos);
        this.tipoMotorHibrido = tipoMotorHibrido;
    }

    @Override
    void encender() {
        System.out.println("El carro híbrido enciende combinando el motor eléctrico y de gasolina.");
    }

    @Override
    void imprimirCaracteristicasEspecificas() {
        System.out.println("Tipo de Motor Híbrido: " + tipoMotorHibrido);
    }
}