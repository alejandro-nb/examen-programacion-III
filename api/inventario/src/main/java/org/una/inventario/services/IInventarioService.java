package org.una.inventario.services;

import org.una.inventario.dto.InventarioDTO;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IInventarioService {
    public Optional<List<InventarioDTO>> findByEstado(Boolean estado);

    public Optional<List<InventarioDTO>> findAll();

    public Optional<InventarioDTO> findById(Long id);

    public Optional<InventarioDTO> create(InventarioDTO inventarioDTO);

    public Optional<InventarioDTO> update(InventarioDTO inventarioDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public CompletableFuture<Boolean> generateInventario(Long id);
}
