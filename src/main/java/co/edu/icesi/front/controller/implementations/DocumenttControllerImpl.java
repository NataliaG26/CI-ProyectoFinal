package co.edu.icesi.front.controller.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.bd.interfaces.DocumenttDelegate;
import co.edu.icesi.front.bd.interfaces.DocumenttypeDelegate;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.controller.interfaces.DocumenttController;
import co.edu.icesi.front.model.classes.Documentt;
import co.edu.icesi.front.model.classes.Documenttype;

@Controller
@RequestMapping("/documentt")
public class DocumenttControllerImpl implements DocumenttController{
	
	private DocumenttDelegate documenttDelegate;
	
	private DocumenttypeDelegate documenttypeDelegate;
	
	private PersonDelegate personDelegate;
	
	@Autowired
	public DocumenttControllerImpl(DocumenttDelegate documenttDelegate, DocumenttypeDelegate documenttypeDelegate, PersonDelegate personDelegate) {
		this.documenttDelegate = documenttDelegate;
		this.documenttypeDelegate = documenttypeDelegate;
		this.personDelegate = personDelegate;
	}
	
	@GetMapping("/")
	@Override
	public String indexDocumentt(Model model) {
		model.addAttribute("documentts", documenttDelegate.findAll());
		return "documentt/index";
	}
	
	@GetMapping("/update/{id}")
	@Override
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Documentt documentt = documenttDelegate.getDocumenttById(id);
		model.addAttribute("documentt", documentt);
		model.addAttribute("documenttypes", documenttypeDelegate.findAll());
		model.addAttribute("persons", personDelegate.findAll());
		return "documentt/update";
	}
	
	@PostMapping("/update/{id}")
	@Override
	public String update(@PathVariable("id") long id, String action, Documentt documentt, BindingResult bindingresult, Model model)
			throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("documenttypes", documenttypeDelegate.findAll());
				model.addAttribute("persons", personDelegate.findAll());
			 	return "documentt/update/{id}";
			}else {
				documenttDelegate.updateDocumentt(documentt);
				return "redirect:/documentt/showDocumentt/{id}";
			}
		}
		return "redirect:/documentt/";
			
	}

	@RequestMapping(value = "/del/{id}", method = {RequestMethod.DELETE})
	@Override
	public String deleteForm(@PathVariable("id") long id, Model model) {
		documenttDelegate.delete(id);
		return "redirect:/documentt/";
	}
	
	@GetMapping("/add")
	@Override
	public String showAdd(Model model) {
		model.addAttribute("documentt", new Documentt());
		model.addAttribute("documenttypes", documenttypeDelegate.findAll());
		model.addAttribute("persons", personDelegate.findAll());
		return "documentt/add";
	}
	
	@PostMapping("/add")
	@Override
	public String save(Documentt documentt, BindingResult bindingresult, Model model, String action)
			throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("documenttypes", documenttypeDelegate.findAll());
				model.addAttribute("persons", personDelegate.findAll());
			 	return "documentt/add";
			}else {
				documenttDelegate.createDocumentt(documentt);
			}
		}
		return "redirect:/documentt/";
	}
	
	@GetMapping("/showDocumentt/{id}")
	@Override
	public String show(@PathVariable("id") long id, Model model) {
		Documentt documentt = documenttDelegate.getDocumenttById(id);
		model.addAttribute("documentt", documentt);
		return "documentt/showDocumentt";
	}


}
