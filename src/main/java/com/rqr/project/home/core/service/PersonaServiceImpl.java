package com.rqr.project.home.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rqr.project.home.core.converter.PersonaConverter;
import com.rqr.project.home.core.entity.Persona;
import com.rqr.project.home.core.error.PersonaServiceException;
import com.rqr.project.home.core.model.PersonaModel;
import com.rqr.project.home.core.repo.PersonaRepo;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaConverter personaConverter;
	@Autowired
	@Qualifier("personaRepo")
	private PersonaRepo personaRepo;

	@Override
	public boolean crear(PersonaModel personaModel) throws PersonaServiceException {
		boolean edo = false;
		
		try {
			personaRepo.save(personaConverter.modelEntidad(personaModel));
			edo = true;
		} catch (PersonaServiceException e) {
			throw new PersonaServiceException(""+e.getMessage());
		} catch (Exception e) {
			throw new PersonaServiceException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public List<PersonaModel> listarModels(Integer pageNo, Integer pageSize, String sortBy)
			throws PersonaServiceException {
		List<PersonaModel> personaModels = new ArrayList<PersonaModel>();
		
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Persona> pagedResult = personaRepo.findAll(pageable);
			
			if(pagedResult.hasContent()) {
				personaModels = personaConverter.lisModels(pagedResult.getContent());
			}
		} catch (Exception e) {
			throw new PersonaServiceException(""+e.getMessage());
		}
		
		return personaModels;
	}

	@Override
	public boolean actualizar(PersonaModel personaModel) throws PersonaServiceException {
		boolean edo = false;
		
		try {
			personaRepo.save(personaConverter.modelEntidad(personaModel));
			edo = true;
		} catch (PersonaServiceException e) {
			throw new PersonaServiceException(""+e.getMessage());
		} catch (Exception e) {
			throw new PersonaServiceException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public boolean eliminar(PersonaModel personaModel) throws PersonaServiceException {
		boolean edo = false;
		
		try {
			personaRepo.delete(personaConverter.modelEntidad(personaModel));
			edo = true;
		} catch (Exception e) {
			throw new PersonaServiceException(""+e.getMessage());
		}
		
		return edo;
	}

}
