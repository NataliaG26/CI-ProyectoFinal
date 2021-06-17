package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.restcontroller.interfaces.InstitutionRestController;

public class InstitutionRestControllerImpl implements InstitutionRestController {

	@Override
	public String indexInstitution(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showUpdateForm(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInstitution(long id, String action, Institution institution, BindingResult bindingresult,
			Model model) throws LogicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showDeleteForm(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showAddInstitution(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveInstitution(Institution institution, BindingResult bindingresult, Model model, String action)
			throws LogicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showInstitution(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
