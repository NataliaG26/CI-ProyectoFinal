package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.model.Institutions;
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
	@GetMapping("/{id}")
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
	@RequestMapping(value = "/update", method = {RequestMethod.PUT})
	public void updateInstitution(@RequestBody Institution institution) throws LogicalException {
		institutionService.updateInstitution(institution);
	}

	@Override
	@PostMapping("/add")
	public Institution saveInstitution(@RequestBody Institution institution) throws LogicalException {
		return institutionService.createInstitution(institution);
	}


	@Override
	@RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
	public void deleteInstitution(@PathVariable("id") long id) {
		System.out.println("Delete Rest controller 1");
		try {
			institutionService.delete(id);
			System.out.println("Delete Rest controller");
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
