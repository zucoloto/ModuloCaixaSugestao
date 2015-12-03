package br.mil.eb.ccomsex.flc.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;

public interface AssuntoRepository {

	public Assunto salvar(Assunto assunto);

	public void excluir(Assunto assunto);

	public List<Assunto> listarTodos();

	public Assunto buscarPorId(Long id);

}
