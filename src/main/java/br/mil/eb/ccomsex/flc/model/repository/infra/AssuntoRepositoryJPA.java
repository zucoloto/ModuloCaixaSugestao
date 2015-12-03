package br.mil.eb.ccomsex.flc.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.repository.AssuntoRepository;

public class AssuntoRepositoryJPA implements AssuntoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Override
	public Assunto salvar(Assunto assunto) {
		return em.merge(assunto);
	}

	@Override
	public void excluir(Assunto assunto) {
		em.remove(assunto);
	}

	@Override
	public List<Assunto> listarTodos() {
		return em.createQuery("from Assunto", Assunto.class).getResultList();
	}

	@Override
	public Assunto buscarPorId(Long id) {
		return em.find(Assunto.class, id);
	}

}
