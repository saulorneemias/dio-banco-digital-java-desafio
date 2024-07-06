import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando o banco
        System.out.print("Digite o nome do banco: ");
        String nomeBanco = scanner.nextLine();
        Banco banco = new Banco(nomeBanco);

        // Cadastro do cliente 1
        System.out.println("\n=== Cadastro do Cliente 1 ===");
        System.out.print("Nome: ");
        String nomeCliente1 = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfCliente1 = scanner.nextLine();
        System.out.print("Tipo de conta (Corrente/Poupanca): ");
        String tipoConta1 = scanner.nextLine();
        System.out.print("Depósito inicial: ");
        double depositoInicial1 = scanner.nextDouble();

        Conta contaCliente1;
        if (tipoConta1.equalsIgnoreCase("corrente")) {
            contaCliente1 = new ContaCorrente(depositoInicial1);
        } else if (tipoConta1.equalsIgnoreCase("poupanca")) {
            System.out.print("Taxa de rendimento da poupança: ");
            double taxaRendimento1 = scanner.nextDouble();
            contaCliente1 = new ContaPoupanca(depositoInicial1, taxaRendimento1);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        Cliente cliente1 = new Cliente(nomeCliente1, cpfCliente1, contaCliente1);
        banco.adicionarCliente(cliente1);

        // Cadastro do cliente 2
        System.out.println("\n=== Cadastro do Cliente 2 ===");
        System.out.print("Nome: ");
        scanner.nextLine(); // Limpar o buffer do scanner
        String nomeCliente2 = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfCliente2 = scanner.nextLine();
        System.out.print("Tipo de conta (Corrente/Poupanca): ");
        String tipoConta2 = scanner.nextLine();
        System.out.print("Depósito inicial: ");
        double depositoInicial2 = scanner.nextDouble();

        Conta contaCliente2;
        if (tipoConta2.equalsIgnoreCase("corrente")) {
            contaCliente2 = new ContaCorrente(depositoInicial2);
        } else if (tipoConta2.equalsIgnoreCase("poupanca")) {
            System.out.print("Taxa de rendimento da poupança: ");
            double taxaRendimento2 = scanner.nextDouble();
            contaCliente2 = new ContaPoupanca(depositoInicial2, taxaRendimento2);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        Cliente cliente2 = new Cliente(nomeCliente2, cpfCliente2, contaCliente2);
        banco.adicionarCliente(cliente2);

        // Realizar operações adicionais (depósitos e transferências)
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Operações adicionais ===");
            System.out.println("1. Fazer depósito para o Cliente 1");
            System.out.println("2. Fazer depósito para o Cliente 2");
            System.out.println("3. Fazer transferência do Cliente 1 para o Cliente 2");
            System.out.println("4. Fazer transferência do Cliente 2 para o Cliente 1");
            System.out.println("5. Encerrar");

            System.out.print("Escolha uma operação (1-5): ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito para o Cliente 1: ");
                    double valorDeposito1 = scanner.nextDouble();
                    cliente1.getConta().depositar(valorDeposito1);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Valor do depósito para o Cliente 2: ");
                    double valorDeposito2 = scanner.nextDouble();
                    cliente2.getConta().depositar(valorDeposito2);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 3:
                    System.out.print("Valor da transferência do Cliente 1 para o Cliente 2: ");
                    double valorTransferencia1 = scanner.nextDouble();
                    cliente1.getConta().transferir(cliente2.getConta(), valorTransferencia1);
                    System.out.println("Transferência realizada com sucesso.");
                    break;
                case 4:
                    System.out.print("Valor da transferência do Cliente 2 para o Cliente 1: ");
                    double valorTransferencia2 = scanner.nextDouble();
                    cliente2.getConta().transferir(cliente1.getConta(), valorTransferencia2);
                    System.out.println("Transferência realizada com sucesso.");
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        // Listar contas cadastradas no banco
        System.out.println("\n=== Contas cadastradas no banco " + banco.getNome() + " ===");
        banco.listarClientes();

        scanner.close();
    }
}
