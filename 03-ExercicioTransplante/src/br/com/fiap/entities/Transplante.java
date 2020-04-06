package br.com.fiap.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_TRANSPLANTE")
@SequenceGenerator(name = "transplante", sequenceName = "transplante_seq", allocationSize = 1, initialValue = 1)
public class Transplante {
	
	@Id
	@GeneratedValue(generator = "transplante", strategy = GenerationType.SEQUENCE)
	@Column(name ="cd_transplante")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_transplante")
	private Calendar dtTransplante;

	@Column(name = "cd_orgao")
	private Orgao orgao;
	
	@Column(name = "cd_paciente")
	private Paciente paciente; 
	
	
}
