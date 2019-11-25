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
public class RegistroAhorroIngreso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 16L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_registro_ahorro")
	private int idResgistroAhorro;
	@Column
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_ahorro", nullable = false)
	private AhorroInversion ahorroInversion;
	@ManyToOne
	@JoinColumn(name = "id_periodo", nullable = false)
	private Periodo periodo;
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;
	@Column
	private double monto;
	@ManyToOne
	@JoinColumn(name = "id_registro_ingreso", nullable = false)
	private RegistroIngreso registroIngreso;
	
	public RegistroAhorroIngreso() {}

	public RegistroAhorroIngreso(String descripcion, AhorroInversion ahorroInversion, Periodo periodo, Estado estado,
			double monto, RegistroIngreso registroIngreso) {
		this.descripcion = descripcion;
		this.ahorroInversion = ahorroInversion;
		this.periodo = periodo;
		this.estado = estado;
		this.monto = monto;
		this.registroIngreso = registroIngreso;
	}

	public int getIdResgistroAhorro() {
		return idResgistroAhorro;
	}

	public void setIdResgistroAhorro(int idResgistroAhorro) {
		this.idResgistroAhorro = idResgistroAhorro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AhorroInversion getAhorroInversion() {
		return ahorroInversion;
	}

	public void setAhorroInversion(AhorroInversion ahorroInversion) {
		this.ahorroInversion = ahorroInversion;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public RegistroIngreso getRegistroIngreso() {
		return registroIngreso;
	}

	public void setRegistroIngreso(RegistroIngreso registroIngreso) {
		this.registroIngreso = registroIngreso;
	}

	@Override
	public String toString() {
		return "RegistroAhorroIngreso [idResgistroAhorro=" + idResgistroAhorro + ", descripcion=" + descripcion
				+ ", ahorroInversion=" + ahorroInversion + ", periodo=" + periodo + ", estado=" + estado + ", monto="
				+ monto + ", registroIngreso=" + registroIngreso + "]";
	}
}
