package labvi;
import java.time.LocalTime;

public class MusicStore {
	
	private String owner;
	private int openTime;
	private int closeTime;
	
	public MusicStore() {
		
		this.owner = "sem dono";
		this.openTime = 9;
		this.closeTime = 21;
		
	}
	
	public String toString() {
		return "MusicStore [Dono=" + owner + ", Abre=" + openTime + ", Fecha=" + closeTime + "]";
	}
	
	public void  setOwner(String owner) {

		this.owner = owner;
		
	}
	
	public void setOpen(int openTime) {
		
		this.openTime = openTime;
		
	}
	
	public void setClose(int closeTime) {

		this.closeTime = closeTime;
		
	}
	
	public String getOwner() {
		
		return this.owner;
		
	}
	
	public int getOpen() {
		
		return this.openTime;
		
	}
	
	public int getClose() {
		
		return this.closeTime;
		
	}
	
	 
	private boolean isOpen() {
		LocalTime abertura = LocalTime.of(openTime, 0,0);
		LocalTime fechamento = LocalTime.of(closeTime, 0,0);
		
		LocalTime horarioAtual = LocalTime.now();
		
		if(horarioAtual.isAfter(abertura) && horarioAtual.isBefore(fechamento)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void displayHoursOfOperation() {
		
		System.out.println("Periodo:");
		this.getOpenClosedMessage();
		System.out.println(this.toString());
		/*System.out.println("Segunda à Sexta, das " + openTime + ":00 - " + closeTime + ":00");
		System.out.println("\nPropriétário: " + getOwner());*/
	}
	
	private void getOpenClosedMessage() {
		if(this.isOpen()) {
			System.out.println("Estamos Abertos!");
		}else {
			System.out.println("Estamos Fechados!");
		}
	}
	
	public static void main(String[] args) {
		
		MusicStore testa_MS = new MusicStore();
		
		testa_MS.displayHoursOfOperation();
		
	}

	
}
