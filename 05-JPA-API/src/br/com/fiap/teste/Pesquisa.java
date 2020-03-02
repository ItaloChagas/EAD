package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.Endereco;
import br.com.fiap.exception.EnderecoNaoExistenteException;
import br.com.fiap.jpa.dao.EnderecoDAOImp;

public class Pesquisa {

	public static void main(String[] args) {

		EntityManagerFactory f = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = f.createEntityManager();
		
		EnderecoDAOImp dao = new EnderecoDAOImp(em);
		
		try {
			Endereco endereco = dao.pesquisa(1);
			System.out.println(endereco.getCep());
			System.out.println(endereco.getLogradouro());
			System.out.println(endereco.getTipo());
		} catch (EnderecoNaoExistenteException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
