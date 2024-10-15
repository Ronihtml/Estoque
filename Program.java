import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private static Map<String, Integer> estoque = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha



            switch (escolha) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    removerItem();
                    break;
                case 3:
                    atualizarQuantidade();
                    break;
                case 4:
                    exibirEstoque();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Controle de Estoque ===");
        System.out.println("1. Adicionar item");
        System.out.println("2. Remover item");
        System.out.println("3. Atualizar quantidade");
        System.out.println("4. Exibir estoque");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarItem() {
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        estoque.put(nome, quantidade);
        System.out.println("Item adicionado com sucesso.");
    }

    private static void removerItem() {
        System.out.print("Nome do item a remover: ");
        String nome = scanner.nextLine();
        if (estoque.remove(nome) != null) {
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    private static void atualizarQuantidade() {
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        if (estoque.containsKey(nome)) {
            System.out.print("Nova quantidade: ");
            int novaQuantidade = scanner.nextInt();
            estoque.put(nome, novaQuantidade);
            System.out.println("Quantidade atualizada com sucesso.");
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    private static void exibirEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("\n=== Estoque Atual ===");
            for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
