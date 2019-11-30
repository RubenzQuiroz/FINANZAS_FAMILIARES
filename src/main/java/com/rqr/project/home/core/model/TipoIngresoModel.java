package com.rqr.project.home.core.model;

import java.time.LocalDate;

public class TipoIngresoModel {
	private int idTipoIngreso;
	private String nombre;
	private String descripcion;
	private LocalDate fechaAlta;

	public TipoIngresoModel() {}

	public TipoIngresoModel(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdTipoIngreso() {
		return idTipoIngreso;
	}

	public void setIdTipoIngreso(int idTipoIngreso) {
		this.idTipoIngreso = idTipoIngreso;
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

	@Override
	public String toString() {
		return "TipoIngresoModel [idTipoIngreso=" + idTipoIngreso + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", fechaAlta=" + fechaAlta + "]";
	}
}
