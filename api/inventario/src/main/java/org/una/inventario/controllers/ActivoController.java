package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ActivoDTO;
import org.una.inventario.services.IActivoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/activos")
@Api(tags = {"Activos"})
public class ActivoController {

    @Autowired
    private IActivoService activoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un activo por id", response = ActivoDTO.class, tags = "Activos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ActivoDTO> activoFound = activoService.findById(id);
        return new ResponseEntity<>(activoFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los activos", response = ActivoDTO.class, responseContainer = "List", tags = "Activos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ActivoDTO>> result = activoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los activos por estado", response = ActivoDTO.class, responseContainer = "List", tags = "Activos")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ActivoDTO>> result = activoService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear activo", response = ActivoDTO.class, tags = "Activos")
    public ResponseEntity<?> create(@RequestBody ActivoDTO activoDTO) {
        Optional<ActivoDTO> activoCreated = activoService.create(activoDTO);
        return new ResponseEntity<>(activoCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar activo por id", response = ActivoDTO.class, tags = "Activos")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        activoService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los activos", response = ActivoDTO.class, tags = "Activos")
    public ResponseEntity<?> deleteAll() throws Exception {
        activoService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar activo", response = ActivoDTO.class, tags = "Activos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ActivoDTO activoModified) {
        Optional<ActivoDTO> activoUpdated = activoService.update(activoModified, id);
        return new ResponseEntity<>(activoUpdated, HttpStatus.OK);
    }

    @GetMapping("/minFecha/{minFecha}/maxFecha/{maxFecha}")
    @ResponseBody
    @Async
    @ApiOperation(value = "Obtiene una lista de todos los activos entre dos fechas", response = ActivoDTO.class, responseContainer = "List", tags = "Activos")
    public CompletableFuture<List<ActivoDTO>> getCobrosPorFecha(@PathVariable(value = "minFecha") String minFecha,
                                                @PathVariable(value = "maxFecha") String maxFecha){
        System.out.println("entro");
        CompletableFuture<List<ActivoDTO>> activoDTOS = activoService.getActivosBetweenFechas(LocalDate.parse(minFecha),LocalDate.parse(maxFecha));
        return activoDTOS;
    }
}
