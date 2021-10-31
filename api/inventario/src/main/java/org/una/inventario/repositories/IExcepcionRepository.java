package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Excepcion;

@Repository
public interface IExcepcionRepository extends JpaRepository<Excepcion, Long> {
}
