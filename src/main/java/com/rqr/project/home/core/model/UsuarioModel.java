package com.rqr.project.home.core.model;

import java.time.LocalDate;
import java.util.Set;


public class UsuarioModel {
	private int idUsuario;
	private String correo;
	private Set<PerfilModel> perfiles;
	private String username;
	private String password;
	private PersonaModel personaModel;
	private LocalDate fechaAlta;
	
	public UsuarioModel() {}

	public UsuarioModel(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UsuarioModel(String correo, Set<PerfilModel> perfiles, String username, String password,
			PersonaModel personaModel, LocalDate fechaAlta) {
		this.correo = correo;
		this.perfiles = perfiles;
		this.username = username;
		this.password = password;
		this.personaModel = personaModel;
		this.fechaAlta = fechaAlta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<PerfilModel> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<PerfilModel> perfiles) {
		this.perfiles = perfiles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonaModel getPersonaModel() {
		return personaModel;
	}

	public void setPersonaModel(PersonaModel personaModel) {
		this.personaModel = personaModel;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
