package com.omfysgroup.ajanhcm.dao;

import java.util.Date;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;

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

public interface TrainingDao {
	
	public boolean isTrainee(int empid);
	
	public boolean isInhouseTrainee(int empid);
	
	public boolean isTraineeForInhouse(int empid);
	
	public boolean isTrainer(int empid);
	
	public boolean isFunctionalReporter(int empid);
	
	public boolean isFunctionalReporterTRSheet(int empid);
	
	public boolean isFunctionalReporterInhouseSheet(int empid);
	
	public boolean isAdministrativeReporter(int empid);
	
	public boolean isAdministrativeReporterTRSheet(int empid);
	
	public boolean isAdministrativeReporterInhouseSheet(int empid);
	
	public boolean isCompletedTask(int tr_lines_id);
	
	public boolean isAllTaskCompleted(int trId);
	
	public List<Administrative_Reporting> getAdministrativeReporter(int empid);
	
	public Employee_Master getEmployee(int empid);
	
	public Training_Master add_TrainingMaster(Training_Master trainging_Master);
	
	public TraineeTrainingSheet add_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh);
	
	public TraineeTrainingSheet update_TraineeTrainingSheet(TraineeTrainingSheet trainging_tr_sh);
	
	public TraineeTrainingSheet getTraineeTrainingSheet(int trainging_tr_sh);
	
	public int deleteInhouseTrainingRecords(int inhousetrid);
	
	public InhouseTrainingSheet saveInhouseTrainingSheet(InhouseTrainingSheet inhouse_tr_sh);
	
	public boolean saveTraineeTrSheet(List<Trainee_Training_Sh_Lines> trainging_Master);
	
	public Training_Master getTrainingMaster(int tr_id);
	
	public Compentency_Master getCompentencyMaster(int comp_m_id);
	
	public List<Training_Master> getTrainee(int empid);
	
	public List<Training_Master> getTrainer(int empid);
	
	public List<Training_Master> getTrainingSheetGrid(int empid);
	
	public List<TraineeTrainingSheet> getInhouseTrSheetGrid(int empid);
	
	public List<Training_Master> getTrainingSheetADGrid(int adrid);
	
	public List<Training_Master> getTrainingSheetTrainerGrid(int trainerid);
	
	public List<Assessment> getAssessment(int empid);
	
	public List<Assessment_Lines> getAssessmentTaskList(int assid);
	
	public List<Training_Sheet_Lines> getTaskList(int trId);
	
	public List<Trainee_Training_Sh_Lines> getTaskListOfInhouse(int trId);
	
	public List<InhouseTrainingSheet> getInhouseRecords(int trId);
	
	public List<Training_Master> getTrainingSheetTraineeGrid(int traineeId);
	
	public List<Training_Sheet_Lines> getPlannedStartDate(int tr_id);
	
	public List<Training_Sheet_Lines> getPlannedEndDate(int tr_id);
	
	public int add_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines);
	
	public boolean save_Training_Sheet_Lines(List<Training_Sheet_Lines> training_sheet_lines);
	
	public int update_Training_Sheet_Lines(Training_Sheet_Lines training_sheet_lines);
	
	public int update_Training_Master(Training_Master training_master);
	
	public int insert_Mail_Communication(MailCommunication mailComm);
	
	public boolean saveTrainingRequestNotification(Training_Request_Notification notifications);
	
	public float calculateDeviation(Date planStartDate,Date planEndDate,Date actualStartDate,Date actualEndDate);
	
	public float calTotalDeviation(int trId,int trlinesid);
	
	public List<Training_Sheet_Lines> getCompletedTask(int trId);
	
	public List<Training_Sheet_Lines> getTaskListForDownload(int tr_id);
	
	public Functional_Reporting getFunctionalReporter(int empid);
	
	public List<Functional_Reporting> getFunctionalReporterList(int empid);
	
	public List<Training_Master> findPendingForApprovalTrainingsSheet(int empid);
	
	public List<Training_Master> findPendingTrainingListNotification(int empid);
	
	public List<Training_Master> getTrainingofParticularTrainee(String status,int userEmpCode,int traineeEmpCode);
	
	public List<TraineeTrainingSheet> getInhouseTrainingofParticularTrainee(String status,int userEmpCode,int traineeEmpCode);
	
	public SubCompentency getSubCompentency(int topic_id);
	
	public String getTrainingCode(String compgroup_ids[]);
	
	public RequestedTraining saveRequestedTraining(RequestedTraining reqTraining);
	
	public RequestedTraining updateRequestedTraining(RequestedTraining reqTraining);
	
	public List<Training_Master> findOngoingTrainingsSheetForTrainee(int empid);
	
	public List<TraineeTrainingSheet> findOngoingInhouseTrainingsSheetForTrainee(int empid);
	
	public Compentency_Group getCompentencyGroup(int comp_id);
	
	public List<TraineeTrainingSheet> findPendingInhouseTrainingsSheet(int empid);
	
}
