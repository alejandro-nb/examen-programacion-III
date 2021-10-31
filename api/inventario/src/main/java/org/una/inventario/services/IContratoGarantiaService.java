package org.una.inventario.services;

import org.una.inventario.dto.ContratoGarantiaDTO;

import java.util.List;
import java.util.Optional;

public interface IContratoGarantiaService {
    public Optional<List<ContratoGarantiaDTO>> findByEstado(Boolean estado);

    public Optional<List<ContratoGarantiaDTO>> findAll();

    public Optional<ContratoGarantiaDTO> findById(Long id);

    public Optional<ContratoGarantiaDTO> create(ContratoGarantiaDTO contratoGarantiaDTO);

    public Optional<ContratoGarantiaDTO> update(ContratoGarantiaDTO contratoGarantiaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
