package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteAtualiacao {

	public static void main(String[] args) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		
		Produto prod = new Produto("Zenfone", 1000, 1000, null, null, Categoria.ELETRONICO);
		EntityManager em = f.createEntityManager();
		
		em.merge(prod); 
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		f.close();
		
	}
}
