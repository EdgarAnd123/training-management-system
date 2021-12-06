package com.myapp.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.myapp.app.jdbc.JDBC;

public class TrainingProposals {

	@Id
	@Column(name = "ProporsalID")
	private String ProposalID;

	private String ExecutionID;
	private String MemberID;
	private Date ProposedDate;
	private String ProposedTime;
	private Integer ProposedDuration;
	private JDBC jdbc = new JDBC();

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
	public Integer getProposedDuration() {
		return ProposedDuration;
	}
	public void setProposedDuration(Integer proposdDuration) {
		ProposedDuration = proposdDuration;
	}
	
	public LDMemberData getMemberObject() {
		LDMemberData p = jdbc.getMemberById(MemberID);
		return p;
	}

	
}
