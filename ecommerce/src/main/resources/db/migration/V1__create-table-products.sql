CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(15, 2) NOT NULL,
    quantidade INT
);
