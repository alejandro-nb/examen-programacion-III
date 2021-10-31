package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InventarioDTO {
    private Long id;
    private String descripcion;
    private Boolean estado;
    private Long responsable;
    private Date fechaCreacion;
}
