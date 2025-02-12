package spring.intern_quest_202504.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApplyForm {
	@NotNull
	private Integer userId;

	@Size(max = 5)
	private String workPattern;

	private LocalDateTime scheduleStart;
	private LocalDateTime scheduleFinish;

	@Size(max = 1000)
	private String reason;
	
	
/*
	@Size(min = 0, max = 2)
	private Integer state; // 0:未承認、1:却下、2:差し戻し

	private LocalDate approveDate;
	private Date actualStart;
	private Date actualFinish;
	private Integer restSeconds;
	private String content;
	private Date applyDate;
	private Integer workedSecondsNormal;
	private Integer workedSecondsNight;

	@NotNull
	private Integer isHoliday;

	@NotNull
	private Integer isCombined;

	@NotNull
	private Integer isDeleted;

	private Date createDate;
	*/

}
/*
package com.example.model;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Date;

public class OvertimeForm {

    @NotNull(message = "{overtimeForm.userId.NotNull}")
    private Integer userId;

    @Size(max = 5, message = "{overtimeForm.workPattern.Size}")
    private String workPattern;

    private LocalDateTime scheduleStart;
    private LocalDateTime scheduleFinish;

    @Size(max = 1000, message = "{overtimeForm.reason.Size}")
    private String reason;

    @Min(value = 0, message = "{overtimeForm.state.Min}")
    @Max(value = 2, message = "{overtimeForm.state.Max}")
    private Integer state = 0;  // 0:未承認、1:却下、2:差し戻し

    private LocalDate approveDate;
    private LocalDateTime actualStart;
    private LocalDateTime actualFinish;
    private Integer restSeconds;
    private String content;
    private LocalDate applyDate;
    private Integer workedSecondsNormal;
    private Integer workedSecondsNight;

    @NotNull(message = "{overtimeForm.isHoliday.NotNull}")
    private Integer isHoliday = 0;

    @NotNull(message = "{overtimeForm.isCombined.NotNull}")
    private Integer isCombined = 0;

    @NotNull(message = "{overtimeForm.isDeleted.NotNull}")
    private Integer isDeleted = 0;

    private LocalDateTime createDate;

    // GetterとSetterをここに追加
}*/
