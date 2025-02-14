package spring.intern_quest_202504.domain.overtime.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class Overtime {
	private String id;
	private String userId;
	private String workPattern;
	private LocalDateTime scheduleStart;
	private LocalDateTime scheduleFinish;
	private String reason;
	private int state;
	private Date approveDate;
	private String approveName;
	
	private LocalDateTime actualStart;
	private LocalDateTime actualFinish;
	private int restSeconds;
	private String content;
	private Date applyDate;
	private int workedSecondsNomal;
	private int workedSecondsNight;
	private int isHoliday;
	private int isCombined;
	private int isDeleted;
	private LocalDateTime createDate;

}
/*
id INT AUTO_INCREMENT PRIMARY KEY,           -- ID
  user_id INT NOT NULL,                        -- ユーザーID(申請者)
  work_pattern VARCHAR(5) NOT NULL,            -- 勤務パターン
  schedule_start DATETIME,                     -- 残業予定時間(開始時刻)
  schedule_finish DATETIME,                    -- 残業予定時間(終了時刻)
  reason VARCHAR(1000),                        -- 残業理由
  state TINYINT NOT NULL DEFAULT 0,            -- 状態 (0:未承認、1:却下、2:差し戻し)
  approve_date DATE,                           -- 承認日
  approve_name VARCHAR(100)                    -- 承認者
  
  actual_start DATETIME,                       -- 実残業時間(開始時刻)
  actual_finish DATETIME,                      -- 実残業時間(終了時刻)
  rest_seconds INT,                            -- 休憩時間
  content VARCHAR(1000),                       -- 残業報告
  apply_date DATE,                             -- 申請日
  worked_seconds_normal INT,                   -- 残業時間（~21:19）
  worked_seconds_night INT,                    -- 残業時間（22:00~）
  is_holiday TINYINT NOT NULL DEFAULT 0,       -- 休日フラグ (0:平日、1:休日出勤)
  is_combined TINYINT NOT NULL DEFAULT 0,      -- とりまとめフラグ (0:とりまとめ前、1:とりまとめ済)
  is_deleted TINYINT NOT NULL DEFAULT 0,       -- 削除フラグ (0:未削除、1:削除)
  create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP -- 作成日
*/