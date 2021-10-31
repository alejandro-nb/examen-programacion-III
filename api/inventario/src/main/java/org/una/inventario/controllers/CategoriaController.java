package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.services.ICategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Api(tags = {"Categorias"})
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una categoria por id", response = CategoriaDTO.class, tags = "Categorias")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CategoriaDTO> categoriaFound = categoriaService.findById(id);
        return new ResponseEntity<>(categoriaFound, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Obtiene una lista de todos las categorias", response = CategoriaDTO.class, responseContainer = "List", tags = "Categorias")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CategoriaDTO>> result = categoriaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEstado/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos las categorias por estado", response = CategoriaDTO.class, responseContainer = "List", tags = "Categorias")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        Optional<List<CategoriaDTO>> result = categoriaService.findByEstado(estado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Crear categoria", response = CategoriaDTO.class, tags = "Categorias")
    public ResponseEntity<?> create(@RequestBody CategoriaDTO categoriaDTO) {
        Optional<CategoriaDTO> categoriaCreated = categoriaService.create(categoriaDTO);
        return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar categoria por id", response = CategoriaDTO.class, tags = "Categorias")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        categoriaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar todos las categorias", response = CategoriaDTO.class, tags = "Categorias")
    public ResponseEntity<?> deleteAll() throws Exception {
        categoriaService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizar departamento", response = CategoriaDTO.class, tags = "Categorias")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CategoriaDTO categoriaModified) {
        Optional<CategoriaDTO> categoriaUpdated = categoriaService.update(categoriaModified, id);
        return new ResponseEntity<>(categoriaUpdated, HttpStatus.OK);
    }
}
