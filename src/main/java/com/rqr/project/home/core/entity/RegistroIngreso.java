package com.rqr.project.home.core.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RegistroIngreso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_registro_ingreso")
	private int idRegistriIngreso;
	@ManyToOne
	@JoinColumn(name="id_ingreso",nullable=false)
	private Ingreso ingreso;
	@Column
	private double monto;
	@Column
	private LocalDate fechaAlta;
	@ManyToOne
	@JoinColumn(name="id_persona",nullable=false)
	private Persona persona;
	@ManyToOne
	@JoinColumn(name="id_estado",nullable=false)
	private Estado estado;
	@ManyToOne
	@JoinColumn(name="id_periodo",nullable=false)
	private Periodo periodo;
	
	public RegistroIngreso() {}

	public RegistroIngreso(Ingreso ingreso, double monto, LocalDate fechaAlta, Persona persona,Estado estado) {
		this.ingreso = ingreso;
		this.monto = monto;
		this.fechaAlta = fechaAlta;
		this.persona = persona;
		this.estado = estado;
	}

	public int getIdRegistriIngreso() {
		return idRegistriIngreso;
	}

	public void setIdRegistriIngreso(int idRegistriIngreso) {
		this.idRegistriIngreso = idRegistriIngreso;
	}

	public Ingreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "RegistroIngreso [idRegistriIngreso=" + idRegistriIngreso + ", ingreso=" + ingreso + ", monto=" + monto
				+ ", fechaAlta=" + fechaAlta + ", persona=" + persona + ", estado=" + estado + "]";
	}
}
