package br.com.fiap.jpa.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.CommitException;
import br.com.fiap.jpa.dao.ContaDao;
import br.com.fiap.jpa.dao.KeyNotFoundException;
import br.com.fiap.jpa.dao.impl.ContaDAOImpl;
import br.com.fiap.jpa.entity.Conta;
import br.com.fiap.jpa.entity.TipoConta;

class ContaDAOTest {

	static ContaDao dao;
	Conta conta;
	
	@BeforeAll
	static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new ContaDAOImpl(em);
		
	}
	
	@BeforeEach
	@DisplayName("Cadastro de conta")
	void cadastrar() {
	
		conta = new Conta();
		
		conta.setAngencia(22);
		conta.setDataAberta(GregorianCalendar.getInstance());
		conta.setSalario(5000);
		conta.setTipo(TipoConta.PREMIUM);
		
		try {
			dao.cadastrar(conta);
			dao.commit();
		} catch (Exception e) {
			fail("falha no teste");
		}
		
		assertNotEquals(0, conta.getId());
	}
	
	@Test
	@DisplayName("Pesquisa de conta")
	void buscaSucessoTest() {
		Conta contaEncontrada = null;
		try {
			contaEncontrada = dao.pesquisar(conta.getId());
			assertEquals(conta.getId(), contaEncontrada.getId());
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}
	
	@Test
	@DisplayName("Atualizar Conta")
	public void AtualizarSucessoTest(){
		conta.setAngencia(666);
		//Date data = new Date(2019,GregorianCalendar.JANUARY, 15);
		conta.setDataAberta(GregorianCalendar.getInstance());
		conta.setSalario(3500);
		conta.setTipo(TipoConta.PREMIUM);
		
		dao.atulizar(conta);
		try {
			dao.commit();
		} catch (Exception e) {
			fail("falha no teste");
		}
		
		
		try {
			Conta busca = dao.pesquisar(conta.getId());
			assertEquals(666, conta.getAngencia());
		} catch (Exception e) {

		}
		
	}
	
	@Test
	@DisplayName("Deletar conta")
	public void deletaSucessoTest() {
		
		try {
			dao.deletar(conta.getId());
			dao.commit();
		} catch (KeyNotFoundException| CommitException e) {
			fail("Falha no Teste");
		}
		
		assertThrows(KeyNotFoundException.class, 
				() -> { dao.pesquisar(conta.getId()); });
	}
	
	
	
	@Test
	@DisplayName("Cadastro de conta")
	void cadastroSucessoTest() {
	}

}
