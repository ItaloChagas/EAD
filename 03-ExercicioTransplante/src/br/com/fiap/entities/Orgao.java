package br.com.fiap.entities;

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
@Table(name = "TB_ORGAO")
@SequenceGenerator(name = "orgao", sequenceName = "orgao_seq", allocationSize = 1, initialValue = 1)
public class Orgao {

	@Id
	@GeneratedValue(generator = "transplante", strategy = GenerationType.SEQUENCE)
	@Column(name ="cd_transplante")
	private int codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "nm_orgao", length = 50, nullable = false)
	private NomeOrgao nomeOrgao;
	
	@Column(name = "ds_isquemia", nullable =false)
	private int isquemia;
	
	private Doador doador;
	
	
}
