package com.rqr.project.home.core.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.Ingreso;
import com.rqr.project.home.core.error.IngresoConverterException;
import com.rqr.project.home.core.model.IngresoModel;

@Component("IngresoConverter")
public class IngresoConverterImp implements IngresoConverter{
	@Autowired
	@Qualifier("tipoIngresoConverter")
	private TipoIngresoConverter tipoIngresoConverter;

	@Override
	public Ingreso modelToEntidad(IngresoModel ingresoModel) throws IngresoConverterException {
		Ingreso ingreso = null;
		
		try {
			ingreso = new Ingreso();
			
			if(ingresoModel.getIdIngreso()!=0)
				ingreso.setIdIngreso(ingresoModel.getIdIngreso());
			if(ingresoModel.getNombre()!=null)
				ingreso.setNombre(ingresoModel.getNombre());
			if(ingresoModel.getDescripcion()!=null)
				ingreso.setDescripcion(ingresoModel.getDescripcion());
			if(ingresoModel.getTipoIngresoModel()!=null) 
				ingreso.setTipoIngreso(tipoIngresoConverter.modelToEntidad(ingresoModel.getTipoIngresoModel()));
			if(ingresoModel.getFechaAlta()!=null) {
				ingreso.setFechaAlta(ingresoModel.getFechaAlta());
			} else {
				ingreso.setFechaAlta(LocalDate.now());
			}
				
			
				
		} catch (Exception e) {
			throw new IngresoConverterException(e.getMessage());
		}
		
		return ingreso;
	}

	@Override
	public List<IngresoModel> listEntidadToModel(List<Ingreso> ingresos) throws IngresoConverterException {
		List<IngresoModel> ingresoModels = null;
		
		try {
			ingresoModels = new ArrayList<>();
			
			for(Ingreso ingreso : ingresos) {
				
				ingresoModels.add(entidadToModel(ingreso));
			}
			
		} catch (Exception e) {
			throw new IngresoConverterException(e.getMessage());
		}
		
		return ingresoModels;
	}

	@Override
	public IngresoModel entidadToModel(Ingreso ingreso) throws IngresoConverterException {
		IngresoModel ingresoModel = null;
		
		try {
			ingresoModel = new IngresoModel();
			
			if(ingreso.getIdIngreso()!=0)
				ingresoModel.setIdIngreso(ingreso.getIdIngreso());
			if(ingreso.getNombre()!=null)
				ingresoModel.setNombre(ingreso.getNombre().toUpperCase());
			if(ingreso.getDescripcion()!=null)
				ingresoModel.setDescripcion(ingreso.getDescripcion().toUpperCase());
			if(ingreso.getTipoIngreso()!=null)
				ingresoModel.setTipoIngresoModel(tipoIngresoConverter.entidadToModel(ingreso.getTipoIngreso()));
			if(ingreso.getFechaAlta()!=null)
				ingresoModel.setFechaAlta(ingreso.getFechaAlta());
			
		} catch (Exception e) {
			throw new IngresoConverterException(e.getMessage());
		}
		
		return ingresoModel;
	}

}
