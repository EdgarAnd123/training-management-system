package com.myapp.app.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.myapp.app.mapper.ExecutionMapper;
import com.myapp.app.mapper.MemberMapper;
import com.myapp.app.mapper.ParticipantMapper;
import com.myapp.app.mapper.ProposalMapper;
import com.myapp.app.mapper.RequirementMapper;
import com.myapp.app.mapper.VerticalMapper;
import com.myapp.app.model.LDMemberData;
import com.myapp.app.model.Participant;
import com.myapp.app.model.TrainingExecutionMaster;
import com.myapp.app.model.TrainingProposals;
import com.myapp.app.model.TrainingRequirementMaster;
import com.myapp.app.model.VerticalMaster;


public class JDBC {
	JdbcTemplate temp;

	public JDBC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("mytemp");
	}

	public List<TrainingRequirementMaster> getAllRequirements() {
		List<TrainingRequirementMaster> all = temp.query("Select * from TrainingRequirementMaster", new RequirementMapper());
		return all;
	} 

	public TrainingExecutionMaster getExecutionById(String id) {
		List<TrainingExecutionMaster> ex =  temp.query("Select * from TrainingExecutionMaster where RequirementID = '" + id +"'", new ExecutionMapper());
		return ex.isEmpty() ? null : ex.get(0);
	}

	public VerticalMaster getVerticalById(String id) {
		List<VerticalMaster> v =  temp.query("Select * from VerticalMaster where VID = '" + id+"'", new VerticalMapper());
		return v.isEmpty() ? null : v.get(0);
	}

	public List<VerticalMaster> getAllVerticalMaster() {
		List<VerticalMaster> verticalList =  temp.query("Select * from VerticalMaster", new VerticalMapper());
		return verticalList;
	}
	
	public List<TrainingProposals> getProposalsByRequirementId(String id) {
		List<TrainingProposals> p =  temp.query("Select * from TrainingProposals where RequirementID = '" + id+"'", new ProposalMapper());
		return p;
	}
	
	public TrainingProposals getProposalById(String id) {
		List<TrainingProposals> p =  temp.query("Select * from TrainingProposals where ProposalID = '" + id+"'", new ProposalMapper());
		return p.isEmpty() ? null : p.get(0);
	}

	public LDMemberData getMemberById(String id) {
		List<LDMemberData> p =  temp.query("Select * from LDMemberData where MemberID = '" + id+"'", new MemberMapper());
		return p.isEmpty() ? null : p.get(0);
	}
	
	public List<LDMemberData> getMembers() {
		List<LDMemberData> p =  temp.query("Select * from LDMemberData", new MemberMapper());
		return p;
	}

	public TrainingRequirementMaster getRequirementById(String id) {
		List<TrainingRequirementMaster> p =  temp.query("Select * from TrainingRequirementMaster where RequirementID = '" + id+"'", new RequirementMapper());
		return p.isEmpty() ? null : p.get(0);
	}

	public int saveTrainingRequirementMaster(TrainingRequirementMaster trainingRequirementMaster) {
		final String INSERT_QUERY = "INSERT INTO trainingrequirementmaster (RequirementID , RequirementReceivedData, RequirementUser, RequirementUserVertical, TrainingArea, TrainingDescription,  RequestedTrainingStartDate, TotalCandidates, TrainingTimeZone, TotalDurationDays) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			Object[] trainingRequest = new Object[] { trainingRequirementMaster.getRequirementID(), trainingRequirementMaster.getRequirementReceivedData(),
					trainingRequirementMaster.getRequirementUser(),
					trainingRequirementMaster.getRequirementUserVertical(), trainingRequirementMaster.getTrainingArea(),
					trainingRequirementMaster.getTrainingDescription(), trainingRequirementMaster.getRequestedTrainingStartDate(),
					trainingRequirementMaster.getTotalCandidates(), trainingRequirementMaster.getTrainingTimeZone(),
					trainingRequirementMaster.getTotalDurationDays() };

			return temp.update(INSERT_QUERY, trainingRequest);
	}

	public int saveTrainingProposal(TrainingProposals trainingProposals) {
		final String INSERT_QUERY = "INSERT INTO trainingproposals (ProposalID , RequirementID, MemberID, ProposedDate, ProposedTime, ProposedDuration, ProposalStatus) values (?, ?, ?, ?, ?, ?,?)";

		Object[] trainingProposal = new Object[] { trainingProposals.getProposalID(), trainingProposals.getRequirementID(),
				trainingProposals.getMemberID(), trainingProposals.getProposedDate(), trainingProposals.getProposedTime(),
				trainingProposals.getProposedDuration(), "Not Confirmed" };

		return temp.update(INSERT_QUERY, trainingProposal);
	}
	
	public List<Participant> getAllTrainingParticipant() {
		
		//Select * from TrainingParticipantData
		List<Participant> allParticipants = temp.query("Select * from TrainingParticipantData", new ParticipantMapper());
		return allParticipants;
	}

	public List<TrainingExecutionMaster> getExecutionsByRequirementId(String id) {
		List<TrainingExecutionMaster> ex =  temp.query("Select * from TrainingExecutionMaster where RequirementID = '" + id +"'", new ExecutionMapper());
		return ex;
	}

	public List<Participant> getAllTrainingParticipantsByRequirementID(String id) {
		//Select * from TrainingParticipantData
		List<Participant> allParticipants = temp.query("Select * from TrainingParticipantData where RequirementID = '" +id + "'", new ParticipantMapper());
		return allParticipants;
	}

	public int acceptProposalByID(String id) {
		final String INSERT_QUERY1 = "UPDATE TrainingProposals SET ProposalStatus = 'Confirmed' WHERE ProposalID = ?";
		final String INSERT_QUERY2 = "INSERT INTO TrainingExecutionMaster (RequirementID , ExecutionID, ProposalID, ConfirmedDate, ConfirmedTime, Trainer, TotalHRS, TotalParticipantsAllowed) values (?, ?, ?, ?, ?, ?,?,?)";
		temp.update(INSERT_QUERY1, new Object[] {id});
		
		TrainingProposals prop = getProposalById(id);
		TrainingRequirementMaster req = getRequirementById(prop.getRequirementID());
		
		Object[] execution = new Object[] { prop.getRequirementID(), prop.getRequirementID(), prop.getProposalID(), prop.getProposedDate(), prop.getProposedTime(), prop.getMemberObject().getMemberID(), prop.getProposedDuration(), req.getTotalCandidates()};

		return temp.update(INSERT_QUERY2, execution);
		
		
	}
	

	
	
}