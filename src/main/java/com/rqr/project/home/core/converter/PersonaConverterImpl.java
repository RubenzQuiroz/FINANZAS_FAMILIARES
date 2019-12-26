package com.rqr.project.home.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.Persona;
import com.rqr.project.home.core.error.PersonaConverterException;
import com.rqr.project.home.core.model.PersonaModel;

@Component
public class PersonaConverterImpl implements PersonaConverter {
	@Autowired
	private UsuarioConverter usuarioConverter;

	@Override
	public Persona modelEntidad(PersonaModel personaModel) throws PersonaConverterException {
		Persona persona = null;
		
		try {
			if(personaModel!=null) {
				persona = new Persona();
				
				if(personaModel.getApellido()!=null)
					persona.setApellido(personaModel.getApellido());
				if(personaModel.getFechaAlta()!=null) 
					persona.setFechaAlta(personaModel.getFechaAlta());
				if(personaModel.getIdPersona()!=0)
					persona.setIdPersona(personaModel.getIdPersona());
				if(personaModel.getNombre()!=null)
					persona.setNombre(personaModel.getNombre());
				if(!personaModel.getUsuariosModels().isEmpty())
					persona.setUsuarios(usuarioConverter.lisEntitys(personaModel.getUsuariosModels()));
				
			}
			
		} catch (Exception e) {
			throw new PersonaConverterException(""+e.getMessage());
		}
		
		return persona;
	}

	@Override
	public PersonaModel entidadToModel(Persona persona) throws PersonaConverterException {
		PersonaModel personaModel = null;
		
		try {
			personaModel = new PersonaModel();
			
			if(persona.getApellido()!=null)
				personaModel.setApellido(persona.getApellido());
			if(persona.getFechaAlta()!=null) {
				personaModel.setFechaAlta(persona.getFechaAlta());
			}
			if(persona.getIdPersona()!=0)
				personaModel.setIdPersona(persona.getIdPersona());
			if(persona.getNombre()!=null)
				personaModel.setNombre(persona.getNombre());
			if(!persona.getRegistroIngresos().isEmpty()) {
				
			}
				
			if(!persona.getUsuarios().isEmpty()) 
				personaModel.setUsuariosModels(usuarioConverter.lisModels(persona.getUsuarios()));
			
			
		} catch (Exception e) {
			throw new PersonaConverterException(""+e.getMessage());
		}
		
		return personaModel;
	}

	@Override
	public List<PersonaModel> lisModels(List<Persona> personas) throws PersonaConverterException {
		List<PersonaModel> personaModels = new ArrayList<PersonaModel>();
		
		try {
			for(Persona persona : personas) {
				personaModels.add(entidadToModel(persona));
			}
		} catch (Exception e) {
			throw new PersonaConverterException(""+e.getMessage());
		}
		
		return personaModels;
	}

}
