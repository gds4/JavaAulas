package exercicios;
import java.util.Arrays;
import java.util.List;

/*Segue a lista de exercícios Java 8+

Considerando a lista abaixo execute as seguintes operações usando as features do Java 8+ (não utilize: for/while/if)

    List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);

    01 . imprima todos os itens da lista no console
    02 . imprima os números distintos em ordem crescente
    03 . imprima os números impares  e distintos em ordem decrescente
    04. imprima a soma dos números ignorando os 3 primeiros
    05. imprima cada número da lista multiplicado por 2
    06. imprima de forma agrupada os números pares e impares distintos
    07. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException
    08. imprima apenas os 3 primeiros números da lista
    09. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN
    10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo
    11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente
*/

public class Q10 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
		System.out.println(
			numbers.stream()
			   .mapToInt(n->n)
			   .summaryStatistics()
		);
	}

}
