# 1 - CRIANDO TABELA CADASTRO DE VACINA
#drop table vacina;
CREATE TABLE vacina(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    desenvolvedora VARCHAR(60) NOT NULL,
    produtora VARCHAR(60) NOT NULL,
    parceira VARCHAR(60) NOT NULL,
    qtd_Dose INT(2) NOT NULL,
    periodo VARCHAR(12) NOT NULL,
    descricao VARCHAR(4000) NOT NULL
);

# 2 - INSERINDO VACINA
INSERT INTO bd_vacina_sars_cov_2.vacina(desenvolvedora, produtora, parceira, qtd_Dose, periodo, descricao) VALUES ('Universidade Oxford', 'Astrazeneca', 'Fiocruz', 2, '03 meses', 'Tecnologia - A vacina produzida pela Universidade de Oxford (Reino Unido) usa uma tecnologia conhecida como vetor viral não replicante. Por isso, utiliza um "vírus vivo", como um adenovírus (que causa o resfriado comum), que não tem capacidade de se replicar no organismo humano ou prejudicar a saúde. Este adenovírus também é modificado por meio de engenharia genética para passar a carregar em si as instruções para a produção de uma proteína característica do coronavírus, conhecida como espícula. Ao entrar nas células, o adenovírus faz com que elas passem a produzir essa proteína e a exiba em sua superfície, o que é detectado pelo sistema imune, que cria formas de combater o coronavírus e cria uma resposta protetora contra uma infecção.
Eficácia - A AstraZeneca e a Universidade de Oxford anunciaram dois resultados distintos de eficácia desta vacina —62% quando aplicada em duas doses completas e 90% com meia dose seguida de outra completa. A eficácia média, segundo os cientistas responsáveis, é de 70%.');

# 3 - OBS: PARA INSERIR MAIS VACINAS BASTA COPIAR A LINHA ACIMA E ALTERAR SOMENTE OS 'VALUES'.

# 4 - VERIFICANDO SE FOI CADASTRADO
SELECT * FROM bd_vacina_sars_cov_2.vacina;