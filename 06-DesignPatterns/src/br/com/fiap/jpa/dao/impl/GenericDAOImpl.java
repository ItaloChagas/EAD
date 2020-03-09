package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CommitException;
import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.KeyNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K>{

	EntityManager em = null;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em){
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
		
	}

	@Override
	public void atulizar(T entity) {
		em.merge(entity);
	}

	@Override
	public void deletar(K entity) throws KeyNotFoundException {
		em.remove(entity);
		
	}

	@Override
	public T pesquisar(K id) throws KeyNotFoundException {
		T entity = em.find(clazz, id);
		if(entity == null) {
			throw new KeyNotFoundException();
		}
		return entity;
	}

	@Override
	public void commit() throws CommitException {
		
		
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
