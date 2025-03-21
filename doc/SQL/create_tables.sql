create database intern_quest_202504;

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY, -- ID
  user VARCHAR(30) NOT NULL,         -- ユーザー名
  pass VARCHAR(100) NOT NULL,        -- パスワード
  name VARCHAR(100) NOT NULL,        -- 名前
  department_id INT NOT NULL,        -- 部署ID
  section_id INT,                    -- 課ID
  role VARCHAR(30),                  -- 役職
  authority VARCHAR(30) NOT NULL     -- 管理者権限
);


CREATE TABLE department (
  id INT AUTO_INCREMENT PRIMARY KEY, -- ID
  name VARCHAR(30) NOT NULL          -- 部署名
);

CREATE TABLE section (
  section_id INT AUTO_INCREMENT PRIMARY KEY, -- ID
  section_name VARCHAR(30) NOT NULL,         -- 課名
  department_id INT NOT NULL
);

CREATE TABLE overtime (
  id INT AUTO_INCREMENT PRIMARY KEY,           -- ID
  user_id INT NOT NULL,                        -- ユーザーID(申請者)
  department_id INT NOT NULL,                  -- 部署ID
  section_id INT,                              -- 課ID
  main_pattern VARCHAR(20) NOT NULL,           -- 勤務パターン
  sub_pattern VARCHAR(20) NOT NULL,            -- 勤務パターン
  schedule_start DATETIME,                     -- 残業予定時間(開始時刻)
  schedule_finish DATETIME,                    -- 残業予定時間(終了時刻)
  reason VARCHAR(1000),                        -- 残業理由
  state TINYINT NOT NULL DEFAULT 0,            -- 状態 (0:未承認、1:却下、2:差し戻し)
  approve_date DATETIME,                       -- 承認日
  approve_name VARCHAR(100),                   -- 承認者
  actual_start DATETIME,                       -- 実残業時間(開始時刻)
  actual_finish DATETIME,                      -- 実残業時間(終了時刻)
  rest_second INT,                             -- 休憩時間
  content VARCHAR(1000),                       -- 残業報告
  apply_date DATETIME,                         -- 申請日

  weekday_daytime_second INT,                   -- 残業時間（~21:19）
  weekday_not_daytime_second INT,               -- 残業時間（22:00~）
  holiday_daytime_second INT,                   -- 残業時間（~21:19）
  holiday_not_daytime_second INT,               -- 残業時間（22:00~）
  

  combine_id INT,                              -- とりまとめID
  is_deleted TINYINT NOT NULL DEFAULT 0,       -- 削除フラグ (0:未削除、1:削除)
  create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP -- 作成日
);

CREATE TABLE combine (
  id INT AUTO_INCREMENT PRIMARY KEY, -- ID
  create_user INT NOT NULL,          -- 作成ユーザー
  section_id INT NOT NULL            -- 課ID
);
