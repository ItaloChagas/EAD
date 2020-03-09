package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator( name = "veiculo", sequenceName = "SQ_T_VEICULO", allocationSize = 1 )
public class Veiculo {


	public Veiculo(String placa, Cor cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	
	
	@Column(name = "cd_veiculo")
	@GeneratedValue( generator = "veiculo", strategy = GenerationType.SEQUENCE )
	private int id;

	@Column(name = "ds_placa", length = 9)
	private String placa; 
	
	@Column(name ="ds_cor", length = 20)
	@Enumerated(EnumType.STRING)
	private Cor cor; 
	
	@Column(name = "nr_ano")
	private int ano;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	} 
	
	
	
	
}
