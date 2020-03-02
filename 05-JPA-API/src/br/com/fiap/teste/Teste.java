package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.Endereco;
import br.com.fiap.Tipo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.jpa.dao.EnderecoDAOImp;

public class Teste {

	public static void main(String[] args) {
	
		
		Endereco endereco = new Endereco("04938070", "dos brabos", Tipo.RUA);
		
		
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		EnderecoDAOImp dao = new EnderecoDAOImp(em);
		dao.cadastrar(endereco);
		try {
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
		
		
	}
	
	
}
