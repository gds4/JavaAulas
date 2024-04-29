package cadastroFuncionarios;

import java.util.ArrayList;

public class Chefe extends Pessoa{



	public Chefe(String nome, Pessoa chefe, boolean grauInstrucao2grau, boolean grauInstrucaoSuperior) {
		super(nome, chefe, grauInstrucao2grau, grauInstrucaoSuperior);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void listSubordinados(ArrayList<String> nomes) throws RuntimeException {
		for (Pessoa p : this.subordinados) {
			nomes.add(p.getNome());
			if (p instanceof Chefe) {
				p.listSubordinados(nomes);
			}
		}
		
	}

	@Override
	public Pessoa findSubordinado(String nome) {
		
		for (Pessoa p : subordinados) {
			if(p.getNome().equals(nome)) {
				return p;
			}
			if (p instanceof Chefe) {
				Pessoa q = p.findSubordinado(nome);
				if(q != null) {
					return q;
				}
			}
		}
		return null;
	}

	public void listChefesSubordinados(ArrayList<String> chefesSubordinados){
		
		for (Pessoa p : subordinados) {
			
			if (p instanceof Chefe) {
				chefesSubordinados.add(p.getNome());
				((Chefe) p).listChefesSubordinados(chefesSubordinados);
				
			}
		}
	}
	
	public void addEmpregado(Pessoa p) {
		this.subordinados.add(p);
	}
}
