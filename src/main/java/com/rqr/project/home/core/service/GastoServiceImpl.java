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

import com.rqr.project.home.core.converter.GastoConverter;
import com.rqr.project.home.core.entity.Gasto;
import com.rqr.project.home.core.error.GastoServicException;
import com.rqr.project.home.core.model.GastoModel;
import com.rqr.project.home.core.repo.GastoRepo;

@Service("gastoService")
public class GastoServiceImpl implements GastoService{
	@Autowired
	@Qualifier("gastoRepo")
	private GastoRepo gastoRepo;
	@Autowired
	@Qualifier("gastoConverter")
	private GastoConverter gastoConverter;

	@Override
	public boolean crear(GastoModel gastoModel) throws GastoServicException {
		boolean edo = false;
		
		try {
			gastoRepo.save(gastoConverter.modelEntidad(gastoModel));
			edo = true;
			
		} catch (Exception e) {
			throw new GastoServicException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public List<GastoModel> listarModels(Integer pageNo, Integer pageSize, String sortBy) throws GastoServicException {
		List<GastoModel> list = null;
		
		try {
			list = new ArrayList<GastoModel>();
			Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Gasto> pagedResult = gastoRepo.findAll(pageable);
			
			if(pagedResult.hasContent()) {
				list = gastoConverter.lisModels(pagedResult.getContent());
			}
		} catch (Exception e) {
			throw new GastoServicException(""+e.getMessage());
		}
		
		return list;
	}

	@Override
	public boolean actualizar(GastoModel gastoModel) throws GastoServicException {
		boolean edo = false;
		
		try {
			gastoRepo.save(gastoConverter.modelEntidad(gastoModel));
			edo = true;
			
		} catch (Exception e) {
			throw new GastoServicException(""+e.getMessage());
		}
		
		return edo;
	}

	@Override
	public boolean eliminar(GastoModel gastoModel) throws GastoServicException {
		boolean edo = false;
		
		try {
			gastoRepo.delete(gastoConverter.modelEntidad(gastoModel));
			edo = true;
		} catch (Exception e) {
			throw new GastoServicException(""+e.getMessage());
		}
		
		return edo;
	}

}
