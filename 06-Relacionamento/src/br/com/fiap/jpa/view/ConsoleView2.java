package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.LoginDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Login;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.TipoEndereco;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class ConsoleView2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstace();
		EntityManager em = fabrica.createEntityManager();
		
		LoginDAOImpl dao = new LoginDAOImpl(em);
		
		Cliente cliente = new Cliente("italo", "chagas", new GregorianCalendar(1996, Calendar.JANUARY, 16));
		Login login = new Login(cliente, "admin", "admin");
		
		cliente.addPedido(new Pedido(10,20,Calendar.getInstance()));
		cliente.addPedido(new Pedido(20,30,Calendar.getInstance()));
		cliente.addPedido(new Pedido(30,40,Calendar.getInstance()));
		
		Endereco end = new Endereco("rua dos brabos", TipoEndereco.RUA, 666);
		Endereco end2 = new Endereco("rua dos brabissimo", TipoEndereco.RUA, 333);
		Endereco end3 = new Endereco("rua dos menos brabos", TipoEndereco.RUA, 999);
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(end);
		enderecos.add(end2);
		enderecos.add(end3);
		
		cliente.setEnderecos(enderecos);
		
		dao.cadastrar(login);
		
		try {
			dao.commit();
			System.out.println("Cadastrado");
		} catch (Exception e) {
			System.out.println("Erro...");
		}
		
		
		fabrica.close();
		em.close();
	}
}
