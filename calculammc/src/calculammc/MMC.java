package calculammc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MMC {
    // Função para calcular o MDC
    public static BigInteger calcularMDC(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    // Função para calcular o MMC
    public static BigInteger calcularMMC(List<BigInteger> numeros) {
        BigInteger mmc = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            mmc = mmc.multiply(numeros.get(i)).divide(calcularMDC(mmc, numeros.get(i)));
        }
        return mmc;
    }

    public static void main(String[] args) {
        // Lista de números para calcular o MMC
        List<BigInteger> numeros = new ArrayList<>();
        numeros.add(new BigInteger("12"));
        numeros.add(new BigInteger("18"));
        numeros.add(new BigInteger("24"));

        // Calcula e imprime o MMC
        BigInteger mmc = calcularMMC(numeros);
        System.out.println("MMC dos números é: " + mmc);
    }
}