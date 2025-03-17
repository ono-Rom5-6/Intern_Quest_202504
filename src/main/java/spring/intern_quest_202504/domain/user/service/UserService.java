//ユーザーテーブル用
package spring.intern_quest_202504.domain.user.service;

import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.user.model.User;

@Service
public interface UserService {
	public User getLoginUser(String user);

}
