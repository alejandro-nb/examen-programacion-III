package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Parametro;

import java.util.List;
import java.util.Optional;

@Repository
public interface IParametroRepository extends JpaRepository<Parametro, Long> {
    public List<Parametro> findByEstado(Boolean estado);

    public Optional<Parametro> findByNombre(String nombre);
}
