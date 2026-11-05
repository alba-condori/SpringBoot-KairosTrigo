package etec.backend.controller

import etec.backend.dto.DetallePersonalizadoRequest
import etec.backend.dto.DetallePersonalizadoResponse
import etec.backend.service.DetallePersonalizadoService
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
@RequestMapping("/api/detalles-personalizados")
class DetallePersonalizadoController(
    private val detallePersonalizadoService: DetallePersonalizadoService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<DetallePersonalizadoResponse>> =
        ResponseEntity.ok(detallePersonalizadoService.listar(pageable))

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<DetallePersonalizadoResponse> =
        ResponseEntity.ok(detallePersonalizadoService.obtener(id))

    @PostMapping
    fun crear(@Valid @RequestBody req: DetallePersonalizadoRequest): ResponseEntity<DetallePersonalizadoResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(detallePersonalizadoService.crear(req))
}