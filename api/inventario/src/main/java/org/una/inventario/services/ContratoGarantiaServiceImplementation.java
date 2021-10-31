package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ContratoGarantiaDTO;
import org.una.inventario.entities.ContratoGarantia;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IContratoGarantiaRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoGarantiaServiceImplementation implements IContratoGarantiaService{
    @Autowired
    private IContratoGarantiaRepository contratoGarantiaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContratoGarantiaDTO>> findByEstado(Boolean estado) {
        List<ContratoGarantiaDTO> contratoGarantiaDTOList = MapperUtils.DtoListFromEntityList(contratoGarantiaRepository.findByEstado(estado), ContratoGarantiaDTO.class);
        return Optional.ofNullable(contratoGarantiaDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContratoGarantiaDTO>> findAll() {
        List<ContratoGarantiaDTO> contratoGarantiaDTOList = MapperUtils.DtoListFromEntityList(contratoGarantiaRepository.findAll(), ContratoGarantiaDTO.class);

        return Optional.ofNullable(contratoGarantiaDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContratoGarantiaDTO> findById(Long id) {
        Optional<ContratoGarantia> contratoGarantia = contratoGarantiaRepository.findById(id);
        if (contratoGarantia.isEmpty())
            throw new NotFoundInformationException();
        ContratoGarantiaDTO contratoGarantiaDTO = MapperUtils.DtoFromEntity(contratoGarantia.get(), ContratoGarantiaDTO.class);

        return Optional.ofNullable(contratoGarantiaDTO);
    }

    private ContratoGarantiaDTO getSavedContratoGarantiaDTO(ContratoGarantiaDTO contratoGarantiaDTO) {
        ContratoGarantia contratoGarantia = MapperUtils.EntityFromDto(contratoGarantiaDTO, ContratoGarantia.class);
        ContratoGarantia contratoGarantiaCreated = contratoGarantiaRepository.save(contratoGarantia);
        return MapperUtils.DtoFromEntity(contratoGarantiaCreated, ContratoGarantiaDTO.class);
    }

    @Override
    @Transactional
    public Optional<ContratoGarantiaDTO> create(ContratoGarantiaDTO contratoGarantiaDTO) {
        return Optional.ofNullable(getSavedContratoGarantiaDTO(contratoGarantiaDTO));
    }

    @Override
    @Transactional
    public Optional<ContratoGarantiaDTO> update(ContratoGarantiaDTO contratoGarantiaDTO, Long id) {
        if (contratoGarantiaRepository.findById(id).isEmpty())
            throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedContratoGarantiaDTO(contratoGarantiaDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        contratoGarantiaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        contratoGarantiaRepository.deleteAll();
    }
}
