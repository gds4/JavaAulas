package arvoreGenealogica;
import java.util.ArrayList;

public abstract class Pessoa {
	private String nome;
	private ArrayList<Pessoa> descendentes;
	private Pessoa ascendente;
	
	public Pessoa(String nome, Pessoa ascendente) {
		super();
		
		this.setNome(nome);
		this.descendentes = new ArrayList<Pessoa>();
		this.ascendente = ascendente;
	}
	
	
	public abstract Pessoa cadastrarFilho(String nome,char sexo) throws Exception;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getAscendente() {
		return ascendente;
	}

	public void setAscendente(Pessoa ascendente) {
		this.ascendente = ascendente;
	}
	
	public void ListarDescendentes(ArrayList<String> nomes) {
		for(Pessoa p : descendentes) {
			p.ListarDescendentes(nomes);
			nomes.add(p.nome);
			
		}
	}
	
	
	public void ListarAscendentes(ArrayList<String> nomes) {
		Pessoa p = this;
		
		while (p.ascendente != null) {
			nomes.add(p.ascendente.getNome());
			p = p.ascendente;
		}
	}
	
	public void addDescendente(Pessoa descendente) {
		descendentes.add(descendente);
	}
	
	public Pessoa findByName(String nome) {
		if(this.getNome().equals(nome)) {
			return this;
		}
		
		for(Pessoa p : descendentes) {
			if(p.getNome().equals(nome)) {
				return p;
			}else {
				 Pessoa descendenteatual = p.findByName(nome);
		         if (descendenteatual != null) {
		              return descendenteatual;
		         }
			}
		}
		return null;
	}
}
