INSERT INTO department (id, name) VALUES 
  (1, '総務部'),
  (2, '営業部'),
  (3, '開発部'),
  (4, '人事部'),
  (5, '経理部')
  ;

INSERT INTO user (id, user, pass, name, department_id, role, authority) VALUES 
  (1, 'test1', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', -- パスワードは thisIsTest 以下共通
  '田中 太郎', 2, '平社員', 'user'),
  (2, 'test2', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '山田 花子', 2, '平社員', 'user'),
  (3, 'test3', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '鈴木 次郎', 2, '次長', 'deputyManager'),
  (4, 'test4', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '佐藤 三郎', 2, '課長', 'sectionManager'),
  (5, 'test5', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '小林 由美', 2, '部長', 'generalManager'),

  (6, 'test6', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '山本 一郎', 3, '平社員', 'user'),
  (7, 'test7', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '藤田 美咲', 3, '平社員', 'user'),
  (8, 'test8', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '高橋 健', 3, '次長', 'deputyManager'),
  (9, 'test9', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '石川 理恵', 3, '課長', 'sectionManager'),
  (10, 'test10', '$2a$10$o0LPTuahmqkh5BS.4xpcqecDb8bDcjnErK0zUlh0HUtouVvOYxcF2', '加藤 翔太', 3, '部長', 'generalManager')
  ;

insert into overtime(
			user_id,
			department_id,
			main_pattern,
			sub_pattern,
			schedule_start,
			schedule_finish,
			reason,
            state,
            approve_date,
			approve_name,
			combine_id
		)
		values(
			1,
			2,
			'early',
			'A',
			'2025-03-06 13:58:00',
			'2025-03-06 14:58:00',
			'月次処理テスト(営業部)',
            1,
            curdate() - interval 1 month,
			'佐藤 三郎',
			1
		),
        (
			2,
			2,
			'early',
			'A',
			'2025-03-06 13:58:00',
			'2025-03-06 14:58:00',
			'月次処理テスト(営業部)',
            1,
            curdate() - interval 1 month,
			'佐藤 三郎',
			1
		),
        (
			3,
			2,
			'early',
			'A',
			'2025-03-06 13:58:00',
			'2025-03-06 14:58:00',
			'月次処理テスト(営業部)',
            1,
            curdate() - interval 1 month,
			'佐藤 三郎',
			1
		),
        (
			3,
			2,
			'early',
			'A',
			'2025-03-06 13:58:00',
			'2025-03-06 14:58:00',
			'月次処理テスト(営業部)',
            1,
            curdate() - interval 1 month,
			'佐藤 三郎',
			1
		),
        (
			4,
			2,
			'early',
			'A',
			'2025-02-06 13:58:00',
			'2025-02-06 14:58:00',
			'月次処理テスト(営業部)',
            1,
            curdate() - interval 1 month,
			'佐藤 三郎',
			1
		)
		;



