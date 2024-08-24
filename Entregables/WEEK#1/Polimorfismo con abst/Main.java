public class Main {

    public static void main(String[] args) {
        System.err.println("MAIN");

        Carro[] carros = new Carro[4];

        carros[0] = new hibrido(4, "Rojo", 4, "Motor Híbrido Paralelo");
        carros[1] = new FullElectrico(4, "Azul", 4, 400);
        carros[2] = new Diesel(4, "Negro", 4, 60.0);
        carros[3] = new GasolinaNormal(4, "Blanco", 4, 4);

        // Imprimir características de cada carro
        for (Carro carro : carros) {
            System.out.println("-------- Características del carro --------");
            carro.imprimirCaracteristicasComunes(); 
            carro.imprimirCaracteristicasEspecificas(); 
            carro.encender(); 
            System.out.println();
        }


    }
    
}
