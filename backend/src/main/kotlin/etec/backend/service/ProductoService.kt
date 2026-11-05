package etec.backend.service

import etec.backend.dto.ProductoRequest
import etec.backend.dto.ProductoResponse
import etec.backend.entity.Producto
import etec.backend.exception.RecursoNoEncontradoException
import etec.backend.repository.ProductoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductoService(
    private val productoRepository: ProductoRepository
) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<ProductoResponse> =
        productoRepository.findAll(pageable).map { ProductoResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): ProductoResponse {
        val producto = productoRepository.findById(id)
            .orElseThrow { RecursoNoEncontradoException("Producto", id) }
        return ProductoResponse.fromEntity(producto)
    }

    @Transactional
    fun crear(req: ProductoRequest): ProductoResponse {
        val nuevo = Producto(
            nombre = req.nombre,
            descripcion = req.descripcion,
            categoria = req.categoria,
            precio = req.precio,
            unidad = req.unidad
        )
        return ProductoResponse.fromEntity(productoRepository.save(nuevo))
    }
}