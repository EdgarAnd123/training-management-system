package com.myapp.springReact.service;

import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

public class TrainingRequirementMasterServiceTest {

    @InjectMocks
    private TrainingRequirementMasterService trainingRequirementMasterService;

    @Test
    public void retrieveTrainingRequestWithMockRepository_test(){
        TrainingRequirementMaster trainingRM = new TrainingRequirementMaster();

        trainingRM.setRequirementID("200");
        trainingRM.setRequirementReceivedData(new Date("13-DEC-2021"));
        trainingRM.setRequirementUser("1");

        Mockito.when(trainingRequirementMasterService.getTrainingRequest(Mockito.anyString())).thenReturn(trainingRM);
        //when(trainingRequirementMasterService.getTrainingRequest("23")).thenReturn(trainingRM);
        //when(mytemp.query("Select * from TrainingRequirementMaster where RequirementID = 23", new RequirementMapper())).thenReturn(Arrays.asList(trainingRM));

        TrainingRequirementMaster responseTrainingRM = trainingRequirementMasterService.getTrainingRequest("23");
        System.out.println(responseTrainingRM);
    }
}