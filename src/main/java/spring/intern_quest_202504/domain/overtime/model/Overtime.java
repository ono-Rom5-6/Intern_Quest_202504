//残業テーブル用
package spring.intern_quest_202504.domain.overtime.model;

import java.time.LocalDateTime;

import lombok.Data;
import spring.intern_quest_202504.domain.combine.model.Combine;
import spring.intern_quest_202504.domain.department.model.Department;
import spring.intern_quest_202504.domain.user.model.User;

@Data
public class Overtime {
	private String id;
	private String userId;
	private String departmentId;
	private String mainPattern;
	private String subPattern;
	private LocalDateTime scheduleStart;
	private LocalDateTime scheduleFinish;
	private String reason;
	private int state;
	private LocalDateTime approveDate;
	private String approveName;
	
	private LocalDateTime actualStart;
	private LocalDateTime actualFinish;
	private int restSecond;
	private String content;
	private LocalDateTime applyDate;
	private int weekdayDaytimeSecond;
	private int weekdayNotDaytimeSecond;
	private int holidayDaytimeSecond;
	private int holidaydayNotDaytimeSecond;
	private String combineId;
	private int isDeleted;
	private LocalDateTime createDate;
	
	private Department department;
	private User user;
	private Combine combine;
	
	/*
	private String userName;
	private String departmentName;
	*/

}
/*
id INT AUTO_INCREMENT PRIMARY KEY,           -- ID
  user_id INT NOT NULL,                        -- ユーザーID(申請者)
  work_pattern VARCHAR(5) NOT NULL,            -- 勤務パターン
  schedule_start DATETIME,                     -- 残業予定時間(開始時刻)
  schedule_finish DATETIME,                    -- 残業予定時間(終了時刻)
  reason VARCHAR(1000),                        -- 残業理由
  state TINYINT NOT NULL DEFAULT 0,            -- 状態 (0:未承認、1:承認, 2:却下、3:差し戻し)
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