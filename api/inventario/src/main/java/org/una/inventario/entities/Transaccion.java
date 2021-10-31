package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transacciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "objeto", length = 50)
    private String objeto;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Column(length = 50, name = "accion")
    private String accion;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaRegistro = new Date();
    }

}
