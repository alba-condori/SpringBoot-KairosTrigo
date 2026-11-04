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
@Table(name = "detalle_pedido")
class DetallePedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    var pedido: Pedido? = null,

    @ManyToOne
    @JoinColumn(name = "producto_id")
    var producto: Producto? = null,

    var cantidad: Int? = null,

    @Column(length = 50)
    var sabor: String? = null,

    var porciones: Int? = null,

    @Column(columnDefinition = "text")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    var descripcion: String? = null,
)