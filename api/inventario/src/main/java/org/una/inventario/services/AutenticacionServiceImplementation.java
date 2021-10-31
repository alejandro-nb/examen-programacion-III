package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.AuthenticationRequest;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.exceptions.InvalidCredentialsException;
import org.una.inventario.exceptions.NotFoundInformationException;

import java.util.Optional;

@Service
public class AutenticacionServiceImplementation implements IAutenticacionService {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationResponse = usuarioService.login(authenticationRequest);

        if (!authenticationResponse.getJwt().isBlank()) {

            Optional<UsuarioDTO> result = usuarioService.findByCedula(authenticationRequest.getCedula());
            if (result.isEmpty())
                throw new NotFoundInformationException();

            authenticationResponse.setUsuarioDTO(result.get());
            authenticationResponse.setRolDTO(result.get().getRol());
            return authenticationResponse;
        } else {
            throw new InvalidCredentialsException();
        }
    }
}
