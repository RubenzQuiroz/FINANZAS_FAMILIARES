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

import com.rqr.project.home.core.converter.TipoGastoConverter;
import com.rqr.project.home.core.entity.TipoGasto;
import com.rqr.project.home.core.error.TipoGastoException;
import com.rqr.project.home.core.model.TipoGastoModel;
import com.rqr.project.home.core.repo.TipoGastoRepo;

@Service("tipoGastoService")
public class TipoGastoServiceImp implements TipoGastoService {
	@Autowired
	@Qualifier("tipoGastoRepo")
	private TipoGastoRepo tipoGastoRepo;
	@Autowired
	@Qualifier("tipoGastoConverter")
	private TipoGastoConverter tipoGastoConverter;
	
	@Override
	public boolean crear(TipoGastoModel tipoGastoModel) throws TipoGastoException {
		boolean edo = false;
		
		try {
			tipoGastoRepo.save(tipoGastoConverter.modelToEntidad(tipoGastoModel));
			edo = true;
		} catch (Exception e) {
			throw new TipoGastoException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public List<TipoGastoModel> listarModel(Integer pageNo, Integer pageSize, String sortBy) throws TipoGastoException {
		List<TipoGastoModel> liGastoModels = null;
		
		try {
			liGastoModels = new ArrayList<TipoGastoModel>();
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<TipoGasto> pagedResult = tipoGastoRepo.findAll(paging);
			
			if(pagedResult.hasContent()) {
				liGastoModels = tipoGastoConverter.lisTipoGastoModels(pagedResult.getContent());
			}
		} catch (Exception e) {
			throw new TipoGastoException(""+e.getMessage());
		}
		
		return liGastoModels;
	}

	@Override
	public boolean actualizar(TipoGastoModel tipoGastoModel) throws TipoGastoException {
		boolean edo = false;
		
		try {
			tipoGastoRepo.save(tipoGastoConverter.modelToEntidad(tipoGastoModel));
			edo = true;
		} catch (Exception e) {
			throw new TipoGastoException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public boolean eliminar(TipoGastoModel tipoGastoModel) throws TipoGastoException {
		boolean edo = false;
		
		try {
			tipoGastoRepo.delete(tipoGastoConverter.modelToEntidad(tipoGastoModel));
			edo = true;
		} catch (Exception e) {
			throw new TipoGastoException(""+e.getMessage());
		}
		
		return edo;
	}

}
