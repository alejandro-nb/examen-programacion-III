package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ExcepcionDTO;
import org.una.inventario.services.IExcepcionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Excepciones")
@Api(tags = {"Excepciones"})
public class ExcepcionController {
    @Autowired
    private IExcepcionService excepcionService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los errores", response = ExcepcionDTO.class, responseContainer = "List", tags = "Excepciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ExcepcionDTO>> result = excepcionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una excepcion por id", response = ExcepcionDTO.class, tags = "Excepciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ExcepcionDTO> excepcionFound = excepcionService.findById(id);
        return new ResponseEntity<>(excepcionFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear excepcion", response = ExcepcionDTO.class, tags = "Excepciones")
    public ResponseEntity<?> create(@RequestBody ExcepcionDTO excepcionDTO) {
        Optional<ExcepcionDTO> excepcionCreated = excepcionService.create(excepcionDTO);
        return new ResponseEntity<>(excepcionCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar excepcion", response = ExcepcionDTO.class, tags = "Excepciones")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ExcepcionDTO excepcionModified) {
        Optional<ExcepcionDTO> excepcionUpdated = excepcionService.update(excepcionModified, id);
        return new ResponseEntity<>(excepcionUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar excepcion por id", response = ExcepcionDTO.class, tags = "Excepciones")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        excepcionService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos las excepciones", response = ExcepcionDTO.class, tags = "Excepciones")
    public ResponseEntity<?> deleteAll() throws Exception {
        excepcionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todas los excepciones por estado", response = ExcepcionDTO.class, responseContainer = "List", tags = "Excepciones")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ExcepcionDTO>> result = excepcionService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
