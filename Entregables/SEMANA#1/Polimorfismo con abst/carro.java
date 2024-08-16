abstract class Carro {
    private int llantas;
    private String color;
    private int asientos;

    // Constructor para inicializar las características comunes
    public Carro(int llantas, String color, int asientos) {
        this.llantas = llantas;
        this.color = color;
        this.asientos = asientos;
    }

    // Método abstracto para encender
    abstract void encender();

    // Método para imprimir características comunes
    public void imprimirCaracteristicasComunes() {
        System.out.println("Llantas: " + llantas);
        System.out.println("Color: " + color);
        System.out.println("Asientos: " + asientos);
    }

    
    abstract void imprimirCaracteristicasEspecificas();
}