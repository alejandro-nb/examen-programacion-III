package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AlertaDTO {
    private Long id;
    private ActivoDTO activoDTO;
    private String tipo;
    private String descripcion;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long responsable;
}
