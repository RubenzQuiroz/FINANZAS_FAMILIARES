package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AhorroInversion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ahorro")
	private int IdAhorro;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private float porcentaje;
	@Column
	private LocalDate fechaAlta;
	@ManyToOne
	@JoinColumn(name ="id_tipo_ahorro")
	private TipoAhorro tipoAhorro;
	
	public AhorroInversion() {}

	public AhorroInversion(String nombre, String descripcion, float porcentaje, LocalDate fechaAlta,
			TipoAhorro tipoAhorro) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.fechaAlta = fechaAlta;
		this.tipoAhorro = tipoAhorro;
	}

	public int getIdAhorro() {
		return IdAhorro;
	}

	public void setIdAhorro(int idAhorro) {
		IdAhorro = idAhorro;
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

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public TipoAhorro getTipoAhorro() {
		return tipoAhorro;
	}

	public void setTipoAhorro(TipoAhorro tipoAhorro) {
		this.tipoAhorro = tipoAhorro;
	}

	@Override
	public String toString() {
		return "AhorroInversion [IdAhorro=" + IdAhorro + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", porcentaje=" + porcentaje + ", fechaAlta=" + fechaAlta + ", tipoAhorro=" + tipoAhorro + "]";
	}
}
