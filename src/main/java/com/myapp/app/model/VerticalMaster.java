package com.myapp.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VerticalMaster")
public class VerticalMaster {

	@Id
	private String VID;
	private String VerticalName;
	private String VerticalLBPID;
	
	public String getVID() {
		return VID;
	}
	public void setVID(String vID) {
		VID = vID;
	}
	public String getVerticalName() {
		return VerticalName;
	}
	public void setVerticalName(String verticalName) {
		VerticalName = verticalName;
	}
	public String getVerticalLBPID() {
		return VerticalLBPID;
	}
	public void setVerticalLBPID(String verticalLBPID) {
		VerticalLBPID = verticalLBPID;
	}

	

}
