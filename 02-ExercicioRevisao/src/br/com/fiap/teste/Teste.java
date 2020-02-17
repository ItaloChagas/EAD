package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {

	public static void main(String[] args) {
		
		ContaCorrente cc = 
			new ContaCorrente(1, 12, Calendar.getInstance(), 100, TipoConta.COMUM);

		ContaPoupanca cp = 
			new ContaPoupanca(1, 123, new GregorianCalendar(2019, Calendar.MAY, 20), 
					1500, 2);
		
		//Criar uma lista e adicionar 3 contas
		List<Conta> lista = new ArrayList<Conta>();
		lista.add(cc);
		lista.add(cp);
		lista.add(new ContaCorrente(1,32,Calendar.getInstance(),500,TipoConta.ESPECIAL));
		
		//Exibir o saldo das contas
		for (Conta conta : lista) {
			System.out.println(conta.getSaldo());
		}
		
		//Testar o método retirar da conta corrente
		try {
			cc.retirar(5000);
		}catch (SaldoInsuficienteException e1) {
			//ação para tratar essa exception específica..
			System.err.println(e1.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage()); //Recupera a mensagem da exceção quando foi instanciada
		}
	}

}