package com.omfysgroup.ajanhcm.model;

public class LateEarlyEvents {
	
	private int total_events;
	
	private int approved_count;
	
	//attendance Dashbord Count
	
	private double presentcount;
	
	private double absentcount;
	
	private int earlygoingcount;
	
	private int latecomingcount;
	
	private double leave_count_approved;
	
	private double leave_count_rejected;
	
	private double leves_count_Pending_approval;
	
	private double leave_count_total_applied;
	
	private double leave_count_pl;
	
	private double leave_count_cl;
	
	private double leave_count_lwp;
	
	private double leave_count_od;
	
	private double utilizedCl;
	
	private double utilizedPl;
	
	//Leaves late Coming early going  deduction Count
	
	private double lwpdeduction;
	
	private double pldeduction;
	
	private double cldeduction;
	
	private double totalleavedediction;
	
	private double totalPresentcount;
	
	private double totalAbsentcount;
	
	private double weeklyPresentCount;
	
	private double holidaysPresentCount;
	
	private int totalDays;

	public int getTotal_events() {
		return total_events;
	}

	public void setTotal_events(int total_events) {
		this.total_events = total_events;
	}

	public int getApproved_count() {
		return approved_count;
	}

	public void setApproved_count(int approved_count) {
		this.approved_count = approved_count;
	}

	public double getPresentcount() {
		return presentcount;
	}

	public void setPresentcount(double presentcount) {
		this.presentcount = presentcount;
	}

	public double getAbsentcount() {
		return absentcount;
	}

	public void setAbsentcount(double absentcount) {
		this.absentcount = absentcount;
	}

	public int getEarlygoingcount() {
		return earlygoingcount;
	}

	public void setEarlygoingcount(int earlygoingcount) {
		this.earlygoingcount = earlygoingcount;
	}

	public int getLatecomingcount() {
		return latecomingcount;
	}

	public void setLatecomingcount(int latecomingcount) {
		this.latecomingcount = latecomingcount;
	}

	public double getLeave_count_approved() {
		return leave_count_approved;
	}

	public void setLeave_count_approved(double leave_count_approved) {
		this.leave_count_approved = leave_count_approved;
	}

	public double getLeave_count_rejected() {
		return leave_count_rejected;
	}

	public void setLeave_count_rejected(double leave_count_rejected) {
		this.leave_count_rejected = leave_count_rejected;
	}

	public double getLeves_count_Pending_approval() {
		return leves_count_Pending_approval;
	}

	public void setLeves_count_Pending_approval(double leves_count_Pending_approval) {
		this.leves_count_Pending_approval = leves_count_Pending_approval;
	}

	public double getLeave_count_total_applied() {
		return leave_count_total_applied;
	}

	public void setLeave_count_total_applied(double leave_count_total_applied) {
		this.leave_count_total_applied = leave_count_total_applied;
	}

	public double getLeave_count_pl() {
		return leave_count_pl;
	}

	public void setLeave_count_pl(double leave_count_pl) {
		this.leave_count_pl = leave_count_pl;
	}

	public double getLeave_count_cl() {
		return leave_count_cl;
	}

	public void setLeave_count_cl(double leave_count_cl) {
		this.leave_count_cl = leave_count_cl;
	}

	public double getLeave_count_lwp() {
		return leave_count_lwp;
	}

	public void setLeave_count_lwp(double leave_count_lwp) {
		this.leave_count_lwp = leave_count_lwp;
	}

	public double getLeave_count_od() {
		return leave_count_od;
	}

	public void setLeave_count_od(double leave_count_od) {
		this.leave_count_od = leave_count_od;
	}

	public double getUtilizedCl() {
		return utilizedCl;
	}

	public void setUtilizedCl(double utilizedCl) {
		this.utilizedCl = utilizedCl;
	}

	public double getUtilizedPl() {
		return utilizedPl;
	}

	public void setUtilizedPl(double utilizedPl) {
		this.utilizedPl = utilizedPl;
	}

	public double getLwpdeduction() {
		return lwpdeduction;
	}

	public void setLwpdeduction(double lwpdeduction) {
		this.lwpdeduction = lwpdeduction;
	}

	public double getPldeduction() {
		return pldeduction;
	}

	public void setPldeduction(double pldeduction) {
		this.pldeduction = pldeduction;
	}

	public double getCldeduction() {
		return cldeduction;
	}

	public void setCldeduction(double cldeduction) {
		this.cldeduction = cldeduction;
	}

	public double getTotalleavedediction() {
		return totalleavedediction;
	}

	public void setTotalleavedediction(double totalleavedediction) {
		this.totalleavedediction = totalleavedediction;
	}

	public double getTotalPresentcount() {
		return totalPresentcount;
	}

	public void setTotalPresentcount(double totalPresentcount) {
		this.totalPresentcount = totalPresentcount;
	}

	public double getTotalAbsentcount() {
		return totalAbsentcount;
	}

	public void setTotalAbsentcount(double totalAbsentcount) {
		this.totalAbsentcount = totalAbsentcount;
	}

	public double getWeeklyPresentCount() {
		return weeklyPresentCount;
	}

	public void setWeeklyPresentCount(double weeklyPresentCount) {
		this.weeklyPresentCount = weeklyPresentCount;
	}

	public double getHolidaysPresentCount() {
		return holidaysPresentCount;
	}

	public void setHolidaysPresentCount(double holidaysPresentCount) {
		this.holidaysPresentCount = holidaysPresentCount;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	@Override
	public String toString() {
		return "LateEarlyEvents [total_events=" + total_events + ", approved_count=" + approved_count
				+ ", presentcount=" + presentcount + ", absentcount=" + absentcount + ", earlygoingcount="
				+ earlygoingcount + ", latecomingcount=" + latecomingcount + ", leave_count_approved="
				+ leave_count_approved + ", leave_count_rejected=" + leave_count_rejected
				+ ", leves_count_Pending_approval=" + leves_count_Pending_approval + ", leave_count_total_applied="
				+ leave_count_total_applied + ", leave_count_pl=" + leave_count_pl + ", leave_count_cl="
				+ leave_count_cl + ", leave_count_lwp=" + leave_count_lwp + ", leave_count_od=" + leave_count_od
				+ ", utilizedCl=" + utilizedCl + ", utilizedPl=" + utilizedPl + ", lwpdeduction=" + lwpdeduction
				+ ", pldeduction=" + pldeduction + ", cldeduction=" + cldeduction + ", totalleavedediction="
				+ totalleavedediction + ", totalPresentcount=" + totalPresentcount + ", totalAbsentcount="
				+ totalAbsentcount + ", weeklyPresentCount=" + weeklyPresentCount + ", holidaysPresentCount="
				+ holidaysPresentCount + ", totalDays=" + totalDays + "]";
	}
	
}
