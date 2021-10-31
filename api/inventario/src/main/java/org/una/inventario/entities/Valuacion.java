package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "valuaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Valuacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precio_valuacion")
    private Double precioValuacion;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "inventarios_id")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activo;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }
}
