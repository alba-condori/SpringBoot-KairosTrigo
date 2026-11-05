package etec.backend.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class DetallePedidoRequest(
    @field:NotNull
    val pedidoId: Int,

    @field:NotNull
    val productoId: Int,

    @field:NotNull
    @field:Min(1)
    val cantidad: Int,

    @field:Size(max = 50)
    val variedad: String? = null,

    @field:Min(0)
    val precioUnitario: Int? = null,
)