//ログイン処理、パスワード変更処理
package spring.intern_quest_202504.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.intern_quest_202504.domain.user.model.User;
import spring.intern_quest_202504.domain.user.service.UserService;
import spring.intern_quest_202504.repository.UserMapper;

@Service
public class UserServiceImpl  implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getLoginUser(String user) {
		return userMapper.findLoginUser(user);
	}

}
