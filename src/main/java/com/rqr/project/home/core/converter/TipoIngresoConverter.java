package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.TipoIngreso;
import com.rqr.project.home.core.error.TipoIngresoConverterError;
import com.rqr.project.home.core.model.TipoIngresoModel;

public interface TipoIngresoConverter {
	
	public TipoIngreso modelToEntidad(TipoIngresoModel tipoIngresoModel) throws TipoIngresoConverterError;
	
	public List<TipoIngresoModel> listEntidadToListModel(List<TipoIngreso> tipoIngresos) throws TipoIngresoConverterError;
	
	public TipoIngresoModel entidadToModel(TipoIngreso tipoIngreso) throws TipoIngresoConverterError;
	
}
