package com.myapp.app.controller;

import com.myapp.app.model.TrainingProposals;
import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.TrainerProposalService;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainingProposal")
public class TrainerProposalController {

    @Autowired
    TrainingRequirementMasterService trainingRequirementMasterService;

    @Autowired
    TrainerProposalService trainerProposalService;

    @GetMapping("/{trainingRequestId}")
    public String viewTrainerProposal(@PathVariable String trainingRequestId, Model model) {
        TrainingRequirementMaster trainingRequest = trainingRequirementMasterService.getTrainingRequest(trainingRequestId);
        model.addAttribute("editingForm", false);
        model.addAttribute("trainingRequestDetails", trainingRequest);

        return "trainingProposal";
    }
/*
    @GetMapping("/{trainingProposal}/{trainingRequestId}")
    public String editTrainerProposal(@PathVariable String trainingProposal, @PathVariable String trainingRequestId, Model model) {
        TrainingProposals trainingProposals = trainerProposalService.getProposalById(trainingProposal);
        TrainingRequirementMaster trainingRequest = trainingRequirementMasterService.getTrainingRequest(trainingRequestId);

        if(trainingProposals.getProposalID().isEmpty()){
            model.addAttribute("editingForm", false);
        } else {
            model.addAttribute("editingForm", true);
        }

        model.addAttribute("trainingProposalDetails", trainingProposals);
        model.addAttribute("trainingRequestDetails", trainingRequest);

        return "trainingProposal";
    }
*/
    @RequestMapping(value = "/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveTrainerProposal(@RequestBody TrainingProposals trainingProposals){
        trainerProposalService.save(trainingProposals);

        return "LBPDashboard";
    }

    @PatchMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody TrainingProposals trainingProposals) {
        trainerProposalService.update(trainingProposals);

        return "dashboard";
    }
}
