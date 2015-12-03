package br.mil.eb.ccomsex.flc.model.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mil.eb.ccomsex.flc.model.entity.Grupo;
import br.mil.eb.ccomsex.flc.model.repository.GrupoRepository;

public class GrupoRepositoryJPA implements GrupoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Override
	public Grupo salvar(Grupo grupo) {
		return em.merge(grupo);
	}

	@Override
	public void excluir(Grupo grupo) {
		em.remove(grupo);
	}

	@Override
	public List<Grupo> listarTodos() {
		return em.createQuery("from Grupo order by nomeGrupo", Grupo.class).getResultList();
	}

	@Override
	public Grupo buscarPorId(Long id) {
		return em.find(Grupo.class, id);
	}
}
