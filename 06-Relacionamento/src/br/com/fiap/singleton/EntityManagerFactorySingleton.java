package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	
	EntityManagerFactorySingleton(){
		
	}
	
	private static EntityManagerFactory fabrica = null;

	public static EntityManagerFactory getInstace() {
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		
		return fabrica;
	}
}
