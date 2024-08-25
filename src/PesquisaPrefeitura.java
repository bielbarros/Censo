import java.util.Scanner;

public class PesquisaPrefeitura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double somaSalarios = 0;
        int somaFilhos = 0;
        int contadorHabitantes = 0;
        double maiorSalario = Double.NEGATIVE_INFINITY;
        int contadorMenor150 = 0;


        System.out.println("Entre com os dados dos habitantes (salário e número de filhos):");
        while (true) {
            System.out.print("Salário (digite um valor de salario negativo para encerrar): ");
            double salario = scanner.nextDouble();

            if (salario < 0) {
                break; // Encerra o loop se o salario for menor que zero
            }

            System.out.print("Número de filhos: ");
            int numFilhos = scanner.nextInt();

            // Atualiza os cálculos
            somaSalarios += salario;
            somaFilhos += numFilhos;
            contadorHabitantes++;

            // Verifica o maior salário
            if (salario > maiorSalario) {
                maiorSalario = salario;
            }

            // Conta habitantes com salário menor que R$ 150,00
            if (salario < 150.0) {
                contadorMenor150++;
            }
        }

        // Verifica se houve habitantes para evitar divisão por zero
        if (contadorHabitantes > 0) {
            // Calcula médias
            double mediaSalarios = somaSalarios / contadorHabitantes;
            double mediaFilhos = (double) somaFilhos / contadorHabitantes;

            // Calcula percentual de pessoas com salário menor que R$ 150,00
            double percentualMenor150 = (double) contadorMenor150 / contadorHabitantes * 100.0;

            // Exibe os resultados
            System.out.println("\nResultados da pesquisa:");
            System.out.printf("Média de salário da população: R$ %.2f\n", mediaSalarios);
            System.out.printf("Média do número de filhos: %.2f\n", mediaFilhos);
            System.out.printf("Maior salário dos habitantes: R$ %.2f\n", maiorSalario);
            System.out.printf("Percentual de pessoas com salário menor que R$ 150,00: %.2f%%\n", percentualMenor150);
        } else {
            System.out.println("Nenhum habitante encontrado.");
        }

        scanner.close();
    }
}
