package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.Endereco;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EnderecoNaoExistenteException;
import br.com.fiap.jpa.dao.EnderecoDAOImp;

public class Atualizar {

	public static void main(String[] args) {

	
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		
		EnderecoDAOImp dao = new EnderecoDAOImp(em);
		try {
			Endereco endereco = dao.pesquisa(1);
			
			endereco.setCep("66666668");
			dao.atualizar(endereco);
			try {
				dao.commit();
			} catch (CommitException e) {
				e.printStackTrace();
			}
			
		} catch (EnderecoNaoExistenteException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}

}
