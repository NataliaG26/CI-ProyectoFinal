package co.edu.icesi.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.groups.CreateAutotransition;
import co.edu.icesi.back.groups.UpdateAutotransition;
import co.edu.icesi.front.model.classes.Autotransition;

public interface AutotransitionController {
	
	public String indexAutotransition(Model model);
	
	public String addAutotransition(Model model);
	
	public String saveAutotransition(@Validated(CreateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);

	public String deleteAutotransition(@PathVariable("id") long id, Model model);
	
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(UpdateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition, 
			BindingResult bindingresult, Model model);
	
	public String searchByName(Model model, @RequestParam(value = "autoName", required = false) String autoName);
	
	public String searchByIsActive(Model model, @RequestParam(value = "isactive", required = false) String isactive);
	
	public String searchByLogicOp(Model model, @RequestParam(value = "logicOp", required = false) String logicOp);
}
