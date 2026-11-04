package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "productos")
class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(length = 100)
    var nombre: String? = null,

    @Column(length = 50)
    var categoria: String? = null,

    var precio: Int? = null,

    @Column(name = "a_cotizar")
    var aCotizar: Boolean? = null,
)