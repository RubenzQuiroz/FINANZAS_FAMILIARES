package com.rqr.project.home.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.Gasto;
import com.rqr.project.home.core.error.GastoConverterException;
import com.rqr.project.home.core.error.TipoGastoConverterException;
import com.rqr.project.home.core.model.GastoModel;

@Component("gastoConverter")
public class GastoConverterImpl implements GastoConverter{
	@Autowired
	@Qualifier("tipoGastoConverter")
	private TipoGastoConverter tipoGastoConverter;
	
	@Override
	public Gasto modelEntidad(GastoModel gastoModel) throws GastoConverterException {
		Gasto gasto = null;
		
		try {
			if(gastoModel != null) {
				gasto = new Gasto();
				
				if(gastoModel.getIdGasto()!=0)
					gasto.setIdGasto(gastoModel.getIdGasto());
				if(gastoModel.getDescripcion()!=null)
					gasto.setDescripcion(gastoModel.getDescripcion().toUpperCase());
				if(gastoModel.getNombre()!=null)
					gasto.setNombre(gastoModel.getNombre().toUpperCase());
				if(gastoModel.getTipoGastoModel()!=null)
					gasto.setTipoGasto(tipoGastoConverter.modelToEntidad(gastoModel.getTipoGastoModel()));
			}
			
		} catch (TipoGastoConverterException e) {
			throw new GastoConverterException(""+e.getMessage());
		} catch (Exception e) {
			throw new GastoConverterException(""+e.getMessage());
		}
		
		return gasto;
	}

	@Override
	public GastoModel entidadToModel(Gasto gasto) throws GastoConverterException {
		GastoModel gastoModel = null;
		
		try {
			if(gasto != null) {
				gastoModel = new GastoModel();
				
				if(gasto.getDescripcion()!=null)
					gastoModel.setDescripcion(gasto.getDescripcion().toUpperCase());
				if(gasto.getIdGasto()!=0)
					gastoModel.setIdGasto(gasto.getIdGasto());
				if(gasto.getNombre()!=null)
					gastoModel.setNombre(gasto.getNombre().toUpperCase());
				if(gasto.getTipoGasto()!=null)
					gastoModel.setTipoGastoModel(tipoGastoConverter.entidadToModel(gasto.getTipoGasto()));
			}
			
		} catch (TipoGastoConverterException e) {
			throw new GastoConverterException(""+e.getMessage());
		} catch (Exception e) {
			throw new GastoConverterException(""+e.getMessage());
		}
		
		return gastoModel;
	}

	@Override
	public List<GastoModel> lisModels(List<Gasto> gastos) throws GastoConverterException {
		List<GastoModel> gastoModels = null;
		
		try {
			if(!gastos.isEmpty()) {
				gastoModels = new ArrayList<GastoModel>();
				
				for(Gasto gasto : gastos) {
					gastoModels.add(entidadToModel(gasto));
				}
			}
		} catch (Exception e) {
			throw new GastoConverterException(""+e.getMessage());
		}
		
		return gastoModels;
	}
	
	

}
