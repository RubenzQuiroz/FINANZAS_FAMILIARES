package com.rqr.project.home.core.service;

import java.util.List;

import com.rqr.project.home.core.error.TipoIngresoServiceException;
import com.rqr.project.home.core.model.TipoIngresoModel;

public interface TipoIngresoService {
	
	public boolean crateTipoIngreso(TipoIngresoModel tipoIngresoModel) throws TipoIngresoServiceException;
	
	public List<TipoIngresoModel> listarAll(Integer pageNo, Integer pageSize, String sortBy) throws TipoIngresoServiceException;

}
