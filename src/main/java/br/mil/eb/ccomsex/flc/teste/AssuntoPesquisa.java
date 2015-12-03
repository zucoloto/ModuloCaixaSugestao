package br.mil.eb.ccomsex.flc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.Assunto;

public class AssuntoPesquisa {

	public static void main(String[] args) {

		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		List<Assunto> assuntos = manager.createQuery("from Assunto", Assunto.class).getResultList();
		
		for (Assunto a : assuntos) {
			System.out.println(a.getAssunto());
		}
		
		trx.commit();
		manager.close();
	}
}
