package com.omfysgroup.ajanhcm.serviceImpl;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
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
import com.omfysgroup.ajanhcm.model.Leaves_Setting;
import com.omfysgroup.ajanhcm.model.MailCommunication;
import com.omfysgroup.ajanhcm.model.PALeaveHistory;
import com.omfysgroup.ajanhcm.model.PendingApprovals;
import com.omfysgroup.ajanhcm.model.RenewedMailCommunication;
import com.omfysgroup.ajanhcm.model.Rules_Document_Type;
import com.omfysgroup.ajanhcm.model.Rules_Documents;
import com.omfysgroup.ajanhcm.model.TimeLineStructure;
import com.omfysgroup.ajanhcm.service.LeavesService;




@Service("leavesService")
@Transactional
public class LeavesServiceImpl implements LeavesService{
	
	@Autowired
	com.omfysgroup.ajanhcm.dao.LeavesDao LeavesDao;
	

	
	@Override
	public List<LeaveRequestLines> getLeaveRequestLines(int LR_ID) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestLines(LR_ID);
	}

	@Override
	public boolean saveLeaveNotifications(LeaveNotifications notifications) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeaveNotifications(notifications);
	}

	@Override
	public boolean updateLeaveRequest(LeaveRequest leaveRequest) {
		// TODO Auto-generated method stub
		return LeavesDao.updateLeaveRequest(leaveRequest);
	}

	@Override
	public boolean updateLeaveNotifications(LeaveNotifications leaveNotifications) {
		// TODO Auto-generated method stub
		return LeavesDao.updateLeaveNotifications(leaveNotifications);
	}

	@Override
	public boolean updateLeaveRequestLine(LeaveRequestLines leaveRequestLines) {
		// TODO Auto-generated method stub
		return LeavesDao.updateLeaveRequestLine(leaveRequestLines);
	}

	@Override
	public float saveLeaveCredit(Leave_Credit_Setting lcs) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeaveCredit(lcs);
	}
	
	@Override
	public boolean updateLeaveBalance(LeaveBalance leaveBalance) {
		// TODO Auto-generated method stub
		return LeavesDao.updateLeaveBalance(leaveBalance);
	}

	@Override
	public Leaves_Setting getLeaveSettings(int leaveType) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveSettings(leaveType);
	}

	@Override
	public boolean saveReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar) {
		// TODO Auto-generated method stub
		return LeavesDao.saveReportingStructure(fr, ar);
	}

	@Override
	public boolean saveLeavesSettings(Leaves_Setting ls) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeavesSettings(ls);
	}
	@Override
	public int checkInLeave(String final_date,int emp_code,int int_mon,String string_mon,String year,int daycount,String daystatus) {
		return LeavesDao.checkInLeave(final_date,emp_code,int_mon,string_mon,year,daycount,daystatus);
	}

	@Override
	public int checkInLeaveHd(String final_date, int emp_code, int int_mon, String string_mon, String year,
			int daycount) {
		// TODO Auto-generated method stub
		return LeavesDao.checkInLeaveHd(final_date,emp_code,int_mon,string_mon,year,daycount);
	}

	@Override
	public Joining_Details getDes_id(int emp_code) {
		// TODO Auto-generated method stub
		return LeavesDao.getDes_id(emp_code);
		
	}

	@Override
	public float creditLeave1(int emp_code, int desig_id,float total) {
		// TODO Auto-generated method stub
		return LeavesDao.creditLeave1(emp_code,desig_id,total);
	}

	@Override
	public LeaveBalance getLeaveBalance(int emp_id) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveBalance(emp_id);
	}

	@Override
	public int getMaxLR_NO() {
		// TODO Auto-generated method stub
		return LeavesDao.getMaxLR_NO();
	}
	
	@Override
	public TimeLineStructure getTimeLine() {
		// TODO Auto-generated method stub
		return LeavesDao.getTimeLine();
	}
	
	@Override
	public boolean updateTimeLine(TimeLineStructure tm) {
		// TODO Auto-generated method stub
		return LeavesDao.updateTimeLine(tm);
	}

	@Override
	public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeaveRequest(leaveRequest);
	}
	
	@Override
	public ArrayList checkInLeave_for_replacing_A_to_PL(String final_date, int emp_code,String daystatus, int int_mon, String string_mon,
			String year, int daycount) {
		return LeavesDao.checkInLeave_for_replacing_A_to_PL( final_date,  emp_code, daystatus, int_mon,  string_mon,
				 year,  daycount);
	}

	@Override
	public boolean saveLeaveRequestLines(List<LeaveRequestLines> leaveRequestLines, LeaveBalance leaveBalance) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeaveRequestLines(leaveRequestLines, leaveBalance);
	}

	@Override
	public boolean saveMailCommunication(MailCommunication mail) {
		// TODO Auto-generated method stub
		return LeavesDao.saveMailCommunication(mail);
	}

	@Override
	public float creditCl(int emp_code, int desig_id, int int_mon) {
		// TODO Auto-generated method stub
		return LeavesDao.creditCl(emp_code,desig_id,int_mon);
	}

	@Override
	public int saveEmployeeLeaveBalance(String empcode) {
		// TODO Auto-generated method stub
		return LeavesDao.saveEmployeeLeaveBalance(empcode);
	}

	@Override
	public int saveAttendance(Employee_Attendance emp) {
		// TODO Auto-generated method stub
		return LeavesDao.saveAttendance(emp);
	}

	

	@Override
	public ArrayList<Leave_Credit_Setting> updateLcs(int lc_no) {
		// TODO Auto-generated method stub
		return LeavesDao.updateLcs(lc_no);
	}

	@Override
	public ArrayList<Functional_Reporting> getEmp_Id_From_Reporting_Structure() {
		// TODO Auto-generated method stub
		return LeavesDao.getEmp_Id_From_Reporting_Structure();
	}

	@Override
	public ArrayList<Administrative_Reporting> getEmp_Id_From_AdminReporting_Structure(int empid) {
		// TODO Auto-generated method stub
		return LeavesDao.getEmp_Id_From_AdminReporting_Structure(empid);
	}

	@Override
	public ArrayList<Administrative_Reporting> getArData(int ar_no) {
		// TODO Auto-generated method stub
		return LeavesDao.getArData(ar_no);
	}

	@Override
	public ArrayList<Functional_Reporting> getFrData(int fr_no) {
		// TODO Auto-generated method stub
		return LeavesDao.getFrData(fr_no);
	}


	@Override
	public List<Leaves_Setting> update_leaveSetting(int ls_id) {
		// TODO Auto-generated method stub
		return LeavesDao.update_leave_setting(ls_id);
	}

	@Override
	public float udateLeaveCredit(Leave_Credit_Setting lcs) {
		// TODO Auto-generated method stub
		return LeavesDao.udateLeaveCredit(lcs);
	}

	@Override
	public List<LeaveNotifications> getApprovalPendingLeaves(Employee_Master employee) {
		// TODO Auto-generated method stub
		return LeavesDao.getApprovalPendingLeaves(employee);
	}

	@Override
	public ArrayList<Employee_Master> getEmployeeData() {
		// TODO Auto-generated method stub
		return LeavesDao.getEmployeeData();
	}

	@Override
	public boolean updateReportingStructure(List<Functional_Reporting> fr, List<Administrative_Reporting> ar) {
		// TODO Auto-generated method stub
		return LeavesDao.updateReportingStructure(fr,ar);
	}

	@Override
	public List<PendingApprovals> getApprovedApprovalPendingLeaves(Employee_Master employee,int year) {
		// TODO Auto-generated method stub
		return LeavesDao.getApprovedApprovalPendingLeaves(employee,year);
	}

	@Override
	public List<PendingApprovals> getPendingApprovalPendingLeaves(Employee_Master employee,int year) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApprovalPendingLeaves(employee,year);
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaves(Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeaves(approver);
	}
	
	@Override
	public List<PendingApprovals> getPendingApproverPendingLeave(Employee_Master employee, Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeave(employee, approver);
	}
	


	@Override
	public List<PALeaveHistory> getapprovedLeaveHistoryHR() {
		// TODO Auto-generated method stub
		return LeavesDao.getapprovedLeaveHistoryHR();
	}

	@Override
	public List<PALeaveHistory> getPendingLeaveHistoryHR() {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingLeaveHistoryHR();
	}

	@Override
	public List<PALeaveHistory> getPreviousApprovedLHHR(int prevyear) {
		// TODO Auto-generated method stub
		return LeavesDao.getPreviousApprovedLHHR(prevyear);
	}

	@Override
	public List<PALeaveHistory> getPreviousApprovedLeaveHistory(Employee_Master employee,int prevyear) {
		// TODO Auto-generated method stub
		return LeavesDao.getPreviousApprovedLeaveHistory(employee,prevyear);
	}

	@Override
	public List<PALeaveHistory> getPreviousPendingLeaveHistory(int year) {
		// TODO Auto-generated method stub
		return LeavesDao.getPreviousPendingLeaveHistory(year);
	}

	@Override
	public List<PALeaveHistory> getPreviousPendingLeaveHistoryEmployee(Employee_Master employee, int year) {
		// TODO Auto-generated method stub
		return LeavesDao.getPreviousPendingLeaveHistoryEmployee(employee, year);
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForFunctional(Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeavesForFunctional(approver);
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForAdministrative(Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeavesForAdministrative(approver);
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaveForFunctional(Employee_Master employee,
			Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeaveForFunctional(employee, approver);
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeaveForAdministartive(Employee_Master employee,
			Employee_Master approver) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeaveForAdministartive(employee, approver);
	}

	@Override
	public boolean saveRenewdMailCommunication(RenewedMailCommunication mail) {
		// TODO Auto-generated method stub
		return LeavesDao.saveRenewdMailCommunication(mail);
	}

	

	@Override
	public List<LeaveDetails> getAllApprovedLeaveList() {
		// TODO Auto-generated method stub
		return LeavesDao.getAllApprovedLeaveList();
	}

	@Override
	public List<PendingApprovals> getPendingApproverPendingLeavesForManagement(int empid) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingApproverPendingLeavesForManagement(empid);
	}

	@Override
	public List<LeaveDetails> getAppiledLeaveDetail(int lr_id, int lr_no) {
		// TODO Auto-generated method stub
		return	LeavesDao.getAppiledLeaveDetail(lr_id, lr_no);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovedList(LocalDate currDate, LocalDate weekday,
			Employee_Master emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovedList(currDate, weekday, emp);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingList(LocalDate currDate, LocalDate weekday,
			Employee_Master emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovalPendingList(currDate, weekday, emp);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForFr(String currDate, String weekday, int emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovalPendingListForFr(currDate, weekday, emp);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForAr(String currDate, String weekday, int emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovalPendingListForAr(currDate, weekday, emp);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForMG(String currDate, String weekday, int emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovalPendingListForMG(currDate, weekday, emp);
	}

	@Override
	public List<PALeaveHistory> getapprovedLeaveHistory(Employee_Master employee, String currdate, String weekdaydate) {
		// TODO Auto-generated method stub
		return LeavesDao.getapprovedLeaveHistory(employee, currdate, weekdaydate);
	}

	@Override
	public List<PALeaveHistory> getPendingLeaveHistory(Employee_Master employee, String currdate, String weekdaydate) {
		// TODO Auto-generated method stub
		return LeavesDao.getPendingLeaveHistory(employee, currdate, weekdaydate);
	}

	@Override
	public List<PendingApprovals> getLeaveRequestApprovalPendingListForHR(String currDate, String weekday, int emp) {
		// TODO Auto-generated method stub
		return LeavesDao.getLeaveRequestApprovalPendingListForHR(currDate, weekday, emp);
	}

	@Override
	public boolean saveLeaveRequestLinesForProbation(List<LeaveRequestLines> leaveRequestLines) {
		// TODO Auto-generated method stub
		return LeavesDao.saveLeaveRequestLinesForProbation(leaveRequestLines);
	}

	@Override
	public int deleteLeave(Object o) {
		// TODO Auto-generated method stub
		return LeavesDao.deleteLeave(o);
	}

	@Override
	public List<Rules_Documents> getRulesDocument(int doc_id) {
		// TODO Auto-generated method stub
		return LeavesDao.getRulesDocument(doc_id);
	}

	@Override
	public List<Rules_Documents> getAllRulesDocument() {
		// TODO Auto-generated method stub
		return LeavesDao.getAllRulesDocument();
	}

	@Override
	public List<Rules_Document_Type> getRulesdocTypes() {
		// TODO Auto-generated method stub
		return LeavesDao.getRulesdocTypes();
	}

	

}
