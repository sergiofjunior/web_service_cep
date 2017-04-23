package com.webservices.exception;

/**
 * Exceção CEP inválido.
 *
 * @author sergiofjunior@gmail.com
 */
public class CepInvalidoException extends Exception {

	/**
	 * Serial;
	 */
	private static final long serialVersionUID = -3205289088605739909L;

	/**
	 * Construtor.
	 * 
	 * @param message Mensagem de erro.
	 */
	public CepInvalidoException(String message) {
		super(message);
	}

}
