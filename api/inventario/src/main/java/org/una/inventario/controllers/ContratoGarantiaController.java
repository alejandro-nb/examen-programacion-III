package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ContratoGarantiaDTO;
import org.una.inventario.services.IContratoGarantiaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratos_garantias")
@Api(tags = {"Contratos Garantias"})
public class ContratoGarantiaController {
    @Autowired
    private IContratoGarantiaService contratoGarantiaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un contrato garantia por id", response = ContratoGarantiaDTO.class, tags = "Contratos Garantias")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContratoGarantiaDTO> contratoGarantiaFound = contratoGarantiaService.findById(id);
        return new ResponseEntity<>(contratoGarantiaFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los contratos garantias", response = ContratoGarantiaDTO.class, responseContainer = "List", tags = "Contratos Garantias")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ContratoGarantiaDTO>> result = contratoGarantiaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los contratos garantias por estado", response = ContratoGarantiaDTO.class, responseContainer = "List", tags = "Contratos Garantias")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ContratoGarantiaDTO>> result = contratoGarantiaService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear contrato garantia", response = ContratoGarantiaDTO.class, tags = "Contratos Garantias")
    public ResponseEntity<?> create(@RequestBody ContratoGarantiaDTO contratoGarantiaDTO) {
        Optional<ContratoGarantiaDTO> contratoGarantiaCreated = contratoGarantiaService.create(contratoGarantiaDTO);
        return new ResponseEntity<>(contratoGarantiaCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar contrato garantia por id", response = ContratoGarantiaDTO.class, tags = "Contratos Garantias")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        contratoGarantiaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los contratos garantias", response = ContratoGarantiaDTO.class, tags = "Contratos Garantias")
    public ResponseEntity<?> deleteAll() throws Exception {
        contratoGarantiaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar contrato garantia", response = ContratoGarantiaDTO.class, tags = "Contratos Garantias")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ContratoGarantiaDTO contratoGarantiaModified) {
        Optional<ContratoGarantiaDTO> contratoGarantiaUpdated = contratoGarantiaService.update(contratoGarantiaModified, id);
        return new ResponseEntity<>(contratoGarantiaUpdated, HttpStatus.OK);
    }
}
