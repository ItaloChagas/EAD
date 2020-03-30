package br.com.fiap.jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.util.Calculadora;

class CalculadoraTest {

	@Test
	void somarTest() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 5);
		
		assertEquals(8,  soma);
		
	}

}
