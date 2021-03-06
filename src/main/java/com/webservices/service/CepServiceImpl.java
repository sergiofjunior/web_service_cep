package com.webservices.service;

import com.webservices.exception.CepInvalidoException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.webservices.dao.CepDao;
import com.webservices.entity.EnderecoEntity;

/**
 * Implementação do componente de negócio responsável ao CEP.
 *
 * @author sergiofjunior@gmail.com
 */
public class CepServiceImpl implements CepService {
	
	/**
	 * DAO.
	 */
	@Autowired
	private CepDao cepDao;
	
	/**
	 * Buscar CEP válido.
	 * 
	 * @param cep CEP.
	 * @throws CepInvalidoException Erro ao buscar CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(final String cep) throws CepInvalidoException {
		
		/*
		 * Validar CEP
		 */
		isCepValido(cep);
		
		EnderecoEntity enderecoEntity = null;
		
		/*
		 * Buscar endereço do CEP, 
		 * atribuindo o zeros à direta até que seja encontrado.
		 */
		for (StringBuilder code = new StringBuilder(cep); 
				enderecoEntity == null && !this.isCepZero(code); 
				this.atribuirZerosADireita(code)) {
			enderecoEntity = this.getCepDao().buscarEnderecoPorCEP(code.toString());
		}
		
		/*
		 * Caso não seja encontrado, retorna erro.
		 */
		if (enderecoEntity == null) {
			throw new CepInvalidoException(String.format("CEP não encontrado %s.", cep));
		}
		
		return enderecoEntity;
	}

	/**
	 * Validar o CEP:
	 *  - Não é nulo ou vazio;
	 *  - Se é padrão numérico 99999999
	 *  
	 * @param cep CEP.
	 * @throws CepInvalidoException Erro ao validar CEP.
	 */
	private void isCepValido(String cep) throws CepInvalidoException {

		if (cep == null) {
			throw new CepInvalidoException("CEP é nulo.");
		}
		
		if (StringUtils.isBlank(cep)) {
			throw new CepInvalidoException("CEP está em branco.");
		}
		
		if (!cep.matches("[0-9]{8}")) {
			throw new CepInvalidoException(String.format("CEP %s  não está no padrão 99999999.", cep));
		}
		
	}
	

	/**
	 * Validar se o CEP não é formado apenas de zeros.
	 * @param cep CEP.
	 */
	private boolean isCepZero(StringBuilder cep) {
		return cep.toString().matches("[0]+");
	}

	/**
	 * Atribuir zero ao número mais à direita diferente de zero.
	 * 
	 * @param cep CEP.
	 * @return Novo CEP com zero à esqueda.
	 */
	private StringBuilder atribuirZerosADireita(StringBuilder cep) {
		
		/*
		 * Iterar da direita para esquerda atribuindo zero
		 * ao valor mais à direita diferente de zero.
		 */
		for (int i = cep.length(); i >= 0; i--) {
			if (cep.charAt(i - 1) != '0') {
				cep.replace(i - 1, i, "0");
				break;
			}
		}
		
		return cep;
	}

	/**
	 * @return the cepDao
	 */
	public CepDao getCepDao() {
		return cepDao;
	}
	
}
