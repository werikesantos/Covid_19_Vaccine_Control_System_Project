# 1 - CRIANDO TABELA CIDADAO
CREATE TABLE cidadao(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
	nascimento VARCHAR(10) NOT NULL,
	celular VARCHAR(14),
	cpf VARCHAR(14) UNIQUE NOT NULL,
	endereco VARCHAR(100) NOT NULL,
    n VARCHAR(20) NOT NULL,
	email VARCHAR(80) NOT NULL
);

# 2 - INSERINDO UM CADASTRO
INSERT INTO bd_vacina_sars_cov_2.cidadao (nome, nascimento, celular, cpf, endereco, n, email) VALUES ('werike', '02/03/2021', '11 9 6547-8502', '456.654.789-02', 'Rua do zé caneta', '1478', 'werike@gmail.com');

# 3 - VERIFICANDO SE FOI CADASTRADO
SELECT * FROM cidadao;