package com.rqr.project.home.core.error;

import java.io.Serializable;

public class PersonaConverterException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonaConverterException(String mensaje) {
		super(mensaje);
	}
	
}
