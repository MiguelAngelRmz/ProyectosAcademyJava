class GasolinaNormal extends Carro {
    private int cilindros;

    public GasolinaNormal(int llantas, String color, int asientos, int cilindros) {
        super(llantas, color, asientos);
        this.cilindros = cilindros;
    }

    @Override
    void encender() {
        System.out.println("El carro de gasolina normal enciende usando su motor de gasolina.");
    }

    @Override
    void imprimirCaracteristicasEspecificas() {
        System.out.println("Cilindros: " + cilindros);
    }
}