package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.Gasto;
import com.rqr.project.home.core.error.GastoConverterException;
import com.rqr.project.home.core.model.GastoModel;

public interface GastoConverter {
	
	public Gasto modelEntidad(GastoModel gastoModel) throws GastoConverterException;
	
	public GastoModel entidadToModel(Gasto gasto) throws GastoConverterException;
	
	public List<GastoModel> lisModels(List<Gasto> gastos) throws GastoConverterException;

}
