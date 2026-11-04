package etec.backend.exception

class ProductoNoEncontradoException(id: Long) :
    RuntimeException("Producto no encontrado con el ID: $id")