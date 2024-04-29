package cadastroFuncionarios;

import java.util.ArrayList;

public abstract class Pessoa {
	private String nome;
	private Pessoa chefe;
	protected ArrayList<Pessoa> subordinados;
	private boolean grauInstrucao2grau;
	private boolean grauInstrucaoSuperior;
	
	public Pessoa(String nome, Pessoa chefe, boolean grauInstrucao2grau, boolean grauInstrucaoSuperior) {
		super();
		this.nome = nome;
		this.chefe = chefe;
		this.grauInstrucao2grau = grauInstrucao2grau;
		this.grauInstrucaoSuperior = grauInstrucaoSuperior;
		this.subordinados = new ArrayList<Pessoa>();
	}
	
	public abstract void listSubordinados(ArrayList<String> nomes) throws RuntimeException;
	
	public abstract Pessoa findSubordinado(String nome) throws RuntimeException;
	
	
	
	public void listSuperiores(ArrayList<String> superiores) {
		Pessoa p = this;
		while(p.chefe != null) {
			superiores.add(p.chefe.getNome());
			p = p.chefe;
		}
	}
 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getChefe() {
		return chefe;
	}

	public void setChefe(Pessoa chefe) {
		this.chefe = chefe;
	}

	public boolean isGrauInstrucao2grau() {
		return grauInstrucao2grau;
	}

	public void setGrauInstrucao2grau(boolean grauInstrucao2grau) {
		this.grauInstrucao2grau = grauInstrucao2grau;
	}

	public boolean isGrauInstrucaoSuperior() {
		return grauInstrucaoSuperior;
	}

	public void setGrauInstrucaoSuperior(boolean grauInstrucaoSuperior) {
		this.grauInstrucaoSuperior = grauInstrucaoSuperior;
	}


	
	
}
