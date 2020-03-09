package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ContaDao;
import br.com.fiap.jpa.dao.impl.ContaDAOImpl;
import br.com.fiap.jpa.entity.Conta;
import br.com.fiap.jpa.entity.TipoConta;
import br.com.fiap.jpa.singleton.EntityMFactory;

public class View {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityMFactory.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		ContaDao dao = new ContaDAOImpl(em);
			
			
		Conta conta = new Conta(2, TipoConta.PREMIUM, 4000, Calendar.getInstance());
		
		
		try {
		dao.cadastrar(conta);
		dao.commit();
		
		System.out.println("Conta criada com sucesso");
		} catch (Exception e) {
		
			System.out.println("Erro ao criar conta");
			
		}
		
		fabrica.close();
		
	}
}
