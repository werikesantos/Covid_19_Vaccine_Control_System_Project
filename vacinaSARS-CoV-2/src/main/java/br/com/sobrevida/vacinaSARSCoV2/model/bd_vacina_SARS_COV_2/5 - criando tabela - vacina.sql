# 1 - CRIANDO TABELA CADASTRO DE VACINA
    
CREATE TABLE vacina(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    desenvolvedora VARCHAR(60) NOT NULL,
    produtora VARCHAR(60) NOT NULL UNIQUE,
    parceira VARCHAR(60) NOT NULL,
    qtd_Dose INT(2) NOT NULL,
    periodo VARCHAR(12) NOT NULL,
    descricao VARCHAR(4000) NOT NULL
);

# 2 - INSERINDO VACINA
INSERT INTO bd_vacina_sars_cov_2.vacina(desenvolvedora, produtora, parceira, qtd_Dose, periodo, descricao) VALUES ('Universidade Oxford', 'Astrazeneca', 'Fiocruz', 2, '03 meses', '* Tecnologia *\r A vacina produzida pela Universidade de Oxford (Reino Unido)\r usa uma tecnologia conhecida como vetor viral não \r replicante. \r Por isso, utiliza um \"vírus vivo\", como um adenovírus \r (que causa o resfriado comum), que não tem capacidade de \r se replicar no organismo humano ou prejudicar a saúde.\r  \r Este adenovírus também é modificado por meio de \r engenharia genética para passar a carregar em si as \r instruções para a produção de uma proteína característica\r do coronavírus, conhecida como espícula. \r Ao entrar nas células, o adenovírus faz com que elas passem\r a produzir essa proteína e a exiba em sua superfície, \r o que é detectado pelo sistema imune, que cria formas\r de combater o coronavírus e cria uma resposta protetora\r contra uma infecção.\r \r * Eficácia *\r A AstraZeneca e a Universidade de Oxford anunciaram dois \r resultados distintos de eficácia desta vacina —62% quando \r aplicada em duas doses completas e 90% com meia dose \r seguida de outra completa. \r A eficácia média, segundo os cientistas responsáveis,\r é de 70%.');
INSERT INTO bd_vacina_sars_cov_2.vacina(desenvolvedora, produtora, parceira, qtd_Dose, periodo, descricao) VALUES ('Sinovac', 'Instituto Butantan', 'Instituto Butantan', 2, '14 a 28 dias', '* Tecnologia *\r A vacina de origem chinesa é feita com o vírus inativado: \r ele é cultivado e multiplicado numa cultura de células e \r depois inativado por meio de calor ou produto químico. \r Ou seja, o corpo que recebe a vacina com o vírus \r —já inativado— começa a gerar os anticorpos \r necessários no combate da doença.\r \r As células que dão início à resposta imune encontram \r os vírus inativados e os capturam, \r ativando os linfócitos, células especializadas \r capazes de combater microrganismos. \r Os linfócitos produzem anticorpos, que se ligam \r aos vírus para impedir que eles infectem nossas células.\r \r * Eficácia *\r A eficácia geral da CoronaVac é 50,38%, ou seja, \r os vacinadostêm 50,38% menos risco de adoecer e,\r caso pegue covid-19, a vacina oferece 100% de eficácia\r para não adoecer gravemente e 78% para \r prevenir casos leves.');

# 3 - OBS: PARA INSERIR MAIS VACINAS BASTA COPIAR A LINHA ACIMA E ALTERAR SOMENTE OS 'VALUES'.
# INSERT INTO bd_vacina_sars_cov_2.vacina(colunas) VALUES (campos e seus valores);

# 4 - VERIFICANDO SE FOI CADASTRADO
SELECT * FROM bd_vacina_sars_cov_2.vacina;