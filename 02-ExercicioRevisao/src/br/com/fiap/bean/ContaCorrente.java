package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (tipo == TipoConta.COMUM && saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiênte");
		}
		saldo -= valor; //saldo = saldo - valor;
	}
	
	public ContaCorrente() {}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}