package arvoreGenealogica;


public class Natimorto extends Pessoa {
	public Natimorto(String nome, Pessoa ascendente) {
		super("Natimorto" + nome, ascendente);
	}
	
	@Override
	public Pessoa cadastrarFilho(String nome, char sexo) throws Exception {
		throw new Exception("Natimortos não podem cadastrar filhos.");
	}

	

}
