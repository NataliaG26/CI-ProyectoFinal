package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.restcontroller.interfaces.PersonautotranRestController;
import co.edu.icesi.back.service.interfaces.PersonautotranService;
import co.edu.icesi.back.model.Personautotran;

@RestController
@RequestMapping("/api-rest/personautotran")
public class PersonautotranRestControllerImpl implements PersonautotranRestController {

	@Autowired
	private PersonautotranService personautotranService;
	
	@Override
	@GetMapping("/")
	public Iterable<Personautotran> showAll() {
		return personautotranService.findAll();
	}

	@Override
	@GetMapping("showPersonautotran/{id}")
	public Personautotran showPersonautotran(@PathVariable("id") long id) throws LogicalException {
		return personautotranService.getPersonautotranById(id);
	}

	@Override
	@PostMapping("/add")
	public Personautotran savePersonautotran(Personautotran personautotran) throws LogicalException {
		return personautotranService.createPersonautotran(personautotran);
	}

	@Override
	@DeleteMapping("/del/{id}")
	public void deletePersonautotran(@PathVariable("id") long id) throws LogicalException {
		personautotranService.delete(id);
	}

	@Override
	@PutMapping("/update")
	public void updatePersonautotran(Personautotran personautotran) throws LogicalException {
		personautotranService.updatePersonautotran(personautotran);
	}

}
