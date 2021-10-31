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
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.exceptions.InvalidCredentialsException;
import org.una.inventario.exceptions.MissingInputsException;
import org.una.inventario.services.IUsuarioService;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<UsuarioDTO>> result = usuarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un usuario por id", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<UsuarioDTO> usuarioFound = usuarioService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @GetMapping("/byDepartamentoId/{id}")
    @ApiOperation(value = "Obtiene una lista de todos por id del departamento", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByDepartamentoId(@PathVariable(value = "id") Long id) {
        Optional<List<UsuarioDTO>> result = usuarioService.findByDepartamentoId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/cedula/{term}")
    @ApiOperation(value = "Obtiene un usuario por cedula aproximada", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {
        Optional<List<UsuarioDTO>> result = usuarioService.findByCedulaAproximate(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<UsuarioDTO>> result = usuarioService.findByNombreCompletoAproximateIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear usuario", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> usuarioCreated = usuarioService.create(usuarioDTO);
        return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar usuario", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO usuarioModified) {
        Optional<UsuarioDTO> usuarioUpdated = usuarioService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar usuario por id", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        usuarioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los usuarios", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> deleteAll() throws Exception {
        usuarioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}

