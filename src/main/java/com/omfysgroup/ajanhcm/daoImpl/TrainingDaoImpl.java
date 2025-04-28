package com.omfysgroup.ajanhcm.daoImpl;



import org.hibernate.Transaction;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;

import com.omfysgroup.ajanhcm.dao.TrainingDao;
import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.Assessment;
import com.omfysgroup.ajanhcm.model.Assessment_Lines;
import com.omfysgroup.ajanhcm.model.Compentency_Group;
import com.omfysgroup.ajanhcm.model.Compentency_Master;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.InhouseTrainingSheet;
import com.omfysgroup.ajanhcm.model.MailCommunication;
import com.omfysgroup.ajanhcm.model.RequestedTraining;
import com.omfysgroup.ajanhcm.model.SubCompentency;
import com.omfysgroup.ajanhcm.model.TraineeTrainingSheet;
import com.omfysgroup.ajanhcm.model.Trainee_Training_Sh_Lines;
import com.omfysgroup.ajanhcm.model.TrainingSheetADFR;
import com.omfysgroup.ajanhcm.model.Training_Master;
import com.omfysgroup.ajanhcm.model.Training_Request_Notification;
import com.omfysgroup.ajanhcm.model.Training_Sheet_Lines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("TrainingDao")
public class TrainingDaoImpl implements TrainingDao {

	@Autowired
	HibernateTemplate hibernatetemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	

	@Override
	public int add_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines) {
		// TODO Auto-generated method stub
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(training_sheet_lines);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return 0;
	}

	@Override
	public List<Training_Sheet_Lines> getTaskList(int trId) {
		// TODO Auto-generated method stub
		List<Training_Sheet_Lines> tr_lines = new ArrayList<Training_Sheet_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Sheet_Lines t where t.tr_sh_id.tr_id = :trId";
			Query sql = session.createQuery(query);
			sql.setParameter("trId", trId);
			tr_lines = sql.list();
			return tr_lines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_lines;
	}

	@Override
	public List<Training_Master> getTrainee(int empid) {
		// TODO Auto-generated method stub
		List<Training_Master> traineeList = new ArrayList<Training_Master>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		String status = "Ongoing";
		String status1 = "Approved";
		String status2 = "Completed";
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainee_id.emp_id = :empid and (t.status = :status or t.status = :status1 or t.status = :status2)";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			sql.setParameter("status", status);
			sql.setParameter("status1", status1);
			sql.setParameter("status2", status2);
			traineeList = sql.list();
			
			return traineeList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return traineeList;
	}

	@Override
	public List<Training_Master> getTrainer(int empid) {
		// TODO Auto-generated method stub
		List<Training_Master> trainerList = new ArrayList<Training_Master>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainer_id.emp_id = :empid";
			Query sql = session.createQuery(query);

			sql.setParameter("empid", empid);
			trainerList = sql.list();
			return trainerList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return trainerList;

	}

	@Override
	public Functional_Reporting getFunctionalReporter(int empid) {
		// TODO Auto-generated method stub
		Functional_Reporting functionalReporter = new Functional_Reporting();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Functional_Reporting f where f.emp_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			functionalReporter = (Functional_Reporting) sql.uniqueResult();
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
	public List<Administrative_Reporting> getAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
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
	public int update_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines) {
		// TODO Auto-generated method stub
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(training_sheet_lines);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return 0;
	}

	@Override
	public int insert_Mail_Communication(MailCommunication mailComm) {
		// TODO Auto-generated method stub
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.saveOrUpdate(mailComm);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return 0;
	}

	@Override
	public List<Training_Master> getTrainingSheetADGrid(int adrid) {

		String sql2 = "SELECT * FROM TRAINING_SHEET_MASTER TRM,ADMINISTRATIVE_REPORTING AR WHERE AR.ADMINISTRATIVE_REPORTING_ID ="
				+ adrid + "AND AR.EMP_ID=TRM.TRAINEE_ID AND TRM.STATUS='Pending for Approval'";

		List<Training_Master> dml2 = jdbcTemplate.query(sql2, new RowMapper<Training_Master>() {

			@Override
			public Training_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
				Training_Master trmasterAd = new Training_Master();
				int traineeid = rs.getInt("TRAINEE_ID");
				int trainerid = rs.getInt("TRAINER_ID");
				Employee_Master traineeIdobj = getEmployee(traineeid);
				Employee_Master trainerIdobj = getEmployee(trainerid);
				trmasterAd.setTr_id(rs.getInt("TR_ID"));
				trmasterAd.setSubject(rs.getString("SUBJECT"));
				trmasterAd.setTrainee_id(traineeIdobj);
				trmasterAd.setTrainer_id(trainerIdobj);
				trmasterAd.setStatus(rs.getString("STATUS"));
				return trmasterAd;
			}

		});
		

		return (List<Training_Master>) dml2;

	}

	@Override
	public Employee_Master getEmployee(int empid) {
		Employee_Master traineeObj = new Employee_Master();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Employee_Master e where e.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			traineeObj = (Employee_Master) sql.uniqueResult();
			return traineeObj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return traineeObj;

	}

	@Override
	public Training_Master add_TrainingMaster(Training_Master trainging_Master) {
		// TODO Auto-generated method stub
		Training_Master tr_id = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(trainging_Master);
			System.out.println("tr id ==> "+trainging_Master.getTr_id());
			String query = "from Training_Master where tr_id =:tr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_id", trainging_Master.getTr_id());
			tr_id = (Training_Master) sql.uniqueResult();
			return tr_id;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_id;
	}

	@Override
	public boolean saveTrainingRequestNotification(Training_Request_Notification notifications) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(notifications);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isFunctionalReporter(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Functional_Reporting> fr = new ArrayList<Functional_Reporting>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Functional_Reporting f where f.functional_reporting_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
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
	public boolean isAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Administrative_Reporting> ar = new ArrayList<Administrative_Reporting>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
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

	@SuppressWarnings("unchecked")
	@Override
	public boolean isTrainer(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Training_Master> trainerList = new ArrayList<Training_Master>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainer_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			trainerList = sql.list();
			if (trainerList.size() > 0) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Training_Master> getTrainingSheetTrainerGrid(int trainerid) {
		// TODO Auto-generated method stub
		List<Training_Master> trainerShGrList = new ArrayList<Training_Master>();
		String status = "Pending";
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainer_id.emp_id = :trainerid and status =:status";
			Query sql = session.createQuery(query);
			sql.setParameter("trainerid", trainerid);
			sql.setParameter("status", status);
			trainerShGrList = sql.list();
			return trainerShGrList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerShGrList;
	}

	@Override
	public int update_Training_Master(Training_Master training_master) {
		// TODO Auto-generated method stub
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(training_master);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return 0;
	}

	@Override
	public Training_Master getTrainingMaster(int tr_id) {
		Training_Master trmaster = new Training_Master();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.tr_id = :tr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_id", tr_id);
			trmaster = (Training_Master) sql.uniqueResult();
			return trmaster;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return trmaster;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Training_Master> getTrainingSheetTraineeGrid(int traineeId) {
		// TODO Auto-generated method stub
		List<Training_Master> trainerShGrList = new ArrayList<Training_Master>();
		String status = "Approved";
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainee_id.emp_id = :traineeId and status =:status";
			Query sql = session.createQuery(query);
			sql.setParameter("trainerid", traineeId);
			sql.setParameter("status", status);
			trainerShGrList = sql.list();
			return trainerShGrList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerShGrList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isTrainee(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Training_Master> traineeList = new ArrayList<Training_Master>();
		
		List<TraineeTrainingSheet> inhousetraineeList = new ArrayList<TraineeTrainingSheet>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Master t where t.trainee_id.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			traineeList = sql.list();
			
			String query1 = "from TraineeTrainingSheet t where t.trainee.emp_id = :empid";
			Query sql1 = session.createQuery(query1);
			sql1.setParameter("empid", empid);
			inhousetraineeList = sql1.list();
			
			if (traineeList.size() > 0 || inhousetraineeList.size() > 0) {
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
	public List<Training_Sheet_Lines> getPlannedStartDate(int tr_id) {
		// TODO Auto-generated method stub
		String sql = "select MIN(PL_START_DATE) PL_START_DATE from TRAINING_SHEET_LINE where TR_SH_ID=" + tr_id;
		List<Training_Sheet_Lines> dml = jdbcTemplate.query(sql, new RowMapper<Training_Sheet_Lines>() {

			@Override
			public Training_Sheet_Lines mapRow(ResultSet rs, int rowNum) throws SQLException {
				Training_Sheet_Lines aContact = new Training_Sheet_Lines();
				
				aContact.setPlannnedStartDate(rs.getDate("PL_START_DATE"));
				return aContact;
			}

		});

		return dml;
	}

	@Override
	public List<Training_Sheet_Lines> getPlannedEndDate(int tr_id) {
		// TODO Auto-generated method stub
		String sql1 = "select MAX(PL_END_DATE) PL_END_DATE from TRAINING_SHEET_LINE where TR_SH_ID=" + tr_id;

		List<Training_Sheet_Lines> dml1 = jdbcTemplate.query(sql1, new RowMapper<Training_Sheet_Lines>() {

			@Override
			public Training_Sheet_Lines mapRow(ResultSet resultset, int rowNum) throws SQLException {
				Training_Sheet_Lines aContact1 = new Training_Sheet_Lines();
				aContact1.setPlannnedEndDate(resultset.getDate("PL_END_DATE"));
				return aContact1;
			}

		});

		return dml1;

	}

	@Override
	public float calculateDeviation(Date planStartDate, Date planEndDate, Date actualStartDate, Date actualEndDate) {
		// TODO Auto-generated method stub
		float deviationper = 0.0f;
		float division;
		float deviation;
		float targetdate = planEndDate.getTime() - planStartDate.getTime();
		float targetdateDays = targetdate / (24 * 60 * 60 * 1000);
		
		float actualDay = actualEndDate.getTime() - actualStartDate.getTime();
		float actualDayDays = actualDay / (24 * 60 * 60 * 1000);

		

		deviation = actualDayDays - targetdateDays;

		if (deviation > 0) {
			division = deviation / targetdateDays;
			deviationper = division * 100;
		}

		return deviationper;
	}

	@Override
	public boolean isCompletedTask(int tr_lines_id) {
		boolean flag = false;
		Training_Sheet_Lines trSheetLine = new Training_Sheet_Lines();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Sheet_Lines t where t.tr_lines_id = :tr_lines_id and status ='Completed'";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_lines_id", tr_lines_id);
			trSheetLine = (Training_Sheet_Lines) sql.uniqueResult();
			if (!(trSheetLine == null)) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Training_Sheet_Lines> getCompletedTask(int trId) {
		// TODO Auto-generated method stub
		List<Training_Sheet_Lines> tr_lines = new ArrayList<Training_Sheet_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		String status = "Completed";
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Sheet_Lines t where t.tr_sh_id.tr_id = :trId and t.status =:status";
			Query sql = session.createQuery(query);
			sql.setParameter("trId", trId);
			sql.setParameter("status", status);
			tr_lines = sql.list();
			return tr_lines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_lines;
	}

	@Override
	public float calTotalDeviation(int trId, int trlinesid) {
		// TODO Auto-generated method stub
		float totaldeviation = 0.0f;
		float aggrDeviation = 0.0f;
		float totalTargetDay = 0.0f;
		float totalactualDay = 0.0f;
		float deviationper = 0.0f;
		float deviation;
		float division;

		@SuppressWarnings("unchecked")
		// ArrayList<Training_Master> trm = (ArrayList<Training_Master>)
		// hibernatetemplate.find("from Training_Master where tr_id=?",trId);
		// Training_Master trMaster=trm.get(0);
		List<Training_Sheet_Lines> trShLines1 = getCompletedTask(trId);
		int compTaskSize = trShLines1.size();
		if (compTaskSize != 0) {
			for (int i = 0; i < trShLines1.size(); i++) {
				
				float targetdate = trShLines1.get(i).getPlEndDate().getTime()
						- trShLines1.get(i).getPlStartDate().getTime();
				float targetdateDays = targetdate / (24 * 60 * 60 * 1000);
				totalTargetDay = totalTargetDay + targetdateDays;
				
				float actualDay = trShLines1.get(i).getActualStDate().getTime()
						- trShLines1.get(i).getActualEndDate().getTime();
				float actualDayDays = actualDay / (24 * 60 * 60 * 1000);
				totalactualDay = totalactualDay + actualDayDays;
			}

			deviation = totalactualDay - totalTargetDay;

			if (deviation > 0) {
				division = deviation / totalTargetDay;
				deviationper = division * 100;
			}
		}

		return deviationper;
	}

	@Override
	public boolean save_Training_Sheet_Lines(List<Training_Sheet_Lines> training_sheet_lines) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (Training_Sheet_Lines trshliobj : training_sheet_lines) {
				session.save(trshliobj);
			}
			return true;
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
	public Compentency_Master getCompentencyMaster(int comp_m_id) {
		// TODO Auto-generated method stub

		Compentency_Master compMaster = new Compentency_Master();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Compentency_Master c where c.comp_m_id = :comp_m_id";
			Query sql = session.createQuery(query);
			sql.setParameter("comp_m_id", comp_m_id);
			compMaster = (Compentency_Master) sql.uniqueResult();
			return compMaster;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return compMaster;

	}

	@Override
	public boolean isAllTaskCompleted(int trId) {
		boolean flag = false;
		List<Training_Sheet_Lines> trSheetLine = new ArrayList<Training_Sheet_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Sheet_Lines t where t.tr_sh_id.tr_id = :trId";
			Query sql = session.createQuery(query);
			sql.setParameter("trId", trId);
			trSheetLine = sql.list();
			for (int i = 0; i < trSheetLine.size(); i++) {

				if (trSheetLine.get(i).getStatus().equals("Completed")
						&& trSheetLine.get(i).getTrainerStatus().equals("Completed")) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}

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
	public List<Training_Sheet_Lines> getTaskListForDownload(int tr_id) {
		// TODO Auto-generated method stub
		List<Training_Sheet_Lines> tr_lines = new ArrayList<Training_Sheet_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Training_Sheet_Lines t where t.tr_sh_id.tr_id = :tr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_id", tr_id);
			tr_lines = sql.list();
			return tr_lines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_lines;
	}

	@Override
	public boolean saveTraineeTrSheet(List<Trainee_Training_Sh_Lines> trainging_Master) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (Trainee_Training_Sh_Lines trshliobj : trainging_Master) {
				session.save(trshliobj);
			}
			return true;
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
	public TraineeTrainingSheet add_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh) {
		// TODO Auto-generated method stub
		TraineeTrainingSheet tr_id = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(trainging_tr_sh);
			String query = "from TraineeTrainingSheet where tr_sh_id =:tr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_id", trainging_tr_sh.getTr_sh_id());
			tr_id = (TraineeTrainingSheet) sql.uniqueResult();
			return tr_id;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_id;
	}



	@Override
	public List<Trainee_Training_Sh_Lines> getTaskListOfInhouse(int trId) {
		// TODO Auto-generated method stub
		List<Trainee_Training_Sh_Lines> inhouse_lines = new ArrayList<Trainee_Training_Sh_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Trainee_Training_Sh_Lines t where t.tr_sh_id.tr_sh_id = :trId";
			Query sql = session.createQuery(query);
			sql.setParameter("trId", trId);
			inhouse_lines = sql.list();
			return inhouse_lines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return inhouse_lines;
	}

	@Override
	public boolean isTraineeForInhouse(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<TraineeTrainingSheet> traineeList = new ArrayList<TraineeTrainingSheet>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from TraineeTrainingSheet t where t.trainee.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			traineeList = sql.list();
			if (traineeList.size() > 0) {
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
	public InhouseTrainingSheet saveInhouseTrainingSheet(InhouseTrainingSheet inhouse_tr_sh) {
		// TODO Auto-generated method stub
		InhouseTrainingSheet in_tr_id = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(inhouse_tr_sh);
			String query = "from InhouseTrainingSheet where intrsh =:intrsh";
			Query sql = session.createQuery(query);
			sql.setParameter("intrsh", inhouse_tr_sh.getIntrsh());
			in_tr_id = (InhouseTrainingSheet) sql.uniqueResult();
			return in_tr_id;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return in_tr_id;
	}

	@Override
	public List<InhouseTrainingSheet> getInhouseRecords(int trId) {
		// TODO Auto-generated method stub
		List<InhouseTrainingSheet> inhouse_lines = new ArrayList<InhouseTrainingSheet>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from InhouseTrainingSheet t where t.tr_sh_id.tr_sh_id = :trId";
			Query sql = session.createQuery(query);
			sql.setParameter("trId", trId);
			inhouse_lines = sql.list();
			return inhouse_lines;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return inhouse_lines;
	}

	@Override
	public TraineeTrainingSheet getTraineeTrainingSheet(int trainging_tr_sh) {
		// TODO Auto-generated method stub
		TraineeTrainingSheet tr_id = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from TraineeTrainingSheet where tr_sh_id =:trainging_tr_sh";
			Query sql = session.createQuery(query);
			sql.setParameter("trainging_tr_sh", trainging_tr_sh);
			tr_id = (TraineeTrainingSheet) sql.uniqueResult();
			return tr_id;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_id;
	}

	@Override
	public int deleteInhouseTrainingRecords(int inhousetrid) {
		// TODO Auto-generated method stub
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		int row = 0;
		try {
			tx = session.beginTransaction();
			String query = "delete from InhouseTrainingSheet i where i.intrsh = :inhousetrid";
			Query sql = session.createQuery(query);
			sql.setParameter("inhousetrid", inhousetrid);
			row = sql.executeUpdate();

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return row;
	}

	@Override
	public boolean isInhouseTrainee(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<TraineeTrainingSheet> traineeList = new ArrayList<TraineeTrainingSheet>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from TraineeTrainingSheet t where t.trainee.emp_id = :empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			traineeList = sql.list();
			if (traineeList.size() > 0) {
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
	public TraineeTrainingSheet update_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh) {
		// TODO Auto-generated method stub
		TraineeTrainingSheet tr_id = null;
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(trainging_tr_sh);
			String query = "from TraineeTrainingSheet where tr_sh_id =:tr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("tr_id", trainging_tr_sh.getTr_sh_id());
			tr_id = (TraineeTrainingSheet) sql.uniqueResult();
			return tr_id;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return tr_id;
	}

	@Override
	public List<Assessment> getAssessment(int empid) {
		// TODO Auto-generated method stub
		List<Assessment> assessmentList = new ArrayList<Assessment>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Assessment a where a.createdBy.emp_id =:empid";
			Query sql = session.createQuery(query);
			sql.setParameter("empid", empid);
			assessmentList = sql.list();
			return assessmentList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return assessmentList;
	}

	@Override
	public List<Assessment_Lines> getAssessmentTaskList(int assid) {
		// TODO Auto-generated method stub
		List<Assessment_Lines> assessmentTaskList = new ArrayList<Assessment_Lines>();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String query = "from Assessment_Lines al where al.assid.assId = :assid";
			Query sql = session.createQuery(query);
			sql.setParameter("assid", assid);
			assessmentTaskList = sql.list();
			return assessmentTaskList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return assessmentTaskList;
	}

	@Override
	public boolean isFunctionalReporterTRSheet(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;

		String sql = "SELECT TRSH.TR_ID,FR.FUNCTIONAL_REPORTING_ID,TRSH.TRAINEE_ID,TRSH.SUBJECT FROM TRAINING_SHEET_MASTER TRSH,"
				+ " FUNCTIONAL_REPORTING FR WHERE FR.EMP_ID=TRSH.TRAINEE_ID AND FR.FUNCTIONAL_REPORTING_ID=" + empid;
		List<TrainingSheetADFR> frList = jdbcTemplate.query(sql, new RowMapper<TrainingSheetADFR>() {

			@Override
			public TrainingSheetADFR mapRow(ResultSet rs, int rownum) throws SQLException {
				// TODO Auto-generated method stub
				TrainingSheetADFR frList = new TrainingSheetADFR();
				frList.setTr_sh(rs.getInt("TR_ID"));
				frList.setFunctional_reporting_id(rs.getInt("FUNCTIONAL_REPORTING_ID"));
				frList.setTrainee_id(rs.getInt("TRAINEE_ID"));
				frList.setSubject(rs.getString("SUBJECT"));
				return frList;
			}

		});

		if (frList.size() > 0) {
			flag = true;
		}
		return flag;

	}

	@Override
	public boolean isAdministrativeReporterTRSheet(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;

		String sql = "SELECT TRSH.TR_ID,AD.ADMINISTRATIVE_REPORTING_ID,TRSH.TRAINEE_ID,TRSH.SUBJECT FROM TRAINING_SHEET_MASTER TRSH,"
				+ " ADMINISTRATIVE_REPORTING AD WHERE AD.EMP_ID=TRSH.TRAINEE_ID AND AD.ADMINISTRATIVE_REPORTING_ID="
				+ empid;

		List<TrainingSheetADFR> adList = jdbcTemplate.query(sql, new RowMapper<TrainingSheetADFR>() {

			@Override
			public TrainingSheetADFR mapRow(ResultSet rs, int numRow) throws SQLException {
				TrainingSheetADFR ad = new TrainingSheetADFR();
				ad.setTr_sh(rs.getInt("TR_ID"));
				ad.setAdministrative_reporting_id(rs.getInt("ADMINISTRATIVE_REPORTING_ID"));
				ad.setSubject(rs.getString("SUBJECT"));
				ad.setTrainee_id(rs.getInt("TRAINEE_ID"));
				return ad;
			}

		});

		if (adList.size() > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean isFunctionalReporterInhouseSheet(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "SELECT TRSH.TR_SH_ID AS TR_ID,FR.FUNCTIONAL_REPORTING_ID AS FUNCTIONAL_REPORTING_ID,TRSH.TRAINEE AS TRAINEE_ID,TRSH.TITLE AS SUBJECT FROM TRAINEE_TRAINING_SHEET_MASTER TRSH,"
				+ " FUNCTIONAL_REPORTING FR WHERE FR.EMP_ID=TRSH.TRAINEE AND FR.FUNCTIONAL_REPORTING_ID==" + empid;

		List<TrainingSheetADFR> frInhouse = jdbcTemplate.query(sql, new RowMapper<TrainingSheetADFR>() {

			@Override
			public TrainingSheetADFR mapRow(ResultSet rs, int rownum) throws SQLException {
				TrainingSheetADFR frin = new TrainingSheetADFR();
				frin.setTr_sh(rs.getInt("TR_ID"));
				frin.setFunctional_reporting_id(rs.getInt("FUNCTIONAL_REPORTING_ID"));
				frin.setSubject(rs.getString("SUBJECT"));
				frin.setTrainee_id(rs.getInt("TRAINEE_ID"));
				return frin;
			}
		});


		if (frInhouse.size() > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean isAdministrativeReporterInhouseSheet(int empid) {
		// TODO Auto-generated method stub
		boolean flag = false;

		String sql = "SELECT TRSH.TR_SH_ID AS TR_ID,AD.ADMINISTRATIVE_REPORTING_ID AS ADMINISTRATIVE_REPORTING_ID,TRSH.TRAINEE AS TRAINEE_ID,TRSH.TITLE AS SUBJECT FROM"
				+ " TRAINEE_TRAINING_SHEET_MASTER TRSH,"
				+ " ADMINISTRATIVE_REPORTING AD WHERE AD.EMP_ID=TRSH.TRAINEE AND AD.ADMINISTRATIVE_REPORTING_ID="
				+ empid;

		List<TrainingSheetADFR> adInhouse = jdbcTemplate.query(sql, new RowMapper<TrainingSheetADFR>() {

			@Override
			public TrainingSheetADFR mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				TrainingSheetADFR adinouseobj = new TrainingSheetADFR();
				adinouseobj.setTr_sh(rs.getInt("TR_ID"));
				adinouseobj.setTrainee_id(rs.getInt("TRAINEE_ID"));
				adinouseobj.setAdministrative_reporting_id(rs.getInt("ADMINISTRATIVE_REPORTING_ID"));
				adinouseobj.setSubject(rs.getString("SUBJECT"));
				return adinouseobj;
			}

		});

		if (adInhouse.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Training_Master> getTrainingSheetGrid(int empid) {
		
		// TODO Auto-generated method stub
//		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,"
//				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
//				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
//				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
//				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
//				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
//				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND  TRM.STATUS = 'Approved' AND " + " (TRM.TRAINEE_ID="
//				+ empid + " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
//				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";
		
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND  TRM.STATUS = 'Approved' AND " + " ("
				+ "FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {

			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				// TODO Auto-generated method stub
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));

				Employee_Master trainee = traineelist.get(0);
				
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
	
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);

				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));

				trmaster.setDeviation(rs.getFloat("DEVIATION"));

				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));

				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));

				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));

				trmaster.setTrcomment(rs.getString("TRCOMMENT"));

				trmaster.setSubject(rs.getString("SUBJECT"));

				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
				return trmaster;

			}

		});

		return trainingList;
	}

	@Override
	public List<Functional_Reporting> getFunctionalReporterList(int empid) {
		// TODO Auto-generated method stub
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
	public List<TraineeTrainingSheet> getInhouseTrSheetGrid(int empid) {

		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINING_CODE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND TRM.STATUS='Approved' AND" + " (TRM.TRAINEE =" + empid
				+ " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID=" + empid
				+ " OR TRM.CREATED_BY=" + empid + ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {

			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				traineeTrSh.setTr_code(rs.getString("TRAINING_CODE"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}

	// 14 May
	public List<Training_Master> findCompletedTrainingsSheet(int empid) {
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='Completed' AND " + " (TRM.TRAINEE_ID="
				+ empid + " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
				return trmaster;
			}
		});
		return trainingList;
	}

	public List<Training_Master> findOngoingTrainingsSheet(int empid) {
		
	String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
					+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
					+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
					+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
					+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
					+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
					+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='Ongoing' AND " + " (FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
					+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";
	
		
//		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,"
//				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
//				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
//				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
//				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
//				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
//				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='Ongoing' AND " + " (TRM.TRAINEE_ID="
//				+ empid + " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
//				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
				return trmaster;
			}
		});
		
		return trainingList;
	}

	public List<Training_Master> findPendingTrainingsSheet(int empid) {
		
//		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,"
//				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
//				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
//				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
//				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
//				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
//				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Pending' OR TRM.STATUS='Pending for Approval') AND" + " (TRM.TRAINEE_ID="
//				+ empid + " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
//				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";
		
		// updated on 26/05/2020 for trainee not visible the pending or Pending for Approval  training Sheet 
		
		
		
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Pending' OR TRM.STATUS='Pending for Approval') AND" 
				+ " (FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR"
				+ " TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));

				return trmaster;
			}
		});
		return trainingList;
	}

	public List<TraineeTrainingSheet> findCompetedInhouseTrainingsSheet(int empid) {

		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINING_CODE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND TRM.STATUS='Completed' AND" + " (TRM.TRAINEE =" + empid
				+ " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID=" + empid
				+ " OR TRM.CREATED_BY=" + empid + ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {
			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				traineeTrSh.setTr_code(rs.getString("TRAINING_CODE"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}

	public List<TraineeTrainingSheet> findPendingInhouseTrainingsSheet(int empid) {

		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINING_CODE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND (TRM.STATUS='Pending' OR TRM.STATUS='Pending for Approval') AND" + " (TRM.TRAINEE =" + empid
				+ " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID=" + empid
				+ " OR TRM.CREATED_BY=" + empid + ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {
			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				traineeTrSh.setTr_code(rs.getString("TRAINING_CODE"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}

	public List<TraineeTrainingSheet> findOngoingInhouseTrainingsSheet(int empid) {

		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINING_CODE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND TRM.STATUS='Ongoing' AND" + " (FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID=" + empid
				+ " OR TRM.CREATED_BY=" + empid + ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {
			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				traineeTrSh.setTr_code(rs.getString("TRAINING_CODE"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}
	// 14 May

	//22 May
	
	public List<Training_Master> findPendingTrainingsSheetForAR(int empid) {
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='Pending for Approval' AND" + " (TRM.TRAINEE_ID="
				+ empid + " OR FR.FUNCTIONAL_REPORTING_ID=" + empid + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + empid
				+ " OR TRM.TRAINER_ID=" + empid + " OR TRM.CREATED_BY=" + empid + ")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));

				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);

				return trmaster;
			}
		});
		return trainingList;
	}
	//22 May

	@Override
	public List<Training_Master> findPendingForApprovalTrainingsSheet(int empid) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Pending for Approval') AND" 
				+ " (AD.ADMINISTRATIVE_REPORTING_ID = " + empid +")";

		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
				return trmaster;
			}
		});
		return trainingList;
	}

	@Override
	public List<Training_Master> findPendingTrainingListNotification(int empid) {
		// TODO Auto-generated method stub
		List<Training_Master> notificationTrainingList = new ArrayList<Training_Master>();
		
		boolean adminFlag = false,trainerFlag = false;		
		
		adminFlag = isAdministrativeReporter(empid);
		
		trainerFlag = isTrainer(empid);
		
		
		if(adminFlag)
		{
			String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
					+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
					+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
					+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
					+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
					+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
					+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Pending for Approval') AND" 
					+ " (AD.ADMINISTRATIVE_REPORTING_ID = " + empid
					+ ")";

			List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
				@Override
				public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
					Training_Master trmaster = new Training_Master();
					trmaster.setTr_id(rs.getInt("TR_ID"));

					List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
							.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
					Employee_Master trainee = traineelist.get(0);
					trmaster.setTrainee_id(trainee);

					List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
							.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
					Employee_Master trainer = trainerList.get(0);
					trmaster.setTrainer_id(trainer);

					trmaster.setCreated_by(rs.getInt("CREATED_BY"));
					if (rs.getDate("CREATION_DATE") != null) {
						trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
					}
					if (rs.getDate("LAST_UPDATE_DATE") != null) {
						trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
					}
					trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
					trmaster.setStatus(rs.getString("STATUS"));

					Compentency_Group compgr = new Compentency_Group();
					compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
					trmaster.setComp_group(compgr);
					trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
					trmaster.setDeviation(rs.getFloat("DEVIATION"));
					trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
					trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
					trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
					trmaster.setTrcomment(rs.getString("TRCOMMENT"));
					trmaster.setSubject(rs.getString("SUBJECT"));
					trmaster.setTr_code(rs.getString("TRAINING_CODE"));
					trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
					Administrative_Reporting ar = new Administrative_Reporting();
					ar.setAr_no(rs.getInt("AR_ID"));
					trmaster.setAr_id(ar);

					return trmaster;
				}
			});
			
			notificationTrainingList.addAll(trainingList);
		}
		
		if(trainerFlag)
		{
			String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_TYPE,TRM.TRAINING_CODE,"
					+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
					+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
					+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
					+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
					+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
					+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Pending') AND" 
					+ " (TRM.TRAINER_ID=" + empid + ")";

			List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
				@Override
				public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
					Training_Master trmaster = new Training_Master();
					trmaster.setTr_id(rs.getInt("TR_ID"));

					List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
							.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
					Employee_Master trainee = traineelist.get(0);
					trmaster.setTrainee_id(trainee);

					List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
							.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
					Employee_Master trainer = trainerList.get(0);
					trmaster.setTrainer_id(trainer);

					trmaster.setCreated_by(rs.getInt("CREATED_BY"));
					if (rs.getDate("CREATION_DATE") != null) {
						trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
					}
					if (rs.getDate("LAST_UPDATE_DATE") != null) {
						trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
					}
					trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
					trmaster.setStatus(rs.getString("STATUS"));

					Compentency_Group compgr = new Compentency_Group();
					compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
					trmaster.setComp_group(compgr);
					trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
					trmaster.setDeviation(rs.getFloat("DEVIATION"));
					trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
					trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
					trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
					trmaster.setTrcomment(rs.getString("TRCOMMENT"));
					trmaster.setSubject(rs.getString("SUBJECT"));
					trmaster.setTr_code(rs.getString("TRAINING_CODE"));
					trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
					Administrative_Reporting ar = new Administrative_Reporting();
					ar.setAr_no(rs.getInt("AR_ID"));
					trmaster.setAr_id(ar);

					return trmaster;
				}
			});
			notificationTrainingList.addAll(trainingList);
		}
		
		
		return notificationTrainingList;
	}

	@Override
	public List<Training_Master> getTrainingofParticularTrainee(String status, int userEmpCode, int traineeEmpCode) {
		
		
		String sql = "";
		
		if(userEmpCode == 34)
		{
			sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,"
					+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
					+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
					+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
					+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
					+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
					+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='"+status+"' AND " + " TRM.TRAINEE_ID="
					+   traineeEmpCode;
		}
		else
		{
			sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,"
					+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
					+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
					+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
					+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
					+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
					+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND TRM.STATUS='"+status+"' AND " + " TRM.TRAINEE_ID="
					+   traineeEmpCode + " AND (FR.FUNCTIONAL_REPORTING_ID=" + userEmpCode + " OR AD.ADMINISTRATIVE_REPORTING_ID = " + userEmpCode
					+ " OR TRM.TRAINER_ID=" + userEmpCode + " OR TRM.CREATED_BY=" + userEmpCode + ")";
		}
		
		
		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));

				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);

				return trmaster;
			}
		});
		
		return trainingList;
	}

	@Override
	public List<TraineeTrainingSheet> getInhouseTrainingofParticularTrainee(String status, int userEmpCode,
			int traineeEmpCode) {
		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND TRM.STATUS='"+status+"' AND" + " TRM.TRAINEE =" + traineeEmpCode
				+ " AND (FR.FUNCTIONAL_REPORTING_ID=" + userEmpCode + " OR AD.ADMINISTRATIVE_REPORTING_ID=" + userEmpCode
				+ " OR TRM.CREATED_BY=" + userEmpCode + ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {
			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}

	@Override
	public SubCompentency getSubCompentency(int topic_id) {
		// TODO Auto-generated method stub
		SubCompentency subComp =  new SubCompentency();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			String query = "from SubCompentency where topic_id = :topic_id";
			Query sql = session.createQuery(query);
			sql.setParameter("topic_id", topic_id);
			subComp = (SubCompentency) sql.uniqueResult();
			return subComp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return subComp;
	}

	@Override
	public String getTrainingCode(String[] compgroup_ids) {
		// TODO Auto-generated method stub
		int count = 0;
		String abb="",trainingCode="";
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		Compentency_Group compgr = new Compentency_Group();
		ArrayList<Training_Master> trainingMaster = new ArrayList<Training_Master>();
		
		ArrayList<Trainee_Training_Sh_Lines> trainingSheetLines = new ArrayList<Trainee_Training_Sh_Lines>();
		try
		{
			tx = session.beginTransaction();
			for(int i=0;i<compgroup_ids.length;i++)
			{
				int comp_gr_id = Integer.parseInt(compgroup_ids[i]);
				String query = "from Compentency_Group where comp_gr_id = :comp_gr_id";
				Query sql = session.createQuery(query);
				sql.setParameter("comp_gr_id", comp_gr_id);
				compgr =  (Compentency_Group) sql.uniqueResult();
				
				if(i == 0)
				{
					abb = abb + compgr.getAbbreviation();
				}
				else
				{
					abb = abb +"-" + compgr.getAbbreviation();
				}
				
				query = "from Training_Master where comp_group.comp_gr_id = :comp_gr_id";
				
				sql = session.createQuery(query);
				
				sql.setParameter("comp_gr_id", comp_gr_id);
				
				trainingMaster = (ArrayList<Training_Master>) sql.list();
				
				
				query = "from Trainee_Training_Sh_Lines where comp_gr.comp_gr_id = :comp_gr_id";
				
				sql = session.createQuery(query);
				
				sql.setParameter("comp_gr_id", comp_gr_id);
				
				trainingSheetLines = (ArrayList<Trainee_Training_Sh_Lines>) sql.list();
				
				
			}
			
			count = trainingMaster.size() + trainingSheetLines.size() + 1;
			
			LocalDate today = LocalDate.now();
			
			int month1 = today.getMonthValue();
			
			String year = String.valueOf(today.getYear()).substring(2);
			
			
			String month = null;
			
			if(month1 < 10)
			{
				month = "0"+month1;
			}
			else
			{
				month = String.valueOf(month1);
			}
			
			trainingCode = abb +"-"+ month + year+"-"+ (count);
			
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trainingCode;
	}

	@Override
	public RequestedTraining saveRequestedTraining(RequestedTraining reqTraining) {
		// TODO Auto-generated method stub
		RequestedTraining rqTraining = new RequestedTraining();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(reqTraining);
			String query = "from RequestedTraining where retr_id =:retr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("retr_id", reqTraining.getRetr_id());
			rqTraining = (RequestedTraining) sql.uniqueResult();
			return rqTraining;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return rqTraining;
	}

	@Override
	public RequestedTraining updateRequestedTraining(RequestedTraining reqTraining) {
		// TODO Auto-generated method stub
		RequestedTraining rqTrainings = new RequestedTraining();
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.saveOrUpdate(reqTraining);
			String query = "from RequestedTraining where retr_id =:retr_id";
			Query sql = session.createQuery(query);
			sql.setParameter("retr_id", reqTraining.getRetr_id());
			rqTrainings = (RequestedTraining) sql.uniqueResult();
			return rqTrainings;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			tx.commit();
			session.close();
			System.gc();
		}
		return rqTrainings;
	}

	@Override
	public List<Training_Master> findOngoingTrainingsSheetForTrainee(int empid) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT(TRM.TR_ID),TRM.TRAINEE_ID,TRM.TRAINER_ID,TRM.CREATED_BY,TRM.TRAINING_CODE,TRM.TRAINING_TYPE,"
				+ " TRM.CREATION_DATE,TRM.LAST_UPDATE_DATE,TRM.LAST_UPDATED_BY,TRM.SUBJECT,"
				+ " TRM.STATUS,TRM.COMP_GR_ID,TRM.TR_SH_TYPE,TRM.DEVIATION,TRM.REDBUTTON,"
				+ " TRM.AMBERBUTTON,TRM.GREENBUTTON,TRM.TRCOMMENT,TRM.AR_ID"
				+ " FROM TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE_ID=EMP.EMP_ID AND TRM.TRAINEE_ID=FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE_ID = AD.EMP_ID AND AD.EMP_ID = EMP.EMP_ID AND (TRM.STATUS='Ongoing' OR TRM.STATUS='Approved') AND " + " (TRM.TRAINEE_ID="
				+ empid +")";
		
		List<Training_Master> trainingList = jdbcTemplate.query(sql, new RowMapper<Training_Master>() {
			@Override
			public Training_Master mapRow(ResultSet rs, int numRow) throws SQLException {
				Training_Master trmaster = new Training_Master();
				trmaster.setTr_id(rs.getInt("TR_ID"));

				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE_ID"));
				Employee_Master trainee = traineelist.get(0);
				trmaster.setTrainee_id(trainee);

				List<Employee_Master> trainerList = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINER_ID"));
				Employee_Master trainer = trainerList.get(0);
				trmaster.setTrainer_id(trainer);

				trmaster.setCreated_by(rs.getInt("CREATED_BY"));
				if (rs.getDate("CREATION_DATE") != null) {
					trmaster.setCreation_date(rs.getDate("CREATION_DATE"));
				}
				if (rs.getDate("LAST_UPDATE_DATE") != null) {
					trmaster.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
				}
				trmaster.setLast_updated_by(rs.getInt("LAST_UPDATED_BY"));
				trmaster.setStatus(rs.getString("STATUS"));

				Compentency_Group compgr = new Compentency_Group();
				compgr.setComp_gr_id(rs.getInt("COMP_GR_ID"));
				trmaster.setComp_group(compgr);
				trmaster.setTr_sh_type(rs.getString("TR_SH_TYPE"));
				trmaster.setDeviation(rs.getFloat("DEVIATION"));
				trmaster.setRedButtonFlag(rs.getString("REDBUTTON"));
				trmaster.setAmberButtonFlag(rs.getString("AMBERBUTTON"));
				trmaster.setGreenButtonFlag(rs.getString("GREENBUTTON"));
				trmaster.setTrcomment(rs.getString("TRCOMMENT"));
				trmaster.setSubject(rs.getString("SUBJECT"));
				trmaster.setTr_code(rs.getString("TRAINING_CODE"));
				Administrative_Reporting ar = new Administrative_Reporting();
				ar.setAr_no(rs.getInt("AR_ID"));
				trmaster.setAr_id(ar);
				trmaster.setTraining_type(rs.getString("TRAINING_TYPE"));
				return trmaster;
			}
		});
		
		return trainingList;
	}

	@Override
	public List<TraineeTrainingSheet> findOngoingInhouseTrainingsSheetForTrainee(int empid) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT(TRM.TR_SH_ID),TRM.TITLE,TRM.TRAINING_CODE,TRM.TRAINEE,TRM.PLANSTARTDATE,TRM.PLANENDDATE,TRM.STATUS FROM TRAINEE_TRAINING_SHEET_MASTER TRM,EMPLOYEE_MASTER EMP,"
				+ " FUNCTIONAL_REPORTING FR,ADMINISTRATIVE_REPORTING AD"
				+ " WHERE TRM.TRAINEE=EMP.EMP_ID AND TRM.TRAINEE= FR.EMP_ID AND FR.EMP_ID=EMP.EMP_ID AND"
				+ " TRM.TRAINEE = AD.EMP_ID AND AD.EMP_ID=EMP.EMP_ID AND TRM.STATUS='Ongoing' AND" + " (TRM.TRAINEE =" + empid
				+ ")";

		List<TraineeTrainingSheet> traineeTrSH = jdbcTemplate.query(sql, new RowMapper<TraineeTrainingSheet>() {
			@Override
			public TraineeTrainingSheet mapRow(ResultSet rs, int num) throws SQLException {
				TraineeTrainingSheet traineeTrSh = new TraineeTrainingSheet();
				traineeTrSh.setTr_sh_id(rs.getInt("TR_SH_ID"));
				traineeTrSh.setTitle(rs.getString("TITLE"));
				List<Employee_Master> traineelist = (List<Employee_Master>) hibernatetemplate
						.find("from Employee_Master where emp_id=?", rs.getInt("TRAINEE"));

				Employee_Master trainee = traineelist.get(0);
				traineeTrSh.setTrainee(trainee);
				traineeTrSh.setPlanStartDate(rs.getDate("PLANSTARTDATE"));
				traineeTrSh.setPlanEndDate(rs.getDate("PLANENDDATE"));
				traineeTrSh.setStatus(rs.getString("STATUS"));
				traineeTrSh.setTr_code(rs.getString("TRAINING_CODE"));
				return traineeTrSh;
			}

		});

		return traineeTrSH;
	}


	@Override
	public Compentency_Group getCompentencyGroup(int comp_id) {
		Compentency_Group comp_gr = new Compentency_Group();
		
		Session session = hibernatetemplate.getSessionFactory().openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			String query = "from Compentency_Group where comp_gr_id = :comp_m_id";
			Query sql = session.createQuery(query);
			sql.setParameter("comp_m_id", comp_id);
			
			comp_gr = (Compentency_Group) sql.uniqueResult();
			
			return comp_gr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			tx.commit();
			session.close();
			System.gc();
		}

		return comp_gr;
	}

	

	


	
}
