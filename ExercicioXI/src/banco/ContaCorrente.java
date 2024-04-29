package banco;

public class ContaCorrente extends Conta{

	
	public void atualizasaldo() {
		double saldo = this.getSaldo();
		saldo = saldo - 1.00;
		this.setSaldo(saldo);
	}
}
