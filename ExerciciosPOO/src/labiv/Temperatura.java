package labiv;

public class Temperatura {
	private int quente;
	private int frio;
	
	public Temperatura() {
		this.quente = 40;
		this.frio = 10;
	}
	
	public void condicaoDeTemperatura(int temp_atual) {
		if(temp_atual < frio) {
			System.out.println("Extremamente frio!");
		}else if(temp_atual == frio) {
			System.out.println("Fazendo frio...");
		}else if(temp_atual == quente) {
			System.out.println("Fazendo calor...");
		}else if(temp_atual > quente) {
			System.out.println("Extremamente quente!");
		}else {
			System.out.println("Temperatura normal.");
		}
	}
}
