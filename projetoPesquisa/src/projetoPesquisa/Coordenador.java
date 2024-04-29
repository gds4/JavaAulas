package projetoPesquisa;

import java.util.ArrayList;

public class Coordenador extends Pesquisador {

	public Coordenador(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
		this.setValorPago(this.calculaValorPago());
	}

	@Override
	public double calculaValorPago() {
		
		double valorPago = (double)300;
		for(int i = 0; i < pesquisadores.size(); i++ ) {
			valorPago *= 0.975;
		}
		return valorPago;
	}

	@Override
	public int getQtdSubordinados() {
		
		int qtdSubordinados = 0;
		for (Pesquisador p : pesquisadores) {
			qtdSubordinados += p.getQtdSubordinados() + 1;
		}
		return qtdSubordinados;
	}

	public Pesquisador findPesquisador(String nome) throws RuntimeException{
		if(this.getNome().equals(nome)) {
			return this;
		}
		Pesquisador q;
		for(Pesquisador p : pesquisadores) {
			if(p.getNome().equalsIgnoreCase(nome)) {
				return p;
			}else if(p instanceof Coordenador) {
				q = ((Coordenador) p).findPesquisador(nome);
				if(q != null) {
					return q;
				}
				continue;
			}else {
				continue;
			}
		}
		throw new RuntimeException();
		
	}
	
	public void listSubordinados(ArrayList<String> nomes) {
		
		for(Pesquisador p : pesquisadores) {
			
			if(p instanceof Coordenador) {
				nomes.add(p.getNome());
				((Coordenador) p).listSubordinados(nomes);
				
			}else {
				nomes.add(p.getNome());
			}
		}
	}
	
	public void listCoordSubordinados(ArrayList<String> nomes) {
	
		for(Pesquisador p : pesquisadores) {
			
			if(p instanceof Coordenador) {
				nomes.add(p.getNome());
				((Coordenador) p).listCoordSubordinados(nomes);
				
			}else {
				continue;
			}
		}
	}
	
}
