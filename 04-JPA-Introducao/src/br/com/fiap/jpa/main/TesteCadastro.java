package br.com.fiap.jpa.main;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteCadastro {

	public static void main(String[] args) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = f.createEntityManager();
		
		
		Produto prod = new Produto("XIAOMI", 100, 150, null, null, Categoria.ELETRONICO);
		
		em.persist(prod);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		f.close();
		
		
	}
}
