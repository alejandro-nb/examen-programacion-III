package org.una.inventario.repositories;

import net.bytebuddy.implementation.bind.annotation.Argument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Inventario;

import java.util.List;

@Repository
public interface IInventarioRepository extends JpaRepository<Inventario, Long> {
    public List<Inventario> findByEstado(Boolean estado);

    @Query(value = "CALL calc_valuaciones(:id_in);", nativeQuery = true)
    public int generarInventario(@Param("id_in") Long id);


}