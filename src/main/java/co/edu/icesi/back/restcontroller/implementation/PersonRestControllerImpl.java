package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.restcontroller.interfaces.PersonRestController;

public class PersonRestControllerImpl implements PersonRestController{

	@Override
	public String showUpdateForm(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInstitution(long id, String action, Person person, BindingResult bindingresult, Model model)
			throws LogicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showDeleteForm(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showAddPerson(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String savePerson(Person person, BindingResult bindingresult, Model model, String action)
			throws LogicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showPerson(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
