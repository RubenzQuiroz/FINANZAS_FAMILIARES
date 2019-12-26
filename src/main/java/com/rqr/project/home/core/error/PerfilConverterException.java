package com.rqr.project.home.core.error;

import java.io.Serializable;

public class PerfilConverterException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PerfilConverterException(String mensaje) {
		super(mensaje);
	}

}
