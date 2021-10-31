package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ExcepcionDTO;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.entities.Excepcion;
import org.una.inventario.entities.Rol;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IExcepcionRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ExcepcionServiceImplementation implements IExcepcionService {

    @Autowired
    private IExcepcionRepository excepcionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ExcepcionDTO>> findAll() {
        List<ExcepcionDTO> excepcionDTOList = MapperUtils.DtoListFromEntityList(excepcionRepository.findAll(), ExcepcionDTO.class);
        return Optional.ofNullable(excepcionDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExcepcionDTO> findById(Long id) {
        Optional<Excepcion> excepcion = excepcionRepository.findById(id);
        if (excepcion.isEmpty())
            throw new NotFoundInformationException();
        ExcepcionDTO excepcionDTO = MapperUtils.DtoFromEntity(excepcion.get(), ExcepcionDTO.class);
        return Optional.ofNullable(excepcionDTO);
    }

    private ExcepcionDTO getSavedExpcepcionDTO(ExcepcionDTO excepcionDTO) {
        Excepcion excepcion = MapperUtils.EntityFromDto(excepcionDTO, Excepcion.class);
        Excepcion excepcionCreated = excepcionRepository.save(excepcion);
        return MapperUtils.DtoFromEntity(excepcionCreated, ExcepcionDTO.class);
    }

    @Override
    @Transactional
    public Optional<ExcepcionDTO> create(ExcepcionDTO excepcionDTO) {
        return Optional.ofNullable(getSavedExpcepcionDTO(excepcionDTO));
    }

    @Override
    @Transactional
    public Optional<ExcepcionDTO> update(ExcepcionDTO excepcionDTO, Long id) {
        if (excepcionRepository.findById(id).isEmpty())
            throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedExpcepcionDTO(excepcionDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        excepcionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        excepcionRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ExcepcionDTO>> findByEstado(boolean estado) {
        return Optional.empty();
    }
}
