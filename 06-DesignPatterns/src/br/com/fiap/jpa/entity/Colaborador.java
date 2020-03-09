package br.com.fiap.jpa.entity;

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
@Table (name = "TB_COLABORADOR")
@SequenceGenerator( name = "colaborador", sequenceName = "SQ_TB_COLABORADOR", allocationSize = 1)
public class Colaborador {

	@Id
	@Column(name = "CD_COLABORADOR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "colaborador" )
	private int id;
	
	@Column(name = "NM_COLABORADOR", nullable = false)
	private String Nome;
	
	@Column( name = "DS_CARGO", length = 50)
	@Enumerated( EnumType.STRING )
	private TipoCargo tipo;
	
	@Column(name = "DT_DEMISSAO")
	@Temporal(TemporalType.DATE)
	private Calendar dtDemissao;
	
	@Column(name = "VL_SALARIO")
	private float salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public TipoCargo getTipo() {
		return tipo;
	}

	public void setTipo(TipoCargo tipo) {
		this.tipo = tipo;
	}

	public Calendar getDtDemissao() {
		return dtDemissao;
	}

	public void setDtDemissao(Calendar dtDemissao) {
		this.dtDemissao = dtDemissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Colaborador(String nome, TipoCargo tipo, Calendar dtDemissao, float salario) {
		super();
		Nome = nome;
		this.tipo = tipo;
		this.dtDemissao = dtDemissao;
		this.salario = salario;
	}
	
	public Colaborador() {}
	
	
}
