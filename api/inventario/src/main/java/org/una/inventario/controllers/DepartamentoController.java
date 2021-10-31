package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.services.IDepartamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Departamentos"})
public class DepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un departamento por id", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<DepartamentoDTO> departamentoFound = departamentoService.findById(id);
        return new ResponseEntity<>(departamentoFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los departamentos", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<DepartamentoDTO>> result = departamentoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los departamentos por estado", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<DepartamentoDTO>> result = departamentoService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear departamento", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> create(@RequestBody DepartamentoDTO departamentoDTO) {
        Optional<DepartamentoDTO> departamentoCreated = departamentoService.create(departamentoDTO);
        return new ResponseEntity<>(departamentoCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar departamento por id", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        departamentoService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los departamentos", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> deleteAll() throws Exception {
        departamentoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar departamento", response = DepartamentoDTO.class, tags = "Departamentos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody DepartamentoDTO departamentoModified) {
        Optional<DepartamentoDTO> depapartamentoUpdated = departamentoService.update(departamentoModified, id);
        return new ResponseEntity<>(depapartamentoUpdated, HttpStatus.OK);
    }
}
