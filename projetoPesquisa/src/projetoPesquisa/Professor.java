package projetoPesquisa;

public class Professor extends Pesquisador {

	public Professor(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
		this.setValorPago(this.calculaValorPago());
	}


	@Override
	public double calculaValorPago() {
		
		double valorPago = (double)220 + (this.getCoordenador().getValorPago() * 0.3);

		return valorPago;
	}

	@Override
	public int getQtdSubordinados() {
		return 0;
	}
	
	@Override
	public void addPesquisador(Pesquisador pesquisador) throws RuntimeException{
		throw new RuntimeException();
	}

}
