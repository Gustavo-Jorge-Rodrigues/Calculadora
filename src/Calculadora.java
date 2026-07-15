import java.util.Scanner;

public class  Calculadora {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CALCULADORA DO EPSTEIN");

        System.out.print("Digite o primeiro número: ");
        double numero1 = leitor.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        String operacao = leitor.next();

        System.out.print("Digite o segundo número: ");
        double numero2 = leitor.nextDouble();

        double resultado = calcular(numero1, numero2, operacao);

        System.out.println("Resultado: " + resultado);

        leitor.close();
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