package jogoForca;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/*
Jogo jogo = new Jogo();

try {
	jogo.setItemSelecionado(jogo.EscolheItem("Filmes"));
	jogo.setLetraEscolhida("a");
	jogo.setLetraEscolhida("o");
	jogo.setLetraEscolhida("t");
	jogo.setLetraEscolhida("r");
	System.out.println(jogo.getPalavraEscondida());
	System.out.println(jogo.getItemSelecionado());
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/

public class Jogo {
	private ArrayList<String> letrasEscolhidas = new ArrayList<String>();
	//private StringBuilder letrasEscolhidas = new StringBuilder();
	private String[] filmes = {"O Poderoso Chefão", "Matrix", "Cidade de Deus", "Forrest Gump", "Senhor dos Anéis", "Interestelar"};
	private String[] novelas = {"Avenida Brasil", "Vale Tudo", "Roque Santeiro", "Tieta", "Fera Ferida", "Mulheres de Areia"};
	private String[] carros = {"Ferrari", "Tesla Model S", "Ford Mustang", "Toyota Corolla", "Uno", "Honda Civic"};
	private String itemSelecionado;
	//private String ItemEscondido;
	
	
	public void setLetraEscolhida(String letra) {
			letrasEscolhidas.add(letra);
	}
	
	public String getLetrasEscolhidas() {
		return letrasEscolhidas.stream().collect(Collectors.joining(" - "));
	}
	
	public boolean JaEscolheuLetra(String Letra) {
		
		return letrasEscolhidas.stream().collect(Collectors.joining()).contains(Letra);
		
	}
	
	private String EscolheItem(String opcaoEscolhida) throws Exception{
		Random posicaoRdn = new Random();
		
		if(opcaoEscolhida.equals("Filmes")) {
			return filmes[posicaoRdn.nextInt(0, filmes.length)];
		}else if (opcaoEscolhida.equals("Novelas")){
			return novelas[posicaoRdn.nextInt(0, novelas.length)];
		}else if (opcaoEscolhida.equals("Carros")) {
			return carros[posicaoRdn.nextInt(0, carros.length)];
		}
		throw new Exception("Erro ao escolher Item");
	}
	
	
	public String getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(String itemSelecionado) {
		try {
			this.itemSelecionado = this.EscolheItem(itemSelecionado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getPalavraEscondida() {
		
		String strFinal;
		ArrayList<String> ListaStrFinal =  new  ArrayList<String>();
		ArrayList<String> nomeItemSeparado = new  ArrayList<String>(Arrays.asList( this.itemSelecionado.split(" ")));
		
		nomeItemSeparado.stream()
			.forEach(str -> ListaStrFinal.add(str.chars().mapToObj(c->"_").collect(Collectors.joining())));
		
		
		this.letrasEscolhidas.stream().forEach(c -> {
			//itera sobre cada palavra do item selecionado -  exemplo: Cidade | de | Deus
			
			for( int i = 0 ; i < nomeItemSeparado.size() ; i++) {
				String str = nomeItemSeparado.get(i);
				
				//converte o texto para minusculo e verifica em cada palavra do item se contem a letra selecionada(tambem em minusculo) 
				//exemplo: letra 'a' está em "Cidade" mas não em "Deus"
				if(str.toLowerCase().contains(c.toLowerCase())) {
					for(int j = 0 ; j < str.length() ; j++) {
						
						if(str.toLowerCase().charAt(j) == c.toLowerCase().charAt(0)) {
							
							StringBuilder strBuilder = new StringBuilder(ListaStrFinal.get(i));
							strBuilder.setCharAt(j, this.itemSelecionado.charAt(j));
							ListaStrFinal.set(i, strBuilder.toString());
							
						}
					}
				}
			}
		});
		
		strFinal = ListaStrFinal.stream().collect(Collectors.joining(" "));
		return strFinal;
		/*
		Obs.: não é necessario iterar sobre todas as letrasEscolhidas todas as vezes, basta pegar a ultima letra fornecida
		e verificar sua presença no ItemEscolhido e ir modificando a palavra escondida (public void modificaItemEscondido(char c) modificando um atributo que deve ser criado na classe)
		*/
	}
	
	public boolean temLetra(String c) {
		return this.itemSelecionado.toLowerCase().contains(c.toLowerCase());
	}
	
	
}
