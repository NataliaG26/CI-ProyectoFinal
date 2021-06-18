package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.edu.icesi.back.model.Documenttype;
import co.edu.icesi.back.restcontroller.interfaces.DocumenttypeRestController;
import co.edu.icesi.back.service.interfaces.DocumenttypeService;

public class DocumenttypeRestControllerImpl implements DocumenttypeRestController{

	@Autowired
	 private DocumenttypeService documenttypeService;
	
	@Override
	@GetMapping("/")
	public Iterable<Documenttype> showAllDocumenttype() {
		return documenttypeService.findAll();
	}

	@Override
	@GetMapping("showDocumenttype/{id}")
	public Documenttype showDocumenttype(@PathVariable("id") long id) {
		return documenttypeService.getDocumenttypeById(id);
	}

	@Override
	@PostMapping("/add")
	public Documenttype saveDocumenttype(Documenttype documenttype) {
		return documenttypeService.createDocumenttype(documenttype);
	}

	@Override
	@PutMapping("/update")
	public void updateDocumenttype(Documenttype documenttype) {
		documenttypeService.updateDocumenttype(documenttype);
	}

	@Override
	@DeleteMapping("/del/{id}")
	public void deleteDocumenttype(@PathVariable("id") long id) {
		documenttypeService.delete(id);
	}

}