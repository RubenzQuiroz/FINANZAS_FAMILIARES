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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author ruben
 *
 */
@Entity
public class RegistroGasto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_registro_gasto")
	private long idRegistroGasto;
	@ManyToOne
	@JoinColumn(name="id_Gasto",nullable=false)
	private Gasto gasto;
	@Column
	private double monto;
	@Column
	private LocalDate fechaAlta;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "gasto_persona", joinColumns = @JoinColumn(name = "id_registro_gasto"), inverseJoinColumns = @JoinColumn(name = "id_persona"))
	private List<Persona> personas;
	@ManyToOne
	@JoinColumn(name="id_periodo",nullable=false)
	private Periodo periodo;
	@ManyToOne
	@JoinColumn(name="id_estado",nullable=false)
	private Estado estado;
	
	public RegistroGasto() {}
	
	public RegistroGasto(Gasto gasto, double monto, LocalDate fechaAlta, List<Persona> personas, Periodo periodo,
			Estado estado) {
		this.gasto = gasto;
		this.monto = monto;
		this.fechaAlta = fechaAlta;
		this.personas = personas;
		this.periodo = periodo;
		this.estado = estado;
	}

	public long getIdRegistroGasto() {
		return idRegistroGasto;
	}

	public void setIdRegistroGasto(long idRegistroGasto) {
		this.idRegistroGasto = idRegistroGasto;
	}

	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
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

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
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

	@Override
	public String toString() {
		return "RegistroGasto [idRegistroGasto=" + idRegistroGasto + ", gasto=" + gasto + ", monto=" + monto
				+ ", fechaAlta=" + fechaAlta + ", personas=" + personas + ", periodo=" + periodo + ", estado=" + estado
				+ "]";
	}
}
