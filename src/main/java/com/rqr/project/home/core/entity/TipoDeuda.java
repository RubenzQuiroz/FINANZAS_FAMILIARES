package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoDeuda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 17L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tipo_deuda")
	private int idTipoDeuda;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private LocalDate fechaAlta;
	@OneToMany(mappedBy = "tipoDeuda")
	private List<Deuda> deudas;
	
	public TipoDeuda() {}

	public TipoDeuda(String nombre, String descripcion, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
	}

	public int getIdTipoDeuda() {
		return idTipoDeuda;
	}

	public void setIdTipoDeuda(int idTipoDeuda) {
		this.idTipoDeuda = idTipoDeuda;
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

	public List<Deuda> getDeudas() {
		return deudas;
	}

	public void setDeudas(List<Deuda> deudas) {
		this.deudas = deudas;
	}

	@Override
	public String toString() {
		return "TipoDeuda [idTipoDeuda=" + idTipoDeuda + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + "]";
	}
	 
}
