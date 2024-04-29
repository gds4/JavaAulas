package banco;

public class ContaPoupanca extends Conta{
	
	
	
	public void atualizasaldo() {
		double saldo = this.getSaldo();
		saldo = saldo + (saldo * 1/100);
		this.setSaldo(saldo);
	}
}
