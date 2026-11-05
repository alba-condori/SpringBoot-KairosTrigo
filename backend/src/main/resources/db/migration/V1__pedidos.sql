CREATE TABLE IF NOT EXISTS pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    fecha_pedido DATETIME,
    fecha_retiro DATE,
    franja_horaria VARCHAR(30),
    tipo_entrega VARCHAR(20),
    direccion VARCHAR(200),
    estado VARCHAR(20),
    total INT,
    sena INT,
    sena_pagada TINYINT(1),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;