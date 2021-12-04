package com.myapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.myapp.app.jdbc.RequirementJDBC;

public class TrainingRequirementMaster {
	
	private String RequirementID;
	private Date RequirementReceivedData;
	private String RequirementUser;
	private String RequirementUserVertical;
	private String TrainingArea;
	private String TrainingDescription;
	private Date RequestedTrainingStartDate;
	private Integer TotalCandidates;
	private String TrainingTimeZone;
	private Integer TotalDurationDays;
	private RequirementJDBC jdbc = new RequirementJDBC();
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public Date getRequirementReceivedData() {
		return RequirementReceivedData;
	}
	public void setRequirementReceivedData(Date requirementReceivedData) {
		RequirementReceivedData = requirementReceivedData;
	}
	public String getRequirementUser() {
		return RequirementUser;
	}
	public void setRequirementUser(String requirementUser) {
		RequirementUser = requirementUser;
	}
	public String getRequirementUserVertical() {
		return RequirementUserVertical;
	}
	public void setRequirementUserVertical(String requirementUserVertical) {
		RequirementUserVertical = requirementUserVertical;
	}
	public String getTrainingArea() {
		return TrainingArea;
	}
	public void setTrainingArea(String trainingArea) {
		TrainingArea = trainingArea;
	}
	public String getTrainingDescription() {
		return TrainingDescription;
	}
	public void setTrainingDescription(String trainingDescription) {
		TrainingDescription = trainingDescription;
	}
	public Date getRequestedTrainingStartDate() {
		return RequestedTrainingStartDate;
	}
	public void setRequestedTrainingStartDate(Date requestedTrainingStartDate) {
		RequestedTrainingStartDate = requestedTrainingStartDate;
	}
	public Integer getTotalCandidates() {
		return TotalCandidates;
	}
	public void setTotalCandidates(Integer totalCandidates) {
		TotalCandidates = totalCandidates;
	}
	public String getTrainingTimeZone() {
		return TrainingTimeZone;
	}
	public void setTrainingTimeZone(String trainingTimeZone) {
		TrainingTimeZone = trainingTimeZone;
	}
	public Integer getTotalDurationDays() {
		return TotalDurationDays;
	}
	public void setTotalDurationDays(Integer totalDurationDays) {
		TotalDurationDays = totalDurationDays;
	}
	
	public TrainingExecutionMaster getExecutionJDBC() {
		return jdbc.getExecutionById(RequirementID);
	}
	
	public String getVerticalMasterName() {
		VerticalMaster v = jdbc.getVerticalById(RequirementUserVertical);
		return v == null ? "" : v.getVerticalName();
	}
	
	public TrainingProposals getProposalObject() {
		TrainingProposals p = jdbc.getProposalByExecutionId(RequirementID);
		return p;
	}

}
