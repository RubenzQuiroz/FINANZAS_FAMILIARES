package com.rqr.project.home.core.service;

import java.util.List;

import com.rqr.project.home.core.error.PersonaServiceException;
import com.rqr.project.home.core.model.PersonaModel;

public interface PersonaService {
	
	public boolean crear(PersonaModel personaModel) throws PersonaServiceException;
	
	public List<PersonaModel> listarModels(Integer pageNo, Integer pageSize, String sortBy) throws PersonaServiceException; 
	
	public boolean actualizar(PersonaModel personaModel) throws PersonaServiceException; 
	
	public boolean eliminar(PersonaModel personaModel) throws PersonaServiceException; 

}
