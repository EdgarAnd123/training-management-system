package com.myapp.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LDRoles {

	@Id
	private String LDRoleID;
	private String LDRoleName;
	private String LDRoleDescription;

	public String getLDRoleID() {
		return LDRoleID;
	}
	public void setLDRoleID(String LDRoleID) {
		this.LDRoleID = LDRoleID;
	}
	public String getLDRoleName() {
		return LDRoleName;
	}
	public void setLDRoleName(String LDRoleName) {
		this.LDRoleName = LDRoleName;
	}
	public String getLDRoleDescription() {
		return LDRoleDescription;
	}
	public void setLDRoleDescription(String LDRoleDescription) {
		this.LDRoleDescription = LDRoleDescription;
	}
	
	
	
}
