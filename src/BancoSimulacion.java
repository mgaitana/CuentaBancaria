class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo);
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo restante: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

public class BancoSimulacion {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500);

        try {
            cuenta.retirar(400); // Intenta retirar más de lo que hay
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
