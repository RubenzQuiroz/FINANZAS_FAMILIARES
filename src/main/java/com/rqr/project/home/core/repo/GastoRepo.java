package com.rqr.project.home.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rqr.project.home.core.entity.Gasto;

@Repository("gastoRepo")
public interface GastoRepo extends JpaRepository<Gasto, Long>, PagingAndSortingRepository<Gasto, Long> {

}
