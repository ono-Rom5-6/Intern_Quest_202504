//報告フォーム
package spring.intern_quest_202504.form;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReportForm {
	@NotNull
	private String id;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime actualStart;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime actualFinish;
	
	@Range(min = 0)
	private int restHour;
	@Range(min = 0, max = 59)
	private int restMin;
	
	@NotBlank
	@Size(max = 1000)
	private String content;
	
	
	
	

}
