package com.myapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrainingProposals {

	@Id
	private String ProposalID;
	private String ExecutionID;
	private String MemberID;
	private Date ProposedDate;
	private String ProposedTime;
	private Integer ProposdDuration;
	
	public String getProposalID() {
		return ProposalID;
	}
	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}
	public String getExecutionID() {
		return ExecutionID;
	}
	public void setExecutionID(String executionID) {
		ExecutionID = executionID;
	}
	
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public Date getProposedDate() {
		return ProposedDate;
	}
	public void setProposedDate(Date proposedDate) {
		ProposedDate = proposedDate;
	}
	public String getProposedTime() {
		return ProposedTime;
	}
	public void setProposedTime(String proposedTime) {
		ProposedTime = proposedTime;
	}
	public Integer getProposdDuration() {
		return ProposdDuration;
	}
	public void setProposdDuration(Integer proposdDuration) {
		ProposdDuration = proposdDuration;
	}
	
	
	
}
