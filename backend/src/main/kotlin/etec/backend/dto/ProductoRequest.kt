package etec.backend.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ProductoRequest(
    @field:NotBlank
    @field:Size(max = 100)
    val nombre: String,

    val descripcion: String? = null,

    @field:Size(max = 50)
    val categoria: String? = null,

    @field:NotNull
    @field:Min(0)
    val precio: Int,

    @field:Size(max = 20)
    val unidad: String? = null,
)