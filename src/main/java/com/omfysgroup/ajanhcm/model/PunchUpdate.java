package com.omfysgroup.ajanhcm.model;

import java.sql.Timestamp;

public class PunchUpdate {
	
	


	private int attid;
	
	private Timestamp logdatetime;

	public int getAttid() {
		return attid;
	}

	public void setAttid(int attid) {
		this.attid = attid;
	}

	public Timestamp getLogdatetime() {
		return logdatetime;
	}

	public void setLogdatetime(Timestamp logdatetime) {
		this.logdatetime = logdatetime;
	}

}
