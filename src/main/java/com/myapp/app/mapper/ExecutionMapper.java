package com.myapp.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.app.model.TrainingExecutionMaster;
import com.myapp.app.model.TrainingRequirementMaster;

public class ExecutionMapper implements RowMapper<TrainingExecutionMaster> {

	@Override
	public TrainingExecutionMaster mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingExecutionMaster r = new TrainingExecutionMaster();
		r.setRequirementID(result.getString(1));
		r.setExecutionID(result.getString(2));
		r.setProposalID(result.getString(3));
		r.setConfirmedDate(result.getDate(4));
		r.setConfirmedTime(result.getString(5));
		r.setTrainer(result.getString(6));
		r.setTotalHRS(result.getInt(7));
		r.setTotalParticipantsAllowed(result.getInt(8));
		return r;
		
	}

}
