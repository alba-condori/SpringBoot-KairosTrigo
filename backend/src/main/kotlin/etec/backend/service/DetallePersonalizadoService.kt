package etec.backend.service

import etec.backend.dto.DetallePersonalizadoRequest
import etec.backend.dto.DetallePersonalizadoResponse
import etec.backend.entity.DetallePersonalizado
import etec.backend.exception.RecursoNoEncontradoException
import etec.backend.repository.DetallePersonalizadoRepository
import etec.backend.repository.PedidoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DetallePersonalizadoService(
    private val detallePersonalizadoRepository: DetallePersonalizadoRepository,
    private val pedidoRepository: PedidoRepository
) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<DetallePersonalizadoResponse> =
        detallePersonalizadoRepository.findAll(pageable)
            .map { DetallePersonalizadoResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): DetallePersonalizadoResponse {
        val detalle = detallePersonalizadoRepository.findById(id)
            .orElseThrow { RecursoNoEncontradoException("Detalle personalizado", id) }
        return DetallePersonalizadoResponse.fromEntity(detalle)
    }

    @Transactional
    fun crear(req: DetallePersonalizadoRequest): DetallePersonalizadoResponse {
        val pedido = pedidoRepository.findById(req.pedidoId)
            .orElseThrow { RecursoNoEncontradoException("Pedido", req.pedidoId) }
        val nuevo = DetallePersonalizado(
            pedido = pedido,
            tipo = req.tipo,
            nombrePersonalizado = req.nombrePersonalizado,
            cantidad = req.cantidad,
            porciones = req.porciones,
            sabor = req.sabor,
            descripcion = req.descripcion,
            linkReferencia = req.linkReferencia,
            imagenPorWhatsapp = req.imagenPorWhatsapp,
            precioCotizado = req.precioCotizado
        )
        return DetallePersonalizadoResponse.fromEntity(detallePersonalizadoRepository.save(nuevo))
    }
}