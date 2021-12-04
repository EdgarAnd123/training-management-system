package com.myapp.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.app.model.TrainingProposals;
import com.myapp.app.model.VerticalMaster;

public class VerticalMapper implements RowMapper<VerticalMaster> {

	@Override
	public VerticalMaster mapRow(ResultSet result, int arg1) throws SQLException {
		VerticalMaster v = new VerticalMaster();
		v.setVID(result.getString(1));
		v.setVerticalName(result.getString(2));
		v.setVerticalLBPID(result.getString(3));
		return v;
		
	}

}
