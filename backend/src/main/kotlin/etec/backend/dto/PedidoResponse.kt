package etec.backend.dto

import etec.backend.entity.Pedido
import java.time.LocalDate
import java.time.LocalDateTime

data class PedidoResponse(
    val id: Int,
    val clienteId: Int?,
    val fechaPedido: LocalDateTime?,
    val fechaRetiro: LocalDate?,
    val franjaHoraria: String?,
    val tipoEntrega: String?,
    val direccion: String?,
    val estado: String?,
    val total: Int?,
    val sena: Int?,
    val senaPagada: Boolean?,
) {
    companion object {
        fun fromEntity(p: Pedido): PedidoResponse =
            PedidoResponse(
                id = p.id ?: 0,
                clienteId = p.cliente?.id,
                fechaPedido = p.fechaPedido,
                fechaRetiro = p.fechaRetiro,
                franjaHoraria = p.franjaHoraria,
                tipoEntrega = p.tipoEntrega,
                direccion = p.direccion,
                estado = p.estado,
                total = p.total,
                sena = p.sena,
                senaPagada = p.senaPagada,
            )
    }
}