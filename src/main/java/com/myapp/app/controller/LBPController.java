package com.myapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.app.POJO.MessageRequirementForm;
import com.myapp.app.POJO.TrainersRequestForm;
import com.myapp.app.service.MyService;

@Controller
@RequestMapping("/LBP")
public class LBPController {
	
	@Autowired
	MyService service;
	
	@GetMapping("/bluecard")
	public String getBlueLBP(Model model, @RequestParam String id) {
		model.addAttribute("trainers", service.getrainerslist());
		model.addAttribute("r",service.getrequirement(id));
		return "LBPBlue";
	}
	
	@GetMapping("dashboard")
	public String getLBPDashboard()
	{
		return "LBPDashboard";
	}
	
	@PostMapping("/processRequirementMessage")
	public String processMessage( Model model, MessageRequirementForm form)
	{
		try {
		model.addAttribute("trainers", service.getrainerslist());
		model.addAttribute("r",service.getrequirement(form.getRequirementID()));
		} catch(Exception e) {
			model.addAttribute("alerttype","danger");
			model.addAttribute("alertmessage","Unable to Send Message!");
			System.out.println(form.getRequirementMessage().toString());
			return "LBPBlue";
		
		}
		model.addAttribute("alerttype","success");
		model.addAttribute("alertmessage","Request Message Successfuly Sent!");
		System.out.println(form.getRequirementMessage().toString());
		return "LBPBlue";
	}
	
	@PostMapping("/processRequestTrainers")
	public String processTrainers(Model model, TrainersRequestForm form)
	{
		try {
		model.addAttribute("trainers", service.getrainerslist());
		model.addAttribute("r",service.getrequirement(form.getRequirementID()));
		System.out.println(form.getTrainers());
		} catch(Exception e){
			model.addAttribute("alerttype","danger");
			model.addAttribute("alertmessage","Error Sending Request to Chosen Trainers!");
			return "LBPBlue";
			
		}
		model.addAttribute("alerttype","success");
		model.addAttribute("alertmessage","Request Successfuly Sent to Chosen Trainers!");
		return "LBPBlue";
	}
	

}
