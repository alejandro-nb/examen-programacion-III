package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.services.IInventarioService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/inventarios")
@Api(tags = {"Inventarios"})
public class InventarioController {
    @Autowired
    private IInventarioService inventarioService;

    @Async
    @PostMapping("/generarInventario/{id}")
    public CompletableFuture<Boolean> generateInventario(@PathVariable(value = "id") Long id){
        CompletableFuture<Boolean> result=inventarioService.generateInventario(id);
        return result;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un inventario por id", response = InventarioDTO.class, tags = "Inventarios")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<InventarioDTO> inventarioFound = inventarioService.findById(id);
        return new ResponseEntity<>(inventarioFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los inventarios", response = InventarioDTO.class, responseContainer = "List", tags = "Inventarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<InventarioDTO>> result = inventarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los inventarios por estado", response = InventarioDTO.class, responseContainer = "List", tags = "Inventarios")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<InventarioDTO>> result = inventarioService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear inventario", response = InventarioDTO.class, tags = "Inventarios")
    public ResponseEntity<?> create(@RequestBody InventarioDTO inventarioDTO) {
        Optional<InventarioDTO> inventarioCreated = inventarioService.create(inventarioDTO);
        return new ResponseEntity<>(inventarioCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar inventario por id", response = InventarioDTO.class, tags = "Inventarios")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        inventarioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los inventarios", response = InventarioDTO.class, tags = "Inventarios")
    public ResponseEntity<?> deleteAll() throws Exception {
        inventarioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar departamento", response = InventarioDTO.class, tags = "Inventarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody InventarioDTO inventarioModified) {
        Optional<InventarioDTO> inventarioUpdated = inventarioService.update(inventarioModified, id);
        return new ResponseEntity<>(inventarioUpdated, HttpStatus.OK);
    }
}
