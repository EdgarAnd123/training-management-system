package com.myapp.app.controller;

import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.MyService;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("trainingRequest")
public class TrainingRequirementMasterController {

    @Autowired
    TrainingRequirementMasterService trainingRequirementMasterService;
    @Autowired
    MyService myService;

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RedirectView save(@RequestBody TrainingRequirementMaster trainingRequirementMaster) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("dashboard");

        trainingRequirementMasterService.save(trainingRequirementMaster);

        return redirectView;
    }

    @PatchMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody TrainingRequirementMaster trainingRequirementMaster) {
        trainingRequirementMasterService.update(trainingRequirementMaster);

        return "dashboard";
    }

    @GetMapping("/{trainingRequestId}")
    public String getNewRequest(@PathVariable String trainingRequestId, Model model) {
        TrainingRequirementMaster trainingRequest = trainingRequirementMasterService.getTrainingRequest(trainingRequestId);

        model.addAttribute("editingForm", true);
        model.addAttribute("verticals", myService.getAllVerticalMaster());
        model.addAttribute("trainingRequest", trainingRequest);

        return "training-request";
    }
}