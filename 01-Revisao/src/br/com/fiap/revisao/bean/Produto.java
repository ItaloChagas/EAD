package br.com.fiap.revisao.bean;

//classe abstrata -> n�o pode ser instanciada, 
//pode conter m�todos abstratos
public abstract class Produto {

	/**
	 * public(todos), private(s� a classe), 
	 * protected(heran�a,pacotes), default/package(pacotes)
	 */	
	private String nome;

	protected double preco;
	
	private Embalagem embalagem;
	
	//Construtor
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	//m�todo abstrato -> m�todo sem implementa��o
	public abstract void aumentar(double valor);
	
	public double descontar(double desconto) {
		return preco - desconto;
	}
	
	//sobrecarga de m�todos(mesmo m�todo, parametros diferentes)
	public double descontar(int porcentagem) {
		return preco - (preco*porcentagem)/100; 
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}
	
}