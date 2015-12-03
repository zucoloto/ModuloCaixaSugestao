package br.mil.eb.ccomsex.flc.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.repository.AssuntoRepository;

@FacesConverter(forClass = Assunto.class)
public class AssuntoConverter implements Converter {

	@Inject
	private AssuntoRepository assuntoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Assunto retorno = null;
		if (value != null && !value.equals("")) {
			retorno = assuntoRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Assunto retorno = (Assunto) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
