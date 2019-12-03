/**
 * 
 */
package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.PersonaDAO;
import model.Persona;

/**
 * @author usuario
 *
 */
@ManagedBean
public class PersonaMB {

	private Persona persona;
	private PersonaDAO personaDAO;
	private List<Persona> lista;

	public PersonaMB() {
		personaDAO = new PersonaDAO();
		persona = new Persona();
		lista = personaDAO.listarTodos();
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getList() {
		return this.lista;
	}

	public void salvar() {
		personaDAO.salvar(persona);
		addMessage("Persona add Success");
		lista = personaDAO.listarTodos();
	}
	
	public void excluir() {
		personaDAO.excluir(persona);
		addMessage("Persona excluida");
		lista = personaDAO.listarTodos();
	}
	
	public void modificar() {
		personaDAO.modificar(persona);
		addMessage("Persona Modified");
		lista = personaDAO.listarTodos();
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
