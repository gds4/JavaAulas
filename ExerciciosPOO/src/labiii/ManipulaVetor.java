package labiii;

import java.util.Random;

public class ManipulaVetor {
	int vetor[];
	
	public ManipulaVetor() {
		this.vetor = new int[10];
	}
	
	public void preencheVetor() {
		for(int i = 0; i < this.vetor.length;i++) {
			Random numAleatorio = new Random();
			this.vetor[i] = numAleatorio.nextInt(101);
		}
	}
	
	public void ordenaVetor() {
		for(int i = 0 ; i < vetor.length;i++) {
			for(int j = i+1 ; j < vetor.length;j++ ) {
				if(vetor[i]> vetor[j]) {
					int aux = vetor[j]; 
					vetor[j] = vetor[i];
					vetor[i] = aux;
				}
					
			}
		}
	}
	
	
}
