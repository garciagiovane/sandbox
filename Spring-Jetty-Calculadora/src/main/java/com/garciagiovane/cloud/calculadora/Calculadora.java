package com.garciagiovane.cloud.calculadora;

import com.garciagiovane.cloud.exception.NaoPodeDividirPorZeroException;
import com.garciagiovane.cloud.exception.OperacaoInvalidaException;
import com.garciagiovane.cloud.operacoes.Divisao;
import com.garciagiovane.cloud.operacoes.Operacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.context.ApplicationContext;

public class Calculadora {
	private List<Operacao> historico = new ArrayList<>();

	private ApplicationContext ac;

	public Calculadora(ApplicationContext ac) {
		this.ac = ac;
	}

	public double calcular(double a, double b, String requisicao) {
		if(!requisicao.matches("\\+|\\-|\\^|\\/|\\*")) {
			throw new OperacaoInvalidaException("Operação inválida");
		} else if (ac.getBean(requisicao, a, b) instanceof Divisao && b == 0) {
			throw new NaoPodeDividirPorZeroException("Não pode dividir por zero");
		} 
		Operacao operacao = (Operacao) ac.getBean(requisicao, a, b);
		historico.add(operacao);
		return operacao.calcular();
	}

	public List<Operacao> mostrarHistorico() {
		return Collections.unmodifiableList(historico);
	}
}
