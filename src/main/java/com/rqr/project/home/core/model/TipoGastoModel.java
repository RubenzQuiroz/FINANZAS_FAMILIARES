package com.rqr.project.home.core.model;

import java.time.LocalDate;

public class TipoGastoModel {
	private int idTipoGasto;
	private String nombre;
	private String descripcion;
	private LocalDate fechaAlta;
	private double monto;
	
	public TipoGastoModel() {}

	public TipoGastoModel( String nombre, String descripcion, LocalDate fechaAlta, double monto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.monto = monto;
	}

	public int getIdTipoGasto() {
		return idTipoGasto;
	}

	public void setIdTipoGasto(int idTipoGasto) {
		this.idTipoGasto = idTipoGasto;
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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "TipoGastoModel [idTipoGasto=" + idTipoGasto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + ", monto=" + monto + "]";
	}
}
