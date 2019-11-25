/**
 * 
 */
package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author ruben
 *
 */
@Entity
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_persona")
	private int idPersona;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private LocalDate fechaAlta;
	@OneToOne(mappedBy="persona")
	private Usuario usuario;
	@OneToMany(mappedBy="persona",fetch=FetchType.LAZY)
	private List<RegistroIngreso> registroIngresos;
		
	public Persona() {}
	
	public Persona(String nombre, String apellido, LocalDate fechaAlta) {
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
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<RegistroIngreso> getRegistroIngresos() {
		return registroIngresos;
	}

	public void setRegistroIngresos(List<RegistroIngreso> registroIngresos) {
		this.registroIngresos = registroIngresos;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaAlta="
				+ fechaAlta + "]";
	}
}
