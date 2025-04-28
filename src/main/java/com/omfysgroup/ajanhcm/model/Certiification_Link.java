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
@Table(name="CERTIFICATION_LINK")
public class Certiification_Link {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_link_seq")
	@SequenceGenerator(name = "certificate_link_seq", sequenceName = "CERTIFICATION_LINK_SEQ", allocationSize = 1)
	
	@Column(name = "CER_LINK_ID")
	private int cert_link_id;
	
	@Column(name="TOPIC")
	private String topic_docs;
	
	@Column(name="CER_MASTER_ID")
    private int master_id;
	
	@Column(name = "LINK")
	private String link;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = true)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_update_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_active;

	public int getCert_link_id() {
		return cert_link_id;
	}

	public void setCert_link_id(int cert_link_id) {
		this.cert_link_id = cert_link_id;
	}

	public String getTopic_docs() {
		return topic_docs;
	}

	public void setTopic_docs(String topic_docs) {
		this.topic_docs = topic_docs;
	}

	public int getMaster_id() {
		return master_id;
	}

	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	
}
