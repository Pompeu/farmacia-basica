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
	private static final EntityManager EM = EMF.createEntityManager();

	@Produces
	@RequestScoped
	public static EntityManager criaEntityManager() {

		return EM;
	}

	public void close(@Disposes EntityManager EM) {
		if (EM.isOpen())
			EM.close();
	}
}
