package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activos_asignados")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivoAsignado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaCreacion = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activo;

    private static final long serialVersionUID = 1L;

    @Column
    private Boolean estado;

    @Column(name = "justificacion", length = 100)
    private String descripcion;

}
