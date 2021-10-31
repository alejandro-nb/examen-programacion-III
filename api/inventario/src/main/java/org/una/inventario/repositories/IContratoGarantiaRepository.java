package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.ContratoGarantia;

import java.util.List;

@Repository
public interface IContratoGarantiaRepository extends JpaRepository<ContratoGarantia, Long> {
    public List<ContratoGarantia> findByEstado(Boolean estado);
}
