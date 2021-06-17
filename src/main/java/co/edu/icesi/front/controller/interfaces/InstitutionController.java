package co.edu.icesi.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.exception.LogicalException;

import co.edu.icesi.front.model.classes.Institution;

public interface InstitutionController {
	
	public String indexInstitution(Model model);
	
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	
	public String updateInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated Institution institution, BindingResult bindingresult, Model model) throws LogicalException;
	
	public String showDeleteForm(@PathVariable("id") long id, Model model);
	
	public String showAddInstitution(Model model);
	
	public String saveInstitution(@Validated Institution institution, BindingResult bindingresult, Model model,
			@RequestParam(value = "action", required = true) String action) throws LogicalException;
	
	public String showInstitution(@PathVariable("id") long id, Model model);
	
}
