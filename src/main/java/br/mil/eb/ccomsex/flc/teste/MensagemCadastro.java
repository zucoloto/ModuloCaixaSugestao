package br.mil.eb.ccomsex.flc.teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;
import br.mil.eb.ccomsex.flc.model.entity.Mensagem;

public class MensagemCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Assunto a = manager.find(Assunto.class, 1L);
		
		Mensagem m = new Mensagem();
		m.setDataHoraRegistro(new Date());
		m.setMensagem("Teste");
		m.setAssunto(a);
		
		manager.persist(m);
		trx.commit();
		manager.close();

	}

}
