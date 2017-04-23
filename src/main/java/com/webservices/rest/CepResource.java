package com.webservices.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.webservices.exception.CepInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservices.entity.EnderecoEntity;
import com.webservices.service.CepService;

/**
 * Implementação REST destinada à requisições do Resource CEP.
 *
 * @author sergiofjunior@gmail.com
 */
@Path("/cep")
@Component
public class CepResource {
	
	/**
	 * Serviço de busca do CEP.
	 */
	@Autowired
	private CepService cepService;
	
	/**
	 * Buscar endereço por um CEP válido.
	 * 
	 * @param cep CEP.
	 * @throws CepInvalidoException Erro ao buscar CEP.
	 */
	@GET
	@Path("/{cep}")
	@Produces(APPLICATION_JSON)
	public EnderecoEntity buscarEnderecoPorCEP(
			@PathParam("cep") String cep) throws CepInvalidoException {
		
		// Efetuar a busca do endereço por um CEP
		return this.cepService.buscarEnderecoPorCEP(cep);
		
	}
	
}
