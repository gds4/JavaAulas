package arvoreGenealogica;

public class Filho extends Pessoa {
	private int qtdFilhos;
	
	
	public Filho(String nome, Pessoa ascendente) {
		super("Sr. " + nome, ascendente);
		this.qtdFilhos = 0;
	}
	
	@Override
	public Pessoa cadastrarFilho(String nome, char sexo) {
		Pessoa descendente = null;
		
		if(qtdFilhos == 1) {
			descendente = new Natimorto(nome, this);
		}else if (sexo == 'M' || sexo == 'm') {
			descendente = new Filho(nome,this);
		}else if (sexo == 'F' || sexo == 'f') {
			descendente = new Filha(nome, this);
		}
		this.qtdFilhos++;
		
		this.addDescendente(descendente);
		return descendente;
	}
	


}
