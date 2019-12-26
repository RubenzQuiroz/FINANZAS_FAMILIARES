package com.rqr.project.home.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rqr.project.home.core.entity.Perfil;

public interface PerfilRepo extends JpaRepository<Perfil, Integer>, PagingAndSortingRepository<Perfil, Integer>{

}
