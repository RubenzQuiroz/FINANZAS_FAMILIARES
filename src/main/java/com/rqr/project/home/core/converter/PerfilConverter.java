package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.Perfil;
import com.rqr.project.home.core.error.PerfilConverterException;
import com.rqr.project.home.core.model.PerfilModel;

public interface PerfilConverter {
	
	public Perfil modelEntidad(PerfilModel perfilModel) throws PerfilConverterException;
	
	public PerfilModel entidadToModel(Perfil perfil) throws PerfilConverterException;
	
	public List<PerfilModel> lisToModels(List<Perfil> perfils) throws PerfilConverterException;
	
	public List<Perfil> lisToEntitys(List<PerfilModel> perfilModels) throws PerfilConverterException;

}
