package br.edu.ifgoiano.farmacia.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

	private static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("farmacia-basica");

	@Produces
	@RequestScoped
	public static EntityManager criaEntityManager() {

		return EMF.createEntityManager();
	}

	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
