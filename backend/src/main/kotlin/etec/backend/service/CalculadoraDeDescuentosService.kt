package etec.backend.service

import org.springframework.stereotype.Service

@Service
class CalculadoraDeDescuentosService {

    fun aplicarDescuentosSegunUsuario(userID: String, monto: Double): Double {
        if (monto <= 0) {
            throw PrecondicionInvalidaException("El monto debe ser mayor a cero")
        }

        return monto * 0.75
    }
}