package com.omfysgroup.ajanhcm.serviceImpl;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omfysgroup.ajanhcm.dao.LoginDao;
import com.omfysgroup.ajanhcm.model.ActiveDeactiveChartBar;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.CertificationCountDashboard;
import com.omfysgroup.ajanhcm.model.CertificationPercentageCal;
import com.omfysgroup.ajanhcm.model.DOCUMENTS_TYPE;
import com.omfysgroup.ajanhcm.model.Department_Master;
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
import com.omfysgroup.ajanhcm.service.LoginService;



@Service("loginService")
@Transactional
public class LogicServiceImpl implements LoginService {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	LoginDao loginDao;
	
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public Employee_Master getUser(Employee_Master kwm_users) {
		return loginDao.getUser(kwm_users);
	}

	@Override
	public List<Main_Menu> getMenus(int profileId) {
		// TODO Auto-generated method stub
		return loginDao.getMenus(profileId);
	}

	@Override
	public boolean getUserPswd(Employee_Master kwm_users) {
		// TODO Auto-generated method stub
		return loginDao.getUserPswd(kwm_users);
	}

	@Override
	public List<Sub_Menu> getSubMenus(int menuId) {
		// TODO Auto-generated method stub
		return loginDao.getSubMenus(menuId);
	}

	@Override
	public Employee_Master loginCheck(String emp_code, String password) {
		// TODO Auto-generated method stub
		return loginDao.loginCheck(emp_code, password);
	}

	@Override
	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee) {
		// TODO Auto-generated method stub
		return loginDao.getApprovalPendingLeaves(employee);
	}

	/*@Override
	public Joining_Details getJoiningDetails(int empId) {
		// TODO Auto-generated method stub
		return loginDao.getJoiningDetails(empId);
	}*/

	@Override
	public List<Designation_Master> getdesignation(String dept) {
	
		List<Designation_Master> YMS = new ArrayList<>();
		if(dept == ""){
		
	
			//String[] year = dept.split(",");
			
			ArrayList<Department_Master> dm = (ArrayList<Department_Master>) hibernateTemplate.find("From Department_Master");      
			
			for(int i=0;i<dm.size();i++){
				
				
				
				String sql = "SELECT * FROM DESIGNATION_MASTER WHERE DEPARTMENT_ID = "+dm.get(i).getDepartment_id()+" ";
				
				List<Designation_Master> al = jdbcTemplate.query(sql, new RowMapper<Designation_Master>() {

					@Override
					public Designation_Master mapRow(ResultSet rs, int no) throws SQLException {
					
						Designation_Master aContact = new Designation_Master();
						//aContact.setYear_id(rs.getString("YEAR_ID"));
						//aContact.setMonth(rs.getString("MONTH"));
						
						aContact.setDesignation_id(rs.getInt("DESIGNATION_ID"));
						aContact.setDesignation_name(rs.getString("DESIGNATION_NAME"));
						aContact.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
						
						return aContact;
					}
			});
			
				YMS.addAll(al);
				
			}
			
		}else{
			
			
			String[] year = dept.split(",");
			for(int i=0;i<year.length;i++){
				
				
				
				String sql = "SELECT * FROM DESIGNATION_MASTER WHERE DEPARTMENT_ID = "+year[i]+" ";
				
				List<Designation_Master> al = jdbcTemplate.query(sql, new RowMapper<Designation_Master>() {

					
					public Designation_Master mapRow(ResultSet rs, int no) throws SQLException {
					
						Designation_Master aContact = new Designation_Master();
					
						
						aContact.setDesignation_id(rs.getInt("DESIGNATION_ID"));
						aContact.setDesignation_name(rs.getString("DESIGNATION_NAME"));
						aContact.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
						
						return aContact;
					}
			});
			
				YMS.addAll(al);
			}
		}
			return YMS;
	}

	@Override
	public List<Joining_Details> getEmp(String designation) {
		
		
		
		List<Joining_Details> YMS = new ArrayList<>();
		
		
		if(designation != ""){
		
		String[] year = designation.split(",");
		for(int i=0;i<year.length;i++){
			
			
			String sql = "SELECT * FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.EMP_ID = EM.EMP_ID AND  JD.DESIGNATION_ID = "+year[i]+" AND EM.IS_ACTIVATED ='Y'";
			
			
			List<Joining_Details> al = jdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

				
				public Joining_Details mapRow(ResultSet rs, int no) throws SQLException {
				
					Joining_Details aContact = new Joining_Details();
					//aContact.setYear_id(rs.getString("YEAR_ID"));
					//aContact.setMonth(rs.getString("MONTH"));
					
					aContact.setE_id(rs.getInt("EMP_ID"));
					aContact.setFname(rs.getString("EMP_FIRST_NAME"));
					aContact.setLname(rs.getString("EMP_LAST_NAME"));
					
					
				
					return aContact;
				}
		});
		
			YMS.addAll(al);
		}
	}//end if
		else{
			
			/// if All option selected in designation
			
			ArrayList<Designation_Master> dm = (ArrayList<Designation_Master>) hibernateTemplate.find("From Designation_Master");      
			
			
			for(int i=0;i<dm.size();i++){
				
				
				String sql = "SELECT * FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.EMP_ID = EM.EMP_ID AND  JD.DESIGNATION_ID = "+dm.get(i).getDesignation_id()+" ";
				
				
				List<Joining_Details> al = jdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

					
					public Joining_Details mapRow(ResultSet rs, int no) throws SQLException {
					
						Joining_Details aContact = new Joining_Details();
						//aContact.setYear_id(rs.getString("YEAR_ID"));
						//aContact.setMonth(rs.getString("MONTH"));
						
						aContact.setE_id(rs.getInt("EMP_ID"));
						aContact.setFname(rs.getString("EMP_FIRST_NAME"));
						aContact.setLname(rs.getString("EMP_LAST_NAME"));
						
						
					
						return aContact;
					}
			});
			
				YMS.addAll(al);
			}
			
			
			
		}
		return YMS;
	}
	

	@Override
	public Employee_Master getEmployeeByEmpCode(String emp_code) {
		// TODO Auto-generated method stub
		return loginDao.getEmployeeByEmpCode(emp_code);
	}

	@Override
	public List<Personal_Details> getPersonalDetails(int empid) {
		// TODO Auto-generated method stub
		return loginDao.getPersonalDetails(empid);
	}

	@Override
	public Joining_Details getJoiningDetails(int empId) {
		// TODO Auto-generated method stub
		return loginDao.getJoiningDetails(empId);
	}

	@Override
	public List<Joining_Details> getJoiningDetails1(int empid) {
		return loginDao.getJoiningDetails1(empid);
	}

	@Override
	public List<DOCUMENTS_TYPE> getdocTypes() {
		// TODO Auto-generated method stub
		return loginDao.getdocTypes();
	}

	@Override
	public boolean changePassword(Employee_Master emp) {
		// TODO Auto-generated method stub
		return loginDao.changePassword(emp);
	}

	@Override
	public float getCredited_Pl(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getCredited_Pl(empid);
	}

	@Override
	public float getCredited_Cl(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getCredited_Cl(empid);
	}

	@Override
	public float getUtilized_Pl(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getUtilized_Pl(empid);
	}

	@Override
	public float getUtilized_Cl(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getUtilized_Cl(empid);
	}

	@Override
	public float getPl_Balance(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getPl_Balance(empid);
	}

	@Override
	public float getCl_Balance(Employee_Master empid) {
		// TODO Auto-generated method stub
		return loginDao.getCl_Balance(empid);
	}

	@Override
	public boolean updateEmployee(Employee_Master employee) {
		// TODO Auto-generated method stub
		return loginDao.updateEmployee(employee);
	}

	@Override
	public List<Designation_Master> getdesignation1(String dept) {
		// TODO Auto-generated method stub
		return loginDao.getdesignation1(dept);
	}
	@Override
	public List<Joining_Details> getEmp1(String[] designation,String[] dept) {
		// TODO Auto-generated method stub
		return loginDao.getEmp1(designation,dept);
	}

	@Override
	public ArrayList<Employee_Master> getAllEmployee() {
		// TODO Auto-generated method stub
		return loginDao.getAllEmployee();
	}

	@Override
	public boolean save_Holidays(Holidays_Setup h_setup) {
		// TODO Auto-generated method stub
		return loginDao.save_Holidays(h_setup);
	}

	@Override
	public ArrayList getEmployeeByDept(String[] dept) {
		// TODO Auto-generated method stub
		return loginDao.getEmployeeByDept(dept);
	}

	@Override
	public ArrayList getEmployeeByDesig(String[] desig) {
		// TODO Auto-generated method stub
		return loginDao.getEmployeeByDesig(desig);
	}

	@Override
	public int set_OTP_To_Change_password(String empcode,String OTP,int emp_id) {
		// TODO Auto-generated method stub
		return loginDao.set_OTP_To_Change_password(empcode,OTP,emp_id);
	}

	@Override
	public boolean setNewPass(Employee_Master emp1) {
		// TODO Auto-generated method stub
		return loginDao.setNewPass(emp1);
	}
	
	@Override
	public List<Employee_Master> getEmpCode(String empdata) {
		// TODO Auto-generated method stub
		return loginDao.getEmpCode(empdata);
	}

	@Override
	public Employee_Master empCodeCheck(String emp_code) {
		// TODO Auto-generated method stub
		return loginDao.empCodeCheck(emp_code);
	}

	@Override
	public ArrayList<ActiveDeactiveChartBar> getactivedeactive() {
		// TODO Auto-generated method stub
		return loginDao.getactivedeactive();
	}

	@Override
	public List<PendingApprovals> getleavenotificationList(Employee_Master emp) {
		// TODO Auto-generated method stub
		return loginDao.getleavenotificationList(emp);
	}

	@Override
	public String getAlphaNumericString(int n) {
		// TODO Auto-generated method stub
		return loginDao.getAlphaNumericString(n);
	}

	@Override
	public <T> T updateMyEntity(T t) {
		// TODO Auto-generated method stub
		return loginDao.updateMyEntity(t);
	}

	@Override
	public void sendDailyReportOfTrainingPlan() throws AddressException, MessagingException {
		loginDao.sendDailyReportOfTrainingPlan();
		
	}

	@Override
	public byte[] hash(char[] password, byte[] salt) {
		// TODO Auto-generated method stub
		return loginDao.hash(password, salt);
	}

	@Override
	public String generateSecurePassword(String password, String salt) {
		// TODO Auto-generated method stub
		return loginDao.generateSecurePassword(password, salt);
	}

	@Override
	public boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		// TODO Auto-generated method stub
		return loginDao.verifyUserPassword(providedPassword, securedPassword, salt);
	}

	@Override
	public String getSalt(int length) {
		// TODO Auto-generated method stub
		return loginDao.getSalt(length);
	}

	@Override
	public ArrayList<CertificationCountDashboard> getCountDashboard() {
		// TODO Auto-generated method stub
		return loginDao.getCountDashboard();
	}

	@Override
	public ArrayList<CertificationCountDashboard> getEmpCountDashboard(int empid) {
		// TODO Auto-generated method stub
		return loginDao.getEmpCountDashboard(empid);
	}


	@Override
	public List<Administrative_Reporting> getAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		return loginDao.getAdministrativeReporter(empid);
	}

	@Override
	public List<Functional_Reporting> getFunctionalReporter(int empid) {
		// TODO Auto-generated method stub
		return loginDao.getFunctionalReporter(empid);
	}

	@Override
	public ArrayList<CertificationPercentageCal> getPercentageDashboard() {
		// TODO Auto-generated method stub
		return loginDao.getPercentageDashboard();
	}

	@Override
	public HashMap<String, Object> getTotalLeaveCount(Employee_Master loggedInUserId) {
		// TODO Auto-generated method stub
		return loginDao.getTotalLeaveCount(loggedInUserId);
	}

	@Override
	public HashMap<Object, ? super List> getTotalData(Employee_Master loggedInUserId) {
		// TODO Auto-generated method stub
		return loginDao.getTotalData(loggedInUserId);
	}

	@Override
	public <T> T saveMyEntity(T t) {
		// TODO Auto-generated method stub
		return loginDao.saveMyEntity(t);
	}

	@Override
	public boolean isAdmin(Employee_Master emp, String userRole) {
		// TODO Auto-generated method stub
		return loginDao.isAdmin(emp, userRole);
	}
	
	
	
	@Override
	public ArrayList<LearningMgCountDashboard> getCount_LearningDashboard() {
		// TODO Auto-generated method stub
		return loginDao.getCount_LearningDashboard();
	}

	@Override
	public ArrayList<LearningMgCountDashboard> getEmp_CountLearningDashboard(int empid) {
		// TODO Auto-generated method stub
		return loginDao.getEmp_CountLearningDashboard(empid);
	}
	
	@Override
	public ArrayList<LearningMgPerCountDashboard> getLearning_PercentageDashboard() {
		// TODO Auto-generated method stub
		return loginDao.getLearning_PercentageDashboard();
	}
}

