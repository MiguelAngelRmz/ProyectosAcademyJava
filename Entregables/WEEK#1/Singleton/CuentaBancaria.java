public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
    }

    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente. Operación fallida.");
            return false;
        }
    }
}
