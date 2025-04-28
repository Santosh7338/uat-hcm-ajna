package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_ATTENDANCE")
public class Employee_Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "EMPLOYEE_ATTENDANCE_SEQ", allocationSize = 1)
	
	@Column(name="EMP_ATTTE_ID")
	private int emp_attte_id;
	
	
	@Column(name="MONTH")
	private String month;
	
	
	@Column(name="YEAR")
	private String year;
	
	
	@Column(name="EMP_NAME")
	private String emp_name;
	
	@Column(name="EMP_ID")
	private String emp_id;
	
	
	@Column(name="D1")
	private String d1;
	
	
	@Column(name="D2")
	private String d2;
	
	
	@Column(name="D3")
	private String d3;
	
	
	@Column(name="D4")
	private String d4;
	
	
	@Column(name="D5")
	private String d5;
	
	
	@Column(name="D6")
	private String d6;
	
	@Column(name="D7")
	private String d7;
	
	
	@Column(name="D8")
	private String d8;
	
	
	@Column(name="D9")
	private String d9;
	
	
	@Column(name="D10")
	private String d10;
	
	
	@Column(name="D11")
	private String d11;
	
	
	@Column(name="D12")
	private String d12;
	
	
	@Column(name="D13")
	private String d13;
	
	@Column(name="D14")
	private String d14;
	
	
	@Column(name="D15")
	private String d15;
	
	
	@Column(name="D16")
	private String d16;
	
	@Column(name="D17")
	private String d17;
	
	
	@Column(name="D18")
	private String d18;
	
	@Column(name="D19")
	private String d19;
	
	
	@Column(name="D20")
	private String d20;
	
	@Column(name="D21")
	private String d21;
	
	
	@Column(name="D22")
	private String d22;
	
	@Column(name="D23")
	private String d23;
	
	
	@Column(name="D24")
	private String d24;
	
	@Column(name="D25")
	private String d25;
	
	@Column(name="D26")
	private String d26;
	
	
	@Column(name="D27")
	private String d27;
	
	
	@Column(name="D28")
	private String d28;
	
	
	@Column(name="D29")
	private String d29;
	
	@Column(name="D30")
	private String d30;
	
	
	@Column(name="D31")
	private String d31;

	@Column(name="CREDITED_PL")
	private float credited_pl;
	
	@Column(name="CREDITED_CL")
	private float credited_cl;

	@Column(name="CREDITED_SL")
	private float credited_sl;

	public float getCredited_pl() {
		return credited_pl;
	}


	public void setCredited_pl(float credited_pl) {
		this.credited_pl = credited_pl;
	}


	public float getCredited_cl() {
		return credited_cl;
	}


	public void setCredited_cl(float credited_cl) {
		this.credited_cl = credited_cl;
	}


	public float getCredited_sl() {
		return credited_sl;
	}


	public void setCredited_sl(float credited_sl) {
		this.credited_sl = credited_sl;
	}


	public float getCredited_ml() {
		return credited_ml;
	}


	public void setCredited_ml(float credited_ml) {
		this.credited_ml = credited_ml;
	}


	@Column(name="CREDITED_ML")
	private float credited_ml;
	
	
	
	
	
	
	

	public int getEmp_attte_id() {
		return emp_attte_id;
	}


	public void setEmp_attte_id(int emp_attte_id) {
		this.emp_attte_id = emp_attte_id;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}

	

	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

	public String getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(String empcode) {
		this.emp_id = empcode;
	}


	public String getD1() {
		return d1;
	}


	public void setD1(String d1) {
		this.d1 = d1;
	}


	public String getD2() {
		return d2;
	}


	public void setD2(String d2) {
		this.d2 = d2;
	}


	public String getD3() {
		return d3;
	}


	public void setD3(String d3) {
		this.d3 = d3;
	}


	public String getD4() {
		return d4;
	}


	public void setD4(String d4) {
		this.d4 = d4;
	}


	public String getD5() {
		return d5;
	}


	public void setD5(String d5) {
		this.d5 = d5;
	}


	public String getD6() {
		return d6;
	}


	public void setD6(String d6) {
		this.d6 = d6;
	}


	public String getD7() {
		return d7;
	}


	public void setD7(String d7) {
		this.d7 = d7;
	}


	public String getD8() {
		return d8;
	}


	public void setD8(String d8) {
		this.d8 = d8;
	}


	public String getD9() {
		return d9;
	}


	public void setD9(String d9) {
		this.d9 = d9;
	}


	public String getD10() {
		return d10;
	}


	public void setD10(String d10) {
		this.d10 = d10;
	}


	public String getD11() {
		return d11;
	}


	public void setD11(String d11) {
		this.d11 = d11;
	}


	public String getD12() {
		return d12;
	}


	public void setD12(String d12) {
		this.d12 = d12;
	}


	public String getD13() {
		return d13;
	}


	public void setD13(String d13) {
		this.d13 = d13;
	}


	public String getD14() {
		return d14;
	}


	public void setD14(String d14) {
		this.d14 = d14;
	}


	public String getD15() {
		return d15;
	}


	public void setD15(String d15) {
		this.d15 = d15;
	}


	public String getD16() {
		return d16;
	}


	public void setD16(String d16) {
		this.d16 = d16;
	}


	public String getD17() {
		return d17;
	}


	public void setD17(String d17) {
		this.d17 = d17;
	}


	public String getD18() {
		return d18;
	}


	public void setD18(String d18) {
		this.d18 = d18;
	}


	public String getD19() {
		return d19;
	}


	public void setD19(String d19) {
		this.d19 = d19;
	}


	public String getD20() {
		return d20;
	}


	public void setD20(String d20) {
		this.d20 = d20;
	}


	public String getD21() {
		return d21;
	}


	public void setD21(String d21) {
		this.d21 = d21;
	}


	public String getD22() {
		return d22;
	}


	public void setD22(String d22) {
		this.d22 = d22;
	}


	public String getD23() {
		return d23;
	}


	public void setD23(String d23) {
		this.d23 = d23;
	}


	public String getD24() {
		return d24;
	}


	public void setD24(String d24) {
		this.d24 = d24;
	}


	public String getD25() {
		return d25;
	}


	public void setD25(String d25) {
		this.d25 = d25;
	}


	public String getD26() {
		return d26;
	}


	public void setD26(String d26) {
		this.d26 = d26;
	}


	public String getD27() {
		return d27;
	}


	public void setD27(String d27) {
		this.d27 = d27;
	}


	public String getD28() {
		return d28;
	}


	public void setD28(String d28) {
		this.d28 = d28;
	}


	public String getD29() {
		return d29;
	}


	public void setD29(String d29) {
		this.d29 = d29;
	}


	public String getD30() {
		return d30;
	}


	public void setD30(String d30) {
		this.d30 = d30;
	}


	public String getD31() {
		return d31;
	}


	public void setD31(String d31) {
		this.d31 = d31;
	}
	

}
