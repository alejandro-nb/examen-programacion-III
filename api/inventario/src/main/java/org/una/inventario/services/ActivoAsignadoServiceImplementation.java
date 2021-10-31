package org.una.inventario.services;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ActivoAsignadoDTO;
import org.una.inventario.entities.Activo;
import org.una.inventario.entities.ActivoAsignado;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IActivoAsignadoRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ActivoAsignadoServiceImplementation implements IActivoAsignadoService {

    @Autowired
    private IActivoAsignadoRepository activoAsignadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ActivoAsignadoDTO>> findByEstado(Boolean estado) {
        List<ActivoAsignadoDTO> activoAsignadoDTOList = MapperUtils.DtoListFromEntityList(activoAsignadoRepository.findByEstado(estado), ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ActivoAsignadoDTO>> findAll() {
        List<ActivoAsignadoDTO> activoAsignadoDTOList = MapperUtils.DtoListFromEntityList(activoAsignadoRepository.findAll(), ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ActivoAsignadoDTO> findById(Long id) {
        Optional<ActivoAsignado> activoAsignado = activoAsignadoRepository.findById(id);
        if (activoAsignado.isEmpty())
            throw new NotFoundInformationException();

        ActivoAsignadoDTO activoAsignadoDTO = MapperUtils.DtoFromEntity(activoAsignado.get(), ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTO);
    }

    private ActivoAsignadoDTO getSavedActivoAsignadoDTO(ActivoAsignadoDTO activoAsignadoDTO) {
        ActivoAsignado activoAsignado = MapperUtils.EntityFromDto(activoAsignadoDTO, ActivoAsignado.class);
        ActivoAsignado activoAsignadoCreated = activoAsignadoRepository.save(activoAsignado);
        return MapperUtils.DtoFromEntity(activoAsignadoCreated, ActivoAsignadoDTO.class);
    }

    @Override
    @Transactional
    public Optional<ActivoAsignadoDTO> create(ActivoAsignadoDTO activoAsignadoDTO) {
        return Optional.ofNullable(getSavedActivoAsignadoDTO(activoAsignadoDTO));
    }

    @Override
    @Transactional
    public Optional<ActivoAsignadoDTO> update(ActivoAsignadoDTO activoAsignadoDTO, Long id) {
        if (activoAsignadoRepository.findById(id).isEmpty())
            throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedActivoAsignadoDTO(activoAsignadoDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        activoAsignadoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        activoAsignadoRepository.deleteAll();
    }
}
