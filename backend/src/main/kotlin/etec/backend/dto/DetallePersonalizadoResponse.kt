package etec.backend.dto

import etec.backend.entity.DetallePersonalizado

data class DetallePersonalizadoResponse(
    val id: Int,
    val pedidoId: Int?,
    val tipo: String?,
    val nombrePersonalizado: String?,
    val cantidad: Int?,
    val porciones: Int?,
    val sabor: String?,
    val descripcion: String?,
    val linkReferencia: String?,
    val imagenPorWhatsapp: Boolean?,
    val precioCotizado: Int?,
) {
    companion object {
        fun fromEntity(d: DetallePersonalizado): DetallePersonalizadoResponse =
            DetallePersonalizadoResponse(
                id = d.id ?: 0,
                pedidoId = d.pedido?.id,
                tipo = d.tipo,
                nombrePersonalizado = d.nombrePersonalizado,
                cantidad = d.cantidad,
                porciones = d.porciones,
                sabor = d.sabor,
                descripcion = d.descripcion,
                linkReferencia = d.linkReferencia,
                imagenPorWhatsapp = d.imagenPorWhatsapp,
                precioCotizado = d.precioCotizado,
            )
    }
}