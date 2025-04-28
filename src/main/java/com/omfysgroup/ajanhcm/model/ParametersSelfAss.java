package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PARAMETERS_SELF_ASS")
public class ParametersSelfAss {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParametersSelfAss_seq")
	@SequenceGenerator(name = "ParametersSelfAss_seq", sequenceName = "PARAMETERS_SELF_ASS_SEQ", allocationSize = 1)
	
    @Column(name = "PSA_NO")
    private Long psaNo;

    @Column(name = "PARAM_TITLE")
    private String paramTitle;

    @Column(name = "CREATED_BY")
    private int createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATED_BY")
    private int lastUpdatedBy;

    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

	@ManyToOne
	@JoinColumn(name = "DESIGNATION_ID")
    private Designation_Master designationId;
	
	@ManyToOne
	@JoinColumn(name = "CGA_NO")
    private Comp_Group_Apr comp_group;

	public Long getPsaNo() {
		return psaNo;
	}

	public void setPsaNo(Long psaNo) {
		this.psaNo = psaNo;
	}

	public String getParamTitle() {
		return paramTitle;
	}

	public void setParamTitle(String paramTitle) {
		this.paramTitle = paramTitle;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Designation_Master getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Designation_Master designationId) {
		this.designationId = designationId;
	}

	public Comp_Group_Apr getComp_group() {
		return comp_group;
	}

	public void setComp_group(Comp_Group_Apr comp_group) {
		this.comp_group = comp_group;
	}

	@Override
	public String toString() {
		return "ParametersSelfAss [psaNo=" + psaNo + ", paramTitle=" + paramTitle + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdateDate="
				+ lastUpdateDate + ", activeFlag=" + activeFlag + ", designationId=" + designationId + ", comp_group="
				+ comp_group + "]";
	}
	
	
    

}
