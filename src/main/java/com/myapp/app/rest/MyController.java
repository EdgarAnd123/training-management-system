package com.myapp.app.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.app.model.LDMemberData;
import com.myapp.app.model.LDRoles;
import com.myapp.app.model.TrainingExecutionMaster;
import com.myapp.app.model.TrainingParticipantData;
import com.myapp.app.model.TrainingProposals;
import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.model.VerticalMaster;
import com.myapp.app.service.MyService;

@RestController
@RequestMapping("/api")
public class MyController {
}
