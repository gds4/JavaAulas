package arvoreGenealogica;
import java.util.Random;
public class Filha extends Pessoa {

	
	public Filha(String nome, Pessoa ascendente) {
		super("Sra. " + nome, ascendente);
	}
	
	
	@Override
	public Pessoa cadastrarFilho(String nome, char sexo) {
		Random random = new Random();
		int tipoDesc = random.nextInt(0,2);
		Pessoa descendente = null;
		
		
			
		if (sexo == 'M' || sexo == 'm') {
			if(tipoDesc == 0) {
				descendente = new Natimorto(nome,this);
			}else {
				descendente = new Filho(nome,this);
			}
			
		}else if (sexo == 'F' || sexo == 'f') {
			descendente = new Filha(nome, this);
		}
		
		this.addDescendente(descendente);
		return descendente;
	}

}
