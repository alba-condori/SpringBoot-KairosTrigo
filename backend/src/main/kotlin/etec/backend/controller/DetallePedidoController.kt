package etec.backend.controller

import etec.backend.dto.DetallePedidoRequest
import etec.backend.dto.DetallePedidoResponse
import etec.backend.service.DetallePedidoService
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
@RequestMapping("/api/detalles-pedido")
class DetallePedidoController(
    private val detallePedidoService: DetallePedidoService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<DetallePedidoResponse>> =
        ResponseEntity.ok(detallePedidoService.listar(pageable))

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<DetallePedidoResponse> =
        ResponseEntity.ok(detallePedidoService.obtener(id))

    @PostMapping
    fun crear(@Valid @RequestBody req: DetallePedidoRequest): ResponseEntity<DetallePedidoResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoService.crear(req))
}