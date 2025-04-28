package com.omfysgroup.ajanhcm.daoImpl;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.web.servlet.ModelAndView;

import com.omfysgroup.ajanhcm.dao.ExitModule_Dao;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.KtKakerCount;
import com.omfysgroup.ajanhcm.model.KtNotifivationHead;
import com.omfysgroup.ajanhcm.model.KtPlans;
import com.omfysgroup.ajanhcm.model.MarkExitScreen;
import com.omfysgroup.ajanhcm.model.Particulars_addGroup;



@Repository("ExitModule_Dao")
public class ExitModule_dao_imp  implements ExitModule_Dao{

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean saveKtModule(KtPlans ktplans) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ktplans);
	
		} catch (Exception e) {
			 flag =false;
			e.printStackTrace();
		} finally {
			tx.commit();
			flag= true;
			session.close();
			System.gc();
		}

		return flag;
	}

	@Override
	public boolean saveParticulars(Particulars_addGroup part_grp) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(part_grp);
	
		} catch (Exception e) {
			 flag =false;
			e.printStackTrace();
		} finally {
			tx.commit();
			flag= true;
			session.close();
			System.gc();
		}

		return flag;
	
	}

	@Override
	public int SaveExitRequest(MarkExitScreen markExit) {
		// TODO Auto-generated method stub
		//boolean flag = false;
		int id=0;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(markExit);
	       id=markExit.getExitid();
	       return id;
		} catch (Exception e) {
			 //flag =false;
			e.printStackTrace();
		} finally {
			tx.commit();
			//flag= true;
			session.close();
			System.gc();
		}

		return id;
	
	}

	@Override
	public List<MarkExitScreen> getexitnotificationList(Employee_Master emp) {
		// TODO Auto-generated method stub
		
		 String sql = "SELECT IS_APPLICABLE,EMP_ID,EMPLOYEE_NAME,EXIT_TYPE FROM MARK_EXIT_SCREEN WHERE EMP_ID ="+ emp.getEmp_id()
					+ " AND IS_APPLICABLE = 'Y'";

			   List<MarkExitScreen> marked = jdbcTemplate.query(sql, new RowMapper<MarkExitScreen>() {
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
		
			  
		    return marked;
	}

	@Override
	public List<KtNotifivationHead> getKtplansnotificationList(Employee_Master emp) {
		// TODO Auto-generated method stub
		
		
//		String sql1 ="SELECT K.KT_GIVERS,K.AR_NOS,K.KTSTATUS,P.AR_NO,P.ADMINISTRATIVE_REPORTING_ID  FROM KT_PLAN_HEADER K LEFT JOIN  ADMINISTRATIVE_REPORTING P ON  P.AR_NO =K.AR_NOS"   
//				+" WHERE K.KTSTATUS ='Pending for Approval' AND P.ADMINISTRATIVE_REPORTING_ID="+emp.getEmp_id();
//		
		String sql1= "SELECT K.KT_GIVERS as KT_GIVER, K.AR_NOS as AR_NOS ,K.KTSTATUS as KTSTATUS ,P.AR_NO as AR_NO ,P.ADMINISTRATIVE_REPORTING_ID as ADMINISTRATIVE_REPORTING_ID ,EM.EMP_CODE AS EMP_CODE, EM.EMP_FIRST_NAME||' '||EM.EMP_LAST_NAME as EMP_NAME"
				+" FROM KT_PLAN_HEADER K ,ADMINISTRATIVE_REPORTING P ,EMPLOYEE_MASTER EM  WHERE P.AR_NO =K.AR_NOS "   
					+" AND K.KT_GIVERS=EM.EMP_ID AND K.KTSTATUS = 'Pending for Approval' AND P.ADMINISTRATIVE_REPORTING_ID="+emp.getEmp_id();
		       
		List<KtNotifivationHead> ktplan = jdbcTemplate.query(sql1, new RowMapper<KtNotifivationHead>() {
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
		return ktplan;
	}

	@Override
	public boolean isFunctionalReporter(int emp_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Functional_Reporting> fr = new ArrayList<Functional_Reporting>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Functional_Reporting f where f.functional_reporting_id.emp_id = :emp_id";
			Query sql = session.createQuery(query);
			sql.setParameter("emp_id", emp_id);
			fr = sql.list();
			if (fr.size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return flag;
	}

	@Override
	public boolean isKtGiver(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<KtPlans> ktList = new ArrayList<KtPlans>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from KtPlans k where k.ktgiver.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			ktList = sql.list();
			if (ktList.size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return flag;
	}

	@Override
	public boolean isAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Administrative_Reporting> ar = new ArrayList<Administrative_Reporting>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Administrative_Reporting a where a.administrative_reporting_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			ar = sql.list();
			if (ar.size() > 0) {
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return false;
	}
 
	@Override
	public List<KtPlans> getAdminsnotificationList(int employeeid) {
		// TODO Auto-generated method stub
		String sql1 ="SELECT DISTINCT K.KT_GIVER, K.AR_ID,K.KT_STATUS,P.AR_NO,P.ADMINISTRATIVE_REPORTING_ID"
				+ "FROM KT_PLANS K LEFT JOIN  ADMINISTRATIVE_REPORTING P ON  P.AR_NO =K.AR_ID"  
				+"WHERE	( K.KT_STATUS='Pending' OR K.KT_STATUS='Pending for Approval') AND P.ADMINISTRATIVE_REPORTING_ID="+employeeid;
		
		        List<KtPlans> ktplans = jdbcTemplate.query(sql1, new RowMapper<KtPlans>() {
				@Override
				public KtPlans mapRow(ResultSet rs, int numRow) throws SQLException {
					KtPlans kts = new KtPlans();
					Employee_Master emp =new Employee_Master();	
					emp.setEmp_id(rs.getInt("KT_GIVER"));
					kts.setKtgiver(emp);
					Administrative_Reporting ads = new Administrative_Reporting();
					ads.setAr_no(rs.getInt("AR_ID"));
					kts.setAr_id(ads);
					kts.setKtstatus(rs.getString("KT_STATUS"));
					
					return kts;
				}
		  });
		return ktplans;
	}

	@Override
	public List<KtKakerCount> getktdetails(int employeeid) {
		// TODO Auto-generated method stub
		
		String sql="SELECT MIN(PLANNED_START_DATE) AS START_DATE,MAX(PLANNED_END_DATE) AS END_DATE,KT_TAKERS AS KT_TAKERS  from KT_PLANS where KT_STATUS='Approved' and KT_TAKERS="+employeeid+ " GROUP BY KT_TAKERS";
		
		 List<KtKakerCount> kttakersC = jdbcTemplate.query(sql, new RowMapper<KtKakerCount>() {
				@Override
				public KtKakerCount mapRow(ResultSet rs, int numRow) throws SQLException {
					KtKakerCount ktcount = new KtKakerCount();
					ktcount.setKttakers(rs.getInt("KT_TAKERS"));
					ktcount.setMinDates(rs.getDate("START_DATE"));
					ktcount.setMaxdates(rs.getDate("END_DATE"));
					
					return ktcount;
				}
		  });
		return kttakersC;
	}

	public List<Administrative_Reporting> getAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		List<Administrative_Reporting> adminstrativeReporter = new ArrayList<Administrative_Reporting>();
		Session session = hibernateTemplate.getSessionFactory().openSession();
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
	public Employee_Master getEmployee(int empid) {
		Employee_Master ExitObj = new Employee_Master();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Employee_Master e where e.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			ExitObj = (Employee_Master) sql.uniqueResult();
			return ExitObj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return ExitObj;
	}

	@Override
	public String getKtPlanExcelFilePath(int kthead_id, Environment environment) {
		return null;}
}
