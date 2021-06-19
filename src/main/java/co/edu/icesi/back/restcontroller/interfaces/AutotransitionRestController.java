package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.groups.CreateAutotransition;
import co.edu.icesi.back.groups.UpdateAutotransition;
import co.edu.icesi.back.model.Autotransition;

public interface AutotransitionRestController {
	
	public Iterable<Autotransition> showAllAutotransition();
	
	public Autotransition showAutotransition(@PathVariable("id") long id)  throws LogicalException;
	
	public Autotransition saveAutotransition(@RequestBody Autotransition autotransition) throws LogicalException;
	
	public void updateAutotransition(@Validated(UpdateAutotransition.class) Autotransition autotransition )throws LogicalException;
	
	public void deleteAutotransition(@PathVariable("id") long id) throws LogicalException;
	
}
