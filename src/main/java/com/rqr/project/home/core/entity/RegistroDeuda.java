package com.rqr.project.home.core.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RegistroDeuda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 20L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_registro_deuda")
	private int idRegistroDeuda;
	@ManyToOne
	@JoinColumn(name="id_deuda",nullable = false)
	private Deuda deuda;
	@Column
	private double monto;
	@ManyToOne
	@JoinColumn(name="id_estado",nullable = false)
	private Estado estado;
	@ManyToOne
	@JoinColumn(name="id_periodo",nullable = false)
	private Periodo periodo;
	@ManyToOne
	@JoinColumn(name="id_registro_ingreso",nullable = false)
	private RegistroIngreso registroIngreso;
	
	public RegistroDeuda() {}

	public RegistroDeuda(Deuda deuda, double monto, Estado estado, Periodo periodo, RegistroIngreso registroIngreso) {
		this.deuda = deuda;
		this.monto = monto;
		this.estado = estado;
		this.periodo = periodo;
		this.registroIngreso = registroIngreso;
	}

	public int getIdRegistroDeuda() {
		return idRegistroDeuda;
	}

	public void setIdRegistroDeuda(int idRegistroDeuda) {
		this.idRegistroDeuda = idRegistroDeuda;
	}

	public Deuda getDeuda() {
		return deuda;
	}

	public void setDeuda(Deuda deuda) {
		this.deuda = deuda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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

	public RegistroIngreso getRegistroIngreso() {
		return registroIngreso;
	}

	public void setRegistroIngreso(RegistroIngreso registroIngreso) {
		this.registroIngreso = registroIngreso;
	}

	@Override
	public String toString() {
		return "RegistroDeuda [idRegistroDeuda=" + idRegistroDeuda + ", deuda=" + deuda + ", monto=" + monto
				+ ", estado=" + estado + ", periodo=" + periodo + ", registroIngreso=" + registroIngreso + "]";
	}
}
