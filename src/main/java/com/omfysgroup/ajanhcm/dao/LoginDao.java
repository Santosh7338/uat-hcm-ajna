package com.omfysgroup.ajanhcm.dao;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import com.omfysgroup.ajanhcm.model.ActiveDeactiveChartBar;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.CertificationCountDashboard;
import com.omfysgroup.ajanhcm.model.CertificationPercentageCal;
import com.omfysgroup.ajanhcm.model.DOCUMENTS_TYPE;
import com.omfysgroup.ajanhcm.model.Designation_Master;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.Holidays_Setup;
import com.omfysgroup.ajanhcm.model.Joining_Details;
import com.omfysgroup.ajanhcm.model.LearningMgCountDashboard;
import com.omfysgroup.ajanhcm.model.LearningMgPerCountDashboard;
import com.omfysgroup.ajanhcm.model.LeaveNotifications;
import com.omfysgroup.ajanhcm.model.Main_Menu;
import com.omfysgroup.ajanhcm.model.PendingApprovals;
import com.omfysgroup.ajanhcm.model.Personal_Details;
import com.omfysgroup.ajanhcm.model.Sub_Menu;


public interface LoginDao{
	
	public Employee_Master getUser(Employee_Master kwm_users);
	
	public List<Main_Menu> getMenus(int profileId);
	
	public List<Sub_Menu> getSubMenus(int menuId);
	
	public boolean getUserPswd(Employee_Master kwm_users);
	
	public Employee_Master loginCheck(String emp_code, String password);
	
	public Employee_Master empCodeCheck(String emp_code);
	
	public Joining_Details getJoiningDetails(int empId);
	
	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee);
	
	public Employee_Master getEmployeeByEmpCode(String emp_code);

	public List<Joining_Details> getJoiningDetails1(int emp_id);

	public List<Personal_Details> getPersonalDetails(int empid);
	
	public List<DOCUMENTS_TYPE> getdocTypes();
	
	public boolean changePassword(Employee_Master emp);

	public float getCredited_Pl(Employee_Master empid);

	public float getCredited_Cl(Employee_Master empid);

	public float getUtilized_Pl(Employee_Master empid);

	public float getUtilized_Cl(Employee_Master empid);

	public float getPl_Balance(Employee_Master empid);

	public float getCl_Balance(Employee_Master empid);

	public boolean updateEmployee(Employee_Master employee);

	public List<Designation_Master> getdesignation1(String dept);

	public List<Joining_Details> getEmp1(String[] designation, String[] dept);

	public ArrayList<Employee_Master> getAllEmployee();

	public boolean save_Holidays(Holidays_Setup h_setup);

	public ArrayList getEmployeeByDept(String[] dept);

	public ArrayList getEmployeeByDesig(String[] desig);

	public int set_OTP_To_Change_password(String empcode, String oTP, int emp_id);
	
	public  List<Employee_Master> getEmpCode(String empdata);

	public boolean setNewPass(Employee_Master emp1);

	public ArrayList<ActiveDeactiveChartBar> getactivedeactive();
	
	public List<PendingApprovals> getleavenotificationList(Employee_Master emp);
	
	public String getAlphaNumericString(int n);
	
	public <T> T updateMyEntity(T t);
	
	public <T> T saveMyEntity(T t);
	
	public String getSalt(int length);
	
	public void sendDailyReportOfTrainingPlan() throws AddressException, MessagingException;
	
	public byte[] hash(char[] password, byte[] salt);
	
	public String generateSecurePassword(String password, String salt);
	
	public boolean verifyUserPassword(String providedPassword,String securedPassword, String salt);

	public ArrayList<CertificationCountDashboard> getCountDashboard();

	public ArrayList<CertificationCountDashboard> getEmpCountDashboard(int empid);

	public List<Administrative_Reporting> getAdministrativeReporter(int empid);

	public List<Functional_Reporting> getFunctionalReporter(int empid);

	public ArrayList<CertificationPercentageCal> getPercentageDashboard();
	
	public HashMap<String, Object> getTotalLeaveCount(Employee_Master loggedInUserId);
	
	public HashMap<Object, ? super List>  getTotalData(Employee_Master loggedInUserId);
	
	public boolean isAdmin(Employee_Master emp, String userRole);
	
	
	public ArrayList<LearningMgCountDashboard> getCount_LearningDashboard();
	public ArrayList<LearningMgCountDashboard> getEmp_CountLearningDashboard(int empid);
	public ArrayList<LearningMgPerCountDashboard> getLearning_PercentageDashboard();
	
	
}
