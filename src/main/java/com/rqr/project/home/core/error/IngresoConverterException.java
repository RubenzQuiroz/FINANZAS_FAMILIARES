package com.rqr.project.home.core.error;

import java.io.Serializable;

public class IngresoConverterException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IngresoConverterException(String mensaje) {
		super(mensaje);
	}

}
