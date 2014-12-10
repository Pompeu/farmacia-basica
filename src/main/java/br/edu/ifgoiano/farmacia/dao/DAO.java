package br.edu.ifgoiano.farmacia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import br.edu.ifgoiano.farmacia.util.JPAUtil;

/**
 *
 * @author pompeu
 * @param <T>
 */
public class DAO<T> {

	private final Class<T> clazz;

	protected EntityManager em;

	public DAO(Class<T> clazz) {
		this.clazz = clazz;
		em = JPAUtil.criaEntityManager();
	}

	@Deprecated
	public DAO() {
		this(null);
	}

	public void create(T obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(T obj) {
		em.getTransaction().begin();
		obj = em.find(clazz, RefletionObjeto.getIdObjeto(obj));
		em.remove(obj);
		em.getTransaction().commit();
		em.close();

	}

	public void update(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		em.close();
	}

	public List<T> retrivetAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(clazz);
		query.from(clazz);
		return em.createQuery(query).getResultList();
	}

	public T retrivetbyId(Integer id) {
		return em.find(clazz, id);
	}

	public List<T> retriveByName(String name) {

		String consulta = "select c from " + clazz.getName()
				+ " c where c.nome like :pNome";

		TypedQuery<T> query = em.createQuery(consulta, this.clazz);

		query.setParameter("pNome", "%" + name + "%");

		return query.getResultList();
	}

	public T retriveByCNPJOrCPF(String numero) {

		String consulta = "select c from " + clazz.getName() + " c where c."
				+ EcpfCnpj.CPFCNPJ.cpfOrCpnj(numero.length())
				+ " like :pCpfCnpj";

		TypedQuery<T> query = em.createQuery(consulta, this.clazz);

		query.setParameter("pCpfCnpj", "%" + numero + "%");

		return (T) query.getSingleResult();
	}

}

enum EcpfCnpj {

	CPFCNPJ {
		@Override
		public String cpfOrCpnj(int tam) {
			return tam < 14 ? "cpf" : "cnpj";

		}

	};

	public abstract String cpfOrCpnj(int tam);
}