package com.myapp.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.app.model.Participant;

public class ParticipantMapper implements RowMapper<Participant> {

	@Override
	public Participant mapRow(ResultSet result, int arg1) throws SQLException {
		
		Participant participant = new Participant();
		
		participant.setParticipantID(result.getString(1));
		participant.setEmployeeID(result.getString(2));
		participant.setEmployeeName(result.getString(3));
		participant.setEmail(result.getString(4));
		participant.setContact(result.getString(5));
		participant.setRequirementID(result.getString(6));
		participant.setAttendanceStatus(result.getString(7));

		return participant;
	}

}