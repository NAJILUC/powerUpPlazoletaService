package com.pragma.plazoleta.infrastructure.out.jpa.repository;

import com.pragma.plazoleta.infrastructure.out.jpa.entity.Restaurante_empleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurante_empleadoRepository extends JpaRepository<Restaurante_empleadoEntity, Long> {
}
