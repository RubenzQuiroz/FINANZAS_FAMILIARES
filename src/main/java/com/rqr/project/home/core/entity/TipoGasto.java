/**
 * 
 */
package com.rqr.project.home.core.entity;

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
@Entity(name ="Tipo_Gasto")
public class TipoGasto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tipo_Gasto")
	private int idTipoGasto;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private LocalDate fechaAlta;
	@OneToMany(mappedBy="tipoGasto",fetch=FetchType.LAZY)
	private List<Gasto> gastos;
	
	public int getIdTipoGasto() {
		return idTipoGasto;
	}
	public void setIdTipoGasto(int idTipoGasto) {
		this.idTipoGasto = idTipoGasto;
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
	@Override
	public String toString() {
		return "TipoGasto [idTipoGasto=" + idTipoGasto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaAlta=" + fechaAlta + "]";
	}
}
