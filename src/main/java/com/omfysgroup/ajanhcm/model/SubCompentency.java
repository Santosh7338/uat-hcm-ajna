package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="COMPENTENCY_TOPICS")
public class SubCompentency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub_comp")
	@SequenceGenerator(name = "sub_comp",sequenceName = "SUB_COMP_SEQ",allocationSize = 1)
	private int topic_id;
	
	@ManyToOne
	@JoinColumn(name ="COMP_GR_ID")
	private Compentency_Group comp_gr_id;
	
	@ManyToOne
	@JoinColumn(name = "COMP_MASTER_ID")
	private Compentency_Master comp_master_id;
	
	@Column(name = "NAMEOFTOPIC")
	private String nameoftopic;
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;
	
	@Column(name="IS_ACTIVATED")
	private String is_actived;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE")
	private Date creation_date;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATED_DATE")
	private Date last_updated_date;

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	
	public Compentency_Group getComp_gr_id() {
		return comp_gr_id;
	}

	public void setComp_gr_id(Compentency_Group comp_gr_id) {
		this.comp_gr_id = comp_gr_id;
	}

	public Compentency_Master getComp_master_id() {
		return comp_master_id;
	}

	public void setComp_master_id(Compentency_Master comp_master_id) {
		this.comp_master_id = comp_master_id;
	}

	public String getNameoftopic() {
		return nameoftopic;
	}

	public void setNameoftopic(String nameoftopic) {
		this.nameoftopic = nameoftopic;
	}

	

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public String getIs_actived() {
		return is_actived;
	}

	public void setIs_actived(String is_actived) {
		this.is_actived = is_actived;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}
}
