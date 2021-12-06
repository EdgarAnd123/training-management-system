package com.myapp.app.service;

import com.myapp.app.jdbc.JDBC;
import com.myapp.app.model.TrainingRequirementMaster;
import org.springframework.stereotype.Service;

@Service
public class TrainingRequirementMasterService {

	public int save(TrainingRequirementMaster trainingRequirementMaster) {
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();

		return jdbc.saveTrainingRequirementMaster(trainingRequirementMaster);
	}

	public TrainingRequirementMaster getTrainingRequest(String id) {
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();

		return jdbc.getRequirementById(id);
	}
}


