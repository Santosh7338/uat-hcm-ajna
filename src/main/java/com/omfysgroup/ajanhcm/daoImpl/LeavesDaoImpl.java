package com.omfysgroup.ajanhcm.daoImpl;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.omfysgroup.ajanhcm.dao.LeavesDao;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.BioMax_Details;
import com.omfysgroup.ajanhcm.model.EmployeeStatus;
import com.omfysgroup.ajanhcm.model.Employee_Attendance;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.Holidays_Setup;
import com.omfysgroup.ajanhcm.model.Joining_Details;
import com.omfysgroup.ajanhcm.model.LeaveBalance;
import com.omfysgroup.ajanhcm.model.LeaveDetails;
import com.omfysgroup.ajanhcm.model.LeaveNotifications;
import com.omfysgroup.ajanhcm.model.LeaveRequest;
import com.omfysgroup.ajanhcm.model.LeaveRequestLines;
import com.omfysgroup.ajanhcm.model.Leave_Credit_Setting;
import com.omfysgroup.ajanhcm.model.Leave_creadit_report;
import com.omfysgroup.ajanhcm.model.Leaves_Setting;
import com.omfysgroup.ajanhcm.model.MailCommunication;
import com.omfysgroup.ajanhcm.model.PALeaveHistory;
import com.omfysgroup.ajanhcm.model.PendingApprovals;
import com.omfysgroup.ajanhcm.model.RenewedMailCommunication;
import com.omfysgroup.ajanhcm.model.Rules_Document_Type;
import com.omfysgroup.ajanhcm.model.Rules_Documents;
import com.omfysgroup.ajanhcm.model.TimeLineStructure;
import com.omfysgroup.ajanhcm.service.LoginService;
import com.omfysgroup.ajanhcm.service.TrainingService;



@Repository("LeavesDao")
public class LeavesDaoImpl implements LeavesDao {

	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TrainingService trainingService;
	
	@Autowired
	LoginService loginService;
	
	public float saveLeaveCredit(Leave_Credit_Setting lcs)
	{
		
		hibernateTemplate.save(lcs);
		return lcs.getNo_of_leaves();
	}
	
	@Override
	public List<LeaveRequestLines> getLeaveRequestLines(int LR_ID) {
		List<LeaveRequestLines> lines = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from LeaveRequestLines where lr_id = :lr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("lr_id", LR_ID);
			lines = (List<LeaveRequestLines>) sql.list();
			return lines;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return lines;
	}
	
	@Override
	public Leaves_Setting getLeaveSettings(int leaveType) {
		Leaves_Setting settings = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Leaves_Setting where leave_type = :leave_type";
			Query sql = session.createQuery(query);
			sql.setParameter("leave_type", leaveType);
			settings = (Leaves_Setting) sql.uniqueResult();
			return settings;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return settings;
	}

	@Override
	public boolean saveLeaveNotifications(LeaveNotifications notifications) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(notifications);
			
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
	public boolean updateLeaveRequest(LeaveRequest leaveRequest) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(leaveRequest);;
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
	public boolean updateLeaveNotifications(LeaveNotifications leaveNotifications) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(leaveNotifications);;
			
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
	public boolean updateLeaveRequestLine(LeaveRequestLines leaveRequestLines) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(leaveRequestLines);;
			
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
	public boolean saveReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			for(Functional_Reporting fro : fr){
				session.save(fro);
			}
			
			
			for(Administrative_Reporting aro : ar){
				session.save(aro);
			}
			
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
	public boolean saveLeavesSettings(Leaves_Setting ls) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Leaves_Setting ls1 = (Leaves_Setting) session.save(ls);
			
			if(ls1 != null){
				flag = true;
			}
				
			return flag;
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
	//@Transactional
	public int checkInLeave(String final_date,int emp_code,int int_mon,String String_mon,String year,int daycount,String daystatus) {
		
		int ret=0;
		int ret1=0;
		int check_Lwp=0;
		
		int year1= Integer.parseInt(year);
		Date fd = null;
		
		String finaldate1 = daycount+"-"+int_mon+"-"+year; 
	     
		  SimpleDateFormat sdfo=new SimpleDateFormat("dd-MMM-yyyy");  
		
		try {
		 //fd = sdfo.parse(final_date);
			fd=sdfo.parse(final_date);  
			
			
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String emp_Code = String.format("%04d", emp_code);  
		String emp_code1 = "OMI-"+emp_Code; 
		
		if(daystatus.equalsIgnoreCase("A"))
		{
			Date daystatusdate = null;
		ArrayList<Employee_Master> emp = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master where emp_code=?",emp_code1);
		if(emp.size() > 0)
		{
		int emp_id = emp.get(0).getEmp_id();
		try {
			 daystatusdate = new SimpleDateFormat("dd-MM-yyyy").parse(finaldate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Holidays_Setup> h_setup = (ArrayList<Holidays_Setup>) hibernateTemplate.find("from Holidays_Setup where emp_id.emp_id=? and holiday_date=?",emp_id,daystatusdate);
		if(h_setup.size() > 0)
		{
			return 3;
		}
		}}
		hibernateTemplate.flush();
		List<LeaveRequestLines> lrl = new ArrayList<>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from LeaveRequestLines where emp_code = :emp_code and month= :month and year = :year";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_code", emp_code1);
			sql.setParameter("month", int_mon);
			sql.setParameter("year", year1);
			lrl = (List<LeaveRequestLines>) sql.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		
		
		
		
		int lrid = 0;
		for(int i=0;i<lrl.size();i++){
				Date sd = lrl.get(i).getStart_date(); 
				Date ed = lrl.get(i).getEnd_date();
					
				String sd_day = sd.toString();
				
				
				String sd1_day = sd_day.substring(8, 10);
				int sd2_day = Integer.parseInt(sd1_day);
				
				String ed_day = ed.toString();
				String ed1_day = ed_day.substring(8, 10);
				int ed2_day = Integer.parseInt(ed1_day);
				if(daycount >= sd2_day && daycount <= ed2_day){
					ret = 1;
					 lrid=lrl.get(i).getLr_id();
					 check_Lwp = lrl.get(i).getLeave_type();
					break;
				}
				
		}
		
		if(ret == 1){
			ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernateTemplate.find("from LeaveRequest where lr_id=?",lrid);
			
			String status = lr.get(0).getStatus();
			if(check_Lwp == 5)
			{
			ret1 = 2;	
			}
			else{
			if(status.equals("Approved"))
			{
				ret1=1;
			}
			else
			{
				ret1 = 0;
			}
			}
		}
		return ret1;
	}

	@Override
	public int checkInLeaveHd(String final_date, int emp_code, int int_mon, String string_mon, String year,
			int daycount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Joining_Details getDes_id(int emp_code) {
		Joining_Details jd = null;
		String emp_Code = String.format("%04d", emp_code);
		String empCode = "OMI-"+emp_Code;
		//ArrayList<Employee_Master> emp_mast = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master where emp_code=?",empCode);
		
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Joining_Details where emp_id.emp_code = :emp_code";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_code", empCode);
			
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
	
	@Transactional
	@Override
	public float creditLeave1(int emp_code, int desig_id,float total) {
		String emp_Code = String.format("%04d",emp_code);
		String emp_code1 = "OMI-"+emp_Code;

		//ArrayList<Leave_Credit_Setting> lrc = (ArrayList<Leave_Credit_Setting>) hibernateTemplate.find("from Leave_Credit_Setting where designation_id=?",desig_id);
		
		//if(lrc.size() >= 1)
		//{
		//float noofleave=lrc.get(0).getNo_of_leaves();
	
		
		ArrayList<LeaveBalance> lb = (ArrayList<LeaveBalance>) hibernateTemplate.find("from LeaveBalance where emp_code=?",emp_code1);
		
		if( lb.size() != 0){
	
		float pl = lb.get(0).getPl();
		
		
		if(total >= 20)
		{
			pl = (float) (pl + 1.5);
			Iterator ii = lb.iterator();
			while(ii.hasNext()){
				LeaveBalance n = ( LeaveBalance ) ii.next();
				n.setPl(pl);
				hibernateTemplate.saveOrUpdate(n);
				return 1.5f;
			}
		
		
			
			
			
		/*	LeaveBalance l = lb.get(0);
			l.setLb_no(lb.get(0).getLb_no());
			l.setEmp_id(lb.get(0).getEmp_id());
			l.setPl(pl);
			hibernateTemplate.saveOrUpdate(l);*/
			
			
		}
		else if(total >= 10 && total < 20)
		{
			pl = (float) (pl+0.5);
			
			Iterator ii = lb.iterator();
			while(ii.hasNext()){
				LeaveBalance n = ( LeaveBalance ) ii.next();
				n.setPl(pl);
				hibernateTemplate.saveOrUpdate(n);
			
			/*lb.get(0).setPl(pl);
			hibernateTemplate.saveOrUpdate(lb);*/
			return 0.5f;
		}
		
		}
		
		else if(total < 10)
		{
			pl = (float) (pl+0);
			
			Iterator ii = lb.iterator();
			while(ii.hasNext()){
				LeaveBalance n = ( LeaveBalance ) ii.next();
				n.setPl(pl);
				hibernateTemplate.saveOrUpdate(n);
			
			/*lb.get(0).setPl(pl);
			hibernateTemplate.saveOrUpdate(lb);*/
			return 0.0f;
		}
		
		}
		}
		//}
		
		return 0;
	}

	@Override
	public LeaveBalance getLeaveBalance(int emp_id) {
		LeaveBalance leaveBalance = new LeaveBalance();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from LeaveBalance where emp_id = :emp_id";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_id", emp_id);
			
			leaveBalance = (LeaveBalance) sql.uniqueResult();
				
			return leaveBalance;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return leaveBalance;
	}
	
	@Override
	public boolean updateLeaveBalance(LeaveBalance leaveBalance) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(leaveBalance);
			
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
	public int getMaxLR_NO() {
		int LR_NO = 0;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "max(lr_no) from LeaveRequest";
			Query sql = session.createQuery(query);
			
			LR_NO = sql.executeUpdate();
				
			return LR_NO;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return LR_NO;
	}
	
	@Override
	public TimeLineStructure getTimeLine() {
		TimeLineStructure tm = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from TimeLineStructure";
			Query sql = session.createQuery(query);
			
			tm = (TimeLineStructure) sql.uniqueResult();
				
			return tm;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return tm;
	}
	
	@Override
	public boolean updateTimeLine(TimeLineStructure tm) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(tm);
				
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
	public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
		LeaveRequest id = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(leaveRequest);
			String query = "from LeaveRequest where lr_no = :lr_no";
			Query sql = session.createQuery(query);
			sql.setParameter("lr_no", leaveRequest.getLr_no());
			id = (LeaveRequest) sql.uniqueResult();
			return id;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return id;
	}

	@Override
	public boolean saveLeaveRequestLines(List<LeaveRequestLines> leaveRequestLines, LeaveBalance leaveBalance) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			for(LeaveRequestLines lrl : leaveRequestLines){
				session.save(lrl);
			}
			
			session.update("lb",leaveBalance);
			
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
	public boolean saveMailCommunication(MailCommunication mail) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(mail);
			
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
	public float creditCl(int emp_code, int desig_id, int int_mon) {
		// TODO Auto-generated method stub
		int retcl=0;
		String emp_Code = String.format("%04d",emp_code);
		String empCode="OMI-"+emp_Code;
		ArrayList<LeaveBalance> lb = (ArrayList<LeaveBalance>) hibernateTemplate.find("from LeaveBalance where emp_code=?",empCode);
		if( lb.size() != 0){
			
			float cl = lb.get(0).getCl();
			 cl = cl+2;
			Iterator ii = lb.iterator();
			while(ii.hasNext()){
				LeaveBalance n = ( LeaveBalance ) ii.next();
				n.setCl(cl);
				hibernateTemplate.saveOrUpdate(n);}
			retcl=2;
		}
		return retcl;
	}

	@Override
	public int saveEmployeeLeaveBalance(String empcode) {
		// TODO Auto-generated method stub
	
		String AprDate = "";
		long diff;
		long diffDays = 0;
		ArrayList<Employee_Master> em = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master where emp_code=?", empcode);
		
		
		if(em.size() != 0 ){
		int emp_id=em.get(0).getEmp_id();	
		
		
		ArrayList<Joining_Details> jd = (ArrayList<Joining_Details>) hibernateTemplate.find("from Joining_Details where emp_id.emp_id=?", emp_id);
		if(jd.size() != 0)
		{
		Date date = jd.get(0).getJoining_date();
		
		String date1=date.toString();
		
		String mon = date1.substring(5, 7);
		String year = date1.substring(0, 4);
		String day = date1.substring(8,10);
		
		String final_date=mon+"/"+day+"/"+year+" 00:00:00";
		
		
		if(Integer.parseInt(mon) >= 1 && Integer.parseInt(mon) <= 3){
			AprDate ="03/31/"+year+" 00:00:00";
		}
		else if(Integer.parseInt(mon) >= 4 && Integer.parseInt(mon) <= 6){
			AprDate ="06/30/"+year+" 00:00:00";
		}
		else if(Integer.parseInt(mon) >= 7 && Integer.parseInt(mon) <= 9){
			AprDate ="09/30/"+year+" 00:00:00";
		}
		else
		{
			AprDate ="12/31/2012"+year+" 00:00:00";
		}
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(final_date);
			d2 = format.parse(AprDate);
			 diff = d2.getTime() - d1.getTime();
			 diffDays = diff / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		float cl = 0;
		
		if(diffDays >= 45 && diffDays <= 90 )
		{
			cl = 1.5f;
		}
		else if(diffDays < 45)
		{
			cl=0.5f;
		}
		else
		{
			cl = 2.0f;
		}
		
		LeaveBalance lb=new LeaveBalance();
		lb.setEmp_code(empcode);
		lb.setPl(0);
		lb.setEmp_id(emp_id);
		lb.setCl(cl);
		lb.setMl(10);
		
		hibernateTemplate.saveOrUpdate(lb);
		
		
	}
		}
		return 0;
	}

	@Override
	public int saveAttendance(Employee_Attendance emp) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(emp);
		return 1;
	}

	@Override
	public ArrayList checkInLeave_for_replacing_A_to_PL(String final_date, int emp_code,String daystatus, int int_mon, String string_mon,
			String year, int daycount) {
		int ret=0;
		ArrayList ret1=null;
		ArrayList al1 = new ArrayList<>();
		
		int year1= Integer.parseInt(year);
		Date fd = null;

	     
		  SimpleDateFormat sdfo=new SimpleDateFormat("dd-MMM-yyyy");  
		
		try {
		 //fd = sdfo.parse(final_date);
			fd=sdfo.parse(final_date);  
			
			
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String emp_Code = String.format("%04d", emp_code);
		String emp_code1 = "OMI-"+emp_Code; 
		String finaldate1 = daycount+"-"+int_mon+"-"+year; 
		
		List<LeaveRequestLines> lrl = new ArrayList<>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from LeaveRequestLines where emp_code = :emp_code and month= :month and year = :year";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_code", emp_code1);
			sql.setParameter("month", int_mon);
			sql.setParameter("year", year1);
			lrl = (List<LeaveRequestLines>) sql.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		
		/////////
		
		
		int lrid = 0;
		for(int i=0;i<lrl.size();i++){
				Date sd = lrl.get(i).getStart_date(); 
				Date ed = lrl.get(i).getEnd_date();
					
				String sd_day = sd.toString();
				
				
				String sd1_day = sd_day.substring(8, 10);
				int sd2_day = Integer.parseInt(sd1_day);
				String ed_day = ed.toString();
				String ed1_day = ed_day.substring(8, 10);
				int ed2_day = Integer.parseInt(ed1_day);
				
				if(daycount >= sd2_day && daycount <= ed2_day){
					ret = 1;
					 lrid=lrl.get(i).getLr_id();
					
					 
					 al1.add(lrl.get(i).getLeave_type());
					 al1.add(lrl.get(i).getLeave_count());
					 
					break;
					
					
					
					
					
				}
				
				
				
		}
		
		
		
		if(ret == 1){
			ArrayList<LeaveRequest> lr = (ArrayList<LeaveRequest>) hibernateTemplate.find("from LeaveRequest where lr_id=?",lrid);
			String status = lr.get(0).getStatus();
			if(status.equals("Approved"))
			{
				al1.add(1);
			}
			else
			{
				al1.clear();
				al1.add(0);
			}
		}
		
		hibernateTemplate.flush();
		
		if(daystatus.equalsIgnoreCase("A") && al1.size() <= 0)
		{
			Date daystatusdate = null;
		ArrayList<Employee_Master> emp = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master where emp_code=?",emp_code1);
		if(emp.size() > 0)
		{
		int emp_id = emp.get(0).getEmp_id();
		try {
			 daystatusdate = new SimpleDateFormat("dd-MM-yyyy").parse(finaldate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Holidays_Setup> h_setup = (ArrayList<Holidays_Setup>) hibernateTemplate.find("from Holidays_Setup where emp_id.emp_id=? and holiday_date=?",emp_id,daystatusdate);
		if(h_setup.size() > 0)
		{
			al1.add(3);
			return al1;
		}
		}
		}
		
		return al1;
	}

	@Override
	public ArrayList updateLcs(int lc_no) {
		
		
		String sql="SELECT * FROM Leave_Credit_Setting WHERE lc_no = "+lc_no+" ";
		List<Leave_Credit_Setting> Grid1_List_autofill = jdbcTemplate.query(sql, new RowMapper<Leave_Credit_Setting>() {

			@Override
			public Leave_Credit_Setting mapRow(ResultSet rs, int rowNum) throws SQLException {
								
				Leave_Credit_Setting Grid1_data = new Leave_Credit_Setting();
				
				/*ArrayList<Leave_Credit_Setting> update_lcs_no = (ArrayList<Leave_Credit_Setting>) hibernateTemplate.find("from Leave_Credit_Setting where lc_no=?",lc_no);
				int leave_Type_Id = update_lcs_no.get(0).getLeave_type_id();
				float no_of_leave = update_lcs_no.get(0).getNo_of_leaves();
				String credit_frequency = update_lcs_no.get(0).getCredit_frequency();*/
								
				
				Grid1_data.setLeave_type_id(rs.getInt("LEAVE_TYPE_ID"));
				Grid1_data.setNo_of_leaves(rs.getFloat("NO_OF_LEAVES"));
				Grid1_data.setCredit_frequency(rs.getString("CREDIT_FREQUENCY"));
				Grid1_data.setDesignation_id(rs.getInt("DESIGNATION_ID"));
				
				DateFormat ser5 = new SimpleDateFormat("MM-dd-yyyy");
				String dateStr5 = ser5.format(rs.getDate("START_DATE"));
				Grid1_data.setApproval_from_str(dateStr5);	
				
				DateFormat ser6 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr6 = ser5.format(rs.getDate("END_DATE"));
				Grid1_data.setApproval_upto_str(dateStr6);
				
				/*Grid1_data.setLs_id(rs.getInt("LS_ID"));
				Grid1_data.setPrior_days(rs.getInt("PRIOR_DAYS"));
				Grid1_data.setAfter_days(rs.getInt("AFTER_DAYS"));
				Grid1_data.setPrefix_weekend(rs.getString("PREFIX_WEEKEND"));
				Grid1_data.setSuffix_weekend(rs.getString("SUFFIX_WEEKEND"));
				Grid1_data.setPrefix_holidays(rs.getString("PREFIX_HOLIDAYS"));
				Grid1_data.setSuffix_holidays(rs.getString("SUFFIX_HOLIDAYS"));
				
				Grid1_data.setMGNT_APPROVAL(rs.getString("MGNT_APPROVAL"));
				Grid1_data.setMgnt_approval_leaves(rs.getInt("MGNT_APPROVAL_LEAVES"));
				
				
				DateFormat ser5 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr5 = ser5.format(rs.getDate("APPROVAL_FROM"));
				Grid1_data.setApproval_from_str(dateStr5);	
				
				
				DateFormat ser6 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr6 = ser5.format(rs.getDate("APPROVAL_UPTO"));
				Grid1_data.setApproval_upto_str(dateStr6);
				
			
				
				Grid1_data.setLeave_type(rs.getInt("LEAVE_TYPE"));
				Grid1_data.setLeaves_combination(rs.getString("LEAVES_COMBINATION"));
				Grid1_data.setLeaves_combination_allow(rs.getString("LEAVES_COMBINATION_ALLOW"));*/
				
				return Grid1_data;
			}

			
		});
		
		return (ArrayList) Grid1_List_autofill;
	
	}

	@Override
	public ArrayList<Functional_Reporting> getEmp_Id_From_Reporting_Structure() {
		ArrayList<Functional_Reporting> al = (ArrayList<Functional_Reporting>) hibernateTemplate.find("from Functional_Reporting where emp_id.is_activated = 'Y'");
		
		return al;
	}

	@Override
	public ArrayList<Administrative_Reporting> getEmp_Id_From_AdminReporting_Structure(int empid) {
		ArrayList<Administrative_Reporting> al = (ArrayList<Administrative_Reporting>) hibernateTemplate.find("from Administrative_Reporting where emp_id.emp_id="+empid+" and emp_id.is_activated = 'Y' ");
		return al;
	}

	@Override
	public ArrayList<Functional_Reporting> getFrData(int fr_no) {
		// TODO Auto-generated method stub
		ArrayList<Functional_Reporting> al = (ArrayList<Functional_Reporting>) hibernateTemplate.find("from Functional_Reporting where fr_no=?",fr_no);
		return al;
	}

	@Override
	public ArrayList<Administrative_Reporting> getArData(int ar_no) {
		// TODO Auto-generated method stub
		ArrayList<Administrative_Reporting> al = (ArrayList<Administrative_Reporting>) hibernateTemplate.find("from Administrative_Reporting where ar_no=?",ar_no);
		

		return al;
	}

	@Override
	public List<Leaves_Setting> update_leave_setting(int ls_id) {
		
		String sql="SELECT * FROM LEAVES_SETTING WHERE LS_ID = "+ls_id+" ";
		List<Leaves_Setting> Grid1_List_autofill = jdbcTemplate.query(sql, new RowMapper<Leaves_Setting>() {

			@Override
			public Leaves_Setting mapRow(ResultSet rs, int rowNum) throws SQLException {
								
				Leaves_Setting Grid1_data = new Leaves_Setting();
								
				//Grid1_data.setService_request_line_id(rs.getInt("P_SR_LINE_ID"));
				Grid1_data.setLs_id(rs.getInt("LS_ID"));
				Grid1_data.setPrior_days(rs.getInt("PRIOR_DAYS"));
				Grid1_data.setAfter_days(rs.getInt("AFTER_DAYS"));
				Grid1_data.setPrefix_weekend(rs.getString("PREFIX_WEEKEND"));
				Grid1_data.setSuffix_weekend(rs.getString("SUFFIX_WEEKEND"));
				Grid1_data.setPrefix_holidays(rs.getString("PREFIX_HOLIDAYS"));
				Grid1_data.setSuffix_holidays(rs.getString("SUFFIX_HOLIDAYS"));
				
				Grid1_data.setMGNT_APPROVAL(rs.getString("MGNT_APPROVAL"));
				Grid1_data.setMgnt_approval_leaves(rs.getInt("MGNT_APPROVAL_LEAVES"));
				
				
				DateFormat ser5 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr5 = ser5.format(rs.getDate("APPROVAL_FROM"));
				Grid1_data.setApproval_from_str(dateStr5);	
				
				
				DateFormat ser6 = new SimpleDateFormat("dd-MM-yyyy");
				String dateStr6 = ser5.format(rs.getDate("APPROVAL_UPTO"));
				Grid1_data.setApproval_upto_str(dateStr6);
				
			
				
				Grid1_data.setLeave_type(rs.getInt("LEAVE_TYPE"));
				Grid1_data.setLeaves_combination(rs.getString("LEAVES_COMBINATION"));
				Grid1_data.setLeaves_combination_allow(rs.getString("LEAVES_COMBINATION_ALLOW"));
				/*Grid1_data.setConvert_to_day_before_days(rs.getInt("CONVERT_TO_DAY_BEFORE_DAYS"));*/
				return Grid1_data;
			}
			
		});
		
		return Grid1_List_autofill;
	
	
	}

	@Override
	public float udateLeaveCredit(Leave_Credit_Setting lcs) {
		hibernateTemplate.flush();
		hibernateTemplate.clear();
		hibernateTemplate.saveOrUpdate(lcs);
		return lcs.getNo_of_leaves();
	}

	@Override
	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee) {
		List<LeaveNotifications> notifications = new ArrayList<>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from LeaveNotifications where approver_id.emp_id = :emp_id";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_id", employee.getEmp_id());
//			sql.setParameter("status", "Pending for approval");
			
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
	public ArrayList<Employee_Master> getEmployeeData() {
		ArrayList<Employee_Master> employee_mast = (ArrayList<Employee_Master>) hibernateTemplate.find("from Employee_Master");
		
		return employee_mast;
	}

	@Override
	public boolean updateReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			for(Functional_Reporting fro : fr){
				session.update(fro);
			}
			
			
			for(Administrative_Reporting aro : ar){
				session.update(aro);
			}
			
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
	public List<PendingApprovals> getApprovedApprovalPendingLeaves(Employee_Master employee,int year) {
//		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
//				  +" LN.STATUS AS STATUS" 
//				  +" FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL" 
//                  +" WHERE LN.LR_ID=LRL.LR_NO AND LN.LR_ID = LR.LRL_NO AND extract(YEAR From LRL.APPLICATION_DATE) ="+year+" AND"
//                  +" LN.EMP_ID = EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" AND LN.STATUS IN('Approved','Cancelled','Rejected')" 
//                  +" ORDER BY LRL.APPLICATION_DATE";
		
		
		String sql="SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
				  +" LN.STATUS AS STATUS" 
				  +" FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL" 
				  +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND extract(YEAR From LRL.APPLICATION_DATE) ="+year+" AND"
				  +" LN.EMP_ID = EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" AND LN.STATUS IN('Approved','Cancelled','Rejected')" 
				  +" ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				pendingApprovals.setStatus(rs.getString("STATUS"));
				return pendingApprovals;
			}
			
			
		});
		
		return notifications;
	}

	@Override
	public List<PendingApprovals> getPendingApprovalPendingLeaves(Employee_Master employee,int year) {
		
		
		List<PendingApprovals> pendingApprovals = new ArrayList<PendingApprovals>();
		
		if(trainingService.isFunctionalReporter(employee.getEmp_id()))
		{
			String Sql = "SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
						+ "LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
						+ "LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT"
						+ " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID"
						+ " AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND"
						+ " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" and LN.APPROVER_TYPE = 'Functional' and LRL.STATUS = 'Pending for FR Approval'"
						+ " AND extract(YEAR From LRL.APPLICATION_DATE)="+year
						+ " AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
			
		List<PendingApprovals> pendingApprovalForFunctional = jdbcTemplate.query(Sql, new RowMapper<PendingApprovals>(){

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
			
		
		pendingApprovals.addAll(pendingApprovalForFunctional);
	}
	
	if(trainingService.isAdministrativeReporter(employee.getEmp_id()))
	{
		String sql = "SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,"
				+ "EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				+ "LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE"
				+ " FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT"
				+ " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO"
				+ " AND LRL.EMP_ID=EM.EMP_ID AND "
				+ " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" and LN.APPROVER_TYPE = 'Administrative' and LRL.STATUS = 'Pending for AR Approval'"
				+ " AND extract(YEAR From LRL.APPLICATION_DATE)="+year+" AND"
				+ " LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> pendingApprovalForAdministartive = jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

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
		
		
		pendingApprovals.addAll(pendingApprovalForAdministartive);
	}
	
	if(employee.getEmp_id() == 46)
	{
		String sql = "SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,"
				+ "EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				+ "LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE"
				+ " FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT"
				+ " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO"
				+ " AND LRL.EMP_ID=EM.EMP_ID AND"
				+ " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" and LN.APPROVER_TYPE = 'Management' and LRL.STATUS = 'Pending for MG Approval'"
				+ " AND extract(YEAR From LRL.APPLICATION_DATE)="+year+" AND"
				+ " LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> pendingApprovalForManagement = jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setStart_date(rs.getString("START_DATE"));
				pendingApprovals.setEnd_date(rs.getString("END_DATE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getInt("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				return pendingApprovals;
			}
			
		});
		
		
		pendingApprovals.addAll(pendingApprovalForManagement);
		
	}
//		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,"
//				+" LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LN.STATUS AS STATUS,LRL.LR_NO AS LR_NO" 
//				+" FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL" 
//				+" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND extract(YEAR From LRL.APPLICATION_DATE) = "+year+" AND"
//				+" LN.EMP_ID = EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" AND" 
//				+" LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
//		
////		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,"
////					+" LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LN.STATUS AS STATUS" 
////                    +" FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL" 
////                    +" WHERE LN.LR_ID=LRL.LR_NO AND LN.LR_ID = LR.LRL_NO AND extract(YEAR From LRL.APPLICATION_DATE) ="+year+" AND"
////                    +" LN.EMP_ID = EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" AND" 
////                    +" LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
//		
//		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){
//
//			@Override
//			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
//			
//				PendingApprovals pendingApprovals=new PendingApprovals();
//				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
//				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
//				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
//				pendingApprovals.setSubject(rs.getString("SUBJECT"));
//				pendingApprovals.setStatus(rs.getString("STATUS"));
//				return pendingApprovals;
//			}
//			
//			
//		});
		
		return pendingApprovals;
		
	}

	@Override
	public List<PALeaveHistory> getapprovedLeaveHistory(Employee_Master employee,String currdate,String weekdaydate) {
		
			String sql ="";
			
			if(employee.getProfile_id() == 6)
			{

			     sql =  "SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME || ' ' || EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
						+ "LRL.APPLICATION_DATE AS APPLICATION_DATE,"
						+ "LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP WHERE"
						+ " (LR.START_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')"
						+ " or LR.END_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')) And"
						+ " LRL.LR_ID=LR.LR_ID AND LRL.EMP_ID=EMP.EMP_ID AND LRL.STATUS IN('Approved','Cancelled','Rejected')"
						+ " ORDER BY LRL.APPLICATION_DATE";
			}
			else
			{
				 sql =  "SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME || ' ' || EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
							+ "LRL.APPLICATION_DATE AS APPLICATION_DATE,"
							+ "LRL.STATUS AS STATUS,(SELECT LT.LEAVE_TYPE FROM LEAVE_TYPE LT WHERE LT.L_NO=LR.LEAVE_TYPE) AS LEAVE_TYPE FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP"
							+ " WHERE LRL.EMP_ID="+employee.getEmp_id()+" AND"
							+ " (LR.START_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')"
							+ " or LR.END_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')) And"
							+ " LRL.LR_ID=LR.LR_ID AND LRL.EMP_ID=EMP.EMP_ID AND LRL.STATUS IN('Approved','Cancelled','Rejected')"
							+ " ORDER BY LRL.APPLICATION_DATE";
			}
			
			System.out.println("*** getapprovedLeaveHistory ==> "+sql);
			
			
			List<PALeaveHistory> approvedleaveHistory=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

				@Override
				public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
					// TODO Auto-generated method stub
					PALeaveHistory approvedLeaveHistory=new PALeaveHistory();
					approvedLeaveHistory.setLr_id(rs.getInt("LR_ID"));
					approvedLeaveHistory.setEmp_name(rs.getString("APPLICANT"));
					approvedLeaveHistory.setSubject(rs.getString("SUBJECT"));
					approvedLeaveHistory.setApplication_date(rs.getDate("APPLICATION_DATE"));
					approvedLeaveHistory.setStatus(rs.getString("STATUS"));
					approvedLeaveHistory.setLeave_type(rs.getString("LEAVE_TYPE"));
					return approvedLeaveHistory;
				}
				
			});
			
			return approvedleaveHistory;
	}

	@Override
	public List<PALeaveHistory> getPendingLeaveHistory(Employee_Master employee,String currdate,String weekdaydate) {
		
		
		LocalDate today=LocalDate.now();
		int year=today.getYear();
//		int year=2020;
		
		String sql = "";
		
		if(employee.getProfile_id() == 6)
		{
			 sql="SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME || ' ' || EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
					  +" LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP" 
					  +" WHERE "
					  +" LRL.LR_ID=LR.LR_ID AND LRL.EMP_ID=EMP.EMP_ID AND"
					  +" (LR.START_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')"
					  +" or LR.END_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD'))" 
	                  +" AND LRL.STATUS IN('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')"
	                  +" ORDER BY LRL.APPLICATION_DATE";
		}
		else
		{
			 sql="SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME || ' ' || EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
					  +" LRL.STATUS AS STATUS,(SELECT LT.LEAVE_TYPE FROM LEAVE_TYPE LT WHERE LT.L_NO=LR.LEAVE_TYPE) AS LEAVE_TYPE FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP" 
					  +" WHERE LRL.EMP_ID="+employee.getEmp_id() 
					  +" AND LRL.LR_ID=LR.LR_ID AND LRL.EMP_ID=EMP.EMP_ID AND"
					  +" (LR.START_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD')"
					  +" or LR.END_DATE between TO_DATE('"+weekdaydate+"', 'YYYY-MM-DD') AND TO_DATE('"+currdate+"', 'YYYY-MM-DD'))" 
	                  +" AND LRL.STATUS IN('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')"
	                  +" ORDER BY LRL.APPLICATION_DATE";
			
		}
		
		List<PALeaveHistory> pendingleaveHistory=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

				@Override
				public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
					// TODO Auto-generated method stub
					PALeaveHistory pendingleaveHistory=new PALeaveHistory();
					pendingleaveHistory.setLr_id(rs.getInt("LR_ID"));
					pendingleaveHistory.setEmp_name(rs.getString("APPLICANT"));
					pendingleaveHistory.setSubject(rs.getString("SUBJECT"));
					pendingleaveHistory.setApplication_date(rs.getDate("APPLICATION_DATE"));
					pendingleaveHistory.setStatus(rs.getString("STATUS"));
					pendingleaveHistory.setLeave_type(rs.getString("LEAVE_TYPE"));
					return pendingleaveHistory;
				}
				
			});
			return pendingleaveHistory;
		
	}

	@Override
	public List<PALeaveHistory> getapprovedLeaveHistoryHR() {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		int year=today.getYear();
//		int year=2020;
		// TODO Auto-generated method stub
		String sql="SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME ||' '|| EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
					+" LRL.APPLICATION_DATE AS APPLICATION_DATE,LRL.STATUS AS STATUS"
                    +" FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP WHERE extract(YEAR From LRL.APPLICATION_DATE) = "+year
                    +" AND LRL.LR_ID=LR.LR_ID AND LR.EMP_ID=EMP.EMP_ID AND LRL.STATUS IN('Approved','Cancelled','Rejected') ORDER BY LRL.APPLICATION_DATE";
		
		List<PALeaveHistory> approvedleaveHistoryHR=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

			@Override
			public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
				// TODO Auto-generated method stub
				PALeaveHistory approvedLeaveHistoryhr=new PALeaveHistory();
				approvedLeaveHistoryhr.setLr_id(rs.getInt("LR_ID"));
				approvedLeaveHistoryhr.setEmp_name(rs.getString("APPLICANT"));
				approvedLeaveHistoryhr.setSubject(rs.getString("SUBJECT"));
				approvedLeaveHistoryhr.setApplication_date(rs.getDate("APPLICATION_DATE"));
				approvedLeaveHistoryhr.setStatus(rs.getString("STATUS"));
				return approvedLeaveHistoryhr;
			}
			
		});
		return approvedleaveHistoryHR;
	}

	@Override
	public List<PALeaveHistory> getPendingLeaveHistoryHR() {
		LocalDate today=LocalDate.now();
		int year=today.getYear();

		String sql="SELECT LRL.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME ||' '||EMP.EMP_LAST_NAME AS APPLICANT,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
                   +" LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL,EMPLOYEE_MASTER EMP" 
                   +" WHERE extract(YEAR From LRL.APPLICATION_DATE) = "+year
                   +" AND LRL.LR_ID=LR.LR_ID AND EMP.EMP_ID=LRL.EMP_ID AND" 
                   +" LRL.STATUS IN('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')" 
                   +" ORDER BY LRL.APPLICATION_DATE";
		
		List<PALeaveHistory> pendingLeaveHistoryHR=jdbcTemplate.query(sql, new RowMapper<PALeaveHistory>(){

			@Override
			public PALeaveHistory mapRow(ResultSet rs, int rownum) throws SQLException {
				// TODO Auto-generated method stub

				PALeaveHistory pendingLeaveHistory=new PALeaveHistory();
				pendingLeaveHistory.setLr_id(rs.getInt("LR_ID"));
				pendingLeaveHistory.setEmp_name(rs.getString("APPLICANT"));
				pendingLeaveHistory.setSubject(rs.getString("SUBJECT"));
				pendingLeaveHistory.setApplication_date(rs.getDate("APPLICATION_DATE"));
				pendingLeaveHistory.setStatus(rs.getString("STATUS"));

				return pendingLeaveHistory;
			}
			
		});
		return pendingLeaveHistoryHR;
	}

	@Override
	public List<PALeaveHistory> getPreviousApprovedLHHR(int prevyear) {
		// TODO Auto-generated method stub
//		LocalDate today=LocalDate.now();
//		int year=today.getYear();
//		int prevYear=year-1;
		
		String sql="SELECT LRL.LR_ID AS LR_ID,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,"
					+" LRL.APPLICATION_DATE AS APPLICATION_DATE,LRL.STATUS AS STATUS"
                    +" FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL WHERE extract(YEAR From LRL.APPLICATION_DATE) = "+prevyear
                    +" AND LRL.LR_ID=LR.LR_ID AND LRL.STATUS IN('Approved','Cancelled','Rejected') ORDER BY LRL.APPLICATION_DATE";
		
		List<PALeaveHistory> prevApprovedLeaveHistoryHR=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

			@Override
			public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
				// TODO Auto-generated method stub
				PALeaveHistory prevApprovedLHHr=new PALeaveHistory();
				prevApprovedLHHr.setLr_id(rs.getInt("LR_ID"));
				prevApprovedLHHr.setSubject(rs.getString("SUBJECT"));
				prevApprovedLHHr.setApplication_date(rs.getDate("APPLICATION_DATE"));
				prevApprovedLHHr.setStatus(rs.getString("STATUS"));
				return prevApprovedLHHr;
			}
			
		});
		return prevApprovedLeaveHistoryHR;
	}

	@Override
	public List<PALeaveHistory> getPreviousApprovedLeaveHistory(Employee_Master employee,int prevyear) {
		// TODO Auto-generated method stub
//		LocalDate today=LocalDate.now();
//		int year=today.getYear();
//		int prevYear=year-1;
		
		String sql="SELECT LRL.LR_ID AS LR_ID,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
                   +" LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL" 
                   +" WHERE  LRL.EMP_ID="+employee.getEmp_id()+" AND extract(YEAR From LRL.APPLICATION_DATE) = "+prevyear+" AND" 
                   +" LRL.LR_ID=LR.LR_ID AND LRL.STATUS IN('Approved','Cancelled','Rejected')" 
                   +" ORDER BY LRL.APPLICATION_DATE";
		
		List<PALeaveHistory> previousApprovedLeaveHistory=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

			@Override
			public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
				// TODO Auto-generated method stub
				PALeaveHistory prevapprvedLeaveHistory=new PALeaveHistory();
				prevapprvedLeaveHistory.setLr_id(rs.getInt("LR_ID"));
				prevapprvedLeaveHistory.setSubject(rs.getString("SUBJECT"));
				prevapprvedLeaveHistory.setApplication_date(rs.getDate("APPLICATION_DATE"));
				prevapprvedLeaveHistory.setStatus(rs.getString("STATUS"));
				return prevapprvedLeaveHistory;
			}
			
		});
		return previousApprovedLeaveHistory;
	}

	@Override
	public List<PALeaveHistory> getPreviousPendingLeaveHistory(int year) {
		// TODO Auto-generated method stub
		
		String sql="SELECT LRL.LR_ID AS LR_ID,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
                   +" LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL" 
                   +" WHERE extract(YEAR From LRL.APPLICATION_DATE) = "+year
                   +" AND LRL.LR_ID=LR.LR_ID AND" 
                   +" LRL.STATUS IN('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')" 
                   +" ORDER BY LRL.APPLICATION_DATE";
		
		List<PALeaveHistory> previousPendingLHHR=jdbcTemplate.query(sql, new RowMapper<PALeaveHistory>(){

			@Override
			public PALeaveHistory mapRow(ResultSet rs, int rownum) throws SQLException {
				// TODO Auto-generated method stub

				PALeaveHistory previousPendingLeaveHistoryHR=new PALeaveHistory();
				previousPendingLeaveHistoryHR.setLr_id(rs.getInt("LR_ID"));
				previousPendingLeaveHistoryHR.setSubject(rs.getString("SUBJECT"));
				previousPendingLeaveHistoryHR.setApplication_date(rs.getDate("APPLICATION_DATE"));
				previousPendingLeaveHistoryHR.setStatus(rs.getString("STATUS"));

				return previousPendingLeaveHistoryHR;
			}
			
		});
		return previousPendingLHHR;
	}

	@Override
	public List<PALeaveHistory> getPreviousPendingLeaveHistoryEmployee(Employee_Master employee, int year) {
		// TODO Auto-generated method stub
		

		String sql="SELECT LRL.LR_ID AS LR_ID,LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LRL.APPLICATION_DATE AS APPLICATION_DATE,"
				  +" LRL.STATUS AS STATUS FROM LEAVE_REQUEST_LINES LR,LEAVE_REQUEST LRL" 
				  +" WHERE extract(YEAR From LRL.APPLICATION_DATE) = "+year+" AND LRL.EMP_ID="+employee.getEmp_id() 
				  +" AND LRL.LR_ID=LR.LR_ID" 
                  +" AND LRL.STATUS IN('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')" 
                  +" ORDER BY LRL.APPLICATION_DATE";
			
			List<PALeaveHistory> pendingleaveHistoryEmp=jdbcTemplate.query(sql,new RowMapper<PALeaveHistory>(){

				@Override
				public PALeaveHistory mapRow(ResultSet rs, int numRow) throws SQLException {
					// TODO Auto-generated method stub
					PALeaveHistory pendingleaveHistoryEMP=new PALeaveHistory();
					pendingleaveHistoryEMP.setLr_id(rs.getInt("LR_ID"));
					pendingleaveHistoryEMP.setSubject(rs.getString("SUBJECT"));
					pendingleaveHistoryEMP.setApplication_date(rs.getDate("APPLICATION_DATE"));
					pendingleaveHistoryEMP.setStatus(rs.getString("STATUS"));
					return pendingleaveHistoryEMP;
				}
				
			});
			return pendingleaveHistoryEmp;
	}
	
	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaves(Employee_Master approver) {
		
		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				+ " LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN, "
				+ " LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT "
				+ " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID "
				+ " AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND "
				+ " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+approver.getEmp_id()+""
						+ " AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
//		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,"
//					+" LR.START_DATE||' TO '||LR.END_DATE AS SUBJECT,LN.STATUS AS STATUS" 
//                    +" FROM LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL" 
//                    +" WHERE LN.LR_ID=LRL.LR_NO AND LN.LR_ID = LR.LRL_NO AND extract(YEAR From LRL.APPLICATION_DATE) ="+year+" AND"
//                    +" LN.EMP_ID = EM.EMP_ID and LN.APPROVER_ID ="+employee.getEmp_id()+" AND" 
//                    +" LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setEmp_code(rs.getString("EMP_CODE"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setStart_date(rs.getString("START_DATE"));
				pendingApprovals.setEnd_date(rs.getString("END_DATE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				return pendingApprovals;
			}
			
			
		});
		
		return notifications;
		
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeave(Employee_Master employee, Employee_Master approver) {
		
		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				+ " LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE ,LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
				+ " LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT "
				+ " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID "
				+ " AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND "
				+ " LN.EMP_ID="+employee.getEmp_id()+" and LN.APPROVER_ID ="+approver.getEmp_id()+""
						+ " AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
	
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setStart_date(rs.getString("START_DATE"));
				pendingApprovals.setEnd_date(rs.getString("END_DATE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getInt("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				return pendingApprovals;
			}
			
			
		});
		
		return notifications;
		
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForFunctional(Employee_Master approver) {

		String sql="SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN," 
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+approver.getEmp_id()+" and LN.APPROVER_TYPE = 'Functional' and LRL.STATUS = 'Pending for FR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

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
		return notifications;
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForAdministrative(Employee_Master approver) {
		
		String sql="SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN," 
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+approver.getEmp_id()+" and LN.APPROVER_TYPE = 'Administrative' and LRL.STATUS = 'Pending for AR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
		
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

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
		
		return notifications;
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaveForFunctional(Employee_Master employee,
			Employee_Master approver) {
		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE ,LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID="+employee.getEmp_id()+" and LN.APPROVER_ID ="+approver.getEmp_id()
				   +" and LN.APPROVER_TYPE = 'Functional' and LRL.STATUS = 'Pending for FR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
	
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setStart_date(rs.getString("START_DATE"));
				pendingApprovals.setEnd_date(rs.getString("END_DATE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getInt("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				return pendingApprovals;
			}
		});
		
		return notifications;
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaveForAdministartive(Employee_Master employee,
			Employee_Master approver) {
		String sql="SELECT LRL.LR_ID as LR_ID,EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				   +" LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE ,LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
				   +" LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT" 
				   +" WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID" 
				   +" AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND" 
				   +" LN.EMP_ID="+employee.getEmp_id()+" and LN.APPROVER_ID = "+approver.getEmp_id()
				   +" and LN.APPROVER_TYPE = 'Administrative' and LRL.STATUS = 'Pending for AR Approval'"
				   +" AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
	
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setStart_date(rs.getString("START_DATE"));
				pendingApprovals.setEnd_date(rs.getString("END_DATE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getInt("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				return pendingApprovals;
			}
		});
		
		return notifications;
	}

	@Override
	public boolean saveRenewdMailCommunication(RenewedMailCommunication mail) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(mail);
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
	public List<LeaveDetails> getAppiledLeaveDetail(int lr_id,int lr_no) {

		String sql = "SELECT LR.LR_NO AS LR_NO,LR.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME ||' '||+EMP.EMP_LAST_NAME AS APPLICANT_NAME,"
					+" LT.LEAVE_TYPE AS LEAVE_TYPE,LRL.REASON as REASON, "
					+" LR.APPLICATION_DATE AS APPLICATION_DATE,LRL.START_DATE AS START_DATE,LRL.END_DATE AS END_DATE,"
					+" LRL.REASON_FOR_LEAVE AS REASON_FOR_LEAVE,LRL.KNOWLEDGE_TRANSFER_SUMMARY AS KNOWLEDGE_TRANSFER_SUMMARY,"
					+ "EMP.EMAIL AS EMAIL,EMP.EMP_CODE AS EMP_CODE,LRL.DAY_TYPE AS DAY_TYPE,"
					+" (SELECT EMP.EMP_FIRST_NAME ||' '||+EMP.EMP_LAST_NAME AS EMP_NAME FROM LEAVE_REQUEST_LINES LRL,EMPLOYEE_MASTER EMP"
					+" WHERE LRL.CHARGE_HAND_OVER_TO = EMP.EMP_ID"
					+" AND LRL.LR_ID="+lr_id+") AS CHARGE_HAND_OVER_TO,"
					+" (select LN.STATUS from LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST LR WHERE LR.LR_NO = LN.LR_ID AND LN.APPROVER_TYPE='Functional' AND LN.LR_ID ="+lr_no+")"
					+" AS FUNCTIONAL_COMMENT,"
					+" (select LN.STATUS from LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST LR WHERE LR.LR_NO = LN.LR_ID AND LN.APPROVER_TYPE='Administrative' AND LN.LR_ID ="+lr_no+")"
					+" AS ADMINISTRATIVE_COMMENT,"
					+" (select LN.STATUS from LEAVE_NOTIFICATIONS LN,LEAVE_REQUEST LR WHERE LR.LR_NO = LN.LR_ID AND LN.APPROVER_TYPE='Management' AND LN.LR_ID = "+lr_no+")"
					+" AS MANAGEMENT_COMMENT"
					+" FROM LEAVE_REQUEST LR,LEAVE_REQUEST_LINES LRL,LEAVE_TYPE LT,EMPLOYEE_MASTER EMP WHERE LR.LR_ID = LRL.LR_ID AND"
					+" LR.EMP_ID = EMP.EMP_ID AND LT.L_NO = LRL.LEAVE_TYPE AND LRL.EMP_ID = EMP.EMP_ID AND LR.LR_ID ="+lr_id;
		
		List<LeaveDetails> detailsOfLeave = jdbcTemplate.query(sql, new RowMapper<LeaveDetails>(){

			@Override
			public LeaveDetails mapRow(ResultSet rs, int rowNUm) throws SQLException {
				
				LeaveDetails leaveDetail = new LeaveDetails();
				
				leaveDetail.setLR_No(rs.getInt("LR_NO"));
				leaveDetail.setLR_Id(rs.getInt("LR_ID"));
				leaveDetail.setApplicant_Name(rs.getString("APPLICANT_NAME"));
				leaveDetail.setLeave_type(rs.getString("LEAVE_TYPE"));
				if(rs.getDate("APPLICATION_DATE") != null)
				{
					leaveDetail.setApplication_Date(rs.getDate("APPLICATION_DATE"));
				}
				if(rs.getDate("START_DATE") != null)
				{
					leaveDetail.setStart_date(rs.getDate("START_DATE"));
				}
				if(rs.getDate("END_DATE") != null)
				{
					leaveDetail.setEnd_date(rs.getDate("END_DATE"));
				}
				leaveDetail.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				leaveDetail.setKnowledge_transfer_summary(rs.getString("KNOWLEDGE_TRANSFER_SUMMARY"));
				
//				leaveDetail.setFunctional_comment(All_Fr_Comment);
				leaveDetail.setFunctional_comment(rs.getString("FUNCTIONAL_COMMENT"));
				leaveDetail.setAdministrative_comment(rs.getString("ADMINISTRATIVE_COMMENT"));
				leaveDetail.setManagement_comment(rs.getString("MANAGEMENT_COMMENT"));
				leaveDetail.setCharge_hand_over_to(rs.getString("CHARGE_HAND_OVER_TO"));
				leaveDetail.setAppEmail(rs.getString("EMAIL"));
				leaveDetail.setEmpCode(rs.getString("EMP_CODE"));
				leaveDetail.setDay_type(rs.getString("DAY_TYPE"));
				leaveDetail.setReason(rs.getString("REASON"));
				return leaveDetail;
			}
			
		});
		
		return detailsOfLeave;
	
	}

	@Override
	public List<LeaveDetails> getAllApprovedLeaveList() {
		// TODO Auto-generated method stub
		String sql = "SELECT LR.LR_NO AS LR_NO,LR.LR_ID AS LR_ID,EMP.EMP_FIRST_NAME ||' '||+EMP.EMP_LAST_NAME AS APPLICANT_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
					+ "LR.APPLICATION_DATE AS APPLICATION_DATE,LRL.START_DATE AS START_DATE,LRL.END_DATE AS END_DATE,"
					+ "LRL.REASON_FOR_LEAVE AS REASON_FOR_LEAVE,LRL.KNOWLEDGE_TRANSFER_SUMMARY AS KNOWLEDGE_TRANSFER_SUMMARY"
					+ " FROM LEAVE_REQUEST LR,LEAVE_REQUEST_LINES LRL,LEAVE_TYPE LT,EMPLOYEE_MASTER EMP WHERE LR.LR_ID = LRL.LR_ID AND"
					+ " LR.EMP_ID = EMP.EMP_ID AND LT.L_NO = LRL.LEAVE_TYPE AND LRL.EMP_ID = EMP.EMP_ID"
					+ " AND TRUNC(sysdate) BETWEEN "
					+ " TRUNC(LRL.START_DATE) AND TRUNC(LRL.END_DATE) AND LR.STATUS = 'Approved'";
	
	List<LeaveDetails> detailsOfLeave = jdbcTemplate.query(sql, new RowMapper<LeaveDetails>(){

		@Override
		public LeaveDetails mapRow(ResultSet rs, int rowNUm) throws SQLException {
			
			LeaveDetails leaveDetail = new LeaveDetails();
			
			leaveDetail.setLR_No(rs.getInt("LR_NO"));
			leaveDetail.setLR_Id(rs.getInt("LR_ID"));
			leaveDetail.setApplicant_Name(rs.getString("APPLICANT_NAME"));
			leaveDetail.setLeave_type(rs.getString("LEAVE_TYPE"));
			if(rs.getDate("APPLICATION_DATE") != null)
			{
				leaveDetail.setApplication_Date(rs.getDate("APPLICATION_DATE"));
			}
			if(rs.getDate("START_DATE") != null)
			{
				leaveDetail.setStart_date(rs.getDate("START_DATE"));
			}
			if(rs.getDate("END_DATE") != null)
			{
				leaveDetail.setEnd_date(rs.getDate("END_DATE"));
			}
			leaveDetail.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
			leaveDetail.setKnowledge_transfer_summary(rs.getString("KNOWLEDGE_TRANSFER_SUMMARY"));
			
		
			return leaveDetail;
		}
		
	});
	
	return detailsOfLeave;
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForManagement(int approver) {
		// TODO Auto-generated method stub
		String sql= "SELECT LRL.LR_ID as LR_ID,LRL.LR_NO AS LR_NO,LRL.SUBJECT AS SUBJECT,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME,LT.LEAVE_TYPE AS LEAVE_TYPE,"
				  + "LR.START_DATE AS START_DATE ,LR.END_DATE AS END_DATE, LR.LEAVE_COUNT AS LEAVE_COUNT,LR.REASON_FOR_LEAVE AS REASON_FOR_LEAVE FROM LEAVE_NOTIFICATIONS LN,"
				  + "LEAVE_REQUEST_LINES LR,EMPLOYEE_MASTER EM,LEAVE_REQUEST LRL,LEAVE_TYPE LT"
				  + " WHERE LN.LR_ID=LRL.LR_NO AND LRL.LR_ID= LR.LR_ID AND LN.EMP_ID=EM.EMP_ID"
				  + " AND LR.EMP_ID=EM.EMP_ID AND LR.LEAVE_TYPE=LT.L_NO AND LRL.EMP_ID=EM.EMP_ID AND"
				  + " LN.EMP_ID=EM.EMP_ID and LN.APPROVER_ID ="+approver+" and LN.APPROVER_TYPE = 'Management' and LRL.STATUS = 'Pending for MG Approval'"
				  + " AND LN.STATUS IN('Pending for approval') ORDER BY LRL.APPLICATION_DATE";
	
		List<PendingApprovals> notifications=jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

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
				pendingApprovals.setLeave_count(rs.getInt("LEAVE_COUNT"));
				pendingApprovals.setReason_for_leave(rs.getString("REASON_FOR_LEAVE"));
				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				return pendingApprovals;
			}
		});
		
		return notifications;
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovedList(java.time.LocalDate currDate, java.time.LocalDate weekday,
			Employee_Master emp) {
		String sql;
		
		if(emp.getProfile_id() == 6)
		{
//			sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
//					+ " lrl.START_DATE  || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE from LEAVE_REQUEST lr,"
//					+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
//					+ " em.EMP_ID = lr.EMP_ID and"
//					+ " lr.EMP_ID = lrl.EMP_ID and"
//					+ " em.EMP_ID = lrl.EMP_ID and"
//					+ " lt.L_NO = lrl.LEAVE_TYPE and"
//					+ " lr.LR_ID = lrl.LR_ID and"
//					+ " lr.LR_NO = LN.LR_ID AND"
//					+ " LR.STATUS IN('Approved','Rejected') AND"
//					+	"(lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
//					+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
			
			sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
					+ " lrl.START_DATE  as START_DATE ,  lrl.END_DATE AS END_DATE, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE ,"
					+ " lrl.LEAVE_COUNT as LEAVE_COUNT from LEAVE_REQUEST lr,"
					+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
					+ " em.EMP_ID = lr.EMP_ID and"
					+ " lr.EMP_ID = lrl.EMP_ID and"
					+ " em.EMP_ID = lrl.EMP_ID and"
					+ " lt.L_NO = lrl.LEAVE_TYPE and"
					+ " lr.LR_ID = lrl.LR_ID and"
					+ " lr.LR_NO = LN.LR_ID AND"
					+ " LR.STATUS IN('Approved','Rejected') AND"
					+	"(lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
					+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
		}
		else
		{
//			sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
//					+ "lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE from LEAVE_REQUEST lr,"
//					+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
//					+ " em.EMP_ID = lr.EMP_ID and"
//					+ " lr.EMP_ID = lrl.EMP_ID and"
//					+ " em.EMP_ID = lrl.EMP_ID and"
//					+ " lt.L_NO = lrl.LEAVE_TYPE and"
//					+ " lr.LR_ID = lrl.LR_ID and"
//					+ " lr.LR_NO = LN.LR_ID AND"
//					+ " LN.APPROVER_ID = "+emp.getEmp_id()+" AND "
//					+ " LR.STATUS IN('Approved','Rejected') AND"
//					+	"(lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
//					+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
			
			sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
					+ "lrl.START_DATE AS START_DATE , lrl.END_DATE AS END_DATE, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE ,"
					+ "lrl.LEAVE_COUNT as LEAVE_COUNT from LEAVE_REQUEST lr,"
					+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
					+ " em.EMP_ID = lr.EMP_ID and"
					+ " lr.EMP_ID = lrl.EMP_ID and"
					+ " em.EMP_ID = lrl.EMP_ID and"
					+ " lt.L_NO = lrl.LEAVE_TYPE and"
					+ " lr.LR_ID = lrl.LR_ID and"
					+ " lr.LR_NO = LN.LR_ID AND"
					+ " LN.APPROVER_ID = "+emp.getEmp_id()+" AND "
					+ " LR.STATUS IN('Approved','Rejected') AND"
					+	"(lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
					+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
		}

		List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
//				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				pendingApprovals.setStatus(rs.getString("STATUS"));
				pendingApprovals.setDay_type(rs.getString("DAY_TYPE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));	
				pendingApprovals.setStartdate(rs.getDate("START_DATE"));
				pendingApprovals.setEnddate(rs.getDate("END_DATE"));
				return pendingApprovals;
			}
			
		});
		
		return notifications;
		
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingList(java.time.LocalDate currDate,
			java.time.LocalDate weekday, Employee_Master emp) {
		
		
		
		String sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
				+ "lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE from LEAVE_REQUEST lr,"
				+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
				+ " em.EMP_ID = lr.EMP_ID and"
				+ " lr.EMP_ID = lrl.EMP_ID and"
				+ " em.EMP_ID = lrl.EMP_ID and"
				+ " lt.L_NO = lrl.LEAVE_TYPE and"
				+ " lr.LR_ID = lrl.LR_ID and"
				+ " lr.LR_NO = LN.LR_ID AND"
				+ " LN.APPROVER_ID = "+emp.getEmp_id()+" AND "
				+ " LN.STATUS IN('Pending for approval') AND"
				+	"(lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
				+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD'))";
		
		List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				pendingApprovals.setStatus(rs.getString("STATUS"));
				pendingApprovals.setDay_type("DAY_TYPE");
				pendingApprovals.setLeave_type("LEAVE_TYPE");
				return pendingApprovals;
			}
			
		});
		
return notifications;
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForFr(String currDate,
			String weekday,int  emp) {
		
			
			String sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
					+ " lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE , lrl.START_DATE AS START_DATE,"
					+ " lrl.END_DATE AS END_DATE , lrl.LEAVE_COUNT as LEAVE_COUNT"
					+ " from LEAVE_REQUEST lr,"
					+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
					+ " em.EMP_ID = lr.EMP_ID and lr.EMP_ID = lrl.EMP_ID and em.EMP_ID = lrl.EMP_ID and lt.L_NO = lrl.LEAVE_TYPE and lr.LR_ID = lrl.LR_ID and"
					+ " lr.LR_NO = LN.LR_ID AND LN.APPROVER_ID = "+emp+" AND  LN.APPROVER_TYPE = 'Functional' AND LR.STATUS = 'Pending for FR Approval' AND"
					+ " LN.STATUS IN('Pending for approval') AND"
					+ " (lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
					+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
		 
			List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

			@Override
			public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				PendingApprovals pendingApprovals=new PendingApprovals();
				pendingApprovals.setLr_id(rs.getInt("LR_ID"));
				pendingApprovals.setLr_no(rs.getInt("LR_NO"));
				pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
				pendingApprovals.setSubject(rs.getString("SUBJECT"));
				pendingApprovals.setStatus(rs.getString("STATUS"));
				pendingApprovals.setDay_type(rs.getString("DAY_TYPE"));
				pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
				
				pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));	
				pendingApprovals.setStartdate(rs.getDate("START_DATE"));
				System.out.println("END_DATE ==> "+rs.getDate("END_DATE"));
				pendingApprovals.setEnddate(rs.getDate("END_DATE"));
				return pendingApprovals;
			}
			
		});
		
		return notifications;
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForAr(String currDate,
			String weekday, int emp) {
		
		String sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
				+ " lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE ,"
				+ " lrl.START_DATE AS START_DATE, lrl.END_DATE AS END_DATE , lrl.LEAVE_COUNT as LEAVE_COUNT  "
				+ " from LEAVE_REQUEST lr,"
				+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
				+ " em.EMP_ID = lr.EMP_ID and lr.EMP_ID = lrl.EMP_ID and em.EMP_ID = lrl.EMP_ID and lt.L_NO = lrl.LEAVE_TYPE and lr.LR_ID = lrl.LR_ID and"
				+ " lr.LR_NO = LN.LR_ID AND LN.APPROVER_ID = "+emp+" AND  LN.APPROVER_TYPE = 'Administrative' AND LR.STATUS = 'Pending for AR Approval' AND"
				+ " LN.STATUS IN('Pending for approval') AND"
				+ " (lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
				+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
	 
		List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

		@Override
		public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PendingApprovals pendingApprovals=new PendingApprovals();
			pendingApprovals.setLr_id(rs.getInt("LR_ID"));
			pendingApprovals.setLr_no(rs.getInt("LR_NO"));
			pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
			pendingApprovals.setSubject(rs.getString("SUBJECT"));
			pendingApprovals.setStatus(rs.getString("STATUS"));
			pendingApprovals.setDay_type(rs.getString("DAY_TYPE"));
			pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
			pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
//			System.out.println("LEAVE_COUNT ==> "+rs.getFloat("LEAVE_COUNT"));
			pendingApprovals.setStartdate(rs.getDate("START_DATE"));
			System.out.println("End Date  ==> "+rs.getDate("END_DATE"));
			pendingApprovals.setEnddate(rs.getDate("END_DATE"));
			return pendingApprovals;
		}
		
	});
	
	
	
	
	return notifications;
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForMG(String currDate,
			String weekday, int emp) {
		
		
		String sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
				+ " lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE ,"
				+ " lrl.START_DATE AS START_DATE, lrl.END_DATE AS END_DATE ,lrl.LEAVE_COUNT as LEAVE_COUNT  from LEAVE_REQUEST lr,"
				+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
				+ " em.EMP_ID = lr.EMP_ID and lr.EMP_ID = lrl.EMP_ID and em.EMP_ID = lrl.EMP_ID and lt.L_NO = lrl.LEAVE_TYPE and lr.LR_ID = lrl.LR_ID and"
				+ " lr.LR_NO = LN.LR_ID AND LN.APPROVER_ID = "+emp+" AND  LN.APPROVER_TYPE = 'Management' AND LR.STATUS = 'Pending for MG Approval' AND"
				+ " LN.STATUS IN('Pending for approval') AND"
				+ " (lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
				+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
	 
		List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

		@Override
		public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PendingApprovals pendingApprovals=new PendingApprovals();
			pendingApprovals.setLr_id(rs.getInt("LR_ID"));
			pendingApprovals.setLr_no(rs.getInt("LR_NO"));
			pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
			pendingApprovals.setSubject(rs.getString("SUBJECT"));
			pendingApprovals.setStatus(rs.getString("STATUS"));
			pendingApprovals.setDay_type(rs.getString("DAY_TYPE"));
			pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
			pendingApprovals.setStartdate(rs.getDate("START_DATE"));
			pendingApprovals.setEnddate(rs.getDate("END_DATE"));
//			System.out.println("End Date  ==> "+rs.getDate("END_DATE"));
			pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
//			System.out.println("LEAVE_COUNT ==> "+rs.getFloat("LEAVE_COUNT"));
			return pendingApprovals;
		}
		
	});
	
	
	
	
	return notifications;
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForHR(String currDate, String weekday, int emp) {
		// TODO Auto-generated method stub
		
		String sql = "select lr.LR_NO AS LR_NO, em.EMP_FIRST_NAME||' '|| em.EMP_LAST_NAME AS EMP_NAME,lr.LR_ID AS LR_ID,lr.STATUS as STATUS,"
				+ " lrl.START_DATE || ' TO ' || lrl.END_DATE AS SUBJECT, lrl.DAY_TYPE as DAY_TYPE, lt.LEAVE_TYPE AS LEAVE_TYPE,"
				+ " lrl.START_DATE AS START_DATE, lrl.END_DATE AS END_DATE ,lrl.LEAVE_COUNT as LEAVE_COUNT from LEAVE_REQUEST lr,"
				+ " LEAVE_REQUEST_LINES lrl, LEAVE_TYPE lt, EMPLOYEE_MASTER em,LEAVE_NOTIFICATIONS LN where"
				+ " em.EMP_ID = lr.EMP_ID and lr.EMP_ID = lrl.EMP_ID and em.EMP_ID = lrl.EMP_ID and lt.L_NO = lrl.LEAVE_TYPE and lr.LR_ID = lrl.LR_ID and"
				+ " lr.LR_NO = LN.LR_ID AND"
				+ " LN.STATUS IN('Pending for approval') AND"
				+ " (lrl.START_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')"
				+ " or lrl.END_DATE between TO_DATE('"+weekday+"', 'YYYY-MM-DD') AND TO_DATE('"+currDate+"', 'YYYY-MM-DD')) order by lr.application_date";
	 
		List<PendingApprovals> notifications= jdbcTemplate.query(sql, new RowMapper<PendingApprovals>(){

		@Override
		public PendingApprovals mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PendingApprovals pendingApprovals=new PendingApprovals();
			pendingApprovals.setLr_id(rs.getInt("LR_ID"));
			pendingApprovals.setLr_no(rs.getInt("LR_NO"));
			pendingApprovals.setEmp_name(rs.getString("EMP_NAME"));
			pendingApprovals.setSubject(rs.getString("SUBJECT"));
			pendingApprovals.setStatus(rs.getString("STATUS"));
			pendingApprovals.setDay_type(rs.getString("DAY_TYPE"));
			pendingApprovals.setLeave_type(rs.getString("LEAVE_TYPE"));
			pendingApprovals.setLeave_count(rs.getFloat("LEAVE_COUNT"));
//			System.out.println("LEAVE_COUNT ==> "+rs.getFloat("LEAVE_COUNT"));
			pendingApprovals.setStartdate(rs.getDate("START_DATE"));
			pendingApprovals.setEnddate(rs.getDate("END_DATE"));
//			System.out.println("End Date  ==> "+rs.getDate("END_DATE"));
			return pendingApprovals;
		}
		
	});
	return notifications;
	}

	@Override
	public boolean saveLeaveRequestLinesForProbation(List<LeaveRequestLines> leaveRequestLines) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			for(LeaveRequestLines lrl : leaveRequestLines){
				session.save(lrl);
			}
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
	public int deleteLeave(Object o) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(o);
			return 0;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return 0;
	}

	@Override
	public List<Employee_Master> employeeLeaveApplicable(int employeeId) {
		// TODO Auto-generated method stub
		String sql = "SELECT ODAPPLICABLE from employee_master where emp_id='" + employeeId + "'";
		List<Employee_Master> employeesList = jdbcTemplate.query(sql, new RowMapper<Employee_Master>() {

			@Override
			public Employee_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee_Master t = new Employee_Master();

				t.setOd_applicable(rs.getString("ODAPPLICABLE"));

				return t;
			}

		});
		return employeesList;
	}

	@Override
	public int updateLeaveApplicable(Employee_Master employeeMaster) {
		// TODO Auto-generated method stub
		String sql = "UPDATE EMPLOYEE_MASTER SET ODAPPLICABLE= '" + employeeMaster.getOd_applicable()
				+ "' WHERE EMP_Id='" + employeeMaster.getEmp_id() + "'";

		jdbcTemplate.execute(sql);
		return 1;
	}

	@Override
	public List<Employee_Master> employeeCodeList() {
		// TODO Auto-generated method stub
		String sql="SELECT Emp_id , EMP_CODE ,Emp_first_name,EMP_LAST_NAME FROM EMPLOYEE_MASTER WHERE IS_ACTIVATED='Y' ";
		List<Employee_Master> employeesList = jdbcTemplate.query(sql, new RowMapper<Employee_Master>() {

					@Override
					public Employee_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee_Master t = new Employee_Master();

						t.setEmp_id(rs.getInt("Emp_id"));
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmp_first_name(rs.getString("emp_first_name"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));

						return t;
					}

				});
		return employeesList;
	}

	@Override
	public List<Employee_Master> readEmployeeLeavesApplicable() {
		// TODO Auto-generated method stub
        String sql="SELECT EMP_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,ODAPPLICABLE FROM EMPLOYEE_MASTER WHERE ODAPPLICABLE='Y' AND is_activated = 'Y' ";
		List<Employee_Master> attendanceList = jdbcTemplate.query(sql, new RowMapper<Employee_Master>() {

			@Override
			public Employee_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee_Master t = new Employee_Master();
				
				t.setEmp_code(rs.getString("EMP_CODE"));
				t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
				t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
				t.setOd_applicable(rs.getString("ODAPPLICABLE"));
				return t;
			}

		});
		return attendanceList;
	}

	@Override
	public List<Rules_Documents> getRulesDocument(int doc_id) {

		List<Rules_Documents> lines = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Rules_Documents where document_type_id = :document_type_id";
			Query sql = session.createQuery(query);
			sql.setParameter("document_type_id", doc_id);
			lines = (List<Rules_Documents>) sql.list();
			System.out.println("rules documents===>"+lines);
			return lines;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return lines;
	}

	@Override
	public List<Rules_Documents> getAllRulesDocument() {
		// TODO Auto-generated method stub
		List<Rules_Documents> lines = null;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Rules_Documents";
			Query sql = session.createQuery(query);
			lines = (List<Rules_Documents>) sql.list();
			return lines;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			tx.commit();
			session.close();
			System.gc();
		}
		
		return lines;
	}

	@Override
	public List<Rules_Document_Type> getRulesdocTypes() {
		// TODO Auto-generated method stub
		List<Rules_Document_Type> docTypes = new ArrayList<>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String query = "from Rules_Document_Type";
			Query sql = session.createQuery(query);
			
			docTypes = (List<Rules_Document_Type>) sql.list();
			
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
	public List<EmployeeStatus> GetLeaveDetails(java.time.LocalDate localDate, int empId,String leavetype,
			String pl_with_Lwp,String Cl_with_Lwp) {
		// TODO Auto-generated method stub

		String sql="";
		
		if(leavetype.equalsIgnoreCase("PL") && pl_with_Lwp.equalsIgnoreCase("FALSE")) {
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
					"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
					"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('5','1') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";

		}else if(leavetype.equalsIgnoreCase("PL") && pl_with_Lwp.equalsIgnoreCase("TRUE")) {
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
						"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('1') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
		
		}else if(leavetype.equalsIgnoreCase("CL")&& Cl_with_Lwp.equalsIgnoreCase("FALSE")){
			
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
						"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('5','2') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
		
		}else if(leavetype.equalsIgnoreCase("CL")&& Cl_with_Lwp.equalsIgnoreCase("TRUE")){
			
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
						"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('2') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
		
		}else if(leavetype.equalsIgnoreCase("LWP")&& Cl_with_Lwp.equalsIgnoreCase("FALSE")){
			
			System.out.println("lwp with cl==========>");
			
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
						"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('1') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
			
		}

		List<EmployeeStatus> attendanceList1 = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

				@Override
				public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
					EmployeeStatus t = new EmployeeStatus();
					t.setStatus(rs.getString("status"));
					t.setLeave_type(rs.getString("leave_type"));
					t.setDayType(rs.getString("DAY_TYPE"));
					return t;
				}

			});
		
if(attendanceList1.size()>0) {
			
			
			return attendanceList1;
		}else {
			
			if(leavetype.equalsIgnoreCase("LWP") && pl_with_Lwp.equalsIgnoreCase("FALSE")) {
				
			System.out.println("lwp with PL====================>");
				
				 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr,\r\n" + 
							"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
							"lrl.END_DATE >= to_char(TO_DATE('"+localDate+"','YYYY-MM-DD'),'dd-MON-YY') AND LRL.LEAVE_TYPE IN('2') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
			}
			
			List<EmployeeStatus> attendanceList2 = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

				@Override
				public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
					EmployeeStatus t = new EmployeeStatus();
					t.setStatus(rs.getString("status"));
					t.setLeave_type(rs.getString("leave_type"));
					t.setDayType(rs.getString("DAY_TYPE"));
					return t;
				}

			});
			
			return attendanceList2;
		}
		
		
	}

	@Override
	public ArrayList<Leave_creadit_report> getLeaveCreditrepo(String leavetype, String date) {
		// TODO Auto-generated method stub

		String sql="SELECT EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,LCR.EMP_ID,\r\n" + 
				"LCR.LEAVE_CREDITED,TO_CHAR(TO_DATE(LCR.UPDATED_DATE,'YYYY-MM'),'MON-YYYY') AS UPDATED_DATE,LCR.CREATED_DATE,LCR.LEAVE_TYPE \r\n" + 
				"FROM LEAVE_CREADIT_REPORT LCR , EMPLOYEE_MASTER EM\r\n" + 
				"WHERE EM.EMP_ID=LCR.EMP_ID AND\r\n" + 
				"UPDATED_DATE='"+date+"' and LEAVE_TYPE='"+leavetype+"' ";
		
		 List<Leave_creadit_report> attendanceList = jdbcTemplate.query(sql, new RowMapper<Leave_creadit_report>() {

				@Override
				public Leave_creadit_report mapRow(ResultSet rs, int rowNum) throws SQLException {
					Leave_creadit_report t = new Leave_creadit_report();
					t.setEmp_name(rs.getString("EMP_FIRST_NAME")+" "+rs.getString("EMP_LAST_NAME"));
					t.setEmpid(rs.getInt("EMP_ID"));
					t.setLeave_creadited(rs.getFloat("LEAVE_CREDITED"));
					t.setUpdated_date(rs.getString("UPDATED_DATE"));
					t.setCreated_date(rs.getDate("CREATED_DATE"));
					t.setLeavetype(rs.getString("LEAVE_TYPE"));
					
					return t;
				}

			});
			return (ArrayList<Leave_creadit_report>) attendanceList;
	}

	@Override
	public List<BioMax_Details> getBiomaxDetails(String date) {
		// TODO Auto-generated method stub
		
		String sql="SELECT ATTID,EMPLOYEE_CODE,LOGDATE,to_char(LOGDATETIME) AS LOGDATETIME,DIRECTIONS FROM BIOMAXATTENDANCE\r\n" + 
				"WHERE TO_CHAR(LOGDATE,'yyyy-mm-dd')='"+date+"' order by ATTID ASC";
		
		System.out.println("test====>"+sql);
		
		 List<BioMax_Details> attendanceList = jdbcTemplate.query(sql, new RowMapper<BioMax_Details>() {

				@Override
				public BioMax_Details mapRow(ResultSet rs, int rowNum) throws SQLException {
					BioMax_Details t = new BioMax_Details();
					t.setAttid(rs.getInt("ATTID"));
					t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
					t.setLogdate(rs.getString("LOGDATE"));
					t.setLogdatetime(rs.getString("LOGDATETIME"));
					t.setDirection(rs.getString("DIRECTIONS"));
					
					
					return t;
				}

			});
			return  attendanceList;
	}

	
}
