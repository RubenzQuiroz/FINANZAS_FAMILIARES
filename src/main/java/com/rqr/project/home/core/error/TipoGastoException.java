package com.rqr.project.home.core.error;

import java.io.Serializable;

public class TipoGastoException extends RuntimeException implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoGastoException(String mensaje) {
		super(mensaje);
	}
	
}
