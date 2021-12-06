package com.myapp.app.controller;

import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping
public class TrainingRequirementMasterController {

    @Autowired
    TrainingRequirementMasterService trainingRequirementMasterService;

    @PostMapping(value = "/saveTrainingRequest",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RedirectView create(@RequestBody TrainingRequirementMaster trainingRequirementMaster) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("dashboard");

        trainingRequirementMasterService.save(trainingRequirementMaster);

        return redirectView;
    }
}