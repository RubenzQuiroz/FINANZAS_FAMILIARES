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

/**
 * @author ruben
 *
 */
@Entity
public class TipoIngreso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tipo_ingreso")
	private int idTipoIngreso;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private LocalDate fechaAlta;
	@OneToMany(mappedBy = "tipoIngreso",fetch = FetchType.LAZY)
	private List<Ingreso> ingresos;
	
	public TipoIngreso() {}
	
	public TipoIngreso(String nombre, String descripcion, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
	}

	public int getIdTipoIngreso() {
		return idTipoIngreso;
	}
	public void setIdTipoIngreso(int idTipoIngreso) {
		this.idTipoIngreso = idTipoIngreso;
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

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	@Override
	public String toString() {
		return "TipoIngreso [idTipoIngreso=" + idTipoIngreso + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + "]";
	}
}
