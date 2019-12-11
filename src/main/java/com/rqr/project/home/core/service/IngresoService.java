package com.rqr.project.home.core.service;

import java.util.List;

import com.rqr.project.home.core.error.IngresoServiceException;
import com.rqr.project.home.core.model.IngresoModel;

public interface IngresoService {
	
	public boolean crear(IngresoModel ingresoModel) throws IngresoServiceException;
	
	public List<IngresoModel> listarModels(Integer pageNo, Integer pageSize, String sortBy) throws IngresoServiceException;
	
	public boolean actualizar(IngresoModel ingresoModel) throws IngresoServiceException;
	
	public boolean eliminar(IngresoModel ingresoModel) throws IngresoServiceException;
	
}
