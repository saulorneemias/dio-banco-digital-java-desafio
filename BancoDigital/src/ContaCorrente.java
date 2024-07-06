public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 0.05; // Taxa de saque de 5%

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor * (1 + TAXA_SAQUE);
        if (valorComTaxa <= saldo) {
            saldo -= valorComTaxa;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta destino, double valor) {
        sacar(valor); // Considerando que transferência de conta corrente para corrente tem taxa
        destino.depositar(valor);
    }
}
