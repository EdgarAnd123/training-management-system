package com.myapp.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.app.model.LDMemberData;
import com.myapp.app.model.TrainingProposals;

public class MemberMapper implements RowMapper<LDMemberData> {

	@Override
	public LDMemberData mapRow(ResultSet result, int arg1) throws SQLException {
		LDMemberData p = new LDMemberData();
		p.setMemberID(result.getString(1));
		p.setMemberName(result.getString(2));
		p.setMemberContact(result.getString(3));
		p.setMemberLocation(result.getString(4));
		p.setMemberEmail(result.getString(5));
		p.setLDRoleID(result.getString(6));;
		return p;
		
	}

}
