/**
 * 
 */
package com.rqr.project.home.core.error;

import java.io.Serializable;

/**
 * @author ruben
 *
 */
public class TipoGastoConverterException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TipoGastoConverterException(String mensaje) {
		super(mensaje);
	}
	

}
