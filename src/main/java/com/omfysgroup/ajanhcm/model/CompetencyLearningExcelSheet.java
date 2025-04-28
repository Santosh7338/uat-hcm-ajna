package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name = "COMPETANCY_LEARNING_EXCEL")
public class CompetencyLearningExcelSheet  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompetencyLearningExcelSheet_seq")
	@SequenceGenerator(name = "CompetencyLearningExcelSheet_seq", sequenceName = "COMPETANCY_LEARNING_EXCEL_SEQ", allocationSize = 1)
	
	
	 	@Column(name = "CLE_NO")
	    private int cleNo;

		@ManyToOne
		@JoinColumn(name="TECHNOLOGY")
	    private Technology technology;

	    @Column(name = "COMPENTANCY")
	    private String competency;

	    @ManyToOne
		@JoinColumn(name="CREATE_BY")
	    private Employee_Master createdBy;

	    @Column(name = "CREATED_DATE")
	    @Temporal(TemporalType.DATE)
	    private Date createdDate;

	    @Column(name = "UPDATED_BY")
	    private int updatedBy;

	    @Column(name = "UPDATED_DATE")
	    @Temporal(TemporalType.DATE)
	    private Date updatedDate;
	    
	    @Lob
	    @Column(name = "UPLOADED_EXCEL")
	    private CommonsMultipartFile uploadedExcel;
	    
	    @Column(name = "STATUS")
	    private String status;

		public int getCleNo() {
			return cleNo;
		}

		public void setCleNo(int cleNo) {
			this.cleNo = cleNo;
		}

		public Technology getTechnology() {
			return technology;
		}

		public void setTechnology(Technology technology) {
			this.technology = technology;
		}

		public String getCompetency() {
			return competency;
		}

		public void setCompetency(String competency) {
			this.competency = competency;
		}

		public Employee_Master getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(Employee_Master createdBy) {
			this.createdBy = createdBy;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public int getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(int updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}

		public CommonsMultipartFile getUploadedExcel() {
			return uploadedExcel;
		}

		public void setUploadedExcel(CommonsMultipartFile uploadedExcel) {
			this.uploadedExcel = uploadedExcel;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "CompetencyLearningExcelSheet [cleNo=" + cleNo + ", technology=" + technology + ", competency="
					+ competency + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
					+ updatedBy + ", updatedDate=" + updatedDate + ", uploadedExcel=" + uploadedExcel + ", status="
					+ status + "]";
		}

		

}
