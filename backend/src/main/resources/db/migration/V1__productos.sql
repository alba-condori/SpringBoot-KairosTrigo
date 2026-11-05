CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    categoria VARCHAR(50),
    precio INT,
    unidad VARCHAR(20)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;