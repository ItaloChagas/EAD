package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CommitException;
import br.com.fiap.dao.LoginDAO;
import br.com.fiap.entity.Login;

public class LoginDAOImpl extends GenericDAOImpl<Login, Integer> implements LoginDAO{

	public LoginDAOImpl(EntityManager em) {
		super(em);

	}
	

	
	
}
