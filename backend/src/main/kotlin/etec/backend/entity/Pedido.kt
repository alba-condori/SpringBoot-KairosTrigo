package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "pedidos")
class Pedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null,

    @Column(name = "fecha_retiro")
    var fechaRetiro: LocalDateTime? = null,

    @Column(name = "tipo_entrega", length = 20)
    var tipoEntrega: String? = null,

    @Column(length = 200)
    var direccion: String? = null,

    @Column(length = 20)
    var estado: String? = null,

    var total: Int? = null,

    var sena: Int? = null,
)