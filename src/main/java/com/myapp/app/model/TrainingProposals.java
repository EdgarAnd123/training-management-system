package com.myapp.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myapp.app.jdbc.JDBC;

public class TrainingProposals {

	@Id
	private String ProposalID;

	private String RequirementID;
	private String MemberID;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ProposedDate;

	private String ProposedTime;
	private String ProposalStatus;
	private Integer ProposedDuration;

	private String RejectDescription;
	private JDBC jdbc = new JDBC();

	public String getProposalID() {
		return ProposalID;
	}
	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getProposalStatus() {
		return ProposalStatus;
	}
	public void setProposalStatus(String proposalStatus) {
		ProposalStatus = proposalStatus;
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

	public String getRejectDescription() {
		return RejectDescription;
	}

	public void setRejectDescription(String rejectDescription) {
		RejectDescription = rejectDescription;
	}

	public LDMemberData getMemberObject() {
		LDMemberData p = jdbc.getMemberById(MemberID);
		return p;
	}

	
}
