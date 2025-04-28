package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Compentency_Master")
public class Compentency_Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_mst_seq")
	@SequenceGenerator(name = "comp_mst_seq", sequenceName = "COMP_MASTER_SEQ", allocationSize = 1)
	
	private int comp_m_id;
	
	@ManyToOne
	@JoinColumn(name = "COMP_GR_ID")
	private Compentency_Group comp_gr_id;
	
	// field is related to Topics of the training
	@Column(name="COMP_TITLE")
	private String comp_title;
	
	@Column(name="IS_ACTIVATED")
	private String is_actived;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE",updatable=false)
	private Date creation_date=new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="LAST_UPDATED_BY",updatable = true)
	private int last_updated_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATE_DATE",updatable=true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());

	public int getComp_m_id() {
		return comp_m_id;
	}

	public void setComp_m_id(int comp_m_id) {
		this.comp_m_id = comp_m_id;
	}

	

	public Compentency_Group getComp_gr_id() {
		return comp_gr_id;
	}

	public void setComp_gr_id(Compentency_Group comp_gr_id) {
		this.comp_gr_id = comp_gr_id;
	}

	public String getComp_title() {
		return comp_title;
	}

	public void setComp_title(String comp_title) {
		this.comp_title = comp_title;
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

	public String getIs_actived() {
		return is_actived;
	}

	public void setIs_actived(String is_actived) {
		this.is_actived = is_actived;
	}
	
	
}
