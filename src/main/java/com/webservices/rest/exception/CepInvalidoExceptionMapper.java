package com.webservices.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.webservices.exception.CepInvalidoException;

/**
 * Classe responsável no tratamento de exceções na camada REST.
 *
 * @author sergiofjunior@gmail.com
 */
@Provider
public class CepInvalidoExceptionMapper implements ExceptionMapper<CepInvalidoException> {

	/**
	 * Mensagem de erro padrão.
	 */
	private static final String MSG_ERRO = "CEP inválido";

	/**
	 * Resposta padrão.
	 */
	public Response toResponse(CepInvalidoException arg0) {
		return Response.status(422)
				.entity(MSG_ERRO)
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
