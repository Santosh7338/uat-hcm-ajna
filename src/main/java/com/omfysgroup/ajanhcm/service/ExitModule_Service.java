package com.omfysgroup.ajanhcm.service;

import java.util.List;



import org.springframework.core.env.Environment;

import com.omfysgroup.ajanhcm.model.Administrative_Reporting;
import com.omfysgroup.ajanhcm.model.Employee_Master;
import com.omfysgroup.ajanhcm.model.Functional_Reporting;
import com.omfysgroup.ajanhcm.model.KtKakerCount;
import com.omfysgroup.ajanhcm.model.KtNotifivationHead;
import com.omfysgroup.ajanhcm.model.KtPlan_Header;
import com.omfysgroup.ajanhcm.model.KtPlans;
import com.omfysgroup.ajanhcm.model.MarkExitScreen;
import com.omfysgroup.ajanhcm.model.Particulars_addGroup;

public interface ExitModule_Service {

	boolean saveKtModule(KtPlans ktplans);

	boolean saveParticulars(Particulars_addGroup part_grp);

	int SaveExitRequest(MarkExitScreen markExit);

	List<MarkExitScreen> getexitnotificationList(Employee_Master empid);


	List<KtNotifivationHead> getKtplansnotificationList(Employee_Master emp);

	boolean isFunctionalReporter(int emp_id);

	boolean isKtGiver(int empid);

	boolean isAdministrativeReporter(int empid);

	List<KtPlans> getAdminsnotificationList(int employeeid);

	List<KtKakerCount> getktdetails(int employeeid);

	Employee_Master getEmployee(int empid);

	String getKtPlanExcelFilePath(int kthead_id, Environment environment);

}
