package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.entities.Departamento;
import org.una.inventario.entities.Rol;

import java.util.Date;
import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
    public List<Rol> findByEstado(Boolean estado);

    public List<Rol> findByFechaCreacionBetween(Date startDate, Date endDate);

    @Query(value = "CALL FIND_ROLES_BY_ESTADO(:estado_in);", nativeQuery = true)
    List<Rol> findRolesByEstado(@Param("estado_in") Boolean estado_in);
}
