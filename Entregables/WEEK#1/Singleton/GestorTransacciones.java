
public class GestorTransacciones {

    private static GestorTransacciones instancia;

    private GestorTransacciones() {
    }

    public static synchronized GestorTransacciones obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorTransacciones();
        }
        return instancia;
    }

    public void iniciarTransaccion(String idTransaccion, CuentaBancaria cuenta, double cantidad, String tipo) {
        System.out.println("Iniciando transacción [" + tipo + "] con ID: " + idTransaccion + " en la cuenta: " + cuenta.getNumeroCuenta());

        switch (tipo.toLowerCase()) {
            case "deposito":
                cuenta.depositar(cantidad);
                break;
            case "retiro":
                if (!cuenta.retirar(cantidad)) {
                    System.out.println("Error en la transacción: " + idTransaccion);
                }
                break;
            default:
                System.out.println("Tipo de transacción desconocido.");
        }
    }

    public void completarTransaccion(String idTransaccion) {
        System.out.println("Transacción completada con ID: " + idTransaccion);
    }
}
