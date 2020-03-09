package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ContaDao;
import br.com.fiap.jpa.entity.Conta;

public class ContaDAOImpl extends GenericDAOImpl<Conta, Integer> implements ContaDao{

	public ContaDAOImpl(EntityManager em) {
		super(em);
	}

	
	
}
