package etec.backend.dto

import etec.backend.entity.DetallePedido

data class DetallePedidoResponse(
    val id: Int,
    val pedidoId: Int?,
    val productoId: Int?,
    val cantidad: Int?,
    val variedad: String?,
    val precioUnitario: Int?,
) {
    companion object {
        fun fromEntity(d: DetallePedido): DetallePedidoResponse =
            DetallePedidoResponse(
                id = d.id ?: 0,
                pedidoId = d.pedido?.id,
                productoId = d.producto?.id,
                cantidad = d.cantidad,
                variedad = d.variedad,
                precioUnitario = d.precioUnitario,
            )
    }
}