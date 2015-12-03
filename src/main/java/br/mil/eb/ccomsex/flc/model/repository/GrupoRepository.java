package br.mil.eb.ccomsex.flc.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.flc.model.entity.Grupo;

public interface GrupoRepository {

	public Grupo salvar(Grupo grupo);

	public void excluir(Grupo grupo);

	public List<Grupo> listarTodos();

	public Grupo buscarPorId(Long id);

}
