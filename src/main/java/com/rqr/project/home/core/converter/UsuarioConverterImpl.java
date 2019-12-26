package com.rqr.project.home.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rqr.project.home.core.entity.Usuario;
import com.rqr.project.home.core.error.PersonaConverterException;
import com.rqr.project.home.core.error.UsuarioConverterException;
import com.rqr.project.home.core.model.UsuarioModel;

@Component
public class UsuarioConverterImpl implements UsuarioConverter{
	@Autowired
	private PersonaConverter personaConverter;

	@Override
	public Usuario modelEntidad(UsuarioModel usuarioModel) throws UsuarioConverterException {
		Usuario usuario = new Usuario();
		
		try {
			if(usuarioModel.getCorreo()!=null)
				usuario.setCorreo(usuarioModel.getCorreo());
			if(usuarioModel.getFechaAlta()!=null)
				usuario.setFechaAlta(usuarioModel.getFechaAlta());
			if(usuarioModel.getIdUsuario()!=0)
				usuario.setIdUsuario(usuarioModel.getIdUsuario());
			if(usuarioModel.getPassword()!=null)
				usuario.setPassword(usuarioModel.getPassword());
			if(!usuarioModel.getPerfiles().isEmpty()) {
				
			}
			if(usuarioModel.getPersonaModel()!=null)
				usuario.setPersona(personaConverter.modelEntidad(usuarioModel.getPersonaModel()));
				
		} catch (PersonaConverterException e) {
			throw new UsuarioConverterException(""+e.getMessage());
		} catch (Exception e) {
			throw new UsuarioConverterException(""+e.getMessage());
		}
		
		return usuario;
	}

	@Override
	public UsuarioModel entidadToModel(Usuario usuario) throws UsuarioConverterException {
		UsuarioModel usuarioModel = new UsuarioModel();
		
		try {
			if(usuario.getCorreo()!=null)
				usuarioModel.setCorreo(usuario.getCorreo());
			if(usuario.getFechaAlta()!=null)
				usuarioModel.setFechaAlta(usuario.getFechaAlta());
			if(usuario.getIdUsuario()!=0)
				usuarioModel.setIdUsuario(usuario.getIdUsuario());
			if(usuario.getPassword()!=null)
				usuarioModel.setPassword(usuario.getPassword());
			if(!usuario.getPerfiles().isEmpty()) {
				
			}
			if(usuario.getPersona()!=null)
				usuarioModel.setPersonaModel(personaConverter.entidadToModel(usuario.getPersona()));
		} catch (PersonaConverterException e) {
			throw new UsuarioConverterException(""+e.getMessage());
		} catch (Exception e) {
			throw new UsuarioConverterException(""+e.getMessage());
		}
		
		return usuarioModel;
	}

	@Override
	public List<UsuarioModel> lisModels(List<Usuario> usuarios) throws UsuarioConverterException {
		List<UsuarioModel> usuarioModels = new ArrayList<UsuarioModel>();
		
		try {
			for(Usuario usuario : usuarios) {
				usuarioModels.add(entidadToModel(usuario));
			}
			
		} catch (Exception e) {
			throw new UsuarioConverterException(""+e.getMessage());
		}
		
		return usuarioModels;
	}

	@Override
	public List<Usuario> lisEntitys(List<UsuarioModel> usuariosModels) throws UsuarioConverterException {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			for(UsuarioModel usuarioModel : usuariosModels) {
				usuarios.add(modelEntidad(usuarioModel));
			}
		} catch (Exception e) {
			throw new UsuarioConverterException(""+e.getMessage());
		}
		
		return usuarios;
	}

}
