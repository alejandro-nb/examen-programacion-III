package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Transaccion;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {


}
