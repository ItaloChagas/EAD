package br.com.fiap.revisao.bean;

public class Computador extends Produto {

	private static final double TAXA = 0.05;
	
	//Construtor
	public Computador(String nome, double preco) {
		super(nome,preco); //chama o construtor do pai
	}
	
	//sobrescrita de método
	@Override
	public double descontar(double desconto) {
		return preco*(1+TAXA) - desconto;
	}

	@Override
	public void aumentar(double valor) {
		this.preco += valor;		
	}
	
}
