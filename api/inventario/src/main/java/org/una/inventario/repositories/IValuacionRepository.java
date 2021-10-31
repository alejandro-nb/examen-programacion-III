package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Valuacion;

import java.util.List;

@Repository
public interface IValuacionRepository extends JpaRepository<Valuacion, Long> {
}
