package etec.backend.dto

import etec.backend.entity.Cliente

data class ClienteResponse(
    val id: Int,
    val nombre: String?,
    val apellido: String?,
    val telefono: String?,
) {
    companion object {
        fun fromEntity(c: Cliente): ClienteResponse =
            ClienteResponse(
                id = c.id ?: 0,
                nombre = c.nombre,
                apellido = c.apellido,
                telefono = c.telefono,
            )
    }
}