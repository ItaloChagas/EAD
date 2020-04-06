package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Login;
import br.com.fiap.entity.Pedido;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		
		Cliente cliente = new Cliente("Italo", "Chagas", new GregorianCalendar(1996, 7, 14));
				
		
		Login login = new Login(cliente, "1234", "italo");
				
		
		cliente.addPedido(new Pedido(1500, 3, new GregorianCalendar(2020, Calendar.APRIL, 06)));
		cliente.addPedido(new Pedido(2500, 2, new GregorianCalendar(2020, Calendar.APRIL, 06)));
		cliente.addPedido(new Pedido(3500, 1, new GregorianCalendar(2020, Calendar.APRIL, 06)));
		
		//em.remove(em.find(Login.class, 2));
		//em.persist(cliente);
		em.persist(login);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Login busca = em.find(Login.class, 6);
		//System.out.println(busca.getNome());
		//System.out.println(busca.getCliente().getNome());
		
		em.close();
		fabrica.close();
		
	}
}
