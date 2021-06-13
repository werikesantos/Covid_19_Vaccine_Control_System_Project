# 1 - CRIANDO TABELA APLICAÇÃO
CREATE TABLE aplicacao(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idCidadao INT NOT NULL,
    idVacina INT NOT NULL,
    dose_aplicada INT(1) NOT NULL,
    data_aplicacao VARCHAR(10) NOT NULL,
    previsao DATE,
    FOREIGN KEY (idCidadao) REFERENCES cidadao(id),
    FOREIGN KEY (idVacina) REFERENCES vacina(id)
);

# 2 - INSERIR DADOS NA TABELA
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (1, 1, 1, '20/05/2021', '20/06/2021');

INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (1, 1, 1, '20/05/2021', '20/06/2021');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (11, 6, 1, '20/05/2021', 'null');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (6, 3, 1, '20/05/2021', '30/05/2021');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (2, 3, 1, '25/08/1993', '31/05/2021');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (6, 3, 2, '30/05/2021', 'null');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (15, 3, 1, '25/08/1993', '31/05/2021');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (17, 6, 1, '25/08/1993', '31/05/2021');
INSERT INTO bd_vacina_sars_cov_2.aplicacao(idCidadao, idVacina, dose_aplicada, data_aplicacao, previsao) VALUES (12, 6, 1, '25/08/1993', 'null');

# 3 - SELECIONAR TABELA APLICAÇÃO
SELECT * FROM bd_vacina_sars_cov_2.aplicacao;