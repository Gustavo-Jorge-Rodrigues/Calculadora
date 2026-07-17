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

    // Lê a operação desejada, repetindo até ser uma das 5 válidas
    public static String lerOperacao(Scanner leitor) {
        String operacao = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a operação (+, -, *, /, %): ");
                operacao = leitor.next();
                validarOperacao(operacao);
                entradaValida = true;
            } catch (OperacaoInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        return operacao;
    }

    // Verifica se a operação é uma das 5 permitidas, senão lança a exceção
    public static void validarOperacao(String operacao) throws OperacaoInvalidaException {
        switch (operacao) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return;
            default:
                throw new OperacaoInvalidaException("Erro: operação inválida! Use apenas +, -, *, / ou %.");
        }
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
                return 0; // nunca deve acontecer, pois já validámos antes
        }
    }
}

// Exceção personalizada para operações inválidas
class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}