package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "cliente_seq", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column(name = "nm_cliente", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_sobrenome", length = 50, nullable = false)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dt_nacimento;

	//Quando for uma relacao bi-direcional, colocamos o mappedBy do lado fraco da relacao
	//Serve para semanticamente  
	//Cascade Realiza as operacoes em cascata(nos relacionamentos)
	@OneToOne(mappedBy = "cliente",
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Login login;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	

	//Método que adiciona o pedido no cliente
	public void addPedido(Pedido pedido) {
		//Adiciona o pedido na lista de pedidos
		pedidos.add(pedido);
		//Setar o cliente do pedido (atributo que mapeia a FK)
		pedido.setCliente(this);
	}
	
	//Mapeamento da tabela asossiativa com endereco
	@ManyToMany(cascade = CascadeType.PERSIST, fetch =FetchType.EAGER)
	//JoinColumns: coluna que armazena a PK da classe que estamos
	@JoinTable(name = "TB_CLIENTE_ENDERECO", 
	joinColumns = @JoinColumn(name="cd_cliente"),
	inverseJoinColumns = @JoinColumn(name = "cd_endereco"))
	private List<Endereco> enderecos;
	
	
	
	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}



	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}



	public List<Endereco> getEnderecos() {
		return enderecos;
	}



	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}



	public int getCodigo() {
		return codigo;
	}

	
	
	public Cliente(String nome, String sobrenome, Calendar dt_nacimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dt_nacimento = dt_nacimento;
		
		
	}





	public Cliente(int codigo, String nome, String sobrenome, 
			Calendar dt_nacimento, Login login,
			List<Pedido> pedidos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dt_nacimento = dt_nacimento;
		this.login = login;
		this.pedidos = pedidos;
	}





	public Cliente() {
		super();
	}





	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDt_nacimento() {
		return dt_nacimento;
	}

	public void setDt_nacimento(Calendar dt_nacimento) {
		this.dt_nacimento = dt_nacimento;
	}
	


	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
}
