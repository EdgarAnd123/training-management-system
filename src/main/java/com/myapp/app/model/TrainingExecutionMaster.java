package com.myapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.myapp.app.jdbc.JDBC;

public class TrainingExecutionMaster {

	@Id
	private String RequirementID;
	private String ExecutionID;
	private String ProposalID;
	private Date ConfirmedDate;
	private String ConfirmedTime;
	private String Trainer;
	private Integer TotalHRS;
	private Integer TotalParticipantsAllowed;
	private JDBC jdbc = new JDBC();
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getExecutionID() {
		return ExecutionID;
	}
	public void setExecutionID(String executionID) {
		ExecutionID = executionID;
	}
	public Date getConfirmedDate() {
		return ConfirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		ConfirmedDate = confirmedDate;
	}
	public String getConfirmedTime() {
		return ConfirmedTime;
	}
	public void setConfirmedTime(String confirmedTime) {
		ConfirmedTime = confirmedTime;
	}
	public String getTrainer() {
		return Trainer;
	}
	public void setTrainer(String trainer) {
		Trainer = trainer;
	}
	public Integer getTotalHRS() {
		return TotalHRS;
	}
	public void setTotalHRS(Integer totalHRS) {
		TotalHRS = totalHRS;
	}
	public Integer getTotalParticipantsAllowed() {
		return TotalParticipantsAllowed;
	}
	public void setTotalParticipantsAllowed(Integer totalParticipantsAllowed) {
		TotalParticipantsAllowed = totalParticipantsAllowed;
	}
	public String getProposalID() {
		return ProposalID;
	}
	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}
	
	public LDMemberData getMemberObject() {
		return jdbc.getMemberById(Trainer);
	}
	

}
