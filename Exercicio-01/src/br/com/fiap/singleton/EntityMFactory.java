package br.com.fiap.singleton;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMFactory {

	
	private EntityMFactory(){
		
	}
	
	private static EntityManagerFactory emf = null;
	
	public static EntityManagerFactory getInstance(){
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("oracle");
		}
		
		return emf;
	}
}
