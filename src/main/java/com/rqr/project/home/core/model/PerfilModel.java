package com.rqr.project.home.core.model;

import java.util.Date;

public class PerfilModel {
	private int idPerfil;
	private String nombrePerfil;
	private String descripcion;
	private Date fechaAlta;
	
	public PerfilModel() {}

	public PerfilModel(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public PerfilModel(String nombrePerfil, String descripcion, Date fechaAlta) {
		this.nombrePerfil = nombrePerfil;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
