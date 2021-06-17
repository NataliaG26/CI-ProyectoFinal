package co.edu.icesi.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Epidemevent;
import co.edu.icesi.back.model.Epidemstatus;
import co.edu.icesi.back.model.Epidemstatuscolor;
import co.edu.icesi.back.model.Eventstatus;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.model.UserType;
import co.edu.icesi.back.model.Userr;
import co.edu.icesi.back.service.implementation.EpidemeventServiceImpl;
import co.edu.icesi.back.service.implementation.EpidemstatusServiceImpl;
import co.edu.icesi.back.service.implementation.EpidemstatuscolorServiceImpl;
import co.edu.icesi.back.service.implementation.EventstatusServiceImpl;
import co.edu.icesi.back.service.implementation.InstitutionServiceImpl;
import co.edu.icesi.back.service.implementation.PersonServiceImpl;
import co.edu.icesi.back.service.implementation.UserrServiceImpl;

@SpringBootApplication
@ComponentScan("co.edu.icesi.")
public class RastreoCercosEpidemiologicosApplication {
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		
		ConfigurableApplicationContext c = SpringApplication.run(RastreoCercosEpidemiologicosApplication.class, args);
		UserrServiceImpl userrService = c.getBean(UserrServiceImpl.class);
		PersonServiceImpl personService = c.getBean(PersonServiceImpl.class);
		InstitutionServiceImpl institutionService = c.getBean(InstitutionServiceImpl.class);
		EventstatusServiceImpl eventstatusService = c.getBean(EventstatusServiceImpl.class);
		EpidemeventServiceImpl epidemeventService = c.getBean(EpidemeventServiceImpl.class);
		EpidemstatusServiceImpl epidemstatusService = c.getBean(EpidemstatusServiceImpl.class);
		EpidemstatuscolorServiceImpl epidemstatuscolorServiceImpl = c.getBean(EpidemstatuscolorServiceImpl.class);
		
		
		Institution institution1 = new Institution();
		institution1 = new Institution();
		institution1.setInstName("Universidad Icesi");
		institution1.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		institution1.setInstLdapurl("https://www.icesi.edu.co/es/");
		
		Institution institution2 = new Institution();
		institution2 = new Institution();
		institution2.setInstName("Universidad Icesi 2");
		institution2.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		institution2.setInstLdapurl("https://www.icesi.edu.co/es/");
		
		Person person1 = new Person();
		person1.setInstitution(institution1);
		person1.setPersName("Natalia Isabel");
		person1.setPersLastname("Gonzalez Murillo");
		person1.setPersEmail("natalia.isa@gmail.com");
		
		Userr userr1 = new Userr();
		userr1.setUserName("Natalia Isabel");
		userr1.setUserPassword("{noop}Nat123");
		userr1.setPerson(person1);
		userr1.setType(UserType.admin);
		
		Person person2 = new Person();
		person2.setInstitution(institution1);
		person2.setPersName("Isabel");
		person2.setPersLastname("Murillo");
		person2.setPersEmail("isa@gmail.com");
		
		Userr userr2 = new Userr();
		userr2.setUserName("Isabel Murillo");
		userr2.setUserPassword("{noop}Isa123");
		userr2.setPerson(person2);
		userr2.setType(UserType.operator);
		
		Epidemevent epidemevent1 = new Epidemevent();
		epidemevent1.setEpieveName("epidemevent_1");
		
		Epidemevent epidemevent2 = new Epidemevent();
		epidemevent2.setEpieveName("epidemevent_2");
		
		Epidemstatus epidemstatus1 = new Epidemstatus();
		epidemstatus1.setEpistatName("epidemstatus_1");
		
		Epidemstatuscolor epidemstatuscolor1 = new Epidemstatuscolor();
		epidemstatuscolor1.setEpistatcolName("epidemstatuscolor_1");
		
		Eventstatus eventstatus1 = new Eventstatus();
		eventstatus1.setEvestatName("Eventstatus_1");
		eventstatus1.setEpidemevent(epidemevent1);
		eventstatus1.setEpidemstatus(epidemstatus1);
		eventstatus1.setEpidemstatuscolor(epidemstatuscolor1);
		eventstatus1.setInstitution(institution1);
		
		Eventstatus eventstatus2 = new Eventstatus();
		eventstatus2.setEvestatName("Eventstatus_2");
		eventstatus2.setEpidemevent(epidemevent1);
		eventstatus2.setEpidemstatus(epidemstatus1);
		eventstatus2.setEpidemstatuscolor(epidemstatuscolor1);
		eventstatus2.setInstitution(institution2);
		
		Eventstatus eventstatus3 = new Eventstatus();
		eventstatus3.setEvestatName("Eventstatus_3");
		eventstatus3.setEpidemevent(epidemevent2);
		eventstatus3.setEpidemstatus(epidemstatus1);
		eventstatus3.setEpidemstatuscolor(epidemstatuscolor1);
		eventstatus3.setInstitution(institution1);
		
		try {
			institutionService.createInstitution(institution1);
			institutionService.createInstitution(institution2);
			personService.createPerson(person1);
			personService.createPerson(person2);
			userrService.createUserr(userr1);
			userrService.createUserr(userr2);
			epidemeventService.createEpidemevent(epidemevent1);
			epidemeventService.createEpidemevent(epidemevent2);
			epidemstatusService.createEpidemstatus(epidemstatus1);
			epidemstatuscolorServiceImpl.createEpidemstatuscolor(epidemstatuscolor1);
			eventstatusService.createEventstatus(eventstatus1);
			eventstatusService.createEventstatus(eventstatus2);
			eventstatusService.createEventstatus(eventstatus3);
		} catch (LogicalException e) {
			e.printStackTrace();
		}
		
	}

}
