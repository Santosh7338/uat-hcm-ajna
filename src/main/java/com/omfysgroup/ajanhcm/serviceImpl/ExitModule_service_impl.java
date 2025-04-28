package com.omfysgroup.ajanhcm.serviceImpl;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.omfysgroup.ajanhcm.dao.ExitModule_Dao;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.KtKakerCount;
import com.omfysgroup.ajanhcm.model.KtNotifivationHead;
import com.omfysgroup.ajanhcm.model.KtPlan_Header;
import com.omfysgroup.ajanhcm.model.KtPlans;
import com.omfysgroup.ajanhcm.model.MarkExitScreen;
import com.omfysgroup.ajanhcm.model.Particulars_addGroup;
import com.omfysgroup.ajanhcm.model.RenewedMailCommunication;
import com.omfysgroup.ajanhcm.service.ExitModule_Service;
import com.omfysgroup.ajanhcm.utility.MailService;


@Service("ExitModule_Service")
public class ExitModule_service_impl implements ExitModule_Service {

	@Autowired
	ExitModule_Dao exitModuleDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	MailService mailService;

	@Override
	public boolean saveKtModule(KtPlans ktplans) {
		// TODO Auto-generated method stub
		return exitModuleDao.saveKtModule(ktplans);
	}

	@Override
	public boolean saveParticulars(Particulars_addGroup part_grp) {
		// TODO Auto-generated method stub
		return exitModuleDao.saveParticulars(part_grp);
	}

	@Override
	public int SaveExitRequest(MarkExitScreen markExit) {
		// TODO Auto-generated method stub
		return exitModuleDao.SaveExitRequest(markExit);
	}

	@Override
	public List<MarkExitScreen> getexitnotificationList(Employee_Master emp) {
		// TODO Auto-generated method stub
		return exitModuleDao.getexitnotificationList(emp);
	}

	@Override
	public List<KtNotifivationHead> getKtplansnotificationList(Employee_Master emp) {
		// TODO Auto-generated method stub
		return exitModuleDao.getKtplansnotificationList(emp);
	}

	@Override
	public boolean isFunctionalReporter(int emp_id) {
		// TODO Auto-generated method stub
		return exitModuleDao.isFunctionalReporter(emp_id);
	}

	@Override
	public boolean isKtGiver(int empid) {
		// TODO Auto-generated method stub
		return exitModuleDao.isKtGiver(empid);
	}

	@Override
	public boolean isAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		return exitModuleDao.isAdministrativeReporter(empid);
	}

	@Override
	public List<KtPlans> getAdminsnotificationList(int employeeid) {
		// TODO Auto-generated method stub
		return exitModuleDao.getAdminsnotificationList(employeeid);
	}

	@Override
	public List<KtKakerCount> getktdetails(int employeeid) {
		// TODO Auto-generated method stub
		return exitModuleDao.getktdetails(employeeid);
	}

	
	 @Scheduled(cron="0 33 11 ? * *")
	public void deactivateResignedEmployees() throws ParseException, MessagingException {
		 System.out.println("Inside cron......Exit......");
		    Date current_date = new Date();
			SimpleDateFormat sdfl = new SimpleDateFormat("dd-MMM-yy");
			String date_str = sdfl.format(current_date);
			
		 ArrayList<Employee_Master> hrobj = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master where profile_id=?",6);
			      		
		 
		 String sql ="SELECT ME.EMPLOYEE_NAME,ME.EMP_ID,ME.FINAL_EXIT_DATE,ME.EXIT_TYPE,EM.EMAIL FROM MARK_EXIT_SCREEN ME,EMPLOYEE_MASTER EM WHERE ME.EMP_ID=EM.EMP_ID AND EM.IS_ACTIVATED='Y' AND ME.EXIT_TYPE='Resigned'"; 

         
         List<MarkExitScreen> ResignMaster = jdbcTemplate.query(sql, new RowMapper<MarkExitScreen>() {

				@Override
				public MarkExitScreen mapRow(ResultSet rs, int rowNum) throws SQLException {
					MarkExitScreen aContact = new MarkExitScreen();

					aContact.setEmployee(rs.getString("EMPLOYEE_NAME"));
					Employee_Master emp = new Employee_Master();
					emp.setEmp_id(rs.getInt("EMP_ID"));
					aContact.setEmp_id(emp);
					aContact.setFinalexitdate(rs.getDate("FINAL_EXIT_DATE"));
					aContact.setExittype(rs.getString("EXIT_TYPE"));
					aContact.setEmail_id(rs.getString("EMAIL"));
					return aContact;
				}
			});
         System.out.println("the size of list===="+ResignMaster.size()+"the empid===="+ResignMaster.get(0).getEmp_id().getEmp_id());
		if(ResignMaster.size()>0){
         for(int i=0;i<ResignMaster.size();i++){
			 
		 Date finalDate = ResignMaster.get(i).getFinalexitdate();
		 Date tomorrow = new Date(finalDate.getTime() + (1000 * 60 * 60 * 24));
		 SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			String fnl_str = sdfl.format(finalDate);
			
			System.out.println("the final date===="+finalDate);
			
			if (current_date.compareTo(tomorrow)>0) {
				
				System.out.println("inside if condition..........");
				
				String sql2 = "Update Employee_Master set IS_ACTIVATED='N' ,EMP_DEACT_DATE='" + date_str
						+ "' where EMP_ID="+ ResignMaster.get(i).getEmp_id().getEmp_id();
				jdbcTemplate.execute(sql2);
				
					
		      		
	 	          String messages =  "<!DOCTYPE html>"
	 					+ "<html>"
	 					+ "<head>"
	 					
	 					+ "<style>"
	 					
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
	 					+ "Dear "+hrobj.get(0).getEmp_first_name()+",<br><br>"
	 					+ "Please be informed <b>"+ResignMaster.get(i).getEmployee()+"</b> has been Successfully deactivated from the MindsConnect Application.</p>"
	 					+ "As his/her Final Exit date was:- <b>"+fnl_str+"</b>.<br>"
	                    + "<p>You are requested to please log in to <a href='http://mindsconnect.omfysgroup.com/'>MindsConnect</a> application and check the Status of the Same Employee against <b>Manage Employee -> Active/Deactive</b>.</p>"
						
						+ "<br>"
						+ "<p>"
						+ "Thanks & Regards,<br>"
						+ "Team HR<br>"
									
						+ "<br>"
									
						+ "Note : This is a system generated mail. Do not reply to this mail.</p>"
	 					+ "</body>"
	 					+ "</html>";
	 	
	 	              RenewedMailCommunication mail1 = new RenewedMailCommunication();
	 	              mail1.setComm_type("Email");
	 	              mail1.setSub_type(""+ResignMaster.get(i).getEmployee()+" Deactivated Successfully");
	 	              mail1.setFrom_mail("helpdesk@omfysgroup.com");
	 	              mail1.setTo_mail(hrobj.get(0).getEmail());
	 	              mail1.setSubject(""+ResignMaster.get(i).getEmployee()+" Deactivated Successfully");
	 	              mail1.setBody(messages);
	 	              mail1.setStatus("Completed");
	 	             // mail.setCreated_by(emp.getEmp_id());
	 	             // mail.setLast_updated_by(emp.getEmp_id());
	 	
	 	             mailService.updatedSendMail(mail1);
	 	      
			}	
		 	
		}
		}
		/////////////////////////////////////////////////////////////////////////////////////
		
		String sql1 ="SELECT ME.EMPLOYEE_NAME,ME.EMP_ID,ME.FINAL_EXIT_DATE,ME.EXIT_TYPE,EM.EMAIL FROM MARK_EXIT_SCREEN ME,EMPLOYEE_MASTER EM WHERE ME.EMP_ID=EM.EMP_ID AND EM.IS_ACTIVATED='Y' AND ME.EXIT_TYPE IN('Absconded','Terminated')";
        
        List<MarkExitScreen> AbscondMaster = jdbcTemplate.query(sql1, new RowMapper<MarkExitScreen>() {

				@Override
				public MarkExitScreen mapRow(ResultSet rs, int rowNum) throws SQLException {
					MarkExitScreen aContact = new MarkExitScreen();

					aContact.setEmployee(rs.getString("EMPLOYEE_NAME"));
					Employee_Master emp = new Employee_Master();
					emp.setEmp_id(rs.getInt("EMP_ID"));
					aContact.setEmp_id(emp);
					aContact.setFinalexitdate(rs.getDate("FINAL_EXIT_DATE"));
					aContact.setExittype(rs.getString("EXIT_TYPE"));
					aContact.setEmail_id(rs.getString("EMAIL"));
					return aContact;
				}
			});
        System.out.println("the size of AbscondMaster list===="+AbscondMaster.size()+"the empid AbscondMaster===="+AbscondMaster.get(0).getEmp_id().getEmp_id());
		if(AbscondMaster.size()>0){
        for(int i=0;i<AbscondMaster.size();i++){
				
				System.out.println("inside for loop condition..........");
				
				String sql2 = "Update Employee_Master set IS_ACTIVATED='N' ,EMP_DEACT_DATE='" + date_str
						+ "' where EMP_ID="+ AbscondMaster.get(i).getEmp_id().getEmp_id();
				jdbcTemplate.execute(sql2);
				
		      		
	 	          String messages =  "<!DOCTYPE html>"
	 					+ "<html>"
	 					+ "<head>"
	 					
	 					+ "<style>"
	 					
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
	 					+ "Dear "+hrobj.get(0).getEmp_first_name()+",<br><br>"
	 					+ "Please be informed <b>"+AbscondMaster.get(i).getEmployee()+"</b> has been Successfully deactivated from the MindsConnect Application.</p>"
	                    + "<p>You are requested to please log in to <a href='http://mindsconnect.omfysgroup.com/'>MindsConnect</a> application and check the Status of the Same Employee against <b>Manage Employee -> Active/Deactive</b>.</p>"
						
						+ "<br>"
						+ "<p>"
						+ "Thanks & Regards,<br>"
						+ "Team HR<br>"
									
						+ "<br>"
									
						+ "Note : This is a system generated mail. Do not reply to this mail.</p>"
	 					+ "</body>"
	 					+ "</html>";
	 	
	 	              RenewedMailCommunication mail1 = new RenewedMailCommunication();
	 	              mail1.setComm_type("Email");
	 	              mail1.setSub_type(""+AbscondMaster.get(i).getEmployee()+" Deactivated Successfully");
	 	              mail1.setFrom_mail("helpdesk@omfysgroup.com");
	 	              mail1.setTo_mail(hrobj.get(0).getEmail());
	 	              mail1.setSubject(""+AbscondMaster.get(i).getEmployee()+" Deactivated Successfully");
	 	              mail1.setBody(messages);
	 	              mail1.setStatus("Completed");
	 	             // mail.setCreated_by(emp.getEmp_id());
	 	             // mail.setLast_updated_by(emp.getEmp_id());
	 	
	 	             mailService.updatedSendMail(mail1);
	 	      
			}	
		 	
		}

	}

	@Override
	public Employee_Master getEmployee(int empid) {
		// TODO Auto-generated method stub
		return exitModuleDao.getEmployee(empid);
	}

	@Override
	public String getKtPlanExcelFilePath(int kthead_id, Environment environment) {
		// TODO Auto-generated method stub
		return exitModuleDao.getKtPlanExcelFilePath(kthead_id,environment);
	}

}
