package com.rqr.project.home;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rqr.project.home.core.entity.Perfil;
import com.rqr.project.home.core.entity.Persona;
import com.rqr.project.home.core.entity.Usuario;
import com.rqr.project.home.core.repo.PersonaRepo;
import com.rqr.project.home.core.repo.UsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeApplicationTests {
	@Autowired
	@Qualifier("usuarioRepo")
	private UsuarioRepo usurioRepo;
	@Autowired
	@Qualifier("personaRepo")
	private PersonaRepo personaRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void contextLoads() {
		Persona persona = new Persona(1);
		Perfil uno = new Perfil(1);
		Set<Perfil> perfiles = new HashSet<>();
		perfiles.add(uno);
		
		Usuario usuario = new Usuario();
		usuario.setCorreo("rqrsharingan@gmail.com");
		usuario.setFechaAlta(LocalDate.now());
		usuario.setPassword(encoder.encode("superadmin"));
		usuario.setPerfiles(perfiles);
		usuario.setPersona(persona);
		usuario.setUsername("MRN21837");
		
		Usuario usuarioSalida = usurioRepo.save(usuario);
		assertTrue(usuarioSalida.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}

}
