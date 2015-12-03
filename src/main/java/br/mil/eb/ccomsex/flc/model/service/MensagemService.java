package br.mil.eb.ccomsex.flc.model.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.repository.MensagemRepository;
import br.mil.eb.ccomsex.flc.util.jpa.Transactional;

public class MensagemService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MensagemRepository mensagemRepository;

	@Transactional
	public Mensagem salvar(Mensagem mensagem) {
		mensagem.setDataHoraRegistro(new Date());
		return mensagemRepository.salvar(mensagem);
	}

	public List<Mensagem> listarTodos() {
		return mensagemRepository.listarTodos();
	}

	public Mensagem buscarPorId(Long id) {
		return mensagemRepository.buscarPorId(id);
	}

	public Boolean mensagemLida() {
		return true;
	}
}
