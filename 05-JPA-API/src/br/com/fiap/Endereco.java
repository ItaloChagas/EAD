package br.com.fiap;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName ="SQ_TB_ENDERECO", allocationSize =1)
public class Endereco {
	
	@Id
	@Column(name ="cd_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	private int codigo;
	
	@Column(name ="nr_cep", length = 8, nullable = false)
	private String cep;
	
	@Column(name ="ds_logradouro", length = 50, nullable = false)
	private String logradouro;
	
	@Column(name ="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column(name ="dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar cadastro;
	
	
	
	public Endereco(){}

	
	public Endereco(String cep, String logradouro, Tipo tipo) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Calendar getCadastro() {
		return cadastro;
	}

	public void setCadastro(Calendar cadastro) {
		this.cadastro = cadastro;
	}


	
}
