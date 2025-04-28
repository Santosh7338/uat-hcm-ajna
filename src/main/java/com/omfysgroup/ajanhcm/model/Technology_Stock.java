package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TECHNOLOGY_STOCK")

public class Technology_Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_stock_seq")
	@SequenceGenerator(name = "technology_stock_seq", sequenceName = "TECHNOLOGY_STOCK_SEQ", allocationSize = 1)
    @Column(name="TECHNOLOGY_STOCK_ID")
private int technology_Stock_Id;
    @Column(name="SOURCE_ID")
private int source_Id;    
    @Column(name="TECHNOLOGY_NAME")
private String technology_Name;
	public int getTechnology_Stock_Id() {
		return technology_Stock_Id;
	}
	public void setTechnology_Stock_Id(int technology_Stock_Id) {
		this.technology_Stock_Id = technology_Stock_Id;
	}
	public int getSource_Id() {
		return source_Id;
	}
	public void setSource_Id(int source_Id) {
		this.source_Id = source_Id;
	}
	public String getTechnology_Name() {
		return technology_Name;
	}
	public void setTechnology_Name(String technology_Name) {
		this.technology_Name = technology_Name;
	}
	@Override
	public String toString() {
		return "Technology_Stock [technology_Stock_Id=" + technology_Stock_Id + ", source_Id=" + source_Id
				+ ", technology_Name=" + technology_Name + "]";
	}

    
    
}
