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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ruben
 *
 */
@Entity
@Table(name = "INGRESO")
public class Ingreso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ingreso")
	private int idIngreso;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private LocalDate fechaAlta;
	@ManyToOne
	@JoinColumn(name="id_tipo_ingreso",nullable=false)
	private TipoIngreso tipoIngreso;
	@OneToMany(mappedBy = "ingreso",fetch = FetchType.LAZY)
	private List<RegistroIngreso> registroIngresos;
	
	public Ingreso() {}
	
	public Ingreso(String nombre, String descripcion, LocalDate fechaAlta, TipoIngreso tipoIngreso) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.tipoIngreso = tipoIngreso;
	}

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
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

	public TipoIngreso getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(TipoIngreso tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	@Override
	public String toString() {
		return "Ingreso [idIngreso=" + idIngreso + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + ", tipoIngreso=" + tipoIngreso + "]";
	}
}
