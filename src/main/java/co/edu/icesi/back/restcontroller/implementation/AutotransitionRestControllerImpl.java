package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.restcontroller.interfaces.AutotransitionRestController;
import co.edu.icesi.back.service.interfaces.AutotransitionService;

public class AutotransitionRestControllerImpl implements AutotransitionRestController{

	private AutotransitionService autotransitionService;
	
	public AutotransitionRestControllerImpl(AutotransitionService autotransitionService) {
		this.autotransitionService = autotransitionService;
	}
	
	@Override
	public String indexAutotransition(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addAutotransition(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAutotransition(Autotransition autotransition, BindingResult bindingresult, String action,
			Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAutotransition(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showUpdateForm(long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAutotransition(long id, String action, Autotransition autotransition,
			BindingResult bindingresult, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
