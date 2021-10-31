package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "decripcion", length = 100)
    private String descripcion;

    @Column
    private Boolean estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private List<Valuacion> valuacionList;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(nullable = false)
    private Long responsable;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }
}
