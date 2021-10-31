package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.AlertaDTO;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.services.IAlertaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alertas")
@Api(tags = {"Alertas"})
public class AlertaController {
    @Autowired
    private IAlertaService alertaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un alerta por id", response = AlertaDTO.class, tags = "Alertas")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<AlertaDTO> activoFound = alertaService.findById(id);
        return new ResponseEntity<>(activoFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las alertas", response = AlertaDTO.class, responseContainer = "List", tags = "Alertas")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<AlertaDTO>> result = alertaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos alertas por estado", response = AlertaDTO.class, responseContainer = "List", tags = "Alertas")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<AlertaDTO>> result = alertaService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear alerta", response = AlertaDTO.class, tags = "Alertas")
    public ResponseEntity<?> create(@RequestBody AlertaDTO alertaDTO) {
        Optional<AlertaDTO> alertaCreated = alertaService.create(alertaDTO);
        return new ResponseEntity<>(alertaCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar alerta por id", response = AlertaDTO.class, tags = "Alertas")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        alertaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todas las alertas", response = AlertaDTO.class, tags = "Alertas")
    public ResponseEntity<?> deleteAll() throws Exception {
        alertaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar alerta", response = AlertaDTO.class, tags = "Alertas")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody AlertaDTO alertaModified) {
        Optional<AlertaDTO> alertaUpdated = alertaService.update(alertaModified, id);
        return new ResponseEntity<>(alertaUpdated, HttpStatus.OK);
    }
}
