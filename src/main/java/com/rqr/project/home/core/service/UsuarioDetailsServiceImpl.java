package com.rqr.project.home.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rqr.project.home.core.entity.Perfil;
import com.rqr.project.home.core.entity.Usuario;
import com.rqr.project.home.core.repo.UsuarioRepo;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{
	@Autowired
	@Qualifier("usuarioRepo")
	private UsuarioRepo usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario: "+username));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		for(Perfil perfil : usuario.getPerfiles()) {
			roles.add(new SimpleGrantedAuthority(perfil.getNombrePerfil()));
		}
		
		UserDetails userDetails = new User(usuario.getUsername(),usuario.getPassword(),roles);
		
		return userDetails;
	}

}
