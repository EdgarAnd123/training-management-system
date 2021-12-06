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

        model.addAttribute("trainingRequestDetails", trainingRequest);

        return "green-card-trainer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveTrainerProposal(@RequestBody TrainingProposals trainingProposals) {
        trainerProposalService.save(trainingProposals);

        return "redirect:/dashboard";
    }
}
