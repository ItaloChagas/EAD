package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Computador;
import br.com.fiap.revisao.bean.Embalagem;

public class TesteEnum {

	public static void main(String[] args) {
		//Criar um computador e atribuir a embalagem
		Computador note = new Computador("Positivo", 1500);
		note.setEmbalagem(Embalagem.PAPELAO);
		
		//Validar se a embalagem � de papel�o
		if (note.getEmbalagem() == Embalagem.PAPELAO) {
			System.out.println("Produto embalado em papel�o");
		}
		
	}
	
}
