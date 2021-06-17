package co.edu.icesi.front.controller.implementations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.model.Eventstatus;
import co.edu.icesi.back.service.interfaces.EpidemeventService;
import co.edu.icesi.back.service.interfaces.EpidemstatusService;
import co.edu.icesi.back.service.interfaces.EpidemstatuscolorService;
import co.edu.icesi.back.service.interfaces.EventstatusService;
import co.edu.icesi.back.service.interfaces.InstitutionService;
import co.edu.icesi.front.controller.interfaces.EventstatusController;

@Controller
@RequestMapping("/eventstatus")
public class EventstatusControllerImpl implements EventstatusController{
	
	private EventstatusService eventstatusService;
	private EpidemeventService epidemeventService;
	private EpidemstatusService epidemstatusService;
	private EpidemstatuscolorService epidemstatuscolorService;
	private InstitutionService institutionService;
	private ArrayList<String> isActiveList;
	
	@Autowired
	public EventstatusControllerImpl(EventstatusService eventstatusService, EpidemeventService epidemeventService,
			EpidemstatusService epidemstatusService, EpidemstatuscolorService epidemstatuscolorService, InstitutionService institutionService) {
		this.eventstatusService = eventstatusService;
		this.epidemeventService = epidemeventService;
		this.epidemstatusService = epidemstatusService;
		this.epidemstatuscolorService = epidemstatuscolorService;
		this.institutionService = institutionService;
		isActiveList = new ArrayList<String>();
		isActiveList.add("Y");
		isActiveList.add("N");
	}
	
	@GetMapping("/")
	public String showEventstatus(Model model) {
		model.addAttribute("eventstatusList", eventstatusService.findAll());
		return "eventstatus/index";
	}
	
	@GetMapping("/add")
	public String addEventstatus(Model model) {
		model.addAttribute("isActiveList", isActiveList);
		model.addAttribute("epidemeventList", epidemeventService.findAll());
		model.addAttribute("epidemstatusList", epidemstatusService.findAll());
		model.addAttribute("epidemstatuscolorList", epidemstatuscolorService.findAll());
		model.addAttribute("institutionList", institutionService.findAll());
		model.addAttribute("eventstatus", new Eventstatus());
		return "eventstatus/add";
	}
	
	@PostMapping("/add")
	public String saveEventstatus( @ModelAttribute("eventstatus") Eventstatus eventstatus
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {
				model.addAttribute("isActiveList", isActiveList);
				model.addAttribute("epidemeventList", epidemeventService.findAll());
				model.addAttribute("epidemstatusList", epidemstatusService.findAll());
				model.addAttribute("epidemstatuscolorList", epidemstatuscolorService.findAll());
				model.addAttribute("institutionList", institutionService.findAll());
				return "eventstatus/add";
			}		
			else {
				eventstatusService.createEventstatus(eventstatus);
			}			
		return "redirect:/eventstatus/";
	}
	
	@GetMapping("/del/{id}")
	public String deleteEventstatus(@PathVariable("id") long id, Model model) {
		Eventstatus eventstatus;
		eventstatus = eventstatusService.getEventstatusById(id);
		eventstatusService.delete(eventstatus);
		return "redirect:/eventstaus/";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateEventstatus(@PathVariable("id") long id, Model model) {
		Eventstatus eventstatus = eventstatusService.getEventstatusById(id);
		model.addAttribute("isActiveList", isActiveList);
		model.addAttribute("epidemeventList", epidemeventService.findAll());
		model.addAttribute("epidemstatusList", epidemstatusService.findAll());
		model.addAttribute("epidemstatuscolorList", epidemstatuscolorService.findAll());
		model.addAttribute("institutions", institutionService.findAll());
		model.addAttribute("eventstatus", eventstatus);
		return "eventstatus/update";
	}
	
	@PostMapping("/update/{id}")
	public String updateEventstatus(@PathVariable("id") long id,
			 @ModelAttribute("eventstatus") Eventstatus eventstatus
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {
				model.addAttribute("isActiveList", isActiveList);
				model.addAttribute("epidemeventList", epidemeventService.findAll());
				model.addAttribute("epidemstatusList", epidemstatusService.findAll());
				model.addAttribute("epidemstatuscolorList", epidemstatuscolorService.findAll());
				model.addAttribute("institutions", institutionService.findAll());
				return "eventstatus/update";
			}		
			else {
				eventstatusService.updateEventstatus(eventstatus);
			}			
		return "redirect:/eventstaus/";
	}

}
