package com.rqr.project.home.core.error;

import java.io.Serializable;

public class UsuarioConverterException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioConverterException(String mensaje) {
		super(mensaje);
	}
	

}
