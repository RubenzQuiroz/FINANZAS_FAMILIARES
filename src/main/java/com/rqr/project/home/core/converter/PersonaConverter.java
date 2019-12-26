package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.Persona;
import com.rqr.project.home.core.error.PersonaConverterException;
import com.rqr.project.home.core.model.PersonaModel;

public interface PersonaConverter {
	
	public Persona modelEntidad(PersonaModel personaModel) throws PersonaConverterException;
	
	public PersonaModel entidadToModel(Persona persona) throws PersonaConverterException;
	
	public List<PersonaModel> lisModels(List<Persona> personas) throws PersonaConverterException;

}
