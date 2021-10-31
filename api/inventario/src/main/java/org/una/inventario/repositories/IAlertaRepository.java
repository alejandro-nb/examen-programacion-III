package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Alerta;

import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta, Long> {

    public List<Alerta> findByEstado(Boolean estado);
}
