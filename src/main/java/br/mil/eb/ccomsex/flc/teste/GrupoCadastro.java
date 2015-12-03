package br.mil.eb.ccomsex.flc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.flc.model.entity.Grupo;

public class GrupoCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Grupo grupo = new Grupo();
		grupo.setNomeGrupo("USUARIO");
		grupo.setDescricao("Acesso as mensagens");
		
		manager.persist(grupo);

		trx.commit();
		manager.close();
	}

}
