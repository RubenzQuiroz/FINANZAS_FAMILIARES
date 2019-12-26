package com.rqr.project.home.core.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.Perfil;
import com.rqr.project.home.core.error.PerfilConverterException;
import com.rqr.project.home.core.model.PerfilModel;

@Component
public class PerfilConverterImpl implements PerfilConverter {

	@Override
	public Perfil modelEntidad(PerfilModel perfilModel) throws PerfilConverterException {
		Perfil perfil = new Perfil();
		
		try {
			if(perfilModel.getDescripcion()!=null)
				perfil.setDescripcion(perfilModel.getDescripcion());
			if(perfilModel.getFechaAlta()!=null)
				perfil.setFechaAlta(perfilModel.getFechaAlta());
			if(perfilModel.getIdPerfil()!=0)
				perfil.setIdPerfil(perfilModel.getIdPerfil());
			if(perfilModel.getNombrePerfil()!=null)
				perfil.setNombrePerfil(perfilModel.getNombrePerfil());
				
		} catch (Exception e) {
			throw new PerfilConverterException(""+e.getMessage());
		}
		
		return perfil;
	}

	@Override
	public PerfilModel entidadToModel(Perfil perfil) throws PerfilConverterException {
		PerfilModel perfilModel = new PerfilModel();
		
		try {
			if(perfil.getDescripcion()!=null)
				perfilModel.setDescripcion(perfilModel.getDescripcion());
			if(perfil.getFechaAlta()!=null)
				perfilModel.setFechaAlta(perfilModel.getFechaAlta());
			if(perfil.getIdPerfil()!=0)
				perfilModel.setIdPerfil(perfilModel.getIdPerfil());
			if(perfil.getNombrePerfil()!=null)
				perfilModel.setNombrePerfil(perfilModel.getNombrePerfil());
				
		} catch (Exception e) {
			throw new PerfilConverterException(""+e.getMessage());
		}
		
		return perfilModel;
	}

	@Override
	public List<PerfilModel> lisToModels(List<Perfil> perfils) throws PerfilConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perfil> lisToEntitys(List<PerfilModel> perfilModels) throws PerfilConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
