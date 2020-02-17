package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TesteUpdate {

	public static void main(String[] args) {


		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = f.createEntityManager();
		
		Produto prod = em.find(Produto.class, 2);
		prod.setValor(1500);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
			
		em.close();
		f.close();
		
		
	}

}
