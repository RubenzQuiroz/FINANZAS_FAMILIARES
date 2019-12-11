package com.rqr.project.home.core.error;

import java.io.Serializable;

public class GastoServicException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GastoServicException(String mensaje) {
		super(mensaje);
	}

}
