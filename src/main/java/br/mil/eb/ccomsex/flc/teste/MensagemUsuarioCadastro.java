package br.mil.eb.ccomsex.flc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.Mensagem;
import br.mil.eb.ccomsex.flc.model.entity.Usuario;

public class MensagemUsuarioCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario = manager.find(Usuario.class, 1L);
		System.out.println(usuario.getNomeUsuario());
		
		Mensagem msg = new Mensagem();
		msg = manager.find(Mensagem.class, 1L);
		System.out.println(msg.getAssunto().getAssunto());

		//usuario.getMensagens().add(msg);

		manager.merge(usuario);

		trx.commit();
		manager.close();
	}

}
