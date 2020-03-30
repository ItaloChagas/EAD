package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

	@Id
	@SequenceGenerator(name = "pedido", sequenceName = "pedido_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	@Column(name = "cd_pedido")
	private int codigo;
	
	//Relacionamento muitos para Um
	//Pensar na classe corrente par a classe da relacao
	// *PEDIDOS -> 1CLIENTE
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_cliente", nullable = false)
	private Cliente cliente;
	
	@Column(name = "vl_pedido", nullable = false)
	private float valor;
	
	@Column(name ="qt_pedido", nullable = false)
	private int quantidade;
	
	@Column(name ="dt_pedido")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	
	
	
	
	
	
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
