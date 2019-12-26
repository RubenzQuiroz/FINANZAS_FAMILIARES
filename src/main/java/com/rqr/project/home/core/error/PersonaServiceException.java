package com.rqr.project.home.core.error;

import java.io.Serializable;

public class PersonaServiceException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonaServiceException(String mensaje) {
		super(mensaje);
	}

}
