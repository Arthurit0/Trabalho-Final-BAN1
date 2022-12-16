CREATE TABLE regiao(
	id serial,
	cidade varchar(50),
	estado varchar(50) NOT NULL,
	UNIQUE(cidade, estado),
	PRIMARY KEY (id)
);

INSERT INTO regiao (cidade, estado) VALUES (NULL, 'Santa Catarina');
INSERT INTO regiao (cidade, estado) VALUES (NULL, 'Paraná');
INSERT INTO regiao (cidade, estado) VALUES ('Joinville', 'Santa Catarina');
INSERT INTO regiao (cidade, estado) VALUES (NULL, 'São Paulo');
INSERT INTO regiao (cidade, estado) VALUES ('Curitiba', 'Paraná')

CREATE TABLE usuario(
	id serial,
	nome varchar(50) NOT NULL,
	email varchar(30) NOT NULL,
	id_regiao int NOT NULL,
	avaliacao float,
	instituicao varchar(30),
	profissao varchar(30),
	senha varchar(30) NOT NULL,
	cont_denuncias int,
	is_Adm boolean,
	PRIMARY KEY(id),
	FOREIGN KEY(id_regiao) REFERENCES regiao(id)
);

INSERT INTO usuario (nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm) 
VALUES ('Arthur', 'arthur@gmail.com', 3, 1, 'UDESC', 'Estagiário', 'arthur123', 0, true);
INSERT INTO usuario (nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm) 
VALUES ('Ana', 'Ana@gmail.com', 3, 3, 'UDESC', 'Estudante', 'anaClara123', 0, true);
INSERT INTO usuario (nome, email, id_regiao, avaliacao, profissao, senha, cont_denuncias, is_adm) 
VALUES ('Pedro', 'Pedro@gmail.com', 2, 1, 'Empresário', 'pedro11123', 1, false);
INSERT INTO usuario (nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm) 
VALUES ('Rodrigo', 'Rodrigo@gmail.com', 2, 0, 'UDESC', 'Jogador', '1234567', 0, false);
INSERT INTO usuario (nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm) 
VALUES ('Grasiella', 'Grasi@gmail.com', 4, 4, 'UDESC', 'Estagiária', 'senha', 0, false);


CREATE TABLE publicacao(
	id serial,
	id_autor int NOT NULL,
	texto TEXT NOT NULL,
	likes int NOT NULL,
	deslikes int NOT NULL,
	data_publicacao date,
	removido boolean,
	tipo_pub char NOT NULL,
	id_regiao int,
	id_pub int,
	id_mencao int,
	arquivo varchar(200),
	PRIMARY KEY (id),
	FOREIGN KEY (id_autor) REFERENCES usuario(id),
	FOREIGN KEY (id_regiao) REFERENCES regiao(id),
	FOREIGN KEY (id_pub) REFERENCES publicacao(id),
	FOREIGN KEY (id_mencao) REFERENCES usuario(id)
);

INSERT INTO publicacao (id_autor, texto, likes, deslikes, data_publicacao, removido, tipo_pub, id_regiao, id_pub, id_mencao, arquivo)
VALUES (1, 'Oi, tenho uma dúvida quanto...', 10, 0, '2019-12-29', FALSE, 'P', 3, NULL, NULL, NULL);
INSERT INTO publicacao (id_autor, texto, likes, deslikes, data_publicacao, removido, tipo_pub, id_regiao, id_pub, id_mencao, arquivo)
VALUES (2, 'Oi, bom dia...', 1, 0, '2019-12-29', FALSE, 'R', NULL, 1, NULL, 'Resposta.png');
INSERT INTO publicacao (id_autor, texto, likes, deslikes, data_publicacao, removido, tipo_pub, id_regiao, id_pub, id_mencao, arquivo)
VALUES (1, 'Mano, realmente acredito que', 3, -1, '2019-12-30', FALSE, 'C', NULL, 2, 5, NULL);
INSERT INTO publicacao (id_autor, texto, likes, deslikes, data_publicacao, removido, tipo_pub, id_regiao, id_pub, id_mencao, arquivo)
VALUES (3, 'Preciso saber se...', 2, 0, '2019-12-31', FALSE, 'P', 3, NULL, NULL, NULL);
