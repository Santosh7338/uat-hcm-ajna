package com.omfysgroup.ajanhcm.model;

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

@Entity
@Table(name="TASK_ASS_APR_DOC")
public class TaskAssAprDoc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskAssAprDocseq")
    @SequenceGenerator(name = "TaskAssAprDocseq", sequenceName = "TASK_ASS_APR_DOC_SEQ", allocationSize = 1)

    @Column(name="TAPDOCUMENTID")
    private int tapDocumentId;
 
    @Column(name="DOCUMENTNAME")
    private String documentname;
	
    @Lob
	private byte[] documentupload;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "FILESIZE")
	private Long filesize;
	
	@Column(name = "FILETYPE")
	private String filetype;
	
	@ManyToOne
	@JoinColumn(name = "SAI")
	private SelfAssessmentInfo sai;
	
	@ManyToOne
	@JoinColumn(name = "TAA_NO")
	private TaskAssignment_Apr taaNo;
	
	@Column(name = "CREATEDBY")
	private int CREATEDBY;
	
	@Column(name = "CREATIONDATE",columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date creationdate;
	
	@Column(name = "LASTUPDATEDBY")
	private int lastupdatedby;
	
	@Column(name = "LASTUPDATEDDATE",columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date lastupdateddate;

	public int getTapDocumentId() {
		return tapDocumentId;
	}

	public void setTapDocumentId(int tapDocumentId) {
		this.tapDocumentId = tapDocumentId;
	}

	public String getDocumentname() {
		return documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public byte[] getDocumentupload() {
		return documentupload;
	}

	public void setDocumentupload(byte[] documentupload) {
		this.documentupload = documentupload;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public SelfAssessmentInfo getSai() {
		return sai;
	}

	public void setSai(SelfAssessmentInfo sai) {
		this.sai = sai;
	}

	public TaskAssignment_Apr getTaaNo() {
		return taaNo;
	}

	public void setTaaNo(TaskAssignment_Apr taaNo) {
		this.taaNo = taaNo;
	}

	public int getCREATEDBY() {
		return CREATEDBY;
	}

	public void setCREATEDBY(int cREATEDBY) {
		CREATEDBY = cREATEDBY;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public int getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(int lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	@Override
	public String toString() {
		return "TaskAssAprDoc [tapDocumentId=" + tapDocumentId + ", documentname=" + documentname + ", documentupload="
				+ Arrays.toString(documentupload) + ", filename=" + filename + ", filesize=" + filesize + ", filetype="
				+ filetype + ", sai=" + sai + ", taaNo=" + taaNo + ", CREATEDBY=" + CREATEDBY + ", creationdate="
				+ creationdate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + "]";
	}
	

}
