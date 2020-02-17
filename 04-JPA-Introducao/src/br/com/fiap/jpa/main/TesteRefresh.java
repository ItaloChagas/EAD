package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TesteRefresh {

	public static void main(String[] args) {
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = f.createEntityManager();
		
		Produto produto = em.find(Produto.class, 1);
		
		produto.setNome("O brabo");
		
		System.out.println(produto.getNome());
		
		em.refresh(produto);
		
		System.out.println(produto.getNome());
		
		em.close();
		f.close();
	}
}
