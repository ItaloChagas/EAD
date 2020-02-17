package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Computador;

public class TesteColecao {

	public static void main(String[] args) {
		//Criar uma lista de computadores
		List<Computador> computadores = new ArrayList<Computador>();
		//Popular a lista
		for (int i = 1; i <10; i++) {
			Computador c = new Computador("i"+i, i*100);
			computadores.add(c);
		}
		//Exibir os computadores da lista
		for (Computador churros : computadores) {
			System.out.println(churros.getNome() + " " + churros.getPreco());
		}
		
		//Criar um mapa <Chave,Valor>
		Map<String, Computador> mapa = new HashMap<String, Computador>();
		//Adicionar dois computadores no mapa
		mapa.put("dell", new Computador("DELL i3", 1000));
		mapa.put("hp", new Computador("HP i7", 2000));
		
		//Recuperar o computador através da chave
		Computador c = mapa.get("hp");
		System.out.println(c.getNome() + " " + c.getPreco());
		
	}
	
}


