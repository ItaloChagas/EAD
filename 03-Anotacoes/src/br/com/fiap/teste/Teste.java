package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Produto;

public class Teste {

	public static void main(String[] args) {
		Produto prod = new Produto();
		
		System.out.println("ATRIBUTOS");
		//Recuperar os atributos da classe
		Field[] atributos = prod.getClass().getDeclaredFields();
		//Exibir os atributos
		for (int i = 0; i< atributos.length; i++) {
			//Recuperar a anotação @Coluna
			Coluna anotacao = atributos[i].getAnnotation(Coluna.class);
			//Exibir o nome do atributo
			System.out.println(atributos[i].getName() + " - " + 
					anotacao.nome() + " - Chave: " + anotacao.chave());			
		}
		
		System.out.println("MÉTODOS:");
		//Recuperar os métodos da classe
		Method[] metodos = prod.getClass().getDeclaredMethods();
		//Exibir os nomes dos métodos da classe
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
	}
	
}



