package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERFIL")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = 23L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_perfil")
	private int idPerfil;
	@Column(name = "nombre")
	private String nombrePerfil;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha_alta")
	private Date fechaAlta;

	public Perfil() {
	}
	
	public Perfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Perfil(String nombrePerfil, String descripcion, Date fechaAlta) {
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

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombrePerfil=" + nombrePerfil + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + "]";
	}
}
