package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.singleton.EntityMFactory;

public class CadastroDAO {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityMFactory.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		Motorista motorista = new Motorista(123,"italo",Genero.MASCULINO);
		
		try {
			dao.cadastrar(motorista);
			dao.commit();
		}catch (Exception e) {
			System.out.println("Erro");
			
		}
		System.out.println("Certo");
		
		fabrica.close();
	}
	

}
