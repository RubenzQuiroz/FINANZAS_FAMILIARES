/**
 * 
 */
package com.rqr.project.home.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ruben
 *
 */
@Entity
public class Deuda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 18L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_deuda")
	private int idDeuda;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private float porcentaje;
	@ManyToOne
	@JoinColumn(name = "id_tipo_deuda", nullable = false)
	private TipoDeuda tipoDeuda;
	
	public Deuda() {}

	public Deuda(String nombre, String descripcion, float porcentaje) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
	}

	public int getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(int idDeuda) {
		this.idDeuda = idDeuda;
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

	@Override
	public String toString() {
		return "Deuda [idDeuda=" + idDeuda + ", nombre=" + nombre + ", descripcion=" + descripcion + ", porcentaje="
				+ porcentaje + "]";
	}
}
