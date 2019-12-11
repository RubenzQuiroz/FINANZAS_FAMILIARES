package com.rqr.project.home.core.error;

import java.io.Serializable;

public class IngresoServiceException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public IngresoServiceException(String mensaje) {
		super(mensaje);
	}

}
