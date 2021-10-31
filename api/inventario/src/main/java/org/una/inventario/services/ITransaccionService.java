package org.una.inventario.services;

import org.una.inventario.dto.TransaccionDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    public Optional<TransaccionDTO> findById(Long id);

    public Optional<List<TransaccionDTO>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO);
}
