# SOBREVIDA LTDA - Vacinas SARS-COV-2
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/LICENSE) 

# Sobre o projeto

https://www.youtube.com/watch?v=pOBHq4WMrwY&t=5s

Sobrevida é uma aplicação Java desktop construída durante o 1ª semestre de 2021, e apresentada no evento **EXPO SÃO JUDAS TI** - organizado pela [Universidade São Judas Tadeu](https://sites.google.com/saojudas.br/exposaojudasti/projetos/bancas-20211 "Aluno - Werike Marques Santos").

O sistema foi desenvolvido com o objetivo de ajudar funcionários da recepção e/ou administração, no controle de aplicações de vacinas contra o SARS-COV-2.

## Layout 
![Inicializando o sistema 1](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/01.png)

![Login 2](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/02.png)

![Criar conta 3](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/03.png)

![Reset senha 4](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/04.png)

![Área principal 5](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/5.png)

![Cadastro Pacientes 6](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/6.png)

![Cadastro de vacinas 7](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/07.png)

![Controle de aplicações 8](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/8.png)

![Relatório 9](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/9.png)

![Relatório 9.1](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/9_1.png)

![Tutorial 10](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/10.png)

![Link 11](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/11.png)

![Sobre 12](https://github.com/werikesantos/Projeto_Vacina_Codiv19/blob/master/PROJETO/vacinaSARS-CoV-2/src/main/resources/image/layout/12.png)

# Tecnologias utilizadas
## Back end
- Java Platform Standard Edition 
- Architecture MVC
- Library rs2xml 1.0
- Library openpdf 1.3.26
- Maven
## Front end
- API Swing
## Implantação em produção
- Banco de dados: mysql-connector-java-8.0.24

# Como executar o projeto

## Back end
Pré-requisitos: JDK 11.0.10

```bash
# clonar repositório
git clone https://github.com/werikesantos/Projeto_Vacina_Codiv19.git

# abrir o MySQL Workbench e configurar uma nova conexão cadastrando um usuário e senha
- Criar um banco de dados com o seguinte nome "bd_vacina_sars_cov_2"

# banco de dados MySQL
- Nas respectivas linhas 12, 13, 14 e 15 colocar dentro das aspas os dados da conexão com o banco de dados dentro do arquivo informado abaixo:
cd Projeto_Vacina_Codiv19\PROJETO\vacinaSARS-CoV-2\src\main\java\br\com\sobrevida\vacinaSARSCoV2\model\dao\ConnectionFactory.java

# Ajustando rota do relatório 
- Criar uma pasta em qualquer lugar com o seguinte nome: "RELATÓRIO DE CONTROLE DE APLICAÇÕES"
- Copiar o caminho dessa pasta e colar na linha 60 e 123 dentro do arquivo abaixo:
cd Projeto_Vacina_Codiv19\PROJETO\vacinaSARS-CoV-2\src\main\java\br\com\sobrevida\vacinaSARSCoV2\controller\RelatorioController.java
- Copiar o caminho que leva a imagem(conforme descrito abaixo) e colar na linha 63 desse mesmo arquivo conforme descrito acima
cd .\Projeto_Vacina_Codiv19\PROJETO\vacinaSARS-CoV-2\src\main\resources\image\relatorioBranco.png

# importar dump no MySQL
cd .\Projeto_Vacina_Codiv19\PROJETO\vacinaSARS-CoV-2\src\main\java\br\com\sobrevida\vacinaSARSCoV2\model\bd_vacina_SARS_COV_2\DUMP-16_06_2021

# executar o projeto
- Copiar o executável localizado no caminho abaixo e colar na área de trabalho:
cd Projeto_Vacina_Codiv19\PROJETO\vacinaSARS-CoV-2\target\Sobrevida.exe
```



# Autor

Werike Marques Santos

https://www.linkedin.com/in/werike-santos-bb91a5167

https://www.youtube.com/channel/UCLKSIfyDV0Cx-R4IaNB_CSg

