package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FINANCIAL_SETTLEMENTS")
public class Financial_Settlements {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_settlement_seq")
	@SequenceGenerator(name = "financial_settlement_seq", sequenceName = "FINANCIAL_SETTLEMENT_SEQ", allocationSize = 1)
	
	@Column(name="FINANCE_ID")
	private int financial_id;
	
	@Column(name="PARTICULAR_TO_EMP")
	private String part_toemp;
	
	@Column(name="AMOUNT_TO_EMP")
	private int amt_toemp;
	
	@Column(name="REMARK_TO_EMP")
	private String remark_toemp;
	
	@Column(name="PARTICULAR_FROM_EMP")
	private String part_frmemp;
	
	@Column(name="AMOUNT_FROM_EMP")
	private int amt_frmemp;
	
	@Column(name="REMARK_FROM_EMP")
	private String remark_frmemp;
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@Column(name = "FINANCE_HEADER_ID")
	private int headid;
	

	public int getFinancial_id() {
		return financial_id;
	}

	public void setFinancial_id(int financial_id) {
		this.financial_id = financial_id;
	}

	public String getPart_toemp() {
		return part_toemp;
	}

	public void setPart_toemp(String part_toemp) {
		this.part_toemp = part_toemp;
	}

	public int getAmt_toemp() {
		return amt_toemp;
	}

	public void setAmt_toemp(int amt_toemp) {
		this.amt_toemp = amt_toemp;
	}

	public String getRemark_toemp() {
		return remark_toemp;
	}

	public void setRemark_toemp(String remark_toemp) {
		this.remark_toemp = remark_toemp;
	}

	public String getPart_frmemp() {
		return part_frmemp;
	}

	public void setPart_frmemp(String part_frmemp) {
		this.part_frmemp = part_frmemp;
	}

	public int getAmt_frmemp() {
		return amt_frmemp;
	}

	public void setAmt_frmemp(int amt_frmemp) {
		this.amt_frmemp = amt_frmemp;
	}

	public String getRemark_frmemp() {
		return remark_frmemp;
	}

	public void setRemark_frmemp(String remark_frmemp) {
		this.remark_frmemp = remark_frmemp;
	}

	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
	}

	

	public int getHeadid() {
		return headid;
	}

	public void setHeadid(int headid) {
		this.headid = headid;
	}

	


}
