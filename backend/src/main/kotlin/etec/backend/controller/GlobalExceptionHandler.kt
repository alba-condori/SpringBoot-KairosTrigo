package etec.backend.controller

import etec.backend.dto.ErrorResponseDto
import etec.backend.service.PrecondicionInvalidaException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(PrecondicionInvalidaException::class)
    fun manejarPrecondicionInvalida(ex: PrecondicionInvalidaException): ResponseEntity<ErrorResponseDto> {
        val cuerpoError = ErrorResponseDto(error = ex.message ?: "Parámetros inválidos")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpoError)
    }
}