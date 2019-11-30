package com.rqr.project.home.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rqr.project.home.core.entity.TipoIngreso;

@Repository("tipoIngresoRepo")
public interface TipoIngresoRepo extends JpaRepository<TipoIngreso, Integer>,PagingAndSortingRepository<TipoIngreso, Integer>{

}
