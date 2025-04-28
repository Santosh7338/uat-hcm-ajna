package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SOURCE")

public class Source {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_seq")
	@SequenceGenerator(name = "source_seq", sequenceName = "SOURCE_SEQ", allocationSize = 1)
    @Column(name="SOURCE_ID")
private int source_Id;
	@Column(name="ORGNIZATION")
private String orgnization;	
@Column(name="ADDRESS")
private String address;	
@Column(name="WEBSITE")
private String website;	
@Column(name="STATE")
private String state;	
@Column(name="DISTRICT")
private String district;
@Column(name="PERSON1")
private String person1;
@Column(name="CONTACT1")
private String contact1;
@Column(name="Email1")
private String email1;
@Column(name="PERSON2")
private String person2;
@Column(name="CONTACT2")
private String contact2;
@Column(name="Email2")
private String email2;
@Column(name="PERSON3")
private String Person3;
@Column(name="CONTACT3")
private String contact3;
@Column(name="EMAIL3")
private String email3;
@Transient	
private String technologies;
public int getSource_Id() {
	return source_Id;
}
public void setSource_Id(int source_Id) {
	this.source_Id = source_Id;
}
public String getOrgnization() {
	return orgnization;
}
public void setOrgnization(String orgnization) {
	this.orgnization = orgnization;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getPerson1() {
	return person1;
}
public void setPerson1(String person1) {
	this.person1 = person1;
}
public String getContact1() {
	return contact1;
}
public void setContact1(String contact1) {
	this.contact1 = contact1;
}
public String getEmail1() {
	return email1;
}
public void setEmail1(String email1) {
	this.email1 = email1;
}
public String getPerson2() {
	return person2;
}
public void setPerson2(String person2) {
	this.person2 = person2;
}
public String getContact2() {
	return contact2;
}
public void setContact2(String contact2) {
	this.contact2 = contact2;
}
public String getEmail2() {
	return email2;
}
public void setEmail2(String email2) {
	this.email2 = email2;
}
public String getPerson3() {
	return Person3;
}
public void setPerson3(String person3) {
	Person3 = person3;
}
public String getContact3() {
	return contact3;
}
public void setContact3(String contact3) {
	this.contact3 = contact3;
}
public String getEmail3() {
	return email3;
}
public void setEmail3(String email3) {
	this.email3 = email3;
}
public String getTechnologies() {
	return technologies;
}
public void setTechnologies(String technologies) {
	this.technologies = technologies;
}
@Override
public String toString() {
	return "Source [source_Id=" + source_Id + ", orgnization=" + orgnization + ", address=" + address + ", website="
			+ website + ", state=" + state + ", district=" + district + ", person1=" + person1 + ", contact1="
			+ contact1 + ", email1=" + email1 + ", person2=" + person2 + ", contact2=" + contact2 + ", email2=" + email2
			+ ", Person3=" + Person3 + ", contact3=" + contact3 + ", email3=" + email3 + ", technologies="
			+ technologies + "]";
}

	
	
	
	
	
}
