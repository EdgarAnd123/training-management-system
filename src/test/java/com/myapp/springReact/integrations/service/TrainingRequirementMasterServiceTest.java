package com.myapp.springReact.integrations.service;

import com.myapp.app.service.TrainingRequirementMasterService;
import com.myapp.springReact.integrations.BaseIntegrationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TrainingRequirementMasterServiceTest extends BaseIntegrationTest {

    @Autowired
    protected TrainingRequirementMasterService trainingRequirementMasterService;

    @Test
    @Disabled
    public void getTrainingRequest_test() {
        trainingRequirementMasterService.getTrainingRequest("56");
    }

    @Test
    @Disabled
    public void getExistingTrainingRequest_test() {
        trainingRequirementMasterService.getTrainingRequest("23");
    }

}
