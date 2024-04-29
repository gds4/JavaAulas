package projetoPesquisa;

import java.util.ArrayList;

public abstract class Pesquisador {
	protected ArrayList<Pesquisador> pesquisadores;
	private String nome;
	private Pesquisador coordenador;
	private double valorPago;
	
	public Pesquisador(String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
		pesquisadores = new ArrayList<Pesquisador>();
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pesquisador getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(Pesquisador coordenador) {
		this.coordenador = coordenador;
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	public void addPesquisador(Pesquisador pesquisador) throws RuntimeException{
		this.pesquisadores.add(pesquisador);
	}
	
	public abstract double calculaValorPago();
	
	public abstract int getQtdSubordinados();
}
