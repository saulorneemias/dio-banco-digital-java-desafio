public class Transacao {
  private Conta origem;
  private Conta destino;
  private double valor;

  public Transacao(Conta origem, Conta destino, double valor) {
      this.origem = origem;
      this.destino = destino;
      this.valor = valor;
  }

  public void executar() {
      if (origem.getSaldo() >= valor) {
          origem.sacar(valor);
          destino.depositar(valor);
          System.out.println("Transferência realizada com sucesso.");
      } else {
          System.out.println("Saldo insuficiente para realizar a transferência.");
      }
  }
}
