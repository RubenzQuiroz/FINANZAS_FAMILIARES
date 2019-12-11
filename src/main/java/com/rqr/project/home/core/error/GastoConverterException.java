package com.rqr.project.home.core.error;

import java.io.Serializable;

public class GastoConverterException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GastoConverterException(String mensaje) {
		super(mensaje);
	}

}
