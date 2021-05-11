# JUNÇÃO DAS TABELAS 'CIDADÃO', 'VACINA' E 'APLICAÇÃO'
SELECT ci.nome, ci.cpf, va.desenvolvedora, va.qtd_Dose, ap.unica, ap.primeira, ap.segunda
FROM aplicacao ap
INNER JOIN cidadao ci
ON ap.idCidadao = ci.id
INNER JOIN vacina va
ON ap.idVacina = va.id;