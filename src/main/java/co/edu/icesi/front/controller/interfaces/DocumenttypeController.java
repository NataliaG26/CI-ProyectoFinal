package co.edu.icesi.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.model.classes.Documenttype;

public interface DocumenttypeController {
	
	public String indexDocumenttype(Model model);
	
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	
	public String update(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated Documenttype documenttype, BindingResult bindingresult, Model model) throws LogicalException;
	
	public String deleteForm(@PathVariable("id") long id, Model model);
	
	public String showAdd(Model model);
	
	public String save(@Validated Documenttype documenttype, BindingResult bindingresult, Model model,
			@RequestParam(value = "action", required = true) String action) throws LogicalException;
	
	public String show(@PathVariable("id") long id, Model model);

}
