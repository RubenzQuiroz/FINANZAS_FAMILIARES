package com.rqr.project.home.core.model;

import java.time.LocalDate;


public class IngresoModel {
	
	private int idIngreso;
	private String nombre;
	private String descripcion;
	private LocalDate fechaAlta;
	private TipoIngresoModel tipoIngresoModel;
	
	public IngresoModel() {}

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public TipoIngresoModel getTipoIngresoModel() {
		return tipoIngresoModel;
	}

	public void setTipoIngresoModel(TipoIngresoModel tipoIngresoModel) {
		this.tipoIngresoModel = tipoIngresoModel;
	}

	@Override
	public String toString() {
		return "IngresoModel [idIngreso=" + idIngreso + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + ", tipoIngresoModel=" + tipoIngresoModel + "]";
	}
}
