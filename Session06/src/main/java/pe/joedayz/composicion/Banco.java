package pe.joedayz.composicion;


import java.math.BigDecimal;

interface Retiro {
    BigDecimal retirar();
}

interface Deposito {
    void depositar(BigDecimal monto);
}

interface Autenticacion {
    void autenticar();
}

class Cuenta implements Retiro, Deposito {
    private BigDecimal saldo = new BigDecimal("100");

    @Override
    public BigDecimal retirar() {
        saldo = saldo.subtract(BigDecimal.TEN);
        return saldo;
    }

    @Override
    public void depositar(BigDecimal monto) {
        saldo = saldo.add(monto);
    }
}


class Seguridad implements Autenticacion {
    @Override
    public void autenticar() {
        IO.println("autenticado");
    }
}



public class Banco implements Retiro, Deposito, Autenticacion {

    private final Cuenta cuenta;
    private final Seguridad seguridad;

    public Banco(Cuenta cuenta, Seguridad seguridad) {
        this.cuenta = cuenta;
        this.seguridad = seguridad;
    }

    @Override
    public void autenticar() {
seguridad.autenticar();
    }

    @Override
    public void depositar(BigDecimal monto) {
        autenticar();
        cuenta.depositar(monto);
    }

    @Override
    public BigDecimal retirar() {
        autenticar();
        return cuenta.retirar();
    }

    static void main() {
        Banco banco = new Banco(new Cuenta(), new Seguridad());
        banco.depositar(new BigDecimal("50"));
        IO.println(banco.retirar());
    }
}
