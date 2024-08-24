import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        CuentaBancaria cuenta = null;
        GestorTransacciones gestor = GestorTransacciones.obtenerInstancia();

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Apertura de cuenta");
            System.out.println("2. Depósito");
            System.out.println("3. Retiro");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    String numeroCuenta = "00" + (1000000 + random.nextInt(9000000));
                    System.out.print("Ingresa el saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    cuenta = new CuentaBancaria(numeroCuenta, saldoInicial);
                    System.out.println("Cuenta creada exitosamente. Número de cuenta: " + cuenta.getNumeroCuenta() + ". Saldo inicial: $" + saldoInicial);
                    break;

                case 2:
                    if (cuenta == null) {
                        System.out.println("Primero debes abrir una cuenta.");
                    } else {
                        System.out.print("Ingresa la cantidad a depositar: ");
                        double cantidadDeposito = scanner.nextDouble();
                        String idDeposito = "TX" + (1000 + random.nextInt(9000));
                        gestor.iniciarTransaccion(idDeposito, cuenta, cantidadDeposito, "deposito");
                        gestor.completarTransaccion(idDeposito);
                    }
                    break;

                case 3:
                    if (cuenta == null) {
                        System.out.println("Primero debes abrir una cuenta.");
                    } else {
                        System.out.print("Ingresa la cantidad a retirar: ");
                        double cantidadRetiro = scanner.nextDouble();
                        String idRetiro = "TX" + (1000 + random.nextInt(9000));
                        gestor.iniciarTransaccion(idRetiro, cuenta, cantidadRetiro, "retiro");
                        gestor.completarTransaccion(idRetiro);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
