package cadastroFuncionarios;

import java.util.ArrayList;

public class Empresa {
	Chefe lider;
	
	public Empresa(Chefe lider) {
		super();
		this.lider = lider;
	}

	public String[] listaFuncionarios(){
		ArrayList<String> lista = new ArrayList<String>();
		lista.add(lider.getNome());
		lider.listSubordinados(lista);
		
		return lista.toArray(new String[lista.size()]);
	}
	
	public String[] listaChefes() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add(lider.getNome());
		lider.listChefesSubordinados(lista);
		
		return lista.toArray(new String[lista.size()]);
	}
	
	public Pessoa findFuncionario(String nome){
		if(lider.getNome().equals(nome)) {
			return (Pessoa) lider;
		}else {
			return lider.findSubordinado(nome);
		}
		
	}
}
