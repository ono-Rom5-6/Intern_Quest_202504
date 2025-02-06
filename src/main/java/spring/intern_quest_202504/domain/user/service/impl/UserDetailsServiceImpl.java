//ユーザーネームからユーザーを取得する
package spring.intern_quest_202504.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.intern_quest_202504.domain.user.model.LoginUserDetails;
import spring.intern_quest_202504.domain.user.model.User;
import spring.intern_quest_202504.domain.user.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserService service;
	
	@Transactional(readOnly = true)
	  @Override
	  public LoginUserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
	    assert(user != null);
	   
	    User loginUser = service.getLoginUser(user);       
	    return new LoginUserDetails(loginUser);
	  }
	

}
