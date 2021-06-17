package co.edu.icesi.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.back.groups.CreateEventstatus;
import co.edu.icesi.back.groups.UpdateEventstatus;
import co.edu.icesi.back.model.Eventstatus;

public interface EventstatusController {
	
	public String showEventstatus(Model model);
	
	public String addEventstatus(Model model);
	
	public String saveEventstatus(@Validated(CreateEventstatus.class) @ModelAttribute("eventstatus") Eventstatus eventstatus
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);			
	
	public String deleteEventstatus(@PathVariable("id") long id, Model model);
	
	public String showUpdateEventstatus(@PathVariable("id") long id, Model model);
	
	public String updateEventstatus(@PathVariable("id") long id,
			@Validated(UpdateEventstatus.class) @ModelAttribute("eventstatus") Eventstatus eventstatus
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);
		
}
