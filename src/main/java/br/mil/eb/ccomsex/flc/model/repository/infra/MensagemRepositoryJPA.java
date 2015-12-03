package br.mil.eb.ccomsex.flc.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.repository.MensagemRepository;

public class MensagemRepositoryJPA implements MensagemRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Override
	public Mensagem salvar(Mensagem mensagem) {
		return em.merge(mensagem);
	}

	@Override
	public List<Mensagem> listarTodos() {
		return em.createQuery("from Mensagem order by dataHoraRegistro desc", Mensagem.class).getResultList();
	}

	@Override
	public Mensagem buscarPorId(Long id) {
		return em.find(Mensagem.class, id);
	}

}
