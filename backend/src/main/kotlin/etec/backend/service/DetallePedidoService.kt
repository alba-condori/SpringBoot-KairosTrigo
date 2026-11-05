package etec.backend.service

import etec.backend.dto.DetallePedidoRequest
import etec.backend.dto.DetallePedidoResponse
import etec.backend.entity.DetallePedido
import etec.backend.exception.RecursoNoEncontradoException
import etec.backend.repository.DetallePedidoRepository
import etec.backend.repository.PedidoRepository
import etec.backend.repository.ProductoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DetallePedidoService(
    private val detallePedidoRepository: DetallePedidoRepository,
    private val pedidoRepository: PedidoRepository,
    private val productoRepository: ProductoRepository
) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<DetallePedidoResponse> =
        detallePedidoRepository.findAll(pageable).map { DetallePedidoResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): DetallePedidoResponse {
        val detalle = detallePedidoRepository.findById(id)
            .orElseThrow { RecursoNoEncontradoException("Detalle de pedido", id) }
        return DetallePedidoResponse.fromEntity(detalle)
    }

    @Transactional
    fun crear(req: DetallePedidoRequest): DetallePedidoResponse {
        val pedido = pedidoRepository.findById(req.pedidoId)
            .orElseThrow { RecursoNoEncontradoException("Pedido", req.pedidoId) }
        val producto = productoRepository.findById(req.productoId)
            .orElseThrow { RecursoNoEncontradoException("Producto", req.productoId) }
        val nuevo = DetallePedido(
            pedido = pedido,
            producto = producto,
            cantidad = req.cantidad,
            variedad = req.variedad,
            precioUnitario = req.precioUnitario
        )
        return DetallePedidoResponse.fromEntity(detallePedidoRepository.save(nuevo))
    }
}