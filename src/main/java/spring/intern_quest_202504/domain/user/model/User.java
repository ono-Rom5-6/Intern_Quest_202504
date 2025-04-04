//ユーザーテーブル用
package spring.intern_quest_202504.domain.user.model;

import lombok.Data;

@Data
public class User {
	private String id;
	private String user;
	private String pass;
	private String name;
	private String departmentId;
	private String sectionId;
	private String role;
	private String authority;
}
