package com.myapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	

}
