package kr.ac.kopo.schedule.service;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScheTimeVO {

	private String timeId;
	private String scheId;
	private LocalTime timeArlam;
	private LocalTime timeLimit;
	private int rearlamCount;
	private int rearlamTime;
	private char medLocation;
}
