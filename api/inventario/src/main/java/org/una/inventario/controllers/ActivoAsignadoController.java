package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ActivoAsignadoDTO;
import org.una.inventario.services.IActivoAsignadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activos_asignados")
@Api(tags = {"Activos Asignados"})
public class ActivoAsignadoController {

    @Autowired
    private IActivoAsignadoService activoAsignadoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un activo asignado por id", response = ActivoAsignadoDTO.class, tags = "Activos Asignados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ActivoAsignadoDTO> activoAsignadoFound = activoAsignadoService.findById(id);
        return new ResponseEntity<>(activoAsignadoFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los activos asignados", response = ActivoAsignadoDTO.class, responseContainer = "List", tags = "Activos Asignados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ActivoAsignadoDTO>> result = activoAsignadoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los activos asignados por estado", response = ActivoAsignadoDTO.class, responseContainer = "List", tags = "Activos Asignados")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ActivoAsignadoDTO>> result = activoAsignadoService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear activo asignado", response = ActivoAsignadoDTO.class, tags = "Activos Asignados")
    public ResponseEntity<?> create(@RequestBody ActivoAsignadoDTO activoAsignadoDTO) {
        Optional<ActivoAsignadoDTO> activoCreated = activoAsignadoService.create(activoAsignadoDTO);
        return new ResponseEntity<>(activoCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar activo asignado por id", response = ActivoAsignadoDTO.class, tags = "Activos Asignados")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        activoAsignadoService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los activos asignados", response = ActivoAsignadoDTO.class, tags = "Activos Asignados")
    public ResponseEntity<?> deleteAll() throws Exception {
        activoAsignadoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar departamento", response = ActivoAsignadoDTO.class, tags = "Activos Asignados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ActivoAsignadoDTO activoAsignadoModified) {
        Optional<ActivoAsignadoDTO> activoAsignadoUpdated = activoAsignadoService.update(activoAsignadoModified, id);
        return new ResponseEntity<>(activoAsignadoUpdated, HttpStatus.OK);
    }
}