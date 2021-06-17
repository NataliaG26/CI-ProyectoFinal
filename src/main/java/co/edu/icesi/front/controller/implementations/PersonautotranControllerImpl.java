package co.edu.icesi.front.controller.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.model.Personautotran;
import co.edu.icesi.back.service.interfaces.AutotransitionService;
import co.edu.icesi.back.service.interfaces.PersonService;
import co.edu.icesi.back.service.interfaces.PersonautotranService;
import co.edu.icesi.front.controller.interfaces.PersonautotranController;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/personautotran")
@Log4j2
public class PersonautotranControllerImpl implements PersonautotranController {
	
	private PersonautotranService personautotranService;
	private PersonService personService;
	private AutotransitionService autotransitionService;
	
	@Autowired
	public PersonautotranControllerImpl(PersonautotranService personautotranService, PersonService personService,
			AutotransitionService autotransitionService) {
		this.personautotranService = personautotranService;
		this.personService = personService;
		this.autotransitionService = autotransitionService;
	}
	
	@Override
	public String indexPersonautotran(Model model) {
		model.addAttribute("personautotran", personautotranService.findAll());
		return null;
	}
	
	@GetMapping("/")
	public String indexAutotransition(Model model) {
		model.addAttribute("autotransitions", personautotranService.findAll());
		return "personautotran/index";
	}
	
	@GetMapping("/add")
	public String addPersonautotran(Model model) {
		model.addAttribute("personautotran", new Personautotran());
		model.addAttribute("persons", personService.findAll());
		model.addAttribute("autotransitions", autotransitionService.findAll());
		return "personautotran/add";
	}
	
	@PostMapping("/add")
	public String savePersonautotran(@Validated @ModelAttribute("personautotran") Personautotran personautotran
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("persons", personService.findAll());
				model.addAttribute("autotransitions", autotransitionService.findAll());
			 	return "/add";
			}		
			else {
				try {
				personautotranService.createPersonautotran(personautotran);
				}catch(LogicalException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/personautotran/";
	}
	
	@GetMapping("/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		Personautotran personautotran;
		try {
			personautotran = personautotranService.getPersonautotranById(id);
			personautotranService.delete(personautotran);
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("autotransitions", personautotranService.findAll());
		return "autotransition/index";
	}

	
	@GetMapping("/update/{id}")
	public String showUpdatePersonautotran(@PathVariable("id") long id,Model model) {
		Personautotran personautotran;
		try {
			personautotran = personautotranService.getPersonautotranById(id);
			if (personautotran == null) 
				throw new IllegalArgumentException("Invalid user Id:" + id);
			model.addAttribute("personautotran", personautotran);
			model.addAttribute("persons", personService.findAll());
			model.addAttribute("autotransitions", autotransitionService.findAll());
			} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "personautotran/update";
	}
	
	@PostMapping("/update/{id}")
	public String updatePersonautotran(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated @ModelAttribute("personautotran") Personautotran personautotran,
			BindingResult bindingresult,   Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("persons", personService.findAll());
				model.addAttribute("autotransitions", autotransitionService.findAll());
			 	return "personautotran/update";
			}		
			else {
				try {
				personautotranService.updatePersonautotran(personautotran);
				}catch(LogicalException e) {
					e.printStackTrace();
				}
			}			
		
		}
		return "redirect:/personautotran/";
	}
}
