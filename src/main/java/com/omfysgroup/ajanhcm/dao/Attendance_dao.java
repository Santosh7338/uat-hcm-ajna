package com.omfysgroup.ajanhcm.dao;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;




import org.springframework.stereotype.Repository;

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



@Repository
public interface Attendance_dao{

	List<Designation_Master> getdesignation(String dept);

	boolean saveHoli_days(Holidays_Setup h_setup);

	int savePuchExcel(PunchRecords pr);
	
	public List<EmployeeMasterAttendance> empmaster();
	
	public List<EmployeeMasterAttendance> empmaster1(int empid);
	
	public List<AttendanceModule> details(String date);
	
	public List<EmployeeStatus> empstatus(String todaysDate, int employeeId);
	public List<EmployeeStatus> odstatus(String todaysDate, int employeeId) ;

	
	public List<Holidays_Setup> getHolidayDetails(String date);
	
	//Auto Attendance logic santosh
	
	public List<AttendanceModule> attModuleInfo(String date);
	
	public List<EmployeeStatus> empStatusLeave(String todaysDate, int employeeId);
	
	public List<AttendanceModule> details1(String todaysDate, int employeeId);
	
	public List<AttendanceReport> attreport();
	
	public List<Early_Late_Tracking> attRegularization(String todaysDate, int employeeId);
	
	public List<LeaveBalance> leaveBalance(int employeeId); 
	
	public boolean updateLeaveBalance(LeaveBalance leaveBalance);
	
	public int createAttendanceModule(Attendance_Module attendance_module);
	
	public int updateAttendanceModule(Attendance_Module attendance_module);
	
	public List<Attendance_Module> readAttendanceModule();
	
	public List<Attendance_Module> attendancesModule();
	
	public List<LateEarlyEvents> sumOfEvents(String date,int employeeId);
	
	public List<LateEarlyEvents> eventsCounts(String date,String endDate ,int employeeId);
	
	public List<Attendance_Module> attendanceSetting(String date);
	//Methods by auto attendance logic by snt
	
	//There should be a report options from which we should be able to get the following data by selecting date ranges
	public List<AttendanceModule> attendanceLCEGReport();
	
	public int lateEarlyDebited(Late_Early_Debited_Leaves lateEarlyDebitedLeves);
	
	//21/26
	public List<AttendanceModule> attModuleInfo1(String date,String date1);
	
	public List<EmployeeStatus> empstatus1(String startDate,String endDate, int employeeId);

	public List<LateEarlyEvents> attRegularizationCount(String date ,String endDate ,int employeeId);
	
	//DASHBORD Count for employees
	
	public List<LateEarlyEvents> biomaxCount(String startDate , String endDate, String employeeId );
	
	public List<LateEarlyEvents> totalLeavesCount(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> levesCountforPresent(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> leavesDedictionCount(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> leavesUtilization(String StartDate, String endDate,String employeeId);
	
	
	//Month Count for Employee DashBord
	
    public List<LateEarlyEvents> biomaxCountMonth(String startDate , String endDate, String employeeId );
	
	public List<LateEarlyEvents> totalLeavesCountMonth(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> levesCountforPresentMonth(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> leavesDedictionCountMonth(String StartDate, String endDate,String employeeId);
	
	public List<LateEarlyEvents> leavesUtilizationMonth(String StartDate, String endDate,String employeeId);
	
	//DASHBORD CONT FOR HR
	
    public List<LateEarlyEvents> biomaxCountHR(String startDate , String endDate);
	
	public List<LateEarlyEvents> totalLeavesCountHR(String StartDate, String endDate);
	
	public List<LateEarlyEvents> levesCountforPresentHR(String StartDate, String endDate);
	
	public List<LateEarlyEvents> leavesDedictionCountHR(String StartDate, String endDate);
	
	public List<LateEarlyEvents> leavesUtilizationHR(String StartDate, String endDate);
	
	//Dashbord count for Month
	
    public List<LateEarlyEvents> biomaxCountHRMonth(String startDate , String endDate);
	
	public List<LateEarlyEvents> totalLeavesCountHRMonth(String StartDate, String endDate);
	
	public List<LateEarlyEvents> levesCountforPresentHRMonth(String StartDate, String endDate);
	
	public List<LateEarlyEvents> leavesDedictionCountHRMonth(String StartDate, String endDate);
	
	public List<LateEarlyEvents> leavesUtilizationHRMonth(String StartDate, String endDate);
	
	public List<LateEarlyEvents> holidayCountHRMonth(String StartDate,String endDate);
	
	public List<LateEarlyEvents> sundaysCountHrMonth(String StartDate, String endDate);
	
	
		
	//RULES ON LATE COMING AND EARLY GOING APPLICABLE OR NOT APPLICABLE
	
	public int updateLateEarlyStatus(Employee_Master employeeMaster);
	
	public List<Employee_Master> employeeCodeList();
	
	public List<Employee_Master> lateEarlyRulesStatus(int employeeId);
	
	
	//ATTENDANCE REPORT
	
	public List<AttendanceModule> employeeAttendaceReportLateComing(String startDate, String endDate);
	
	public List<AttendanceModule> employeeAttednaceReportEarlyGoing(String startDate, String endDate);
	
	public List<AttendanceModule> employeeAttendanceReportOnIntime(String startDate, String endDate);
	
	public List<AttendanceModule> employeeAtteendaceReportOuttime(String startDate, String endDate);
	
	public List<Late_Early_Debited_Leaves> lateEarlyDebitedLeavesReport(String startDate, String endDate);
	
	public List<EmployeeStatus> employeeLeavesReports(String startDate,String endDate);
	
    public List<EmployeeStatus> utilizeLeaveClReport(String startDate,String endDate);
    
    public List<EmployeeStatus> utilizeLeavePlReport(String startDate,String endDate);
    
    //
    public List<Late_Early_Debited_Leaves> lateEarlyDebitedLeaveEmployee(String startDate,int employeeId);
    
    //READ AUTO CREADIT LEAVES   
    
	public int CreditLeavesAuto(Leave_Creadit_Auto creditLeavesAuto);
	
	public int updateCreditLeavesAuto(Leave_Creadit_Auto creditLeavesAuto);
	
	public List<Leave_Creadit_Auto> readCreadiLeavesAuto();
	
	public List<Leave_Creadit_Auto> readCreadiLeavesAuto(int slno);
	
	public List<Leave_Creadit_Auto> readCreaditConformhfPl();
	
	public List<Leave_Creadit_Auto> readCreaditConfromFlPL();
	
	public List<Leave_Creadit_Auto> readCreaditProbationhfPl();
	
	public List<Leave_Creadit_Auto> readCreaditProbationFlPl();
	
	public List<Leave_Creadit_Auto> readCreaditTraineehfPl();
	
	public List<Leave_Creadit_Auto> readCreaditTraineeFlPl();
	
	public List<Leave_Creadit_Auto> readCreaditConformHfCL();
	
	public List<Leave_Creadit_Auto> readCreaditConformFlCL();
	
	public List<Leave_Creadit_Auto> readCreaditProbationHfCL();
	
	public List<Leave_Creadit_Auto> readCreaditProbationFlCL();
	
	public List<Leave_Creadit_Auto> readCreaditTraineeHfCL();
	
	public List<Leave_Creadit_Auto> readCreaditTraineeFlCL();
	
    public List<Employee_Master> readEmployeeMasterLateEarlyRules();   
    
    public List<Joining_Details> employeeStatus(String empId);  
    
    public List<MarkExitScreen> exitType(String empId);
    
    //Date 01-04-2022
    
    public List<Joining_Details> employeeJoiningDate(int employeeId);
    
    public List<LateEarlyEvents> employeeDaysCount(String start, String end);
    
    
    //for api in java
    
    public List<EmployeeMasterAttendance> fr(String employeeCode);
    
    public List<EmployeeMasterAttendance> ar(String employeeCode);
    
    public List<EmployeeMasterAttendance> hrdetails();
    
    
    public List<Early_Late_Tracking> attRegularizationCount1(String date ,String endDate ,int employeeId);

	List<EmployeeStatus> empstatusRejected(String date, int empId);

	List<LATEEARLY> lateEarlycount(int empId, String upperCase, String upperCase2);

	ArrayList<od_report_lwp> getorldata(String startdate, String enddate);

	List<od_report_lwp> getodtolwpdata(int srno);

	List<AttendanceModule> empdetails(String string);

	List<EmployeeStatus> getLeaveDateForAllEmployee(String string);

	List<od_report_lwp> getOdToLwpConverterAllEmployee(String string);

	List<Late_Early_Debited_Leaves> empLECount(int empId, String yearmonth);

	ArrayList<Employee_Joining_Details> getAllEmployeeJoining();

	List<Early_Late_Tracking> att_reg(String string);

	List<AttendanceModule> getbiomaxattendance(LocalDate firstDayOfThisYear, String enddate);

	List<EmployeeStatus> getLeavetypeforlwpconverter(String startdate, String empid);

	List<EmployeeStatus> getLeavedetails(String date);

	List<LATEEARLY> totalLateEarlyCount(String startDate, String strDate, Integer valueOf);

	List<LateEarlyDetails> leCountInfo(int empId, String date);

	List<EmployeeStatus> getPendingForApprovalleaves(int empId, String date);

	List<EmployeeStatus> getlwpleave(int empId, String date);

	List<EmployeeStatus> getfreaquentleaves(int empId, String date);

	List<Leave_creadit_report> getnotgetleaves(String leavetype, String date);

	List<Attendance_Regularazation> earlyAndLateTracking(String date, Integer valueOf);

	List<EmployeeStatus> empstatus123(int empid);

	List<EmployeeStatus> getwellplannedleave(int empId, String date);

	List<Tte_Lwp> getttelwp(String date);	
    
    

}
