package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.AuthenticationRequest;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.exceptions.MissingInputsException;
import org.una.inventario.services.IAutenticacionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/autenticacion")
@Api(tags = {"Seguridad"})
public class AutenticacionController {

    @Autowired
    private IAutenticacionService autenticacionService;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesion para conseguir un token de acceso", response = AuthenticationRequest.class, tags = "Seguridad")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new MissingInputsException();

        AuthenticationResponse authenticationResponse = autenticacionService.login(authenticationRequest);

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
