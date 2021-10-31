package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ActivoAsignadoDTO {
    private Long id;
    private UsuarioDTO usuarioDTO;
    private ActivoDTO activoDTO;
    private String justificacion;
    private Boolean estado;
    private Date fechaCreacion;
}
