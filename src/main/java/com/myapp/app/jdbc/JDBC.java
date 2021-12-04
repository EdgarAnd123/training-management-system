package com.myapp.app.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.myapp.app.mapper.ExecutionMapper;
import com.myapp.app.mapper.MemberMapper;
import com.myapp.app.mapper.ProposalMapper;
import com.myapp.app.mapper.RequirementMapper;
import com.myapp.app.mapper.VerticalMapper;
import com.myapp.app.model.LDMemberData;
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
		List<TrainingExecutionMaster> ex =  temp.query("Select * from TrainingExecutionMaster where RequirementID = " + id, new ExecutionMapper());
		return ex.isEmpty() ? null : ex.get(0);
	}

	public VerticalMaster getVerticalById(String id) {
		List<VerticalMaster> v =  temp.query("Select * from VerticalMaster where VID = '" + id+"'", new VerticalMapper());
		return v.isEmpty() ? null : v.get(0);
	}
	
	public TrainingProposals getProposalByExecutionId(String id) {
		List<TrainingProposals> p =  temp.query("Select * from TrainingProposals where ExecutionID = '" + id+"'", new ProposalMapper());
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

}