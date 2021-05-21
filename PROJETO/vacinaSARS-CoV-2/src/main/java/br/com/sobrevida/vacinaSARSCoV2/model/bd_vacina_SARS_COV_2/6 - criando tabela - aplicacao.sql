# 1 - CRIANDO TABELA APLICAÇÃO
CREATE TABLE aplicacao(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idCidadao INT NOT NULL UNIQUE,
    idVacina INT NOT NULL,
    dose INT(1) NOT NULL,
    unica VARCHAR(10),
    primeira VARCHAR(10),
    segunda VARCHAR(10),
    FOREIGN KEY (idCidadao) REFERENCES cidadao(id),
    FOREIGN KEY (idVacina) REFERENCES vacina(id)
);

# 2 - INSERIR DADOS NA TABELA
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose, unica, primeira, segunda) VALUES (1, 1, 1, 'null', '20/05/2021', '20/06/2021');

# 3 - SELECIONAR TABELA APLICAÇÃO
SELECT * FROM bd_vacina_sars_cov_2.aplicacao;