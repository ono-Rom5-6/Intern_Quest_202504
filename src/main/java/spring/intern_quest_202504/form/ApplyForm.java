package spring.intern_quest_202504.form;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApplyForm {
	
	//private Integer userId;

	@NotBlank
	private String mainPattern;
	@NotBlank
	private String subPattern;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime scheduleStart;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime scheduleFinish;
	
	@NotBlank
	@Size(max = 1000)
	private String reason;
}

