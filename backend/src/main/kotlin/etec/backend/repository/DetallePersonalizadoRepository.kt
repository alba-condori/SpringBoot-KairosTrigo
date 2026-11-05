package etec.backend.repository

import etec.backend.entity.DetallePersonalizado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetallePersonalizadoRepository : JpaRepository<DetallePersonalizado, Int>