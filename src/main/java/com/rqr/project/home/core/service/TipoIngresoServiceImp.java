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

import com.rqr.project.home.core.converter.TipoIngresoConverter;
import com.rqr.project.home.core.entity.TipoIngreso;
import com.rqr.project.home.core.error.CodigoError;
import com.rqr.project.home.core.error.TipoIngresoServiceException;
import com.rqr.project.home.core.model.TipoIngresoModel;
import com.rqr.project.home.core.repo.TipoIngresoRepo;

@Service("tipoIngresoService")
public class TipoIngresoServiceImp implements TipoIngresoService {
	@Autowired
	@Qualifier("tipoIngresoRepo")
	private TipoIngresoRepo tipoIngresoRepo;
	@Autowired
	@Qualifier("tipoIngresoConverter")
	private TipoIngresoConverter tipoIngresoConverter;
	
	@Override
	public boolean crateTipoIngreso(TipoIngresoModel tipoIngresoModel) throws TipoIngresoServiceException {
		boolean edo = true;
		
		try {
			tipoIngresoRepo.save(tipoIngresoConverter.modelToEntidad(tipoIngresoModel));
			edo = true;
		} catch (Exception e) {
			throw new TipoIngresoServiceException(CodigoError.ERRO_CREAR_TIPO_INGRESO+" "+e.getMessage());
		}
		return edo;
	}

	@Override
	public List<TipoIngresoModel> listarAll(Integer pageNo, Integer pageSize, String sortBy)
			throws TipoIngresoServiceException {
		List<TipoIngresoModel> tipoIngresoModels = null;
		
		try {
			tipoIngresoModels = new ArrayList<>();
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<TipoIngreso> pagedResult = tipoIngresoRepo.findAll(paging);
			
			if(pagedResult.hasContent()) {
				tipoIngresoModels = tipoIngresoConverter.listEntidadToListModel(pagedResult.getContent());
			}
			
		} catch (Exception e) {
			throw new TipoIngresoServiceException(CodigoError.ERRO_LISTAR_TIPO_INGRESO+" "+e.getMessage());
		}
		return tipoIngresoModels;
	}

}
