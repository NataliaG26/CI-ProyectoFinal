package co.edu.icesi.front.controller.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.exception.LogicalException;

import co.edu.icesi.front.model.classes.Institution;
import co.edu.icesi.front.controller.interfaces.InstitutionController;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/institution")
@Log4j2
public class InstitutionControllerImpl implements InstitutionController{

	private InstitutionDelegate institutionDelegate;
	
	@Autowired
	public InstitutionControllerImpl(InstitutionDelegate institutionDelegate) {
		this.institutionDelegate = institutionDelegate;
	}

	@GetMapping("/")
	@Override
	public String indexInstitution(Model model) {
		model.addAttribute("institutions", institutionDelegate.findAll());
		return "institution/index";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Institution institution = institutionDelegate.getInstitutionById(id);
		model.addAttribute("institution", institution);
		return "institution/update";
	}
	
	@PostMapping("/update/{id}")
	public String updateInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated Institution institution, BindingResult bindingresult, Model model) throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {	
				//model.addAttribute("institution", new Institution());
			 	return "institution/update/{id}";
			}else {
				institutionDelegate.updateInstitution(institution);
				return "redirect:/institution/showInstitution/{id}";
			}
		}
		return "redirect:/institution/";
			
	}
	
	@GetMapping("/del/{id}")
	public String showDeleteForm(@PathVariable("id") long id, Model model) {
		Institution institution = institutionDelegate.getInstitutionById(id);
		institutionDelegate.delete(institution.getInstId());
		model.addAttribute("institutions", institutionDelegate.findAll());
		return "institution/index";
	}
	
	@GetMapping("/add")
	public String showAddInstitution(Model model) {
		model.addAttribute("institution", new Institution());
		return "institution/add";
	}
	
	@PostMapping("/add")
	public String saveInstitution(@Validated Institution institution, BindingResult bindingresult, Model model,
			@RequestParam(value = "action", required = true) String action) throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {	
			 	return "institution/add";
			}else {
				institutionDelegate.createInstitution(institution);
			}
		}
		return "redirect:/institution/";
			
	}
	
	@GetMapping("/showInstitution/{id}")
	public String showInstitution(@PathVariable("id") long id, Model model) {
		Institution institution = institutionDelegate.getInstitutionById(id);
		model.addAttribute("institution", institution);
		return "institution/showInstitution";
	}

	
	
}
