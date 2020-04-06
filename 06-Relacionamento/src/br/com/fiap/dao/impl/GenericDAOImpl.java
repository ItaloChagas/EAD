package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CommitException;
import br.com.fiap.dao.IGenericDAO;

public class GenericDAOImpl<E, K> implements IGenericDAO<E, K> {

	EntityManager em = null;
	private Class<E> clazz;
	
	
	public GenericDAOImpl(EntityManager em){
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];	
	}
	
	@Override
	public void cadastrar(E entity) {
		em.persist(entity);
		
	}

	@Override
	public void atualizar(E entity) {
		em.merge(entity);
		
	}

	@Override
	public void deletar(K code) {
		em.remove(code);
		
	}

	@Override
	public E buscar(K code) {
		E entity = em.find(clazz, code); 
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
