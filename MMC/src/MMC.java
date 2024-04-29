import java.math.BigInteger;

public class MMC {
    // Função para calcular o MMC
    public static BigInteger calcularMMC(BigInteger a, BigInteger b) {
        BigInteger mdc = a.gcd(b); // Calcula o MDC
        return a.multiply(b).divide(mdc); // Calcula o MMC usando a fórmula MMC(a, b) = a*b / MDC(a, b)
    }

    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("12"); // Primeiro número
        BigInteger num2 = new BigInteger("18"); // Segundo número

        // Calcula e imprime o MMC
        BigInteger mmc = calcularMMC(num1, num2);
        System.out.println("MMC de " + num1 + " e " + num2 + " é: " + mmc);
    }
}