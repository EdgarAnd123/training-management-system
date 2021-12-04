package com.myapp.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.app.jdbc.JDBC;
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

}
