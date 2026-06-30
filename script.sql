
CREATE TABLE Artista(
	codArtista SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	nacionalidade VARCHAR(60),
	dtNascimento DATE
);
CREATE TABLE Comprador(
	codComprador SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	pais VARCHAR(60),
	telefone VARCHAR(20)
);
CREATE TABLE Obra(
	codObra SERIAL PRIMARY KEY,
	titulo VARCHAR(150),
	ano INTEGER,
	preco NUMERIC(12, 2),
	imagem BYTEA
);
CREATE TABLE Exposicao(
	codExposicao SERIAL PRIMARY KEY,
	titulo VARCHAR(150),
	tema VARCHAR(100),
	dtInicio DATE,
	dtFim DATE
);
CREATE TABLE Registro(
	codComprador INTEGER,
	codObra INTEGER,
	numRegistro INTEGER,
	dtVenda DATE,
	precoFinal NUMERIC(12, 2),
	formaPgto VARCHAR(40),
	descricao TEXT,
	PRIMARY KEY (codComprador, codObra),
	FOREIGN KEY (codComprador) REFERENCES Comprador(codComprador),
	FOREIGN KEY (codObra) REFERENCES Obra(codObra)
);
CREATE TABLE Cria(
	codArtista INTEGER,
	codObra INTEGER,
	PRIMARY KEY (codArtista, codObra),
	FOREIGN KEY (codArtista) REFERENCES Artista(codArtista),
	FOREIGN KEY (codObra) REFERENCES Obra(codObra)
);
CREATE TABLE Participa(
	codExposicao INTEGER,
	codObra INTEGER,
	PRIMARY KEY (codExposicao, codObra),
	FOREIGN KEY (codExposicao) REFERENCES Exposicao(codExposicao),
	FOREIGN KEY (codObra) REFERENCES Obra(codObra)
);

INSERT INTO Artista (nome, nacionalidade, dtNascimento) VALUES
('Vincent van Gogh', 'Holandesa', '1853-03-30'),
('Francisco Goya', 'Espanhola', '1746-03-30'),
('Hieronymus Bosch', 'Holandesa', '1450-01-01'),
('Tarsila do Amaral', 'Brasileira', '1886-09-01'),
('Salvador Dali', 'Espanhola', '1904-05-11');

INSERT INTO Comprador (nome, pais, telefone) VALUES
('Anonimo', '.', '-'),
('Carlos Mendes', 'Brasil', '47999990001'),
('Sophie Laurent', 'Franca', '33145556677'),
('Marco Rossi', 'Italia', '390612345678'),
('Akira Tanaka', 'Japao', '81312345678');

INSERT INTO Obra (titulo, ano, preco) VALUES
('Noite Estrelada', 1889, 1000000.00),
('Os Comedores de Batata', 1885, 800000.00),
('Campo de Trigo com Corvos', 1890, 750000.00),
('Saturno Devorando seu Filho', 1823, 999999.99),
('A Persistencia da Memoria', 1931, 500000.00);

INSERT INTO Exposicao (titulo, tema, dtInicio, dtFim) VALUES
('Impressionismo Brasileiro', 'Pintura', '2026-03-01', '2026-04-30'),
('Arte Moderna', 'Escultura', '2020-06-15', '2020-08-20'),
('Pesadelos e Visoes', 'Surrealismo', '2024-09-01', '2024-10-15'),
('Cores do Pos-Impressionismo', 'Pintura', '2021-11-01', '2021-12-20'),
('Mestres Espanhois', 'Pintura Classica', '2025-01-10', '2025-02-28');

INSERT INTO Registro (codComprador, codObra, numRegistro, dtVenda, precoFinal, formaPgto, descricao) VALUES
(2, 1, 1, '2024-05-10', 950000.00, 'Cartao de Credito', 'Venda realizada em leilao'),
(3, 2, 2, '2024-06-15', 780000.00, 'Transferencia Bancaria', 'Comprador internacional'),
(4, 3, 3, '2024-07-20', 720000.00, 'Cheque', ''),
(5, 4, 4, '2024-08-05', 990000.00, 'Cartao de Credito', 'Venda em galeria privada'),
(1, 5, 5, '2024-09-12', 480000.00, 'Dinheiro', 'Cliente anonimo');

INSERT INTO Cria (codArtista, codObra) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(3, 4),
(4, 5),
(5, 5),
(2, 1),
(3, 2),
(4, 3);

INSERT INTO Participa (codExposicao, codObra) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 4),
(3, 5),
(4, 1),
(4, 3),
(5, 2),
(5, 5);

