package kr.ac.kopo.schedule.service;

import java.util.Date;

public class ScheduleVO {
	private String scheId;
	private String userId;
	private String scheTitle;
	private String scheSelect;
	private Date scheStartDate;
	private Date scheEndDate;
//	private boolean scheDateExpires;
	
	public String getScheId() {
		return scheId;
	}
	public void setScheId(String scheId) {
		this.scheId = scheId;
	}
	public String getScheTitle() {
		return scheTitle;
	}
	public void setScheTitle(String scheTitle) {
		this.scheTitle = scheTitle;
	}
	public String getScheSelect() {
		return scheSelect;
	}
	public void setScheSelect(String scheSelect) {
		this.scheSelect = scheSelect;
	}
	public String getScheNo() {
		return scheId;
	}
	public void setScheNo(String scheId) {
		this.scheId = scheId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMedName() {
		return scheTitle;
	}
	public void setMedName(String scheTitle) {
		this.scheTitle = scheTitle;
	}
	public Date getScheStartDate() {
		return scheStartDate;
	}
	public void setScheStartDate(Date scheStartDate) {
		this.scheStartDate = scheStartDate;
	}
	public Date getScheEndDate() {
		return scheEndDate;
	}
	public void setScheEndDate(Date scheEndDate) {
		this.scheEndDate = scheEndDate;
	}
}
