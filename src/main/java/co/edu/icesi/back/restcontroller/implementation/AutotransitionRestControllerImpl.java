package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.restcontroller.interfaces.AutotransitionRestController;
import co.edu.icesi.back.service.interfaces.AutotransitionService;

@RestController
@RequestMapping("/api-rest/autotransition")
public class AutotransitionRestControllerImpl implements AutotransitionRestController{

	private AutotransitionService autotransitionService;
	
	public AutotransitionRestControllerImpl(AutotransitionService autotransitionService) {
		this.autotransitionService = autotransitionService;
	}

	@Override
	@GetMapping("/")
	public Iterable<Autotransition> showAllAutotransition() {
		return autotransitionService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Autotransition showAutotransition(@PathVariable("id") long id) throws LogicalException {
		return autotransitionService.getAutotransitionById(id);
	}

	@Override
	@PostMapping("/")
	public Autotransition saveAutotransition(@RequestBody Autotransition autotransition) throws LogicalException {
		return autotransitionService.createAutotransition(autotransition);
	}

	@Override
	@PutMapping("/")
	public void updateAutotransition(@RequestBody Autotransition autotransition) throws LogicalException {
		autotransitionService.updateAutotransition(autotransition);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteAutotransition(long id) throws LogicalException {
		try {
			autotransitionService.delete(id);
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
