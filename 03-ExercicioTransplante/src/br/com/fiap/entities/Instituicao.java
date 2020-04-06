package br.com.fiap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "institucao_seq", allocationSize = 1, initialValue = 1)
public class Instituicao {
	
	@Id
	@GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
	@Column(name ="cd_insituicao")
	private int codigo;
	
	@Column(name ="nm_instituicao", nullable = false, length = 20)
	private String nome;
	
	

}
