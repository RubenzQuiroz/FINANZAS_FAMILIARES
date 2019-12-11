package com.rqr.project.home.core.service;

import java.util.List;

import com.rqr.project.home.core.error.GastoServicException;
import com.rqr.project.home.core.model.GastoModel;

public interface GastoService {
	
	public boolean crear(GastoModel gastoModel) throws GastoServicException;
	
	public List<GastoModel> listarModels(Integer pageNo, Integer pageSize, String sortBy) throws GastoServicException;
	
	public boolean actualizar(GastoModel gastoModel) throws GastoServicException;
	
	public boolean eliminar(GastoModel gastoModel) throws GastoServicException;

}
