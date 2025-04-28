package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RENEWEDMAILCOMMUNICATION")
public class RenewedMailCommunication {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "remail_seq")
	@SequenceGenerator(name = "remail_seq", sequenceName = "RENEW_MAIL_COMMUNICATION_SEQ", allocationSize = 1)

	@Column(name = "MAIL_NO")
	private int mail_no;

	@Column(name = "COMM_TYPE")
	private String comm_type;

	@Column(name = "SUB_TYPE")
	private String sub_type;

	@Column(name = "FROM_MAIL")
	private String from_mail;

	@Column(name = "TO_MAIL")
	private String to_mail;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "BODY")
	private String body;

	@Column(name = "RESP1")
	private String resp1;

	@Column(name = "RESP2")
	private String resp2;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CC_MAIL")
	private String cc_mail;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

	public int getMail_no() {
		return mail_no;
	}

	public void setMail_no(int mail_no) {
		this.mail_no = mail_no;
	}

	public String getComm_type() {
		return comm_type;
	}

	public void setComm_type(String comm_type) {
		this.comm_type = comm_type;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public String getFrom_mail() {
		return from_mail;
	}

	public void setFrom_mail(String from_mail) {
		this.from_mail = from_mail;
	}

	public String getTo_mail() {
		return to_mail;
	}

	public void setTo_mail(String to_mail) {
		this.to_mail = to_mail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getResp1() {
		return resp1;
	}

	public void setResp1(String resp1) {
		this.resp1 = resp1;
	}

	public String getResp2() {
		return resp2;
	}

	public void setResp2(String resp2) {
		this.resp2 = resp2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCc_mail() {
		return cc_mail;
	}

	public void setCc_mail(String cc_mail) {
		this.cc_mail = cc_mail;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
