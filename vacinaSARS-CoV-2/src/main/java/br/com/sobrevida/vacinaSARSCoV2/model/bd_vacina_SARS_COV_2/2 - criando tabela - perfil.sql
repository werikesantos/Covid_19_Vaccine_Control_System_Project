# 1 - CRIANDO A TABELA PERFIL
CREATE TABLE perfil(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(80) NOT NULL UNIQUE
);

# 2 - INSERINDO PERFIL
INSERT INTO bd_vacina_sars_cov_2.perfil (usuario) VALUES ('Administrador');
INSERT INTO bd_vacina_sars_cov_2.perfil (usuario) VALUES ('Paciente');
INSERT INTO bd_vacina_sars_cov_2.perfil (usuario) VALUES ('Recepcionista');

# 3 - VERIFICANDO SE FOI CADASTRADO
SELECT * FROM perfil;