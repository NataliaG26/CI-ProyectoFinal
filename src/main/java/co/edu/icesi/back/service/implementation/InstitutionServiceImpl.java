package co.edu.icesi.back.service.implementation;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.back.daos.interfaces.InstitutionDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.repository.InstitutionRepository;
import co.edu.icesi.back.service.interfaces.InstitutionService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InstitutionServiceImpl implements InstitutionService{
	
	private InstitutionRepository institutionRepository;
	private InstitutionDAO institutionDAO;
	
	@Autowired
	public InstitutionServiceImpl (InstitutionRepository institutionRep, InstitutionDAO institutionDAO ) {
		this.institutionRepository = institutionRep;
		this.institutionDAO = institutionDAO;
	}
	
	@Override
	@Transactional
	public Institution createInstitution(Institution institution) throws LogicalException{
		String enlace = "https";
		if(institution==null) {
			throw new LogicalException("la institución a ingresar no puede ser nula");
		}
		else if(institution.getInstName()==null) {
			throw new LogicalException("El nombre de la institución no puede ser null");
		}
		else if(institution.getInstName().equals("")) {
			throw new LogicalException("La institución debe tener un nombre");
		}
		else if (institution.getInstAcademicserverurl() == null|| 
				institution.getInstAcadextradataurl() == null ||
				institution.getInstAcadloginurl() == null ||
				institution.getInstAcadpersoninfodocurl() == null ||
				institution.getInstAcadpersoninfoidurl() == null ||
				institution.getInstAcadphysicalspacesurl() == null ||
				institution.getInstAcadprogrammedcoursesurl() == null ||
				institution.getInstLdapurl() == null ||
				!institution.getInstAcademicserverurl().startsWith(enlace)|| 
				!institution.getInstAcadextradataurl().startsWith(enlace) ||
				!institution.getInstAcadloginurl().startsWith(enlace) ||
				!institution.getInstAcadpersoninfodocurl().startsWith(enlace) ||
				!institution.getInstAcadpersoninfoidurl().startsWith(enlace) ||
				!institution.getInstAcadphysicalspacesurl().startsWith(enlace) ||
				!institution.getInstAcadprogrammedcoursesurl().startsWith(enlace) ||
				!institution.getInstLdapurl().startsWith(enlace)) {
			throw new LogicalException("Los enlaces de la institution deben empezar con 'https'");
		}
		else {
			//institutionRepository.save(institution);
			institutionDAO.Save(institution);
			return institution;
		}
	}

	@Override
	@Transactional
	public Institution updateInstitution(Institution institution) throws LogicalException{
		
		if(institution==null) {
			throw new LogicalException("la institución a ingresar no puede ser nula");
		}

		Institution existingInstitution = getInstitutionById(institution.getInstId());
		String enlace = "https";
		
		if(institution.getInstName().equals("") || institution.getInstName()==null ) {
			throw new LogicalException("La institución debe tener un nombre");
		}
		else if (institution.getInstAcademicserverurl() == null|| 
				institution.getInstAcadextradataurl() == null ||
				institution.getInstAcadloginurl() == null ||
				institution.getInstAcadpersoninfodocurl() == null ||
				institution.getInstAcadpersoninfoidurl() == null ||
				institution.getInstAcadphysicalspacesurl() == null ||
				institution.getInstAcadprogrammedcoursesurl() == null ||
				institution.getInstLdapurl() == null ||
				!institution.getInstAcademicserverurl().startsWith(enlace)|| 
				!institution.getInstAcadextradataurl().startsWith(enlace) ||
				!institution.getInstAcadloginurl().startsWith(enlace) ||
				!institution.getInstAcadpersoninfodocurl().startsWith(enlace) ||
				!institution.getInstAcadpersoninfoidurl().startsWith(enlace) ||
				!institution.getInstAcadphysicalspacesurl().startsWith(enlace) ||
				!institution.getInstAcadprogrammedcoursesurl().startsWith(enlace) ||
				!institution.getInstLdapurl().startsWith(enlace)) {
			throw new LogicalException("Los enlaces de la institution deben empezar con 'https'");
		}
		else {			
			existingInstitution.setInstAcademicserverurl(institution.getInstAcademicserverurl());
			existingInstitution.setInstAcadextradataurl(institution.getInstAcadextradataurl());
			existingInstitution.setInstAcadloginpassword(institution.getInstAcadloginpassword());
			existingInstitution.setInstAcadloginurl(institution.getInstAcadloginurl());
			existingInstitution.setInstAcadloginusername(institution.getInstAcadloginusername());
			existingInstitution.setInstAcadpersoninfodocurl(institution.getInstAcadpersoninfodocurl());
			existingInstitution.setInstAcadpersoninfoidurl(institution.getInstAcadpersoninfoidurl());
			existingInstitution.setInstAcadphysicalspacesurl(institution.getInstAcadphysicalspacesurl());
			existingInstitution.setInstAcadprogrammedcoursesurl(institution.getInstAcadprogrammedcoursesurl());
			existingInstitution.setInstLdapbasedn(institution.getInstLdapbasedn());
			existingInstitution.setInstLdappassword(institution.getInstLdappassword());
			existingInstitution.setInstLdapurl(institution.getInstLdapurl());
			existingInstitution.setInstLdapusername(institution.getInstLdapusername());
			existingInstitution.setInstLdapusersearchbase(institution.getInstLdapusersearchbase());
			existingInstitution.setInstLdapusersearchfilter(institution.getInstLdapusersearchfilter());
			existingInstitution.setInstName(institution.getInstName());
			
			//institutionRepository.save(existingInstitution);
			institutionDAO.Save(existingInstitution);
			return existingInstitution;
		}

	}
	
	@Override
	@Transactional
	public Institution getInstitutionById(long id) throws LogicalException {
		try {
			//Institution institution = institutionRepository.findById(id).get();
			Institution institution = institutionDAO.findById(id);
			return institution;
		}catch(NoSuchElementException e) {
			throw new LogicalException("No se encontró la institución");
		}
		
	}
	
	@Override
	@Transactional
	public Iterable<Institution> findAll(){
		//return institutionRepository.findAll();
		return institutionDAO.findAll();
		
	}
	
	@Override
	@Transactional
	public void delete(long id) throws LogicalException {
		//institutionRepository.delete(institution);
		Institution institution =  getInstitutionById(id);
		institutionDAO.Delete(institution);
	}
}
