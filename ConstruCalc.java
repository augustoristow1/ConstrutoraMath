import java.util.Scanner;

public class ConstruCalc {

    static final double tamanho_da_porta = 0.90;
    static final double tamanho_da_janela = 2.0;

    static final double preco_tijolo = 50.0;
    static final double preco_do_concreto = 70.0;
    static final double preco_da_madeira = 100.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a largura do terreno (em metros): ");
        double larguraTerreno = sc.nextDouble();
        System.out.println("Informe o comprimento do terreno (em metros): ");
        double comprimentoTerreno = sc.nextDouble();

        double areaTerreno = calcularArea(larguraTerreno, comprimentoTerreno);

        System.out.println("Informe o número de cômodos: ");
        int comodos = sc.nextInt();

        double areaTotalComodos = 0;

        for (int i = 0; i < comodos; i++) {
            System.out.println("Informe a largura do cômodo " + (i + 1) + " (em metros): ");
            double larguraComodo = sc.nextDouble();
            System.out.println("Informe o comprimento do cômodo " + (i + 1) + " (em metros): ");
            double comprimentoComodo = sc.nextDouble();
            areaTotalComodos += calcularArea(larguraComodo, comprimentoComodo);
        }

        System.out.println("Informe o número total de portas: ");
        int portas = sc.nextInt();
        System.out.println("Informe o número total de janelas: ");
        int janelas = sc.nextInt();

        double areaPortasJanelas = calcularAreaPortasJanelas(portas, janelas);

        System.out.println("Escolha o material de construção (Tijolinho, Concreto, Madeira): ");
        sc.nextLine();  
        String materialEscolhido = sc.nextLine().trim().toLowerCase();
        double precoMaterial = escolherMaterial(materialEscolhido);

        double custoTotal = calcularCustoTotal(areaTotalComodos, areaPortasJanelas, precoMaterial);

        System.out.println("O custo total estimado da construção é: R$ " + custoTotal);
    }

    private static double calcularArea(double largura, double comprimento) {
        return largura * comprimento;
    }

    private static double calcularAreaPortasJanelas(int portas, int janelas) {
        return (portas * tamanho_da_porta) + (janelas * tamanho_da_janela);
    }

    private static double escolherMaterial(String material) {
        switch (material) {
            case "tijolinho":
                return preco_tijolo;
            case "concreto":
                return preco_do_concreto;
            case "madeira":
                return preco_da_madeira;
            default:
                throw new IllegalArgumentException("Opção de material inválida.");
        }
    }

    private static double calcularCustoTotal(double areaComodos, double areaPortasJanelas, double precoMaterial) {
        double areaConstruida = areaComodos - areaPortasJanelas;
        if (areaConstruida <= 0) {
            throw new IllegalArgumentException("Área construída não pode ser negativa ou zero.");
        }
        return areaConstruida * precoMaterial;
    }
}
