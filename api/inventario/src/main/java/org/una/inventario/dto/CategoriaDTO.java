package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private Boolean estado;
    private Date fechaCreacion;
}
