-- Inserção de 10 produtos para SQL Server - deixar JPA gerenciar as datas
INSERT INTO Produto (name, price, created_at, updated_at) VALUES ('Café', 1500, '2024-01-01T10:00:00.000-03:00', '2024-01-01T10:00:00.000-03:00');
INSERT INTO Produto (name, price, created_at, updated_at) VALUES ('Chá', 1200, '2024-01-01T10:00:00.000-03:00', '2024-01-01T10:00:00.000-03:00');
INSERT INTO APP_USER(name, email, password) VALUES ('gustavo', 'gustavodiasdsc@gmail.com', '$2a$12$BU0FMgJlbaJQoL3UeB.qJ.JQjy3NH98VMdxnHTyUAK2ABn3Cg7LG.');