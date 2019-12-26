package com.rqr.project.home.core.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.TipoIngreso;
import com.rqr.project.home.core.error.CodigoError;
import com.rqr.project.home.core.error.TipoIngresoConverterError;
import com.rqr.project.home.core.model.TipoIngresoModel;

@Component("tipoIngresoConverter")
public class TipoIngresoConverterImp implements TipoIngresoConverter{
	
	public TipoIngreso modelToEntidad(TipoIngresoModel tipoIngresoModel) throws TipoIngresoConverterError{
		TipoIngreso tipoIngreso = null;
		
		try {
			tipoIngreso = new TipoIngreso();
			
			if(tipoIngresoModel.getIdTipoIngreso()!=0) {
				tipoIngreso.setIdTipoIngreso(tipoIngresoModel.getIdTipoIngreso());
			}
			
			if(tipoIngresoModel.getNombre()!=null)
				tipoIngreso.setNombre(tipoIngresoModel.getNombre().toUpperCase());
			
			if(tipoIngresoModel.getDescripcion()!=null)
				tipoIngreso.setDescripcion(tipoIngresoModel.getDescripcion().toUpperCase());
			
			if(tipoIngresoModel.getFechaAlta()!=null) {
				tipoIngreso.setFechaAlta(tipoIngresoModel.getFechaAlta());
			} else {
				tipoIngreso.setFechaAlta(LocalDate.now());
			}
				
		} catch (Exception e) {
			throw new TipoIngresoConverterError(CodigoError.ERRO_CONVERTIR_TIPO_INGRESO+" "+e.getMessage());
		}
		
		return tipoIngreso;
	}

	@Override
	public List<TipoIngresoModel> listEntidadToListModel(List<TipoIngreso> tipoIngresos)
			throws TipoIngresoConverterError {
		List<TipoIngresoModel> tipoIngresoModels = null;
		
		try {
			tipoIngresoModels = new ArrayList<>();
			
			for(TipoIngreso tipoIngreso : tipoIngresos) {
				tipoIngresoModels.add(entidadToModel(tipoIngreso));
			}
			
		} catch (Exception e) {
			throw new TipoIngresoConverterError(CodigoError.ERRO_CONVERTIR_TIPO_INGRESO+" "+e.getMessage());
		}
		
		return tipoIngresoModels;
	}

	@Override
	public TipoIngresoModel entidadToModel(TipoIngreso tipoIngreso) throws TipoIngresoConverterError {
		TipoIngresoModel tipoIngresoModel = null;
		
		try {
			tipoIngresoModel = new TipoIngresoModel();
			
			if(tipoIngreso.getIdTipoIngreso()!=0)
				tipoIngresoModel.setIdTipoIngreso(tipoIngreso.getIdTipoIngreso());
			if(tipoIngreso.getNombre()!=null)
				tipoIngresoModel.setNombre(tipoIngreso.getNombre().toUpperCase());
			if(tipoIngreso.getDescripcion()!=null)
				tipoIngresoModel.setDescripcion(tipoIngreso.getDescripcion().toUpperCase());
			if(tipoIngreso.getFechaAlta()!=null)
				tipoIngresoModel.setFechaAlta(tipoIngreso.getFechaAlta());
			
		} catch (Exception e) {
			throw new TipoIngresoConverterError(CodigoError.ERRO_CONVERTIR_TIPO_INGRESO+" "+e.getMessage());
		}
		
		return tipoIngresoModel;
	}

}
