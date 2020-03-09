package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ColaboradorDao;
import br.com.fiap.jpa.entity.Colaborador;

public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador, Integer> implements ColaboradorDao{

	public ColaboradorDAOImpl(EntityManager em) {
		super(em);
	}

	
}
