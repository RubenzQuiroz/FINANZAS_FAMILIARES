package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.Ingreso;
import com.rqr.project.home.core.error.IngresoConverterException;
import com.rqr.project.home.core.model.IngresoModel;

public interface IngresoConverter {
	
	public Ingreso modelToEntidad(IngresoModel ingresoModel) throws IngresoConverterException;
	
	public List<IngresoModel> listEntidadToModel(List<Ingreso> ingresos) throws IngresoConverterException;
	
	public IngresoModel entidadToModel(Ingreso ingreso) throws IngresoConverterException;
	

}
