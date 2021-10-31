package org.una.inventario.entities;

import lombok.*;
import org.una.inventario.dto.UsuarioDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "excepciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Excepcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Column
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaCreacion = new Date();
    }

}
