package enums;

public enum BaseForca {
	BASE(101, 239,70,10);
	//PILARVERTICAL()
	
	
	private int valor_1;
	private int valor_2;	
	private int valor_3;	
	private int valor_4;
	
	
	private BaseForca(int valor_1, int valor_2, int valor_3, int valor_4) {
		this.valor_1 = valor_1;
		this.valor_2 = valor_2;
		this.valor_3 = valor_3;
		this.valor_4 = valor_4;
	}
	
	public int getValor_1() {
		
		return valor_1;
	}
	
	public void setValor_1(int valor_1) {
		this.valor_1 = valor_1;
	}
	public int getValor_2() {
		return valor_2;
	}
	
	public void setValor_2(int valor_2) {
		this.valor_2 = valor_2;
	}
	
	public int getValor_3() {
		return valor_3;
	}
	
	public void setValor_3(int valor_3) {
		this.valor_3 = valor_3;
	}
	
	public int getValor_4() {
		return valor_4;
	}
	
	public void setValor_4(int valor_4) {
		this.valor_4 = valor_4;
	}
	
	
	
	
	
}
