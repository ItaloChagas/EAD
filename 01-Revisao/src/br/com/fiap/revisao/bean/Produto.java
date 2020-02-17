package br.com.fiap.revisao.bean;

//classe abstrata -> não pode ser instanciada, 
//pode conter métodos abstratos
public abstract class Produto {

	/**
	 * public(todos), private(só a classe), 
	 * protected(herança,pacotes), default/package(pacotes)
	 */	
	private String nome;

	protected double preco;
	
	private Embalagem embalagem;
	
	//Construtor
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	//método abstrato -> método sem implementação
	public abstract void aumentar(double valor);
	
	public double descontar(double desconto) {
		return preco - desconto;
	}
	
	//sobrecarga de métodos(mesmo método, parametros diferentes)
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