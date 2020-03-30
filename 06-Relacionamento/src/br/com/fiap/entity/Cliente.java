package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "cliente_seq", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column(name = "nm_cliente", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_sobrenome", length = 50, nullable = false)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dt_nacimento;

	//Quando for uma relacao bi-direcional, colocamos o mappedBy do lado fraco da relacao
	//Serve para semanticamente  
	//Cascade Realiza as operacoes em cascata(nos relacionamentos)
	@OneToOne(mappedBy = "cliente",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Login login;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDt_nacimento() {
		return dt_nacimento;
	}

	public void setDt_nacimento(Calendar dt_nacimento) {
		this.dt_nacimento = dt_nacimento;
	}
	


	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
}
