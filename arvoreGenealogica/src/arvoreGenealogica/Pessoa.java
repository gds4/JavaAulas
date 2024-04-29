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
	
	public abstract Pessoa cadastrarFilho(String nome,char sexo);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(this instanceof Filho) {
			this.nome = "Sr. " + nome;
		}else if(this instanceof Filha){
			this.nome = "Sra. " + nome;
		}else if(this instanceof Natimorto) {
			this.nome = "Natimorto " + nome;
		}
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
	
	
	public void ListarAscendentes() {
		Pessoa p = this;
		System.out.println(nome);

		while (p.ascendente != null) {
			System.out.println(p.ascendente.nome);
			p = p.ascendente;
		}
	}
	
	public void addDescendente(Pessoa descendente) {
		descendentes.add(descendente);
	}
	
	public Pessoa findDescendente(String nome) {
		for(Pessoa p : descendentes) {
			if(p.getNome().equalsIgnoreCase(nome)) {
				return p;
			}else {
				 Pessoa descendenteatual = p.findDescendente(nome);
		         if (descendenteatual != null) {
		              return descendenteatual;
		         }
			}
			
		}
		return null;
	}
}
