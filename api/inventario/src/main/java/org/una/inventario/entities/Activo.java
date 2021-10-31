package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Activo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @OneToMany(mappedBy = "activo", cascade = CascadeType.ALL)
    private List<ActivoAsignado> activoAsignadoList;

    @OneToMany(mappedBy = "activo", cascade = CascadeType.ALL)
    private List<Valuacion> valuaciones;

    @Column
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marcas_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    private Proveedor proveedor;

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "continente_id")
    private Activo continente;

    @OneToMany(mappedBy = "continente", cascade = CascadeType.ALL)
    private List<Activo> activoList;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaCreacion = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }
}
