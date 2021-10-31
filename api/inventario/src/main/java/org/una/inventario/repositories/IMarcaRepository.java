package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Marca;

import java.util.List;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Long> {
    public List<Marca> findByEstado(Boolean estado);
}
