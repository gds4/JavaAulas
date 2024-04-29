package arvoreGenealogica;

import javax.swing.JOptionPane;

public class Natimorto extends Pessoa {
	public Natimorto(String nome, Pessoa ascendente) {
		super(nome, ascendente);
	}
	
	@Override
	public Pessoa cadastrarFilho(String nome, char sexo) {
		JOptionPane.showMessageDialog(null, "Filhos Natimortos não podem cadastrar novos filhos");
		System.out.println("Filhos Natimortos não podem cadastrar novos filhos");
		return null;
	}

	

}
