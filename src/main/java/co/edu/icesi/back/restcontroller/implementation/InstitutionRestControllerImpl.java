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
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.restcontroller.interfaces.InstitutionRestController;
import co.edu.icesi.back.service.interfaces.InstitutionService;

@RestController
@RequestMapping("/api-rest/institution")
public class InstitutionRestControllerImpl implements InstitutionRestController {
	
	@Autowired
	private InstitutionService institutionService;
	
	@Override
	@GetMapping("/")
	public Iterable<Institution> showAllInstitutions() {
		return institutionService.findAll();
	}

	@Override
	@GetMapping("/show/{id}")
	public Institution showInstitution(@PathVariable("id") long id) {
		try {
			return institutionService.getInstitutionById(id);
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@PutMapping("/update/{id}")
	public void updateInstitution(Institution institution) throws LogicalException {
		institutionService.updateInstitution(institution);
	}

	@Override
	@PostMapping("/add")
	public Institution saveInstitution(Institution institution) throws LogicalException {
		return institutionService.createInstitution(institution);
	}


	@Override
	@DeleteMapping("/del/{id}")
	public void deleteInstitution(@PathVariable("id") long id) {
		try {
			institutionService.delete(id);
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
