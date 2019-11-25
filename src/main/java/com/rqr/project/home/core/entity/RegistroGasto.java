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
	
	
	
	
	

}
