package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.services.IParametroService;

import javax.ws.rs.core.Request;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})
public class ParametroController {
    @Autowired
    private IParametroService parametroService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un parametro por id", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> parametroFound = parametroService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los parametros", response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    public @ResponseBody
    @PreAuthorize("hasRole('USUARIO')")
    ResponseEntity<?> findAll() {

        Optional<List<ParametroDTO>> result = parametroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los parametros por estado", response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<ParametroDTO>> result = parametroService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear parametro", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> create(@RequestBody ParametroDTO parametroDTO) {
        Optional<ParametroDTO> parametroCreated = parametroService.create(parametroDTO);
        return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar parametro por id", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        parametroService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los parametros", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> deleteAll() throws Exception {
        parametroService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar parametro", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroDTO parametroModified) {
        Optional<ParametroDTO> parametroUpdated = parametroService.update(parametroModified, id);
        return new ResponseEntity<>(parametroUpdated, HttpStatus.OK);
    }

    @GetMapping("/byNombre/{nombre}")
    @ApiOperation(value = "Obtiene un parametro por nombre", response = ParametroDTO.class, tags = "Parametros")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        Optional<ParametroDTO> result = parametroService.findByNombre(nombre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
