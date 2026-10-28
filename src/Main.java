import java.util.Scanner;


class Carro {
    private String nome;
    private double preco;


    public Carro(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Carro[] carros = new Carro[50];

        int quantidadeParaCadastrar = 0;


        while (true) {
            System.out.print("Quantos carros você deseja cadastrar? (Máximo 50): ");
            if (scanner.hasNextInt()) {
                quantidadeParaCadastrar = scanner.nextInt();
                scanner.nextLine();

                if (quantidadeParaCadastrar > 0 && quantidadeParaCadastrar <= 50) {
                    break;
                } else {
                    System.out.println("❌ Número inválido! O valor deve ser entre 1 e 50.");
                }
            } else {
                System.out.println("❌ Por favor, digite um número inteiro válido.");
                scanner.next();
            }
        }


        for (int i = 0; i < quantidadeParaCadastrar; i++) {
            System.out.println("\n--- Cadastro do Carro " + (i + 1) + " ---");

            System.out.print("Digite o nome/modelo do carro: ");
            String nome = scanner.nextLine();

            double preco = 0;
            while (true) {
                System.out.print("Digite o preço do carro (R$): ");
                if (scanner.hasNextDouble()) {
                    preco = scanner.nextDouble();
                    scanner.nextLine();
                    if (preco >= 0) {
                        break;
                    } else {
                        System.out.println("❌ O preço não pode ser negativo.");
                    }
                } else {
                    System.out.println("❌ Por favor, digite um valor numérico válido para o preço.");
                    scanner.next();
                }
            }


            carros[i] = new Carro(nome, preco);
        }


        scanner.close();


        System.out.println("\n========================================");
        System.out.println("           RESUMO DO CADASTRO           ");
        System.out.println("========================================");

        System.out.println("Lista de carros cadastrados:");
        double somaPrecos = 0.0;

        for (int i = 0; i < quantidadeParaCadastrar; i++) {
            System.out.printf("- %s (R$ %.2f)%n", carros[i].getNome(), carros[i].getPreco());
            somaPrecos += carros[i].getPreco();
        }

        System.out.println("----------------------------------------");
        System.out.println("Quantidade total de carros cadastrados: " + quantidadeParaCadastrar);
        System.out.printf("Soma total dos preços: R$ %.2f%n", somaPrecos);
        System.out.println("========================================");
    }
}
