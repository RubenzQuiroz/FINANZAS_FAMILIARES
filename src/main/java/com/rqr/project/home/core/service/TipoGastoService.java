package com.rqr.project.home.core.service;

import java.util.List;

import com.rqr.project.home.core.error.TipoGastoException;
import com.rqr.project.home.core.model.TipoGastoModel;

public interface TipoGastoService {
	
	public boolean crear(TipoGastoModel tipoGastoModel) throws TipoGastoException;
	
	public List<TipoGastoModel> listarModel(Integer pageNo, Integer pageSize, String sortBy)throws TipoGastoException;
	
	public boolean actualizar(TipoGastoModel tipoGastoModel) throws TipoGastoException;
	
	public boolean eliminar(TipoGastoModel tipoGastoModel) throws TipoGastoException;
	
}
