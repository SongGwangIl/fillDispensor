package kr.ac.kopo.schedule.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScheduleVO {
	private String scheId;
	private String userId;
	private String scheTitle;
	private String scheSelect;
	private String scheStartDate;
	private String scheEndDate;
	private char scheDateExpires;
}