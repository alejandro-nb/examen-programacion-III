package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ProveedorDTO;
import org.una.inventario.services.IProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
@Api(tags = {"Proveedores"})
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un proveedor por id", response = ProveedorDTO.class, tags = "Proveedores")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ProveedorDTO> proveedorFound = proveedorService.findById(id);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los proveedores", response = ProveedorDTO.class, responseContainer = "List", tags = "Proveedores")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ProveedorDTO>> result = proveedorService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los proveedores por estado", response = ProveedorDTO.class, responseContainer = "List", tags = "Proveedores")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ProveedorDTO>> result = proveedorService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear proveedor", response = ProveedorDTO.class, tags = "Proveedores")
    public ResponseEntity<?> create(@RequestBody ProveedorDTO proveedorDTO) {
        Optional<ProveedorDTO> proveedorCreated = proveedorService.create(proveedorDTO);
        return new ResponseEntity<>(proveedorCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar proveedor por id", response = ProveedorDTO.class, tags = "Proveedores")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        proveedorService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los proveedores", response = ProveedorDTO.class, tags = "Proveedores")
    public ResponseEntity<?> deleteAll() throws Exception {
        proveedorService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar proveedor", response = ProveedorDTO.class, tags = "Proveedores")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ProveedorDTO proveedorModified) {
        Optional<ProveedorDTO> proveedorUpdated = proveedorService.update(proveedorModified, id);
        return new ResponseEntity<>(proveedorUpdated, HttpStatus.OK);
    }
}
