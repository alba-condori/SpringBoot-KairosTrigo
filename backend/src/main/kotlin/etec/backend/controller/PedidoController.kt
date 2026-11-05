package etec.backend.controller

import etec.backend.dto.PedidoRequest
import etec.backend.dto.PedidoResponse
import etec.backend.service.PedidoService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pedidos")
class PedidoController(
    private val pedidoService: PedidoService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<PedidoResponse>> =
        ResponseEntity.ok(pedidoService.listar(pageable))

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<PedidoResponse> =
        ResponseEntity.ok(pedidoService.obtener(id))

    @PostMapping
    fun crear(@Valid @RequestBody req: PedidoRequest): ResponseEntity<PedidoResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crear(req))
}