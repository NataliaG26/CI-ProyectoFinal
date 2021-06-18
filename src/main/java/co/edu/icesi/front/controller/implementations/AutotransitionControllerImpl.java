package co.edu.icesi.front.controller.implementations;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import co.edu.icesi.back.groups.CreateAutotransition;
import co.edu.icesi.back.groups.UpdateAutotransition;
import co.edu.icesi.front.model.classes.Autotransition;
import co.edu.icesi.front.bd.interfaces.AutotransitionDelegate;
import co.edu.icesi.front.bd.interfaces.EventstatusDelegate;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;
import co.edu.icesi.front.controller.interfaces.AutotransitionController;

@Controller
@RequestMapping("/autotransition")
@Log4j2
public class AutotransitionControllerImpl implements AutotransitionController{
	
	private AutotransitionDelegate autotransitionDelegate;
	private InstitutionDelegate institutionDelegate;
	private EventstatusDelegate eventstatusDelegate;
	private ArrayList<String> autotranIsactiveL;
	private ArrayList<String> autotranLogicaloperandL;

	@Autowired	
	public AutotransitionControllerImpl(AutotransitionDelegate autotransitionDelegate, InstitutionDelegate institutionDelegate, EventstatusDelegate eventstatusDelegate) {
		this.autotransitionDelegate = autotransitionDelegate;
		this.institutionDelegate = institutionDelegate;
		this.eventstatusDelegate = eventstatusDelegate;
		
		autotranIsactiveL = new ArrayList<String>();
		autotranIsactiveL.add("Y");
		autotranIsactiveL.add("N");
		autotranLogicaloperandL = new ArrayList<String>();
		autotranLogicaloperandL.add("OR");
		autotranLogicaloperandL.add("AND");
		
	}
		
	@GetMapping("/")
	public String indexAutotransition(Model model) {
		model.addAttribute("autotransitions", autotransitionDelegate.findAll());
		return "autotransition/index";
	}
	
	@GetMapping("/add")
	public String addAutotransition(Model model) {
		model.addAttribute("autotransition", new Autotransition());
		model.addAttribute("institutions", institutionDelegate.findAll());
		model.addAttribute("autotranIsactiveList", autotranIsactiveL);
		model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
		model.addAttribute("eventstatusList", institutionDelegate.findAll());
		return "autotransition/add";
	}
		
	@PostMapping("/add")
	public String saveAutotransition(@Validated(CreateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {
				model.addAttribute("institutions", institutionDelegate.findAll());
				model.addAttribute("autotranIsactiveList", autotranIsactiveL);
				model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
				model.addAttribute("eventstatusList", eventstatusDelegate.findAll());
			 	return "autotransition/add";
			}		
			else {
				autotransitionDelegate.createAutotransition(autotransition);
			}			
		return "redirect:/autotransition/";
	}

	@GetMapping("/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		Autotransition autotransition;
		autotransition = autotransitionDelegate.getAutotransitionById(id);
		autotransitionDelegate.delete(autotransition.getAutotranId());
		model.addAttribute("autotransitions", autotransitionDelegate.findAll());
		return "autotransition/index";
	}


	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Autotransition autotransition;
		autotransition = autotransitionDelegate.getAutotransitionById(id);
		if (autotransition == null) 
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("autotransition", autotransition);
		model.addAttribute("institutions", institutionDelegate.findAll());
		model.addAttribute("autotranIsactiveList", autotranIsactiveL);
		model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
		model.addAttribute("eventstatusList", eventstatusDelegate.findAll());	
		return "autotransition/update";
	}

	@PostMapping("/update/{id}")
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(UpdateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				
				model.addAttribute("institutions", institutionDelegate.findAll());
				model.addAttribute("autotranIsactiveList", autotranIsactiveL);
				model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
				model.addAttribute("eventstatusList", eventstatusDelegate.findAll());
				return "autotransition/update/{id}";
			}
			autotransitionDelegate.updateAutotransition(autotransition);
		}
		return "redirect:/autotransition/";
	}
}