package org.una.inventario.services;


import org.una.inventario.dto.AlertaDTO;

import java.util.List;
import java.util.Optional;

public interface IAlertaService {
    public Optional<List<AlertaDTO>> findAll();

    public Optional<AlertaDTO> findById(Long id);

    public Optional<AlertaDTO> create(AlertaDTO alertaDTO);

    public Optional<AlertaDTO> update(AlertaDTO alertaDTO, Long id);

    public void delete(Long id);

    public Optional<List<AlertaDTO>> findByEstado(boolean estado);

    public void deleteAll();
}
