package com.myapp.app.POJO;

import java.util.List;

public class TrainersRequestForm {

	private List<String> trainers;
	private String requirementID;
	
	public List<String> getTrainers() {
		return trainers;
	}
	public void setTrainers(List<String> trainers) {
		this.trainers = trainers;
	}
	public String getRequirementID() {
		return requirementID;
	}
	public void setRequirementID(String requirementID) {
		this.requirementID = requirementID;
	}
	
	
	
}
