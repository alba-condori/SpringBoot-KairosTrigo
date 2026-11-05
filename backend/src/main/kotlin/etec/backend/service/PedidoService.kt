package etec.backend.service

import etec.backend.dto.PedidoRequest
import etec.backend.dto.PedidoResponse
import etec.backend.entity.Pedido
import etec.backend.exception.RecursoNoEncontradoException
import etec.backend.repository.ClienteRepository
import etec.backend.repository.PedidoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository,
    private val clienteRepository: ClienteRepository
) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<PedidoResponse> =
        pedidoRepository.findAll(pageable).map { PedidoResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): PedidoResponse {
        val pedido = pedidoRepository.findById(id)
            .orElseThrow { RecursoNoEncontradoException("Pedido", id) }
        return PedidoResponse.fromEntity(pedido)
    }

    @Transactional
    fun crear(req: PedidoRequest): PedidoResponse {
        val cliente = clienteRepository.findById(req.clienteId)
            .orElseThrow { RecursoNoEncontradoException("Cliente", req.clienteId) }
        val nuevo = Pedido(
            cliente = cliente,
            fechaPedido = LocalDateTime.now(),
            fechaRetiro = req.fechaRetiro,
            franjaHoraria = req.franjaHoraria,
            tipoEntrega = req.tipoEntrega,
            direccion = req.direccion,
            estado = req.estado,
            total = req.total,
            sena = req.sena,
            senaPagada = req.senaPagada
        )
        return PedidoResponse.fromEntity(pedidoRepository.save(nuevo))
    }
}