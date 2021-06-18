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
import co.edu.icesi.front.bd.interfaces.DocumenttypeDelegate;
import co.edu.icesi.front.controller.interfaces.DocumenttypeController;
import co.edu.icesi.front.model.classes.Documenttype;
import co.edu.icesi.front.model.classes.Institution;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/documenttype")
@Log4j2
public class DocumenttypeControllerImpl implements DocumenttypeController{
	
	private DocumenttypeDelegate documenttypeDelegate;
	
	@Autowired
	public DocumenttypeControllerImpl(DocumenttypeDelegate documenttypeDelegate) {
		this.documenttypeDelegate = documenttypeDelegate;
	}
	
	@GetMapping("/")
	@Override
	public String indexDocumenttype(Model model) {
		model.addAttribute("documenttypes", documenttypeDelegate.findAll());
		return "documenttype/index";
	}
	
	@GetMapping("/update/{id}")
	@Override
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Documenttype documenttype = documenttypeDelegate.getDocumenttypeById(id);
		model.addAttribute("documenttype", documenttype);
		return "documenttype/update";
	}
	
	@PostMapping("/update/{id}")
	@Override
	public String update(@PathVariable("id") long id, String action, Documenttype documenttype, BindingResult bindingresult, Model model)
			throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {	
			 	return "documenttype/update/{id}";
			}else {
				documenttypeDelegate.updateDocumenttype(documenttype);
				return "redirect:/documenttype/showDocumenttype/{id}";
			}
		}
		return "redirect:/documenttype/";
			
	}

	@RequestMapping(value = "/del/{id}", method = {RequestMethod.GET})
	@Override
	public String deleteForm(@PathVariable("id") long id, Model model) {
		documenttypeDelegate.delete(id);
		return "redirect:/documenttype/";
	}
	
	@GetMapping("/add")
	@Override
	public String showAdd(Model model) {
		model.addAttribute("documenttype", new Institution());
		return "documenttype/add";
	}
	
	@PostMapping("/add")
	@Override
	public String save(Documenttype documenttype, BindingResult bindingresult, Model model, String action)
			throws LogicalException {
		if (!action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {	
			 	return "documenttype/add";
			}else {
				documenttypeDelegate.createDocumenttype(documenttype);
			}
		}
		return "redirect:/documenttype/";
	}
	
	@GetMapping("/showDocumenttype/{id}")
	@Override
	public String show(@PathVariable("id") long id, Model model) {
		Documenttype documenttype = documenttypeDelegate.getDocumenttypeById(id);
		model.addAttribute("documenttype", documenttype);

		return "documenttype/showDocumenttype";
	}

}
