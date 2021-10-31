package org.una.inventario.services;

import org.una.inventario.dto.ProveedorDTO;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {
    public Optional<List<ProveedorDTO>> findByEstado(Boolean estado);

    public Optional<List<ProveedorDTO>> findAll();

    public Optional<ProveedorDTO> findById(Long id);

    public Optional<ProveedorDTO> create(ProveedorDTO proveedorDTO);

    public Optional<ProveedorDTO> update(ProveedorDTO proveedorDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
