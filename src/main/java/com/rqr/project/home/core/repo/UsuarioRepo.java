package com.rqr.project.home.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rqr.project.home.core.entity.Usuario;

@Repository("usuarioRepo")
public interface UsuarioRepo extends JpaRepository<Usuario, Integer>,PagingAndSortingRepository<Usuario, Integer>{
	
	public abstract Optional<Usuario> findByUsername(String username);
	
}
