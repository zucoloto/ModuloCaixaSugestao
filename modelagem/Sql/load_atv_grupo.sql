INSERT INTO flc_grupo (id, descricao, nome_grupo) VALUES
(1, 'Administrador do Sistema', 'ADMINISTRADOR'),
(2, 'Usuário do Sistema', 'USUARIO');

INSERT INTO flc_usuario_grupo (usuario_id, grupo_id) VALUES
(1, 1),
(3, 2);
