package com.myapp.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.app.model.TrainingProposals;

public class MemberMapper implements RowMapper<TrainingProposals> {

	@Override
	public TrainingProposals mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingProposals p = new TrainingProposals();
		p.setProposalID(result.getString(1));
		p.setExecutionID(result.getString(2));
		p.setMemberID(result.getString(3));
		p.setProposedDate(result.getDate(4));
		p.setProposedTime(result.getString(5));
		p.setProposedDuration(result.getInt(6));;
		return p;
		
	}

}
