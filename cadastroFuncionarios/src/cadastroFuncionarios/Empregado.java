package cadastroFuncionarios;

import java.util.ArrayList;

public class Empregado extends Pessoa{


	public Empregado(String nome, Pessoa chefe, boolean grauInstrucao2grau, boolean grauInstrucaoSuperior) {
		super(nome, chefe, grauInstrucao2grau, grauInstrucaoSuperior);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void listSubordinados(ArrayList<String> nomes) throws RuntimeException {
		throw new RuntimeException("Empregados não possuem subordinados");
	}

	@Override
	public Pessoa findSubordinado(String nome) {
		throw new RuntimeException("Empregados não possuem subordinados");
	}

	
}