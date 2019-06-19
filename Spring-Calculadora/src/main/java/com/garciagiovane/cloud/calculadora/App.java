package com.garciagiovane.cloud.calculadora;

import com.garciagiovane.cloud.configuracao.ConfiguracaoCalculadora;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ConfiguracaoCalculadora.class);
		Calculadora calculadora = (Calculadora) ac.getBean("calculadora");
		
		calculadora.calcular(2, 8, "+");
		calculadora.calcular(5, 5, "-");
		calculadora.calcular(3, 1, "/");
		calculadora.calcular(2, 3, "*");
		calculadora.calcular(3, 8, "^");

		System.out.println("Histórico de operações");
		calculadora.mostrarHistorico().forEach(op -> System.out.println(op));
		((AnnotationConfigApplicationContext) ac).close();
	}
}
