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
import co.edu.icesi.front.model.classes.Autotransition;
import co.edu.icesi.front.model.classes.Personautotran;
import co.edu.icesi.front.bd.interfaces.AutotransitionDelegate;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.bd.interfaces.PersonautotranDelegate;
import co.edu.icesi.front.controller.interfaces.PersonautotranController;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/personautotran")
@Log4j2
public class PersonautotranControllerImpl implements PersonautotranController {
	
	private PersonautotranDelegate personautotranDelegate;
	private PersonDelegate personDelegate;
	private AutotransitionDelegate autotransitionDelegate;
	
	@Autowired
	public PersonautotranControllerImpl(PersonautotranDelegate personautotranDelegate, PersonDelegate personDelegate,
			AutotransitionDelegate autotransitionDelegate) {
		this.personautotranDelegate = personautotranDelegate;
		this.personDelegate = personDelegate;
		this.autotransitionDelegate = autotransitionDelegate;
	}
	
	@Override
	public String indexPersonautotran(Model model) {
		model.addAttribute("personautotran", personautotranDelegate.findAll());
		return null;
	}
	
	@GetMapping("/")
	public String indexAutotransition(Model model) {
		model.addAttribute("personautotrans", personautotranDelegate.findAll());
		return "personautotran/index";
	}
	
	@GetMapping("/add")
	public String addPersonautotran(Model model) {
		model.addAttribute("personautotran", new Personautotran());
		model.addAttribute("persons", personDelegate.findAll());
		model.addAttribute("autotransitions", autotransitionDelegate.findAll());
		return "personautotran/add";
	}
	
	@PostMapping("/add")
	public String savePersonautotran(@ModelAttribute("personautotran") Personautotran personautotran,
			BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("persons", personDelegate.findAll());
				model.addAttribute("autotransitions", autotransitionDelegate.findAll());
			 	return "personautotran/add";
			}		
			else {
				try {
					long person = personautotran.getPersonId(); 	
					long autotran = personautotran.getAutotranId();
					personautotranDelegate.createPersonautotran(personautotran, person, autotran);
				}catch(LogicalException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/personautotran/";
	}
	
	@GetMapping("/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		personautotranDelegate.delete(id);
		model.addAttribute("autotransitions", personautotranDelegate.findAll());
		return "autotransition/index";
	}

	
	@GetMapping("/update/{id}")
	public String showUpdatePersonautotran(@PathVariable("id") long id,Model model) {
		Personautotran personautotran;
		try {
			personautotran = personautotranDelegate.getPersonautotranById(id);
			if (personautotran == null) 
				throw new IllegalArgumentException("Invalid user Id:" + id);
			model.addAttribute("personautotran", personautotran);
			model.addAttribute("persons", personDelegate.findAll());
			model.addAttribute("autotransitions", autotransitionDelegate.findAll());
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
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("persons", personDelegate.findAll());
				model.addAttribute("autotransitions", autotransitionDelegate.findAll());
			 	return "personautotran/update";
			}		
			else {
				try {
					personautotranDelegate.updatePersonautotran(personautotran);
				}catch(LogicalException e) {
					e.printStackTrace();
				}
			}			
		
		}
		return "redirect:/personautotran/";
	}
}
