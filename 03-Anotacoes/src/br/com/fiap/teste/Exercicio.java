package br.com.fiap.teste;

import br.com.fiap.bean.Aluno;
import br.com.fiap.bean.Produto;
import br.com.fiap.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar a classe Orm
		Orm orm = new Orm();
		
		//Utilizar o m�todo de gerar SQL
		System.out.println(orm.gerarSql(new Produto()));
		System.out.println(orm.gerarSql(new Aluno()));
	
	}
	
}