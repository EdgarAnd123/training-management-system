package com.myapp.app.service;

import com.myapp.app.jdbc.JDBC;
import com.myapp.app.model.TrainingProposals;
import org.springframework.stereotype.Service;

@Service
public class TrainerProposalService {

    public int save(TrainingProposals trainingProposals) {
        com.myapp.app.jdbc.JDBC jdbc = new JDBC();

        return jdbc.saveTrainingProposal(trainingProposals);
    }
}
