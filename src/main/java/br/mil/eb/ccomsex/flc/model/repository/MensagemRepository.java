package br.mil.eb.ccomsex.flc.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;

public interface MensagemRepository {

	public Mensagem salvar(Mensagem mensagem);

	public List<Mensagem> listarTodos();

	public Mensagem buscarPorId(Long id);

}
