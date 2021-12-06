package com.myapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp.app.service.MyService;


@Controller
public class TrainerLPController {

	@Autowired
	private MyService service;
	
	@GetMapping("/trainerdashboard")
	public String getTrainerDashboard(Model model) {
		model.addAttribute("reqs", service.getrequiremetsinlist());
		return "trainer-landing-page";
	}

}