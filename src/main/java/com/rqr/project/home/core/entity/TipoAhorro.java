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
public class TipoAhorro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 16L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tipo_ahorro")
	private int idTipoAhorro;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private LocalDate fechaAlta;
	@OneToMany(mappedBy = "tipoAhorro")
	private List<AhorroInversion> ahorroInversions;
	
	public TipoAhorro() {}

	public TipoAhorro(String nombre, String descripcion, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
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

	public int getIdTipoAhorro() {
		return idTipoAhorro;
	}

	public void setIdTipoAhorro(int idTipoAhorro) {
		this.idTipoAhorro = idTipoAhorro;
	}

	public List<AhorroInversion> getAhorroInversions() {
		return ahorroInversions;
	}

	public void setAhorroInversions(List<AhorroInversion> ahorroInversions) {
		this.ahorroInversions = ahorroInversions;
	}

	@Override
	public String toString() {
		return "TipoAhorro [idTipoAhorro=" + idTipoAhorro + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + "]";
	}
}
