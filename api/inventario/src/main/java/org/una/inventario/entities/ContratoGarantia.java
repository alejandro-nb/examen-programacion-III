package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contratos_garantias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContratoGarantia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto_asegurado")
    private Double montoAsegurado;

    @Column
    private Double costo;

    @Column
    private Boolean estado;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "activos_id")
    private Activo activo;

    @OneToMany(mappedBy = "contratoGarantia", cascade = CascadeType.ALL)
    private List<Alerta> alertaList;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaCreacion = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }


}
