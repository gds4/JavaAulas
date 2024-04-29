package earliest_Deadline_First;
import java.util.Random;
public class Processo {
	
	private double deadline;
	private double periodo;
	private double prioridade;
	private double qtdRepeticoes;
	
	
	public void setPeriodo() {
		Random rd = new Random();
		int periodo = rd.nextInt(8,15);
		this.periodo = periodo;
	}
	
	
	public setDeadline() {
		
	}
}
