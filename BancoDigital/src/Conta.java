public abstract class Conta {
    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Métodos abstratos
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void transferir(Conta destino, double valor);

    // Getters
    public double getSaldo() {
        return saldo;
    }
}
