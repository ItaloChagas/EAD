package br.com.fiap.entities;

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
@Table(name = "TB_DOADOR")
@SequenceGenerator(name = "doador", sequenceName = "doador_seq", allocationSize = 1, initialValue = 1)
public class Doador {

	
	@Id
	@GeneratedValue(generator = "doador", strategy = GenerationType.SEQUENCE)
	@Column(name ="cd_doador")
	private int codigo;
	
	@Column(name ="nm_doador", length = 20, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar dt_nascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipo_sanguineo")
	private TipoSanguineo tipoSangue;
	
	@Column(name ="vl_peso")
	private float peso;
	
	
}
