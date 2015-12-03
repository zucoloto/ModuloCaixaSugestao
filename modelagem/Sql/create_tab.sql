-- Estrutura da tabela 'Assunto'
CREATE TABLE IF NOT EXISTS flc_assunto (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  assunto VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'mensagem'
CREATE TABLE IF NOT EXISTS flc_mensagem (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  assunto_id BIGINT(20) NOT NULL,
  data_hora_registro DATETIME NOT NULL,
  mensagem MEDIUMTEXT NOT NULL, 
  PRIMARY KEY(id), 
  INDEX fk_mensagem_assunto(assunto_id),
  FOREIGN KEY(assunto_id) REFERENCES flc_assunto(id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'Usuário-Mensagem'
CREATE TABLE IF NOT EXISTS flc_usuario_mensagem (
  usuario_id BIGINT NOT NULL,
  mensagem_id BIGINT NOT NULL,
  PRIMARY KEY(usuario_id, mensagem_id),
  INDEX fk_usuario_assunto(usuario_id),
  INDEX fk_mensagem_usuario(mensagem_id),
  FOREIGN KEY(usuario_id) REFERENCES seg_usuario(id),
  FOREIGN KEY(mensagem_id) REFERENCES flc_mensagem(id)
) ENGINE=InnoDB;


-- Estrutura da tabela 'Grupo'
CREATE TABLE IF NOT EXISTS flc_grupo (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome_grupo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB;


-- Estrutura da tabela 'usuario_grupo'
CREATE TABLE IF NOT EXISTS flc_usuario_grupo (
  usuario_id BIGINT(20) NOT NULL,
  grupo_id BIGINT(20) NOT NULL,
  PRIMARY KEY (usuario_id, grupo_id),
  INDEX fk_usuario_grupo(usuario_id),
  INDEX fk_grupo_usuario(grupo_id),
  FOREIGN KEY(usuario_id) REFERENCES seg_usuario(id),
  FOREIGN KEY(grupo_id) REFERENCES flc_grupo(id)
) ENGINE=InnoDB;
