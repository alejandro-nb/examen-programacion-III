package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContratoGarantiaDTO {
    private Long id;
    private ActivoDTO activoDTO;
    private Double montoAsegurado;
    private Double costo;
    private Boolean estado;
    private Date fechaVencimiento;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
