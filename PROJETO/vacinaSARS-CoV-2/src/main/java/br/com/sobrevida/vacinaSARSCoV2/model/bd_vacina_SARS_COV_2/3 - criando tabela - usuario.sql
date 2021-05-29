# 1 - CRIANDO TABELA CADASTRO DE USUÁRIO
CREATE TABLE usuario(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idPerfil INT NOT NULL,
    nome VARCHAR(60) NOT NULL,
    apelido VARCHAR(10) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(16) NOT NULL,
    FOREIGN KEY (idPerfil) REFERENCES perfil(id)
);

# 2 - INSERINDO USUARIO
INSERT INTO bd_vacina_sars_cov_2.usuario (idPerfil, nome, apelido, cpf, email, senha) VALUES ('3', 'werike Santos', 'Werike', '444.555.655-10', 'werike', '1');
INSERT INTO bd_vacina_sars_cov_2.usuario (idPerfil, nome, apelido, cpf, email, senha) VALUES ('3', 'lucas nunes', 'lucas', '444.785.965-44', 'lucasnunes@gmail.com', '12345678');

# 3 - OBS: PARA INSERIR MAIS USUÁRIO BASTA COPIAR A LINHA ACIMA E ALTERAR SOMENTE OS 'VALUES'.


# 4 - VERIFICANDO SE FOI CADASTRADO
SELECT * FROM usuario;