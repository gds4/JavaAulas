package projetoPesquisa;

import java.util.ArrayList;

public class ProjetoPesquisa {
	
	Coordenador lider;
	
	public void cadastrarPesquisador(Pesquisador pesquisador, Pesquisador coordenador) {
		coordenador.addPesquisador(pesquisador);
		
		coordenador.setValorPago(coordenador.calculaValorPago());
		pesquisador.setValorPago(pesquisador.calculaValorPago());
		
	}
	
	public void setLider(Coordenador lider) {
		this.lider = lider;
	}
	
	public String[] listcoordenadores() {
		
		ArrayList<String> nomes = new ArrayList<String>(); 
		nomes.add(lider.getNome());
		lider.listCoordSubordinados(nomes);
		
		return nomes.toArray(new String[nomes.size()]);

	}
	
	public String[] listPesquisadores() {
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add(lider.getNome());
		lider.listSubordinados(nomes);
		
		return nomes.toArray(new String[nomes.size()]);
	}
	
	
}
