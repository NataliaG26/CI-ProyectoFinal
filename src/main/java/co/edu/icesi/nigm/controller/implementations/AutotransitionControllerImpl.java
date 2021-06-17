package co.edu.icesi.nigm.controller.implementations;

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

import co.edu.icesi.nigm.model.Autotransition;
import co.edu.icesi.nigm.service.interfaces.AutotransitionService;
import co.edu.icesi.nigm.service.interfaces.EventstatusService;
import co.edu.icesi.nigm.service.interfaces.InstitutionService;
import lombok.extern.log4j.Log4j2;
import co.edu.icesi.nigm.controller.interfaces.AutotransitionController;
import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.groups.CreateAutotransition;
import co.edu.icesi.nigm.groups.UpdateAutotransition;

@Controller
@RequestMapping("/autotransition")
@Log4j2
public class AutotransitionControllerImpl implements AutotransitionController{
	
	private AutotransitionService autotransitionService;
	private InstitutionService institutionService;
	private EventstatusService eventstatusService;
	private ArrayList<String> autotranIsactiveL;
	private ArrayList<String> autotranLogicaloperandL;

	@Autowired	
	public AutotransitionControllerImpl(AutotransitionService autotranservice, InstitutionService institutionService, EventstatusService eventstatusService) {
		this.autotransitionService = autotranservice;
		this.institutionService = institutionService;
		this.eventstatusService = eventstatusService;
		
		autotranIsactiveL = new ArrayList<String>();
		autotranIsactiveL.add("Y");
		autotranIsactiveL.add("N");
		autotranLogicaloperandL = new ArrayList<String>();
		autotranLogicaloperandL.add("OR");
		autotranLogicaloperandL.add("AND");
		
	}
		
	@GetMapping("/")
	public String indexAutotransition(Model model) {
		model.addAttribute("autotransitions", autotransitionService.findAll());
		return "autotransition/index";
	}
	
	@GetMapping("/add")
	public String addAutotransition(Model model) {
		model.addAttribute("autotransition", new Autotransition());
		model.addAttribute("institutions", institutionService.findAll());
		model.addAttribute("autotranIsactiveList", autotranIsactiveL);
		model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
		model.addAttribute("eventstatusList", eventstatusService.findAll());
		return "autotransition/add";
	}
		
	@PostMapping("/add")
	public String saveAutotransition(@Validated(CreateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {
				model.addAttribute("institutions", institutionService.findAll());
				model.addAttribute("autotranIsactiveList", autotranIsactiveL);
				model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
				model.addAttribute("eventstatusList", eventstatusService.findAll());
			 	return "autotransition/add";
			}		
			else {
				try {
				autotransitionService.createAutotransition(autotransition);
				}catch(LogicalException e) {
					e.printStackTrace();
				}
			}			
		return "redirect:/autotransition/";
	}

	@GetMapping("/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		Autotransition autotransition;
		try {
			autotransition = autotransitionService.getAutotransitionById(id);
			autotransitionService.delete(autotransition);
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("autotransitions", autotransitionService.findAll());
		return "autotransition/index";
	}


	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Autotransition autotransition;
		try {
			autotransition = autotransitionService.getAutotransitionById(id);
			if (autotransition == null) 
				throw new IllegalArgumentException("Invalid user Id:" + id);
			model.addAttribute("autotransition", autotransition);
			model.addAttribute("institutions", institutionService.findAll());
			model.addAttribute("autotranIsactiveList", autotranIsactiveL);
			model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
			model.addAttribute("eventstatusList", eventstatusService.findAll());
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "autotransition/update";
	}

	@PostMapping("/update/{id}")
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(UpdateAutotransition.class) @ModelAttribute("autotransition") Autotransition autotransition, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				
				model.addAttribute("institutions", institutionService.findAll());
				model.addAttribute("autotranIsactiveList", autotranIsactiveL);
				model.addAttribute("autotranLogicaloperandList", autotranLogicaloperandL);
				model.addAttribute("eventstatusList", eventstatusService.findAll());
				return "autotransition/update/{id}";
			}
			try {
				autotransitionService.updateAutotransition(autotransition);
			} catch (LogicalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/autotransition/";
	}
}