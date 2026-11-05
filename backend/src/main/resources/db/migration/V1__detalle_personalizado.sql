CREATE TABLE IF NOT EXISTS detalle_personalizado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    tipo VARCHAR(20),
    nombre_personalizado VARCHAR(100),
    cantidad INT,
    porciones INT,
    sabor VARCHAR(50),
    descripcion TEXT,
    link_referencia VARCHAR(300),
    imagen_por_whatsapp TINYINT(1),
    precio_cotizado INT,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;