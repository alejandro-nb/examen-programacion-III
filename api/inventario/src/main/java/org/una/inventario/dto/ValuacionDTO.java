package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ValuacionDTO {
    private Double precioValuacion;
    private ActivoDTO activoDTO;
    private Long id;
    private Date fechaCreacion;
    private InventarioDTO inventarioDTO;
}
