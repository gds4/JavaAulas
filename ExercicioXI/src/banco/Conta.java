package banco;

public class Conta {
	String numero;
	double saldo;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void atualizaSaldo(){
		
	}
	
	public void depositar(double deposito) {
		double saldo = this.getSaldo();
		saldo += deposito;
		this.setSaldo(saldo);
	}
	
	public void sacar(double saque) {
		double saldo = this.getSaldo();
		
		if(saque > saldo) {
			System.out.println("Saldo Insuficiente");
			return;
		}
		saldo -= saque;
		this.setSaldo(saldo);
	}
	
	public void consultaSaldo() {
		System.out.println("Seu saldo atual é: R$ " + this.getSaldo());
	}
}
