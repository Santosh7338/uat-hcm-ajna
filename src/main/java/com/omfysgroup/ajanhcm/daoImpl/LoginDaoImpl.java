 package com.omfysgroup.ajanhcm.daoImpl;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.omfysgroup.ajanhcm.dao.LoginDao;
import com.omfysgroup.ajanhcm.model.ActiveDeactiveChartBar;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.CertificationCountDashboard;
import com.omfysgroup.ajanhcm.model.CertificationPercentageCal;
import com.omfysgroup.ajanhcm.model.Common_Document_Uploaded;
import com.omfysgroup.ajanhcm.model.Compentency_Group;
import com.omfysgroup.ajanhcm.model.DOCUMENTS_TYPE;
import com.omfysgroup.ajanhcm.model.Department_Master;
import com.omfysgroup.ajanhcm.model.Designation_Master;
import com.omfysgroup.ajanhcm.model.Document_Uploaded;
import com.omfysgroup.ajanhcm.model.Employee_Attendance;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.Holidays_Setup;
import com.omfysgroup.ajanhcm.model.Joining_Details;
import com.omfysgroup.ajanhcm.model.KtNotifivationHead;
import com.omfysgroup.ajanhcm.model.KtPlan_Header;
import com.omfysgroup.ajanhcm.model.LearningMgCountDashboard;
import com.omfysgroup.ajanhcm.model.LearningMgPerCountDashboard;
import com.omfysgroup.ajanhcm.model.LeaveBalance;
import com.omfysgroup.ajanhcm.model.LeaveNotifications;
import com.omfysgroup.ajanhcm.model.LeaveRequest;
import com.omfysgroup.ajanhcm.model.LeaveRequestLines;
import com.omfysgroup.ajanhcm.model.Main_Menu;
import com.omfysgroup.ajanhcm.model.MarkExitScreen;
import com.omfysgroup.ajanhcm.model.PendingApprovals;
import com.omfysgroup.ajanhcm.model.Personal_Details;
import com.omfysgroup.ajanhcm.model.ProbationRequest;
import com.omfysgroup.ajanhcm.model.RenewedMailCommunication;
import com.omfysgroup.ajanhcm.model.Sub_Menu;
import com.omfysgroup.ajanhcm.model.TimeLineStructure;
import com.omfysgroup.ajanhcm.model.TraineeTrainingSheet;
import com.omfysgroup.ajanhcm.model.Training_Master;
import com.omfysgroup.ajanhcm.service.ExitModule_Service;
import com.omfysgroup.ajanhcm.service.LeavesService;
import com.omfysgroup.ajanhcm.service.LoginService;
import com.omfysgroup.ajanhcm.service.TrainingService;
import com.omfysgroup.ajanhcm.utility.MailService;



@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Autowired
	HibernateTemplate hibernatetemplate;
	
//	@Autowired
//	ReportsController repo;

	@Autowired
	TrainingService trainingService;
	
	@Autowired
	LeavesService leaveService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	TrainingDaoImpl trainingDaoImpl;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	Environment environment;
	
    @Autowired
    ExitModule_Service exitModule;
    
    @Autowired
    com.omfysgroup.ajanhcm.dao.Attendance_dao Attendance_dao;
    
    @Autowired
    ExitModule_dao_imp ExitModule_dao_imp;
    
    private  final Random RANDOM = new SecureRandom();
    private  final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private  final int ITERATIONS = 10000;
    private  final int KEY_LENGTH = 256;

	
	@Override
	public Employee_Master getUser(Employee_Master kwm_users) {
		Employee_Master emp = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Employee_Master where emp_code = :empcode and password = :password and is_activated = :Y ";   //is_activated
			Query sql = session.createQuery(query);
			sql.setParameter("empcode", kwm_users.getEmp_code());
			sql.setParameter("password", kwm_users.getPassword());
			sql.setParameter("Y","Y");
			
			emp = (Employee_Master) sql.uniqueResult();
			
			return emp;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return emp;
	}


	@Override
	public List<Main_Menu> getMenus(int profileId) {
		List<Main_Menu> menus = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Main_Menu where profile_id = :profileId order by main_menu_id ASC";
			Query sql = session.createQuery(query);
			sql.setParameter("profileId", profileId);
			
			menus = (List<Main_Menu>) sql.list();
			
			return menus;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return menus;
	}


	@Override
	public boolean getUserPswd(Employee_Master kwm_users) {
		
		return (Boolean) null;
	}


	@Override
	public List<Sub_Menu> getSubMenus(int menuId) {
		List<Sub_Menu> submenus = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Sub_Menu where main_menu_id.main_menu_id = :menuId order by SUB_MENU_NAME";
			Query sql = session.createQuery(query);
			sql.setParameter("menuId", menuId);
			
			submenus = (List<Sub_Menu>) sql.list();
			
			return submenus;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return submenus;
	}


	@Override
	public Employee_Master loginCheck(String emp_code, String password) {
		Employee_Master emp = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Employee_Master where emp_code = :empcode and password = :password";
			Query sql = session.createQuery(query);
			sql.setParameter("empcode", emp_code);
			sql.setParameter("password", password);
			
			emp = (Employee_Master) sql.uniqueResult();
			
			
			return emp;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return emp;
	}


	@Override
	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee) {
		List<LeaveNotifications> notifications = new ArrayList<>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
//			String query = "from LeaveNotifications where approver_id.emp_id = :emp_id and status = :status and (lr_id.status = :leaveStatusFR or lr_id.status = :leaveStatusAR or lr_id.status = :leaveStatusMG)";
			String query = "from LeaveNotifications where approver_id.emp_id = :emp_id and status = :status";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_id", employee.getEmp_id());
			sql.setParameter("status", "Pending for approval");
//			sql.setParameter("leaveStatusFR", "Pending for FR Approval");
//			sql.setParameter("leaveStatusAR", "Pending for AR Approval");
//			sql.setParameter("leaveStatusMG", "Pending for MG Approval");
			
			notifications = (List<LeaveNotifications>) sql.list();
			
			return notifications;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return notifications;
	}




	@Override
	public List<Joining_Details> getJoiningDetails1(int emp_id) {
		// TODO Auto-generated method stub
		//int emp_id = loggedInUser.getEmp_id();
		ArrayList<Joining_Details> jdl = (ArrayList<Joining_Details>) hibernatetemplate.find("from Joining_Details where emp_id.emp_id=?",emp_id);
		return jdl;
	}


	@Override
	public List<Personal_Details> getPersonalDetails(int empid) {
		// TODO Auto-generated method stub
		ArrayList<Personal_Details> per_detail = (ArrayList<Personal_Details>) hibernatetemplate.find("from Personal_Details where emp_id.emp_id = ?",empid);
		return per_detail;
	}


	@Override
	public Joining_Details getJoiningDetails(int empId) {
		Joining_Details jd = new Joining_Details();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Joining_Details where emp_id.emp_id = :emp_id";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_id", empId);
			
			jd = (Joining_Details) sql.uniqueResult();
			
			return jd;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return jd;
	}

	@Override
	public Employee_Master getEmployeeByEmpCode(String emp_code) {
		Employee_Master emp = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Employee_Master where emp_code = :empcode";
			Query sql = session.createQuery(query);
			sql.setParameter("empcode", emp_code);
			
			emp = (Employee_Master) sql.uniqueResult();
			
			return emp;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return emp;
	}


	@Override
	public List<DOCUMENTS_TYPE> getdocTypes() {
		List<DOCUMENTS_TYPE> docTypes = new ArrayList<>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from DOCUMENTS_TYPE";
			Query sql = session.createQuery(query);
			
			docTypes = (List<DOCUMENTS_TYPE>) sql.list();
			
			return docTypes;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return docTypes;
	}


	@Override
	public boolean changePassword(Employee_Master emp) {
		
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(emp);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return false;
	}


	@Override
	public float getCredited_Pl(Employee_Master empid) {
		// TODO Auto-generated method stub
		//int emp_id = empid.getEmp_id();
		String emp_id = empid.getEmp_code();
		float total_credi_pl = 0;
		ArrayList<Employee_Attendance> emp_atte = (ArrayList<Employee_Attendance>) hibernatetemplate.find("from Employee_Attendance where emp_id=?",emp_id);
		for(int i=0;i<emp_atte.size();i++)
		{
			float pl = emp_atte.get(i).getCredited_pl();
			total_credi_pl = total_credi_pl + pl;
		}
 		return total_credi_pl;
	}


	@Override
	public float getCredited_Cl(Employee_Master empid) {
		// TODO Auto-generated method stub
		//int emp_id = empid.getEmp_id();
		String emp_id = empid.getEmp_code();
		float total_credi_cl = 0;
		ArrayList<Employee_Attendance> emp_atte = (ArrayList<Employee_Attendance>) hibernatetemplate.find("from Employee_Attendance where emp_id=?",emp_id);
		for(int i=0;i<emp_atte.size();i++)
		{
			float cl = emp_atte.get(i).getCredited_cl();
			total_credi_cl = total_credi_cl + cl;
		}
 		return total_credi_cl;
	}


	@Override
	public float getUtilized_Pl(Employee_Master empid) {
		// TODO Auto-generated method stub
		float utilized_pl = 0;
		/*ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernatetemplate.find("from LeaveRequest where emp_id=? and status=?",empid.getEmp_id(),"Approved");*/
		
		int year = Year.now().getValue();
		
		ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernatetemplate.find(
				"from LeaveRequest where emp_id = "+empid.getEmp_id()+" and status = 'Approved' and EXTRACT(YEAR FROM TO_DATE(APPLICATION_DATE, 'DD-MON-RR')) = "+year);
		
		for(int i=0;i<lr.size();i++)
		{
			int lr_id = lr.get(i).getLr_id();
			ArrayList<LeaveRequestLines> lrl = (ArrayList<LeaveRequestLines>) hibernatetemplate.find("from LeaveRequestLines where lr_id=?",lr_id);
			for(int j=0;j<lrl.size();j++)
			{
				int leavetype = lrl.get(j).getLeave_type();
				if(leavetype == 2)
				{
					float pl_count = lrl.get(j).getLeave_count();
					utilized_pl = utilized_pl + pl_count;
				}
			
			}
					
		}
		return utilized_pl;
	}


	@Override
	public float getUtilized_Cl(Employee_Master empid) {
		// TODO Auto-generated method stub
		float utilized_cl = 0;
		/*ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernatetemplate.find("from LeaveRequest where emp_id=? and status=?",empid.getEmp_id(),"Approved");*/
		
		int year = Year.now().getValue();
		
		ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernatetemplate.find(
				"from LeaveRequest where emp_id = "+empid.getEmp_id()+" and status = 'Approved' and EXTRACT(YEAR FROM TO_DATE(APPLICATION_DATE, 'DD-MON-RR')) = "+year);
		
		for(int i=0;i<lr.size();i++)
		{
			//String LR_status = lr.get(i).getStatus();
			int lr_id = lr.get(i).getLr_id();
			//if(LR_status.equals("Approved"))
			ArrayList<LeaveRequestLines> lrl = (ArrayList<LeaveRequestLines>) hibernatetemplate.find("from LeaveRequestLines where lr_id=?",lr_id);
			
			for(int j=0;j<lrl.size();j++)
			{
				int leavetype = lrl.get(j).getLeave_type();
				if(leavetype == 1)
				{
					float cl_count = lrl.get(j).getLeave_count();
					utilized_cl = utilized_cl + cl_count;
				}
			}
			
				
		}
		return utilized_cl;
	}


	@Override
	public float getPl_Balance(Employee_Master empid) {
		// TODO Auto-generated method stub
		float pl_balance = 0;
		ArrayList<LeaveBalance> lb = (ArrayList<LeaveBalance>) hibernatetemplate.find("from LeaveBalance where emp_id=?",empid.getEmp_id());
		if(lb.isEmpty()){
			pl_balance = 0;
		}else{
			pl_balance = lb.get(0).getPl();
		}
		
 		return pl_balance;
		
	}


	@Override
	public float getCl_Balance(Employee_Master empid) {
		// TODO Auto-generated method stub
		//float cl_balance = 0;
		float cl = 0;
		ArrayList<LeaveBalance> lb = (ArrayList<LeaveBalance>) hibernatetemplate.find("from LeaveBalance where emp_id=?",empid.getEmp_id());
		if(lb.isEmpty()){
			cl = 0;
		}else{
			cl = lb.get(0).getCl();
		}
		
 		return cl;
	}


	@Override
	public boolean updateEmployee(Employee_Master employee) {
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(employee);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return false;
	}


	@Override
	public List<Designation_Master> getdesignation1(String dept) {
		List<Designation_Master> YMS = new ArrayList<>();
		if(dept.equals("0")){
		
		
			//String[] year = dept.split(",");
			
			ArrayList<Department_Master> dm = (ArrayList<Department_Master>) hibernatetemplate.find("From Department_Master");      
			
			for(int i=0;i<dm.size();i++){
				
				
				
				String sql = "SELECT * FROM DESIGNATION_MASTER WHERE DEPARTMENT_ID = "+dm.get(i).getDepartment_id()+" ";
				
				List<Designation_Master> al = JdbcTemplate.query(sql, new RowMapper<Designation_Master>() {

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
				
				List<Designation_Master> al = JdbcTemplate.query(sql, new RowMapper<Designation_Master>() {

					
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
	public List<Joining_Details> getEmp1(String[] designation,String[] dept) {
		
		
		List<Joining_Details> YMS = new ArrayList<>();
		
		
		if(!designation[0].equals("0")){
		
		//String[] year = designation.split(",");
		for(int i=0;i<designation.length;i++){
			
			
			String sql = "SELECT * FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.EMP_ID = EM.EMP_ID AND  JD.DESIGNATION_ID = "+designation[i]+" ";
			
			
			List<Joining_Details> al = JdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

				
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
			if(dept[0].equals("0"))
			{
			ArrayList<Department_Master> dm = (ArrayList<Department_Master>) hibernatetemplate.find("From Department_Master");  
              for(int i=0;i<dm.size();i++){
				
				
				String sql = "SELECT * FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.EMP_ID = EM.EMP_ID AND  JD.DEPARTMENT_ID = "+dm.get(i).getDepartment_id()+" ";
				
				
				List<Joining_Details> al = JdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

					
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
			else
			{
			for(int i=0;i<dept.length;i++){
				
				
				String sql = "SELECT * FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.EMP_ID = EM.EMP_ID AND  JD.DEPARTMENT_ID = "+dept[i]+" ";
				
				
				List<Joining_Details> al = JdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

					
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
			
		}
		return YMS;
	}


	@Override
	public ArrayList<Employee_Master> getAllEmployee() {
		// TODO Auto-generated method stub
		ArrayList<Employee_Master> emp = (ArrayList<Employee_Master>) hibernatetemplate.find("from Employee_Master");
		return emp;
	}


	@Override
	public boolean save_Holidays(Holidays_Setup h_setup) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			
			tx = session.beginTransaction();
			session.save(h_setup);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return flag;
	}


	@Override
	public ArrayList getEmployeeByDept(String[] dept) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al1= new ArrayList<Integer>();
		for(int i=0;i<dept.length;i++)
		{
			int d_id = Integer.parseInt(dept[i]);
			ArrayList<Joining_Details> jd = (ArrayList<Joining_Details>) hibernatetemplate.find("from Joining_Details where department_id.department_id=?",d_id);
			for(int j=0;j<jd.size();j++)
			{
				al1.add(jd.get(j).getEmp_id().getEmp_id());
			}
		}
		return al1;
	}


	@Override
	public ArrayList getEmployeeByDesig(String[] desig) {
		ArrayList<Integer> al1= new ArrayList<Integer>();
		for(int i=0;i<desig.length;i++)
		{
			int d_id = Integer.parseInt(desig[i]);
			ArrayList<Joining_Details> jd = (ArrayList<Joining_Details>) hibernatetemplate.find("from Joining_Details where designation_id.designation_id=?",d_id);
			for(int j=0;j<jd.size();j++)
			{
				al1.add(jd.get(j).getEmp_id().getEmp_id());
			}
		}
		return al1;
	}


	@Override
	public int set_OTP_To_Change_password(String empcode,String OTP,int emp_id) {
		/*int doc = 0;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(employee);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}*/
		
		return 0;
	}


	@Override
	public boolean setNewPass(Employee_Master emp1) {
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(emp1);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return false;
	}
	
	public List<Employee_Master> getEmpCode(String empdata) {
		
		String query = "";
			
				query = "select emp_code, emp_first_name, emp_last_name, email from Employee_Master where emp_first_name ='"+empdata+"' or emp_last_name ='"+empdata+"'";
				
			
			List<Employee_Master> al = JdbcTemplate.query(query, new RowMapper<Employee_Master>() {

				
				public Employee_Master mapRow(ResultSet rs, int no) throws SQLException {
				
					Employee_Master aContact = new Employee_Master();
					
					aContact.setEmp_code(rs.getString("EMP_CODE"));
					aContact.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
					aContact.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
					aContact.setEmail(rs.getString("EMAIL"));
				
					return aContact;
				}
			});
			
		return  al;
	}


	@Override
	public Employee_Master empCodeCheck(String emp_code) {
		Employee_Master emp = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Employee_Master where emp_code = :empcode";
			Query sql = session.createQuery(query);
			sql.setParameter("empcode", emp_code);
			
			emp = (Employee_Master) sql.uniqueResult();
			
			return emp;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return emp;
	}


@Override
public ArrayList<ActiveDeactiveChartBar> getactivedeactive() {
	
			LocalDate today=LocalDate.now();
			
			int curyear = today.getYear();
			
			String date1="01-Jan-"+curyear;
			
			String lastDate1="31-Dec-"+curyear;
			
			int yearback1=curyear-1;
			
			String date2="01-Jan-"+yearback1;
			
			String lastDate2="31-Dec-"+yearback1;
			
			int yearback2=curyear-2;
			
			String date3="01-Jan-"+yearback2;
			
			String lastDate3="31-Dec-"+yearback2;
	
			int yearback3=curyear-3;
			
			String date4="01-Jan-"+yearback3;
			
			String lastDate4="31-Dec-"+yearback3;
			
			int yearback4=curyear-4;
			
			String date5="01-Jan-"+yearback4;
			
			String lastDate5="31-Dec-"+yearback4;
			
			
			
			String sql = "SELECT ACTIVE1,ACTIVE2,ACTIVE3,ACTIVE4,ACTIVE5,DEACTIVE1,DEACTIVE2,DEACTIVE3,DEACTIVE4,DEACTIVE5 FROM "
					+ "(SELECT COUNT(JD.JOINING_DATE) AS ACTIVE1 FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.JOINING_DATE < TO_DATE('"+lastDate1+"')"
					+"AND EM.IS_ACTIVATED='Y' AND EM.EMP_DEACT_DATE IS NULL AND EM.EMP_ID = JD.EMP_ID),(SELECT COUNT(EMP.EMP_DEACT_DATE) AS DEACTIVE1 FROM EMPLOYEE_MASTER EMP WHERE "
					+ "EMP.EMP_DEACT_DATE BETWEEN TO_DATE('"+date1+"') AND TO_DATE('"+lastDate1+"') AND EMP.IS_ACTIVATED='N'),"
					+ "(SELECT COUNT(JD.JOINING_DATE) AS ACTIVE2 FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.JOINING_DATE < TO_DATE('"+lastDate2+"')"
					+"AND EM.IS_ACTIVATED='Y' AND EM.EMP_DEACT_DATE IS NULL AND EM.EMP_ID = JD.EMP_ID),(SELECT COUNT(EMP.EMP_DEACT_DATE) AS DEACTIVE2 FROM EMPLOYEE_MASTER EMP WHERE "
					+ "EMP.EMP_DEACT_DATE BETWEEN TO_DATE('"+date2+"') AND TO_DATE('"+lastDate2+"') AND EMP.IS_ACTIVATED='N'),"
					+ "(SELECT COUNT(JD.JOINING_DATE) AS ACTIVE3 FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.JOINING_DATE < TO_DATE('"+lastDate3+"')"
					+"AND EM.IS_ACTIVATED='Y' AND EM.EMP_DEACT_DATE IS  NULL AND EM.EMP_ID = JD.EMP_ID),(SELECT COUNT(EMP.EMP_DEACT_DATE) AS DEACTIVE3 FROM EMPLOYEE_MASTER EMP WHERE "
					+ "EMP.EMP_DEACT_DATE BETWEEN TO_DATE('"+date3+"') AND TO_DATE('"+lastDate3+"') AND EMP.IS_ACTIVATED='N'),"
					+ "(SELECT COUNT(JD.JOINING_DATE) AS ACTIVE4 FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.JOINING_DATE < TO_DATE('"+lastDate4+"')"
					+"AND EM.IS_ACTIVATED='Y' AND EM.EMP_DEACT_DATE IS  NULL AND EM.EMP_ID = JD.EMP_ID),(SELECT COUNT(EMP.EMP_DEACT_DATE) AS DEACTIVE4 FROM EMPLOYEE_MASTER EMP WHERE "
					+ "EMP.EMP_DEACT_DATE BETWEEN TO_DATE('"+date4+"') AND TO_DATE('"+lastDate4+"') AND EMP.IS_ACTIVATED='N'),"
					+ "(SELECT COUNT(JD.JOINING_DATE) AS ACTIVE5 FROM JOINING_DETAILS JD,EMPLOYEE_MASTER EM WHERE JD.JOINING_DATE< TO_DATE('"+lastDate5+"')"
		            +"AND EM.IS_ACTIVATED='Y' AND EM.EMP_DEACT_DATE IS  NULL AND EM.EMP_ID = JD.EMP_ID),(SELECT COUNT(EMP.EMP_DEACT_DATE) AS DEACTIVE5 FROM EMPLOYEE_MASTER EMP WHERE "
					+ "EMP.EMP_DEACT_DATE BETWEEN TO_DATE('"+date5+"') AND TO_DATE('"+lastDate5+"') AND EMP.IS_ACTIVATED='N' )";	
			
			List<ActiveDeactiveChartBar> dml = JdbcTemplate.query(sql, new RowMapper<ActiveDeactiveChartBar>() {			
				@Override			
				public ActiveDeactiveChartBar mapRow(ResultSet rs, int rowNum) throws SQLException {
					ActiveDeactiveChartBar aContact = new ActiveDeactiveChartBar();
					
					aContact.setYear1(curyear);	//2020
					aContact.setYear2(yearback1);//2019
					aContact.setYear3(yearback2);//2018
					aContact.setYear4(yearback3);//2017
					aContact.setYear5(yearback4);//2016
					
					aContact.setActive1(rs.getInt("ACTIVE1"));
					aContact.setActive2(rs.getInt("ACTIVE2"));
					aContact.setActive3(rs.getInt("ACTIVE3"));
					aContact.setActive4(rs.getInt("ACTIVE4"));
					aContact.setActive5(rs.getInt("ACTIVE5"));
					
					aContact.setDeactive1(rs.getInt("DEACTIVE1"));
					aContact.setDeactive2(rs.getInt("DEACTIVE2"));
					aContact.setDeactive3(rs.getInt("DEACTIVE3"));
					aContact.setDeactive4(rs.getInt("DEACTIVE4"));
					aContact.setDeactive5(rs.getInt("DEACTIVE5"));
					
					return aContact;	
			}	

				
		});
		
		return (ArrayList<ActiveDeactiveChartBar>) dml;
	}


@Override
public List<PendingApprovals> getleavenotificationList(Employee_Master emp) {
	// TODO Auto-generated method stub
	List<PendingApprovals> pendingApprovals = new ArrayList<PendingApprovals>();
	
	String sql = "";
	
	if(trainingService.isFunctionalReporter(emp.getEmp_id()))
	{
//		List<PendingApprovals> pendingApprovalForFunctional = leaveService.getPendingApproverPendingLeavesForFunctional(emp);
//		
//		pendingApproval.addAll(pendingApprovalForFunctional);
		sql="SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN," 
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+emp.getEmp_id()+" and LN.APPROVER_TYPE = 'Functional' and LRL.STATUS = 'Pending for FR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
//		 System.out.println("inside functional notification sql is ==> "+sql);
		 
		 List<PendingApprovals> pendingApproval =  JdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

				@Override
				public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					PendingApprovals pendingApprovals=new PendingApprovals();
					pendingApprovals.setLr_id(rs.getInt("LR_ID"));
					
					pendingApprovals.setLr_no(rs.getInt("LR_NO"));
					pendingApprovals.setEmp_code(rs.getString("EMP_CODE"));
					pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
					pendingApprovals.setStart_date(rs.getString("START_DATE"));
					pendingApprovals.setEnd_date(rs.getString("END_DATE"));
					pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
					pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
					pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
					pendingApprovals.setSubject(rs.getString("SUBJECT"));
					return pendingApprovals;
				}
				
				
			});
		
		 pendingApprovals.addAll(pendingApproval);
	}
	if(trainingService.isAdministrativeReporter(emp.getEmp_id()))
	{
//		List<PendingApprovals> pendingApprovalForAdministartive = leaveService.getPendingApproverPendingLeavesForAdministrative(emp);
//		pendingApproval.addAll(pendingApprovalForAdministartive);
		
			sql="SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN," 
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+emp.getEmp_id()+" and LN.APPROVER_TYPE = 'Administrative' and LRL.STATUS = 'Pending for AR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
			
//			System.out.println("inside functional notification sql is ==> "+sql);
			 List<PendingApprovals> pendingApproval =  JdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

					@Override
					public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
					
						PendingApprovals pendingApprovals=new PendingApprovals();
						pendingApprovals.setLr_id(rs.getInt("LR_ID"));
					
						pendingApprovals.setLr_no(rs.getInt("LR_NO"));
						pendingApprovals.setEmp_code(rs.getString("EMP_CODE"));
						pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
						pendingApprovals.setStart_date(rs.getString("START_DATE"));
						pendingApprovals.setEnd_date(rs.getString("END_DATE"));
						pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
						pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
						pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
						pendingApprovals.setSubject(rs.getString("SUBJECT"));
						return pendingApprovals;
					}
				});
			 
			 pendingApprovals.addAll(pendingApproval);
		
	}
	if(emp.getEmp_id() == 46)
	{
//		List<PendingApprovals> pendingApprovalForManagement = leaveService.getPendingApproverPendingLeavesForManagement(emp.getEmp_id());
//		
//		
//		pendingApproval.addAll(pendingApprovalForManagement);
		
		 sql= "SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				  + "LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
				  + "LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT"
				  + " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID"
				  + " AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND"
				  + " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+emp.getEmp_id()+" and LN.APPROVER_TYPE = 'Management' and LRL.STATUS = 'Pending for MG Approval'"
				  + " AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		 
//		 System.out.println("inside functional notification sql is ==> "+sql);
		 List<PendingApprovals> pendingApproval =  JdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

				@Override
				public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					PendingApprovals pendingApprovals=new PendingApprovals();
					pendingApprovals.setLr_id(rs.getInt("LR_ID"));
					pendingApprovals.setLr_no(rs.getInt("LR_NO"));
					pendingApprovals.setEmp_code(rs.getString("EMP_CODE"));
					pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
					pendingApprovals.setStart_date(rs.getString("START_DATE"));
					pendingApprovals.setEnd_date(rs.getString("END_DATE"));
					pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
					pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
					pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
					pendingApprovals.setSubject(rs.getString("SUBJECT"));
					return pendingApprovals;
				}
				
				
			});
		 
		 pendingApprovals.addAll(pendingApproval);
		
	}
	
	
	return pendingApprovals;
}





@Scheduled(cron = "0 0 9 * * ?")
public void updateLeaveAsPerTimeline() throws MessagingException
{
	System.out.println("Inside updateLeaveAsPerTimeline");
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	Date applicationDate , applicationDate1 = null ,currentDate1 = null ;
	
	String applDate,curDate,application_date = null,start_date = null ,end_date= null;
	
	DateFormat cre12 = new SimpleDateFormat("dd-MM-yyyy");
	
	ArrayList<LeaveRequest> functionalleaveRequests = (ArrayList<LeaveRequest>) hibernatetemplate.find("from LeaveRequest where status='Pending for FR Approval'");
	
	ArrayList<TimeLineStructure> timeline = (ArrayList<TimeLineStructure>) hibernatetemplate.find("from TimeLineStructure");
	
	if(functionalleaveRequests.size() > 0)
	{
		for(int i=0;i<functionalleaveRequests.size();i++)
		{
			int lr_no = functionalleaveRequests.get(i).getLr_no();
			
			applicationDate = functionalleaveRequests.get(i).getApplication_date();
			
			Date currentDate = new Date();
			
			applDate = formatter.format(applicationDate);
			
			curDate = formatter.format(currentDate);
			
			try
			{
				applicationDate1 = formatter.parse(applDate);
				
				currentDate1 = formatter.parse(curDate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			long diff = currentDate1.getTime() - applicationDate1.getTime();
			
			int daysDiff = (int) (diff / (24 * 60 * 60 * 1000));
			
//		    long daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
			if(daysDiff > timeline.get(0).getFunctional())
			{
				
				ArrayList<LeaveNotifications> functionalleaveNotifications = (ArrayList<LeaveNotifications>) hibernatetemplate.find("from LeaveNotifications ln where ln.lr_id ="+lr_no+"and ln.approver_type ='Functional'");
				
				Iterator<LeaveNotifications> itr = functionalleaveNotifications.iterator();
				
				while (itr.hasNext())
				{
					LeaveNotifications leave = itr.next();
		    		
		    		leave.setStatus("Decision Not Taken");
		    		
		    		leave.setLast_updated_date(new Date());
		    		
		    		boolean flag = leaveService.updateLeaveNotifications(leave);
		    		
		   
				}
				
				functionalleaveRequests.get(i).setStatus("Pending for AR Approval");
				
				boolean flag = leaveService.updateLeaveRequest(functionalleaveRequests.get(i));
				
			} // end of if(daysDiff > timeline.get(0).getFunctional())
		} // end of for(int i=0;i<leaveRequests.size();i++)
	} // if(functionalleaveRequests.size() > 0)
	
	ArrayList<LeaveRequest> leaveRequestsAr = (ArrayList<LeaveRequest>) hibernatetemplate.find("from LeaveRequest where status='Pending for AR Approval'");
	
	if(leaveRequestsAr.size() > 0)
	{
		for(int i=0;i<leaveRequestsAr.size();i++)
		{
			int lr_no = leaveRequestsAr.get(i).getLr_no();
			
			ArrayList<LeaveNotifications> managementNotifications = (ArrayList<LeaveNotifications>) hibernatetemplate.find("from LeaveNotifications where lr_id.lr_no = " + lr_no
					+ " and status='Pending for approval' and approver_type = 'Management'");
			
			applicationDate = leaveRequestsAr.get(i).getApplication_date();
			
			Date currentDate = new Date();
			
			applDate = formatter.format(applicationDate);
			
			curDate = formatter.format(currentDate);
			
			try
			{
				applicationDate1 = formatter.parse(applDate);
				
				currentDate1 = formatter.parse(curDate);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			long diff = currentDate1.getTime() - applicationDate1.getTime();
			
			int daysDiff = (int) (diff / (24 * 60 * 60 * 1000));
			
//		    long daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
			if(daysDiff > timeline.get(0).getAdministrative())
			{
				ArrayList<LeaveNotifications> leaveNotificationsArs = (ArrayList<LeaveNotifications>) hibernatetemplate.find("from LeaveNotifications ln where ln.lr_id ="+lr_no+"and ln.approver_type ='Administrative'");
				
				
				
				if(leaveNotificationsArs.size() > 0 && managementNotifications.size() > 0)
				{
					Iterator<LeaveNotifications> itr1 = leaveNotificationsArs.iterator();
					
					while (itr1.hasNext())
					{
						LeaveNotifications leave = itr1.next();
    					
    					leave.setStatus("Decision Not Taken");
    					
    					leave.setLast_updated_date(new Date());
    					
    					boolean flag = leaveService.updateLeaveNotifications(leave);
					}
					
					leaveRequestsAr.get(i).setStatus("Pending for MG Approval");
					
					boolean flag = leaveService.updateLeaveRequest(leaveRequestsAr.get(i));
				}
				
				
			}
			
			
		} // end of for(int i=0;i<leaveRequestsAr.size();i++)
	} // if(leaveRequestsAr.size() > 0)
	
	

}


@Override
public String getAlphaNumericString(int n) 
	{
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz"; 

			// create StringBuffer size of AlphaNumericString 
			StringBuilder sb = new StringBuilder(n); 
			
			for (int i = 0; i < n; i++) { 
			
			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index 
			= (int)(AlphaNumericString.length() 
			* Math.random()); 
			
			// add Character one by one in end of sb 
			sb.append(AlphaNumericString 
			  .charAt(index)); 
			} 
			
			return sb.toString(); 
	}


@Override
public <T> T updateMyEntity(T t) {
	
	Session session = hibernatetemplate.getSessionFactory().openSession();
	
	Transaction tx = null;
	try
	{
		tx = session.beginTransaction();
		session.saveOrUpdate(t);
		return t;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		tx.commit();
		session.close();
		System.gc();
	}
	return t;
}
		@Scheduled(cron = "0 30 19 * * ?")
       public void sendDailyReportOfTrainingPlan() throws AddressException, MessagingException 
		{
			String mindsconnecturl = environment.getRequiredProperty("mindsconnecturl");
		    String sql = "select * from TRAINING_SHEET_MASTER where LAST_UPDATE_DATE like current_date";
			
			List<Training_Master> dml2 = JdbcTemplate.query(sql, new RowMapper<Training_Master>(){
		
				@Override
				public Training_Master mapRow(ResultSet rs, int rownum) throws SQLException {
					Training_Master trmasterAd = new Training_Master();
					int traineeid = rs.getInt("TRAINEE_ID");
					int trainerid = rs.getInt("TRAINER_ID");
					Employee_Master traineeIdobj = trainingService.getEmployee(traineeid);
					Employee_Master trainerIdobj = trainingService.getEmployee(trainerid);
					Compentency_Group comp_gr = trainingDaoImpl.getCompentencyGroup(rs.getInt("COMP_GR_ID"));
					trmasterAd.setTr_id(rs.getInt("TR_ID"));
					trmasterAd.setSubject(rs.getString("SUBJECT"));
					trmasterAd.setTrainee_id(traineeIdobj);
					trmasterAd.setTrainer_id(trainerIdobj);
					trmasterAd.setComp_group(comp_gr);
					trmasterAd.setTr_code(rs.getString("TRAINING_CODE"));
					trmasterAd.setSubject(rs.getString("SUBJECT"));
					trmasterAd.setStatus(rs.getString("STATUS"));
					return trmasterAd;
				}
				
			});
			
			
			
			if(dml2.size() > 0)
			{
				
				for(int i=0;i<dml2.size();i++)
				{
					
					int tr_id = dml2.get(i).getTr_id();
					
					int trainee_id = dml2.get(i).getTrainee_id().getEmp_id();
					
					String filepath = trainingService.getTrainingPlanExcelFilePath(tr_id,environment);
					
					StringTokenizer tokens = new StringTokenizer(filepath, "\\"); 
					
					String filename = "";
					
					filename  = filepath.substring(filepath.lastIndexOf("\\") + 1);
					
					
					List<Functional_Reporting> frList = trainingDaoImpl.getFunctionalReporterList(trainee_id);
					List<Administrative_Reporting> adminList = trainingDaoImpl.getAdministrativeReporter(trainee_id);
					
					Administrative_Reporting admin = new Administrative_Reporting();
					
					admin = adminList.get(0);
					
					for(Functional_Reporting flist:frList)
					{
						if(flist.getFunctional_reporting_id().getEmp_id() == 47)
						{
							
						}
						else if(flist.getFunctional_reporting_id().getEmp_id() == admin.getAdministrative_reporting_id().getEmp_id())
						{
							
						}
						else
						{
							String frMessage = "<!DOCTYPE html>"
									+ "<html>"
									+ "<head>"
									
									+ "<style>"

									+ "table, th, td {"
									+ "border: 1px solid black;"
									+ "border-collapse: collapse;"
									+ "}"
									
									+ "th, td {"
									+ "padding: 5px;"
									+ "font-size:14px;"
									+ "font-family: Times New Roman, serif;"
									+ "}"
									
									+ "p {"
									+ "display: block;"
									+ "margin-top: 1em;"
									+ "margin-bottom: 1em;"
									+ "margin-left: 0;"
									+ "margin-right: 0;"
									+ "font-family: Times New Roman, serif;"
									+ "font-size:14px;"
									+ "}"
									
									+ "</style>"
									
									+ "</head>"
									
									+ "<body>"
									
									+ "<p>"
									
									+ "Dear "+flist.getFunctional_reporting_id().getEmp_first_name() +",<br><br>"
									+ "Please find attached herewith a status of following Training Plan:<br><br>"
									
									+ "<table>"
									
									+ "<tr>"
									+ "<td>Training Code:</td>"
									+ "<td><b>"+dml2.get(i).getTr_code()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Training Title</td>"
									+ "<td><b>"+dml2.get(i).getSubject()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Trainee: </td>"
									+ "<td><b>"+dml2.get(i).getTrainee_id().getEmp_first_name()+" "+dml2.get(i).getTrainee_id().getEmp_last_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Trainer:</td>"
									+ "<td><b>"+dml2.get(i).getTrainer_id().getEmp_first_name()+" "+dml2.get(i).getTrainer_id().getEmp_last_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Competencies /Topic:</td>"
									+ "<td><b>"+dml2.get(i).getComp_group().getComp_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Status:</td>"
									+ "<td><b>"+dml2.get(i).getStatus()+"</b></td>"
									+ "</tr>"
									
									+ "</table>"
									+ "<br>"
									
									+ "Thanks & Regards,<br>"
									+ "Minds Connect Administrator<br>"
									
									+ "<br><br><br><br><br>"
									
									+ "Note : This is a system generated mail. Do not reply to this mail."
									+ "</body>"
									+ "</html>";
							
							
									RenewedMailCommunication Frmail= new RenewedMailCommunication();
									Frmail.setComm_type("Email");
									Frmail.setSub_type("Training Request");
									Frmail.setFrom_mail("helpdesk@omfysgroup.com");
									
									Frmail.setTo_mail(flist.getFunctional_reporting_id().getEmail());
									
									Frmail.setSubject("Training Status of "+dml2.get(i).getComp_group().getComp_name()+" for "+dml2.get(i).getTrainee_id().getEmp_first_name());
									Frmail.setBody(frMessage);
									Frmail.setStatus("Completed");
									Frmail.setCreated_by(flist.getFunctional_reporting_id().getEmp_id());
									Frmail.setLast_updated_by(flist.getFunctional_reporting_id().getEmp_id());
									
									mailService.sendMailWithAttachment(Frmail, filepath, filename);
									
									leaveService.saveRenewdMailCommunication(Frmail);
						}
					}
					
					if(admin.getAdministrative_reporting_id().getEmp_id() == 47)
					{
						
					}
					else
					{
						String adminMessage = "<!DOCTYPE html>"
								+ "<html>"
								+ "<head>"
								
								+ "<style>"

								+ "table, th, td {"
								+ "border: 1px solid black;"
								+ "border-collapse: collapse;"
								+ "}"
								
								+ "th, td {"
								+ "padding: 5px;"
								+ "font-size:14px;"
								+ "font-family: Times New Roman, serif;"
								+ "}"
								
								+ "p {"
								+ "display: block;"
								+ "margin-top: 1em;"
								+ "margin-bottom: 1em;"
								+ "margin-left: 0;"
								+ "margin-right: 0;"
								+ "font-family: Times New Roman, serif;"
								+ "font-size:14px;"
								+ "}"
								
								+ "</style>"
								
								+ "</head>"
								
								+ "<body>"
								
								+ "<p>"
								
								+ "Dear "+admin.getAdministrative_reporting_id().getEmp_first_name() +",<br><br>"
								+ "Please find attached herewith a status of following Training Plan  :<br><br>"
								
								+ "<table>"
								
								+ "<tr>"
								+ "<td>Training Code:</td>"
								+ "<td><b>"+dml2.get(i).getTr_code()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>Training Title</td>"
								+ "<td><b>"+dml2.get(i).getSubject()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>Trainee: </td>"
								+ "<td><b>"+dml2.get(i).getTrainee_id().getEmp_first_name()+" "+dml2.get(i).getTrainee_id().getEmp_last_name()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>Trainer:</td>"
								+ "<td><b>"+dml2.get(i).getTrainer_id().getEmp_first_name()+" "+dml2.get(i).getTrainer_id().getEmp_last_name()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>Competencies /Topic:</td>"
								+ "<td><b>"+dml2.get(i).getComp_group().getComp_name()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>Status:</td>"
								+ "<td><b>"+dml2.get(i).getStatus()+"</b></td>"
								+ "</tr>"
								
								+ "</table>"
								+ "<br>"
								
								+ "Thanks & Regards,<br>"
								+ "Minds Connect Administrator<br>"
								
								+ "<br><br><br><br><br>"
								
								+ "Note : This is a system generated mail. Do not reply to this mail."
								+ "</body>"
								+ "</html>";
						
						
								RenewedMailCommunication adminmail= new RenewedMailCommunication();
								adminmail.setComm_type("Email");
								adminmail.setSub_type("Training Request");
								adminmail.setFrom_mail("helpdesk@omfysgroup.com");
								adminmail.setTo_mail(admin.getAdministrative_reporting_id().getEmail());
								adminmail.setSubject("Training Status of "+dml2.get(i).getComp_group().getComp_name()+" for "+dml2.get(i).getTrainee_id().getEmp_first_name());
								adminmail.setBody(adminMessage);
								adminmail.setStatus("Completed");
								adminmail.setCreated_by(admin.getAdministrative_reporting_id().getEmp_id());
								adminmail.setLast_updated_by(admin.getAdministrative_reporting_id().getEmp_id());
								
								mailService.sendMailWithAttachment(adminmail, filepath, filename);
								
								leaveService.saveRenewdMailCommunication(adminmail);

					}
					
					// mail send to hr 
					
					String hrMessage = "<!DOCTYPE html>"
							+ "<html>"
							+ "<head>"
							
							+ "<style>"

							+ "table, th, td {"
							+ "border: 1px solid black;"
							+ "border-collapse: collapse;"
							+ "}"
							
							+ "th, td {"
							+ "padding: 5px;"
							+ "font-size:14px;"
							+ "font-family: Times New Roman, serif;"
							+ "}"
							
							+ "p {"
							+ "display: block;"
							+ "margin-top: 1em;"
							+ "margin-bottom: 1em;"
							+ "margin-left: 0;"
							+ "margin-right: 0;"
							+ "font-family: Times New Roman, serif;"
							+ "font-size:14px;"
							+ "}"
							
							+ "</style>"
							
							+ "</head>"
							
							+ "<body>"
							
							+ "<p>"
							
							+ "Dear Sachin,<br><br>"
							+ "Please find attached herewith a status of following Training Plan:<br><br>"
							
							+ "<table>"
							
							+ "<tr>"
							+ "<td>Training Code:</td>"
							+ "<td><b>"+dml2.get(i).getTr_code()+"</b></td>"
							+ "</tr>"
							
							+ "<tr>"
							+ "<td>Training Title</td>"
							+ "<td><b>"+dml2.get(i).getSubject()+"</b></td>"
							+ "</tr>"
							
							+ "<tr>"
							+ "<td>Trainee: </td>"
							+ "<td><b>"+dml2.get(i).getTrainee_id().getEmp_first_name()+" "+dml2.get(i).getTrainee_id().getEmp_last_name()+"</b></td>"
							+ "</tr>"
							
							+ "<tr>"
							+ "<td>Trainer:</td>"
							+ "<td><b>"+dml2.get(i).getTrainer_id().getEmp_first_name()+" "+dml2.get(i).getTrainer_id().getEmp_last_name()+"</b></td>"
							+ "</tr>"
							
							+ "<tr>"
							+ "<td>Competencies /Topic:</td>"
							+ "<td><b>"+dml2.get(i).getComp_group().getComp_name()+"</b></td>"
							+ "</tr>"
							
							+ "<tr>"
							+ "<td>Status:</td>"
							+ "<td><b>"+dml2.get(i).getStatus()+"</b></td>"
							+ "</tr>"
							
							+ "</table>"
							+ "<br>"
							
							+ "Thanks & Regards,<br>"
							+ "Minds Connect Administrator<br>"
							
							+ "<br><br><br><br><br>"
							
							+ "Note : This is a system generated mail. Do not reply to this mail."
							+ "</body>"
							+ "</html>";
					
					
							RenewedMailCommunication hrmail= new RenewedMailCommunication();
							hrmail.setComm_type("Email");
							hrmail.setSub_type("Training Request");
							hrmail.setFrom_mail("helpdesk@omfysgroup.com");
							
							hrmail.setTo_mail("sachin.khutwad@omfysgroup.com");
							
							hrmail.setSubject("Training Status of "+dml2.get(i).getComp_group().getComp_name()+" for "+dml2.get(i).getTrainee_id().getEmp_first_name());
							hrmail.setBody(hrMessage);
							hrmail.setStatus("Completed");
							hrmail.setCreated_by(6);
							hrmail.setLast_updated_by(6);
							
							
							mailService.sendMailWithAttachment(hrmail, filepath, filename);
							
							leaveService.saveRenewdMailCommunication(hrmail);
							
							
							// mail send to Babu Sir
							
							String headMessage = "<!DOCTYPE html>"
									+ "<html>"
									+ "<head>"
									
									+ "<style>"

									+ "table, th, td {"
									+ "border: 1px solid black;"
									+ "border-collapse: collapse;"
									+ "}"
									
									+ "th, td {"
									+ "padding: 5px;"
									+ "font-size:14px;"
									+ "font-family: Times New Roman, serif;"
									+ "}"
									
									+ "p {"
									+ "display: block;"
									+ "margin-top: 1em;"
									+ "margin-bottom: 1em;"
									+ "margin-left: 0;"
									+ "margin-right: 0;"
									+ "font-family: Times New Roman, serif;"
									+ "font-size:14px;"
									+ "}"
									
									+ "</style>"
									
									+ "</head>"
									
									+ "<body>"
									
									+ "<p>"
									
									+ "Dear Babu,<br><br>"
									+ "Please find attached herewith a status of following Training Plan:<br><br>"
									
									+ "<table>"
									
									+ "<tr>"
									+ "<td>Training Code:</td>"
									+ "<td><b>"+dml2.get(i).getTr_code()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Training Title</td>"
									+ "<td><b>"+dml2.get(i).getSubject()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Trainee: </td>"
									+ "<td><b>"+dml2.get(i).getTrainee_id().getEmp_first_name()+" "+dml2.get(i).getTrainee_id().getEmp_last_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Trainer:</td>"
									+ "<td><b>"+dml2.get(i).getTrainer_id().getEmp_first_name()+" "+dml2.get(i).getTrainer_id().getEmp_last_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Competencies /Topic:</td>"
									+ "<td><b>"+dml2.get(i).getComp_group().getComp_name()+"</b></td>"
									+ "</tr>"
									
									+ "<tr>"
									+ "<td>Status:</td>"
									+ "<td><b>"+dml2.get(i).getStatus()+"</b></td>"
									+ "</tr>"
									
									+ "</table>"
									+ "<br>"
									
									+ "Thanks & Regards,<br>"
									+ "Minds Connect Administrator<br>"
									
									+ "<br><br><br><br><br>"
									
									+ "Note : This is a system generated mail. Do not reply to this mail."
									+ "</body>"
									+ "</html>";
							
							
									RenewedMailCommunication headmail= new RenewedMailCommunication();
									headmail.setComm_type("Email");
									headmail.setSub_type("Training Request");
									headmail.setFrom_mail("helpdesk@omfysgroup.com");
									headmail.setTo_mail("babumadhavan@omfysgroup.com");
									headmail.setSubject("Training Status of "+dml2.get(i).getComp_group().getComp_name()+" for "+dml2.get(i).getTrainee_id().getEmp_first_name());
									headmail.setBody(headMessage);
									headmail.setStatus("Completed");
									headmail.setCreated_by(47);
									headmail.setLast_updated_by(47);
									
									mailService.sendMailWithAttachment(headmail, filepath, filename);
									
									leaveService.saveRenewdMailCommunication(headmail);
							
							File f1 = new File(filepath);
							f1.delete();
				}
			}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			
			
			 String sql1 = "select * from KT_PLAN_HEADER where LAST_UPDATED_DATE like current_date";
			
			List<KtPlan_Header> dml1 = JdbcTemplate.query(sql1, new RowMapper<KtPlan_Header>(){

				@Override
				public KtPlan_Header mapRow(ResultSet resultset, int number) throws SQLException {
					// TODO Auto-generated method stub
					KtPlan_Header ktlist = new KtPlan_Header();
					
					int ktgiverid = resultset.getInt("KT_GIVERS");
					Employee_Master ktgiverIdobj = exitModule.getEmployee(ktgiverid);
					ktlist.setKtHeaderId(resultset.getInt("KT_HEADERID"));
					ktlist.setKt_giverhead(ktgiverIdobj);
					ktlist.setKtstatushead(resultset.getString("KTSTATUS"));
					ktlist.setAdminid(resultset.getInt("ADMIN_ID"));
					return ktlist;
				    }
		            });
			
			
			    if(dml1.size() > 0){
				for(int i=0;i<dml1.size();i++)
				{
					
					int kthead_id = dml1.get(i).getKtHeaderId();
					
					int ktgiver = dml1.get(i).getKt_giverhead().getEmp_id();
				    
					int admin_id = dml1.get(i).getAdminid();
					
					String filepath = exitModule.getKtPlanExcelFilePath(kthead_id,environment);
					
					StringTokenizer tokens = new StringTokenizer(filepath, "\\"); 
					
					String filename = "";
					
					filename  = filepath.substring(filepath.lastIndexOf("\\") + 1);
					
					
					List<Administrative_Reporting> adminList = ExitModule_dao_imp.getAdministrativeReporter(ktgiver);
					
					Administrative_Reporting admin = adminList.get(0);
					
					if(adminList.get(i).getAdministrative_reporting_id().getEmp_id()==admin_id){
					  
					 
						String adminMessage = "<!DOCTYPE html>"
								+ "<html>"
								+ "<head>"
								
								+ "<style>"

								+ "table, th, td {"
								+ "border: 1px solid black;"
								+ "border-collapse: collapse;"
								+ "}"
								
								+ "th, td {"
								+ "padding: 5px;"
								+ "font-size:14px;"
								+ "font-family: Times New Roman, serif;"
								+ "}"
								
								+ "p {"
								+ "display: block;"
								+ "margin-top: 1em;"
								+ "margin-bottom: 1em;"
								+ "margin-left: 0;"
								+ "margin-right: 0;"
								+ "font-family: Times New Roman, serif;"
								+ "font-size:14px;"
								+ "}"
								
								+ "</style>"
								
								+ "</head>"
								
								+ "<body>"
								
								+ "<p>"
								
								+ "Dear "+admin.getAdministrative_reporting_id().getEmp_first_name() +",<br><br>"
								+ "Please find attached herewith a status of following Kt Plan  :<br><br>"
								
								+ "<table>"
								
								+ "<tr>"
								+ "<td>KT Giver:</td>"
								+ "<td><b>"+dml1.get(i).getKt_giverhead().getEmp_first_name()+"  "+dml1.get(i).getKt_giverhead().getEmp_last_name()+"</b></td>"
								+ "</tr>"
								
								+ "<tr>"
								+ "<td>KT Status</td>"
								+ "<td><b>"+dml1.get(i).getKtstatushead()+"</b></td>"
								+ "</tr>"
								
								
								+ "</table>"
								
								
								+ "<p>You are requested to please log in to <a href='"+mindsconnecturl+"/'>MindsConnect</a> application and Check the kt plan.<br><br><br>"
								+ "<br>"
								+ "Thanks & Regards,<br>"
								+ "Minds Connect Administrator<br>"
								
								+ "<br><br>"
								
								+ "Note : This is a system generated mail. Do not reply to this mail."
								+ "</body>"
								+ "</html>";
						
						
								RenewedMailCommunication adminmail= new RenewedMailCommunication();
								adminmail.setComm_type("Email");
								adminmail.setSub_type("Kt Request");
								adminmail.setFrom_mail("helpdesk@omfysgroup.com");
								
								adminmail.setTo_mail(admin.getAdministrative_reporting_id().getEmail());
								
							   // adminmail.setTo_mail("amit.k@omfysgroup.com");
							    
								adminmail.setSubject("Kt Plan Daily Reports");
								adminmail.setBody(adminMessage);
								adminmail.setStatus("Completed");
								adminmail.setCreated_by(admin.getAdministrative_reporting_id().getEmp_id());
								adminmail.setLast_updated_by(admin.getAdministrative_reporting_id().getEmp_id());
								
								mailService.sendMailWithAttachment(adminmail, filepath, filename);
								
								leaveService.saveRenewdMailCommunication(adminmail);

				       	}
					
					       // mail send to hr 
					
					      String hrMessage = "<!DOCTYPE html>"
							+ "<html>"
							+ "<head>"
							
							+ "<style>"

							+ "table, th, td {"
							+ "border: 1px solid black;"
							+ "border-collapse: collapse;"
							+ "}"
							
							+ "th, td {"
							+ "padding: 5px;"
							+ "font-size:14px;"
							+ "font-family: Times New Roman, serif;"
							+ "}"
							
							+ "p {"
							+ "display: block;"
							+ "margin-top: 1em;"
							+ "margin-bottom: 1em;"
							+ "margin-left: 0;"
							+ "margin-right: 0;"
							+ "font-family: Times New Roman, serif;"
							+ "font-size:14px;"
							+ "}"
							
							+ "</style>"
							
							+ "</head>"
							
							+ "<body>"
							
							+ "<p>"
							
							+ "Dear Sachin,<br><br>"
							+ "Please find attached herewith a status of following Kt Plan:<br><br>"
							
							+ "<table>"
							
                            + "<tr>"
                            + "<td>KT Giver:</td>"
                            + "<td><b>"+dml1.get(i).getKt_giverhead().getEmp_first_name()+"  "+dml1.get(i).getKt_giverhead().getEmp_last_name()+"</b></td>"
                            + "</tr>"

                            + "<tr>"
                            + "<td>KT Status</td>"
                            + "<td><b>"+dml1.get(i).getKtstatushead()+"</b></td>"
                            + "</tr>"
							
						
							+ "</table>"
							
							
							+ "<p>You are requested to please log in to <a href='"+mindsconnecturl+"/'>MindsConnect</a> application and approve Check the kt plan.<br><br><br>"
							+ "<br>"
							+ "Thanks & Regards,<br>"
							+ "Minds Connect Administrator<br>"
							
							+ "<br><br>"
							
							+ "Note : This is a system generated mail. Do not reply to this mail."
							+ "</body>"
							+ "</html>";
					
					
							RenewedMailCommunication hrmail= new RenewedMailCommunication();
							hrmail.setComm_type("Email");
							hrmail.setSub_type("Kt Request");
							hrmail.setFrom_mail("helpdesk@omfysgroup.com");
							
							hrmail.setTo_mail("sachin.khutwad@omfysgroup.com");
							
						//	hrmail.setTo_mail("amit.k@omfysgroup.com");
							hrmail.setSubject("Kt Plan Daily Reports");
							hrmail.setBody(hrMessage);
							hrmail.setStatus("Completed");
							hrmail.setCreated_by(6);
							hrmail.setLast_updated_by(6);
							
							
							mailService.sendMailWithAttachment(hrmail, filepath, filename);
							
							leaveService.saveRenewdMailCommunication(hrmail);
							
							File f1 = new File(filepath);
							f1.delete();
				}
			}
}


		@Override
		public String getSalt(int length) {
			StringBuilder returnValue = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	        }
	        return new String(returnValue);
		}


		@Override
		public byte[] hash(char[] password, byte[] salt) {
			PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
	        Arrays.fill(password, Character.MIN_VALUE);
	        try {
	            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	            return skf.generateSecret(spec).getEncoded();
	        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
	        } finally {
	            spec.clearPassword();
	        }
		}
		
		public String generateSecurePassword(String password, String salt) {
	        String returnValue = null;
	        
	        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
	 
	        returnValue = Base64.getEncoder().encodeToString(securePassword);
	 
	        return returnValue;
	    }
		
		 public boolean verifyUserPassword(String providedPassword,
		            String securedPassword, String salt)
		    {
		        boolean returnValue = false;
		        
		        // Generate New secure password with the same salt
		        String newSecurePassword = generateSecurePassword(providedPassword, salt);
		        
		        // Check if two passwords are equal
		        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
		        
		        return returnValue;
		    }


		

		@Override
		public ArrayList<CertificationCountDashboard> getCountDashboard() {
			String sql="Select Opens+In_Progress+Completed+On_Hold+Exam_Failed+Withdrawal as Assigned,Opens,In_Progress,"
                        +" Completed,On_Hold,Exam_Failed,Withdrawal FROM "
						+"(select COUNT(CERTIFICATE_NAME) As Opens from ASSIGN_CERTIFICATION where STATUS='Open'),"
						+"(select COUNT(CERTIFICATE_NAME)As In_Progress from ASSIGN_CERTIFICATION where STATUS='In Progress'),"
						+"(select COUNT(CERTIFICATE_NAME)As Completed from ASSIGN_CERTIFICATION where STATUS='Completed' OR STATUS= 'Completed with Pass'),"
						+"(select COUNT(CERTIFICATE_NAME)As On_Hold from ASSIGN_CERTIFICATION where STATUS='On Hold'),"
						+"(select COUNT(CERTIFICATE_NAME)As Exam_Failed from ASSIGN_CERTIFICATION where STATUS='Exam Failed'),"
						+"(select COUNT(CERTIFICATE_NAME)As Withdrawal from ASSIGN_CERTIFICATION where STATUS='Withdrawn')";
		
			List<CertificationCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<CertificationCountDashboard>() {			
				@Override			
				public CertificationCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
					CertificationCountDashboard aContact = new CertificationCountDashboard();
					aContact.setAssigned(rs.getInt("Assigned"));
					aContact.setOpen(rs.getInt("Opens"));
					aContact.setIn_progressCer(rs.getInt("In_Progress"));
					aContact.setCompleted_cer(rs.getInt("Completed"));
					aContact.setOn_hold(rs.getInt("On_Hold"));
					aContact.setExam_failed(rs.getInt("Exam_Failed"));
					aContact.setWithdrawal(rs.getInt("Withdrawal"));
					  
			// TODO Auto-generated method stub
			       return aContact;
		      }
			
			  });
			   
			return (ArrayList<CertificationCountDashboard>) dml;
		}


		@Override
		public ArrayList<CertificationCountDashboard> getEmpCountDashboard(int empid) {
		String sql=" select OPEN_COUNT+IN_PROGRESS_COUNT+COMPLETED_COUNT+ON_HOLD_COUNT+EXAM_FAILED+WITHDRAWAL AS TOTAL_ASSINED ,OPEN_COUNT,IN_PROGRESS_COUNT,COMPLETED_COUNT,"
			       +" ON_HOLD_COUNT,EXAM_FAILED,WITHDRAWAL from"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) OPEN_COUNT FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS = 'Open'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) IN_PROGRESS_COUNT FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS = 'In Progress'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) COMPLETED_COUNT FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS IN('Completed','Completed with Pass')),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) ON_HOLD_COUNT FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS = 'On Hold'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) EXAM_FAILED FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS = 'Exam Failed'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_ID)) WITHDRAWAL FROM ASSIGN_CERTIFICATION WHERE (FR ="+empid+" OR EMPLOYEE_ID ="+empid+" OR AR ="+empid+") AND STATUS = 'Withdrawn')";
										
		List<CertificationCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<CertificationCountDashboard>() {			
			@Override			
			public CertificationCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
				CertificationCountDashboard aContact = new CertificationCountDashboard();
				aContact.setAssigned(rs.getInt("TOTAL_ASSINED"));
				aContact.setOpen(rs.getInt("OPEN_COUNT"));
				aContact.setIn_progressCer(rs.getInt("IN_PROGRESS_COUNT"));
				aContact.setCompleted_cer(rs.getInt("COMPLETED_COUNT"));
				aContact.setOn_hold(rs.getInt("ON_HOLD_COUNT"));
				aContact.setExam_failed(rs.getInt("EXAM_FAILED"));
				aContact.setWithdrawal(rs.getInt("WITHDRAWAL"));
				  
		
		       return aContact;
	      }
		
		  });
		   
		return  (ArrayList<CertificationCountDashboard>) dml;
		}


//		@Override
//		public ArrayList<CertificationCountDashboard> getFRCountDashboard(int fr_reporting) {
//			String sql="Select Opens+In_Progress+Completed+On_Hold+Exam_Failed+Withdrawal as Assigned,Opens,In_Progress,Completed,On_Hold,Exam_Failed,Withdrawal FROM"
//						+"(select COUNT(CERTIFICATE_NAME) As Opens from ASSIGN_CERTIFICATION where STATUS='Open' and FR="+fr_reporting+"),"
//						+"(select COUNT (CERTIFICATE_NAME)As In_Progress from ASSIGN_CERTIFICATION where STATUS='In Progress' and FR="+fr_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Completed from ASSIGN_CERTIFICATION where STATUS IN('Completed','Completed with Pass') and  FR="+fr_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As On_Hold from ASSIGN_CERTIFICATION where STATUS='On Hold' and  FR="+fr_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Exam_Failed from ASSIGN_CERTIFICATION where STATUS='Exam Failed'and  FR="+fr_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Withdrawal from ASSIGN_CERTIFICATION where STATUS='Withdrawal'and  FR="+fr_reporting+")";
//		
//			List<CertificationCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<CertificationCountDashboard>() {			
//				@Override			
//				public CertificationCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
//					CertificationCountDashboard aContact = new CertificationCountDashboard();
//					aContact.setAssigned(rs.getInt("Assigned"));
//					aContact.setOpen(rs.getInt("Opens"));
//					aContact.setIn_progressCer(rs.getInt("In_Progress"));
//					aContact.setCompleted_cer(rs.getInt("Completed"));
//					aContact.setOn_hold(rs.getInt("On_Hold"));
//					aContact.setExam_failed(rs.getInt("Exam_Failed"));
//					aContact.setWithdrawal(rs.getInt("Withdrawal"));
//					  
//			
//			       return aContact;
//		      }
//			
//			  });
//			   
//			return  (ArrayList<CertificationCountDashboard>) dml;
//		}
//
//
//		@Override
//		public ArrayList<CertificationCountDashboard> getARCountDashboard(int ar_reporting) {
//			String sql="Select Opens+In_Progress+Completed+On_Hold+Exam_Failed+Withdrawal as Assigned,Opens,In_Progress,Completed,On_Hold,Exam_Failed,Withdrawal FROM"
//						+"(select COUNT(CERTIFICATE_NAME) As Opens from ASSIGN_CERTIFICATION where STATUS='Open' and AR="+ar_reporting+"),"
//						+"(select COUNT (CERTIFICATE_NAME)As In_Progress from ASSIGN_CERTIFICATION where STATUS='In Progress' and AR="+ar_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Completed from ASSIGN_CERTIFICATION where STATUS IN('Completed','Completed with Pass') and  AR="+ar_reporting+" ),"
//						+"(select COUNT(CERTIFICATE_NAME)As On_Hold from ASSIGN_CERTIFICATION where STATUS='On Hold' and  AR="+ar_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Exam_Failed from ASSIGN_CERTIFICATION where STATUS='Exam Failed'and  AR="+ar_reporting+"),"
//						+"(select COUNT(CERTIFICATE_NAME)As Withdrawal from ASSIGN_CERTIFICATION where STATUS='Withdrawal'and  AR="+ar_reporting+")";
//	
//			List<CertificationCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<CertificationCountDashboard>() {			
//				@Override			
//				public CertificationCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
//					CertificationCountDashboard aContact = new CertificationCountDashboard();
//					aContact.setAssigned(rs.getInt("Assigned"));
//					aContact.setOpen(rs.getInt("Opens"));
//					aContact.setIn_progressCer(rs.getInt("In_Progress"));
//					aContact.setCompleted_cer(rs.getInt("Completed"));
//					aContact.setOn_hold(rs.getInt("On_Hold"));
//					aContact.setExam_failed(rs.getInt("Exam_Failed"));
//					aContact.setWithdrawal(rs.getInt("Withdrawal"));
//			
//			       return aContact;
//		      }
//			
//			  });
//			   
//			return  (ArrayList<CertificationCountDashboard>) dml;
//		}


		@Override
		public List<Administrative_Reporting> getAdministrativeReporter(int empid) {
			
			List<Administrative_Reporting> adminstrativeReporter = new ArrayList<Administrative_Reporting>();
			Session session = hibernatetemplate.getSessionFactory().openSession();
			Transaction tx = null;
			try {
			tx = session.beginTransaction();
			String query = "from Administrative_Reporting a where a.emp_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			adminstrativeReporter = sql.list();
			return adminstrativeReporter;
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			tx.commit();
			session.close();
			System.gc();
			}
			return adminstrativeReporter;
			}


		@Override
		public List<Functional_Reporting> getFunctionalReporter(int empid) {
			
			List<Functional_Reporting> functionalReporter = new ArrayList<Functional_Reporting>();
			Session session = hibernatetemplate.getSessionFactory().openSession();
			Transaction tx = null;
			try {
			tx = session.beginTransaction();
			String query = "from Functional_Reporting f where f.emp_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			functionalReporter = sql.list();
			return functionalReporter;

			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			tx.commit();
			session.close();
			System.gc();
			}
			return functionalReporter;
			}


		@Override
		public ArrayList<CertificationPercentageCal> getPercentageDashboard() {
			// TODO Auto-generated method stub
			String sql="select round((Open_Count/Total_Count * 100),2 )as Open_Count,round((In_Progress_count/Total_Count*100),2) as InProcess_Per,round((Complete_Count/Total_Count*100),2) as Complete_Count,"
                        +"round((OnHold_Count/Total_Count*100),2) as OnHold_Count,round((ExamFailed_Count/Total_Count*100),2) as ExamFailed_Count,round((Withdrawal_Count/Total_Count*100),2) as Withdrawal_Count from "
						+"(SELECT COUNT(STATUS) AS Open_Count FROM ASSIGN_CERTIFICATION where STATUS='Open'),"
						+"(SELECT COUNT(STATUS) AS In_Progress_count FROM ASSIGN_CERTIFICATION where STATUS='In Progress'),"
						+"(SELECT COUNT(STATUS) AS Complete_Count FROM ASSIGN_CERTIFICATION where STATUS IN ('Completed','Completed with Pass')),"
						+"(SELECT COUNT(STATUS) AS OnHold_Count FROM ASSIGN_CERTIFICATION where STATUS='On Hold'),"
						+"(SELECT COUNT(STATUS) AS ExamFailed_Count FROM ASSIGN_CERTIFICATION where STATUS='Exam Failed'),"
						+"(SELECT COUNT(STATUS) AS Withdrawal_Count FROM ASSIGN_CERTIFICATION where STATUS='Withdrawn'),"
						+"(SELECT COUNT(STATUS) AS Total_Count from  ASSIGN_CERTIFICATION)";
							
		List<CertificationPercentageCal> dml = JdbcTemplate.query(sql, new RowMapper<CertificationPercentageCal>() {			
			@Override			
			public CertificationPercentageCal mapRow(ResultSet rs, int rowNum) throws SQLException {
				CertificationPercentageCal aContact = new CertificationPercentageCal();
				
				aContact.setOpen(rs.getDouble("Open_Count"));
				aContact.setIn_progressCer(rs.getDouble("InProcess_Per"));
				aContact.setCompleted_cer(rs.getDouble("Complete_Count"));
				aContact.setOn_hold(rs.getDouble("OnHold_Count"));
				aContact.setExam_failed(rs.getDouble("ExamFailed_Count"));
				aContact.setWithdrawal(rs.getDouble("Withdrawal_Count"));
				  
		
		       return aContact;
	      }
		
		  });
		   
		return  (ArrayList<CertificationPercentageCal>) dml;
	}
		

		@Override
		public HashMap<String, Object> getTotalLeaveCount(Employee_Master loggedInUserId) {
			
			HashMap<String, Object> totalcount = new HashMap<String, Object>();
			
			ArrayList<ProbationRequest> probationRequest = new ArrayList<ProbationRequest>();
			
			int exitcount = 0;
			
			float total_credi_pl = 0 , total_credi_cl = 0  , total_utilized_pl = 0 , total_utilized_cl = 0 , pl_balance = 0 , cl_balance = 0;
			
			int year = Year.now().getValue();
			System.out.println("the year ====="+year);
			ArrayList<Document_Uploaded> payslips = (ArrayList<Document_Uploaded>) hibernatetemplate
					.find("from Document_Uploaded where emp_id.emp_id = " + loggedInUserId.getEmp_id()
							+ " and document_type_id.docs_type_id = 1");
			
			ArrayList<Document_Uploaded> other = (ArrayList<Document_Uploaded>) hibernatetemplate
					.find("from Document_Uploaded where emp_id.emp_id = " + loggedInUserId.getEmp_id()
							+ " and document_type_id.docs_type_id = 3");
			
			ArrayList<Common_Document_Uploaded> common = (ArrayList<Common_Document_Uploaded>) hibernatetemplate
					.find("from Common_Document_Uploaded");
			
			ArrayList<Joining_Details> trainee = (ArrayList<Joining_Details>) hibernatetemplate.find(
					"from Joining_Details where employee_status = 'Trainee' and emp_id.is_activated = 'Y'");
			
			ArrayList<Joining_Details> probation = (ArrayList<Joining_Details>) hibernatetemplate.find(
					"from Joining_Details where employee_status = 'Probation' and emp_id.is_activated = 'Y'");
			
			ArrayList<Joining_Details> confirmed = (ArrayList<Joining_Details>) hibernatetemplate.find(
					"from Joining_Details where employee_status = 'Confirmed' and emp_id.is_activated = 'Y'");
			
			ArrayList<MarkExitScreen> marked = (ArrayList<MarkExitScreen>) hibernatetemplate.find("from MarkExitScreen where emp_id = "+loggedInUserId.getEmp_id()+" and is_applicable = 'Y'");
			
			if(loggedInUserId.getProfile_id() == 6)
			{
				
				probationRequest = (ArrayList<ProbationRequest>) hibernatetemplate
						.find("from ProbationRequest where status = 'Pending for HR Approval'");
			}
			else 
			{
				probationRequest = (ArrayList<ProbationRequest>) hibernatetemplate
						.find("from ProbationRequest where ar_id.emp_id = " + loggedInUserId.getEmp_id() + ""
								+ " and status = 'Pending for AR Approval'");
			}
			
			ArrayList<Employee_Attendance> emp_atte = (ArrayList<Employee_Attendance>) hibernatetemplate.find("from Employee_Attendance where emp_id=?",loggedInUserId.getEmp_code());
			
//			ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernatetemplate.find(
//					"from LeaveRequest where emp_id = "+loggedInUserId.getEmp_id()+" and status = 'Approved' and EXTRACT(YEAR FROM TO_DATE(APPLICATION_DATE, 'DD-MON-RR')) ="+year);
//			
			
			String sql="SELECT * FROM LEAVE_REQUEST WHERE EMP_ID="+loggedInUserId.getEmp_id()+" AND STATUS='Approved' AND to_char(APPLICATION_DATE,'yyyy') = to_char(sysdate,'yyyy')";
			
			List<LeaveRequest> lr = JdbcTemplate.query(sql, new RowMapper<LeaveRequest>() {			
				@Override			
				public LeaveRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
					LeaveRequest aContact = new LeaveRequest();
					
					aContact.setLr_no(rs.getInt("LR_NO"));
					aContact.setLr_id(rs.getInt("LR_ID"));
					aContact.setEmp_id(rs.getInt("EMP_ID"));
					aContact.setSubject(rs.getString("SUBJECT"));
					aContact.setApplication_date(rs.getDate("APPLICATION_DATE"));
					aContact.setStatus(rs.getString("STATUS"));
					aContact.setCreation_date(rs.getDate("CREATION_DATE"));
					aContact.setCreated_by(rs.getInt("CREATED_BY"));
					aContact.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
					aContact.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
					aContact.setFunctional_comment(rs.getString("FUNCTIONAL_COMMENT"));
					aContact.setAdministrative_comment(rs.getString("ADMINISTRATIVE_COMMENT"));
					aContact.setManagement_comment(rs.getString("MANAGEMENT_COMMENT"));
					
			       return aContact;
		      }
			
			  });
			ArrayList<LeaveBalance> lb = (ArrayList<LeaveBalance>) hibernatetemplate.find("from LeaveBalance where emp_id=?",loggedInUserId.getEmp_id());
			
			for(int i=0;i<emp_atte.size();i++)
			{
				float pl = emp_atte.get(i).getCredited_pl();
				total_credi_pl = total_credi_pl + pl;
				
				float cl = emp_atte.get(i).getCredited_cl();
				total_credi_cl = total_credi_cl + cl;
			}
			
			for(int i=0;i<lr.size();i++)
			{
				int lr_id = lr.get(i).getLr_id();
				ArrayList<LeaveRequestLines> lrl = (ArrayList<LeaveRequestLines>) hibernatetemplate.find("from LeaveRequestLines where lr_id=?",lr_id);
				
				for(int j=0;j<lrl.size();j++)
				{
					int leavetype = lrl.get(j).getLeave_type();
					if(leavetype == 2)
					{
						float pl_count = lrl.get(j).getLeave_count();
						total_utilized_pl = total_utilized_pl + pl_count;
					}
					
					if(leavetype == 1)
					{
						float cl_count = lrl.get(j).getLeave_count();
						total_utilized_cl = total_utilized_cl + cl_count;
					}
				}
			}
			
			if(lb.isEmpty()){
				pl_balance = 0;
				cl_balance = 0;
			}else{
				pl_balance = lb.get(0).getPl();
				cl_balance = lb.get(0).getCl();
			}
			
			total_credi_pl=pl_balance+total_utilized_pl;
			
			total_credi_cl=cl_balance+total_utilized_cl;
			
			totalcount.put("payslipscount", payslips.size());
			
			totalcount.put("otherdocumentcount", other.size());
			
			totalcount.put("commondocumentcount", common.size());
			
			totalcount.put("traineecount", trainee.size());
			
			totalcount.put("probationcount", probation.size());
			
			totalcount.put("confirmedcount", confirmed.size());
			
			totalcount.put("probationrequestcount", probationRequest.size());
			
			totalcount.put("creditedpl", total_credi_pl);
			
			totalcount.put("creditedcl", total_credi_cl);
			
			totalcount.put("utilizedpl", total_utilized_pl);
			
			totalcount.put("utilizedcl", total_utilized_cl);
			
			totalcount.put("plbalance", pl_balance);
			
			totalcount.put("clbalance", cl_balance);
			
			totalcount.put("exitcount", marked.size());
			
			return totalcount;
		}


		@Override
		public HashMap<Object, ? super List> getTotalData(Employee_Master loggedInUserId) {
			
			ArrayList<MarkExitScreen> marked = new ArrayList<MarkExitScreen>();
			
			ArrayList<ProbationRequest> probationrequest = new ArrayList<ProbationRequest>();
			
			HashMap<Object, ? super List> m = new HashMap<Object, List>(); 
			
			String sql = "SELECT IS_APPLICABLE,EMP_ID,EMPLOYEE_NAME,EXIT_TYPE FROM MARK_EXIT_SCREEN WHERE EMP_ID ="+ loggedInUserId.getEmp_id()
			+ " AND IS_APPLICABLE = 'Y'";
		    
//		    String sql = "SELECT IS_APPLICABLE,EMP_ID,EMPLOYEE_NAME,EXIT_TYPE FROM MARK_EXIT_SCREEN WHERE EMP_ID = 61 AND IS_APPLICABLE = 'Y'";
		    
		    marked =  (ArrayList<MarkExitScreen>) JdbcTemplate.query(sql, new RowMapper<MarkExitScreen>() {
				@Override
				public MarkExitScreen mapRow(ResultSet rs, int numRow) throws SQLException {
					MarkExitScreen marks = new MarkExitScreen();
					Employee_Master emp =new Employee_Master();
					 emp.setEmp_id(rs.getInt("EMP_ID"));
					 marks.setEmp_id(emp);
					 marks.setIs_applicable(rs.getString("IS_APPLICABLE"));
					 marks.setEmployee(rs.getString("EMPLOYEE_NAME"));
					 marks.setExittype(rs.getString("EXIT_TYPE"));
					return marks;
				}
				
			});
		     
		    String sql1= "SELECT K.KT_GIVERS as KT_GIVER, K.AR_NOS as AR_NOS ,K.KTSTATUS as KTSTATUS ,P.AR_NO as AR_NO ,P.ADMINISTRATIVE_REPORTING_ID as ADMINISTRATIVE_REPORTING_ID ,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME"
						+" FROM KT_PLAN_HEADER K ,ADMINISTRATIVE_REPORTING P ,EMPLOYEE_MASTER EM  WHERE P.AR_NO =K.AR_NOS "   
						+" AND K.KT_GIVERS=EM.EMP_ID AND K.KTSTATUS = 'Pending for Approval' AND P.ADMINISTRATIVE_REPORTING_ID="+loggedInUserId.getEmp_id();
		    
		    ArrayList ktplan = (ArrayList) JdbcTemplate.query(sql1, new RowMapper<KtNotifivationHead>() {
				@Override
				public KtNotifivationHead mapRow(ResultSet rs, int numRow) throws SQLException {
					KtNotifivationHead ktsnotification = new KtNotifivationHead();
					
					ktsnotification.setKtgiver_id(rs.getInt("KT_GIVER"));
					ktsnotification.setStatusKt(rs.getString("KTSTATUS"));
					ktsnotification.setAr_nosheader(rs.getInt("AR_NOS"));
					ktsnotification.setEmp_code(rs.getString("EMP_CODE"));
					ktsnotification.setEmp_name(rs.getString("EMP_NAME"));
					ktsnotification.setAdminitrative_id(rs.getInt("ADMINISTRATIVE_REPORTING_ID"));
					
					return ktsnotification;
					}
		    	});
		    
		    List<PendingApprovals> leavenotificationsnew = getleavenotificationList(loggedInUserId);
		    
		    List<Training_Master> pendingTrainingList = trainingService.findPendingTrainingListNotification(loggedInUserId.getEmp_id());
		    
		    List<TraineeTrainingSheet> inhousependingtraininglist = trainingService
					.findPendingInhouseTrainingsSheet(loggedInUserId.getEmp_id());
		    
		    if(loggedInUserId.getProfile_id() == 6)
		    {
		    	probationrequest = (ArrayList<ProbationRequest>) hibernatetemplate
						.find("from ProbationRequest where status = 'Pending for HR Approval'");
		    }
		    else
		    {
		    	probationrequest = (ArrayList<ProbationRequest>) hibernatetemplate
						.find("from ProbationRequest where ar_id.emp_id = " + loggedInUserId.getEmp_id() + ""
								+ " and status = 'Pending for AR Approval'");
		    }
		    
		    ArrayList<CertificationCountDashboard> totalcount = loginService.getCountDashboard();
		    
		    ArrayList<CertificationPercentageCal> percentagescal = loginService.getPercentageDashboard();
		    
            ArrayList<LearningMgCountDashboard> total_Learningcount = loginService.getCount_LearningDashboard();
		    
		    ArrayList<LearningMgPerCountDashboard> percentage_learning = loginService.getLearning_PercentageDashboard();
		    
		    
		    ArrayList<ActiveDeactiveChartBar> actdeact = loginService.getactivedeactive();
		    
		    List<KtNotifivationHead> ktplanslist = exitModule.getKtplansnotificationList(loggedInUserId);
		    
		    m.put("markexit", marked);
		    
		    m.put("ktplanslist", ktplan);
		    
		    m.put("leavenotificationsnew", leavenotificationsnew);
		    
		    m.put("pendingtraininglist", pendingTrainingList);
		    
		    m.put("inHousePendingTrainingList", inhousependingtraininglist);
		    
		    m.put("probationrequest", probationrequest);
		    
		    m.put("totalcount", totalcount);
		    
		    m.put("percentagescal", percentagescal);
		    
             m.put("total_Learningcount", total_Learningcount);
		    
		    m.put("percentage_learning", percentage_learning);
		    
		    m.put("actdeact", actdeact);
		    
		    m.put("ktplanslist", ktplanslist);
			
			return m;
		}


		@Override
		public <T> T saveMyEntity(T t) {
			
			Session session = hibernatetemplate.getSessionFactory().openSession();
			Transaction tx = null;
			try
			{
				tx = session.beginTransaction();
				session.save(t);
				return t;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				tx.commit();
				session.close();
				System.gc();
			}
			return t;
		}


		@Override
		public boolean isAdmin(Employee_Master emp, String userRole) {
			
			boolean flag = false;
			
			String sql = " SELECT CASE "
					+ " WHEN EXISTS (SELECT 1"
					+ " FROM USER_ROLE"
					+ " WHERE (EMPLOYEE = "+emp.getEmp_id()+" AND USERROLE LIKE '"+userRole+"' AND ISACTIVATED = 'Y' AND  ROWNUM = 1))"
					+ " THEN 'Y'"
					+ " ELSE 'N'"
					+ " END AS REC_EXISTS"
					+ " FROM DUAL";
			
			ArrayList<String> dml2 = (ArrayList<String>) JdbcTemplate.query(sql, new RowMapper<String>(){

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					String flag2 = rs.getString("REC_EXISTS");
					return flag2;
				}
			});	
			
			if(dml2.size() > 0)
			{
				if(dml2.get(0).equals("Y"))
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
			
			return flag;
		}

		//Added by Ankita
	 
		@Override
		public ArrayList<LearningMgCountDashboard> getCount_LearningDashboard() {
			String sql= " Select Opens+In_Progress+Completed+Withdrawal as Assigned,Opens,In_Progress,"
                        +" Completed,Withdrawal FROM "
						+"(select COUNT(COURSE_NAME) As Opens from ASSIGN_VIDEO_COURSES where COURSE_STATUS='Open'),"
						+"(select COUNT(COURSE_NAME)As In_Progress from ASSIGN_VIDEO_COURSES where COURSE_STATUS='In Progress'),"
						+"(select COUNT(COURSE_NAME)As Completed from ASSIGN_VIDEO_COURSES where COURSE_STATUS='Completed'),"
						+"(select COUNT(COURSE_NAME)As Withdrawal from ASSIGN_VIDEO_COURSES where COURSE_STATUS='Withdrawn')";
		
			List<LearningMgCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<LearningMgCountDashboard>() {			
				@Override			
				public LearningMgCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
					LearningMgCountDashboard aContact = new LearningMgCountDashboard();
					aContact.setAssigned_courses(rs.getInt("Assigned"));
					aContact.setOpen(rs.getInt("Opens"));
					aContact.setIn_progress(rs.getInt("In_Progress"));
					aContact.setCompleted(rs.getInt("Completed"));
					aContact.setWithdrawal(rs.getInt("Withdrawal"));
					  
			// TODO Auto-generated method stub
			       return aContact;
		      }
			
			  });
			   
			return (ArrayList<LearningMgCountDashboard>) dml;
		}


		@Override
		public ArrayList<LearningMgCountDashboard> getEmp_CountLearningDashboard(int empid) {
		String sql=" select OPEN_COUNT+IN_PROGRESS_COUNT+COMPLETED_COUNT+WITHDRAWAL AS TOTAL_ASSINED ,OPEN_COUNT,IN_PROGRESS_COUNT,COMPLETED_COUNT,"
			       +" WITHDRAWAL from"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_COURSE_ID)) OPEN_COUNT FROM ASSIGN_VIDEO_COURSES WHERE EMPLOYEE_ID ="+empid+" AND COURSE_STATUS = 'Open'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_COURSE_ID)) IN_PROGRESS_COUNT FROM ASSIGN_VIDEO_COURSES WHERE  EMPLOYEE_ID ="+empid+" AND COURSE_STATUS = 'In Progress'),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_COURSE_ID)) COMPLETED_COUNT FROM ASSIGN_VIDEO_COURSES WHERE  EMPLOYEE_ID ="+empid+" AND COURSE_STATUS IN('Completed','Completed with Pass')),"
			       +"(SELECT COUNT(DISTINCT(ASSIGN_COURSE_ID)) WITHDRAWAL FROM ASSIGN_VIDEO_COURSES WHERE EMPLOYEE_ID ="+empid+" AND COURSE_STATUS = 'Withdrawn')";

										
		List<LearningMgCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<LearningMgCountDashboard>() {			
			@Override			
			public LearningMgCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
				LearningMgCountDashboard aContact = new LearningMgCountDashboard();
				aContact.setAssigned_courses(rs.getInt("TOTAL_ASSINED"));
				aContact.setOpen(rs.getInt("OPEN_COUNT"));
				aContact.setIn_progress(rs.getInt("IN_PROGRESS_COUNT"));
				aContact.setCompleted(rs.getInt("COMPLETED_COUNT"));
				aContact.setWithdrawal(rs.getInt("WITHDRAWAL"));
				  
		
		       return aContact;
	      }
		
		  });
		   
		return  (ArrayList<LearningMgCountDashboard>) dml;
		}


	 
	 
	 
	 @Override
		public ArrayList<LearningMgPerCountDashboard> getLearning_PercentageDashboard() {
			// TODO Auto-generated method stub
			String sql="select round((Open_Count/Total_Count * 100),2 )as Open_Count,round((In_Progress_count/Total_Count*100),2) as InProcess_Per,round((Complete_Count/Total_Count*100),2) as Complete_Count,"
                     +"round((Withdrawal_Count/Total_Count*100),2) as Withdrawal_Count from "
						+"(SELECT COUNT(COURSE_NAME) AS Open_Count FROM ASSIGN_VIDEO_COURSES where COURSE_STATUS='Open'),"
						+"(SELECT COUNT(COURSE_NAME) AS In_Progress_count FROM ASSIGN_VIDEO_COURSES where COURSE_STATUS='In Progress'),"
						+"(SELECT COUNT(COURSE_NAME) AS Complete_Count FROM ASSIGN_VIDEO_COURSES where COURSE_STATUS IN ('Completed','Completed with Pass')),"
						+"(SELECT COUNT(COURSE_NAME) AS Withdrawal_Count FROM ASSIGN_VIDEO_COURSES where COURSE_STATUS='Withdrawn'),"
						+"(SELECT COUNT(COURSE_NAME) AS Total_Count from  ASSIGN_VIDEO_COURSES)";
							
		List<LearningMgPerCountDashboard> dml = JdbcTemplate.query(sql, new RowMapper<LearningMgPerCountDashboard>() {			
			@Override			
			public LearningMgPerCountDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
				LearningMgPerCountDashboard aContact = new LearningMgPerCountDashboard();
				
				aContact.setOpen_per(rs.getDouble("Open_Count"));
				aContact.setIn_progress_per(rs.getDouble("InProcess_Per"));
				aContact.setCompleted_per(rs.getDouble("Complete_Count"));
				aContact.setWithdrawal_per(rs.getDouble("Withdrawal_Count"));
				  
		           return aContact;
	      }
		
		  });
		   
		return  (ArrayList<LearningMgPerCountDashboard>) dml;
	}
		
		
	 
	 
	 
	 
}