package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.MarcaDTO;
import org.una.inventario.services.IMarcaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marcas")
@Api(tags = {"Marcas"})
public class MarcaController {
    @Autowired
    private IMarcaService marcaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una marca por id", response = MarcaDTO.class, tags = "Marcas")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<MarcaDTO> marcaFound = marcaService.findById(id);
        return new ResponseEntity<>(marcaFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las marcas", response = MarcaDTO.class, responseContainer = "List", tags = "Marcas")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<MarcaDTO>> result = marcaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todas las marcas por estado", response = MarcaDTO.class, responseContainer = "List", tags = "Marcas")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<MarcaDTO>> result = marcaService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear marcas", response = MarcaDTO.class, tags = "Marcas")
    public ResponseEntity<?> create(@RequestBody MarcaDTO marcaDTO) {
        Optional<MarcaDTO> marcaCreated = marcaService.create(marcaDTO);
        return new ResponseEntity<>(marcaCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar marca por id", response = MarcaDTO.class, tags = "Marcas")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        marcaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todas las marcas", response = MarcaDTO.class, tags = "Marcas")
    public ResponseEntity<?> deleteAll() throws Exception {
        marcaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar marca", response = MarcaDTO.class, tags = "Marcas")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody MarcaDTO marcaModified) {
        Optional<MarcaDTO> marcaUpdated = marcaService.update(marcaModified, id);
        return new ResponseEntity<>(marcaUpdated, HttpStatus.OK);
    }
}
