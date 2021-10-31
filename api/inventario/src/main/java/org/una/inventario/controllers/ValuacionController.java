package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ValuacionDTO;
import org.una.inventario.services.IValuacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valuaciones")
@Api(tags = {"Valuaciones"})
public class ValuacionController {
    @Autowired
    private IValuacionService valuacionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un valuacion por id", response = ValuacionDTO.class, tags = "Valuaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ValuacionDTO> valuacionFound = valuacionService.findById(id);
        return new ResponseEntity<>(valuacionFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los valuaciones", response = ValuacionDTO.class, responseContainer = "List", tags = "Valuaciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ValuacionDTO>> result = valuacionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear valuacion", response = ValuacionDTO.class, tags = "Valuaciones")
    public ResponseEntity<?> create(@RequestBody ValuacionDTO valuacionDTO) {
        Optional<ValuacionDTO> valuacionCreated = valuacionService.create(valuacionDTO);
        return new ResponseEntity<>(valuacionCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar valuacion por id", response = ValuacionDTO.class, tags = "Valuaciones")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        valuacionService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todas las valuaciones", response = ValuacionDTO.class, tags = "Valuaciones")
    public ResponseEntity<?> deleteAll() throws Exception {
        valuacionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar valuacion", response = ValuacionDTO.class, tags = "Valuaciones")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ValuacionDTO valuacionModified) {
        Optional<ValuacionDTO> valuacionUpdated = valuacionService.update(valuacionModified, id);
        return new ResponseEntity<>(valuacionUpdated, HttpStatus.OK);
    }
}
