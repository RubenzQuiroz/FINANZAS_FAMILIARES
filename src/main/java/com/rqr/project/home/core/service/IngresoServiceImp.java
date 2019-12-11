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

import com.rqr.project.home.core.converter.IngresoConverter;
import com.rqr.project.home.core.entity.Ingreso;
import com.rqr.project.home.core.error.IngresoServiceException;
import com.rqr.project.home.core.model.IngresoModel;
import com.rqr.project.home.core.repo.IngresoRepo;

@Service("ingresoService")
public class IngresoServiceImp implements IngresoService {
	@Autowired
	@Qualifier("ingresoRepo")
	private IngresoRepo ingresoRepo;
	@Autowired
	@Qualifier("IngresoConverter")
	private IngresoConverter ingresoConverter;

	@Override
	public boolean crear(IngresoModel ingresoModel) throws IngresoServiceException {
		boolean edo = false;
		
		try {
			ingresoRepo.save(ingresoConverter.modelToEntidad(ingresoModel));
			edo = true;
			
		} catch (Exception e) {
			throw new IngresoServiceException(e.getMessage());
		}
		
		return edo;
	}

	@Override
	public List<IngresoModel> listarModels(Integer pageNo, Integer pageSize, String sortBy)
			throws IngresoServiceException {
		List<IngresoModel> ingresoModels = null;
		
		try {
			ingresoModels = new ArrayList<>();
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Ingreso> pagedResult = ingresoRepo.findAll(paging);
			
			if(pagedResult.hasContent()) {
				ingresoModels = ingresoConverter.listEntidadToModel(pagedResult.getContent());
			}
			
		} catch (Exception e) {
			throw new IngresoServiceException(e.getMessage());
		}
		
		return ingresoModels;
	}

	@Override
	public boolean actualizar(IngresoModel ingresoModel) throws IngresoServiceException {
		boolean edo = false;
		
		try {
			ingresoRepo.save(ingresoConverter.modelToEntidad(ingresoModel));
			edo = true;
		} catch (Exception e) {
			throw new IngresoServiceException(e.getMessage());
		}
		
		return edo;
	}

	@Override
	public boolean eliminar(IngresoModel ingresoModel) throws IngresoServiceException {
		boolean edo = false;
		
		try {
			ingresoRepo.delete(ingresoConverter.modelToEntidad(ingresoModel));
			edo = true;
			
		} catch (Exception e) {
			throw new IngresoServiceException(e.getMessage());
		}
		
		return edo;
	}

}
