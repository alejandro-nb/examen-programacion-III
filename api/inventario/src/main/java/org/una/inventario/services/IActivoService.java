package org.una.inventario.services;

import org.una.inventario.dto.ActivoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IActivoService {
    public Optional<List<ActivoDTO>> findAll();

    public Optional<ActivoDTO> findById(Long id);

    public Optional<ActivoDTO> create(ActivoDTO activoDTO);

    public Optional<ActivoDTO> update(ActivoDTO activoDTO, Long id);

    public void delete(Long id);

    public Optional<List<ActivoDTO>> findByEstado(boolean estado);

    public void deleteAll();

    public CompletableFuture<List<ActivoDTO>> getActivosBetweenFechas(LocalDate minFecha, LocalDate maxFecha);
}
