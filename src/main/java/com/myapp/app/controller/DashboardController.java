package com.myapp.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.MyService;


@Controller
public class DashboardController {

	@Autowired
	private MyService service;
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model) {
		model.addAttribute("reqs", service.getrequiremetsinlist());
		return "dashboard";
	}
	
	@GetMapping("/newrequest")
	public String getNewRequest(Model model) {
		model.addAttribute("verticals", service.getAllVerticalMaster());
		model.addAttribute("editingForm", false);

		return "training-request";
	}
	
	@GetMapping("/acceptproposal")
	public String getNewRequest(@RequestParam String id) {
		service.acceptProposal(id);
		return "redirect:/dashboard";
	}
	

}
