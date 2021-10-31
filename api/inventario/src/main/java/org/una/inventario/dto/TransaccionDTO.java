package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransaccionDTO {
    private Long id;
    private String objeto;
    private UsuarioDTO usuarioId;
    private String accion;
    private Date fechaRegistro;
}
