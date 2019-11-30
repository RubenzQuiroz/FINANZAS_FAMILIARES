package com.rqr.project.home.core.error;

import java.io.Serializable;

public class TipoIngresoConverterError extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TipoIngresoConverterError(String mensaje) {
		super(mensaje);
	}

}
