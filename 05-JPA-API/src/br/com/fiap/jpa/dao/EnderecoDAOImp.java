package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.Endereco;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EnderecoNaoExistenteException;

public class EnderecoDAOImp implements EnderecoDAO{

	EntityManager em;
	
	public EnderecoDAOImp(EntityManager em) {
		this.em = em;		
	}
	
	@Override
	public void cadastrar(Endereco endereco) {
		em.persist(endereco);

	}

	@Override
	public Endereco pesquisa(int id) throws EnderecoNaoExistenteException{
		Endereco end = em.find(Endereco.class, id);
		if(end == null) {
			
			throw new EnderecoNaoExistenteException();
		}
		
		return end;

	}

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoExistenteException {
		pesquisa(endereco.getCodigo());
		em.merge(endereco);

	}

	@Override
	public void deletar(int id) throws EnderecoNaoExistenteException{		
		Endereco end = pesquisa(id);		
		em.remove(end);

	}

	@Override
	public void commit() throws CommitException{
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();	
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException(e.getMessage());
		}
		
		
	}
	
	
	
	
}