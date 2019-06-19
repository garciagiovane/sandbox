package com.garciagiovane.cloud.exception;

public class OperacaoInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1487946015398245744L;

	public OperacaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}
