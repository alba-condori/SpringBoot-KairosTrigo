CREATE TABLE IF NOT EXISTS pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    fecha_retiro DATETIME,
    tipo_entrega VARCHAR(20),
    direccion VARCHAR(200),
    estado VARCHAR(20),
    total INT,
    sena INT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;