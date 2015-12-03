package br.mil.eb.ccomsex.flc.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.repository.MensagemRepository;

@FacesConverter(forClass = Mensagem.class)
public class MensagemConverter implements Converter {

	@Inject
	private MensagemRepository mensagemRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Mensagem retorno = null;
		if (value != null && !value.equals("")) {
			retorno = mensagemRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Mensagem retorno = (Mensagem) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
