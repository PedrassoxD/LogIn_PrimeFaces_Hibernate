/**
 * 
 */
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Persona;

/**
 * @author usuario
 *
 */
public class PersonaDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public PersonaDAO() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();
	}

	public void salvar(Persona persona) {
		em.getTransaction().begin();
		em.merge(persona);
		em.getTransaction().commit();
		emf.close();
	}

	public void excluir(Persona persona) {
		em.getTransaction().begin();
		em.remove(em.contains(persona) ? persona : em.merge(persona));
		em.getTransaction().commit();
		emf.close();
	}

	public void modificar(Persona persona) {
		em.getTransaction().begin();
		em.merge(em.contains(persona) ? persona : em.merge(persona));
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select persona from Persona persona");
		List<Persona> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return pessoas;
	}

}
