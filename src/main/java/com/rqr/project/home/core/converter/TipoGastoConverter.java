package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.TipoGasto;
import com.rqr.project.home.core.error.TipoGastoConverterException;
import com.rqr.project.home.core.model.TipoGastoModel;

public interface TipoGastoConverter {
	
	public TipoGasto modelToEntidad(TipoGastoModel tipoGastoModel) throws TipoGastoConverterException;
	
	public List<TipoGastoModel> lisTipoGastoModels(List<TipoGasto> tipoGastos) throws TipoGastoConverterException;
	
	public TipoGastoModel entidadToModel(TipoGasto tipoGasto) throws TipoGastoConverterException;

}
