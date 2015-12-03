package br.mil.eb.ccomsex.flc.controller.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.util.jsf.FacesUtil;
import br.mil.eb.ccomsex.flc.util.report.ExecutorRelatorio;

@Named
@RequestScoped
public class RelatorioMensagemUnicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long mensagemId;

	@Inject
	private Mensagem mensagem;

	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletResponse response;

	@Inject
	private EntityManager manager;

	public void emitir() {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("mensagem_id", this.mensagem.getId());

		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/RelatorioMensagemUnica.jasper", this.response,
				parametros, "Relatório de Mensagens.pdf");

		Session session = manager.unwrap(Session.class);
		session.doWork(executor);

		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
		}
	}

	public Long getMensagemId() {
		return mensagemId;
	}

	public void setMensagemId(Long mensagemId) {
		this.mensagemId = mensagemId;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

}
