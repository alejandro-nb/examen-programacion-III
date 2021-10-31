package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.entities.Inventario;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IInventarioRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
public class InventarioServiceImplementation implements IInventarioService {

    @Autowired
    private IInventarioRepository inventarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<InventarioDTO>> findByEstado(Boolean estado) {
        List<InventarioDTO> inventarioDTOList = MapperUtils.DtoListFromEntityList(inventarioRepository.findByEstado(estado), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<InventarioDTO>> findAll() {
        List<InventarioDTO> inventarioDTOList = MapperUtils.DtoListFromEntityList(inventarioRepository.findAll(), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InventarioDTO> findById(Long id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        if (inventario.isEmpty())
            throw new NotFoundInformationException();
        InventarioDTO inventarioDTO = MapperUtils.DtoFromEntity(inventario.get(), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTO);
    }

    private InventarioDTO getSavedInventarioDTO(InventarioDTO inventarioDTO) {
        Inventario inventario= MapperUtils.EntityFromDto(inventarioDTO, Inventario.class);
        Inventario inventarioCreated = inventarioRepository.save(inventario);
        return MapperUtils.DtoFromEntity(inventarioCreated, InventarioDTO.class);
    }
    @Override
    @Transactional
    public Optional<InventarioDTO> create(InventarioDTO inventarioDTO) {

        return Optional.ofNullable(getSavedInventarioDTO(inventarioDTO));
    }

    @Override
    @Transactional
    public Optional<InventarioDTO> update(InventarioDTO inventarioDTO, Long id) {
        if (inventarioRepository.findById(id).isEmpty())
            throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedInventarioDTO(inventarioDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        inventarioRepository.deleteAll();
    }

    @Override
    @Transactional
    public CompletableFuture<Boolean> generateInventario(Long id) {
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {

            completableFuture.complete(inventarioRepository.generarInventario(id) == 1);

            return null;
        });

        return completableFuture;
    }
}
