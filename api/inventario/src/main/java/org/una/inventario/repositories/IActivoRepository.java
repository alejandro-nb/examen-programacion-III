package org.una.inventario.repositories;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Activo;
import org.una.inventario.entities.Valuacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IActivoRepository extends JpaRepository<Activo, Long> {
    public List<Activo> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM activos a where a.fecha_creacion > :c_fechamin AND a.fecha_creacion < :c_fechamax", nativeQuery = true)
    public Optional<List<Activo>> getActivosBetweenFechas(@Param("c_fechamin") LocalDate fechaMin, @Param("c_fechamax") LocalDate fechaMax);
}
