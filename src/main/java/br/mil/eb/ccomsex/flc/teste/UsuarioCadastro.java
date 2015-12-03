package br.mil.eb.ccomsex.flc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.StatusUsuario;
import br.mil.eb.ccomsex.flc.model.entity.Usuario;

public class UsuarioCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario.setIdentidade("0");
		usuario.setNomeUsuario("Usuario");
		usuario.setEmail("usuario@ccomsex.eb.mil.br");
		usuario.setStatusUsuario(StatusUsuario.ATIVO);
		usuario.setSenha("123");

		manager.persist(usuario);

		trx.commit();
		manager.close();
	}
}
