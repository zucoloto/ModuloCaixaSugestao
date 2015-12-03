package br.mil.eb.ccomsex.flc.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.service.MensagemService;

@Named
@ViewScoped
public class PesquisarMensagemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MensagemService mensagemService;

	private Mensagem mensagem;

	private List<Mensagem> mensagens;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		mensagens = mensagemService.listarTodos();
	}

	public Mensagem getMensagem() {
		if (mensagem == null) {
			mensagem = new Mensagem();
		}
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

}
