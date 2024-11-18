import java.util.ArrayList;
import java.util.Scanner;

class CarteiraDigital {
    private double saldo;
    private ArrayList<String> historicoTransacoes;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
            historicoTransacoes.add("Adição: + R$ " + valor);
            System.out.println("Saldo adicionado com sucesso!");
        } else {
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public void realizarPagamento(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            historicoTransacoes.add("Pagamento: - R$ " + valor);
            System.out.println("Pagamento realizado com sucesso!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        } else {
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public void historicoTransacoes() {
        System.out.println("Histórico de Transações:");
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (String transacao : historicoTransacoes) {
                System.out.println(transacao);
            }
        }
    }
}

public class Main {

    public static void menu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Ver Histórico de Transações");
        System.out.println("5 - Sair");
    }

    public static int lerEntradaUsuario(Scanner scanner) {
        System.out.print("Usuário: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteiraDigital carteira = new CarteiraDigital();

        System.out.println("Bem-vindo à sua Carteira Digital!");

        while (true) {
            menu();
            int opcao = lerEntradaUsuario(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para adicionar ao saldo: ");
                    double valorAdicionar = scanner.nextDouble();
                    carteira.adicionarSaldo(valorAdicionar);
                    break;

                case 2:
                    System.out.print("Digite o valor do pagamento: ");
                    double valorPagamento = scanner.nextDouble();
                    carteira.realizarPagamento(valorPagamento);
                    break;

                case 3:
                    System.out.println("Seu saldo atual é: R$ " + carteira.verificarSaldo());
                    break;

                case 4:
                    carteira.historicoTransacoes();
                    break;

                case 5:
                    System.out.println("Obrigado por usar a sua Carteira Digital!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}