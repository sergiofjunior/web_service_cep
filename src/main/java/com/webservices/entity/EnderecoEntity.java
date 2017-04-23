package com.webservices.entity;

import java.io.Serializable;

/**
 * Entidade que representa um endereço.
 *
 * @author sergiofjunior@gmail.com
 */
public class EnderecoEntity implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8684785589943206620L;

	/**
	 * Rua.
	 */
	private String rua;
	
	/**
	 * Bairro.
	 */
	private String bairro;
	
	/**
	 * Cidade.
	 */
	private String cidade;
	
	/**
	 * Estado.
	 */
	private String estado;

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
