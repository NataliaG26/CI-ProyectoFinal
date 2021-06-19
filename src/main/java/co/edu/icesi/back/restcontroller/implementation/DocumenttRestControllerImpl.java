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

import co.edu.icesi.back.model.Documentt;
import co.edu.icesi.back.restcontroller.interfaces.DocumenttRestController;
import co.edu.icesi.back.service.interfaces.DocumenttService;

@RestController
@RequestMapping("/api-rest/documentt")
public class DocumenttRestControllerImpl implements DocumenttRestController{

	 @Autowired
	 private DocumenttService documenttService;
	
	@Override
	@GetMapping("/")
	public Iterable<Documentt> showAllDocumentt() {
		return documenttService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Documentt showDocumentt(@PathVariable("id") long id) {
		return documenttService.getDocumenttById(id);
	}

	@Override
	@PostMapping("/")
	public Documentt saveDocumentt(@RequestBody Documentt documentt) {
		return documenttService.createDocumentt(documentt);
	}

	@Override
	@PutMapping("/")
	public void updateDocumentt(@RequestBody Documentt documentt) {
		documenttService.updateDocumentt(documentt);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteDocumentt(@PathVariable("id") long id) {
		documenttService.delete(id);
	}

}
