package br.mil.eb.ccomsex.flc.model.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.ccomsex.flc.model.entity.Usuario;
import br.mil.eb.ccomsex.flc.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.flc.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.buscarPorId(id);
	}

	public Usuario buscarPorIdentidade(String identidade) {
		return usuarioRepository.buscarPorIdentidade(identidade);
	}

}
