package com.omfysgroup.ajanhcm.daoImpl;

import java.sql.ResultSet;






import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omfysgroup.ajanhcm.dao.Attendance_dao;
import com.omfysgroup.ajanhcm.model.AttendanceModule;
import com.omfysgroup.ajanhcm.model.AttendanceReport;
import com.omfysgroup.ajanhcm.model.Attendance_Module;
import com.omfysgroup.ajanhcm.model.Attendance_Regularazation;
import com.omfysgroup.ajanhcm.model.Designation_Master;
import com.omfysgroup.ajanhcm.model.Early_Late_Tracking;
import com.omfysgroup.ajanhcm.model.EmployeeMasterAttendance;
import com.omfysgroup.ajanhcm.model.EmployeeStatus;
import com.omfysgroup.ajanhcm.model.Employee_Joining_Details;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Holidays_Setup;
import com.omfysgroup.ajanhcm.model.Joining_Details;
import com.omfysgroup.ajanhcm.model.LATEEARLY;
import com.omfysgroup.ajanhcm.model.LateEarlyDetails;
import com.omfysgroup.ajanhcm.model.LateEarlyEvents;
import com.omfysgroup.ajanhcm.model.Late_Early_Debited_Leaves;
import com.omfysgroup.ajanhcm.model.LeaveBalance;
import com.omfysgroup.ajanhcm.model.Leave_Creadit_Auto;
import com.omfysgroup.ajanhcm.model.Leave_creadit_report;
import com.omfysgroup.ajanhcm.model.MarkExitScreen;
import com.omfysgroup.ajanhcm.model.PunchRecords;
import com.omfysgroup.ajanhcm.model.Tte_Lwp;
import com.omfysgroup.ajanhcm.model.od_report_lwp;



@Repository("Attendance_dao")
public class Attendance_dao_impl implements Attendance_dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Designation_Master> getdesignation(String dept) {

		List<Designation_Master> YMS = new ArrayList<>();

		String[] year = dept.split(",");
		for (int i = 0; i < year.length; i++) {

			String sql = "SELECT * FROM DESIGNATION_MASTER WHERE DEPARTMENT_ID = " + year[i] + " ";

			List<Designation_Master> al = jdbcTemplate.query(sql, new RowMapper<Designation_Master>() {

				@Override
				public Designation_Master mapRow(ResultSet rs, int no) throws SQLException {

					Designation_Master aContact = new Designation_Master();
					// aContact.setYear_id(rs.getString("YEAR_ID"));
					// aContact.setMonth(rs.getString("MONTH"));

					aContact.setDesignation_id(rs.getInt("DESIGNATION_ID"));
					aContact.setDesignation_name(rs.getString("DESIGNATION_NAME"));
					aContact.setDepartment_id(rs.getInt("DEPARTMENT_ID"));

					return aContact;
				}
			});

			YMS.addAll(al);

		}
		return YMS;
	}

	@Override
	public boolean saveHoli_days(Holidays_Setup h_setup) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(h_setup);
			flag = true;
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
	public int savePuchExcel(PunchRecords pr) {
		hibernateTemplate.save(pr);
		return pr.getPunch_records_id();
	}

	@Override
	public List<EmployeeMasterAttendance> empmaster() {
		String sql = "select CREATED_BY,CREATION_DATE,EMP_CODE,Email,EMP_DEACT_DATE,EMP_ID,TRIM(EMP_FIRST_NAME) AS EMP_FIRST_NAME,TRIM(EMP_LAST_NAME) AS EMP_LAST_NAME,is_activated,IS_DELETED,LAST_UPDATED_BY,last_update_date,mytestcloumn,otp,password,photo_name,profile_id,project_role_id,PROJECT_ROLE_ID,SALTKEY,user_id from employee_master where is_activated = 'Y'";

		List<EmployeeMasterAttendance> attendanceList = jdbcTemplate.query(sql,
				new RowMapper<EmployeeMasterAttendance>() {

					@Override
					public EmployeeMasterAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeMasterAttendance t = new EmployeeMasterAttendance();

						t.setCreated_by(rs.getString("CREATED_BY"));
						t.setCreation_date(rs.getString("CREATION_DATE"));
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmail(rs.getString("Email"));
						t.setEmp_deact_date(rs.getString("EMP_DEACT_DATE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_id(rs.getString("EMP_ID"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setIs_activated(rs.getString("is_activated"));
						t.setIs_deleted(rs.getString("IS_DELETED"));
						t.setLast_update_by(rs.getString("LAST_UPDATED_BY"));
						t.setLast_update_date(rs.getString("last_update_date"));
						t.setMytestcloumn(rs.getString("mytestcloumn"));
						t.setOtp(rs.getString("otp"));
						t.setPassword(rs.getString("password"));
						t.setPhoto_name(rs.getString("photo_name"));
						t.setProfile_id(rs.getString("profile_id"));
						t.setProject_role_id(rs.getString("PROJECT_ROLE_ID"));
						t.setSaltkey(rs.getString("SALTKEY"));
						// t.setUpload_photo(rs.getString("UPLOAD_PHOTO"));
						t.setUser_id(rs.getString("user_id"));
						return t;
					}
				});

		return attendanceList;
	}

	@Override
	public List<AttendanceModule> details(String date) {
		// String sql="select
		// EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,LOGDATE,PANCH_IN,PANCH_OUT,PANCH_OUT
		// - PANCH_IN as TOTAL_TIME from(select
		// BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then
		// LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then
		// LOGDATETIME end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from
		// BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where
		// BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD')
		// ='"+date+"' group by
		// EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)";
		String sql = "select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,LOGDATE,REPLACE(SUBSTR(PANCH_IN,10,9), '.', ':') PANCH_IN,REPLACE(SUBSTR(PANCH_OUT,10,9), '.', ':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME, case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date('09:30:00','hh24:mi:ss') then 'Late Coming'when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') < to_date('09:30:00','hh24:mi:ss') then 'Ontime' else ' ' end as Status_in, case when to_date(to_char(PANCH_OUT,'hh12:mi:ss'),'hh12:mi:ss') > to_date('06:30:00','hh12:mi:ss') then 'Ontime' when to_date(to_char(PANCH_OUT,'hh12:mi:ss'),'hh12:mi:ss') < to_date('06:30:00','hh12:mi:ss') then 'Early Going'else ' ' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN, max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND\r\n" + 
				"TO_CHAR(LOGDATETIME,'YYYY-MM-DD') ='"+date+"' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)";
		
//		String sql = "select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,LOGDATE,trim(SUBSTR(PANCH_IN,10,9)) PANCH_IN,trim(SUBSTR(PANCH_OUT,10,9)) PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME, case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date('09:30:00','hh24:mi:ss') then 'Late Coming'when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') < to_date('09:30:00','hh24:mi:ss') then 'Ontime' else ' ' end as Status_in, case when to_date(to_char(PANCH_OUT,'hh12:mi:ss'),'hh12:mi:ss') > to_date('06:30:00','hh12:mi:ss') then 'Ontime' when to_date(to_char(PANCH_OUT,'hh12:mi:ss'),'hh12:mi:ss') < to_date('06:30:00','hh12:mi:ss') then 'early Going'else ' ' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN, max(case when DIRECTIONS= 'Out' then LOGDATETIME end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') ='"
//				+ date + "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)";
//		
		

		List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

			@Override
			public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
				AttendanceModule t = new AttendanceModule();
				t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
				t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
				t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
				t.setLogdate(rs.getString("LOGDATE"));
				t.setPanch_in(rs.getString("PANCH_IN"));
				t.setPanch_out(rs.getString("PANCH_OUT"));
				t.setTotal_time(rs.getString("total_time"));
				t.setStatus_in(rs.getString("Status_in"));
				t.setStatus_out(rs.getString("Status_out"));
				return t;
			}
		});
		return attendanceList;
	}

	//desc order
	@Override
	public List<EmployeeStatus> empstatus(String todaysDate, int employeeId) {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
		Date date2 = null;
		try {
			date2 = formatter2.parse(todaysDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		//==========
		String sql1="SELECT LEAVE_TYPE,LEAVE_STATUS,DAY_TYPE \r\n" + 
				"FROM(SELECT CASE WHEN LEAVE_TYPE = 5 THEN 'LWP' ELSE 'OD' END AS LEAVE_TYPE\r\n" + 
				",CASE WHEN LEAVE_TYPE = 5 THEN 'Approved' ELSE 'Rejected' END AS LEAVE_STATUS,\r\n" + 
				"CASE WHEN LEAVE_TYPE = 5 THEN 'Full Day' ELSE 'HALF' END AS DAY_TYPE\r\n" + 
				"FROM TTE_LWP WHERE EMP_ID='"+employeeId+"' AND IS_APPLICABLE='Y' AND TO_CHAR(TTE_DATE,'YYYY-MM-DD')='"+todaysDate+"')";
		
		List<EmployeeStatus> tteReport = jdbcTemplate.query(sql1, new RowMapper<EmployeeStatus>() {

			@Override
			public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeStatus t = new EmployeeStatus();
				t.setStatus(rs.getString("LEAVE_STATUS"));
				t.setLeave_type(rs.getString("LEAVE_TYPE"));
				t.setDayType(rs.getString("DAY_TYPE"));
				return t;
			}
		});
		
		//=========
		String sql ="";
		
		     sql="select ORL.STATUS,LT.LEAVE_TYPE,ORL.START_DATE,ORL.END_DATE,ORL.DAY_TYPE from OD_REPORT_LWP ORL,LEAVE_TYPE LT WHERE EMP_ID='"+employeeId+"' AND START_DATE <= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'DD-MON-YY') AND END_DATE >= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'dd-MON-YY') AND ORL.LEAVE_TYPE = LT.L_NO \r\n" + 
				"";
		
		List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

			@Override
			public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeStatus t = new EmployeeStatus();
				t.setStatus(rs.getString("status"));
				t.setLeave_type(rs.getString("leave_type"));
				t.setDayType(rs.getString("DAY_TYPE"));
				return t;
			}

		});
		
		if(tteReport.size()>0) {
			
			return tteReport;
		}
		else if(attendanceList.size()>0) {
			
			
			return attendanceList;
		}else {
			//adding new desending oder when leave are applyed same day.
			 sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+employeeId+"' AND lrl.START_DATE <= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
			 
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
			 
			 return attendanceList1;
		}
		
		
	}

	@Override
	public List<Holidays_Setup> getHolidayDetails(String date) {
		String sql = "select H_ID,HOLIDAY_DATE,HOLIDAY_NAME from HOLIDAYS_SETUP where TO_CHAR(HOLIDAY_DATE,'YYYY-MM-DD') = '"
				+ date + "' ";
		List<Holidays_Setup> holidaysList = jdbcTemplate.query(sql, new RowMapper<Holidays_Setup>() {
			@Override
			public Holidays_Setup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Holidays_Setup holidays = new Holidays_Setup();
				holidays.setH_id(rs.getInt("H_ID"));
				holidays.setHoliday_date(rs.getDate("HOLIDAY_DATE"));
				holidays.setHoliday_name(rs.getString("HOLIDAY_NAME"));
				return holidays;
			}
		});
		return holidaysList;
	}
	
	
	//Added By Santosh
	
	
	// 23-12-2021
			// CODE ADDED SANTOSH KOTGYALE

			@Override
			public List<AttendanceModule> attModuleInfo(String date) {
				// TODO Auto-generated method stub		
				String sql = "select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,9) AS LOGDATE,replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') <= to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Ontime' else ' ' end as Status_in,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') >= to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Ontime' when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Early Going' else ' ' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN, max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ date + "' AND '" + date + "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)";

				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {

						AttendanceModule t = new AttendanceModule();

						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						// t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("TOTAL_TIME"));
						t.setStatus_in(rs.getString("Status_in"));
						t.setStatus_out(rs.getString("Status_out"));

						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> empStatusLeave(String todaysDate, int employeeId) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				try {
					date2 = formatter2.parse(todaysDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String sql = "select lr.STATUS,LT.LEAVE_TYPE ,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID ='"
						+ employeeId + "' AND lrl.START_DATE <= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO";

				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {
					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setStatus(rs.getString("STATUS"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setDayType(rs.getString("DAY_TYPE"));
						System.out.println("EmployeeStaus===>" + t);

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<AttendanceReport> attreport() {
//				String sql="SELECT att.EMPLOYEE_CODE,att.LOGDATE,att.LOGDATETIME,emp.EMP_FIRST_NAME,att.DIRECTIONS,arr.CATEGORY,arr.LEAVE_STATUS,CASE WHEN DIRECTIONS='In' THEN 'PRESENT' ELSE 'ABSENT'  END AS ATT_STATUS FROM BIOMAXATTENDANCE att, EMPLOYEE_MASTER emp,ATTENDANCE_REGULARIZATION arr where att.EMPLOYEE_CODE = emp.EMP_CODE";
				String sql = "SELECT att.EMPLOYEE_CODE,att.LOGDATE,emp.EMP_FIRST_NAME,emp.EMP_LAST_NAME,att.DIRECTIONS,arr.CATEGORY,arr.LEAVE_STATUS,CASE WHEN DIRECTIONS='In' THEN 'PRESENT' ELSE 'ABSENT'  END AS ATT_STATUS FROM BIOMAXATTENDANCE att, EMPLOYEE_MASTER emp,ATTENDANCE_REGULARIZATION arr where att.EMPLOYEE_CODE = emp.EMP_CODE";

				List<AttendanceReport> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceReport>() {

					@Override
					public AttendanceReport mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceReport t = new AttendanceReport();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("logdate"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("total_time"));
						t.setStatus(rs.getString("status"));
						t.setLeave_type(rs.getString("leave_type"));
						t.setStatus_in(rs.getString("status_in"));
						t.setCategory(rs.getString("category"));
						t.setLeave_status(rs.getString("leave_status"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<Early_Late_Tracking> attRegularization(String todaysDate, int employeeId) {

				// TODO Auto-generated method stub
				String sql = "SELECT EMPLOYEE_CODE,CATEGORIES,LEAVE_STATUS FROM Attendance_Regularization WHERE EMPLOYEE_ID='"
						+ employeeId + "' AND START_DATE <= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND END_DATE >= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'dd-MON-YY')";

				List<Early_Late_Tracking> attendanceList = jdbcTemplate.query(sql, new RowMapper<Early_Late_Tracking>() {
					@Override
					public Early_Late_Tracking mapRow(ResultSet rs, int rowNum) throws SQLException {
						Early_Late_Tracking t = new Early_Late_Tracking();

						t.setEmployee_code(rs.getString("employee_code"));
						t.setCategory(rs.getString("CATEGORIES"));
						t.setLeave_Status(rs.getString("Leave_status"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<LeaveBalance> leaveBalance(int employeeId) {
				// TODO Auto-generated method stub
				String sql = "select LB_NO,EMP_ID,PL,CL,ML,CREATION_DATE,LAST_UPDATE_DATE from leave_balance WHERE EMP_ID='"
						+ employeeId + "'";

				List<LeaveBalance> attendanceList = jdbcTemplate.query(sql, new RowMapper<LeaveBalance>() {

					@Override
					public LeaveBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
						LeaveBalance t = new LeaveBalance();

						t.setLb_no(rs.getInt("LB_NO"));
						t.setEmp_id(rs.getInt("EMP_ID"));
						t.setPl(rs.getInt("PL"));
						t.setCl(rs.getInt("CL"));
						t.setMl(rs.getInt("ML"));
						t.setCreation_date(rs.getDate("CREATION_DATE"));
						t.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public boolean updateLeaveBalance(LeaveBalance leaveBalance) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public int createAttendanceModule(Attendance_Module attendance_module) {
				// TODO Auto-generated method stub
				String sql = "insert into Attendance_Module (start_date, end_date, start_time, end_time, min_con_present, min_con_half_day, grace_period,no_of_events,pl,cl)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				try {

					int counter = jdbcTemplate.update(sql,
							new Object[] { attendance_module.getStart_date(), attendance_module.getEnd_date(),
									attendance_module.getStart_time(), attendance_module.getEnd_time(),
									attendance_module.getMin_con_present(), attendance_module.getMin_con_half_day(),
									attendance_module.getGrace_period(), attendance_module.getNo_of_events(),
									attendance_module.getPl(), attendance_module.getCl() });
					return counter;

				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}

			@Transactional
			@Override
			public int updateAttendanceModule(Attendance_Module attendance_module) {
				// TODO Auto-generated method stub

				hibernateTemplate.saveOrUpdate(attendance_module);

				return 1;
			}

			@Override
			public List<Attendance_Module> readAttendanceModule() {
				// TODO Auto-generated method stub
				List<Attendance_Module> employeesList = jdbcTemplate.query("SELECT * FROM Attendance_Module",
						new RowMapper<Attendance_Module>() {

							@Override
							public Attendance_Module mapRow(ResultSet rs, int rowNum) throws SQLException {
								Attendance_Module t = new Attendance_Module();

								t.setStart_date(rs.getDate("start_date"));
								t.setEnd_date(rs.getDate("end_date"));
								t.setStart_time(rs.getString("start_time"));
								t.setEnd_time(rs.getString("end_time"));
								t.setMin_con_half_day(rs.getInt("min_con_half_day"));
								t.setMin_con_present(rs.getInt("min_con_present"));
								t.setGrace_period(rs.getInt("grace_period"));
								t.setNo_of_events(rs.getInt("no_of_events"));
								t.setPl(rs.getString("pl"));
								t.setCl(rs.getString("cl"));
								t.setMinutes(rs.getInt("minutes"));

								return t;
							}

						});
				return employeesList;

			}


			@Override
			public List<LateEarlyEvents> sumOfEvents(String date, int employeeId) {

				String sql = "SELECT SUM(CASE WHEN STATUS_IN = 'Late Coming' THEN 1 WHEN STATUS_OUT = 'Early Going' then 1 end) AS total_events from (select EMPLOYEE_CODE, case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date(START_TIME,'hh24:mi:ss') then 'Late Coming' end as Status_in,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date(END_TIME,'hh24:mi:ss') then 'Early Going'  end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,BM.LOGDATETIME,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT,EMP.EMP_LAST_NAME,EMP_FIRST_NAME,START_TIME,ATT.END_TIME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP,ATTENDANCE_MODULE ATT where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND emp_id='"
						+ employeeId + "' AND TO_CHAR(BM.LOGDATETIME,'YYYY-MM-DD') between '" + date + "' and '" + date
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE,LOGDATETIME,ATT.START_TIME,ATT.END_TIME))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setTotal_events(rs.getInt("total_events"));
						System.out.println("status_saver" + t);
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> eventsCounts(String date,String endDate, int employeeId) {
//				String sql = "SELECT SUM(CASE WHEN STATUS_IN = 'Late Coming' THEN 1 WHEN STATUS_OUT = 'Early Going' then 1 end) AS total_events from(select EMPLOYEE_CODE,EMP_FIRST_NAME,LOGDATETIME,START_TIME,END_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date(START_TIME,'hh24:mi:ss') then 'Late Coming' when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') < to_date(START_TIME,'hh24:mi:ss') then 'Ontime' else ' ' end as Status_in,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') > to_date(END_TIME,'hh24:mi:ss') then 'Ontime' when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date(END_TIME,'hh24:mi:ss') then 'Early Going'else ' ' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,BM.LOGDATETIME,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT,EMP.EMP_LAST_NAME,EMP_FIRST_NAME,START_TIME,ATT.END_TIME,lr.STATUS from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP,ATTENDANCE_MODULE ATT,LEAVE_REQUEST lr where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND EMP.emp_id='"+employeeId+"' AND TO_CHAR(LOGDATETIME,'YYYY-MM') ='"+date+"' AND  LR.STATUS NOT LIKE  'Rejected' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE,LOGDATETIME,ATT.START_TIME,ATT.END_TIME,ATT.START_TIME,lr.STATUS))";
			//	String sql="select sum(latecomingcount+earlygoingcount) as total_events from(select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount, COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND EMP.EMP_ID='"+employeeId+"' AND TO_CHAR(LOGDATETIME,'YYYY-MM') BETWEEN '"+date+"' AND '"+date+"' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)))";
				String sql="select sum(latecomingcount+earlygoingcount) as total_events from(select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount,COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND EMP.EMP_ID ='"+employeeId+"' AND TO_CHAR(LOGDATETIME,'YYYY-MM-dd')>='"+date+"' AND TO_CHAR(LOGDATETIME,'YYYY-MM-dd')<='"+endDate+"' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)))";
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setTotal_events(rs.getInt("total_events"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<Attendance_Module> attendancesModule() {
				// TODO Auto-generated method stub

				String sql = "SELECT START_DATE,END_DATE,START_TIME,END_TIME,MIN_CON_PRESENT,MIN_CON_HALF_DAY,GRACE_PERIOD,NO_OF_EVENTS,PL,CL,MINUTES FROM ATTENDANCE_MODULE";

				List<Attendance_Module> attendanceList = jdbcTemplate.query(sql, new RowMapper<Attendance_Module>() {

					@Override
					public Attendance_Module mapRow(ResultSet rs, int rowNum) throws SQLException {
						Attendance_Module t = new Attendance_Module();

						t.setStart_date(rs.getDate("start_date"));
						t.setEnd_date(rs.getDate("end_date"));
						t.setStart_time(rs.getString("start_time"));
						t.setEnd_time(rs.getString("end_time"));
						t.setMin_con_present(rs.getInt("min_con_present"));
						t.setMin_con_half_day(rs.getInt("min_con_half_day"));
						t.setGrace_period(rs.getInt("grace_period"));
						t.setNo_of_events(rs.getInt("no_of_events"));
						t.setCl(rs.getString("cl"));
						t.setPl(rs.getString("pl"));
						t.setMinutes(rs.getInt("MINUTES"));
						return t;
					}
				});
				return attendanceList;
			}
			
			@Override
			public List<Attendance_Module> attendanceSetting(String date) {
				// TODO Auto-generated method stub
				return null;
			}

//			@Override
//			public List<Holidays_Setup> getHolidayDetails(String date) {
//				// TODO Auto-generated method stub
//				String sql = "select H_ID,HOLIDAY_DATE,HOLIDAY_NAME from HOLIDAYS_SETUP where TO_CHAR(HOLIDAY_DATE,'YYYY-MM-DD') = '"
//						+ date + "' ";
//				List<Holidays_Setup> holidaysList = jdbcTemplate.query(sql, new RowMapper<Holidays_Setup>() {
	//
//					@Override
//					public Holidays_Setup mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Holidays_Setup holidays = new Holidays_Setup();
//						holidays.setH_id(rs.getInt("H_ID"));
//						holidays.setHoliday_date(rs.getDate("HOLIDAY_DATE"));
//						holidays.setHoliday_name(rs.getString("HOLIDAY_NAME"));
	//
//						return holidays;
//					}
//				});
//				return holidaysList;
//			}
			//
			// CODE ADDED BY SANTOSH

			@Override
			public List<AttendanceModule> attendanceLCEGReport() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lateEarlyDebited(Late_Early_Debited_Leaves lateEarlyDebitedLeves) {
				// TODO Auto-generated method stub
				String sql = "insert into Late_Early_Debited_Leaves (EMP_ID,PL,CL,CREATION_DATE,LAST_UPDATE_DATE,EMP_CODE,LWP,STATUS)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

				try {

					int counter = jdbcTemplate.update(sql,
							new Object[] { lateEarlyDebitedLeves.getEmp_id(), lateEarlyDebitedLeves.getPl(),
									lateEarlyDebitedLeves.getCl(), lateEarlyDebitedLeves.getCreation_date(),
									lateEarlyDebitedLeves.getLast_update_date(), lateEarlyDebitedLeves.getEmp_code(),
									lateEarlyDebitedLeves.getLwp(), lateEarlyDebitedLeves.getStatus() });
					return counter;

				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}

			// 12/26
			@Override
			public List<AttendanceModule> attModuleInfo1(String date, String date1) {
				// TODO Auto-generated method stub
				String sql = "select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,LOGDATE,LOGDATETIME,SUBSTR(PANCH_IN,10,8)PANCH_IN,SUBSTR(PANCH_OUT,10,8)PANCH_OUT, substr(PANCH_OUT - PANCH_IN,12,2) as TOTAL_TIME, case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date(START_TIME,'hh24:mi:ss') then 'Late Coming' when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') <= to_date(START_TIME,'hh24:mi:ss') then 'Ontime' else ' ' end as Status_in,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') >= to_date(END_TIME,'hh24:mi:ss') then 'Ontime' when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date(END_TIME,'hh24:mi:ss') then 'Early Going'else ' ' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,BM.LOGDATETIME,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT,EMP.EMP_LAST_NAME,EMP_FIRST_NAME,START_TIME,ATT.END_TIME \r\n"
						+ "from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP,ATTENDANCE_MODULE ATT \r\n"
						+ "where BM.EMPLOYEE_CODE=EMP.EMP_CODE \r\n" + "AND TO_CHAR(BM.LOGDATETIME,'YYYY-MM-DD') >= '" + date
						+ "' and TO_CHAR(BM.LOGDATETIME,'YYYY-MM-DD') <='" + date1 + "'\r\n"
						+ "group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE,LOGDATETIME,ATT.START_TIME,ATT.END_TIME)";
				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("TOTAL_TIME"));
						t.setStatus_in(rs.getString("Status_in"));
						t.setStatus_out(rs.getString("Status_out"));

						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> empstatus1(String startDate, String endDate, int employeeId) {
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				Date date3 = null;
				try {
					date2 = formatter2.parse(startDate);
					date3 = formatter2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String sql = "select lr.STATUS,LT.LEAVE_TYPE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = "
						+ employeeId + " AND lrl.START_DATE <= to_char(TO_DATE('" + date2
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('" + date3
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO";
				
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setStatus(rs.getString("status"));
						t.setLeave_type(rs.getString("leave_type"));
						t.setDayType(rs.getString("Day_type"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> attRegularizationCount(String date,String endDate ,int employeeId) {
				// TODO Auto-generated method stub
				String sql = "select count(LEAVE_STATUS) as approved_count from (SELECT EMPLOYEE_CODE,CATEGORIES,LEAVE_STATUS FROM Attendance_Regularization WHERE EMPLOYEE_ID='"
						+ employeeId
						+ "' AND LEAVE_STATUS IN ('Approved','Pending for FR Approval','Pending for AR Approval') AND START_DATE >= to_char(TO_DATE('"
						+ date + "','YYYY-MM-DD'),'DD-MON-YY') AND END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setApproved_count(rs.getInt("approved_count"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> biomaxCount(String startDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub

				String sql="select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount, COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND EMP.EMP_ID='"+employeeId+"' AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD')>='"+startDate+"' and TO_CHAR(LOGDATETIME,'YYYY-MM-DD')<='"+endDate+"' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE))";
				
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLatecomingcount(rs.getInt("latecomingcount"));
						t.setEarlygoingcount(rs.getInt("earlygoingcount"));
						t.setPresentcount(rs.getDouble("presentcount"));
						t.setAbsentcount(rs.getInt("absentcount"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> totalLeavesCount(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				Date date3 = null;
				try {
					date2 = formatter2.parse(StartDate);
					date3 = formatter2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String sql = "SELECT LEAVE_COUNT_APPROVED ,LEAVE_COUNT_Rejected, LEAVE_COUNT_Pending_approval ,LEAVE_COUNT_TOTAL_APPLIED FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_APPROVED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Approved'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Rejected FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Rejected'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Pending_approval FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_TOTAL_APPLIED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval','Rejected','Approved'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_approved(rs.getDouble("LEAVE_COUNT_APPROVED"));
						t.setLeave_count_rejected(rs.getDouble("LEAVE_COUNT_Rejected"));
						t.setLeves_count_Pending_approval(rs.getDouble("LEAVE_COUNT_Pending_approval"));
						t.setLeave_count_total_applied(rs.getDouble("LEAVE_COUNT_TOTAL_APPLIED"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> levesCountforPresent(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				Date date3 = null;
				try {
					date2 = formatter2.parse(StartDate);
					date3 = formatter2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				String sql = "SELECT LEAVE_COUNT_PL,LEAVE_COUNT_CL ,LEAVE_COUNT_LWP,LEAVE_COUNT_OD FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_LWP FROM LEAVE_REQUEST_LINES LRL ,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId
						+ "' AND LEAVE_TYPE = 5 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_OD FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LR.EMP_ID='" + employeeId + "'  AND LEAVE_TYPE IN (7,8))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_pl(rs.getInt("LEAVE_COUNT_PL"));
						t.setLeave_count_cl(rs.getInt("LEAVE_COUNT_CL"));
						t.setLeave_count_lwp(rs.getInt("LEAVE_COUNT_LWP"));
						t.setLeave_count_od(rs.getInt("LEAVE_COUNT_OD"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesDedictionCount(String StartDate, String endDate, String employeeId) {

				String sql = "SELECT LWPdeduction , PLdeduction , CLdeduction, TOTALLEAVEDEDICTION FROM(SELECT SUM(LWP) LWPdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND EMP_ID='" + employeeId
						+ "' AND STATUS='LE' AND LWP='0.5'),(SELECT SUM(PL) AS PLdeduction  FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND EMP_ID='" + employeeId
						+ "' AND STATUS='LE' AND PL='0.5'),(SELECT SUM(CL) AS CLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND EMP_ID='" + employeeId
						+ "' AND STATUS='LE' AND CL='0.5'),(SELECT COUNT(EMP_ID) AS TOTALLEAVEDEDICTION FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND EMP_ID='" + employeeId + "' AND STATUS='LE')";


				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLwpdeduction(rs.getDouble("LWPdeduction"));
						t.setPldeduction(rs.getDouble("PLdeduction"));
						t.setCldeduction(rs.getDouble("CLdeduction"));
						t.setTotalleavedediction(rs.getDouble("TOTALLEAVEDEDICTION"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public int updateLateEarlyStatus(Employee_Master employeeMaster) {
				// TODO Auto-generated method stub
				String sql = "UPDATE EMPLOYEE_MASTER SET EARLYLATE_COMINGSTATUS= '" + employeeMaster.getEarlylate_comingstatus()
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
			public List<Employee_Master> lateEarlyRulesStatus(int employeeId) {
				// TODO Auto-generated method stub
				String sql = "select EARLYLATE_COMINGSTATUS,EMAIL from employee_master where emp_id='" + employeeId + "'";
				List<Employee_Master> employeesList = jdbcTemplate.query(sql, new RowMapper<Employee_Master>() {

					@Override
					public Employee_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee_Master t = new Employee_Master();

						t.setEarlylate_comingstatus(rs.getString("EARLYLATE_COMINGSTATUS"));
						t.setEmail(rs.getString("EMAIL"));

						return t;
					}

				});
				return employeesList;
			}

			@Override
			public List<AttendanceModule> employeeAttendaceReportLateComing(String startDate, String endDate) {

				String sql = "select * from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,9) AS LOGDATE ,PANCH_IN AS LOGDATETIME,replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME, case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' end as Status_in from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)ORDER BY LOGDATE asc) where status_in is not null ";

				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("total_time"));
						t.setStatus_in(rs.getString("Status_in"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<AttendanceModule> employeeAttednaceReportEarlyGoing(String startDate, String endDate) {
				// TODO Auto-generated method stub
				String sql = "select * from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,9) AS LOGDATE ,PANCH_OUT AS LOGDATETIME,replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME, case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Early Going' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT,EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)ORDER BY LOGDATE asc) where Status_OUT is not null";

				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("total_time"));
						t.setStatus_out(rs.getString("Status_out"));
						return t;
					}
				});
				System.out.println(attendanceList);
				return attendanceList;
			}

			@Override
			public List<AttendanceModule> employeeAttendanceReportOnIntime(String startDate, String endDate) {
				// TODO Auto-generated method stub
				String sql = "select * from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,9) AS LOGDATE ,PANCH_IN AS LOGDATETIME,replace(SUBSTR(PANCH_IN,10,9),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,9),'.',':')PANCH_OUT,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') <= to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Ontime' end as Status_in from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE) ORDER BY LOGDATE asc) where status_in is not null";

				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setStatus_in(rs.getString("Status_in"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<AttendanceModule> employeeAtteendaceReportOuttime(String startDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "select * from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,9) AS LOGDATE ,PANCH_OUT AS LOGDATETIME,replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME, case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') >= to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Ontime' end as Status_OUT from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT,EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)ORDER BY LOGDATE asc) where Status_OUT is not null";

				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("total_time"));
						t.setStatus_out(rs.getString("Status_OUT"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<Late_Early_Debited_Leaves> lateEarlyDebitedLeavesReport(String startDate, String endDate) {
				// TODO Auto-generated method stub

				
				String sql="select le.emp_id,le.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,le.PL,le.CL,le.LWP,le.STATUS,le.LAST_UPDATE_DATE from LATE_EARLY_DEBITED_LEAVES le , EMPLOYEE_MASTER EM WHERE le.EMP_ID=EM.EMP_ID AND LE.LAST_UPDATE_DATE  BETWEEN to_char(TO_DATE('"+startDate+"','YYYY-MM-DD'),'DD-MON-YY') AND to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'DD-MON-YY')";

				List<Late_Early_Debited_Leaves> attendanceList = jdbcTemplate.query(sql,
						new RowMapper<Late_Early_Debited_Leaves>() {

							@Override
							public Late_Early_Debited_Leaves mapRow(ResultSet rs, int rowNum) throws SQLException {
								Late_Early_Debited_Leaves t = new Late_Early_Debited_Leaves();
								t.setEmp_id(rs.getString("emp_id"));
								t.setEmp_code(rs.getString("EMP_CODE"));
								t.setFirstName(rs.getString("EMP_FIRST_NAME"));
								t.setLastName(rs.getString("EMP_LAST_NAME"));
								t.setPl(rs.getString("PL"));
								t.setCl(rs.getString("CL"));
								t.setLwp(rs.getString("LWP"));
								t.setStatus(rs.getString("STATUS"));
								t.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));

								return t;
							}
						});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> employeeLeavesReports(String startDate, String endDate) {
				// TODO Auto-generated method stu
				String sql = "select lrl.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lrl.START_DATE,lrl.END_DATE,lr.STATUS,LT.LEAVE_TYPE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT ,EMPLOYEE_MASTER EM WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ startDate + "','YYYY-MM-DD'),'DD-MON-YY')AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.EMP_ID=EM.EMP_ID ORDER BY LRL.LR_ID";

				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setStart_date(rs.getString("START_DATE"));
						t.getStart_date().substring(0, 10);
						t.setEnd_date(rs.getString("END_DATE"));
						t.getEnd_date().substring(0, 10);
						t.setStatus(rs.getString("STATUS"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setDayType(rs.getString("DAY_TYPE"));
						return t;
					}
				});
				return attendanceList;

			}

//			@Transactional
//			@Override
//			public int updateAutoCreaditLeaves(Auto_Credit_Leaves acl) {
//				// TODO Auto-generated method stub
//
//				hibernateTemplate.saveOrUpdate(acl);
//
//				return 1;
//			}

			@Override
			public List<LateEarlyEvents> biomaxCountHR(String startDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount, COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss')then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME  from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE  AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "'  group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLatecomingcount(rs.getInt("latecomingcount"));
						t.setEarlygoingcount(rs.getInt("earlygoingcount"));
						t.setPresentcount(rs.getDouble("presentcount"));
						t.setAbsentcount(rs.getInt("absentcount"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> totalLeavesCountHR(String StartDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "SELECT LEAVE_COUNT_APPROVED ,LEAVE_COUNT_Rejected, LEAVE_COUNT_Pending_approval ,LEAVE_COUNT_TOTAL_APPLIED FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_APPROVED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Approved'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Rejected FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Rejected'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Pending_approval FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_TOTAL_APPLIED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval','Rejected','Approved'))";


				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_approved(rs.getDouble("LEAVE_COUNT_APPROVED"));
						t.setLeave_count_rejected(rs.getDouble("LEAVE_COUNT_Rejected"));
						t.setLeves_count_Pending_approval(rs.getDouble("LEAVE_COUNT_Pending_approval"));
						t.setLeave_count_total_applied(rs.getDouble("LEAVE_COUNT_TOTAL_APPLIED"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> levesCountforPresentHR(String StartDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "SELECT LEAVE_COUNT_PL,LEAVE_COUNT_CL ,LEAVE_COUNT_LWP,LEAVE_COUNT_OD FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY')  AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_LWP FROM LEAVE_REQUEST_LINES LRL ,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND LEAVE_TYPE = 5 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_OD FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lrl.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'dd-MON-YY')  AND LEAVE_TYPE IN (7,8) AND lr.STATUS IN ('Approved'))";


				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_pl(rs.getDouble("LEAVE_COUNT_PL"));
						t.setLeave_count_cl(rs.getDouble("LEAVE_COUNT_CL"));
						t.setLeave_count_lwp(rs.getDouble("LEAVE_COUNT_LWP"));
						t.setLeave_count_od(rs.getDouble("LEAVE_COUNT_OD"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesDedictionCountHR(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				
				String sql="SELECT LWPdeduction , PLdeduction , CLdeduction ,TOTALLEAVEDEDICTION FROM (SELECT SUM(LWP) LWPdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE  LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"+StartDate+"','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'DD-MON-YY') AND STATUS='LE' AND LWP='0.5'),(SELECT SUM(PL) AS PLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"+StartDate+"','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'DD-MON-YY')  AND STATUS='LE' AND PL='0.5'),(SELECT SUM(CL) AS CLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"+StartDate+"','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'DD-MON-YY') AND STATUS='LE' AND CL='0.5'),(SELECT SUM(EMP_ID) AS TOTALLEAVEDEDICTION FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"+StartDate+"','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'DD-MON-YY') AND STATUS='LE')";
				
//				String sql = "SELECT LWPdeduction , PLdeduction , CLdeduction, TOTALLEAVEDEDICTION FROM (SELECT COUNT(EMP_ID) LWPdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE   LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
//						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
//						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND STATUS='LE' AND LWP='0.5'),(SELECT COUNT(EMP_ID) AS PLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
//						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
//						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND STATUS='LE' AND PL='0.5'),(SELECT COUNT(EMP_ID) AS CLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
//						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
//						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND STATUS='LE' AND CL='0.5'),(SELECT COUNT(EMP_ID) AS TOTALLEAVEDEDICTION FROM LATE_EARLY_DEBITED_LEAVES WHERE LAST_UPDATE_DATE BETWEEN to_char(TO_DATE('"
//						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY')  AND to_char(TO_DATE('" + endDate
//						+ "','YYYY-MM-DD'),'DD-MON-YY')  AND STATUS='LE')";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLwpdeduction(rs.getDouble("LWPdeduction"));
						t.setPldeduction(rs.getDouble("PLdeduction"));
						t.setCldeduction(rs.getDouble("CLdeduction"));
						t.setTotalleavedediction(rs.getDouble("TOTALLEAVEDEDICTION"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesUtilization(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub

				String sql = "SELECT utilized_CL,utilized_PL FROM(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved') AND LRL.EMP_ID='"
						+ employeeId + "' AND LRL.START_DATE >= to_char(TO_DATE('" + StartDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')),(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved') AND LRL.EMP_ID='"
						+ employeeId + "' AND LRL.START_DATE >= to_char(TO_DATE('" + StartDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setUtilizedCl(rs.getDouble("utilized_CL"));
						t.setUtilizedPl(rs.getDouble("utilized_PL"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesUtilizationHR(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				String sql = "SELECT utilized_CL,utilized_PL FROM(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved') AND  LRL.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY')),(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved') AND LRL.START_DATE >= to_char(TO_DATE('"
						+ StartDate + "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY'))";
				

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setUtilizedCl(rs.getDouble("utilized_CL"));
						t.setUtilizedPl(rs.getDouble("utilized_PL"));
						
						return t;
					}

				});
				return attendanceList;

			}

			@Override
			public List<EmployeeStatus> utilizeLeaveClReport(String startDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL,EM.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,LT.LEAVE_TYPE,LRL.START_DATE,LRL.END_DATE FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr,EMPLOYEE_MASTER EM ,LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lr.EMP_ID = EM.EMP_ID  AND LRL.LEAVE_TYPE=LT.L_NO AND LRL.LEAVE_TYPE IN (1,2) AND lr.STATUS IN ('Approved') AND LRL.START_DATE >= to_char(TO_DATE('"
						+ startDate + "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') GROUP BY EM.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,LRL.LEAVE_TYPE,LT.LEAVE_TYPE,LRL.START_DATE,LRL.END_DATE";

				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setLeaveUtilized(rs.getString("utilized_CL"));
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setStart_date(rs.getString("START_DATE"));
						t.setStart_date(t.getStart_date().substring(0,10));
						t.setEnd_date(rs.getString("END_DATE"));
						t.setEnd_date(t.getEnd_date().substring(0,10));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> utilizeLeavePlReport(String startDate, String endDate) {
				// TODO Auto-generated method stub

				String sql = "SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL,EM.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,LT.LEAVE_TYPE,LRL.START_DATE,LRL.END_DATE FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr,EMPLOYEE_MASTER EM ,LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lr.EMP_ID = EM.EMP_ID  AND LRL.LEAVE_TYPE=LT.L_NO AND LRL.LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved') AND LRL.START_DATE >= to_char(TO_DATE('"
						+ startDate + "','YYYY-MM-DD'),'DD-MON-YY') AND LRL.END_DATE <= to_char(TO_DATE('" + endDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') GROUP BY EM.EMP_CODE,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,LRL.LEAVE_TYPE,LT.LEAVE_TYPE,LRL.START_DATE,LRL.END_DATE";

				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setLeaveUtilized(rs.getString("utilized_CL"));
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setStart_date(rs.getString("START_DATE"));
						t.setEnd_date(rs.getString("END_DATE"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<Late_Early_Debited_Leaves> lateEarlyDebitedLeaveEmployee(String startDate, int employeeId) {
				// TODO Auto-generated method stub
				String sql = "select EMP_ID,PL,CL,LWP,LAST_UPDATE_DATE FROM LATE_EARLY_DEBITED_LEAVES WHERE EMP_ID='"
						+ employeeId + "' AND LAST_UPDATE_DATE = to_char(TO_DATE('" + startDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') ";

				List<Late_Early_Debited_Leaves> attendanceList = jdbcTemplate.query(sql,
						new RowMapper<Late_Early_Debited_Leaves>() {

							@Override
							public Late_Early_Debited_Leaves mapRow(ResultSet rs, int rowNum) throws SQLException {
								Late_Early_Debited_Leaves t = new Late_Early_Debited_Leaves();
								t.setEmp_id(rs.getString("EMP_ID"));
								t.setPl(rs.getString("PL"));
								t.setCl(rs.getString("CL"));
								t.setLwp(rs.getString("LWP"));
								//t.setStatus(rs.getString("STATUS"));
								t.setLast_update_date(rs.getDate("LAST_UPDATE_DATE"));

								return t;
							}
						});
				return attendanceList;

			}

			@Override
			public int CreditLeavesAuto(Leave_Creadit_Auto creditLeavesAuto) {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO LEAVE_CREADIT_AUTO(MIN_PRESENT_DAYS,MAX_PRESENT_DAYS,EMPLOYEE_TYPE,LEAVE_TYPE,CREADIT_FREQUENCY,LEAVE_CREDITED)"
						+ " values (?, ?, ?, ?, ?, ?)";
				try {

					int counter = jdbcTemplate.update(sql,
							new Object[] { creditLeavesAuto.getMinpresentdays(), creditLeavesAuto.getMaxpresnetdays(),
									creditLeavesAuto.getEmployeetype(), creditLeavesAuto.getLeavetype(),
									creditLeavesAuto.getCreditfrequency(), creditLeavesAuto.getLeavecreadited() });
					return counter;

				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}

			}

			@Transactional
			@Override
			public int updateCreditLeavesAuto(Leave_Creadit_Auto acl) {
				hibernateTemplate.saveOrUpdate(acl);
				return 1;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreadiLeavesAuto() {
				// TODO Auto-generated method stub
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query("SELECT * FROM Leave_Creadit_Auto ORDER BY SL_NO ASC",
						new RowMapper<Leave_Creadit_Auto>() {

							@Override
							public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
								Leave_Creadit_Auto t = new Leave_Creadit_Auto();

								t.setSlno(rs.getInt("SL_NO"));
								t.setLeavetype(rs.getString("LEAVE_TYPE"));
								t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
								t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
								t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
								t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
								t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

								return t;
							}
						});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreadiLeavesAuto(int slno) {
				// TODO Auto-generated method stub
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(
						"SELECT * FROM Leave_Creadit_Auto where sl_no=" + slno + "", new RowMapper<Leave_Creadit_Auto>() {

							@Override
							public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
								Leave_Creadit_Auto t = new Leave_Creadit_Auto();

								t.setSlno(rs.getInt("SL_NO"));
								t.setLeavetype(rs.getString("LEAVE_TYPE"));
								t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
								t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
								t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
								t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
								t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

								return t;
							}
						});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditConformhfPl() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=1";
				
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));
		                
						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditConfromFlPL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=2";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditProbationhfPl() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=4";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();
						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditProbationFlPl() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=3";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditTraineehfPl() {
				// TODO Auto-generated method stub

				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=6";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditTraineeFlPl() {
				// TODO Auto-generated method stub

				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=5";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditConformHfCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=7";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditConformFlCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=8";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));
						
						
						return t;
					}
				});
				return employeesList;
			}

			@Override
			public List<Leave_Creadit_Auto> readCreaditProbationHfCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=9";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}
			
			
			@Override
			public List<Leave_Creadit_Auto> readCreaditProbationFlCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=10";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}
			
			
			
			@Override
			public List<Leave_Creadit_Auto> readCreaditTraineeFlCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=11";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}
			
			
			@Override
			public List<Leave_Creadit_Auto> readCreaditTraineeHfCL() {
				// TODO Auto-generated method stub
				String sql = "select sl_no,leave_type,min_present_days,max_present_days,employee_type,creadit_frequency,leave_credited from LEAVE_CREADIT_AUTO where sl_no=12";
				List<Leave_Creadit_Auto> employeesList = jdbcTemplate.query(sql, new RowMapper<Leave_Creadit_Auto>() {

					@Override
					public Leave_Creadit_Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Leave_Creadit_Auto t = new Leave_Creadit_Auto();

						t.setSlno(rs.getInt("SL_NO"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setMinpresentdays(rs.getInt("MIN_PRESENT_DAYS"));
						t.setMaxpresnetdays(rs.getInt("MAX_PRESENT_DAYS"));
						t.setEmployeetype(rs.getString("EMPLOYEE_TYPE"));
						t.setCreditfrequency(rs.getString("CREADIT_FREQUENCY"));
						t.setLeavecreadited(rs.getFloat("LEAVE_CREDITED"));

						return t;
					}
				});
				return employeesList;
			}
			
			

			@Override
			public List<LateEarlyEvents> biomaxCountMonth(String startDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				String sql = "select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount, COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND EMP.EMP_ID='"
						+ employeeId + "' AND TO_CHAR(LOGDATETIME,'YYYY-MM') BETWEEN '" + startDate + "' AND '" + endDate
						+ "' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLatecomingcount(rs.getInt("latecomingcount"));
						t.setEarlygoingcount(rs.getInt("earlygoingcount"));
						t.setPresentcount(rs.getDouble("presentcount"));
						t.setAbsentcount(rs.getInt("absentcount"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> totalLeavesCountMonth(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm");
				Date date2 = null;
				Date date3 = null;
				try {
					date2 = formatter2.parse(StartDate);
					date3 = formatter2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
						
				String sql="SELECT LEAVE_COUNT_APPROVED ,LEAVE_COUNT_Rejected, LEAVE_COUNT_Pending_approval ,LEAVE_COUNT_TOTAL_APPLIED FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_APPROVED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND lr.EMP_ID='" +employeeId+"' AND LEAVE_TYPE IN (1,2,5,7) AND lr.STATUS = 'Approved'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Rejected FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND lr.EMP_ID='"+employeeId+"' AND LEAVE_TYPE IN (1,2,5,7) AND lr.STATUS = 'Rejected'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Pending_approval FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND  lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND lr.EMP_ID='"+employeeId+"' AND LEAVE_TYPE IN (1,2,5,7) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')), (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_TOTAL_APPLIED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND lr.EMP_ID='"+employeeId+"' AND LEAVE_TYPE IN (1,2,5,7) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval','Rejected','Approved'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_approved(rs.getDouble("LEAVE_COUNT_APPROVED"));
						t.setLeave_count_rejected(rs.getDouble("LEAVE_COUNT_Rejected"));
						t.setLeves_count_Pending_approval(rs.getDouble("LEAVE_COUNT_Pending_approval"));
						t.setLeave_count_total_applied(rs.getDouble("LEAVE_COUNT_TOTAL_APPLIED"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> levesCountforPresentMonth(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm");
				Date date2 = null;
				Date date3 = null;
				try {
					date2 = formatter2.parse(StartDate);
					date3 = formatter2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				String sql="SELECT LEAVE_COUNT_PL,LEAVE_COUNT_CL,LEAVE_COUNT_LWP,LEAVE_COUNT_OD FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LR.EMP_ID='"+employeeId+"' AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LR.EMP_ID='"+employeeId+"' AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_LWP FROM LEAVE_REQUEST_LINES LRL ,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LR.EMP_ID='"+employeeId+"' AND LEAVE_TYPE = 5 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_OD FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LR.EMP_ID='"+employeeId+"' AND LEAVE_TYPE IN (7,8))";
				
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_pl(rs.getDouble("LEAVE_COUNT_PL"));
						t.setLeave_count_cl(rs.getDouble("LEAVE_COUNT_CL"));
						t.setLeave_count_lwp(rs.getDouble("LEAVE_COUNT_LWP"));
						t.setLeave_count_od(rs.getDouble("LEAVE_COUNT_OD"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesDedictionCountMonth(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				
				String sql="SELECT LWPdeduction , PLdeduction , CLdeduction, TOTALLEAVEDEDICTION FROM(SELECT SUM(LWP) LWPdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND EMP_ID='"+ employeeId+"' AND STATUS='LE' AND LWP='0.5'),(SELECT SUM(PL) AS PLdeduction  FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"'  AND EMP_ID='"+ employeeId+"' AND STATUS='LE' AND PL='0.5'),(SELECT SUM(CL) AS CLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND EMP_ID='"+employeeId+"' AND STATUS='LE' AND CL='0.5'),(SELECT COUNT(EMP_ID) AS TOTALLEAVEDEDICTION FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND EMP_ID='"+ employeeId + "' AND STATUS='LE')";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLwpdeduction(rs.getDouble("LWPdeduction"));
						t.setPldeduction(rs.getDouble("PLdeduction"));
						t.setCldeduction(rs.getDouble("CLdeduction"));
						t.setTotalleavedediction(rs.getDouble("TOTALLEAVEDEDICTION"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesUtilizationMonth(String StartDate, String endDate, String employeeId) {
				// TODO Auto-generated method stub
				
				String sql="SELECT utilized_CL,utilized_PL FROM(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved') AND LRL.EMP_ID='"+employeeId+"' AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON')),(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved') AND LRL.EMP_ID='"+employeeId+"' AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON'))";
				
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setUtilizedCl(rs.getDouble("utilized_CL"));
						t.setUtilizedPl(rs.getDouble("utilized_PL"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> biomaxCountHRMonth(String startDate, String endDate) {
				// TODO Auto-generated method stub
				String sql = "select count(latecoming) as latecomingcount,COUNT(EARLYGOING) as earlygoingcount, COUNT(PRESENT) as presentcount, COUNT(ABSENT) as absentcount from (select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,SUBSTR(LOGDATE,1,10),replace(SUBSTR(PANCH_IN,10,8),'.',':')PANCH_IN,replace(SUBSTR(PANCH_OUT,10,8),'.',':')PANCH_OUT,CASE WHEN PANCH_IN IS NOT NULL THEN 'PRSENT' END AS PRESENT,CASE WHEN PANCH_IN IS  NULL THEN 'PRSENT' END AS ABSENT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss')then 'Late Coming' end as latecoming,case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Early Going' end as EARLYGOING from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN,max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME  from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE  AND TO_CHAR(LOGDATETIME,'YYYY-MM') BETWEEN '"
						+ startDate + "' AND '" + endDate
						+ "'  group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLatecomingcount(rs.getInt("latecomingcount"));
						t.setEarlygoingcount(rs.getInt("earlygoingcount"));
						t.setPresentcount(rs.getDouble("presentcount"));
						t.setAbsentcount(rs.getInt("absentcount"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> totalLeavesCountHRMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				
				String sql="SELECT LEAVE_COUNT_APPROVED ,LEAVE_COUNT_Rejected, LEAVE_COUNT_Pending_approval ,LEAVE_COUNT_TOTAL_APPLIED FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_APPROVED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Approved'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Rejected FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS = 'Rejected'),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_Pending_approval FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_TOTAL_APPLIED FROM LEAVE_REQUEST_LINES LRL , LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE IN (1,2,5) AND lr.STATUS IN ('Pending for AR Approval','Pending for FR Approval','Pending for MG Approval','Rejected','Approved'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_approved(rs.getDouble("LEAVE_COUNT_APPROVED"));
						t.setLeave_count_rejected(rs.getDouble("LEAVE_COUNT_Rejected"));
						t.setLeves_count_Pending_approval(rs.getDouble("LEAVE_COUNT_Pending_approval"));
						t.setLeave_count_total_applied(rs.getDouble("LEAVE_COUNT_TOTAL_APPLIED"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> levesCountforPresentHRMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				
				String sql="SELECT LEAVE_COUNT_CL,LEAVE_COUNT_PL,LEAVE_COUNT_LWP,LEAVE_COUNT_OD FROM (SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_LWP FROM LEAVE_REQUEST_LINES LRL ,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE = 5 AND lr.STATUS IN ('Approved')),(SELECT SUM(LRL.LEAVE_COUNT) AS LEAVE_COUNT_OD FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON') AND LEAVE_TYPE IN (7,8) and lr.STATUS IN ('Approved'))";
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setLeave_count_pl(rs.getDouble("LEAVE_COUNT_PL"));
						t.setLeave_count_cl(rs.getDouble("LEAVE_COUNT_CL"));
						t.setLeave_count_lwp(rs.getDouble("LEAVE_COUNT_LWP"));
						t.setLeave_count_od(rs.getDouble("LEAVE_COUNT_OD"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesDedictionCountHRMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				
		             String sql="SELECT LWPdeduction,PLdeduction,CLdeduction,TOTALLEAVEDEDICTION FROM (SELECT SUM(LWP) LWPdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND STATUS='LE' AND LWP='0.5'),(SELECT SUM(PL) AS PLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND STATUS='LE' AND PL='0.5'),(SELECT SUM(CL) AS CLdeduction FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND STATUS='LE' AND CL='0.5'),(SELECT COUNT(EMP_ID) AS TOTALLEAVEDEDICTION FROM LATE_EARLY_DEBITED_LEAVES WHERE TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') >='"+StartDate+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') <='"+endDate+"' AND STATUS='LE')";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setLwpdeduction(rs.getDouble("LWPdeduction"));
						t.setPldeduction(rs.getDouble("PLdeduction"));
						t.setCldeduction(rs.getDouble("CLdeduction"));
						t.setTotalleavedediction(rs.getDouble("TOTALLEAVEDEDICTION"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> leavesUtilizationHRMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub		
				String sql="SELECT utilized_CL,utilized_PL FROM(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_CL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 1 AND lr.STATUS IN ('Approved') AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON')),(SELECT SUM(LRL.LEAVE_COUNT) AS utilized_PL FROM LEAVE_REQUEST_LINES LRL,LEAVE_REQUEST lr WHERE lr.LR_ID = lrl.LR_ID AND LEAVE_TYPE = 2 AND lr.STATUS IN ('Approved') AND to_char(to_date(START_DATE),'YY-MON') >= TO_CHAR(TO_DATE('"+StartDate+"','YYYY-MM'),'YY-MON') AND to_char(to_date(END_DATE),'YY-MON') <= TO_CHAR(TO_DATE('"+endDate+"','YYYY-MM'),'YY-MON'))";

				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();

						t.setUtilizedCl(rs.getDouble("utilized_CL"));
						t.setUtilizedPl(rs.getDouble("utilized_PL"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<Employee_Master> readEmployeeMasterLateEarlyRules() {
				// TODO Auto-generated method stub
		        String sql="SELECT EMP_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,earlylate_comingstatus FROM EMPLOYEE_MASTER WHERE earlylate_comingstatus='N'";
				List<Employee_Master> attendanceList = jdbcTemplate.query(sql, new RowMapper<Employee_Master>() {

					@Override
					public Employee_Master mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee_Master t = new Employee_Master();
						
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setEarlylate_comingstatus(rs.getString("earlylate_comingstatus"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> holidayCountHRMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				   String sDate1=StartDate;
				   SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
				   Date date1=null;
				try {
					date1 = formatter1.parse(sDate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				//String sql="select COUNT(H_ID) AS HOLIDAYS from HOLIDAYS_SETUP where HOLIDAY_DATE BETWEEN '"+StartDate+"' AND '"+endDate+"' ";
				 
				String sql="select COUNT(H_ID) as HOLIDAYS from HOLIDAYS_SETUP where TO_CHAR(TO_DATE(HOLIDAY_DATE),'YYYY-MM-DD') >= '"+StartDate+"' AND TO_CHAR(TO_DATE(HOLIDAY_DATE),'YYYY-MM-DD') <= '"+endDate+"'";
				
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						
						t.setHolidaysPresentCount(rs.getDouble("HOLIDAYS"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> sundaysCountHrMonth(String StartDate, String endDate) {
				// TODO Auto-generated method stub
				String sql="with dd as(select TO_DATE('"+StartDate+"','yyyy-MM-dd') fdt, TO_DATE('"+endDate+"','yyyy-MM-dd') ldt from dual) SELECT (next_day(ldt,'sunday')-next_day(fdt-1,'sunday'))/7  holidaysPresentCount FROM dd";
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {

					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						
						t.setWeeklyPresentCount(rs.getDouble("holidaysPresentCount"));

						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<Joining_Details> employeeStatus(String empId) {
				// TODO Auto-generated method stub
				String sql="SELECT EMPLOYEE_STATUS FROM JOINING_DETAILS WHERE EMP_ID='"+empId+"' ";
				List<Joining_Details> attendanceList = jdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

					@Override
					public Joining_Details mapRow(ResultSet rs, int rowNum) throws SQLException {
						Joining_Details t = new Joining_Details();
						t.setEmployee_status(rs.getString("EMPLOYEE_STATUS"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<MarkExitScreen> exitType(String empId) {
				// TODO Auto-generated method stub
				String sql="select exit_type from MARK_EXIT_SCREEN where emp_id='"+empId+"' ";
				List<MarkExitScreen> attendanceList = jdbcTemplate.query(sql, new RowMapper<MarkExitScreen>() {

					@Override
					public MarkExitScreen mapRow(ResultSet rs, int rowNum) throws SQLException {
						MarkExitScreen t = new MarkExitScreen();
						t.setExittype(rs.getString("exit_type"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<Joining_Details> employeeJoiningDate(int employeeId) {
				// TODO Auto-generated method stub
				
				String sql="SELECT JOINING_DATE,EMPLOYEE_STATUS FROM JOINING_DETAILS WHERE EMP_ID='"+employeeId+"' ";

				List<Joining_Details> attendanceList = jdbcTemplate.query(sql, new RowMapper<Joining_Details>() {

					@Override
					public Joining_Details mapRow(ResultSet rs, int rowNum) throws SQLException {
						Joining_Details t = new Joining_Details();
						t.setJoining_date(rs.getDate("JOINING_DATE"));
						t.setEmployee_status(rs.getString("EMPLOYEE_STATUS"));					
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LateEarlyEvents> employeeDaysCount(String start, String end) {
				// TODO Auto-generated method stub

				String sql="with t as (select date '"+start+"' as dt_from, date '"+end+"' as dt_to from dual) select dt_to - dt_from as totalDays from t";
				
				List<LateEarlyEvents> attendanceList = jdbcTemplate.query(sql, new RowMapper<LateEarlyEvents>() {				
					@Override
					public LateEarlyEvents mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyEvents t = new LateEarlyEvents();
						t.setTotalDays(rs.getInt("TotalDays"));
						
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<AttendanceModule> details1(String todaysDate, int employeeId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<EmployeeMasterAttendance> fr(String employeeCode) {
				// TODO Auto-generated method stub

				String sql="SELECT EMP.emp_id FROM FUNCTIONAL_REPORTING FR,EMPLOYEE_MASTER EMP WHERE EMP.EMP_ID=FR.FUNCTIONAL_REPORTING_ID AND EMP.EMP_CODE= '"+employeeCode+"'";
				
				List<EmployeeMasterAttendance> functional = jdbcTemplate.query(sql, new RowMapper<EmployeeMasterAttendance>() {				
					@Override
					public EmployeeMasterAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeMasterAttendance t = new EmployeeMasterAttendance();
						t.setEmp_id(rs.getString("emp_id"));
						return t;
					}
				});
				return functional;
			}

			@Override
			public List<EmployeeMasterAttendance> ar(String employeeCode) {

				// TODO Auto-generated method stub
				
				String sql="SELECT EMP.emp_id FROM ADMINISTRATIVE_REPORTING AR,EMPLOYEE_MASTER EMP WHERE EMP.EMP_ID=AR.ADMINISTRATIVE_REPORTING_ID AND EMP.EMP_CODE= '"+employeeCode+"'";
				
				List<EmployeeMasterAttendance> functional = jdbcTemplate.query(sql, new RowMapper<EmployeeMasterAttendance>() {				
					@Override
					public EmployeeMasterAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeMasterAttendance t = new EmployeeMasterAttendance();
						t.setEmp_id(rs.getString("emp_id"));
						return t;
					}
				});
				return functional;
			}

			@Override
			public List<EmployeeMasterAttendance> hrdetails() {
				// TODO Auto-generated method stub
                  String sql="select email,EMP_FIRST_NAME from EMPLOYEE_MASTER where EMP_ID=34";				
			
                  List<EmployeeMasterAttendance> hrdetails = jdbcTemplate.query(sql, new RowMapper<EmployeeMasterAttendance>() {				
					@Override
					public EmployeeMasterAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeMasterAttendance t = new EmployeeMasterAttendance();
						t.setEmail(rs.getString("email"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						return t;
					}
				});
				return hrdetails;
			}

//			@Override
//			public List<MonthlyData> Employeesheet(int id,String date) {
//				// TODO Auto-generated method stub
//				
//				
//				  String sql="SELECT HOLIDAY_DATE,EMPLOYEE_CODE,STATUS,LEAVE_TYPE,START_DATE,END_DATE,DAY_TYPE FROM(select H_ID,HOLIDAY_DATE,HOLIDAY_NAME from HOLIDAYS_SETUP where TO_CHAR(HOLIDAY_DATE,'YYYY-MM-DD') = '"+date+"'), \r\n" + 
//				  		"(select EMPLOYEE_CODE from(select BM.EMPLOYEE_CODE,BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN, max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') ='"+date+"' \r\n" + 
//				  		"group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE)),\r\n" + 
//				  		"(select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+id+"' AND lrl.START_DATE <= to_char(TO_DATE('"+date+"','YYYY-MM-DD'),'DD-MON-YY') \r\n" + 
//				  		"AND lrl.END_DATE >= to_char(TO_DATE('"+date+"','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO)";				
//					
//				  //System.out.println(sql);
//				  
//                  List<MonthlyData> hrdetails = jdbcTemplate.query(sql, new RowMapper<MonthlyData>() {				
//					@Override
//					public MonthlyData mapRow(ResultSet rs, int rowNum) throws SQLException {
//						MonthlyData t = new MonthlyData();
//						t.setHoliday_date(rs.getDate("HOLIDAY_DATE"));
//						t.setEmp_code(rs.getString("EMPLOYEE_CODE"));
//						t.setStatus(rs.getString("STATUS"));
//						t.setLeave_type(rs.getString("LEAVE_TYPE"));
//						t.setStart_date(rs.getString("START_DATE"));
//						t.setEnd_date(rs.getString("END_DATE"));
//						t.setDayType(rs.getString("DAY_TYPE"));
//						return t;
//					}
//				});
//				return hrdetails;
//			}

//			@Override
//			public List<LATEEARLY> lateEarlycount(int id,String startdate,String enddate) {
//				// TODO Auto-generated method stub
//				
//				String date=startdate.substring(0,7)+startdate.substring(9,11);
//				
//			    String sql="SELECT SUM(LECOUNT) AS LECOUNT FROM LATEERALY WHERE EMP_ID="+id+" AND UPDATED_DATE BETWEEN '"+date+"' AND '"+enddate+"'";				
//				System.out.println("sql==>"+sql);
//			    
//                List<LATEEARLY>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<LATEEARLY>() {				
//					@Override
//					public LATEEARLY mapRow(ResultSet rs, int rowNum) throws SQLException {
//						LATEEARLY t = new LATEEARLY();
//						t.setLecount(rs.getInt("LECOUNT"));
//						return t;
//					}
//				});
//				return lateearlycount;
//			}

			@Override
			public List<EmployeeMasterAttendance> empmaster1(int empid) {
				// TODO Auto-generated method stub
				String sql = "select CREATED_BY,CREATION_DATE,EMP_CODE,Email,EMP_DEACT_DATE,EMP_FIRST_NAME,EMP_ID,EMP_LAST_NAME,is_activated,IS_DELETED,LAST_UPDATED_BY,last_update_date,mytestcloumn,otp,password,photo_name,profile_id,project_role_id,PROJECT_ROLE_ID,SALTKEY,user_id from employee_master where is_activated = 'Y'"
					+ " AND EMP_ID='"+empid+"'";
				List<EmployeeMasterAttendance> attendanceList = jdbcTemplate.query(sql,
						new RowMapper<EmployeeMasterAttendance>() {

							@Override
							public EmployeeMasterAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
								EmployeeMasterAttendance t = new EmployeeMasterAttendance();

								t.setCreated_by(rs.getString("CREATED_BY"));
								t.setCreation_date(rs.getString("CREATION_DATE"));
								t.setEmp_code(rs.getString("EMP_CODE"));
								t.setEmail(rs.getString("Email"));
								t.setEmp_deact_date(rs.getString("EMP_DEACT_DATE"));
								t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
								t.setEmp_id(rs.getString("EMP_ID"));
								t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
								t.setIs_activated(rs.getString("is_activated"));
								t.setIs_deleted(rs.getString("IS_DELETED"));
								t.setLast_update_by(rs.getString("LAST_UPDATED_BY"));
								t.setLast_update_date(rs.getString("last_update_date"));
								t.setMytestcloumn(rs.getString("mytestcloumn"));
								t.setOtp(rs.getString("otp"));
								t.setPassword(rs.getString("password"));
								t.setPhoto_name(rs.getString("photo_name"));
								t.setProfile_id(rs.getString("profile_id"));
								t.setProject_role_id(rs.getString("PROJECT_ROLE_ID"));
								t.setSaltkey(rs.getString("SALTKEY"));
								// t.setUpload_photo(rs.getString("UPLOAD_PHOTO"));
								t.setUser_id(rs.getString("user_id"));
								return t;
							}
						});

				return attendanceList;
			}

			@Override
			public List<Early_Late_Tracking> attRegularizationCount1(String date, String endDate, int employeeId) {
				// TODO Auto-generated method stub
				String sql="SELECT EMPLOYEE_CODE,CATEGORIES,LEAVE_STATUS FROM Attendance_Regularization WHERE EMPLOYEE_ID='"+employeeId+"' \r\n" + 
						"AND LEAVE_STATUS IN ('Approved','Pending HR Approval') AND \r\n" + 
						"START_DATE >= to_char(TO_DATE('"+date+"','YYYY-MM-DD'),'DD-MON-YY') AND \r\n" + 
						"END_DATE >= to_char(TO_DATE('"+endDate+"','YYYY-MM-DD'),'dd-MON-YY')";

				List<Early_Late_Tracking> attendanceRegulerization = jdbcTemplate.query(sql, new RowMapper<Early_Late_Tracking>() {

					@Override
					public Early_Late_Tracking mapRow(ResultSet rs, int rowNum) throws SQLException {
						Early_Late_Tracking t = new Early_Late_Tracking();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setCategory(rs.getString("CATEGORIES"));
						t.setLeave_Status(rs.getString("LEAVE_STATUS"));

						return t;
					}

				});
				return attendanceRegulerization;
			}


			// ATTENDANCE DASHBORD
			// CODE ADDED SANTOSH KOTGYALE
			
			@Override
			public List<EmployeeStatus> empstatusRejected(String todaysDate, int employeeId) {
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				try {
					date2 = formatter2.parse(todaysDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				
				String sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT\r\n" + 
						"WHERE lr.LR_ID = lrl.LR_ID AND \r\n" + 
						"lrl.EMP_ID = '"+employeeId+"' AND \r\n" + 
						"lrl.START_DATE <= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'DD-MON-YY')\r\n" + 
						"AND lrl.END_DATE >= to_char(TO_DATE('"+todaysDate+"','YYYY-MM-DD'),'dd-MON-YY') \r\n" + 
						"AND  lrl.LEAVE_TYPE = LT.L_NO and STATUS IN ('Pending for AR Approval','Pending for FR Approval','Approved')";
				
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setStatus(rs.getString("status"));
						t.setLeave_type(rs.getString("leave_type"));
						t.setDayType(rs.getString("DAY_TYPE"));
						return t;
					}

				});
				return attendanceList;
			}
			
			@Override
			public List<LATEEARLY> lateEarlycount(int id,String startdate,String enddate) {
				// TODO Auto-generated method stub
				
				String date=startdate.substring(0,7)+startdate.substring(9,11);
				
			    String sql="SELECT SUM(LECOUNT) AS LECOUNT FROM LATEERALY WHERE EMP_ID="+id+" AND UPDATED_DATE BETWEEN '"+date+"' AND '"+enddate+"'";				
			    
			    
                List<LATEEARLY>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<LATEEARLY>() {				
					@Override
					public LATEEARLY mapRow(ResultSet rs, int rowNum) throws SQLException {
						LATEEARLY t = new LATEEARLY();
						t.setLecount(rs.getInt("LECOUNT"));
						return t;
					}
				});
				return lateearlycount;
			}

			public List<EmployeeStatus> odstatus(String todaysDate, int employeeId) {
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-mmm-dd");
				Date date2 = null;
				try {
					date2 = formatter2.parse(todaysDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				     String  sql = "select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = "
						+ employeeId + " AND lrl.START_DATE <= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('" + todaysDate
						+ "','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO and lrl.LEAVE_TYPE=7";
				
				// String sql = "select lr.STATUS,LT.LEAVE_TYPE from LEAVE_REQUEST lr,
				// LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND
				// lrl.EMP_ID = "+employeeId+" AND lrl.START_DATE <= "+date2+" AND
				// lrl.END_DATE >= "+date2+" AND lrl.LEAVE_TYPE = LT.L_NO";
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setStatus(rs.getString("status"));
						t.setLeave_type(rs.getString("leave_type"));
						t.setDayType(rs.getString("DAY_TYPE"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public ArrayList<od_report_lwp> getorldata(String startdate, String enddate) {
				// TODO Auto-generated method stub
				String sql="select ORL.SR_NO,ORL.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,ORL.EMP_CODE,ORL.STATUS,LT.LEAVE_TYPE,ORL.START_DATE,ORL.END_DATE,ORL.DAY_TYPE \r\n" + 
						"from OD_REPORT_LWP ORL,LEAVE_TYPE LT,EMPLOYEE_MASTER EM WHERE\r\n" + 
						"START_DATE >= to_char(TO_DATE('"+startdate+"','YYYY-MM-DD'),'DD-MON-YY') \r\n" + 
						"AND END_DATE <= to_char(TO_DATE('"+enddate+"','YYYY-MM-DD'),'dd-MON-YY') AND ORL.LEAVE_TYPE = LT.L_NO\r\n" + 
						"AND ORL.EMP_ID=EM.EMP_ID";
				
				List<od_report_lwp> attendanceList = jdbcTemplate.query(sql, new RowMapper<od_report_lwp>() {

					@Override
					public od_report_lwp mapRow(ResultSet rs, int rowNum) throws SQLException {
						od_report_lwp t = new od_report_lwp();
						t.setSr_no(rs.getInt("SR_NO"));
						t.setEmp_id(rs.getInt("EMP_ID"));
						t.setEmp_code(rs.getString("EMP_CODE"));
						t.setFirstname(rs.getString("EMP_FIRST_NAME"));
						t.setLastname(rs.getString("EMP_LAST_NAME"));
						t.setStatus(rs.getString("STATUS"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setStart_date(rs.getDate("START_DATE"));
						t.setEnd_date(rs.getDate("END_DATE"));
						
						return t;
					}

				});
				return (ArrayList<od_report_lwp>) attendanceList;
			}

			@Override
			public List<od_report_lwp> getodtolwpdata(int srno) {
				// TODO Auto-generated method stub
				List<od_report_lwp> lines = null;
				Session session = hibernateTemplate.getSessionFactory().openSession();
				Transaction tx = null;
				try{
					tx = session.beginTransaction();
					String query = "from od_report_lwp where sr_no = :srno";
					Query sql = session.createQuery(query);
					sql.setParameter("srno", srno);
					lines = (List<od_report_lwp>) sql.list();
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
			public List<AttendanceModule> empdetails(String date) {
				// TODO Auto-generated method stub
				String sql="select EMPLOYEE_CODE,EMP_FIRST_NAME,EMP_LAST_NAME,trim(CAST( LOGDATE AS Date)) as logdate,REPLACE(SUBSTR(PANCH_IN,10,9), '.', ':') PANCH_IN,REPLACE(SUBSTR(PANCH_OUT,10,9), '.', ':')PANCH_OUT,substr(PANCH_OUT - PANCH_IN,12,8) as TOTAL_TIME,\r\n" + 
						"case when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') > to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') \r\n" + 
						"then 'Late Coming'when to_date(to_char(PANCH_IN,'hh24:mi:ss'),'hh24:mi:ss') < to_date((SELECT START_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') \r\n" + 
						"then 'Ontime' else ' ' end as Status_in, case when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss') >  \r\n" + 
						"to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Ontime'  \r\n" + 
						"when to_date(to_char(PANCH_OUT,'hh24:mi:ss'),'hh24:mi:ss')\r\n" + 
						"< to_date((SELECT END_TIME FROM ATTENDANCE_MODULE),'hh24:mi:ss') then 'Early Going' else ' ' end as \r\n" + 
						"Status_OUT from(select BM.EMPLOYEE_CODE, \r\n" + 
						"BM.LOGDATE,min(case when DIRECTIONS= 'In' then LOGDATETIME end) PANCH_IN, max(case when DIRECTIONS= 'Out' then LOGDATETIME  end) \r\n" + 
						"PANCH_OUT, EMP.EMP_LAST_NAME,EMP_FIRST_NAME from BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP  \r\n" + 
						"where BM.EMPLOYEE_CODE=EMP.EMP_CODE AND \r\n" + 
						"TO_CHAR(LOGDATETIME,'YYYY-MM') ='"+date+"' group by EMPLOYEE_CODE,EMP.EMP_FIRST_NAME,EMP.EMP_LAST_NAME,LOGDATE\r\n" + 
						"order by EMP_FIRST_NAME ASC)";
				
				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setPanch_in(rs.getString("PANCH_IN"));
						t.setPanch_out(rs.getString("PANCH_OUT"));
						t.setTotal_time(rs.getString("total_time"));
						t.setStatus_in(rs.getString("Status_in"));
						t.setStatus_out(rs.getString("Status_out"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> getLeaveDateForAllEmployee(String string) {
				// TODO Auto-generated method stub
				String sql="select lrl.EMP_ID ,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE,lr.LR_ID\r\n" + 
						"from LEAVE_REQUEST lr,  \r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID  \r\n" + 
						"AND (to_char(lrl.START_DATE,'MON-YY') >= to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY') or  \r\n" + 
						"to_char(lrl.END_DATE,'MON-YY') <= to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY')) AND  lrl.LEAVE_TYPE = LT.L_NO  \r\n" + 
						"group by lrl.EMP_ID ,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE,lr.LR_ID order by lr.LR_ID";
				
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setEmpid(rs.getString("EMP_ID"));
						t.setStatus(rs.getString("STATUS"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setDayType(rs.getString("DAY_TYPE"));
						t.setStartDate(rs.getDate("START_DATE"));
						t.setEndDate(rs.getDate("END_DATE"));
						t.setEmp_code(rs.getString("LR_ID"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<od_report_lwp> getOdToLwpConverterAllEmployee(String string) {
				// TODO Auto-generated method stub

				String sql="select ORL.EMP_ID,ORL.STATUS,LT.LEAVE_TYPE,ORL.START_DATE,ORL.END_DATE,ORL.DAY_TYPE from OD_REPORT_LWP ORL,LEAVE_TYPE LT WHERE \r\n" + 
						"(to_char(ORL.START_DATE,'MON-YY') >= to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY') or \r\n" + 
						"to_char(ORL.END_DATE,'MON-YY') <= to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY')) AND ORL.LEAVE_TYPE = LT.L_NO";
				
				List<od_report_lwp> attendanceList = jdbcTemplate.query(sql, new RowMapper<od_report_lwp>() {

					@Override
					public od_report_lwp mapRow(ResultSet rs, int rowNum) throws SQLException {
						od_report_lwp t = new od_report_lwp();
						t.setEmpId(rs.getString("EMP_ID"));
						t.setStatus(rs.getString("STATUS"));
						t.setLeavetype(rs.getString("LEAVE_TYPE"));
						t.setStart_date(rs.getDate("START_DATE"));
						t.setEnd_date(rs.getDate("END_DATE"));
						t.setDay_type(rs.getString("DAY_TYPE"));
						
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<Late_Early_Debited_Leaves> empLECount(int empId, String yearmonth) {
				// TODO Auto-generated method stub 
                String sql="select sum(LWP) AS LWP from LATE_EARLY_DEBITED_LEAVES where EMP_ID='"+empId+"' AND TO_CHAR(LAST_UPDATE_DATE,'YYYY-MM') = '"+yearmonth+"'";
				
				List<Late_Early_Debited_Leaves> attendanceList = jdbcTemplate.query(sql, new RowMapper<Late_Early_Debited_Leaves>() {

					@Override
					public Late_Early_Debited_Leaves mapRow(ResultSet rs, int rowNum) throws SQLException {
						Late_Early_Debited_Leaves t = new Late_Early_Debited_Leaves();
						t.setLwp(rs.getString("LWP"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public ArrayList<Employee_Joining_Details> getAllEmployeeJoining() {
				// TODO Auto-generated method stub
               String sql="SELECT EMP_ID,JOINING_DATE FROM JOINING_DETAILS";
				
				ArrayList<Employee_Joining_Details> attendanceList = (ArrayList<Employee_Joining_Details>) jdbcTemplate.query(sql, new RowMapper<Employee_Joining_Details>() {

					@Override
					public Employee_Joining_Details mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee_Joining_Details t = new Employee_Joining_Details();
					    t.setEmp_id(rs.getInt("EMP_ID"));
					    t.setJoining_date1(rs.getString("JOINING_DATE"));
						
						
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<Early_Late_Tracking> att_reg(String string) {
				// TODO Auto-generated method stub
				
				String sql="SELECT EMPLOYEE_ID,START_DATE,END_DATE FROM ATTENDANCE_REGULARIZATION\r\n" + 
						"WHERE (to_char(START_DATE,'MON-YY') = to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY')\r\n" + 
						" or to_char(END_DATE,'MON-YY') = to_char(TO_DATE('"+string+"','YYYY-MM'),'MON-YY')) AND LEAVE_STATUS='Approved'";
				
				List<Early_Late_Tracking> attendanceList = jdbcTemplate.query(sql, new RowMapper<Early_Late_Tracking>() {
					@Override
					public Early_Late_Tracking mapRow(ResultSet rs, int rowNum) throws SQLException {
						Early_Late_Tracking t = new Early_Late_Tracking();

						t.setEmployee_code(rs.getString("EMPLOYEE_ID"));
						t.setStart_date(rs.getDate("START_DATE"));
						t.setEnd_date(rs.getDate("END_DATE"));
						return t;
					}
				});
				return attendanceList;
			}

			@Override
			public List<AttendanceModule> getbiomaxattendance(LocalDate firstDayOfThisYear, String enddate) {
				// TODO Auto-generated method stub

				String sql="SELECT TRIM(EMP_FIRST_NAME) AS EMP_FIRST_NAME,TRIM(EMP_LAST_NAME) AS EMP_LAST_NAME,BM.ATTID,BM.EMPLOYEE_CODE,TO_CHAR(BM.LOGDATE,'DD-MM-YY') LOGDATE,TO_CHAR(BM.LOGDATETIME,'DD-MM-YY hh:mi:ss AM') LOGDATETIME,BM.DIRECTIONS\r\n" + 
						"FROM BIOMAXATTENDANCE BM,EMPLOYEE_MASTER EMP WHERE BM.EMPLOYEE_CODE=EMP.EMP_CODE AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') >='"+enddate+"'\r\n" + 
						"AND TO_CHAR(LOGDATETIME,'YYYY-MM-DD') <='"+enddate+"' ORDER BY BM.ATTID";
				
				System.out.println("sq==================>"+sql);
				
				
				List<AttendanceModule> attendanceList = jdbcTemplate.query(sql, new RowMapper<AttendanceModule>() {

					@Override
					public AttendanceModule mapRow(ResultSet rs, int rowNum) throws SQLException {
						AttendanceModule t = new AttendanceModule();
						t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
						t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
						t.setAttid(rs.getInt("ATTID"));
						t.setEmployee_code(rs.getString("EMPLOYEE_CODE"));
						t.setLogdate(rs.getString("LOGDATE"));
						t.setLogdatetime(rs.getString("LOGDATETIME"));
						t.setDirection(rs.getString("DIRECTIONS"));
						return t;
					}
				});
				return attendanceList;
			}
			
            @Override
			public List<EmployeeStatus> getLeavetypeforlwpconverter(String startdate, String empid) {
				// TODO Auto-generated method stub
			
				String	sql="select lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND lrl.EMP_ID = '"+empid+"' AND lrl.START_DATE <= to_char(TO_DATE('"+startdate+"','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('"+startdate+"','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
				 
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
				 
				 
				 return attendanceList1;
			}

			@Override
			public List<EmployeeStatus> getLeavedetails(String date) {
				// TODO Auto-generated method stub
				
				String sql="\r\n" + 
						"select lrl.EMP_ID ,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT \r\n" + 
						"WHERE lr.LR_ID = lrl.LR_ID  AND lrl.START_DATE <= to_char(TO_DATE('"+date+"','YYYY-MM-DD'),'DD-MON-YY') AND lrl.END_DATE >= to_char(TO_DATE('"+date+"','YYYY-MM-DD'),'dd-MON-YY') AND lr.STATUS not IN('Cancelled','Rejected') AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
				
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setEmpid(rs.getString("EMP_ID"));
						t.setStatus(rs.getString("STATUS"));
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setDayType(rs.getString("DAY_TYPE"));
						t.setStartDate(rs.getDate("START_DATE"));
						t.setEndDate(rs.getDate("END_DATE"));
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<LATEEARLY> totalLateEarlyCount(String startDate, String strDate, Integer valueOf) {
				// TODO Auto-generated method stub
				String sql="SELECT SUM(LECOUNT) AS LECOUNT FROM LATEERALY \r\n" + 
						"WHERE EMP_ID='"+valueOf+"' AND UPDATED_DATE BETWEEN to_char(TO_DATE('"+startDate+"','YYYY-MM-DD'),'DD-MON-YY') \r\n" + 
						"AND to_char(TO_DATE('"+strDate+"','YYYY-MM-DD'),'DD-MON-YY')";
				
				List<LATEEARLY> attendanceList = jdbcTemplate.query(sql, new RowMapper<LATEEARLY>() {
					@Override
					public LATEEARLY mapRow(ResultSet rs, int rowNum) throws SQLException {
						LATEEARLY t = new LATEEARLY();
						t.setLecount(rs.getInt("LECOUNT"));
						return t;
					}
				});

				return attendanceList;
			}

			@Override
			public List<LateEarlyDetails> leCountInfo(int empId, String date) {
				// TODO Auto-generated method stub
				
				String sql="";
				
				if(empId!=0) {
				    sql="SELECT EMP_ID,LATE_COMING,EARLY_GOING,UPDATED_DATE,MM,STATUS,LECOUNT FROM LATEERALY WHERE EMP_ID='"+empId+"' AND TO_CHAR(UPDATED_DATE, 'YYYY-MM')='"+date+"'";
				}else {
					sql="SELECT EMP_ID,LATE_COMING,EARLY_GOING,UPDATED_DATE,MM,STATUS,LECOUNT FROM LATEERALY WHERE TO_CHAR(UPDATED_DATE, 'YYYY-MM')='"+date+"'";
				}
				
                List<LateEarlyDetails>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<LateEarlyDetails>() {				
					
                	@Override
					public LateEarlyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						LateEarlyDetails t = new LateEarlyDetails();
						t.setEmp_id(rs.getInt("EMP_ID"));
						t.setLate_coming(rs.getString("LATE_COMING"));
						t.setEarly_going(rs.getString("EARLY_GOING"));
						t.setUpdate_date(rs.getDate("UPDATED_DATE"));
						t.setMm(rs.getLong("MM"));
						t.setStatus(rs.getString("STATUS"));
						t.setLecount(rs.getInt("LECOUNT"));
						
						return t;
					}
				});
				return lateearlycount;
			}

			@Override
			public List<EmployeeStatus> getPendingForApprovalleaves(int empId, String date) {
				// TODO Auto-generated method stub
				
				String sql="";
				
				if(empId!=0) {
				      sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE \r\n" + 
						"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM\r\n" + 
						"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID AND lrl.EMP_ID = '"+empId+"' \r\n" + 
						"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or \r\n" + 
						"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY'))\r\n" + 
						"and lr.STATUS IN ('Pending for FR Approval','Pending for AR Approval','Pending for MG Approval')\r\n" + 
						"AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
				}else {
				      sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE \r\n" + 
								"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM\r\n" + 
								"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID  \r\n" + 
								"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or \r\n" + 
								"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY'))\r\n" + 
								"and lr.STATUS IN ('Pending for FR Approval','Pending for AR Approval','Pending for MG Approval')\r\n" + 
								"AND  lrl.LEAVE_TYPE = LT.L_NO order by lrl.LR_ID DESC";
				}
				
				 List<EmployeeStatus>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {				
						
	                	@Override
						public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		EmployeeStatus t = new EmployeeStatus();
	                		t.setEmpid(rs.getString("EMP_ID"));
	                		t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
	                		t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
	                		t.setStatus(rs.getString("STATUS"));
	                		t.setLeave_type(rs.getString("LEAVE_TYPE"));
	                		t.setStartDate(rs.getDate("START_DATE"));
	                		t.setEndDate(rs.getDate("END_DATE"));
	                		t.setDayType(rs.getString("DAY_TYPE"));
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<EmployeeStatus> getlwpleave(int empId, String date) {
				// TODO Auto-generated method stub
				String sql="";
				
				if(empId!=0) {
					      sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE \r\n" + 
							"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM\r\n" + 
							"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID AND lrl.EMP_ID = '"+empId+"' \r\n" + 
							"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or \r\n" + 
							"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY'))\r\n" + 
							"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (5)\r\n" + 
							"order by lrl.LR_ID DESC";
				}else {
				      sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE \r\n" + 
						"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM\r\n" + 
						"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID  \r\n" + 
						"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or \r\n" + 
						"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY'))\r\n" + 
						"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (5)\r\n" + 
						"order by lrl.LR_ID DESC";
				}
				
				 List<EmployeeStatus>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {				
						
	                	@Override
						public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		EmployeeStatus t = new EmployeeStatus();
	                		t.setEmpid(rs.getString("EMP_ID"));
	                		t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
	                		t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
	                		t.setStatus(rs.getString("STATUS"));
	                		t.setLeave_type(rs.getString("LEAVE_TYPE"));
	                		t.setStartDate(rs.getDate("START_DATE"));
	                		t.setEndDate(rs.getDate("END_DATE"));
	                		t.setDayType(rs.getString("DAY_TYPE"));
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<EmployeeStatus> getfreaquentleaves(int empId, String date) {
				// TODO Auto-generated method stub
				
				String sql="";
				
				if(empId!=0) {
				          sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,\r\n" + 
				          		"lrl.END_DATE,lrl.DAY_TYPE,lr.APPLICATION_DATE,lrl.LEAVE_COUNT,\r\n" + 
				          		"CASE WHEN lr.APPLICATION_DATE < lrl.START_DATE THEN 'PLANNED' \r\n" + 
				          		"ELSE 'UNPLANNED' END AS LEAVEFLAG\r\n" + 
				          		"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM \r\n" + 
				          		"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID AND EM.EMP_ID='"+empId+"'\r\n" + 
				          		"AND (to_char(lrl.START_DATE,'MON-YY') >= to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') AND \r\n" + 
				          		"to_char(lrl.END_DATE,'MON-YY') <= to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY')) \r\n" + 
				          		"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (1,2,5)\r\n" + 
				          		"order by lrl.LR_ID DESC";
				}else {
			          sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,\r\n" + 
			          		"lrl.END_DATE,lrl.DAY_TYPE,lr.APPLICATION_DATE,lrl.LEAVE_COUNT,\r\n" + 
			          		"CASE WHEN lr.APPLICATION_DATE < lrl.START_DATE THEN 'PLANNED' \r\n" + 
			          		"ELSE 'UNPLANNED' END AS LEAVEFLAG\r\n" + 
			          		"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM \r\n" + 
			          		"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID \r\n" + 
			          		"AND (to_char(lrl.START_DATE,'MON-YY') >= to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') AND \r\n" + 
			          		"to_char(lrl.END_DATE,'MON-YY') <= to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY')) \r\n" + 
			          		"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (1,2,5)\r\n" + 
			          		"order by lrl.LR_ID DESC";
				}
				
				 List<EmployeeStatus>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {				
						
	                	@Override
						public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		EmployeeStatus t = new EmployeeStatus();
	                		t.setEmpid(rs.getString("EMP_ID"));
	                		t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
	                		t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
	                		t.setStatus(rs.getString("STATUS"));
	                		t.setLeave_type(rs.getString("LEAVE_TYPE"));
	                		t.setStartDate(rs.getDate("START_DATE"));
	                		t.setEndDate(rs.getDate("END_DATE"));
	                		t.setDayType(rs.getString("DAY_TYPE"));
	                		t.setApplication_date(rs.getString("APPLICATION_DATE"));
	                		t.setLeavecount(rs.getFloat("LEAVE_COUNT"));
	                		t.setLeaveflag(rs.getString("LEAVEFLAG"));
	                		
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<Leave_creadit_report> getnotgetleaves(String leavetype, String date) {
				// TODO Auto-generated method stub
				
				String sql="SELECT EMP_ID,LEAVE_TYPE,LEAVE_CREDITED,UPDATED_DATE,CREATED_DATE FROM LEAVE_CREADIT_REPORT WHERE UPDATED_DATE='"+date+"' AND LEAVE_TYPE='"+leavetype+"'";
				
				 List<Leave_creadit_report>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<Leave_creadit_report>() {				
						
	                	@Override
						public Leave_creadit_report mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		Leave_creadit_report t = new Leave_creadit_report();
	                		t.setEmpid(rs.getInt("EMP_ID"));
	                		t.setLeavetype(rs.getString("LEAVE_TYPE"));
	                		t.setLeave_creadited(rs.getFloat("LEAVE_CREDITED"));
	                		t.setUpdated_date(rs.getString("UPDATED_DATE"));
	                		t.setCreated_date(rs.getDate("CREATED_DATE"));
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<Attendance_Regularazation> earlyAndLateTracking(String date, Integer valueOf) {
				// TODO Auto-generated method stub
				
				String sql="SELECT ATT.TOTAL_TIME,ATT.CATEGORIES FROM ATTENDANCE_REGULARIZATION ATT\r\n" + 
						"WHERE ATT.EMPLOYEE_ID='"+valueOf+"' AND TO_CHAR(ATT.CREATION_DATE,'YYYY-MM-DD')='"+date+"' and ATT.LEAVE_STATUS='Approved'";
				
				 List<Attendance_Regularazation>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<Attendance_Regularazation>() {				
						
	                	@Override
						public Attendance_Regularazation mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		Attendance_Regularazation t = new Attendance_Regularazation();
	                		t.setTotaltime(rs.getString("TOTAL_TIME"));
	                		t.setCatogary(rs.getString("CATEGORIES"));
	                		
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<EmployeeStatus> empstatus123(int empid) {
				// TODO Auto-generated method stub
				
				String sql="select lr.LR_ID from LEAVE_REQUEST lr, \r\n" + 
						"LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT WHERE lr.LR_ID = lrl.LR_ID AND \r\n" + 
						"lrl.EMP_ID ='"+empid+"' AND \r\n" + 
						"lrl.START_DATE <= to_char(TO_DATE('2023-12-10','YYYY-MM-DD'),'DD-MON-YY') AND\r\n" + 
						"lrl.END_DATE >= to_char(TO_DATE('2023-12-12','YYYY-MM-DD'),'dd-MON-YY') AND  lrl.LEAVE_TYPE = LT.L_NO";
				
				List<EmployeeStatus> attendanceList = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {

					@Override
					public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeStatus t = new EmployeeStatus();
						t.setStatus(rs.getString("LR_ID"));
						
						return t;
					}

				});
				return attendanceList;
			}

			@Override
			public List<EmployeeStatus> getwellplannedleave(int empId, String date) {
				// TODO Auto-generated method stub
                 String sql="";
				
				if(empId!=0) {
				          sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,\r\n" + 
				          		"lrl.END_DATE,lrl.DAY_TYPE,lr.APPLICATION_DATE,lrl.LEAVE_COUNT \r\n" + 
				          		"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM \r\n" + 
				          		"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID AND EM.EMP_ID='"+empId+"'\r\n" + 
				          		"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or  \r\n" + 
				          		"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY')) \r\n" + 
				          		"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (1,2,5)\r\n" + 
				          		"order by lrl.LR_ID DESC";
				}else {
			          sql="select EM.EMP_ID,EM.EMP_FIRST_NAME,EM.EMP_LAST_NAME,lr.STATUS,LT.LEAVE_TYPE,lrl.START_DATE,lrl.END_DATE,lrl.DAY_TYPE,lr.APPLICATION_DATE,lrl.LEAVE_COUNT \r\n" + 
								"from LEAVE_REQUEST lr, LEAVE_REQUEST_LINES lrl, LEAVE_TYPE LT,EMPLOYEE_MASTER EM\r\n" + 
								"WHERE lr.LR_ID = lrl.LR_ID AND EM.EMP_ID=lrl.EMP_ID \r\n" + 
								"AND (to_char(lrl.START_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY') or \r\n" + 
								"to_char(lrl.END_DATE,'MON-YY') = to_char(TO_DATE('"+date+"','YYYY-MM'),'MON-YY'))\r\n" + 
								"AND  lrl.LEAVE_TYPE = LT.L_NO AND lrl.LEAVE_TYPE IN (1,2,5)\r\n" + 
								"order by lrl.LR_ID DESC";
				}
				
				 List<EmployeeStatus>  lateearlycount = jdbcTemplate.query(sql, new RowMapper<EmployeeStatus>() {				
						
	                	@Override
						public EmployeeStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
	                		EmployeeStatus t = new EmployeeStatus();
	                		t.setEmpid(rs.getString("EMP_ID"));
	                		t.setEmp_first_name(rs.getString("EMP_FIRST_NAME"));
	                		t.setEmp_last_name(rs.getString("EMP_LAST_NAME"));
	                		t.setStatus(rs.getString("STATUS"));
	                		t.setLeave_type(rs.getString("LEAVE_TYPE"));
	                		t.setStartDate(rs.getDate("START_DATE"));
	                		t.setEndDate(rs.getDate("END_DATE"));
	                		t.setDayType(rs.getString("DAY_TYPE"));
							
							return t;
						}
					});
					return lateearlycount;
			}

			@Override
			public List<Tte_Lwp> getttelwp(String date) {
				// TODO Auto-generated method stub
				
				String sql="SELECT LEAVE_TYPE,LEAVE_STATUS,DAY_TYPE,TTE_DATE,EMP_ID\r\n" + 
						"FROM(SELECT CASE WHEN LEAVE_TYPE = 5 THEN 'LWP' ELSE 'OD' END AS LEAVE_TYPE \r\n" + 
						",CASE WHEN LEAVE_TYPE = 5 THEN 'Approved' ELSE 'Rejected' END AS LEAVE_STATUS, \r\n" + 
						"CASE WHEN LEAVE_TYPE = 5 THEN 'Full Day' ELSE 'HALF' END AS DAY_TYPE,TTE_LWP.TTE_DATE,TTE_LWP.EMP_ID\r\n" + 
						"FROM TTE_LWP WHERE IS_APPLICABLE='Y' AND TO_CHAR(TTE_DATE,'YYYY-MM')='"+date+"')";
				
				List<Tte_Lwp> attendanceList = jdbcTemplate.query(sql, new RowMapper<Tte_Lwp>() {

					@Override
					public Tte_Lwp mapRow(ResultSet rs, int rowNum) throws SQLException {
						Tte_Lwp t = new Tte_Lwp();
						t.setLeave_type(rs.getString("LEAVE_TYPE"));
						t.setLeave_status(rs.getString("LEAVE_STATUS"));
						t.setDay_type(rs.getString("DAY_TYPE"));
						t.setTte_date(rs.getDate("TTE_DATE"));
						t.setEmp_id(rs.getString("EMP_ID"));
						
						return t;
					}

				});
				return attendanceList;
			}
}
