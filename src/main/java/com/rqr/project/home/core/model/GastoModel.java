package com.rqr.project.home.core.model;

public class GastoModel {
	private long idGasto;
	private String nombre;
	private String descripcion;
	private TipoGastoModel tipoGastoModel;
	
	public GastoModel() {}

	public GastoModel(String nombre, String descripcion, TipoGastoModel tipoGastoModel) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoGastoModel = tipoGastoModel;
	}

	public long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(long idGasto) {
		this.idGasto = idGasto;
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

	public TipoGastoModel getTipoGastoModel() {
		return tipoGastoModel;
	}

	public void setTipoGastoModel(TipoGastoModel tipoGastoModel) {
		this.tipoGastoModel = tipoGastoModel;
	}

	@Override
	public String toString() {
		return "GastoModel [idGasto=" + idGasto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", tipoGastoModel=" + tipoGastoModel + "]";
	}
}
