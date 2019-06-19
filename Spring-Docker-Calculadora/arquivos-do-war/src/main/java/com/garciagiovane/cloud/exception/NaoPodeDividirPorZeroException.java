package com.garciagiovane.cloud.exception;

public class NaoPodeDividirPorZeroException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NaoPodeDividirPorZeroException(String mensagem) {
		super(mensagem);
	}	
}
