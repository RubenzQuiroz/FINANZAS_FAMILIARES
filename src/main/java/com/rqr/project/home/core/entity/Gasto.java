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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author ruben
 *
 */
@Entity(name ="Gastos")
public class Gasto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_Gasto",unique = true)
	private long idGasto;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_Gasto",nullable=false)
	private TipoGasto tipoGasto;
	@OneToMany(mappedBy = "gasto",fetch = FetchType.LAZY)
	private List<RegistroGasto> registroGastos;
	
	public Gasto() {}
	
	public Gasto(String nombre, String descripcion, TipoGasto tipoGasto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoGasto = tipoGasto;
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

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public List<RegistroGasto> getRegistroGastos() {
		return registroGastos;
	}

	public void setRegistroGastos(List<RegistroGasto> registroGastos) {
		this.registroGastos = registroGastos;
	}

	@Override
	public String toString() {
		return "Gastos [idGasto=" + idGasto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoGasto="
				+ tipoGasto + "]";
	}
}
