package com.myapp.app.controller;

import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.MyService;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Controller
@RequestMapping("trainingRequest")
public class TrainingRequirementMasterController {

    private final TrainingRequirementMasterService trainingRequirementMasterService;
    private final MyService myService;

    @Autowired
    public TrainingRequirementMasterController(TrainingRequirementMasterService trainingRequirementMasterService, MyService myService) {
        this.trainingRequirementMasterService = trainingRequirementMasterService;
        this.myService = myService;
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody TrainingRequirementMaster trainingRequirementMaster) {

        try {
            trainingRequirementMasterService.save(trainingRequirementMaster);
            return new ResponseEntity<>("Training Request was created successfully.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody TrainingRequirementMaster trainingRequirementMaster) {
        try {
            trainingRequirementMasterService.update(trainingRequirementMaster);

            return new ResponseEntity<>("Training Request was updated successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{trainingRequestId}")
    public String getNewRequest(@PathVariable String trainingRequestId, Model model) {
        TrainingRequirementMaster trainingRequest = trainingRequirementMasterService.getTrainingRequest(trainingRequestId);

        if (!Objects.isNull(trainingRequest)) {
            model.addAttribute("editingForm", true);
            model.addAttribute("verticals", myService.getAllVerticalMaster());
            model.addAttribute("trainingRequest", trainingRequest);
        }

        return "training-request";
    }
/*
    @DeleteMapping("/delete/{trainingRequestId}")
    public String deleteTrainingRequest(@PathVariable String trainingRequestId) {


        if (!Objects.isNull(trainingRequest)) {
            model.addAttribute("editingForm", true);
            model.addAttribute("verticals", myService.getAllVerticalMaster());
            model.addAttribute("trainingRequest", trainingRequest);

        }
        try {
            trainingRequirementMasterService.delete(trainingRequestId);

            return new ResponseEntity<>("Training Request was updated successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "training-request";
    }*/
}