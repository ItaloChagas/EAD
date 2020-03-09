package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CommitException;
import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Colaborador;
import br.com.fiap.jpa.entity.TipoCargo;
import br.com.fiap.jpa.singleton.EntityMFactory;

public class View2 {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityMFactory.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		
		GenericDAO<Colaborador, Integer> dao = 
				new GenericDAOImpl<Colaborador, Integer>(em) {};
	
		try {
			Colaborador c = new Colaborador();
			c.setDtDemissao(Calendar.getInstance());
			c.setNome("fAsf");
			c.setSalario(4444);
			c.setTipo(TipoCargo.ATENDIMENTO);
			
			dao.cadastrar(c);
			dao.commit();
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar");
		}
	
	}

}
