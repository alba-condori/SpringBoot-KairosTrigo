package etec.backend.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class PedidoRequest(
    @field:NotNull
    val clienteId: Int,

    val fechaRetiro: LocalDate? = null,

    @field:Size(max = 30)
    val franjaHoraria: String? = null,

    @field:Size(max = 20)
    val tipoEntrega: String? = null,

    @field:Size(max = 200)
    val direccion: String? = null,

    @field:Size(max = 20)
    val estado: String? = null,

    @field:Min(0)
    val total: Int? = null,

    @field:Min(0)
    val sena: Int? = null,

    val senaPagada: Boolean? = null,
)