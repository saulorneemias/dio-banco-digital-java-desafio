import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public String getNome() {
        return nome;
    }

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Tipo de Conta: " + cliente.getConta().getClass().getSimpleName());
            System.out.println("Saldo: R$ " + cliente.getConta().getSaldo());
            System.out.println();
        }
    }
}
