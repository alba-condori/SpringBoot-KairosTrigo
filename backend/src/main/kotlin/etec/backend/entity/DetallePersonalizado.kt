package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "detalle_personalizado")
class DetallePersonalizado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    var pedido: Pedido? = null,

    @Column(length = 20)
    var tipo: String? = null,

    @Column(name = "nombre_personalizado", length = 100)
    var nombrePersonalizado: String? = null,

    var cantidad: Int? = null,

    var porciones: Int? = null,

    @Column(length = 50)
    var sabor: String? = null,

    @Column(columnDefinition = "text")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var descripcion: String? = null,

    @Column(name = "link_referencia", length = 300)
    var linkReferencia: String? = null,

    @Column(name = "imagen_por_whatsapp")
    var imagenPorWhatsapp: Boolean? = null,

    @Column(name = "precio_cotizado")
    var precioCotizado: Int? = null,
)