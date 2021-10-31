package org.una.inventario.services;

import org.una.inventario.dto.ValuacionDTO;

import java.util.List;
import java.util.Optional;

public interface IValuacionService {

    public Optional<List<ValuacionDTO>> findAll();

    public Optional<ValuacionDTO> findById(Long id);

    public Optional<ValuacionDTO> create(ValuacionDTO valuacionDTO);

    public Optional<ValuacionDTO> update(ValuacionDTO valuacionDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
