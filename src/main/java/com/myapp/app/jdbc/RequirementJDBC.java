package com.myapp.app.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.myapp.app.mapper.RequirementMapper;
import com.myapp.app.model.TrainingRequirementMaster;


public class RequirementJDBC {
	JdbcTemplate temp;

	public RequirementJDBC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("mytemp");
	}

	public List<TrainingRequirementMaster> getAllRequirements() {
		List<TrainingRequirementMaster> all = temp.query("Select * from TrainingRequirementMaster", new RequirementMapper());
		return all;
	} 

	public TrainingRequirementMaster getExecutionById(String id) {
		List<com.myapp.app.model.TrainingRequirementMaster> req =  temp.query("Select * from TrainingExecutionMaster where RequirementID = " + id, new RequirementMapper());
		return req.isEmpty() ? null : req.get(0);
	}

	public void insertNewStudent(int a, String b, String c, int d) {
		temp.update("insert into student values(?,?,?,?)", new Object[] { a, b, c, d });
	}

	public void updateStudentScore(int sid, int newscore) {
		temp.update("update student set sscore=? where sid=?", new Object[] { newscore, sid });
	}

}