package com.rqr.project.home.core.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.TipoGasto;
import com.rqr.project.home.core.error.TipoGastoConverterException;
import com.rqr.project.home.core.model.TipoGastoModel;

@Component("tipoGastoConverter")
public class TipoGastoConverterImp implements TipoGastoConverter {

	@Override
	public TipoGasto modelToEntidad(TipoGastoModel tipoGastoModel) throws TipoGastoConverterException {
		TipoGasto tipoGasto = null;
		
		try {
			tipoGasto = new TipoGasto();
			
			if(tipoGastoModel.getDescripcion()!=null)
				tipoGasto.setDescripcion(tipoGastoModel.getDescripcion().toUpperCase());
			if(tipoGastoModel.getFechaAlta()!=null) {
				tipoGasto.setFechaAlta(tipoGastoModel.getFechaAlta());
			} else {
				tipoGasto.setFechaAlta(LocalDate.now());
			}
			if(tipoGastoModel.getIdTipoGasto()!=0)
				tipoGasto.setIdTipoGasto(tipoGastoModel.getIdTipoGasto());
			if(tipoGastoModel.getNombre()!=null)
				tipoGasto.setNombre(tipoGastoModel.getNombre().toUpperCase());
			
		} catch (Exception e) {
			throw new TipoGastoConverterException(e.getMessage());
		}
		
		return tipoGasto;
	}

	@Override
	public List<TipoGastoModel> lisTipoGastoModels(List<TipoGasto> tipoGastos) throws TipoGastoConverterException {
		List<TipoGastoModel> tipoGastoModels = new ArrayList<>();
		
		try {
			if(!tipoGastos.isEmpty()) {
				for(TipoGasto tipoGasto : tipoGastos) {
					tipoGastoModels.add(entidadToModel(tipoGasto));
				}
			}
			
		} catch (Exception e) {
			throw new TipoGastoConverterException(""+e.getMessage());
		}

		return tipoGastoModels;
	}

	@Override
	public TipoGastoModel entidadToModel(TipoGasto tipoGasto) throws TipoGastoConverterException {
		TipoGastoModel tipoGastoModel = null;
		
		try {
			
			if(tipoGasto!=null) {
				tipoGastoModel = new TipoGastoModel();
				
				if(tipoGasto.getIdTipoGasto()!=0)
					tipoGastoModel.setIdTipoGasto(tipoGasto.getIdTipoGasto());
				if(tipoGasto.getDescripcion()!=null)
					tipoGastoModel.setDescripcion(tipoGasto.getDescripcion().toUpperCase());
				if(tipoGasto.getFechaAlta()!=null)
					tipoGastoModel.setFechaAlta(tipoGasto.getFechaAlta());
				if(tipoGasto.getNombre()!=null)
					tipoGastoModel.setNombre(tipoGasto.getNombre().toUpperCase());
			}
		} catch (Exception e) {
			throw new TipoGastoConverterException(""+e.getMessage());
		}
		
		return tipoGastoModel;
	}

}
