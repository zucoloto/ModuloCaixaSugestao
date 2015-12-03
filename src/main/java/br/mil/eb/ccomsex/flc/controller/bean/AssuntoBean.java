package br.mil.eb.ccomsex.flc.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.service.AssuntoService;
import br.mil.eb.ccomsex.flc.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AssuntoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AssuntoService assuntoService;

	private Assunto assunto;
	private List<Assunto> assuntos;

	public AssuntoBean() {
		limpar();
	}

	public void init() {
		pesquisar();
	}

	public void limpar() {
		this.assunto = new Assunto();
	}

	public void salvar() {
		this.assunto = assuntoService.salvar(this.assunto);
		limpar();
		FacesUtil.addInfoMessage("Registro salvo com sucesso!");
	}

	public void pesquisar() {
		assuntos = assuntoService.listarTodos();
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

}
