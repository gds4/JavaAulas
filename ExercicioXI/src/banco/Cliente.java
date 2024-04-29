package banco;

public class Cliente {
	String nome;
	Conta conta;
	
	public Cliente(String nome, double saldo) {
		this.nome = nome;
		this.conta = conta;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	
	
}
