import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculadora {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("------------CALCULADORA STARK-------------");

        double numero1 = lerNumero(leitor, "Digite o primeiro número: ");
        String operacao = lerOperacao(leitor);
        double numero2 = lerNumero(leitor, "Digite o segundo número: ");

        double resultado = calcular(numero1, numero2, operacao);

        System.out.println("Resultado: " + resultado);

        leitor.close();
    }

    // Lê um número double, repetindo até ser válido
    public static double lerNumero(Scanner leitor, String mensagem) {
        double numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensagem);
                numero = leitor.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número do tipo double válido!");
                leitor.nextLine();
            }
        }

        return numero;
    }

    // Lê a operação desejada
    public static String lerOperacao(Scanner leitor) {
        System.out.print("Digite a operação (+, -, *, /, %): ");
        return leitor.next();
    }

    // Executa o cálculo com base na operação escolhida
    public static double calcular(double a, double b, String operacao) {
        switch (operacao) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                if (b == 0) {
                    System.out.println("Erro: divisão por zero!");
                    return 0;
                }
                return a / b;

            case "%":
                return (a * b) / 100;

            default:
                System.out.println("Operação inválida!");
                return 0;
        }
    }
}