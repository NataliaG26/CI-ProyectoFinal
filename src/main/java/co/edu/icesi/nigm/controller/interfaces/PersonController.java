package co.edu.icesi.nigm.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Person;

public interface PersonController {
	
public String indexPerson(Model model);
	
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	
	public String updateInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated Person person, BindingResult bindingresult, Model model) throws LogicalException;
	
	public String showDeleteForm(@PathVariable("id") long id, Model model);
	
	public String showAddPerson(Model model);
	
	public String savePerson(@Validated Person person, BindingResult bindingresult, Model model,
			@RequestParam(value = "action", required = true) String action) throws LogicalException;
	
	public String showPerson(@PathVariable("id") long id, Model model);
	
}
