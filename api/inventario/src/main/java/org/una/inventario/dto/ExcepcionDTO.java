package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcepcionDTO {

    private Long id;
    private UsuarioDTO usuarioId;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
}
