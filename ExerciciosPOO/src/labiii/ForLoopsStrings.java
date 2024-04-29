package labiii;

public class ForLoopsStrings {
	
	public static void main(String[] args) {
		int inteiros[] = new int[5];
		int i = 0;
		while(i < inteiros.length) {
			inteiros[i] = (int)((Math.random()*100)+10);
			i++;
		}
		
		for(int j = 0; j < inteiros.length;j++) {
			System.out.println(inteiros[j]);
		}
		
		String nomes[] = {"Zé", "João", "Tonho"};
		
		for(int j = 0;j < nomes.length ;j++) {
			System.out.println(nomes[j]);
		}
		
		nomes[0]="Maria";
		
		for(int j = 0;j < nomes.length ;j++) {
			System.out.println(nomes[j]);
		}
	}
	

}
