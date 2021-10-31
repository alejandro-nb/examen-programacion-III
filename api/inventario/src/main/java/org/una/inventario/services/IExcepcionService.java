package org.una.inventario.services;

import org.una.inventario.dto.ExcepcionDTO;
import org.una.inventario.entities.Excepcion;

import java.util.List;
import java.util.Optional;

public interface IExcepcionService {
    public Optional<List<ExcepcionDTO>> findAll();

    public Optional<ExcepcionDTO> findById(Long id);

    public Optional<ExcepcionDTO> create(ExcepcionDTO excepcionDTO);

    public Optional<ExcepcionDTO> update(ExcepcionDTO excepcionDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<ExcepcionDTO>> findByEstado(boolean estado);

}
