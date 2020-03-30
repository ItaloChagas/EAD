package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "endereco_seq", allocationSize = 1)
public class Endereco {

	
	@Id
	@Column(name = "cd_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	private int codigo;
	
	@Column(name ="ds_logradouro")
	private String logradouro;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoEndereco tipo;
	
	@Column(name = "nr_numero")
	private int numero;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
