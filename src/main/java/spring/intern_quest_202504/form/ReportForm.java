package spring.intern_quest_202504.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReportForm {
	//TODO:バリデーション
	
	private LocalDateTime actualStart;
	
	private LocalDateTime actualFinish;
	
	private int restHour;
	private int restMin;
	
	private String content;
	
	

}
