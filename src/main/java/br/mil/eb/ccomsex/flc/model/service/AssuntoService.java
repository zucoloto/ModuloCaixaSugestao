package br.mil.eb.ccomsex.flc.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.repository.AssuntoRepository;
import br.mil.eb.ccomsex.flc.util.jpa.Transactional;

public class AssuntoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AssuntoRepository assuntoRepository;

	@Transactional
	public Assunto salvar(Assunto assunto) {
		return assuntoRepository.salvar(assunto);
	}

	@Transactional
	public void excluir(Assunto assunto) {
		assuntoRepository.excluir(assunto);
	}

	public List<Assunto> listarTodos() {
		return assuntoRepository.listarTodos();
	}

	public Assunto buscarPorId(Long id) {
		return assuntoRepository.buscarPorId(id);
	}
}
