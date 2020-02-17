package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//mantém a anotação até a execução do código
@Retention(RetentionPolicy.RUNTIME)
//determina que a anotação pode ser usada em atributos e métodos
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Coluna {

	String nome();
	boolean chave() default false;
	
}

