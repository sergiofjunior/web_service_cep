package com.webservices.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webservices.exception.CepInvalidoException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webservices.dao.CepDao;
import com.webservices.entity.EnderecoEntity;
import com.webservices.service.CepService;

/**
 * Test Case do serviço de busca de CEP.
 *
 * @author sergiofjunior@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class BuscaCepTest {
	
	/**
	 * Serviço do CEP.
	 */
	@Autowired
	private CepService cepService;
	
	/**
	 * Serviço do CEP.
	 */
	@Autowired
	private CepDao cepDao;

	/**
	 * Validar um CEP nulo.
	 */
	@Test
	public void validarCEPNulo() {
		
		try {
			
			// Tentar buscar um CEP nulo
			this.cepService.buscarEnderecoPorCEP(null);
			fail("CEP é nulo");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}
		
	}
	
	/**
	 * Validar um CEP vazio.
	 */
	@Test
	public void validarCEPVazio() {
		
		try {
			
			// Tentar buscar um CEP com valor vazio
			this.cepService.buscarEnderecoPorCEP("   ");
			fail("CEP é vazio");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}
		
	}
	
	/**
	 * Validar um CEP nulo.
	 */
	@Test
	public void validarCEPIncorreto() {
		
		try {
			
			// Tentar buscar um CEP com formato incorreto
			String randomCep = RandomStringUtils.random(999);
			this.cepService.buscarEnderecoPorCEP(randomCep);
			fail("CEP é incorreto");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}
		
		try {
			
			// Tentar buscar um CEP com espaços à direita ou esqueda
			this.cepService.buscarEnderecoPorCEP(" 12345678  ");
			fail("CEP é incorreto");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}

		
	}
	
	/**
	 * Validar um CEP não cadastrado.
	 */
	@Test
	public void validarCEPNaoEncontrato() {
		
		/*
		 * Valor inexistente 99999999 
		 */
		try {
			
			this.cepService.buscarEnderecoPorCEP("99999999");
			fail("CEP foi encontrado");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}
		
		/*
		 * Valor inexistente 00000000 
		 */
		try {
			
			this.cepService.buscarEnderecoPorCEP("00000000");
			fail("CEP foi encontrado");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CepInvalidoException);
		}
		
	}
	
	/**
	 * Buscar CEP válido.
	 */
	@Test
	public void buscarCEPsValidos() {
		
		try {
			
			EnderecoEntity enderecoEntity = mock(EnderecoEntity.class);
			
			/*
			 * Match exato 22333999
			 */
			when(this.cepDao.buscarEnderecoPorCEP("12345678")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("12345678");

			assertNotNull(enderecoEntity);

			/*
			 * Match com zeros à diretira 99990000
			 */
			when(this.cepDao.buscarEnderecoPorCEP("99990000")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("99999999");

			assertNotNull(enderecoEntity);

			/*
			 * Match extado com zeros à direita 08080800
			 */
			when(this.cepDao.buscarEnderecoPorCEP("08080800")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("08080800");

			assertNotNull(enderecoEntity);
			
			/*
			 * Match aproximado com zeros intercados 70707070
			 */
			when(this.cepDao.buscarEnderecoPorCEP("70707000")).thenReturn(enderecoEntity);
			
			enderecoEntity = this.cepService.buscarEnderecoPorCEP("70707777");

			assertNotNull(enderecoEntity);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
