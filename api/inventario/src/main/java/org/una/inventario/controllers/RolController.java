package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.services.IRolService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@Api(tags = {"Roles"})
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un rol por id", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RolDTO> rolFound = rolService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los roles", response = RolDTO.class, responseContainer = "List", tags = "Roles")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<RolDTO>> result = rolService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ApiOperation(value = "Crear rol", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> create(@RequestBody RolDTO rolDTO) {
        Optional<RolDTO> rolCreated = rolService.create(rolDTO);
        return new ResponseEntity<>(rolCreated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar rol por id", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        rolService.delete(id);
        return  new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos los roles", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> deleteAll() throws Exception {
        rolService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar rol", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RolDTO rolModified) {
        Optional<RolDTO> rolUpdated = rolService.update(rolModified, id);
        return new ResponseEntity<>(rolUpdated, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los roles por estado", response = RolDTO.class, responseContainer = "List", tags = "Roles")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<RolDTO>> result = rolService.findRolesByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping("/byFechaBetween/{startDate}/{endDate}")
//    @ApiOperation(value = "Obtiene una lista de los roles por fecha entre creacion y final", response = RolDTO.class, responseContainer = "List", tags = "Roles")
//    public ResponseEntity<?> findByFechaCreacionBetween(@Param(value = "startDate") Date startDate, @Param(value = "endDate") Date endDate) {
//        System.out.println(startDate.toString());
//        Optional<List<RolDTO>> result = rolService.findByFechaCreacionBetween(startDate, endDate);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

}
