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
@Table(name = "TB_CONTA")
@SequenceGenerator( name = "conta", sequenceName = "conta_seq", allocationSize = 1 )
public class Conta {

	public Conta() {}
	
	public Conta(int angencia, TipoConta tipo, float salario, Calendar dataAberta) {
		super();
		this.angencia = angencia;
		this.tipo = tipo;
		this.salario = salario;
		this.dataAberta = dataAberta;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "conta_seq")
	@Column( name = "CD_CONTA" )
	private int id;
	
	@Column( name = "NR_AGENCIA", nullable = false)
	private int angencia;
	
	@Column( name = "DS_TIPO")
	@Enumerated( EnumType.STRING )
	private TipoConta tipo;
	
	@Column(name = "VL_SALARIO")
	private float salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="DT_ABERTA")
	private Calendar dataAberta;

	
	
	public int getAngencia() {
		return angencia;
	}

	public void setAngencia(int angencia) {
		this.angencia = angencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Calendar getDataAberta() {
		return dataAberta;
	}

	public void setDataAberta(Calendar dataAberta) {
		this.dataAberta = dataAberta;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	
	
}
