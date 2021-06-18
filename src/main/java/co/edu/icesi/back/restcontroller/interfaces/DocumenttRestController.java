package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

import co.edu.icesi.back.model.Documentt;

public interface DocumenttRestController {
	
	public Iterable<Documentt> showAllDocumentt();
	
	public Documentt showDocumentt(@PathVariable("id") long id);
	
	public Documentt saveDocumentt(Documentt documentt);
	
	public void updateDocumentt(Documentt documentt);
	
	public void deleteDocumentt(@PathVariable("id") long id);

}
