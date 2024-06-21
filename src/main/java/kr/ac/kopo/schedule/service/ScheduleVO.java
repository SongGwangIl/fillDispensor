package kr.ac.kopo.schedule.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScheduleVO {
	private String scheId;
	private String userId;
	private String scheTitle;
	private String scheSelect;
	private LocalDate scheStartDate;
	private LocalDate scheEndDate;
	private char scheDateExpires;
	

}