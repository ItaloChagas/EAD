package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {
		//Obter um objeto com a data atual
		Calendar hoje = Calendar.getInstance();
		//Obter uma data específica
		Calendar carnaval = new GregorianCalendar(2020, Calendar.FEBRUARY, 22);
		
		//Exibir a data formatada
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatador.format(hoje.getTime()));
		System.out.println(formatador.format(carnaval.getTime()));
		
	}
	
}
