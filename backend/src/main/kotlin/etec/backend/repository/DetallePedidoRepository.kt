package etec.backend.repository

import etec.backend.entity.DetallePedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetallePedidoRepository : JpaRepository<DetallePedido, Int>