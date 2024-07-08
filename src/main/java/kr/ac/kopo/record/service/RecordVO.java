package kr.ac.kopo.record.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecordVO {
	
	private String takeId;
	private String userId;
	private String timeId;
	private Date takeDate;
	private char takeSuccess;
	
}
