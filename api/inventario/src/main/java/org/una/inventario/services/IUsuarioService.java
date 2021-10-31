package org.una.inventario.services;

import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.AuthenticationRequest;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public Optional<List<UsuarioDTO>> findAll();

    public Optional<UsuarioDTO> findById(Long id);

    @Transactional(readOnly = true)
    Optional<UsuarioDTO> findByCedula(String cedula);

    public Optional<List<UsuarioDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<UsuarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public Optional<UsuarioDTO> create(UsuarioDTO usuarioDTO);

    public Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<UsuarioDTO> login(String cedula,String password);

    public Optional<List<UsuarioDTO>> findByDepartamentoId(Long id);

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest);

}
