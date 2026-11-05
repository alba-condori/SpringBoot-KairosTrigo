package etec.backend.service

import etec.backend.dto.ClienteRequest
import etec.backend.dto.ClienteResponse
import etec.backend.entity.Cliente
import etec.backend.exception.RecursoNoEncontradoException
import etec.backend.repository.ClienteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<ClienteResponse> =
        clienteRepository.findAll(pageable).map { ClienteResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): ClienteResponse {
        val cliente = clienteRepository.findById(id)
            .orElseThrow { RecursoNoEncontradoException("Cliente", id) }
        return ClienteResponse.fromEntity(cliente)
    }

    @Transactional
    fun crear(req: ClienteRequest): ClienteResponse {
        val nuevo = Cliente(
            nombre = req.nombre,
            apellido = req.apellido,
            telefono = req.telefono
        )
        return ClienteResponse.fromEntity(clienteRepository.save(nuevo))
    }
}