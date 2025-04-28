package com.omfysgroup.ajanhcm.model;

public class TrainingSheetADFR {
	
	private int tr_sh;
	
	private int administrative_reporting_id;
	
	private int functional_reporting_id;
	
	private int trainee_id;
	
	private String subject;

	public int getTr_sh() {
		return tr_sh;
	}

	public void setTr_sh(int tr_sh) {
		this.tr_sh = tr_sh;
	}

	public int getAdministrative_reporting_id() {
		return administrative_reporting_id;
	}

	public void setAdministrative_reporting_id(int administrative_reporting_id) {
		this.administrative_reporting_id = administrative_reporting_id;
	}

	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getFunctional_reporting_id() {
		return functional_reporting_id;
	}

	public void setFunctional_reporting_id(int functional_reporting_id) {
		this.functional_reporting_id = functional_reporting_id;
	}
	
	

}
