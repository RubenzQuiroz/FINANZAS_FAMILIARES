package com.rqr.project.home.core.converter;

import java.util.List;

import com.rqr.project.home.core.entity.Usuario;
import com.rqr.project.home.core.error.UsuarioConverterException;
import com.rqr.project.home.core.model.UsuarioModel;

public interface UsuarioConverter {
	
	public Usuario modelEntidad(UsuarioModel usuarioModel) throws UsuarioConverterException;
	
	public UsuarioModel entidadToModel(Usuario usuario) throws UsuarioConverterException;
	
	public List<UsuarioModel> lisModels(List<Usuario> usuarios) throws UsuarioConverterException;
	
	public List<Usuario> lisEntitys(List<UsuarioModel> usuariosModels) throws UsuarioConverterException;
	
}
