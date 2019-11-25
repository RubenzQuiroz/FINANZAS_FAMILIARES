/**
 * 
 */
package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author ruben
 *
 */
@Entity
public class Estado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_estado")
	private int idEstado;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@OneToMany(mappedBy="estado",fetch=FetchType.LAZY)
	private List<RegistroIngreso> registroIngresos;
	@OneToMany(mappedBy="estado",fetch=FetchType.LAZY)
	private List<RegistroGasto> registroGastos;
	
	public Estado() {}
	
	public Estado(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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

	public List<RegistroIngreso> getRegistroIngresos() {
		return registroIngresos;
	}

	public void setRegistroIngresos(List<RegistroIngreso> registroIngresos) {
		this.registroIngresos = registroIngresos;
	}

	public List<RegistroGasto> getRegistroGastos() {
		return registroGastos;
	}

	public void setRegistroGastos(List<RegistroGasto> registroGastos) {
		this.registroGastos = registroGastos;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
