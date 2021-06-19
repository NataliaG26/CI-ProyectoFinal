package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.back.model.Documenttype;
import co.edu.icesi.back.restcontroller.interfaces.DocumenttypeRestController;
import co.edu.icesi.back.service.interfaces.DocumenttypeService;


@RestController
@RequestMapping("/api-rest/documenttype")
public class DocumenttypeRestControllerImpl implements DocumenttypeRestController{

	@Autowired
	 private DocumenttypeService documenttypeService;
	
	@Override
	@GetMapping("/")
	public Iterable<Documenttype> showAllDocumenttype() {
		return documenttypeService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Documenttype showDocumenttype(@PathVariable("id") long id) {
		return documenttypeService.getDocumenttypeById(id);
	}

	@Override
	@PostMapping("/add")
	public Documenttype saveDocumenttype(@RequestBody Documenttype documenttype) {
		return documenttypeService.createDocumenttype(documenttype);
	}

	@Override
	@PutMapping("/update")
	public void updateDocumenttype(@RequestBody Documenttype documenttype) {
		System.out.println(documenttype.getDoctypeId());
		documenttypeService.updateDocumenttype(documenttype);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteDocumenttype(@PathVariable("id") long id) {
		documenttypeService.delete(id);
	}

}
