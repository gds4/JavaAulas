package enums;

public enum CorpoHumano {
	CABECA(186,83,30,30),
	//O tronco não esta com valores absolutos , pois quero fazer com que o corpo fosse padra de acordo com o tamanho da cabeça
	//falta modificar o resto 
	TRONCO(CABECA.getValor1() + ((int)( CABECA.getValor4() / 2)),CABECA.getValor2()+  CABECA.getValor4(),CABECA.getValor1() + ((int)( CABECA.getValor4() / 2)),CABECA.getValor2()+  CABECA.getValor4() + (CABECA.getValor4()*2 + (int)(CABECA.getValor4()/2))),
	BRACOESQUERDO(201,118,181,153),
	BRACODIREITO(201,118,221,153),
	PERNAESQUERDA(201,188,191,238),
	PERNADIREITA(201,188,211,238),
	FORCA(176,65,50,50);
	//CABECA.getvalor1() + ((int)( CABECA.getvalor4() / 2))
	private int valor1;
	private int valor2;
	private int valor3;
	private int valor4;
	
	
	
	private CorpoHumano(int valor1, int valor2, int valor3, int valor4) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
	}
	
	
	
	public int getValor1() {
		return valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public int getValor3() {
		return valor3;
	}

	public int getValor4() {
		return valor4;
	}

	
	
}
