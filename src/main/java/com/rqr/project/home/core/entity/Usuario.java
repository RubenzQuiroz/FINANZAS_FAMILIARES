/**
 * 
 */
package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author ruben
 *
 */
@Entity
@Table(name ="USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 32L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_usuario",unique = true)
	private int idUsuario;
	@Column
	private String correo;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
	private Set<Perfil> perfiles;
	@Column
	private String username;
	@Column
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona",nullable=false)
	private Persona persona;
	@Column (name ="fecha_alta")
	private LocalDate fechaAlta;
	
	public Usuario() {}
	
	public Usuario( String correo, Set<Perfil> perfiles, String username,String password, LocalDate fechaAlta) {
		this.correo = correo;
		this.perfiles = perfiles;
		this.username = username;
		this.password = password;
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

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
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

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", correo=" + correo + ", perfiles=" + perfiles + ", username="
				+ username + ", password=" + password + ", fechaAlta=" + fechaAlta + "]";
	}

}
