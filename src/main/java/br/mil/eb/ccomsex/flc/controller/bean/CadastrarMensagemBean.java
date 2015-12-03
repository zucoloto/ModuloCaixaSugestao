package br.mil.eb.ccomsex.flc.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.service.AssuntoService;
import br.mil.eb.ccomsex.flc.model.service.MensagemService;
import br.mil.eb.ccomsex.flc.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastrarMensagemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MensagemService mensagemService;

	@Inject
	private AssuntoService assuntoService;

	private Mensagem mensagem;

	private List<Assunto> assuntos;

	public CadastrarMensagemBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			carregarAssuntos();
		}
	}

	public void limpar() {
		mensagem = new Mensagem();
	}

	public void salvar() {
		this.mensagem = mensagemService.salvar(this.mensagem);
		limpar();
		FacesUtil.addInfoMessage("Mensagem enviada com sucesso!");
	}

	public void carregarAssuntos() {
		assuntos = assuntoService.listarTodos();
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

}
