/**
 * 
 */
package com.webservices.service;

import com.webservices.entity.EnderecoEntity;
import com.webservices.exception.CepInvalidoException;

/**
 * interface de negócio responsável ao CEP.
 *
 * @author sergiofjunior@gmail.com
 */
public interface CepService {

	/**
	 * Buscar endereço por um CEP válido.
	 * 
	 * @param cep CEP.
	 * @throws CepInvalidoException Erro ao buscar CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cep) throws CepInvalidoException;
	
}
