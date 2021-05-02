# JUNÇÃO DAS DUAS TABELAS 'USUARIO' E 'PERFIL'
SELECT *
FROM usuario
INNER JOIN perfil
ON usuario.idPerfil = perfil.id;