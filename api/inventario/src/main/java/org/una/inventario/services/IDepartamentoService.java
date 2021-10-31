package org.una.inventario.services;

import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {

    public Optional<List<DepartamentoDTO>> findByEstado(Boolean estado);

    public Optional<List<DepartamentoDTO>> findAll();

    public Optional<DepartamentoDTO> findById(Long id);

    public Optional<DepartamentoDTO> create(DepartamentoDTO departamentoDTO);

    public Optional<DepartamentoDTO> update(DepartamentoDTO departamentoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
