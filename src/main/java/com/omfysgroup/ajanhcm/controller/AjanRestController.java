package com.omfysgroup.ajanhcm.controller;

import java.io.BufferedReader;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.internet.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.omfysgroup.ajanhcm.dao.LeavesDao;
import com.omfysgroup.ajanhcm.daoImpl.TrainingDaoImpl;
import com.omfysgroup.ajanhcm.model.AttendanceModule;
import com.omfysgroup.ajanhcm.model.AttendanceReport;
import com.omfysgroup.ajanhcm.model.Attendance_Module;
import com.omfysgroup.ajanhcm.model.Early_Late_Tracking;
import com.omfysgroup.ajanhcm.model.EmployeeMasterAttendance;
import com.omfysgroup.ajanhcm.model.EmployeeStatus;
import com.omfysgroup.ajanhcm.model.Employee_Joining_Details;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.ErrorInfo;
import com.omfysgroup.ajanhcm.model.Holidays_Setup;
import com.omfysgroup.ajanhcm.model.Joining_Details;
import com.omfysgroup.ajanhcm.model.LateEarlyDetails;
import com.omfysgroup.ajanhcm.model.LateEarlyEvents;
import com.omfysgroup.ajanhcm.model.Late_Early_Debited_Leaves;
import com.omfysgroup.ajanhcm.model.LeaveRequestLines;
import com.omfysgroup.ajanhcm.model.Leave_creadit_report;
import com.omfysgroup.ajanhcm.model.Rules_Documents;
import com.omfysgroup.ajanhcm.model.od_report_lwp;
import com.omfysgroup.ajanhcm.service.LeavesService;
import com.omfysgroup.ajanhcm.service.LoginService;
import com.omfysgroup.ajanhcm.service.TrainingService;
import com.omfysgroup.ajanhcm.utility.MailService;

import io.swagger.annotations.Api;

@Api(value = "", description = "REST APIs!!!!")
@RestController
//@RequestMapping("/api")
public class AjanRestController {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	com.omfysgroup.ajanhcm.dao.Attendance_dao Attendance_dao;

	
	@Autowired
	LeavesService leavesService;

	@Autowired
	TrainingService trainingService;

	@Autowired
	TrainingDaoImpl trainingDaoImpl;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	Environment environment;
	
	@Autowired
	LeavesDao leavesDao;
	
	
	@RequestMapping(value = "/downloadattendance1", method = RequestMethod.GET)
	public void downloadMonthlyAttendanceReport1(@RequestParam String month, @RequestParam int year, Model model,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, java.text.ParseException {
		// Get the number of days in that month

		YearMonth yearMonthObject = YearMonth.of(year, Integer.parseInt(month));
		int daysInMonth = yearMonthObject.lengthOfMonth();

		LocalDate firstOfMonth = yearMonthObject.atDay(1);
		String firstDate1 = String.valueOf(firstOfMonth);
		
		
	    String yearmonth=year+"-"+month;

		// LocalDate last = yearMonthObject.atEndOfMonth();

		List<EmployeeMasterAttendance> employees = Attendance_dao.empmaster();
		List<AttendanceModule> attendanceRecord = new ArrayList<AttendanceModule>();
		List<Joining_Details> joiningDetails = new ArrayList<Joining_Details>();
		List<LateEarlyEvents> sundaysCount = new ArrayList<LateEarlyEvents>();
		List<LateEarlyEvents> holidaysCount = new ArrayList<LateEarlyEvents>();
		List<Attendance_Module> attendance_module = new ArrayList<Attendance_Module>();
		List<EmployeeStatus> leaveStatus = new ArrayList<EmployeeStatus>();
		List<od_report_lwp> od_to_lwp_converted = new ArrayList<od_report_lwp>();
		List<Early_Late_Tracking> Att_regularization = new ArrayList<Early_Late_Tracking>();
		
		List<JSONObject> m = new ArrayList<JSONObject>();
		
		//get Attendance setting
		attendance_module = Attendance_dao.attendancesModule();
		
		//Attendance Regulirazation
		Att_regularization=Attendance_dao.att_reg(year + "-" + month);//d1
		
		ArrayList<Employee_Joining_Details> allEmployeeJoinigDetails = Attendance_dao.getAllEmployeeJoining();
		
		//Employee Records
		attendanceRecord = Attendance_dao.empdetails(year + "-" + month);//d1
		
		//Leave Details for all Employees
		leaveStatus=Attendance_dao.getLeaveDateForAllEmployee(year + "-" + month);

		//Od_report_lwp data od convert lwp 
		od_to_lwp_converted=Attendance_dao.getOdToLwpConverterAllEmployee(year+"-"+month);
		

		
		LocalDate localDate = null;
		java.time.DayOfWeek dayOfWeekInCell = null;
		for (int i = 1; i <= daysInMonth; i++) {

			// checking which day is today
			localDate = LocalDate.of(year, Integer.parseInt(month), i);
			dayOfWeekInCell = localDate.getDayOfWeek();

		}

		for (EmployeeMasterAttendance employeeMaster : employees) {
			// All Counts
			double presentDaysCount = 0;
			int plCount = 0;
			int clCount = 0;
			int lwpCount = 0;
			int odCount = 0;
			int sodCount = 0;
			int holidayCount = 0;

			double hdplCount = 0.0;
			double hdclCount = 0.0;
			double hdlwpCount = 0.0;
			double hdodCount = 0.0;
			int weeklyOffCounts = 0;
			double sundaysCount1 = 0;
			double weeklyCount1 = 0;
			String lecount="0";
			// All Counts
			int empId = 0;
			if (employeeMaster.getEmp_id() == null) {
				empId = 0;
			} else {
				empId = Integer.parseInt(employeeMaster.getEmp_id());
			}
			
			
			System.out.println("Employee id===>"+empId);

			//Late Coming / Early Going Leave deduction Count
			List<Late_Early_Debited_Leaves> leavedeductionforLE = Attendance_dao.empLECount(empId,yearmonth);
			
			if(leavedeductionforLE.get(0).getLwp() !=null) {
			lecount=leavedeductionforLE.get(0).getLwp();
			}
			
			//Joining Details Employee
			//joiningDetails = Attendance_dao.employeeJoiningDate(empId);
			
			
			
			//Date date1 = joiningDetails.get(0).getJoining_date();
			//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			//DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			//String joiningDate = dateFormat.format(date1);
			//String joiningDate1 = dateFormat1.format(date1);

			// Excell logic

			JSONObject t=new JSONObject();
			for (int j = 1; j <= daysInMonth; j++) {

				empId=0;
				if (employeeMaster.getEmp_id() == null) {
					empId = 0;
				} else {
					empId = Integer.parseInt(employeeMaster.getEmp_id());
				}

				// Get the current day
				String currentDate = String.valueOf(0);
				;
				for (int k = 1; k <= daysInMonth; k++) {
					if (j == k) {
						if (k > 9) {
							currentDate = String.valueOf(k);
						} else {
							currentDate = "0" + String.valueOf(k);
						}
						break;
					}
				}
				// Get the current day
				//String compareDate = year + "-" + month + "-" + currentDate;
				//d1
				SimpleDateFormat month_date = new SimpleDateFormat("MMM", Locale.ENGLISH);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String compareDate = year + "-" + month + "-" + currentDate;
				
				String actualDate = compareDate;
				Date date123 = sdf.parse(actualDate);
				String month_name = month_date.format(date123);				
				String compareDate1 = currentDate+"-"+month_name.toUpperCase()+"-"+compareDate.substring(2,4);
				
				 Optional<Employee_Joining_Details> jd = allEmployeeJoinigDetails.stream()
							.filter(p -> p.getEmp_id()==Integer.valueOf(employeeMaster.getEmp_id())
									&& p.getJoining_date1().substring(0,10).trim().compareTo(actualDate.trim())==0).findFirst();
				 if (jd.isPresent()) {
					 sundaysCount = Attendance_dao.sundaysCountHrMonth(firstDate1, jd.get().getJoining_date1().substring(0,10).trim());
					 sundaysCount1 = sundaysCount.get(0).getWeeklyPresentCount();
					 holidaysCount = Attendance_dao.holidayCountHRMonth(firstDate1, jd.get().getJoining_date1().substring(0,10).trim());
					 weeklyCount1 = holidaysCount.get(0).getHolidaysPresentCount();
				 }

				// checking which day is today
				LocalDate localDate1 = LocalDate.of(year, Integer.parseInt(month), Integer.parseInt(currentDate));
				java.time.DayOfWeek dayOfWeek = localDate1.getDayOfWeek();
				
				// checking which day is today
				//d1
				 Early_Late_Tracking elt=new Early_Late_Tracking();
				
				 List<Early_Late_Tracking> attendance = Att_regularization.stream()
						 .filter(p -> p.getEmployee_code().equals(String.valueOf(employeeMaster.getEmp_id()))
								 && (date123.equals(p.getStart_date())|| date123.equals(p.getEnd_date()))) .collect(Collectors.toList());
				 if (attendance.size() > 0) {
					 elt.setEmployee_code(attendance.get(0).getEmployee_code());
					 elt.setStart_date(attendance.get(0).getStart_date());
					 elt.setEnd_date(attendance.get(0).getEnd_date());
				 }
				
				
				 EmployeeStatus empStatus=new EmployeeStatus();
				 
				 //lambada expression for OD to lwp 
				 //here we are comparing start date and end date and emp id 
				 List<od_report_lwp> odtolwpconverted = od_to_lwp_converted.stream()
						 .filter(p -> p.getEmpId().equals(employeeMaster.getEmp_id())
								 && (date123.equals(p.getStart_date())|| date123.equals(p.getEnd_date()))) .collect(Collectors.toList());
				 if (odtolwpconverted.size() > 0) {
				 
					 empStatus.setStatus(odtolwpconverted.get(0).getStatus());
					 empStatus.setLeave_type(odtolwpconverted.get(0).getLeavetype());
					 empStatus.setEndDate(odtolwpconverted.get(0).getEnd_date());
					 empStatus.setStartDate(odtolwpconverted.get(0).getStart_date());
					 empStatus.setDayType(odtolwpconverted.get(0).getDay_type());
				 }
				 
				 //here we are matching leavesdata.
				 List<EmployeeStatus> leaveMatchingObject1 = leaveStatus .stream()
						 .filter(p -> p.getEmpid().equals(employeeMaster.getEmp_id())
								 && ((date123.after(p.getStartDate()) && date123.before(p.getEndDate())) ||
								 (date123.equals(p.getStartDate()) || date123.equals(p.getEndDate())))).collect(Collectors.toList());
				 
				 //if od to lwp data is not present then we are verifed leave date
				 if(odtolwpconverted.size() == 0) {
				 
				 if (leaveMatchingObject1.size() > 0) {
					 
					 if(leaveMatchingObject1.size()>1) {
						 EmployeeStatus e = leaveMatchingObject1.get(leaveMatchingObject1.size() - 1);
						 empStatus.setEmpid(e.getEmpid());
						 empStatus.setStatus(e.getStatus());
						 empStatus.setLeave_type(e.getLeave_type());
						 empStatus.setEndDate(e.getEndDate());
						 empStatus.setStartDate(e.getStartDate());
						 empStatus.setDayType(e.getDayType());
					 }else {
					 empStatus.setEmpid(leaveMatchingObject1.get(0).getEmpid());
					 empStatus.setStatus(leaveMatchingObject1.get(0).getStatus());
					 empStatus.setLeave_type(leaveMatchingObject1.get(0).getLeave_type());
					 empStatus.setEndDate(leaveMatchingObject1.get(0).getEndDate());
					 empStatus.setStartDate(leaveMatchingObject1.get(0).getStartDate());
					 empStatus.setDayType(leaveMatchingObject1.get(0).getDayType());
					 }
				    }
				}
				//
				 
				AttendanceReport att1 = new AttendanceReport();
				List<Holidays_Setup> holidays = Attendance_dao.getHolidayDetails(year + "-" + month + "-" + currentDate);
				
				if (dayOfWeek.toString().equals("SUNDAY")) {
					
					if (leaveMatchingObject1.size() > 0 || odtolwpconverted.size() > 0) {

						 if (!empStatus.getLeave_type().equalsIgnoreCase("OD")) {
						
						if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
							// newonnn
							if (empStatus.getDayType() != null) {
								att1.setStatus("Present with leave");
								if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										clCount = clCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										plCount = plCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										odCount = odCount + 1;
									} else {
										lwpCount = lwpCount + 1;
									}

								} else {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										hdclCount = hdclCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										hdplCount = hdplCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										hdodCount = hdodCount + 0.5;
									} else {
										hdlwpCount = hdlwpCount + 0.5;
									}
									presentDaysCount = presentDaysCount + 0.5;

								}
							}
							// newonnn

						} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
								|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
								|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {

							// newonnn
							if (empStatus.getDayType() != null) {
								att1.setStatus("Present with leave");
								if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {

									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										clCount = clCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										plCount = plCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										odCount = odCount + 1;
									} else {
										lwpCount = lwpCount + 1;
									}

								} else {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										hdclCount = hdclCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										hdplCount = hdplCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										hdodCount = hdodCount + 0.5;
									} else {
										hdlwpCount = hdlwpCount + 0.5;
									}
									presentDaysCount = presentDaysCount + 0.5;

								}
							}
						  }else if (empStatus.getStatus().equalsIgnoreCase("Rejected")) {
							  weeklyOffCounts = weeklyOffCounts + 1;
							} else if (empStatus.getStatus().equalsIgnoreCase("Cancelled")) {
								weeklyOffCounts = weeklyOffCounts + 1;
							}
						}else {
							weeklyOffCounts = weeklyOffCounts + 1;
						}
					}else {
						weeklyOffCounts = weeklyOffCounts + 1;
					}
				} else if (holidays.size() != 0) {

					// For Holiday entry
					if (leaveMatchingObject1.size() > 0 || odtolwpconverted.size() > 0 ) {

						if (!empStatus.getLeave_type().equalsIgnoreCase("OD")) {
						
						if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
							// newonnn
							if (empStatus.getDayType() != null) {
								att1.setStatus("Present with leave");
								if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										clCount = clCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										plCount = plCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										odCount = odCount + 1;
									} else {
										lwpCount = lwpCount + 1;
									}

								} else {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										hdclCount = hdclCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										hdplCount = hdplCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										hdodCount = hdodCount + 0.5;
									} else {
										hdlwpCount = hdlwpCount + 0.5;
									}
									presentDaysCount = presentDaysCount + 0.5;

								}
							}
							// newonnn

						} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
								|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
								|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {

							// newonnn
							if (empStatus.getDayType() != null) {
								att1.setStatus("Present with leave");
								if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {

									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										clCount = clCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										plCount = plCount + 1;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										odCount = odCount + 1;
									} else {
										lwpCount = lwpCount + 1;
									}

								} else {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										hdclCount = hdclCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										hdplCount = hdplCount + 0.5;
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										hdodCount = hdodCount + 0.5;
									} else {
										hdlwpCount = hdlwpCount + 0.5;
									}
									presentDaysCount = presentDaysCount + 0.5;
								}
							  }
							}else if (empStatus.getStatus().equalsIgnoreCase("Rejected")) {
								     holidayCount = holidayCount + 1;
								} else if (empStatus.getStatus().equalsIgnoreCase("Cancelled")) {
									holidayCount = holidayCount + 1;
								}
						}
						else {
							holidayCount = holidayCount + 1;
						}
					}else {
						holidayCount = holidayCount + 1;
					}

				} else {

					Optional<AttendanceModule> matchingObject = attendanceRecord.stream()
							.filter(p -> p.getEmployee_code().equals(employeeMaster.getEmp_code()) 
									&& p.getLogdate().compareTo(compareDate1.trim())==0).findFirst();
					
					if (matchingObject.isPresent()) {

						AttendanceModule attendanceModule = matchingObject.get();
						att1.setEmployee_code(attendanceModule.getEmployee_code());
						att1.setEmp_first_name(attendanceModule.getEmp_first_name());
						att1.setEmp_last_name(attendanceModule.getEmp_last_name());
						att1.setPanch_in(attendanceModule.getPanch_in());
						att1.setPanch_out(attendanceModule.getPanch_out());
						att1.setTotal_time(attendanceModule.getTotal_time());
						att1.setRemark(attendanceModule.getRemark());
						att1.setStatus_in(attendanceModule.getStatus_in() + "/" + attendanceModule.getStatus_out());
						att1.setStatus("Present");
						att1.setLeave_type(attendanceModule.getLeave_type());
						String t1 = "";
						if (attendanceModule.getTotal_time() != null) {
							t1 = attendanceModule.getTotal_time().substring(0, 2);
						}
						Integer totalTime = 0;
						try {
							if (attendanceModule.getTotal_time() != null) {
								totalTime = Integer.valueOf(t1);
							}
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
						}
						
						if(attendance.size() <= 0) {
						if (totalTime < attendance_module.get(0).getMin_con_present()) {
							
							att1.setStatus("Absent");

							if (leaveMatchingObject1.size() > 0 || odtolwpconverted.size() > 0) {

								if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
									// newonnn
									if (empStatus.getDayType() != null) {
										att1.setStatus("Present with leave");
										if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												clCount = clCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												plCount = plCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												odCount = odCount + 1;
											} else {
												lwpCount = lwpCount + 1;
											}

										} else {
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												hdclCount = hdclCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												hdplCount = hdplCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												hdodCount = hdodCount + 0.5;
											} else {
												hdlwpCount = hdlwpCount + 0.5;
											}
											presentDaysCount = presentDaysCount + 0.5;

										}
									}
									// newonnn

								} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
										|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
										|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {

									// newonnn
									if (empStatus.getDayType() != null) {
										att1.setStatus("Present with leave");
										if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {

											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												clCount = clCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												plCount = plCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												odCount = odCount + 1;
											} else {
												lwpCount = lwpCount + 1;
											}

										} else {
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												hdclCount = hdclCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												hdplCount = hdplCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												hdodCount = hdodCount + 0.5;
											} else {
												hdlwpCount = hdlwpCount + 0.5;
											}
											presentDaysCount = presentDaysCount + 0.5;

										}
									}
								}
							}
							//
						} else if (totalTime >= attendance_module.get(0).getMin_con_present()
								&& totalTime < attendance_module.get(0).getMin_con_half_day()) {
							att1.setStatus("Half Day Absent");

							if (leaveMatchingObject1.size() > 0 || odtolwpconverted.size() > 0) {
								if (empStatus.getStatus().equalsIgnoreCase("Approved")) {

									// newonnn
									if (empStatus.getDayType() != null) {
										att1.setStatus("Present with leave");

										if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {
											
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												clCount = clCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												plCount = plCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												odCount = odCount + 1;
											} else {
												lwpCount = lwpCount + 1;
											}

										} else {
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												hdclCount = hdclCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												hdplCount = hdplCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												hdodCount = hdodCount + 0.5;
											} else {
												hdlwpCount = hdlwpCount + 0.5;
											}
											presentDaysCount = presentDaysCount + 0.5;

										}
									}
									// newonnn

								} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
										|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
										|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
									// newonnn

									if (empStatus.getDayType() != null) {
										att1.setStatus("Present with leave");
										if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {

											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												clCount = clCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												plCount = plCount + 1;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												odCount = odCount + 1;
											} else {
												lwpCount = lwpCount + 1;
											}

										} else {
											if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
												hdclCount = hdclCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
												hdplCount = hdplCount + 0.5;
											} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
												hdodCount = hdodCount + 0.5;
											} else {
												hdlwpCount = hdlwpCount + 0.5;
											}
											presentDaysCount = presentDaysCount + 0.5;

										}
									}
								}
								// newonnn

							}
							//
						}
					}
						if (att1.getStatus().equalsIgnoreCase("Present")) {
							presentDaysCount = presentDaysCount + 1;	
						}
						
						if (att1.getStatus().equalsIgnoreCase("Absent")) {
						}
						
						if (att1.getStatus().equalsIgnoreCase("Half Day Absent")) {
							presentDaysCount = presentDaysCount + 0.5;
						}
						
					} else {
						if (empStatus == null) {

						} 
						if(leaveMatchingObject1.size() > 0 || odtolwpconverted.size() > 0) {

							if (empStatus.getStatus().equalsIgnoreCase("Approved")) {

								// newonnn
								if (empStatus.getDayType() != null) {
									
									if (empStatus.getDayType().equals("Full Day")) {
										if (empStatus.getLeave_type().equals("CL")) {
											clCount = clCount + 1;
										} else if (empStatus.getLeave_type().equals("PL")) {
											plCount = plCount + 1;
										} else if (empStatus.getLeave_type().equals("OD")) {
											odCount = odCount + 1;
										} else if (empStatus.getLeave_type().equals("SOD")) {
											sodCount = sodCount + 1;
										} else {
											lwpCount = lwpCount + 1;
										}

									} else {

										if (empStatus.getLeave_type().equals("CL")) {
											hdclCount = hdclCount + 0.5;
										} else if (empStatus.getLeave_type().equals("PL")) {
											hdplCount = hdplCount + 0.5;
										} else if (empStatus.getLeave_type().equals("OD")) {
											hdodCount = hdodCount + 0.5;
										} else {
											hdlwpCount = hdlwpCount + 0.5;
										}
									}
								}
								// newonnn

							} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
									|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
									|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
								// newonnn
								if (empStatus.getDayType() != null) {
									if (empStatus.getDayType().equals("Full Day")) {
										if (empStatus.getLeave_type().equals("CL")) {
											clCount = clCount + 1;
										} else if (empStatus.getLeave_type().equals("PL")) {
											plCount = plCount + 1;
										} else if (empStatus.getLeave_type().equals("OD")) {
											odCount = odCount + 1;
										} else {
											lwpCount = lwpCount + 1;
										}

									} else {

										if (empStatus.getLeave_type().equals("CL")) {
											hdclCount = hdclCount + 0.5;
										} else if (empStatus.getLeave_type().equals("PL")) {
											hdplCount = hdplCount + 0.5;
										} else if (empStatus.getLeave_type().equals("OD")) {
											hdodCount = hdodCount + 0.5;
										} else {
											hdlwpCount = hdlwpCount + 0.5;
										}
									}
								}
								// newonnn

							} else if (empStatus.getStatus().equalsIgnoreCase("Rejected")) {

							} else if (empStatus.getStatus().equalsIgnoreCase("Cancelled")) {

							}
						}else {
						}
						
					  }
				}

			}

			double totalLeaves = 0;
			double payableDays = 0;
			double presentDays = 0;
			double absentDays = 0;
			double notPaybleDays = sundaysCount1 + weeklyCount1+Double.valueOf(lecount);//LE LWP Count Added
			totalLeaves = clCount + plCount + odCount + sodCount + lwpCount + hdclCount + hdplCount + hdlwpCount
					+ hdodCount;// SOD ADD
			presentDays = presentDaysCount + clCount + plCount + odCount + sodCount + hdclCount + hdplCount + hdodCount
					+ weeklyOffCounts + holidayCount - notPaybleDays; // SOD ADDED
			absentDays = daysInMonth - presentDays;
			//LE Deduction
			
			payableDays = presentDaysCount + clCount + plCount + odCount + sodCount + hdclCount + hdplCount + hdodCount
					+ weeklyOffCounts + holidayCount - notPaybleDays; // SOD ADDED
			
			t.put("Employee Code", employeeMaster.getEmp_code());
			t.put("employee_name", employeeMaster.getEmp_first_name()+" "+employeeMaster.getEmp_last_name());
			t.put("payableDays", payableDays);
			
			m.add(t);
		}
		
		 if (m != null) {
		      String json = null;
		      json = (new Gson()).toJson(m);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    }

	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public void test1(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value = "startDate") String startdate,@RequestParam(value = "endDate") String endDate
			,@RequestParam(value = "leavetype") String leavetype) throws IOException  {
		
		
		 ArrayList<Object> list=new ArrayList<Object>(); 
		 
		 //ArrayList<Hr_Rules> st=(ArrayList<Hr_Rules>) leaveDao.getHrRules();
		 
		 List<Rules_Documents> dml = leavesService.getRulesDocument(1);
		 
			
			try  
			{  
				 
				 ByteArrayInputStream bin = new ByteArrayInputStream(dml.get(0).getDocument());

				
			//File file = new File("D:\\Minds Connect-Santosh\\SVN Updated Codes\\MINDSCONNECT\\src\\main\\resources\\HR Rules.xlsx");   //creating a new file instance  
			//FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(bin);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			
			 DataFormatter dataFormatter = new DataFormatter(new java.util.Locale("en", "US"));
			  // from 5.2.0 on the DataFormatter can set to use cached values for formula cells			
			 
			while (itr.hasNext())                 
			{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
			Cell cell = cellIterator.next(); 
			
			String value = dataFormatter.formatCellValue(cell); // from apache poi 5.2.0 on 
			System.out.println(value);
			list.add(value);    
			}
			System.out.println("");  
			}  
			}  
			catch(Exception e)  
			{  
			e.printStackTrace();  
			}
		
		    String prior_days_pl=list.get(1).toString();
		    
		    String prior_days_cl=list.get(3).toString();
		    
		    String prior_days_lwp=list.get(5).toString();
		    
		    String prior_days_od=list.get(7).toString();
		    
		    String prior_days_sod=list.get(9).toString();
		    
		    String prefixWeek=list.get(11).toString();
		    
		    String suffixweek=list.get(13).toString();
		    
		    String suffixHoliday=list.get(15).toString();
		    
		    String prefixHoliday=list.get(17).toString();
		    
		    String between_holiday=list.get(19).toString();
		    
		    String between_sunday=list.get(21).toString();
		    
		    String leave_combination=list.get(23).toString();
		    
		    String list_of_holidays=list.get(27).toString();
		    
			
		 String line="";
		 String res="";
        try {
    		URL url = new URL("http://140.238.162.129:4040/kie-server/services/rest/server/containers/instances/doo_1.0.0-SNAPSHOT");

    		String postData="{\r\n" + 
    				"    \"lookups\":null,\r\n" + 
    				"    \"commands\":[\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"         {\r\n" + 
    				"            \r\n" + 
    				"        \"insert\": {\r\n" + 
    				"            \"out-identifier\":\"LeaveSetting\",\r\n" + 
    				"            \"object\":{\r\n" + 
    				"                \"com.kie_pract.doo.foo\":{\r\n" + 
    				"                    \r\n" + 
    				"                    \"leaveStartDate\":\""+startdate+"\",\r\n" + 
    				"                    \"leaveEndDate\":\""+endDate+"\",\r\n" + 
    				"                    \"priorDaysPL\":"+prior_days_pl+",\r\n" + 
    				"                    \"priorDaysCL\":"+prior_days_cl+",\r\n" + 
    				"                    \"priorDaysLWP\":"+prior_days_lwp+",\r\n" + 
    				"                    \"priorDaysOD\":"+prior_days_od+",\r\n" + 
    				"                    \"priorDaysSOD\":"+prior_days_sod+",\r\n" + 
    				"                    \"leaveType\": \""+leavetype+"\",\r\n" + 
    				"                    \"suffixWeek\":"+suffixweek+",\r\n" + 
    				"                    \"suffixHoliday\":"+suffixHoliday+",\r\n" + 
    				"                    \"prefixHoliday\":"+prefixHoliday+",\r\n" + 
    				"                    \"prefixweek\":"+prefixWeek+",\r\n" + 
    				"                    \"betweenHoliday\" :"+between_holiday+",\r\n" +
    				"                    \"betweenSunday\" :"+between_sunday+",\r\n" +
    				"                    \"listOfHolidays\":["+list_of_holidays+"]\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				" \r\n" + 
    				"                }\r\n" + 
    				"                \r\n" + 
    				"            },\r\n" + 
    				"           \r\n" + 
    				"            \"disconnected\":true,\r\n" + 
    				"            \"return-object\":true,\r\n" + 
    				"            \"entry-point\":\"DEFAULT\"\r\n" + 
    				" \r\n" + 
    				"        }\r\n" + 
    				"        }, \r\n" + 
    				" \r\n" + 
    				"   \r\n" + 
    				" \r\n" + 
    				"    {\r\n" + 
    				"        \"fire-all-rules\":\"\"\r\n" + 
    				"    }\r\n" + 
    				"    ]\r\n" + 
    				"}\r\n" + 
    				" \r\n" + 
    				"";
    		
    		
    		
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Basic d2JhZG1pbjp3YmFkbWlu");
    		conn.setRequestProperty("Content-Type", "application/json");
 
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }
 
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                                                conn.getInputStream())))
            {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    res+=line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JSONObject parent=new JSONObject();
        parent.put("values", res);
        
        
        String json = res;
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        
        int i=0;
        Map<String, Object> map3 = new HashMap<String, Object>();
        
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            i++;
            if(i==3) {
            	map3.put(entry.getKey(), entry.getValue());
            }
    }
        
        String s=map3.toString();
        
        String arr[]=s.split(",");
        
        
        String massage="";
        
        String leaveCount="";
        
        String reset="";
        
        		
        for(int j=0;j<arr.length;j++) {
        
        	if(arr[j].trim().startsWith("message")) {
        		massage=(arr[j]);
        	}
        	
        	if(arr[j].trim().startsWith("leaveCount")) {
        		leaveCount=(arr[j]);
        	}
        	
        	if(arr[j].trim().startsWith("reset")) {
        		reset=(arr[j]);
        	}
        	
        }
        	
        	//massage	
          String massageonly= massage.substring(0,8);
          
          String mass= massage.substring(9);
          
          System.out.println("Massage=====>"+mass);
          //leaveCount
          String noofleave=leaveCount.substring(12, leaveCount.length()-0);
         
          String resetflag=reset.substring(7, reset.length()-0);
         
          JSONObject massage1=new JSONObject();
          massage1.put("massage", mass);
          massage1.put("noofleaves",noofleave.trim());
          massage1.put("resetflag", resetflag.trim());
          
          String json2 = null;
	      json2 = (new Gson()).toJson(massage1);
	      response.setContentType("application/json");
	      response.getWriter().write(json2);
        
	}
	
	@RequestMapping(value = "/leavenotappliyed", method = RequestMethod.GET)
	public void leaverulesapplicable(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value = "startDate") String startdate,@RequestParam(value = "empid") String empid
			,@RequestParam(value = "leavetype") String leavetype) throws IOException, java.text.ParseException  {
		
		 String sDate1=startdate;  
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  String date = startdate;
		  //convert String to LocalDate
		  LocalDate localDate = LocalDate.parse(date, formatter);
		  
		 localDate.minusDays(1);
		 
		
		 ArrayList<Object> list=new ArrayList<Object>(); 
		 
		 //ArrayList<Hr_Rules> st=(ArrayList<Hr_Rules>) leaveDao.getHrRules();
		 
		 List<Rules_Documents> dml = leavesService.getRulesDocument(1);
		 
			try  
			{  
				 
				 ByteArrayInputStream bin = new ByteArrayInputStream(dml.get(0).getDocument());
				
			//File file = new File("D:\\Minds Connect-Santosh\\SVN Updated Codes\\MINDSCONNECT\\src\\main\\resources\\HR Rules.xlsx");   //creating a new file instance  
			//FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(bin);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			
			 DataFormatter dataFormatter = new DataFormatter(new java.util.Locale("en", "US"));
			  // from 5.2.0 on the DataFormatter can set to use cached values for formula cells			
			 
			while (itr.hasNext())                 
			{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
			Cell cell = cellIterator.next(); 
			
			String value = dataFormatter.formatCellValue(cell); // from apache poi 5.2.0 on 
			System.out.println(value);
			list.add(value);    
			}
			System.out.println("");  
			}  
			}  
			catch(Exception e)  
			{  
			e.printStackTrace();  
			}
		
		    String prior_days_pl=list.get(1).toString();
		    
		    String prior_days_cl=list.get(3).toString();
		    
		    String prior_days_lwp=list.get(5).toString();
		    
		    String prior_days_od=list.get(7).toString();
		    
		    String prior_days_sod=list.get(9).toString();
		    
		    
		    String prefixWeek=list.get(11).toString();
		    
		    String suffixweek=list.get(13).toString();
		    
		    String suffixHoliday=list.get(15).toString();
		    
		    String prefixHoliday=list.get(17).toString();
		    
		    String between_holiday=list.get(19).toString();
		    
		    String between_sunday=list.get(21).toString();
		    
		    String pl_with_Lwp=list.get(23).toString();
		    
		    String Cl_with_Lwp=list.get(25).toString();
		    
		    String list_of_holidays=list.get(27).toString().trim();

		    int empId=Integer.valueOf(empid);
		    
		    List<EmployeeStatus> status = new ArrayList<EmployeeStatus>();

		    status=leavesDao.GetLeaveDetails(localDate.minusDays(1), empId,leavetype,pl_with_Lwp,Cl_with_Lwp);

		    System.out.println("leaveCombination============>"+pl_with_Lwp);
		    
		    boolean flag=false;
		    
		    if(status.size()!=0) {
		    	flag=true;
		    }
		    
		      String json2 = null;
		      json2 = (new Gson()).toJson(flag);
		      response.setContentType("application/json");
		      response.getWriter().write(json2);
	}
	
	@RequestMapping(value = "/biomaxattendance", method = RequestMethod.GET)
	public void test1(HttpServletRequest request,HttpServletResponse response) throws IOException  {

		   String enddate="";
		
		  LocalDate firstDayOfThisYear = Year.now(ZoneId.systemDefault()).atDay(1);
		    System.out.println("First date in month=====>"+firstDayOfThisYear);
		    
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

				Date today = new Date();
				enddate = simpleDateFormat.format(today);
				
				System.out.println("end date"+enddate);
		
		
		List<AttendanceModule> attendanceRecord = Attendance_dao.getbiomaxattendance(firstDayOfThisYear,enddate);
		
		    String json2 = null;
	      json2 = (new Gson()).toJson(attendanceRecord);
	      response.setContentType("application/json");
	      response.getWriter().write(json2);
	}
	
	@RequestMapping(value = "/empattendancedetailsforhr",method = RequestMethod.GET)
	public void attendanceReports1(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException, ParseException, java.text.ParseException {
		
		String date = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (request.getParameter("date") != null) {
			date = request.getParameter("date");
		} else {
			Date today = new Date();
			date = simpleDateFormat.format(today);

		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String actualDate = date;
		Date date123 = sdf.parse(actualDate);
		
		List<EmployeeMasterAttendance> employees = Attendance_dao.empmaster();
		List<AttendanceModule> attendanceRecord = Attendance_dao.details(date);
		List<EmployeeStatus> status = new ArrayList<EmployeeStatus>();
		List<AttendanceReport> attendanceReports = new ArrayList<AttendanceReport>();
		List<Attendance_Module> attendance_module = new ArrayList<Attendance_Module>();
		attendance_module = Attendance_dao.attendancesModule();

		// All Counts

		List<Integer> presentEmployeeCount = new ArrayList<Integer>();
		int presentCount = 0;
		List<Integer> absentEmployeesCount = new ArrayList<Integer>();
		int absentCount = 0;
		List<Double> plEmployeesCount = new ArrayList<Double>();
		double plCount = 0;
		List<Double> clEmployeesCount = new ArrayList<Double>();
		double clCount = 0;
		List<Double> lwpEmployeesCount = new ArrayList<Double>();
		double lwpCount = 0;
		List<Double> odEmployeesCount = new ArrayList<Double>();
		double odCount = 0;
		List<Double> approvedEmployeesCount = new ArrayList<Double>();
		double approvedCount = 0;
		List<Double> pendingtEmployeesCount = new ArrayList<Double>();
		double pendingCount = 0;
		List<Double> rejectEmployeesCount = new ArrayList<Double>();
		double rejectedCount = 0;
		List<Double> approvedPLEmployeesCount = new ArrayList<Double>();
		double approvedPLCount = 0;
		List<Double> approvedCLEmployeesCount = new ArrayList<Double>();
		double approvedCLCount = 0;
		List<Double> approvedODEmployeesCount = new ArrayList<Double>();
		double approvedODCount = 0;
		List<Double> approvedLWPEmployeesCount = new ArrayList<Double>();
		double approvedLWPCount = 0;

		// santosh add code 30/dec
		List<Integer> pendingPLArEmployeeCount = new ArrayList<Integer>();
		int pendingPLArCount = 0;
		List<Integer> pendingPLMgEmployeeCount = new ArrayList<Integer>();
		int pendingPLMgCount = 0;
		List<Integer> pendingPLFrEmployeeCount = new ArrayList<Integer>();
		int pendingPLFrCount = 0;

		List<Integer> pendingCLArEmployeeCount = new ArrayList<Integer>();
		int pendingCLArCount = 0;
		List<Integer> pendingCLMgEmployeeCount = new ArrayList<Integer>();
		int pendingCLMgCount = 0;
		List<Integer> pendingCLFrEmployeeCount = new ArrayList<Integer>();
		int pendingCLFrCount = 0;

		List<Integer> pendingODArEmployeeCount = new ArrayList<Integer>();
		int pendingODArCount = 0;
		List<Integer> pendingODMgEmployeeCount = new ArrayList<Integer>();
		int pendingODMgCount = 0;
		List<Integer> pendingODFrEmployeeCount = new ArrayList<Integer>();
		int pendingODFrCount = 0;

		List<Integer> pendingLWPArEmployeeCount = new ArrayList<Integer>();
		int pendingLWPArCount = 0;
		List<Integer> pendingLWPMgEmployeeCount = new ArrayList<Integer>();
		int pendingLWPMgCount = 0;
		List<Integer> pendingLWPFrEmployeeCount = new ArrayList<Integer>();
		int pendingLWPFrCount = 0;

		//

		List<Integer> rejectedPLEmployeesCount = new ArrayList<Integer>();
		int rejectedPLCount = 0;
		List<Integer> rejectedCLEmployeesCount = new ArrayList<Integer>();
		int rejectedCLCount = 0;
		List<Integer> rejectedODEmployeesCount = new ArrayList<Integer>();
		int rejectedODCount = 0;
		List<Integer> rejectedLWPEmployeesCount = new ArrayList<Integer>();
		int rejectedLWPCount = 0;

		// All Counts
		
		status=Attendance_dao.getLeavedetails(date);

		for (EmployeeMasterAttendance employeeMaster : employees) {
			// System.out.println("Emp MAster==>"+employeeMaster.getEmp_id());
			int empId = 0;
			if (employeeMaster.getEmp_id() == null) {
				empId = 0;
			} else {
				empId = Integer.parseInt(employeeMaster.getEmp_id());
			}
			AttendanceReport att1 = new AttendanceReport();
			
			//
			EmployeeStatus empStatus = new EmployeeStatus();
			
			 List<EmployeeStatus> leaveMatchingObject1 = status .stream()
					 .filter(p -> p.getEmpid().equals(employeeMaster.getEmp_id())
							 && ((date123.after(p.getStartDate()) && date123.before(p.getEndDate())) ||
							 (date123.equals(p.getStartDate()) || date123.equals(p.getEndDate())))).collect(Collectors.toList());
			 
			 //if od to lwp data is not present then we are verifed leave date
			 if (leaveMatchingObject1.size() > 0) {
				 
				 if(leaveMatchingObject1.size()>1) {
					 EmployeeStatus e = leaveMatchingObject1.get(leaveMatchingObject1.size() - 1);
					 empStatus.setEmpid(e.getEmpid());
					 empStatus.setStatus(e.getStatus());
					 empStatus.setLeave_type(e.getLeave_type());
					 empStatus.setEndDate(e.getEndDate());
					 empStatus.setStartDate(e.getStartDate());
					 empStatus.setDayType(e.getDayType());
				 }else {
				 empStatus.setEmpid(leaveMatchingObject1.get(0).getEmpid());
				 empStatus.setStatus(leaveMatchingObject1.get(0).getStatus());
				 empStatus.setLeave_type(leaveMatchingObject1.get(0).getLeave_type());
				 empStatus.setEndDate(leaveMatchingObject1.get(0).getEndDate());
				 empStatus.setStartDate(leaveMatchingObject1.get(0).getStartDate());
				 empStatus.setDayType(leaveMatchingObject1.get(0).getDayType());
				 }
			    }
			
			//

			Optional<AttendanceModule> matchingObject = attendanceRecord.stream()
					.filter(p -> p.getEmployee_code().equals(employeeMaster.getEmp_code())).findFirst();
			if (matchingObject.isPresent()) {

				AttendanceModule attendanceModule = matchingObject.get();
				att1.setEmployee_code(attendanceModule.getEmployee_code());
				att1.setEmp_first_name(attendanceModule.getEmp_first_name());
				att1.setEmp_last_name(attendanceModule.getEmp_last_name());
				att1.setLogdate(attendanceModule.getLogdate().substring(0, 10));
				att1.setPanch_in(attendanceModule.getPanch_in());
				att1.setPanch_out(attendanceModule.getPanch_out());
				att1.setTotal_time(attendanceModule.getTotal_time());
				att1.setRemark(attendanceModule.getRemark());
				att1.setStatus_in(attendanceModule.getStatus_in() + "/" + attendanceModule.getStatus_out());
				att1.setStatus("Present");
				att1.setLeave_type(attendanceModule.getLeave_type());
				String t1 = "";
				if (attendanceModule.getTotal_time() != null) {
					t1 = attendanceModule.getTotal_time().substring(0, 2);
				}
				Integer totalTime = 0;
				try {
					if (attendanceModule.getTotal_time() != null) {
						totalTime = Integer.valueOf(t1);
					}
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				if (totalTime < attendance_module.get(0).getMin_con_present()) {
					if (leaveMatchingObject1.size() > 0) {
						if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
							att1.setStatus(empStatus.getLeave_type());
							// newonnn
							if (empStatus.getDayType() != null) {
								if (empStatus.getDayType().equals("Full Day")) {

									if (empStatus.getLeave_type().equals("CL")) {
										att1.setStatus("Leave with CL");
										approvedCLCount = approvedCLCount + 1;
										approvedCLEmployeesCount.add(approvedCLCount);
									} else if (empStatus.getLeave_type().equals("PL")) {
										att1.setStatus("Leave with PL");
										approvedPLCount = approvedPLCount + 1;
										approvedPLEmployeesCount.add(approvedPLCount);
									} else if (empStatus.getLeave_type().equals("OD")) {
										att1.setStatus("Present with OD");
										approvedODCount = approvedODCount + 1;
										approvedODEmployeesCount.add(approvedODCount);
									} else if (empStatus.getLeave_type().equals("LWP")) {
										att1.setStatus("Leave without pay");
										approvedLWPCount = approvedLWPCount + 1;
										approvedLWPEmployeesCount.add(approvedLWPCount);
									} else {
										absentCount = absentCount + 1;
										absentEmployeesCount.add(absentCount);
									}
								} else {
									if (empStatus.getLeave_type().equals("CL")) {
										att1.setStatus("HDCL");
										approvedCLCount = approvedCLCount + 0.5;
										approvedCLEmployeesCount.add(approvedCLCount);
									} else if (empStatus.getLeave_type().equals("PL")) {
										att1.setStatus("HDPL");
										approvedPLCount = approvedPLCount + 0.5;
										approvedPLEmployeesCount.add(approvedPLCount);
									} else if (empStatus.getLeave_type().equals("OD")) {
										att1.setStatus("HDOD");
										approvedODCount = approvedODCount + 0.5;
										approvedODEmployeesCount.add(approvedODCount);
									} else {
										att1.setStatus("HDLWP");
										approvedLWPCount = approvedLWPCount + 0.5;
										approvedLWPEmployeesCount.add(approvedLWPCount);
									}
									att1.setStatus("HDP");
								}
							}
							// newonnn
						}
					}
				} else if (totalTime >= attendance_module.get(0).getMin_con_present()
						&& totalTime < attendance_module.get(0).getMin_con_half_day()) {
					if (leaveMatchingObject1.size() > 0) {
						if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
							att1.setStatus(status.get(0).getLeave_type());
							// newonnn
							if (empStatus.getDayType() != null) {
								if (empStatus.getDayType().equalsIgnoreCase("Full Day")) {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										att1.setStatus("Leave with CL");
										approvedCLCount = approvedCLCount + 1;
										approvedCLEmployeesCount.add(approvedCLCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										att1.setStatus("Leave with PL");
										approvedPLCount = approvedPLCount + 1;
										approvedPLEmployeesCount.add(approvedPLCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										att1.setStatus("Present with OD");
										approvedODCount = approvedODCount + 1;
										approvedODEmployeesCount.add(approvedODCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")) {
										att1.setStatus("Leave without pay");
										approvedLWPCount = approvedLWPCount + 1;
										approvedLWPEmployeesCount.add(approvedLWPCount);
									}
								} else {
									if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
										att1.setStatus("HDCL");
										approvedCLCount = approvedCLCount + 0.5;
										approvedCLEmployeesCount.add(approvedCLCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
										att1.setStatus("HDPL");
										approvedPLCount = approvedPLCount + 0.5;
										approvedPLEmployeesCount.add(approvedPLCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")) {
										att1.setStatus("HDP Present");
										approvedODCount = approvedODCount + 0.5;
										approvedODEmployeesCount.add(approvedODCount);
									} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")) {
										att1.setStatus("HDLWP");
										approvedLWPCount = approvedLWPCount + 0.5;
										approvedLWPEmployeesCount.add(approvedLWPCount);
									}
								}
							}
							// newonnn
						}
					}
				}
				if (att1.getStatus().equalsIgnoreCase("Present")) {
					presentCount = presentCount + 1;
					presentEmployeeCount.add(presentCount);
				}

				attendanceReports.add(att1);
			} else {
				att1.setEmployee_code(employeeMaster.getEmp_code());
				att1.setEmp_first_name(employeeMaster.getEmp_first_name());
				att1.setEmp_last_name(employeeMaster.getEmp_last_name());
				att1.setLogdate("");
				att1.setPanch_in("");
				att1.setPanch_out("");
				att1.setTotal_time("");
				att1.setRemark("");

				if (leaveMatchingObject1.size() > 0) {
					
					if (empStatus.getLeave_type().equalsIgnoreCase("PL")) {
						plCount = plCount + 1;
						plEmployeesCount.add(plCount);
						if (empStatus.getLeave_type().equalsIgnoreCase("PL")
								&& status.get(0).getStatus().equalsIgnoreCase("Approved")) {
							approvedPLCount = approvedPLCount + 1;
							approvedPLEmployeesCount.add(approvedPLCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")
								&& status.get(0).getStatus().equalsIgnoreCase("Rejected")) {
							rejectedPLCount = rejectedPLCount + 1;
							rejectedPLEmployeesCount.add(rejectedPLCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")) {
							pendingPLArCount = pendingPLArCount + 1;
							pendingPLArEmployeeCount.add(pendingPLArCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")) {
							pendingPLFrCount = pendingPLFrCount + 1;
							pendingPLFrEmployeeCount.add(pendingPLFrCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("PL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
							pendingPLMgCount = pendingPLMgCount + 1;
							pendingPLMgEmployeeCount.add(pendingPLMgCount);
						}

					} else if (empStatus.getLeave_type().equalsIgnoreCase("CL")) {
						clCount = clCount + 1;
						clEmployeesCount.add(clCount);
						if (empStatus.getLeave_type().equalsIgnoreCase("CL")
								&& status.get(0).getStatus().equalsIgnoreCase("Approved")) {
							approvedCLCount = approvedCLCount + 1;
							approvedCLEmployeesCount.add(approvedCLCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("CL")
								&& empStatus.getStatus().equalsIgnoreCase("Rejected")) {
							rejectedCLCount = rejectedCLCount + 1;
							rejectedCLEmployeesCount.add(rejectedCLCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("CL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")) {
							pendingCLArCount = pendingCLArCount + 1;
							pendingCLArEmployeeCount.add(pendingCLArCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("CL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")) {
							pendingCLFrCount = pendingCLFrCount + 1;
							pendingCLFrEmployeeCount.add(pendingCLFrCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("CL")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
							pendingCLMgCount = pendingCLMgCount + 1;
							pendingCLMgEmployeeCount.add(pendingCLMgCount);
						}

					} else if (empStatus.getLeave_type().equalsIgnoreCase("OD") || empStatus.getLeave_type().equalsIgnoreCase("SOD")) {
						odCount = odCount + 1;
						odEmployeesCount.add(odCount);
						if (empStatus.getLeave_type().equalsIgnoreCase("OD")
								&& empStatus.getStatus().equalsIgnoreCase("Approved")) {
							approvedODCount = approvedODCount + 1;
							approvedODEmployeesCount.add(approvedODCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")
								&& empStatus.getStatus().equalsIgnoreCase("Rejected")) {
							rejectedODCount = rejectedODCount + 1;
							rejectedODEmployeesCount.add(rejectedODCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")) {
							pendingODArCount = pendingODArCount + 1;
							pendingODArEmployeeCount.add(pendingODArCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")) {
							pendingODFrCount = pendingODFrCount + 1;
							pendingODFrEmployeeCount.add(pendingODFrCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("OD")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
							pendingODMgCount = pendingODMgCount + 1;
							pendingODMgEmployeeCount.add(pendingODMgCount);
						}

					} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")) {
						lwpCount = lwpCount + 1;
						lwpEmployeesCount.add(lwpCount);
						if (empStatus.getLeave_type().equalsIgnoreCase("LWP")
								&& empStatus.getStatus().equalsIgnoreCase("Approved")) {
							approvedLWPCount = approvedLWPCount + 1;
							approvedLWPEmployeesCount.add(approvedLWPCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")
								&& empStatus.getStatus().equalsIgnoreCase("Rejected")) {
							rejectedLWPCount = rejectedLWPCount + 1;
							rejectedLWPEmployeesCount.add(rejectedLWPCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")) {
							pendingLWPArCount = pendingLWPArCount + 1;
							pendingLWPArEmployeeCount.add(pendingLWPArCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")) {
							pendingLWPFrCount = pendingLWPFrCount + 1;
							pendingLWPFrEmployeeCount.add(pendingLWPFrCount);
						} else if (empStatus.getLeave_type().equalsIgnoreCase("LWP")
								&& empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
							pendingLWPMgCount = pendingLWPMgCount + 1;
							pendingLWPMgEmployeeCount.add(pendingODMgCount);
						}

					} else if (empStatus.getStatus().equalsIgnoreCase("Approved")) {
						approvedCount = approvedCount + 1;
						approvedEmployeesCount.add(approvedCount);
					} else if (empStatus.getStatus().equalsIgnoreCase("Pending For AR Approval")
							|| empStatus.getStatus().equalsIgnoreCase("Pending For FR Approval")
							|| empStatus.getStatus().equalsIgnoreCase("Pending For MG Approval")) {
						pendingCount = pendingCount + 1;
						pendingtEmployeesCount.add(pendingCount);

					} else if (empStatus.getStatus().equalsIgnoreCase("Rejected")) {
						rejectedCount = rejectedCount + 1;
						rejectEmployeesCount.add(rejectedCount);
					}
					att1.setStatus(empStatus.getStatus());

				}else {
					att1.setStatus("Absent");
					absentCount = absentCount + 1;
					absentEmployeesCount.add(absentCount);
				}
				attendanceReports.add(att1);
			}

		}

		int totalAR = pendingPLArEmployeeCount.size() + pendingCLArEmployeeCount.size()
				+ pendingODArEmployeeCount.size() + pendingLWPArEmployeeCount.size();


		int totalFR = pendingPLFrEmployeeCount.size() + pendingCLFrEmployeeCount.size()
				+ pendingODFrEmployeeCount.size() + pendingLWPFrEmployeeCount.size();
		System.out.println(totalFR);


		int totalMG = pendingPLMgEmployeeCount.size() + pendingCLMgEmployeeCount.size()
				+ pendingODMgEmployeeCount.size() + pendingLWPMgEmployeeCount.size();


		// Applied column
		float totalApplied = plEmployeesCount.size() + clEmployeesCount.size(); 
		//+ odEmployeesCount.size()+ lwpEmployeesCount.size();
		// Approved PL
		int totalApproved = approvedPLEmployeesCount.size() + approvedCLEmployeesCount.size()
				+ approvedODEmployeesCount.size() + approvedLWPEmployeesCount.size();

		int totalRejected = rejectedPLEmployeesCount.size() + rejectedCLEmployeesCount.size()
				+ rejectedLWPEmployeesCount.size();
		
		// Total PL Count Row
		float totalPL = plEmployeesCount.size();
		
		// Total Cl count row
		float totalCl = clEmployeesCount.size();
		
		// Total OD Count row
		float totalOD = odEmployeesCount.size();
		
		// Total LWP Count Row
		float totalLWP = lwpEmployeesCount.size();

		// Total All Row Count
		float totalleave = totalPL + totalCl;

	    float totalAll = absentEmployeesCount.size() + attendanceRecord.size()+totalleave+totalOD+totalLWP;

	    float present =  presentEmployeeCount.size();
 
   	    float absent= absentEmployeesCount.size()+totalLWP;
   	    
   	    DecimalFormat df = new DecimalFormat();
   	    df.setMaximumFractionDigits(2);
   	   //System.out.println(df.format(decimalNumber));
   		
   		String presentper =  df.format(((present/totalAll)*100));
   		
   		String absentper =  df.format(((absent/totalAll)*100));
   		
   		String totalleavespre =  df.format(((totalApplied/totalAll)*100));
   		
   		System.out.println("TotalLeavesper"+totalleavespre);
   		
   		String od=df.format(totalOD);
   		
   		String totalodper=df.format(((totalOD/totalAll)*100));

   		JSONObject parent=new JSONObject();
		parent.put("totalAll",totalAll);
		parent.put("present",present);
		parent.put("absent",absent);
		parent.put("presentper",presentper);
		parent.put("absentper",absentper);
		parent.put("totalleaves",totalApplied);
		parent.put("totalleavespre",totalleavespre);
		parent.put("totalOd",od);
		parent.put("totalodper",totalodper);
		
		  String json = null;
	      json = (new Gson()).toJson(parent);
	      response.setContentType("application/json");
	      response.getWriter().write(json);
	}
	
	@RequestMapping(value = "/isleaveexist1", method = RequestMethod.GET)
	public void isleaveexist(HttpServletRequest request, Model model, HttpServletResponse response,
			@RequestParam(value = "empid") int empid , @RequestParam(value = "startDate") String startDate,@RequestParam(value = "endDate") String endDate) 
	{
		try
		{
			String sql="SELECT lines.LEAVE_TYPE FROM LEAVE_REQUEST_LINES lines,LEAVE_REQUEST REQ WHERE" 
					+ "((lines.START_DATE >= TO_DATE('"+startDate+"','YYYY-MM-DD') AND lines.END_DATE <= TO_DATE('"+endDate+"','YYYY-MM-DD')) OR "
					+ "(lines.END_DATE >= TO_DATE('"+startDate+"','YYYY-MM-DD') AND lines.START_DATE <= TO_DATE('"+endDate+"','YYYY-MM-DD'))) AND " 
					+ "LINES.EMP_ID = "+empid+" AND REQ.LR_ID = LINES.LR_ID AND REQ.STATUS NOT IN('Cancelled','Rejected')";

			System.out.println("Inside isleaveexist SQL ==> "+sql);
			
			ArrayList<LeaveRequestLines> leaverequestlines = (ArrayList<LeaveRequestLines>) jdbcTemplate.query(sql, new RowMapper<LeaveRequestLines>() {

				@Override
				public LeaveRequestLines mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					LeaveRequestLines leavereqobj = new LeaveRequestLines();
					leavereqobj.setLeave_type(rs.getInt("LEAVE_TYPE"));
					if(leavereqobj.getLeave_type()==7) {
						leavereqobj.setDay_type("OD");
					}else if(leavereqobj.getLeave_type()==5) {
						leavereqobj.setDay_type("LWP"); 
					}else if(leavereqobj.getLeave_type()==1) {
						leavereqobj.setDay_type("CL"); 
					}else if(leavereqobj.getLeave_type()==2) {
						leavereqobj.setDay_type("PL"); 
					}
					
					return leavereqobj;
				}
				
			});
			
			String json = null;
			json = new Gson().toJson(leaverequestlines);

			response.setContentType("application/json");
			response.getWriter().write(json);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//-------------------------
	@RequestMapping(value = "/absentEmployee", method = RequestMethod.GET)
	public void absentEmployee(HttpServletRequest request, Model model, HttpServletResponse response,@RequestParam(value = "date") String date) throws IOException {
		try {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		 ErrorInfo errorMsg = new ErrorInfo();
		
		if (request.getParameter("date") != null) {
			date = request.getParameter("date");
		} else {
			Date today = new Date();
			date = simpleDateFormat.format(today);

		}
		List<EmployeeMasterAttendance> employees = Attendance_dao.empmaster();
		List<AttendanceModule> attendanceRecord = Attendance_dao.details(date);
		List<EmployeeStatus> status = new ArrayList<EmployeeStatus>();
		List<AttendanceReport> attendanceReports = new ArrayList<AttendanceReport>();
		List<Attendance_Module> attendance_module = new ArrayList<Attendance_Module>();
		attendance_module = Attendance_dao.attendancesModule();

		// All Counts
		ArrayList<JSONObject> parent=new ArrayList<JSONObject>();
		for (EmployeeMasterAttendance employeeMaster : employees) {
			// System.out.println("Emp MAster==>"+employeeMaster.getEmp_id());
			int empId = 0;
			if (employeeMaster.getEmp_id() == null) {
				empId = 0;
			} else {
				empId = Integer.parseInt(employeeMaster.getEmp_id());
			}
			status = Attendance_dao.empstatus(date, empId);
			AttendanceReport att1 = new AttendanceReport();

			Optional<AttendanceModule> matchingObject = attendanceRecord.stream()
					.filter(p -> p.getEmployee_code().equals(employeeMaster.getEmp_code())).findFirst();
			if (matchingObject.isPresent()) {
				
				
			} else {
				JSONObject t=new JSONObject();
				
				if (status.isEmpty()) {
					t.put("EMP_CODE", employeeMaster.getEmp_code());
					t.put("EMPLOYEE NAME", employeeMaster.getEmp_first_name().trim()+" "+employeeMaster.getEmp_last_name().trim());
					parent.add(t);
					
				} else {
					if(status.get(0).getLeave_type().equals("CL") || status.get(0).getLeave_type().equals("PL")||status.get(0).getLeave_type().equals("LWP") ) {
					t.put("EMP_CODE", employeeMaster.getEmp_code());
					t.put("EMPLOYEE NAME", employeeMaster.getEmp_first_name().trim()+" "+employeeMaster.getEmp_last_name().trim());
					parent.add(t);
					}
				}
				attendanceReports.add(att1);
			}

		}

		if(parent.size()!=0) {
			String json = null;
			json = new Gson().toJson(parent);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value = "/lateearlycoming", method = RequestMethod.GET)
	public void lateearlycoming(HttpServletRequest request, Model model, HttpServletResponse response,int empId,String date) throws IOException {
		
		try {
		
			
		List<LateEarlyDetails> le=Attendance_dao.leCountInfo(empId,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(le.size()!=0) {
			String json = null;
			json = new Gson().toJson(le);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value = "/getPendingForApprovalleaves", method = RequestMethod.GET)
	public void getPendingForApprovalleaves(HttpServletRequest request, Model model, HttpServletResponse response,int empId,String date) throws IOException {
		
		try {
		
		List<EmployeeStatus> pendingleaves=Attendance_dao.getPendingForApprovalleaves(empId,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(pendingleaves.size()!=0) {
			String json = null;
			json = new Gson().toJson(pendingleaves);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/getlwpleave", method = RequestMethod.GET)
	public void getlwpleaves(HttpServletRequest request, Model model, HttpServletResponse response,int empId,String date) throws IOException {
		
		try {
		
		List<EmployeeStatus> getlwp=Attendance_dao.getlwpleave(empId,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(getlwp.size()!=0) {
			String json = null;
			json = new Gson().toJson(getlwp);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/getfreaquentleaves", method = RequestMethod.GET)
	public void getfreaquentleaves(HttpServletRequest request, Model model, HttpServletResponse response,int empId,String date) throws IOException {
		
		try {
		
		List<EmployeeStatus> getlwp=Attendance_dao.getfreaquentleaves(empId,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(getlwp.size()!=0) {
			String json = null;
			json = new Gson().toJson(getlwp);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/notgetLeave", method = RequestMethod.GET)
	public void notgetLeave1(HttpServletRequest request, Model model, HttpServletResponse response,String leavetype,String date) throws IOException {
		
		try {
		
		List<Leave_creadit_report> getlwp=Attendance_dao.getnotgetleaves(leavetype,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(getlwp.size()!=0) {
			String json = null;
			json = new Gson().toJson(getlwp);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
    			String json = null;
				json = new Gson().toJson(getlwp);
				response.setContentType("application/json");
				response.getWriter().write(json);
		    } 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/getdesignationmanagement", method = RequestMethod.POST)
	public void designationmanagement(HttpServletRequest request, Model model, HttpServletResponse response,@RequestParam(value = "projTech", required = false) ArrayList<String> projTech) throws IOException {
		
		try {
		
			ArrayList<Joining_Details> joiningDetails=new ArrayList<Joining_Details>();
			
			for(int i=0;i<projTech.size();i++) {
				ArrayList<Joining_Details> joiningDetails1 = (ArrayList<Joining_Details>) hibernateTemplate
					.find("from Joining_Details where emp_id.is_activated='Y' and employee_status in ('"+projTech.get(i)+"') ");
				
				
				if(joiningDetails1.size()!=0) {
				   joiningDetails.addAll(joiningDetails1);
				}
			}
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(joiningDetails.size()!=0) {
			String json = null;
			json = new Gson().toJson(joiningDetails);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
    			String json = null;
				json = new Gson().toJson(joiningDetails);
				response.setContentType("application/json");
				response.getWriter().write(json);
		    } 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value = "/getwellplannedleave", method = RequestMethod.GET)
	public void getwellplannedleave(HttpServletRequest request, Model model, HttpServletResponse response,int empId,String date) throws IOException {
		
		try {
		
		List<EmployeeStatus> getlwp=Attendance_dao.getwellplannedleave(empId,date);
		
		ErrorInfo errorMsg = new ErrorInfo();
		
		if(getlwp.size()!=0) {
			String json = null;
			json = new Gson().toJson(getlwp);
			response.setContentType("application/json");
			response.getWriter().write(json);
		 } else {
		      errorMsg.setErrorCode(404);
		      errorMsg.setErrorMsg("Failed");
		      errorMsg.setErrorDesc("No data available");
		      String json = null;
		      json = (new Gson()).toJson(errorMsg);
		      response.setContentType("application/json");
		      response.getWriter().write(json);
		    } 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	


}
