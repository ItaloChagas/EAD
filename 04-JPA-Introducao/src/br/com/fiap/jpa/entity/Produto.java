package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import oracle.jdbc.proxy.annotation.Post;




@Entity //Obrigatório
@Table(name = "TB_PRODUTO")
//name -> nome da sequencia no java (@GeneratedValue)
//sequenceName -> nome da sequencia no banco de dados
@SequenceGenerator(name="produto",sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {


	
	public Produto() {}
	
	public Produto(int codigo, String nome, double valor, double valorLiquido, 
			Calendar dataVencimento, byte[] imagem, Categoria catergoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.valorLiquido = valorLiquido;
		this.dataVencimento = dataVencimento;
		this.imagem = imagem;
		this.catergoria = catergoria;
	}

	public Produto(String nome, double valor, double valorLiquido,
			Calendar dataVencimento, byte[] imagem, Categoria catergoria) {
		this.nome = nome;
		this.valor = valor;
		this.valorLiquido = valorLiquido;
		this.dataVencimento = dataVencimento;
		this.imagem = imagem;
		this.catergoria = catergoria;
	}

	
	
	@Id  //OBRIGATÓRIO
	@Column(name = "CD_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;

	@Column(name = "NM_PRODUTO", nullable = false)
	private String nome;

	@Column(name = "VL_PRODUTO")
	private double valor;
	
	@Transient // não será mapeado para uma coluna na base de dados
	private double valorLiquido;

	@Column(name = "DT_VENCIMENTO")
	@Temporal(TemporalType.DATE) // Armazena no banco somente a data sem o horário.
	private Calendar dataVencimento;
	
	@Column(name = "IMG_PRODUTO")
	@Lob // Mapeia uma coluna do tipo BLOB, para armazenar arquivos no banco
	private byte[] imagem; 
	
	@Column(name = "NOME_CATEGORIA")
	@Enumerated(EnumType.STRING) // Armazena a String no banco não a posição. 
	private Categoria catergoria;

	
	
	
	
	@PostLoad
	public void carregar () {
		
		valor = this.valor * 0.80;
		System.out.println("Carregando o valor liquido apos pesquisa no banco");
		
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCatergoria() {
		return catergoria;
	}

	public void setCatergoria(Categoria catergoria) {
		this.catergoria = catergoria;
	}
	
	
	
}
