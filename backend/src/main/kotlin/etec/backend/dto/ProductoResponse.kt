package etec.backend.dto

import etec.backend.entity.Producto

data class ProductoResponse(
    val id: Int,
    val nombre: String?,
    val descripcion: String?,
    val categoria: String?,
    val precio: Int?,
    val unidad: String?,
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse =
            ProductoResponse(
                id = p.id ?: 0,
                nombre = p.nombre,
                descripcion = p.descripcion,
                categoria = p.categoria,
                precio = p.precio,
                unidad = p.unidad,
            )
    }
}