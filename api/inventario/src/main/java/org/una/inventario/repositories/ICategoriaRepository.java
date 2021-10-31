package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Categoria;

import java.util.List;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    public List<Categoria> findByEstado(Boolean estado);
}
