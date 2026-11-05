package etec.backend.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class DetallePersonalizadoRequest(
    @field:NotNull
    val pedidoId: Int,

    @field:Size(max = 20)
    val tipo: String? = null,

    @field:Size(max = 100)
    val nombrePersonalizado: String? = null,

    @field:Min(1)
    val cantidad: Int? = null,

    @field:Min(1)
    val porciones: Int? = null,

    @field:Size(max = 50)
    val sabor: String? = null,

    val descripcion: String? = null,

    @field:Size(max = 300)
    val linkReferencia: String? = null,

    val imagenPorWhatsapp: Boolean? = null,

    @field:Min(0)
    val precioCotizado: Int? = null,
)