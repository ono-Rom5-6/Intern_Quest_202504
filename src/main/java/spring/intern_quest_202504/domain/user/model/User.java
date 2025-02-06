package spring.intern_quest_202504.domain.user.model;

import lombok.Data;

@Data
public class User {
	private String id;
	private String user;
	private String pass;
	private String name;
	private String department_id;
	private String role;
	private String authority;
}
