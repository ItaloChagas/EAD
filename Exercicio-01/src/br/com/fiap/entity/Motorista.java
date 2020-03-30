package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="TB_MOTORISTA")
public class Motorista {

	public Motorista(int nCarteira, String nome, Genero genero) {
		super();
		this.nCarteira = nCarteira;
		this.nome = nome;
		this.genero = genero;
	}

	@Id
	@Column(name = "nr_carteira")
	private int nCarteira; 
	
	@Column(name ="NM_MOTORISTA", length = 250)
	private String nome;
	
	@Column(name ="dt_nascimento")
	@Temporal(TemporalType.DATE )
	private Calendar dtNascimento; 
	
	@Column(name = "ft_carteira")
	private Byte[] carteira ; 
	
	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING )
	private Genero genero;

	public int getnCarteira() {
		return nCarteira;
	}

	public void setnCarteira(int nCarteira) {
		this.nCarteira = nCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(Byte[] carteira) {
		this.carteira = carteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	} 
	
	
	
	
}
