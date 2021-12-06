package com.myapp.app.service;

import java.util.ArrayList;
import java.util.List;

import com.myapp.app.model.VerticalMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.app.jdbc.JDBC;
import com.myapp.app.model.LDMemberData;
import com.myapp.app.model.Participant;
import com.myapp.app.model.TrainingRequirementMaster;


@Service
public class MyService {

	public List<List<TrainingRequirementMaster>> getrequiremetsinlist(){
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		List<TrainingRequirementMaster> l = jdbc.getAllRequirements();
		List<List<TrainingRequirementMaster>> result = new ArrayList();
		 for (int i=0; i<l.size(); i= i+3){
			 	if(i+2 < l.size()) {
			 		result.add(l.subList(i, i+3));
			 	} else {
			 		result.add(l.subList(i, l.size()));
			 	}
		    }
		
		return result;
		
	}
	
	public List<LDMemberData> getrainerslist(){
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		return jdbc.getMembers();
		
	}

	public Object getrequirement(String id) {
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		return jdbc.getRequirementById(id);
	}

	public List<VerticalMaster> getAllVerticalMaster(){
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		return jdbc.getAllVerticalMaster();
	}

	public Object getExecutionFromRequirementID(String id) {
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		return jdbc.getExecutionById(id);
	}

	public List<Participant> getAllTrainingParticipantsByRequirementID(String id) {
		com.myapp.app.jdbc.JDBC jdbc = new JDBC();
		return jdbc.getAllTrainingParticipantsByRequirementID(id);
	}
}
