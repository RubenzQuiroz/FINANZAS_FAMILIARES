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

@Entity
public class Periodo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_periodo")
	private int idPeriodo;
	@Column
	private String nombre;
	@Column
	private int valor;
	@OneToMany(mappedBy="periodo",fetch=FetchType.LAZY)
	private List<RegistroIngreso> registroIngresos;
	@OneToMany(mappedBy="periodo",fetch=FetchType.LAZY)
	private List<RegistroGasto> registroGastos;
	
	public List<RegistroGasto> getRegistroGastos() {
		return registroGastos;
	}

	public void setRegistroGastos(List<RegistroGasto> registroGastos) {
		this.registroGastos = registroGastos;
	}

	public Periodo() {}

	public Periodo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<RegistroIngreso> getRegistroIngresos() {
		return registroIngresos;
	}

	public void setRegistroIngresos(List<RegistroIngreso> registroIngresos) {
		this.registroIngresos = registroIngresos;
	}

	@Override
	public String toString() {
		return "Periodo [idPeriodo=" + idPeriodo + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
}
