package com.backend.tiendacomida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tiendacomida.model.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
