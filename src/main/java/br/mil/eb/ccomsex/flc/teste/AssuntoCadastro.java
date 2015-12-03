package br.mil.eb.ccomsex.flc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;

public class AssuntoCadastro {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Assunto a = new Assunto();
		a.setAssunto("Sugestão1");
		
		manager.persist(a);
		trx.commit();
		manager.close();
	}
}
