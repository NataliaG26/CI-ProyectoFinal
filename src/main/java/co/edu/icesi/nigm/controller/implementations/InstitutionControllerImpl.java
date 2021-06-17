package co.edu.icesi.nigm.controller.implementations;



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

import co.edu.icesi.nigm.controller.interfaces.InstitutionController;
import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.groups.Add1;
import co.edu.icesi.nigm.model.Institution;
import co.edu.icesi.nigm.service.interfaces.InstitutionService;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/institution")
@Log4j2
public class InstitutionControllerImpl implements InstitutionController{

	private InstitutionService institutionService;
	
	@Autowired
	public InstitutionControllerImpl(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}

	@GetMapping("/")
	@Override
	public String indexInstitution(Model model) {
		
		model.addAttribute("institutions", institutionService.findAll());
		return "institution/index";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		try {
			Institution institution = institutionService.getInstitutionById(id);
			model.addAttribute("institution", institution);
		}catch(LogicalException e) {
			e.printStackTrace();
		}
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
				
		//institutionService.createInstitution(institution);
			try {
				institutionService.updateInstitution(institution);
				return "redirect:/institution/showInstitution/{id}";
			}catch(LogicalException e) {
				//model.addAttribute("institution", new Institution());
				e.printStackTrace();
				return "redirect:/institution/showInstitution/{id}";
			}
			}
		}
		return "redirect:/institution/";
			
	}
	
	@GetMapping("/del/{id}")
	public String showDeleteForm(@PathVariable("id") long id, Model model) {
		try {
			Institution institution = institutionService.getInstitutionById(id);
			institutionService.delete(institution);
			model.addAttribute("institutions", institutionService.findAll());
		}catch(LogicalException e) {
			e.printStackTrace();
		}
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
				//model.addAttribute("institution", new Institution());
			 	return "institution/add";
			}else {
				
		//institutionService.createInstitution(institution);
			try {
				institutionService.createInstitution(institution);
			}catch(LogicalException e) {
				//model.addAttribute("institution", new Institution());
				e.printStackTrace();
				return "redirect:/institution/";
			}
			}
		}
		return "redirect:/institution/";
			
	}
	
	@GetMapping("/showInstitution/{id}")
	public String showInstitution(@PathVariable("id") long id, Model model) {
		try {
			Institution institution = institutionService.getInstitutionById(id);
			model.addAttribute("institution", institution);
		}catch(LogicalException e) {
			e.printStackTrace();
		}
		return "institution/showInstitution";
	}
	
	
	
	
	
}
