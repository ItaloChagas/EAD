package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Cor;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.singleton.EntityMFactory;

public class CadastroVeiculo {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityMFactory.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Veiculo veiculo = new Veiculo("123sad", Cor.PRETO, 2019);
		
		VeiculoDAOImpl dao = new VeiculoDAOImpl(em);
		
		try {
			
			dao.cadastrar(veiculo);
			dao.commit();
			
			System.out.println("sucesso");
		} catch (Exception e) {
			System.out.println("Erro");
		}
		
		fabrica.close();
		
	}
}
