/**
 * 
 */
package com.rqr.project.home.core.error;

import java.io.Serializable;

/**
 * @author ruben
 *
 */
public class TipoIngresoServiceException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TipoIngresoServiceException(String mensaje) {
		super(mensaje);
	}
}
