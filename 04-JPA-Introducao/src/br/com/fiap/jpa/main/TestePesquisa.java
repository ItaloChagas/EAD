package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TestePesquisa {

	public static void main(String[] args) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = f.createEntityManager();
		
		em.getTransaction().begin();
		
		
		Produto prod = em.find(Produto.class, 1);
		
		System.out.println(prod.getNome());
		System.out.println(prod.getValor());
		
		em.close();
		f.close();
		
		
	}
	
}
