package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGIN")
public class Login {

	@Id
	@SequenceGenerator(name = "login", sequenceName = "login_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	@Column(name = "cd_login")
	private int codigo;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// JOIN COLUMN É USADO SÓ EM OneToOne
	@JoinColumn( name = "cd_cliente", nullable = false, unique = true)
	private Cliente cliente;
	
	@Column(name = "ds_senha")
	private String senha;
	
	@Column(name = "nm_login")
	private String nome;

	
	
	public Login(Cliente cliente, String senha, String nome) {
		super();
		this.cliente = cliente;
		this.senha = senha;
		this.nome = nome;
	}

	public Login() {
		super();
	}

	public Login(int codigo, Cliente cliente, String senha, String nome) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.senha = senha;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
}
