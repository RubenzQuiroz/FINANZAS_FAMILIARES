package com.rqr.project.home.core.model;

import java.time.LocalDate;
import java.util.List;

public class PersonaModel {
	private int idPersona;
	private String nombre;
	private String apellido;
	private LocalDate fechaAlta;
	private List<UsuarioModel> usuariosModels;
	
	public PersonaModel() {}
	
	public PersonaModel(int idPersona) {
		this.idPersona = idPersona;
	}

	public PersonaModel(int idPersona, String nombre, String apellido, LocalDate fechaAlta) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaAlta = fechaAlta;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<UsuarioModel> getUsuariosModels() {
		return usuariosModels;
	}

	public void setUsuariosModels(List<UsuarioModel> usuariosModels) {
		this.usuariosModels = usuariosModels;
	}
}
