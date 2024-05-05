package enums;

public enum BaseForca {
	BASE(51, 239,110,20),
	PILARVERTICAL(83,40,20,199),
	PILARHORIZONTAL(103,40,110,10),
	CORDA(201,50,201,65),
	FORCA(176,65,50,50);
	
	
	private int valor1;
	private int valor2;	
	private int valor3;	
	private int valor4;
	
	
	private BaseForca(int valor1, int valor2, int valor3, int valor4) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
	}
	
	public int getValor1() {
		
		return valor1;
	}
	
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public int getValor2() {
		return valor2;
	}
	
	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
	
	public int getValor3() {
		return valor3;
	}
	
	public void setValor3(int valor3) {
		this.valor3 = valor3;
	}
	
	public int getValor4() {
		return valor4;
	}
	
	public void setValor4(int valor4) {
		this.valor4 = valor4;
	}
	
	
	
	
	
}
