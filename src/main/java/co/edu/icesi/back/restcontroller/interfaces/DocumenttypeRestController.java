package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

import co.edu.icesi.back.model.Documenttype;

public interface DocumenttypeRestController {
	
	public Iterable<Documenttype> showAllDocumenttype();
	
	public Documenttype showDocumenttype(@PathVariable("id") long id);
	
	public Documenttype saveDocumenttype(Documenttype documenttype);
	
	public void updateDocumenttype(Documenttype documenttype);
	
	public void deleteDocumenttype(@PathVariable("id") long id);
	
}
