package com.omfysgroup.ajanhcm.serviceImpl;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

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
import com.omfysgroup.ajanhcm.model.Training_Master;
import com.omfysgroup.ajanhcm.model.Training_Request_Notification;
import com.omfysgroup.ajanhcm.model.Training_Sheet_Lines;
import com.omfysgroup.ajanhcm.service.TrainingService;



@Service("TrainingService")
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingDao  trainingDAO;

	@Override
	public List<Training_Master> getTrainingSheetGrid(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingSheetGrid(empid);
	}

	@Override
	public Functional_Reporting getFunctionalReporter(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getFunctionalReporter(empid);
	}
	
	@Override
	public List<Administrative_Reporting> getAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getAdministrativeReporter(empid);
	}

	@Override
	public int add_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines) {
		// TODO Auto-generated method stub
		return trainingDAO.add_Training_Sheet_Lines(training_sheet_lines);
	}

	@Override
	public List<Training_Sheet_Lines> getTaskList(int trId) {
		// TODO Auto-generated method stub
		return trainingDAO.getTaskList(trId);
	}

	@Override
	public List<Training_Master> getTrainee(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainee(empid);
	}

	@Override
	public List<Training_Master> getTrainer(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainer(empid);
	}

	@Override
	public int update_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines) {
		// TODO Auto-generated method stub
		return trainingDAO.update_Training_Sheet_Lines(training_sheet_lines);
	}

	@Override
	public int insert_Mail_Communication(MailCommunication mailComm) {
		// TODO Auto-generated method stub
		return trainingDAO.insert_Mail_Communication(mailComm);
	}

	

	@Override
	public List<Training_Master> getTrainingSheetADGrid(int adrid) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingSheetADGrid(adrid);
	}

	@Override
	public Employee_Master getEmployee(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getEmployee(empid);
	}

	@Override
	public Training_Master add_TrainingMaster(Training_Master trainging_Master) {
		// TODO Auto-generated method stub
		return trainingDAO.add_TrainingMaster(trainging_Master);
	}

	@Override
	public boolean saveTrainingRequestNotification(Training_Request_Notification notifications) {
		// TODO Auto-generated method stub
		return trainingDAO.saveTrainingRequestNotification(notifications);
	}

	@Override
	public boolean isFunctionalReporter(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isFunctionalReporter(empid);
	}

	@Override
	public boolean isAdministrativeReporter(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isAdministrativeReporter(empid);
	}

	@Override
	public boolean isTrainer(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isTrainer(empid);
	}

	@Override
	public List<Training_Master> getTrainingSheetTrainerGrid(int trainerid) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingSheetTrainerGrid(trainerid);
	}

	@Override
	public int update_Training_Master(Training_Master training_master) {
		// TODO Auto-generated method stub
		return trainingDAO.update_Training_Master(training_master);
	}

	@Override
	public Training_Master getTrainingMaster(int tr_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingMaster(tr_id);
	}

	@Override
	public boolean isTrainee(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isTrainee(empid);
	}

	@Override
	public List<Training_Master> getTrainingSheetTraineeGrid(int traineeId) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingSheetTraineeGrid(traineeId);
	}

	@Override
	public List<Training_Sheet_Lines> getPlannedStartDate(int tr_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getPlannedStartDate(tr_id);
	}

	@Override
	public List<Training_Sheet_Lines> getPlannedEndDate(int tr_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getPlannedEndDate(tr_id);
	}

	@Override
	public float  calculateDeviation(Date planStartDate, Date planEndDate, Date actualStartDate, Date actualEndDate) {
		// TODO Auto-generated method stub
		return trainingDAO.calculateDeviation(planStartDate, planEndDate, actualStartDate, actualEndDate);
	}

	@Override
	public boolean isCompletedTask(int tr_lines_id) {
		// TODO Auto-generated method stub
		return trainingDAO.isCompletedTask(tr_lines_id);
	}

	@Override
	public List<Training_Sheet_Lines> getCompletedTask(int trId) {
		// TODO Auto-generated method stub
		return trainingDAO.getCompletedTask(trId);
	}

	@Override
	public float calTotalDeviation(int trId, int trlinesid) {
		// TODO Auto-generated method stub
		return trainingDAO.calTotalDeviation(trId, trlinesid);
	}

	@Override
	public boolean save_Training_Sheet_Lines(List<Training_Sheet_Lines> training_sheet_lines) {
		// TODO Auto-generated method stub
		return trainingDAO.save_Training_Sheet_Lines(training_sheet_lines);
	}

	@Override
	public Compentency_Master getCompentencyMaster(int comp_m_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getCompentencyMaster(comp_m_id);
	}

	@Override
	public boolean isAllTaskCompleted(int trId) {
		// TODO Auto-generated method stub
		return trainingDAO.isAllTaskCompleted(trId);
	}

	@Override
	public List<Training_Sheet_Lines> getTaskListForDownload(int tr_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getTaskListForDownload(tr_id);
	}

	@Override
	public boolean saveTraineeTrSheet(List<Trainee_Training_Sh_Lines> trainging_Master) {
		// TODO Auto-generated method stub
		return trainingDAO.saveTraineeTrSheet(trainging_Master);
	}

	@Override
	public TraineeTrainingSheet add_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh) {
		// TODO Auto-generated method stub
		return trainingDAO.add_TraineeTrainingSheet(trainging_tr_sh);
	}

	@Override
	public List<TraineeTrainingSheet> getInhouseTrSheetGrid(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getInhouseTrSheetGrid(empid);
	}

	@Override
	public List<Trainee_Training_Sh_Lines> getTaskListOfInhouse(int trId) {
		// TODO Auto-generated method stub
		return trainingDAO.getTaskListOfInhouse(trId);
	}

	@Override
	public boolean isTraineeForInhouse(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isTraineeForInhouse(empid);
	}

	@Override
	public InhouseTrainingSheet saveInhouseTrainingSheet(InhouseTrainingSheet inhouse_tr_sh) {
		// TODO Auto-generated method stub
		return trainingDAO.saveInhouseTrainingSheet(inhouse_tr_sh);
	}

	@Override
	public List<InhouseTrainingSheet> getInhouseRecords(int trId) {
		// TODO Auto-generated method stub
		return trainingDAO.getInhouseRecords(trId);
	}

	@Override
	public TraineeTrainingSheet getTraineeTrainingSheet(int trainging_tr_sh) {
		// TODO Auto-generated method stub
		return trainingDAO.getTraineeTrainingSheet(trainging_tr_sh);
	}

	@Override
	public int deleteInhouseTrainingRecords(int inhousetrid) {
		// TODO Auto-generated method stub
		return trainingDAO.deleteInhouseTrainingRecords(inhousetrid);
	}

	@Override
	public TraineeTrainingSheet update_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh) {
		// TODO Auto-generated method stub
		return trainingDAO.update_TraineeTrainingSheet(trainging_tr_sh);
	}

	@Override
	public List<Assessment> getAssessment(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getAssessment(empid);
	}

	@Override
	public List<Assessment_Lines> getAssessmentTaskList(int assid) {
		// TODO Auto-generated method stub
		return trainingDAO.getAssessmentTaskList(assid);
	}

	@Override
	public boolean isFunctionalReporterTRSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isFunctionalReporterTRSheet(empid);
	}

	@Override
	public boolean isAdministrativeReporterTRSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isAdministrativeReporterTRSheet(empid);
	}

	@Override
	public boolean isFunctionalReporterInhouseSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isFunctionalReporterInhouseSheet(empid);
	}

	@Override
	public boolean isAdministrativeReporterInhouseSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.isAdministrativeReporterInhouseSheet(empid);
	}

	@Override
	public List<Functional_Reporting> getFunctionalReporterList(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.getFunctionalReporterList(empid);
	}

	@Override
	public List<Training_Master> findPendingForApprovalTrainingsSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.findPendingForApprovalTrainingsSheet(empid);
	}

	@Override
	public List<Training_Master> findPendingTrainingListNotification(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.findPendingTrainingListNotification(empid);
	}

	@Override
	public List<Training_Master> getTrainingofParticularTrainee(String status, int userEmpCode, int traineeEmpCode) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingofParticularTrainee(status, userEmpCode, traineeEmpCode);
	}

	@Override
	public List<TraineeTrainingSheet> getInhouseTrainingofParticularTrainee(String status, int userEmpCode,
			int traineeEmpCode) {
		// TODO Auto-generated method stub
		return trainingDAO.getInhouseTrainingofParticularTrainee(status, userEmpCode, traineeEmpCode);
	}

	@Override
	public SubCompentency getSubCompentency(int topic_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getSubCompentency(topic_id);
	}

	@Override
	public String getTrainingCode(String[] compgroup_ids) {
		// TODO Auto-generated method stub
		return trainingDAO.getTrainingCode(compgroup_ids);
	}

	@Override
	public RequestedTraining saveRequestedTraining(RequestedTraining reqTraining) {
		// TODO Auto-generated method stub
		return trainingDAO.saveRequestedTraining(reqTraining);
	}

	@Override
	public RequestedTraining updateRequestedTraining(RequestedTraining reqTraining) {
		// TODO Auto-generated method stub
		return trainingDAO.updateRequestedTraining(reqTraining);
	}

	@Override
	public List<Training_Master> findOngoingTrainingsSheetForTrainee(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.findOngoingTrainingsSheetForTrainee(empid);
	}

	@Override
	public List<TraineeTrainingSheet> findOngoingInhouseTrainingsSheetForTrainee(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.findOngoingInhouseTrainingsSheetForTrainee(empid);
	}


	@Override
	public Compentency_Group getCompentencyGroup(int comp_id) {
		// TODO Auto-generated method stub
		return trainingDAO.getCompentencyGroup(comp_id);
	}

	@Override
	public List<TraineeTrainingSheet> findPendingInhouseTrainingsSheet(int empid) {
		// TODO Auto-generated method stub
		return trainingDAO.findPendingInhouseTrainingsSheet(empid);
	}

	@Override
	public String getTrainingPlanExcelFilePath(int tr_id, Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
