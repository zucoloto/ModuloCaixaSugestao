package br.mil.eb.ccomsex.flc.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class SegurancaBean {

	UsuarioSistemaSecurity usuarioLogado = getUsuarioLogado();

	public String getIdentidadeUsuario() {
		String identidadeUsuario = null;

		if (usuarioLogado != null) {
			identidadeUsuario = usuarioLogado.getUsuario().getIdentidade();
		}

		return identidadeUsuario;
	}

	public String getNomeUsuario() {
		String nome = null;

		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNomeUsuario();
		}

		return nome;
	}

	private UsuarioSistemaSecurity getUsuarioLogado() {
		UsuarioSistemaSecurity usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistemaSecurity) auth.getPrincipal();
		}

		return usuario;
	}
}
