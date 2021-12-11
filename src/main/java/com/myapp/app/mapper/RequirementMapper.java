package com.myapp.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.myapp.app.model.TrainingRequirementMaster;

public class RequirementMapper implements RowMapper<TrainingRequirementMaster> {

	@Override
	public TrainingRequirementMaster mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingRequirementMaster r = new TrainingRequirementMaster();
		r.setRequirementID(result.getString(1));
		r.setRequirementReceivedData(result.getDate(2));
		r.setRequirementUser(result.getString(3));
		r.setRequirementUserVertical(result.getString(4));
		r.setTrainingArea(result.getString(5));
		r.setTrainingDescription(result.getString(6));
		r.setRequestedTrainingStartDate(result.getDate(7));
		r.setTotalCandidates(result.getInt(8));
		r.setTrainingTimeZone(result.getString(9));
		r.setTotalDurationDays(result.getInt(10));
		r.setStatus(result.getString(11));
		return r;
		
	}

}
