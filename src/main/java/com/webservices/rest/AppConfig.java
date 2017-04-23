package com.webservices.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.webservices.rest.exception.CepInvalidoExceptionMapper;

/**
 * Configuração REST.
 *
 * @author sergiofjunior@gmail.com
 */
public class AppConfig extends ResourceConfig {

	/**
	 * Construtor padrão.
	 */
	public AppConfig() {
		register(RequestContextFilter.class);
		register(CepResource.class);
		register(CepInvalidoExceptionMapper.class);
	}
	
}
