package co.edu.icesi.front.controller.implementations;

import java.util.ArrayList;

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
import co.edu.icesi.front.model.classes.Person;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.controller.interfaces.PersonController;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/person")
@Log4j2
public class PersonControllerImpl implements PersonController {
	
	private PersonDelegate personDelegate;
	private InstitutionDelegate institutionDelegate;
	private ArrayList<String> personIsactiveL;
	
	@Autowired
	public PersonControllerImpl(PersonDelegate personDelegate, InstitutionDelegate institutionDelegate) {
		this.personDelegate = personDelegate;
		this.institutionDelegate = institutionDelegate;
		
		personIsactiveL = new ArrayList<String>();
		personIsactiveL.add("Y");
		personIsactiveL.add("N");
	}
	
	@GetMapping("/")
	@Override
	public String indexPerson(Model model) {
		model.addAttribute("persons", personDelegate.findAll());
		return "person/index";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		try {
			Person person = personDelegate.getPersonById(id);
			model.addAttribute("person", person);
			model.addAttribute("personIsactiveL", personIsactiveL);
			model.addAttribute("institutions", institutionDelegate.findAll());
		}catch(LogicalException e) {
			e.printStackTrace();
		}
		return "person/update";
	}
	
	@PostMapping("/update/{id}")
	public String updateInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated Person person, BindingResult bindingresult, Model model) throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				//model.addAttribute("person", person);
				model.addAttribute("personIsactiveL", personIsactiveL);
				model.addAttribute("institutions", institutionDelegate.findAll());
			 	return "person/update";
			}else {
			try {
				long instid = person.getInstid();
				personDelegate.updatePerson(person, instid);
				return "redirect:/person/showPerson/{id}";
			}catch(LogicalException e) {
				//model.addAttribute("institution", new Institution());
				e.printStackTrace();
				return "redirect:/person/showPerson/{id}";
			}
			}
		}
		return "redirect:/person/";
			
	}
	
	@GetMapping("/del/{id}")
	public String showDeleteForm(@PathVariable("id") long id, Model model) {
		personDelegate.delete(id);
		model.addAttribute("person", personDelegate.findAll());
		return "redirect:/person/";
	}
	
	@GetMapping("/add")
	public String showAddPerson(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("personIsactiveL", personIsactiveL);
		model.addAttribute("institutions", institutionDelegate.findAll());
		return "person/add";
	}
	
	@PostMapping("/add")
	public String savePerson(@Validated Person person, BindingResult bindingresult, Model model,
			@RequestParam(value = "action", required = true) String action) throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {	
				model.addAttribute("personIsactiveL", personIsactiveL);
				model.addAttribute("institutions", institutionDelegate.findAll());
				System.out.println("Save Person controller error");
			 	return "person/add";
			}else {
				try {
					long instid = person.getInstid();
					System.out.println(instid);
					personDelegate.createPerson(person, instid);
				}catch(LogicalException e) {
					e.printStackTrace();
					return "redirect:/person/";
				}
			}
		}
		return "redirect:/person/";
			
	}
	
	@GetMapping("/showPerson/{id}")
	public String showPerson(@PathVariable("id") long id, Model model) {
		try {
			Person person = personDelegate.getPersonById(id);
			model.addAttribute("person", person);
		}catch(LogicalException e) {
			e.printStackTrace();
		}
		return "person/showPerson";
	}


}
