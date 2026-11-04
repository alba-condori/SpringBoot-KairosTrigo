CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    categoria VARCHAR(50),
    precio INT,
    a_cotizar TINYINT(1)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;