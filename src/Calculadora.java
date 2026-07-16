import java.util.Scanner;
import java.util.InputMismatchException;

public class  Calculadora {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CALCULADORA DO EPSTEIN");

        double numero1 = lerNumero(leitor, "Digite o primeiro número: ");

        System.out.print("Digite a operação (+, -, *, /): ");
        String operacao = leitor.next();

        double numero2 = lerNumero(leitor, "Digite o segundo número: ");

        double resultado = calcular(numero1, numero2, operacao);

        System.out.println("Resultado: " + resultado);

        leitor.close();
    }

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
            default:
                System.out.println("Operação inválida!");
                return 0;
        }
    }
}