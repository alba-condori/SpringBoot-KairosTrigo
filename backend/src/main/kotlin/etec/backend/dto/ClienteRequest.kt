package etec.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ClienteRequest(
    @field:NotBlank
    @field:Size(max = 100)
    val nombre: String,

    @field:Size(max = 100)
    val apellido: String? = null,

    @field:Size(max = 30)
    val telefono: String? = null,
)