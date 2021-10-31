package org.una.inventario.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Component
public class InformationNotSavedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode = HttpStatus.INTERNAL_SERVER_ERROR;

    private final String errorMessage = "Esta petición no ha sido completada, revise su peticion";

}
