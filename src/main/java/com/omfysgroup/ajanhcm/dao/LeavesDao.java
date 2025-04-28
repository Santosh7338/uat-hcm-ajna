package com.omfysgroup.ajanhcm.dao;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.BioMax_Details;
import com.omfysgroup.ajanhcm.model.EmployeeStatus;
import com.omfysgroup.ajanhcm.model.Employee_Attendance;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
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



public interface LeavesDao {

	public float saveLeaveCredit(Leave_Credit_Setting lcs);

	public List<LeaveRequestLines> getLeaveRequestLines(int LR_ID);

	public boolean saveLeaveNotifications(LeaveNotifications notifications);

	public boolean updateLeaveRequest(LeaveRequest leaveRequest);

	public boolean updateLeaveNotifications(LeaveNotifications leaveNotifications);

	public boolean updateLeaveRequestLine(LeaveRequestLines leaveRequestLines);

	public boolean saveReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar);

	public boolean saveLeavesSettings(Leaves_Setting ls);
	
	public Leaves_Setting getLeaveSettings(int leaveType);

	public int checkInLeave(String final_date, int emp_code, int int_mon, String string_mon, String year, int daycount, String daystatus);

	public int checkInLeaveHd(String final_date, int emp_code, int int_mon, String string_mon, String year,
			int daycount);

	public Joining_Details getDes_id(int emp_code);

	public float creditLeave1(int emp_code, int desig_id, float total);

	public LeaveBalance getLeaveBalance(int emp_id);

	public boolean updateLeaveBalance(LeaveBalance leaveBalance);

	public int getMaxLR_NO();

	public TimeLineStructure getTimeLine();

	public boolean updateTimeLine(TimeLineStructure tm);

	public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest);

	public boolean saveLeaveRequestLines(List<LeaveRequestLines> leaveRequestLines, LeaveBalance leaveBalance);

	public boolean saveMailCommunication(MailCommunication mail);
	
	public boolean saveRenewdMailCommunication(RenewedMailCommunication mail);
	
	public ArrayList checkInLeave_for_replacing_A_to_PL(String final_date, int emp_code, String daystatus, int int_mon, String string_mon,
			String year, int daycount);

	public float creditCl(int emp_code, int desig_id, int int_mon);

	public int saveEmployeeLeaveBalance(String empcode);

	public int saveAttendance(Employee_Attendance emp);

	public ArrayList<Leave_Credit_Setting> updateLcs(int lc_no);

	public ArrayList<Functional_Reporting> getEmp_Id_From_Reporting_Structure();

	public ArrayList<Administrative_Reporting> getEmp_Id_From_AdminReporting_Structure(int empid);

	public ArrayList<Functional_Reporting> getFrData(int fr_no);

	public ArrayList<Administrative_Reporting> getArData(int ar_no);

	public List<Leaves_Setting> update_leave_setting(int ls_id);

	public float udateLeaveCredit(Leave_Credit_Setting lcs);

	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee);

	public ArrayList<Employee_Master> getEmployeeData();

	public boolean updateReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar);
	
	public List<PendingApprovals> getApprovedApprovalPendingLeaves(Employee_Master employee,int year);
	
	public List<PendingApprovals> getPendingApproverPendingLeaves(Employee_Master approver);
	
	public List<PendingApprovals> getPendingApproverPendingLeave(Employee_Master employee, Employee_Master approver);
	
	public List<PendingApprovals> getPendingApprovalPendingLeaves(Employee_Master employee,int year);
	
	public List<PALeaveHistory> getapprovedLeaveHistory(Employee_Master employee,String currdate,String weekdaydate);
	
	public List<PALeaveHistory> getPendingLeaveHistory(Employee_Master employee,String currdate,String weekdaydate);
	
	public List<PALeaveHistory> getapprovedLeaveHistoryHR();
	
	public List<PALeaveHistory> getPendingLeaveHistoryHR();
	
	public List<PALeaveHistory> getPreviousApprovedLHHR(int prevyear);
	
	public List<PALeaveHistory> getPreviousApprovedLeaveHistory(Employee_Master employee,int prevyear);
	
	public List<PALeaveHistory> getPreviousPendingLeaveHistory(int year);
	
	public List<PALeaveHistory> getPreviousPendingLeaveHistoryEmployee(Employee_Master employee,int year);
	
	public List<PendingApprovals> getPendingApproverPendingLeavesForFunctional(Employee_Master approver);
	
	public List<PendingApprovals> getPendingApproverPendingLeavesForAdministrative(Employee_Master approver);
	
	public List<PendingApprovals> getPendingApproverPendingLeaveForFunctional(Employee_Master employee, Employee_Master approver);
	
	public List<PendingApprovals> getPendingApproverPendingLeaveForAdministartive(Employee_Master employee, Employee_Master approver);
	
	public List<LeaveDetails> getAppiledLeaveDetail(int lr_id ,int lr_no);
	
	public List<LeaveDetails> getAllApprovedLeaveList();
	
	public List<PendingApprovals> getPendingApproverPendingLeavesForManagement(int empid);
	
	public List<PendingApprovals>  getLeaveRequestApprovedList(LocalDate currDate,LocalDate weekday,Employee_Master emp);
	
	public List<PendingApprovals>  getLeaveRequestApprovalPendingList(LocalDate currDate,LocalDate weekday,Employee_Master emp);
	
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForFr(String currDate,String weekday,int emp);
	
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForAr(String currDate,String weekday,int emp);
	
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForMG(String currDate,String weekday,int emp);
	
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForHR(String currDate,String weekday,int emp);
	
	public boolean saveLeaveRequestLinesForProbation(List<LeaveRequestLines> leaveRequestLines);
	
	public int deleteLeave(Object o);
	
	//Santosh add code
	
	public List<Employee_Master> employeeLeaveApplicable(int employeeId);
	
	public int updateLeaveApplicable(Employee_Master employeeMaster);
	
	public List<Employee_Master> employeeCodeList();
	
	 public List<Employee_Master> readEmployeeLeavesApplicable();

	public List<Rules_Documents> getRulesDocument(int doc_id);

	public List<Rules_Documents> getAllRulesDocument();

	public List<Rules_Document_Type> getRulesdocTypes();

	public List<EmployeeStatus> GetLeaveDetails(LocalDate localDate, int empId,String leavetype,String pl_with_Lwp,String Cl_with_Lwp);

	public ArrayList<Leave_creadit_report> getLeaveCreditrepo(String leavetype, String date);

	public List<BioMax_Details> getBiomaxDetails(String date); 

	
	
}
